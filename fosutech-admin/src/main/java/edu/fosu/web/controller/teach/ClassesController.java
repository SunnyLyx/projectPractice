package edu.fosu.web.controller.teach;

import java.util.List;
import java.util.Map;

import edu.fosu.common.utils.StringUtils;
import edu.fosu.framework.web.domain.server.Sys;
import edu.fosu.system.domain.SysDept;
import edu.fosu.system.service.ISysDeptService;
import edu.fosu.teach.domain.Major;
import edu.fosu.teach.domain.School;
import edu.fosu.teach.service.IMajorService;
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
import edu.fosu.teach.domain.Classes;
import edu.fosu.teach.service.IClassesService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 班级 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/classes")
public class ClassesController extends BaseController
{
    private String prefix = "teach/classes";
	
	@Autowired
	private IClassesService classesService;

	@Autowired
	private ISysDeptService deptService;

	@Autowired
	private IMajorService majorService;
	
	@RequiresPermissions("teach:classes:view")
	@GetMapping()
	public String classes()
	{
	    return prefix + "/classes";
	}
	
	/**
	 * 查询班级列表
	 */
	@RequiresPermissions("teach:classes:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Classes classes)
	{
		startPage();
        List<Classes> list = classesService.selectClassesList(classes);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出班级列表
	 */
	@RequiresPermissions("teach:classes:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Classes classes)
    {
    	List<Classes> list = classesService.selectClassesList(classes);
        ExcelUtil<Classes> util = new ExcelUtil<Classes>(Classes.class);
        return util.exportExcel(list, "classes");
    }
	
	/**
	 * 新增班级
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		Major major = new Major();
		List<Major> list2 = majorService.selectMajorList(major);
		mmap.put("major", list2);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存班级
	 */
	@RequiresPermissions("teach:classes:add")
	@Log(title = "班级", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Classes classes)
	{		
		return toAjax(classesService.insertClasses(classes));
	}

	/**
	 * 修改班级
	 *//*
	@GetMapping("/edit/{classId}")
	public String edit(@PathVariable("classId") Integer classId, ModelMap mmap)
	{
		Classes classes = classesService.selectClassesById(classId);
		mmap.put("classes", classes);

		Major major = new Major();
		List<Major> list2 = majorService.selectMajorList(major);
		mmap.put("major", list2);

		long deptId = Integer.valueOf(classes.getSchoolId()).longValue();
		SysDept dept = deptService.selectDeptById(deptId);
		if (StringUtils.isNotNull(dept) && 100L == deptId)
		{
			dept.setParentName("无");
		}
		mmap.put("dept", dept);

	    return prefix + "/edit";
	}*/

	/**
	 * 修改学生档案
	 */
	@GetMapping("/edit/{classId}")
	public String edit(@PathVariable("classId") Integer classId, ModelMap mmap)
	{
		Classes classes = classesService.selectClassesById(classId);
		mmap.put("classes", classes);

		long deptId = Integer.valueOf(classes.getSchoolId()).longValue();
		SysDept dept = deptService.selectDeptById(deptId);
		if (StringUtils.isNotNull(dept) && 100L == deptId)
		{
			dept.setParentName("无");
		}
		mmap.put("dept", dept);

		return prefix + "/edit";
	}
	
	/**
	 * 修改保存班级
	 */
	@RequiresPermissions("teach:classes:edit")
	@Log(title = "班级", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Classes classes)
	{
		return toAjax(classesService.updateClasses(classes));
	}
	
	/**
	 * 删除班级
	 */
	@RequiresPermissions("teach:classes:remove")
	@Log(title = "班级", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(classesService.deleteClassesByIds(ids));
	}
	
}
