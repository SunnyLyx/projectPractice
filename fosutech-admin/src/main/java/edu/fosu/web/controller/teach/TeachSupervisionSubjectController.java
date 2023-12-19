package edu.fosu.web.controller.teach;

import java.util.List;

import edu.fosu.teach.domain.TeachMajor;
import edu.fosu.teach.service.ITeachMajorService;
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
import edu.fosu.teach.domain.TeachSupervisionSubject;
import edu.fosu.teach.service.ITeachSupervisionSubjectService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 总部督查项目 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/teachSupervisionSubject")
public class TeachSupervisionSubjectController extends BaseController
{
    private String prefix = "teach/teachSupervisionSubject";
	
	@Autowired
	private ITeachSupervisionSubjectService teachSupervisionSubjectService;

	@Autowired
    private ITeachMajorService teachMajorService;
	
	@RequiresPermissions("teach:teachSupervisionSubject:view")
	@GetMapping()
	public String teachSupervisionSubject(ModelMap mmap)
	{
        TeachMajor major = new TeachMajor();
        List<TeachMajor> list = teachMajorService.selectTeachMajorList(major);
        mmap.put("major", list);
	    return prefix + "/teachSupervisionSubject";
	}
	
	/**
	 * 查询总部督查项目列表
	 */
	@RequiresPermissions("teach:teachSupervisionSubject:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachSupervisionSubject teachSupervisionSubject)
	{
		startPage();
        List<TeachSupervisionSubject> list = teachSupervisionSubjectService.selectTeachSupervisionSubjectList(teachSupervisionSubject);
		return getDataTable(list);
	}

	/**
	 * 查询总部督查项目列表ByShcoolId
	 */
	@RequiresPermissions("teach:teachSupervisionSubject:list")
	@PostMapping("/listById")
	@ResponseBody
	public TableDataInfo listById(Integer schoolId)
	{
		startPage();
		List<TeachSupervisionSubject> list = teachSupervisionSubjectService.selectTeachSupervisionSubjectListById(schoolId);
		return getDataTable(list);
	}

	/**
	 * 导出总部督查项目列表
	 */
	@RequiresPermissions("teach:teachSupervisionSubject:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachSupervisionSubject teachSupervisionSubject)
    {
    	List<TeachSupervisionSubject> list = teachSupervisionSubjectService.selectTeachSupervisionSubjectList(teachSupervisionSubject);
        ExcelUtil<TeachSupervisionSubject> util = new ExcelUtil<TeachSupervisionSubject>(TeachSupervisionSubject.class);
        return util.exportExcel(list, "teachSupervisionSubject");
    }
	
	/**
	 * 新增总部督查项目
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存总部督查项目
	 */
	@RequiresPermissions("teach:teachSupervisionSubject:add")
	@Log(title = "总部督查项目", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachSupervisionSubject teachSupervisionSubject)
	{		
		return toAjax(teachSupervisionSubjectService.insertTeachSupervisionSubject(teachSupervisionSubject));
	}

	/**
	 * 修改总部督查项目
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		TeachSupervisionSubject teachSupervisionSubject = teachSupervisionSubjectService.selectTeachSupervisionSubjectsById(id);
		mmap.put("teachSupervisionSubject", teachSupervisionSubject);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存总部督查项目
	 */
	@RequiresPermissions("teach:teachSupervisionSubject:edit")
	@Log(title = "总部督查项目", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachSupervisionSubject teachSupervisionSubject)
	{		
		return toAjax(teachSupervisionSubjectService.updateTeachSupervisionSubject(teachSupervisionSubject));
	}
	
	/**
	 * 删除总部督查项目
	 */
	@RequiresPermissions("teach:teachSupervisionSubject:remove")
	@Log(title = "总部督查项目", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teachSupervisionSubjectService.deleteTeachSupervisionSubjectByIds(ids));
	}
	
}
