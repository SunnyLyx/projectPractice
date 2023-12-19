package edu.fosu.web.controller.teach;

import java.util.List;

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
import edu.fosu.teach.domain.TeachSupervisionExam;
import edu.fosu.teach.service.ITeachSupervisionExamService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 总部督查考试 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/teachSupervisionExam")
public class TeachSupervisionExamController extends BaseController
{
    private String prefix = "teach/teachSupervisionExam";
	
	@Autowired
	private ITeachSupervisionExamService teachSupervisionExamService;

	@Autowired
	private ITeachMajorService teachMajorService;

	@Autowired
	private ITeachMajorStageService teachMajorStageService;
	
	@RequiresPermissions("teach:teachSupervisionExam:view")
	@GetMapping()
	public String teachSupervisionExam(ModelMap mmap)
	{
		TeachMajor major = new TeachMajor();
		List<TeachMajor> list = teachMajorService.selectTeachMajorList(major);
		mmap.put("major", list);
	    return prefix + "/teachSupervisionExam";
	}
	
	/**
	 * 查询总部督查考试列表
	 */
	@RequiresPermissions("teach:teachSupervisionExam:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachSupervisionExam teachSupervisionExam)
	{
		startPage();
        List<TeachSupervisionExam> list = teachSupervisionExamService.selectTeachSupervisionExamList(teachSupervisionExam);
		return getDataTable(list);
	}

	/**
	 * 查询总部督查考试列表ByShcoolId
	 */
	@RequiresPermissions("teach:teachSupervisionExam:list")
	@PostMapping("/listById")
	@ResponseBody
	public TableDataInfo listById(Integer schoolId)
	{
		startPage();
		List<TeachSupervisionExam> list = teachSupervisionExamService.selectTeachSupervisionExamListById(schoolId);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出总部督查考试列表
	 */
	@RequiresPermissions("teach:teachSupervisionExam:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachSupervisionExam teachSupervisionExam)
    {
    	List<TeachSupervisionExam> list = teachSupervisionExamService.selectTeachSupervisionExamList(teachSupervisionExam);
        ExcelUtil<TeachSupervisionExam> util = new ExcelUtil<TeachSupervisionExam>(TeachSupervisionExam.class);
        return util.exportExcel(list, "teachSupervisionExam");
    }
	
	/**
	 * 新增总部督查考试
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存总部督查考试
	 */
	@RequiresPermissions("teach:teachSupervisionExam:add")
	@Log(title = "总部督查考试", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachSupervisionExam teachSupervisionExam)
	{		
		return toAjax(teachSupervisionExamService.insertTeachSupervisionExam(teachSupervisionExam));
	}

	/**
	 * 修改总部督查考试
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		TeachSupervisionExam teachSupervisionExam = teachSupervisionExamService.selectTeachSupervisionExamById(id);
		mmap.put("teachSupervisionExam", teachSupervisionExam);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存总部督查考试
	 */
	@RequiresPermissions("teach:teachSupervisionExam:edit")
	@Log(title = "总部督查考试", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachSupervisionExam teachSupervisionExam)
	{		
		return toAjax(teachSupervisionExamService.updateTeachSupervisionExam(teachSupervisionExam));
	}
	
	/**
	 * 删除总部督查考试
	 */
	@RequiresPermissions("teach:teachSupervisionExam:remove")
	@Log(title = "总部督查考试", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teachSupervisionExamService.deleteTeachSupervisionExamByIds(ids));
	}
	
}
