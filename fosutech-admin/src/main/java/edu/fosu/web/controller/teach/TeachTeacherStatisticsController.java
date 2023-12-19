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
import edu.fosu.teach.domain.TeachTeacherStatistics;
import edu.fosu.teach.service.ITeachTeacherStatisticsService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 数据汇总（教师） 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/teachTeacherStatistics")
public class TeachTeacherStatisticsController extends BaseController
{
    private String prefix = "teach/teachTeacherStatistics";
	
	@Autowired
	private ITeachTeacherStatisticsService teachTeacherStatisticsService;
	
	@RequiresPermissions("teach:teachTeacherStatistics:view")
	@GetMapping()
	public String teachTeacherStatistics()
	{
	    return prefix + "/teachTeacherStatistics";
	}
	
	/**
	 * 查询数据汇总（教师）列表
	 */
	@RequiresPermissions("teach:teachTeacherStatistics:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachTeacherStatistics teachTeacherStatistics)
	{
		startPage();
        List<TeachTeacherStatistics> list = teachTeacherStatisticsService.selectTeachTeacherStatisticsList(teachTeacherStatistics);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出数据汇总（教师）列表
	 */
	@RequiresPermissions("teach:teachTeacherStatistics:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachTeacherStatistics teachTeacherStatistics)
    {
    	List<TeachTeacherStatistics> list = teachTeacherStatisticsService.selectTeachTeacherStatisticsList(teachTeacherStatistics);
        ExcelUtil<TeachTeacherStatistics> util = new ExcelUtil<TeachTeacherStatistics>(TeachTeacherStatistics.class);
        return util.exportExcel(list, "teachTeacherStatistics");
    }
	
	/**
	 * 新增数据汇总（教师）
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存数据汇总（教师）
	 */
	@RequiresPermissions("teach:teachTeacherStatistics:add")
	@Log(title = "数据汇总（教师）", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachTeacherStatistics teachTeacherStatistics)
	{		
		return toAjax(teachTeacherStatisticsService.insertTeachTeacherStatistics(teachTeacherStatistics));
	}

	/**
	 * 修改数据汇总（教师）
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		TeachTeacherStatistics teachTeacherStatistics = teachTeacherStatisticsService.selectTeachTeacherStatisticsById(id);
		mmap.put("teachTeacherStatistics", teachTeacherStatistics);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存数据汇总（教师）
	 */
	@RequiresPermissions("teach:teachTeacherStatistics:edit")
	@Log(title = "数据汇总（教师）", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachTeacherStatistics teachTeacherStatistics)
	{		
		return toAjax(teachTeacherStatisticsService.updateTeachTeacherStatistics(teachTeacherStatistics));
	}
	
	/**
	 * 删除数据汇总（教师）
	 */
	@RequiresPermissions("teach:teachTeacherStatistics:remove")
	@Log(title = "数据汇总（教师）", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teachTeacherStatisticsService.deleteTeachTeacherStatisticsByIds(ids));
	}
	
}
