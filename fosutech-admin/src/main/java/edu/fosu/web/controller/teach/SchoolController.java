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
import edu.fosu.teach.domain.School;
import edu.fosu.teach.service.ISchoolService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 分部 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/school")
public class SchoolController extends BaseController
{
    private String prefix = "teach/school";
	
	@Autowired
	private ISchoolService schoolService;
	
	@RequiresPermissions("teach:school:view")
	@GetMapping()
	public String school()
	{
	    return prefix + "/school";
	}
	
	/**
	 * 查询分部列表
	 */
	@RequiresPermissions("teach:school:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(School school)
	{
		startPage();
        List<School> list = schoolService.selectSchoolList(school);
		return getDataTable(list);
	}

	/**
	 * 导出分部列表
	 */
	@RequiresPermissions("teach:school:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(School school)
    {
    	List<School> list = schoolService.selectSchoolList(school);
        ExcelUtil<School> util = new ExcelUtil<School>(School.class);
        return util.exportExcel(list, "school");
    }
	
	/**
	 * 新增分部
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存分部
	 */
	@RequiresPermissions("teach:school:add")
	@Log(title = "分部", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(School school)
	{		
		return toAjax(schoolService.insertSchool(school));
	}

	/**
	 * 修改分部
	 */
	@GetMapping("/edit/{schoolId}")
	public String edit(@PathVariable("schoolId") Integer schoolId, ModelMap mmap)
	{
		School school = schoolService.selectSchoolById(schoolId);
		mmap.put("school", school);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存分部
	 */
	@RequiresPermissions("teach:school:edit")
	@Log(title = "分部", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(School school)
	{		
		return toAjax(schoolService.updateSchool(school));
	}
	
	/**
	 * 删除分部
	 */
	@RequiresPermissions("teach:school:remove")
	@Log(title = "分部", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(schoolService.deleteSchoolByIds(ids));
	}
	
}
