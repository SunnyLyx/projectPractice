package edu.fosu.web.controller.teach;

import java.util.List;

import edu.fosu.common.utils.spring.SpringUtils;
import edu.fosu.framework.util.ShiroUtils;
import edu.fosu.system.service.ISysUserService;
import edu.fosu.teach.domain.TeachMajor;
import edu.fosu.teach.domain.TeachStudentJob;
import edu.fosu.teach.service.ITeachMajorService;
import edu.fosu.teach.service.ITeachStudentJobService;
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
import edu.fosu.teach.domain.TeachJob;
import edu.fosu.teach.service.ITeachJobService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 班级作业 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/teachJob")
public class TeachJobController extends BaseController
{
    private String prefix = "teach/teachJob";
	
	@Autowired
	private ITeachJobService teachJobService;

	@Autowired
	private ITeachStudentJobService teachStudentJobService;

	@Autowired
	private TeachClassesController teachClassesController = SpringUtils.getBean(TeachClassesController.class);
	@Autowired
	private ISysUserService sysUserService;
	@Autowired
	private ITeachMajorService teachMajorService;

	@RequiresPermissions("teach:teachJob:view")
	@GetMapping()
	public String teachJob(ModelMap mmap)
	{
		TeachMajor major = new TeachMajor();
		List<TeachMajor> list2 = teachMajorService.selectTeachMajorList(major);
		mmap.put("major", list2);
		return prefix + "/teachJob";
	}
	
	/**
	 * 查询班级作业列表
	 */
	@RequiresPermissions("teach:teachJob:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachJob teachJob)
	{
		String[] strs1 =teachClassesController.getClasses();
		teachJob.setClasses(strs1);
		startPage();
        List<TeachJob> list = teachJobService.selectTeachJobList(teachJob);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出班级作业列表
	 */
	@RequiresPermissions("teach:teachJob:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachJob teachJob)
    {
    	List<TeachJob> list = teachJobService.selectTeachJobList(teachJob);
        ExcelUtil<TeachJob> util = new ExcelUtil<TeachJob>(TeachJob.class);
        return util.exportExcel(list, "teachJob");
    }
	
	/**
	 * 新增班级作业
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
	 * 新增保存班级作业
	 */
	@RequiresPermissions("teach:teachJob:add")
	@Log(title = "班级作业", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachJob teachJob)
	{		
		int a = teachJobService.insertTeachJob(teachJob);
		if (a == -2){
			AjaxResult ajaxResult = new AjaxResult();
			ajaxResult.put("code", 1);
			ajaxResult.put("msg", "只能添加当日或昨日的作业记录");
			return ajaxResult;
		}else {
		return toAjax(a);
		}
	}

	/**
	 * 修改班级作业
	 */
	@GetMapping("/edit/{jobId}")
	public String edit(@PathVariable("jobId") Integer jobId, ModelMap mmap)
	{
		TeachJob teachJob = teachJobService.selectTeachJobById(jobId);
		mmap.put("teachJob", teachJob);

		/*TeachStudentJob teachStudentJob = new TeachStudentJob();
		teachStudentJob.setJobId(jobId);
		List<TeachStudentJob> list2 = teachStudentJobService.selectTeachStudentJobList(teachStudentJob);
		mmap.put("studentList",list2);*/

	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存班级作业
	 */
	@RequiresPermissions("teach:teachJob:edit")
	@Log(title = "班级作业", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachJob teachJob)
	{		
		return toAjax(teachJobService.updateTeachJob(teachJob));
	}
	
	/**
	 * 删除班级作业
	 */
	@RequiresPermissions("teach:teachJob:remove")
	@Log(title = "班级作业", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teachJobService.deleteTeachJobByIds(ids));
	}

	/**
	 * 班级项目详情
	 */
	@RequiresPermissions("teach:teachJob:detail")
	@GetMapping("/detail/{jobId}")
	public String detail(@PathVariable("jobId") Integer jobId, ModelMap mmap)
	{
		TeachJob teachJob = teachJobService.selectTeachJobById(jobId);
		mmap.put("teachJob", teachJob);
		return prefix + "/detail";
	}
	
}
