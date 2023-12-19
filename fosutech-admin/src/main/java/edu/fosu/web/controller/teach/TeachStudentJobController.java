package edu.fosu.web.controller.teach;

import java.util.List;
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
import edu.fosu.teach.domain.TeachStudentJob;
import edu.fosu.teach.service.ITeachStudentJobService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 学生作业 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/teachStudentJob")
public class TeachStudentJobController extends BaseController
{
    private String prefix = "teach/teachStudentJob";
	
	@Autowired
	private ITeachStudentJobService teachStudentJobService;
	
	@RequiresPermissions("teach:teachStudentJob:view")
	@GetMapping()
	public String teachStudentJob()
	{
	    return prefix + "/teachStudentJob";
	}
	
	/**
	 * 查询学生作业列表
	 */
	@RequiresPermissions("teach:teachStudentJob:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachStudentJob teachStudentJob)
	{
		startPage();
        List<TeachStudentJob> list = teachStudentJobService.selectTeachStudentJobList(teachStudentJob);
		return getDataTable(list);
	}

	/**
	 * 查询学生作业列表ById
	 */
	@RequiresPermissions("teach:teachStudentJob:list")
	@PostMapping("/listByStudentId")
	@ResponseBody
	public TableDataInfo listByStudentId(TeachStudentJob teachStudentJob)
	{
		startPage();
		List<TeachStudentJob> list = teachStudentJobService.selectTeachStudentJob(teachStudentJob);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出学生作业列表
	 */
	@RequiresPermissions("teach:teachStudentJob:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachStudentJob teachStudentJob)
    {
    	List<TeachStudentJob> list = teachStudentJobService.selectTeachStudentJobList(teachStudentJob);
        ExcelUtil<TeachStudentJob> util = new ExcelUtil<TeachStudentJob>(TeachStudentJob.class);
        return util.exportExcel(list, "teachStudentJob");
    }
	
	/**
	 * 新增学生作业
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存学生作业
	 */
	@RequiresPermissions("teach:teachStudentJob:add")
	@Log(title = "学生作业", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachStudentJob teachStudentJob)
	{		
		return toAjax(teachStudentJobService.insertTeachStudentJob(teachStudentJob));
	}

	/**
	 * 修改学生作业
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		TeachStudentJob teachStudentJob = teachStudentJobService.selectTeachStudentJobById(id);
		mmap.put("teachStudentJob", teachStudentJob);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存学生作业
	 */
	@RequiresPermissions("teach:teachStudentJob:edit")
	@Log(title = "学生作业", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachStudentJob teachStudentJob)
	{		
		return toAjax(teachStudentJobService.updateTeachStudentJob(teachStudentJob));
	}
	
	/**
	 * 删除学生作业
	 */
	@RequiresPermissions("teach:teachStudentJob:remove")
	@Log(title = "学生作业", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teachStudentJobService.deleteTeachStudentJobByIds(ids));
	}
	
}
