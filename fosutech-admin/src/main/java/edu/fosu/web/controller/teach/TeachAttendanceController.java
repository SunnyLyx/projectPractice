package edu.fosu.web.controller.teach;

import java.util.List;
import java.util.Map;

import edu.fosu.common.utils.spring.SpringUtils;
import edu.fosu.framework.util.ShiroUtils;
import edu.fosu.system.service.ISysUserService;
import edu.fosu.teach.domain.TeachMajor;
import edu.fosu.teach.domain.TeachStudentAttendance;
import edu.fosu.teach.service.ITeachClassesTeacherService;
import edu.fosu.teach.service.ITeachMajorService;
import edu.fosu.teach.service.ITeachStudentAttendanceService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import edu.fosu.common.annotation.Log;
import edu.fosu.common.enums.BusinessType;
import edu.fosu.teach.domain.TeachAttendance;
import edu.fosu.teach.service.ITeachAttendanceService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * 班级考勤 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/teachAttendance")
public class TeachAttendanceController extends BaseController
{
    private String prefix = "teach/teachAttendance";
	
	@Autowired
	private ITeachAttendanceService teachAttendanceService;

	@Autowired
	private ITeachClassesTeacherService teachClassesTeacherService;

	@Autowired
	private ITeachStudentAttendanceService teachStudentAttendanceService;

	@Autowired
	private TeachClassesController teachClassesController = SpringUtils.getBean(TeachClassesController.class);

	@Autowired
	private ISysUserService sysUserService;

	@Autowired
	private ITeachMajorService teachMajorService;
	
	@RequiresPermissions("teach:teachAttendance:view")
	@GetMapping()
	public String teachAttendance(ModelMap mmap)
	{
		TeachMajor major = new TeachMajor();
		List<TeachMajor> list2 = teachMajorService.selectTeachMajorList(major);
		mmap.put("major", list2);
		return prefix + "/teachAttendance";
	}
	
	/**
	 * 查询班级考勤列表
	 */
	@RequiresPermissions("teach:teachAttendance:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachAttendance teachAttendance)
	{
		String[] strs1 =teachClassesController.getClasses();
		teachAttendance.setClasses(strs1);
		startPage();
        List<TeachAttendance> list = teachAttendanceService.selectTeachAttendanceList(teachAttendance);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出班级考勤列表
	 */
	@RequiresPermissions("teach:teachAttendance:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachAttendance teachAttendance)
    {
    	List<TeachAttendance> list = teachAttendanceService.selectTeachAttendanceList(teachAttendance);
        ExcelUtil<TeachAttendance> util = new ExcelUtil<TeachAttendance>(TeachAttendance.class);
        return util.exportExcel(list, "teachAttendance");
    }
	
	/**
	 * 新增班级考勤
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		int userno = ShiroUtils.getUserId().intValue();
		String roleNo = sysUserService.selectUserRoleGroup2(new Long((long)userno));
		if("9".equals(roleNo) || "1".equals(roleNo) || "11".equals(roleNo) || "8".equals(roleNo)){
			mmap.put("quanxian",0);
		}else {
			mmap.put("quanxian",1);
		}

		return prefix + "/add";
	}
	
	/**
	 * 新增保存班级考勤
	 */
	@RequiresPermissions("teach:teachAttendance:add")
	@Log(title = "班级考勤", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachAttendance teachAttendance)
	{
		int a = teachAttendanceService.insertTeachAttendance(teachAttendance);
		if(a == -1){
			AjaxResult ajaxResult = new AjaxResult();
			ajaxResult.put("code", 1);
			ajaxResult.put("msg", "今日已为该班该课程添加过考勤");
			return ajaxResult;
		}
		if(a == -2){
			AjaxResult ajaxResult = new AjaxResult();
			ajaxResult.put("code", 1);
			ajaxResult.put("msg", "只能添加当日或昨日的考勤记录");
			return ajaxResult;
		}else {
			return toAjax(a);
		}
	}

	/**
	 * 修改班级考勤
	 */
	@GetMapping("/edit/{attendanceId}")
	public String edit(@PathVariable("attendanceId") Integer attendanceId, ModelMap mmap)
	{
		TeachAttendance teachAttendance = teachAttendanceService.selectTeachAttendanceById(attendanceId);
		mmap.put("teachAttendance", teachAttendance);
		List<Map<String,Object>> list = teachClassesTeacherService.selectByClassId(teachAttendance.getClassId()) ;
		mmap.put("teacherList",list);
		TeachStudentAttendance teachStudentAttendance = new TeachStudentAttendance();
		teachStudentAttendance.setAttendanceId(attendanceId);
		List<TeachStudentAttendance> list2 = teachStudentAttendanceService.selectTeachStudentAttendanceList(teachStudentAttendance);
		mmap.put("studentList",list2);
	    return prefix + "/edit";
	}

	/**
	 * 班级考勤详情
	 */
	@RequiresPermissions("teach:teachAttendance:detail")
	@GetMapping("/detail/{attendanceId}")
	public String detail(@PathVariable("attendanceId") Integer attendanceId, ModelMap mmap)
	{
		TeachAttendance teachAttendance = teachAttendanceService.selectTeachAttendanceById(attendanceId);
		mmap.put("teachAttendance", teachAttendance);
		List<Map<String,Object>> list = teachClassesTeacherService.selectByClassId(teachAttendance.getClassId()) ;
		mmap.put("teacherList",list);
		TeachStudentAttendance teachStudentAttendance = new TeachStudentAttendance();
		teachStudentAttendance.setAttendanceId(attendanceId);
		List<TeachStudentAttendance> list2 = teachStudentAttendanceService.selectTeachStudentAttendanceList(teachStudentAttendance);
		mmap.put("studentList",list2);
		return prefix + "/detail";
	}
	
	/**
	 * 修改保存班级考勤
	 */
	@RequiresPermissions("teach:teachAttendance:edit")
	@Log(title = "班级考勤", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachAttendance teachAttendance)
	{
		return toAjax(teachAttendanceService.updateTeachAttendance(teachAttendance));
	}
	
	/**
	 * 删除班级考勤
	 */
	@RequiresPermissions("teach:teachAttendance:remove")
	@Log(title = "班级考勤", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teachAttendanceService.deleteTeachAttendanceByIds(ids));
	}
	
}
