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
import edu.fosu.teach.domain.TeachStudentExam;
import edu.fosu.teach.service.ITeachStudentExamService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 学生考试子 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/teachStudentExam")
public class TeachStudentExamController extends BaseController
{
    private String prefix = "teach/teachStudentExam";
	
	@Autowired
	private ITeachStudentExamService teachStudentExamService;
	
	@RequiresPermissions("teach:teachStudentExam:view")
	@GetMapping()
	public String teachStudentExam()
	{
	    return prefix + "/teachStudentExam";
	}
	
	/**
	 * 查询学生考试子列表
	 */
	@RequiresPermissions("teach:teachStudentExam:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachStudentExam teachStudentExam)
	{
		startPage();
        List<TeachStudentExam> list = teachStudentExamService.selectTeachStudentExamList(teachStudentExam);
		return getDataTable(list);
	}

	/**
	 * 查询学生考试子列表ById
	 */
	@RequiresPermissions("teach:teachStudentExam:list")
	@PostMapping("/listByStudentId")
	@ResponseBody
	public TableDataInfo listByStudentId(TeachStudentExam teachStudentExam)
	{
		startPage();
		List<TeachStudentExam> list = teachStudentExamService.selectTeachStudentExam(teachStudentExam);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出学生考试子列表
	 */
	@RequiresPermissions("teach:teachStudentExam:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachStudentExam teachStudentExam)
    {
    	List<TeachStudentExam> list = teachStudentExamService.selectTeachStudentExamList(teachStudentExam);
        ExcelUtil<TeachStudentExam> util = new ExcelUtil<TeachStudentExam>(TeachStudentExam.class);
        return util.exportExcel(list, "teachStudentExam");
    }
	
	/**
	 * 新增学生考试子
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存学生考试子
	 */
	@RequiresPermissions("teach:teachStudentExam:add")
	@Log(title = "学生考试子", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachStudentExam teachStudentExam)
	{		
		return toAjax(teachStudentExamService.insertTeachStudentExam(teachStudentExam));
	}

	/**
	 * 修改学生考试子
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		TeachStudentExam teachStudentExam = teachStudentExamService.selectTeachStudentExamById(id);
		mmap.put("teachStudentExam", teachStudentExam);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存学生考试子
	 */
	@RequiresPermissions("teach:teachStudentExam:edit")
	@Log(title = "学生考试子", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachStudentExam teachStudentExam)
	{		
		return toAjax(teachStudentExamService.updateTeachStudentExam(teachStudentExam));
	}
	
	/**
	 * 删除学生考试子
	 */
	@RequiresPermissions("teach:teachStudentExam:remove")
	@Log(title = "学生考试子", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teachStudentExamService.deleteTeachStudentExamByIds(ids));
	}
	
}
