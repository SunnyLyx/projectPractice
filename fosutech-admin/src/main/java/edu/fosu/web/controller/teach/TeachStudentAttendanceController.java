package edu.fosu.web.controller.teach;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import edu.fosu.common.annotation.Log;
import edu.fosu.common.enums.BusinessType;
import edu.fosu.teach.domain.TeachStudentAttendance;
import edu.fosu.teach.service.ITeachStudentAttendanceService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 学生考勤 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/teachStudentAttendance")
public class  TeachStudentAttendanceController extends BaseController
{
    private String prefix = "teach/teachStudentAttendance";
	
	@Autowired
	private ITeachStudentAttendanceService teachStudentAttendanceService;
	
	@RequiresPermissions("teach:teachStudentAttendance:view")
	@GetMapping()
	public String teachStudentAttendance()
	{
	    return prefix + "/teachStudentAttendance";
	}
	
	/**
	 * 查询学生考勤列表
	 */
	@RequiresPermissions("teach:teachStudentAttendance:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachStudentAttendance teachStudentAttendance)
	{
		startPage();
        List<TeachStudentAttendance> list = teachStudentAttendanceService.selectTeachStudentAttendanceList(teachStudentAttendance);
		return getDataTable(list);
	}

	/**
	 * 查询学生考勤
	 *
	 * @param teachStudentAttendance 学生ID
	 * @return 学生考勤
	 */
	@RequiresPermissions("teach:teachStudentAttendance:list")
	@PostMapping("/attendanceList")
	@ResponseBody
	public TableDataInfo selectTeachStudentAttendance(TeachStudentAttendance teachStudentAttendance){
		startPage();
		TeachStudentAttendance studentAttendances = new TeachStudentAttendance();
		List<TeachStudentAttendance> list = teachStudentAttendanceService.selectTeachStudentAttendance(teachStudentAttendance);
		int attendancenum = 0; //正常出勤人数
		int leavenum = 0; //请假人数
		int truancynum = 0; //旷课人数
		int latenum = 0; //迟到人数
		int leaveearlynum = 0; //早退人数
		for (TeachStudentAttendance studentAttendance:list) {
			Integer attendance = studentAttendance.getAttendance();
			if(attendance == 1){
				attendancenum += 1;
			}
			if(attendance == 2){
				leavenum += 1;
			}
			if(attendance == 3){
				truancynum += 1;
			}
			if(attendance == 4){
				latenum += 1;
			}
			if(attendance == 5){
				leaveearlynum += 1;
			}
		}
		Map map = new HashMap();
		map.put("leavenum",leavenum);
		map.put("truancynum",truancynum);
		map.put("latenum",latenum);
		map.put("leaveearlynum",leaveearlynum);
		String acceptability;
		Integer num = attendancenum + latenum;
		if(num == 0 || list.size() == 0 || list == null){
			acceptability = "0";
		}else{
			acceptability = String.format("%.0f", Double.valueOf(Double.valueOf(num)/Double.valueOf(list.size()))*100).concat("%");
		}
		map.put("acceptability",acceptability);
		studentAttendances.setStudentId(-1);
		studentAttendances.setParams(map);
		list.add(studentAttendances);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出学生考勤列表
	 */
	@RequiresPermissions("teach:teachStudentAttendance:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachStudentAttendance teachStudentAttendance)
    {
    	List<TeachStudentAttendance> list = teachStudentAttendanceService.selectTeachStudentAttendanceList(teachStudentAttendance);
        ExcelUtil<TeachStudentAttendance> util = new ExcelUtil<TeachStudentAttendance>(TeachStudentAttendance.class);
        return util.exportExcel(list, "teachStudentAttendance");
    }
	
	/**
	 * 新增学生考勤
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存学生考勤
	 */
	@RequiresPermissions("teach:teachStudentAttendance:add")
	@Log(title = "学生考勤", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachStudentAttendance teachStudentAttendance)
	{		
		return toAjax(teachStudentAttendanceService.insertTeachStudentAttendance(teachStudentAttendance));
	}

	/**
	 * 修改学生考勤
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		TeachStudentAttendance teachStudentAttendance = teachStudentAttendanceService.selectTeachStudentAttendanceById(id);
		mmap.put("teachStudentAttendance", teachStudentAttendance);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存学生考勤
	 */
	@RequiresPermissions("teach:teachStudentAttendance:edit")
	@Log(title = "学生考勤", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachStudentAttendance teachStudentAttendance)
	{		
		return toAjax(teachStudentAttendanceService.updateTeachStudentAttendance(teachStudentAttendance));
	}
	
	/**
	 * 删除学生考勤
	 */
	@RequiresPermissions("teach:teachStudentAttendance:remove")
	@Log(title = "学生考勤", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teachStudentAttendanceService.deleteTeachStudentAttendanceByIds(ids));
	}
	
}
