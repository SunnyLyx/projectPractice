package edu.fosu.web.controller.teach;

import java.util.List;

import edu.fosu.common.utils.spring.SpringUtils;
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
import edu.fosu.teach.domain.TeachClassesTeacher;
import edu.fosu.teach.service.ITeachClassesTeacherService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 班级教师（班级子） 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/teachClassesTeacher")
public class TeachClassesTeacherController extends BaseController
{
    private String prefix = "teach/teachClassesTeacher";
	
	@Autowired
	private ITeachClassesTeacherService teachClassesTeacherService;

	private  TeachClassesController teachClassesController = SpringUtils.getBean(TeachClassesController.class);

	@RequiresPermissions("teach:teachClassesTeacher:view")
	@GetMapping()
	public String teachClassesTeacher()
	{
	    return prefix + "/teachClassesTeacher";
	}
	
	/**
	 * 查询班级教师（班级子）列表
	 */
	@RequiresPermissions("teach:teachClassesTeacher:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachClassesTeacher teachClassesTeacher)
	{
		startPage();

		//获取当前登录用户班级情况
		String[] strs1 = teachClassesController.getClasses();


        List<TeachClassesTeacher> list = teachClassesTeacherService.selectTeachClassesTeacherList(teachClassesTeacher);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出班级教师（班级子）列表
	 */
	@RequiresPermissions("teach:teachClassesTeacher:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachClassesTeacher teachClassesTeacher)
    {
    	List<TeachClassesTeacher> list = teachClassesTeacherService.selectTeachClassesTeacherList(teachClassesTeacher);
        ExcelUtil<TeachClassesTeacher> util = new ExcelUtil<TeachClassesTeacher>(TeachClassesTeacher.class);
        return util.exportExcel(list, "teachClassesTeacher");
    }
	
	/**
	 * 新增班级教师（班级子）
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存班级教师（班级子）
	 */
	@RequiresPermissions("teach:teachClassesTeacher:add")
	@Log(title = "班级教师（班级子）", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachClassesTeacher teachClassesTeacher)
	{		
		return toAjax(teachClassesTeacherService.insertTeachClassesTeacher(teachClassesTeacher));
	}

	/**
	 * 修改班级教师（班级子）
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		TeachClassesTeacher teachClassesTeacher = teachClassesTeacherService.selectTeachClassesTeacherById(id);
		mmap.put("teachClassesTeacher", teachClassesTeacher);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存班级教师（班级子）
	 */
	@RequiresPermissions("teach:teachClassesTeacher:edit")
	@Log(title = "班级教师（班级子）", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachClassesTeacher teachClassesTeacher)
	{		
		return toAjax(teachClassesTeacherService.updateTeachClassesTeacher(teachClassesTeacher));
	}
	
	/**
	 * 删除班级教师（班级子）
	 */
	@RequiresPermissions("teach:teachClassesTeacher:remove")
	@Log(title = "班级教师（班级子）", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teachClassesTeacherService.deleteTeachClassesTeacherByIds(ids));
	}

	/**
	 * 删除班级教师（班级子）
	 */
	@RequiresPermissions("teach:teachClassesTeacher:delete")
	@Log(title = "班级教师（班级子）", businessType = BusinessType.DELETE)
	@PostMapping( "/delete")
	@ResponseBody
	public AjaxResult delete(TeachClassesTeacher teachClassesTeacher)
	{
		return toAjax(teachClassesTeacherService.deleteTeachClassesTeacherById(teachClassesTeacher));
	}
	
}
