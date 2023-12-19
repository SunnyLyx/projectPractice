package edu.fosu.web.controller.teach;

import java.util.List;

import io.swagger.models.auth.In;
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
import edu.fosu.teach.domain.TeachStudentSubject;
import edu.fosu.teach.service.ITeachStudentSubjectService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 学生项目 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/teachStudentSubject")
public class TeachStudentSubjectController extends BaseController
{
    private String prefix = "teach/teachStudentSubject";
	
	@Autowired
	private ITeachStudentSubjectService teachStudentSubjectService;
	
	@RequiresPermissions("teach:teachStudentSubject:view")
	@GetMapping()
	public String teachStudentSubject()
	{
	    return prefix + "/teachStudentSubject";
	}
	
	/**
	 * 查询学生项目列表
	 */
	@RequiresPermissions("teach:teachStudentSubject:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachStudentSubject teachStudentSubject)
	{
		startPage();
        List<TeachStudentSubject> list = teachStudentSubjectService.selectTeachStudentSubjectList(teachStudentSubject);
		return getDataTable(list);
	}

	/**
	 * 查询学生项目列表ById
	 */
	@RequiresPermissions("teach:teachStudentSubject:list")
	@PostMapping("/listByStudentId")
	@ResponseBody
	public TableDataInfo listByStudentId(Integer studentId)
	{
		startPage();
		List<TeachStudentSubject> list = teachStudentSubjectService.selectTeachStudentSubject(studentId);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出学生项目列表
	 */
	@RequiresPermissions("teach:teachStudentSubject:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachStudentSubject teachStudentSubject)
    {
    	List<TeachStudentSubject> list = teachStudentSubjectService.selectTeachStudentSubjectList(teachStudentSubject);
        ExcelUtil<TeachStudentSubject> util = new ExcelUtil<TeachStudentSubject>(TeachStudentSubject.class);
        return util.exportExcel(list, "teachStudentSubject");
    }
	
	/**
	 * 新增学生项目
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存学生项目
	 */
	@RequiresPermissions("teach:teachStudentSubject:add")
	@Log(title = "学生项目", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachStudentSubject teachStudentSubject)
	{		
		return toAjax(teachStudentSubjectService.insertTeachStudentSubject(teachStudentSubject));
	}

	/**
	 * 修改学生项目
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		TeachStudentSubject teachStudentSubject = teachStudentSubjectService.selectTeachStudentSubjectById(id);
		mmap.put("teachStudentSubject", teachStudentSubject);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存学生项目
	 */
	@RequiresPermissions("teach:teachStudentSubject:edit")
	@Log(title = "学生项目", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachStudentSubject teachStudentSubject)
	{		
		return toAjax(teachStudentSubjectService.updateTeachStudentSubject(teachStudentSubject));
	}
	
	/**
	 * 删除学生项目
	 */
	@RequiresPermissions("teach:teachStudentSubject:remove")
	@Log(title = "学生项目", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teachStudentSubjectService.deleteTeachStudentSubjectByIds(ids));
	}
	
}
