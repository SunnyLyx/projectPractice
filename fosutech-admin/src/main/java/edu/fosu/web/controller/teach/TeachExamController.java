package edu.fosu.web.controller.teach;

import java.util.List;

import edu.fosu.common.utils.spring.SpringUtils;
import edu.fosu.framework.util.ShiroUtils;
import edu.fosu.system.service.ISysUserService;
import edu.fosu.teach.domain.TeachMajor;
import edu.fosu.teach.domain.TeachMajorStage;
import edu.fosu.teach.service.ITeachMajorService;
import edu.fosu.teach.service.ITeachMajorStageService;
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
import edu.fosu.teach.domain.TeachExam;
import edu.fosu.teach.service.ITeachExamService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 班级考试 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/teachExam")
public class TeachExamController extends BaseController
{
    private String prefix = "teach/teachExam";
	
	@Autowired
	private ITeachExamService teachExamService;

	@Autowired
	private ITeachMajorService teachMajorService;

	@Autowired
	private ITeachMajorStageService teachMajorStageService;

	@Autowired
	private TeachClassesController teachClassesController = SpringUtils.getBean(TeachClassesController.class);
	@Autowired
	private ISysUserService sysUserService;
	@RequiresPermissions("teach:teachExam:view")
	@GetMapping()
	public String teachExam(ModelMap mmap)
	{
		TeachMajor major = new TeachMajor();
		List<TeachMajor> list = teachMajorService.selectTeachMajorList(major);
		mmap.put("major", list);
	    return prefix + "/teachExam";
	}
	
	/**
	 * 查询班级考试列表
	 */
	@RequiresPermissions("teach:teachExam:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachExam teachExam)
	{
		String[] strs1 =teachClassesController.getClasses();
		teachExam.setClasses(strs1);
		startPage();
        List<TeachExam> list = teachExamService.selectTeachExamList(teachExam);
		return getDataTable(list);
	}

    /**
     * 根据分部查询
     * @param schoolId
     * @return
     */
    @PostMapping("/listById")
    @ResponseBody
    public TableDataInfo listById(Integer schoolId)
    {
        startPage();
        List<TeachExam> list = teachExamService.selectTeachExamListById(schoolId);
        return getDataTable(list);
    }

	/**
	 * 查询班级考试列表ByClassId
	 * 下拉框
	 */
	@RequiresPermissions("teach:teachExam:list")
	@PostMapping("/selectTeachExamByClassId")
	@ResponseBody
	public TableDataInfo selectTeachExamByClassId(TeachExam teachExam)
	{
		startPage();
		List<TeachExam> list = teachExamService.selectTeachExamByClassId(teachExam);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出班级考试列表
	 */
	@RequiresPermissions("teach:teachExam:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachExam teachExam)
    {
    	List<TeachExam> list = teachExamService.selectTeachExamList(teachExam);
        ExcelUtil<TeachExam> util = new ExcelUtil<TeachExam>(TeachExam.class);
        return util.exportExcel(list, "teachExam");
    }
	
	/**
	 * 新增班级考试
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
	 * 新增保存班级考试
	 */
	@RequiresPermissions("teach:teachExam:add")
	@Log(title = "班级考试", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachExam teachExam)
	{		
		int a = teachExamService.insertTeachExam(teachExam);
		/*if(a == -1){
			AjaxResult ajaxResult = new AjaxResult();
			ajaxResult.put("code", 1);
			ajaxResult.put("msg", "该班该阶段已添加过考试记录");
			return ajaxResult;
		}
		if (a == -2){
			AjaxResult ajaxResult = new AjaxResult();
			ajaxResult.put("code", 1);
			ajaxResult.put("msg", "只能添加当日或昨日的考试记录");
			return ajaxResult;
		}else {*/
			return toAjax(a);
		//}
	}

	/**
	 * 修改班级考试
	 */
	@GetMapping("/edit/{examId}")
	public String edit(@PathVariable("examId") Integer examId, ModelMap mmap)
	{
		TeachExam teachExam = teachExamService.selectTeachExamById(examId);
		mmap.put("teachExam", teachExam);

		TeachMajorStage teachMajorStage = new TeachMajorStage();
		List<TeachMajorStage> list = teachMajorStageService.selectTeachMajorStageList(teachMajorStage);
		mmap.put("list", list);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存班级考试
	 */
	@RequiresPermissions("teach:teachExam:edit")
	@Log(title = "班级考试", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachExam teachExam)
	{		
		return toAjax(teachExamService.updateTeachExam(teachExam));
	}
	
	/**
	 * 删除班级考试
	 */
	@RequiresPermissions("teach:teachExam:remove")
	@Log(title = "班级考试", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teachExamService.deleteTeachExamByIds(ids));
	}

	/**
	 * 班级考试详情
	 */
	@RequiresPermissions("teach:teachExam:detail")
	@GetMapping("/detail/{examId}")
	public String detail(@PathVariable("examId") Integer examId, ModelMap mmap)
	{
		TeachExam teachExam = teachExamService.selectTeachExamById(examId);
		mmap.put("teachExam", teachExam);

		TeachMajorStage teachMajorStage = new TeachMajorStage();
		List<TeachMajorStage> list = teachMajorStageService.selectTeachMajorStageList(teachMajorStage);
		mmap.put("list", list);
		return prefix + "/detail";
	}
	
}
