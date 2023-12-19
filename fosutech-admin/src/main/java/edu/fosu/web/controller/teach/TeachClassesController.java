package edu.fosu.web.controller.teach;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.fosu.common.utils.spring.SpringUtils;
import edu.fosu.framework.util.ShiroUtils;
import edu.fosu.system.service.ISysUserService;
import edu.fosu.teach.domain.*;
import edu.fosu.teach.service.*;
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
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 班级 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/teachClasses")
public class TeachClassesController extends BaseController
{
    private String prefix = "teach/teachClasses";
	
	@Autowired
	private ITeachClassesService teachClassesService;

	@Autowired
	private ITeachMajorService teachMajorService;

	@Autowired
	private ITeachMajorStageService teachMajorStageService;

	@Autowired
	private ITeachClassesTeacherService teachClassesTeacherService;

	@Autowired
	private ISysUserService sysUserService;

	@Autowired
	private IStudentService studentService;

	@RequiresPermissions("teach:teachClasses:view")
	@GetMapping()
	public String teachClasses(ModelMap mmap)
	{
		TeachMajor major = new TeachMajor();
		List<TeachMajor> list2 = teachMajorService.selectTeachMajorList(major);
		mmap.put("major", list2);
		int userno = ShiroUtils.getUserId().intValue();
		String roleNo = sysUserService.selectUserRoleGroup2(new Long((long)userno));
		if("5".equals(roleNo) || "6".equals(roleNo) || "7".equals(roleNo) || "8".equals(roleNo) || "11".equals(roleNo)){
			return prefix + "/teachClasses1";
		}else{
			return prefix + "/teachClasses";
		}
	}
	
	/**
	 * 查询班级列表
	 */
	@RequiresPermissions("teach:teachClasses:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachClasses teachClasses )
	{
		String[] strs1 =getClasses();
		teachClasses.setClasses(strs1);
		startPage();
		List<TeachClasses> list = teachClassesService.selectTeachClassesList(teachClasses);
		if(list.size() == 0){
			return getDataTable(list);
		}else {
			for (TeachClasses teachClasses2 : list) {
				int classId = teachClasses2.getClassId();
				int studentNum = studentService.selectStudentSum(classId);
				if (studentNum > 0) {
					List<Map> students = teachClassesService.selecttongji(classId);
					teachClasses2.setZaidu(Integer.valueOf(students.get(0).get("zaidu").toString()));
					teachClasses2.setTuixue(Integer.valueOf(students.get(0).get("tuixue").toString()));
					teachClasses2.setXiuxue(Integer.valueOf(students.get(0).get("xiuxue").toString()));
					teachClasses2.setXianshang(Integer.valueOf(students.get(0).get("xianshang").toString()));
					teachClasses2.setTiqianjiuye(Integer.valueOf(students.get(0).get("tiqianjiuye").toString()));
					teachClasses2.setLixiao(Integer.valueOf(students.get(0).get("lixiao").toString()));
					teachClasses2.setJieke(Integer.valueOf(students.get(0).get("jieke").toString()));
				} else {
					teachClasses2.setZaidu(0);
					teachClasses2.setTuixue(0);
					teachClasses2.setXiuxue(0);
					teachClasses2.setXianshang(0);
					teachClasses2.setTiqianjiuye(0);
					teachClasses2.setLixiao(0);
					teachClasses2.setJieke(0);
				}
			}
			return getDataTable(list);
		}
	}

	/**
	 * 查询班级列表
	 */
	@RequiresPermissions("teach:teachClasses:list")
	@PostMapping("/list1")
	@ResponseBody
	public TableDataInfo list1(TeachClasses teachClasses )
	{
		startPage();
		List<TeachClasses> list = teachClassesService.selectTeachClassesList(teachClasses);
		return getDataTable(list);
	}

	/**
	 * 返回班级数组数据
	 * @return
	 */
	String[] getClasses(){
		int userno = ShiroUtils.getUserId().intValue();
		String roleNo = sysUserService.selectUserRoleGroup2(new Long((long)userno));
		if("5".equals(roleNo)){
			TeachClassesTeacher teachClassesTeacher = new TeachClassesTeacher();
			teachClassesTeacher.setTeacherId(userno);
			List<String> listString = teachClassesTeacherService.selectTeachClasses(teachClassesTeacher);
			String[] strs1 = listString.toArray(new String[listString.size()]);
			if(strs1.length == 0){
				return new String[]{"0"};
			}
			return strs1;
		}
		if("6".equals(roleNo)){
			TeachClassesTeacher teachClassesTeacher = new TeachClassesTeacher();
			teachClassesTeacher.setInstructorId(userno);
			List<String> listString = teachClassesTeacherService.selectTeachClasses(teachClassesTeacher);
			String[] strs1 = listString.toArray(new String[listString.size()]);
			if(strs1.length == 0){
				return new String[]{"0"};
			}
			return strs1;
		}
		if("7".equals(roleNo)){
			TeachClassesTeacher teachClassesTeacher = new TeachClassesTeacher();
			teachClassesTeacher.setAssistantId(userno);
			List<String> listString = teachClassesTeacherService.selectTeachClasses(teachClassesTeacher);
			String[] strs1 = listString.toArray(new String[listString.size()]);
			if(strs1.length == 0){
				return new String[]{"0"};
			}
			return strs1;
		}
		if("11".equals(roleNo)){
			int deptId = ShiroUtils.getSysUser().getDeptId().intValue();
			List<String> listString = teachClassesService.selectClassesBySchoolId(deptId);
			String[] strs1 = listString.toArray(new String[listString.size()]);
			if(strs1.length == 0){
				return new String[]{"0"};
			}
			return strs1;
		}
		if ("8".equals(roleNo)){
			int deptId = ShiroUtils.getSysUser().getDeptId().intValue();
			List<String> listString = teachClassesService.selectClassesBySchoolId(deptId);
			String[] strs1 = listString.toArray(new String[listString.size()]);
			if(strs1.length == 0){
				return new String[]{"0"};
			}
			return strs1;
		}else {
			List<String> listString = teachClassesService.selectAllClasses();
			String[] strs1 = listString.toArray(new String[listString.size()]);
			if(strs1.length == 0){
				return new String[]{"0"};
			}
			return strs1;
		}
	}


	/**
	 * 查询班级列表
	 */
	@PostMapping("/listBySchoolId")
	@ResponseBody
	public TableDataInfo listBySchoolId(TeachClasses teachClasses)
	{
		startPage();
		List<TeachClasses> list = teachClassesService.selectTeachClassesList(teachClasses);
		if(list.size() == 0){
			return getDataTable(list);
		}else {
			for (TeachClasses teachClasses2 : list) {
				int classId = teachClasses2.getClassId();
				int studentNum = studentService.selectStudentSum(classId);
				if (studentNum > 0) {
					List<Map> students = teachClassesService.selecttongji(classId);
					teachClasses2.setZaidu(Integer.valueOf(students.get(0).get("zaidu").toString()));
					teachClasses2.setTuixue(Integer.valueOf(students.get(0).get("tuixue").toString()));
					teachClasses2.setXiuxue(Integer.valueOf(students.get(0).get("xiuxue").toString()));
					teachClasses2.setXianshang(Integer.valueOf(students.get(0).get("xianshang").toString()));
					teachClasses2.setTiqianjiuye(Integer.valueOf(students.get(0).get("tiqianjiuye").toString()));
					teachClasses2.setLixiao(Integer.valueOf(students.get(0).get("lixiao").toString()));
				} else {
					teachClasses2.setZaidu(0);
					teachClasses2.setTuixue(0);
					teachClasses2.setXiuxue(0);
					teachClasses2.setXianshang(0);
					teachClasses2.setTiqianjiuye(0);
					teachClasses2.setLixiao(0);
				}
			}
			return getDataTable(list);
		}
	}
	
	
	/**
	 * 导出班级列表
	 */
	@RequiresPermissions("teach:teachClasses:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachClasses teachClasses)
    {
    	List<TeachClasses> list = teachClassesService.selectTeachClassesList(teachClasses);
        ExcelUtil<TeachClasses> util = new ExcelUtil<TeachClasses>(TeachClasses.class);
        return util.exportExcel(list, "teachClasses");
    }
	
	/**
	 * 新增班级
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		TeachMajor major = new TeachMajor();
		List<TeachMajor> list2 = teachMajorService.selectTeachMajorList(major);
		mmap.put("major", list2);
		return prefix + "/add";
	}
	
	/**
	 * 新增保存班级
	 */
	@RequiresPermissions("teach:teachClasses:add")
	@Log(title = "班级", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachClasses teachClasses) {
		int a = teachClassesService.insertTeachClasses(teachClasses);
		if(a == -1){
			AjaxResult ajaxResult = new AjaxResult();
			ajaxResult.put("code", 1);
			ajaxResult.put("msg", "班级名称已存在！");
			return ajaxResult;
		}else {
			return toAjax(a);
		}
	}

	/**
	 * 修改班级
	 */
	@GetMapping("/edit/{classId}")
	public String edit(@PathVariable("classId") Integer classId, ModelMap mmap)
	{
		TeachClasses teachClasses = teachClassesService.selectTeachClassesById(classId);
		mmap.put("teachClasses", teachClasses);

		TeachMajorStage teachMajorStage = new TeachMajorStage();
		teachMajorStage.setMajorId(teachClasses.getMajorId());
		List<TeachMajorStage> list = teachMajorStageService.selectTeachMajorStageList(teachMajorStage);
		mmap.put("list", list);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存班级
	 */
	@RequiresPermissions("teach:teachClasses:edit")
	@Log(title = "班级", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachClasses teachClasses)
	{
		return toAjax(teachClassesService.updateTeachClasses(teachClasses));
	}
	
	/**
	 * 删除班级
	 */
	@RequiresPermissions("teach:teachClasses:remove")
	@Log(title = "班级", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{
		int a  = teachClassesService.deleteTeachClassesByIds(ids);
		if(a == -1){
			AjaxResult ajaxResult = new AjaxResult();
			ajaxResult.put("code", 1);
			ajaxResult.put("msg", "该班级有学生，不可删除！");
			return ajaxResult;
		}else {
			return toAjax(a);
		}
	}

	/**
	 * 班级结课
	 */
	@RequiresPermissions("teach:teachClasses:change")
	@PostMapping( "/change")
	@ResponseBody
	public AjaxResult change(String ids) { return toAjax(teachClassesService.changeTeachClassesByIds(ids)); }

	/**
	 * 选择list
	 */
	@GetMapping("/selectList")
	public String selectList(ModelMap mmap)
	{
		TeachClasses teachClass = new TeachClasses();
		List<TeachClasses> classes = teachClassesService.selectTeachClassesList(teachClass);
		mmap.put("classes", classes);
		return prefix + "/list";
	}

	/**
	 * 根据班级编号查询该班级所属专业的所有阶段
	 */
	@PostMapping("/majorStage")
	@ResponseBody
	public TableDataInfo majorStage(TeachClasses teachClasses)
	{
		//startPage();
		List<TeachClasses> list = teachClassesService.selectTeachClassesList(teachClasses);
		Integer major_id = list.get(0).getMajorId();
		TeachMajorStage teachMajorStage = new TeachMajorStage();
		teachMajorStage.setMajorId(major_id);
		List<TeachMajorStage> list1 = teachMajorStageService.selectTeachMajorStageList(teachMajorStage);
		return getDataTable(list1);
	}

	/**
	 * 查看班级详情
	 */
	@RequiresPermissions("teach:teachClasses:detail")
	@GetMapping("/detail/{classId}")
	public String detail(@PathVariable("classId") Integer classId, ModelMap mmap)
	{
		TeachClasses teachClasses = teachClassesService.selectTeachClassesById(classId);
		mmap.put("teachClasses", teachClasses);

		TeachMajorStage teachMajorStage = new TeachMajorStage();
		teachMajorStage.setMajorId(teachClasses.getMajorId());
		List<TeachMajorStage> list = teachMajorStageService.selectTeachMajorStageList(teachMajorStage);
		mmap.put("list", list);
		return prefix + "/detail";
	}

	/**
	 * 班级连接状态修改
	 */
	@Log(title = "班级管理", businessType = BusinessType.UPDATE)
	@RequiresPermissions("teach:teachClasses:edit")
	@PostMapping("/changeStatus")
	@ResponseBody
	public AjaxResult changeStatus(TeachClasses teachClasses)
	{
		return toAjax(teachClassesService.changeStatus(teachClasses));
	}
}
