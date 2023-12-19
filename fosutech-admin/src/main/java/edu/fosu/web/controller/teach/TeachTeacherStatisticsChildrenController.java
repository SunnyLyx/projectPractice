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
import edu.fosu.teach.domain.TeachTeacherStatisticsChildren;
import edu.fosu.teach.service.ITeachTeacherStatisticsChildrenService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 数据统计（教师）子 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/teachTeacherStatisticsChildren")
public class TeachTeacherStatisticsChildrenController extends BaseController
{
    private String prefix = "teach/teachTeacherStatisticsChildren";
	
	@Autowired
	private ITeachTeacherStatisticsChildrenService teachTeacherStatisticsChildrenService;
	
	@RequiresPermissions("teach:teachTeacherStatisticsChildren:view")
	@GetMapping()
	public String teachTeacherStatisticsChildren()
	{
	    return prefix + "/teachTeacherStatisticsChildren";
	}
	
	/**
	 * 查询数据统计（教师）子列表
	 */
	@RequiresPermissions("teach:teachTeacherStatisticsChildren:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachTeacherStatisticsChildren teachTeacherStatisticsChildren)
	{
		startPage();
        List<TeachTeacherStatisticsChildren> list = teachTeacherStatisticsChildrenService.selectTeachTeacherStatisticsChildrenList(teachTeacherStatisticsChildren);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出数据统计（教师）子列表
	 */
	@RequiresPermissions("teach:teachTeacherStatisticsChildren:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachTeacherStatisticsChildren teachTeacherStatisticsChildren)
    {
    	List<TeachTeacherStatisticsChildren> list = teachTeacherStatisticsChildrenService.selectTeachTeacherStatisticsChildrenList(teachTeacherStatisticsChildren);
        ExcelUtil<TeachTeacherStatisticsChildren> util = new ExcelUtil<TeachTeacherStatisticsChildren>(TeachTeacherStatisticsChildren.class);
        return util.exportExcel(list, "teachTeacherStatisticsChildren");
    }
	
	/**
	 * 新增数据统计（教师）子
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存数据统计（教师）子
	 */
	@RequiresPermissions("teach:teachTeacherStatisticsChildren:add")
	@Log(title = "数据统计（教师）子", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachTeacherStatisticsChildren teachTeacherStatisticsChildren)
	{		
		return toAjax(teachTeacherStatisticsChildrenService.insertTeachTeacherStatisticsChildren(teachTeacherStatisticsChildren));
	}

	/**
	 * 修改数据统计（教师）子
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		TeachTeacherStatisticsChildren teachTeacherStatisticsChildren = teachTeacherStatisticsChildrenService.selectTeachTeacherStatisticsChildrenById(id);
		mmap.put("teachTeacherStatisticsChildren", teachTeacherStatisticsChildren);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存数据统计（教师）子
	 */
	@RequiresPermissions("teach:teachTeacherStatisticsChildren:edit")
	@Log(title = "数据统计（教师）子", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachTeacherStatisticsChildren teachTeacherStatisticsChildren)
	{		
		return toAjax(teachTeacherStatisticsChildrenService.updateTeachTeacherStatisticsChildren(teachTeacherStatisticsChildren));
	}
	
	/**
	 * 删除数据统计（教师）子
	 */
	@RequiresPermissions("teach:teachTeacherStatisticsChildren:remove")
	@Log(title = "数据统计（教师）子", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teachTeacherStatisticsChildrenService.deleteTeachTeacherStatisticsChildrenByIds(ids));
	}
	
}
