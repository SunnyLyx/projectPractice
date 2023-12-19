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
import edu.fosu.teach.domain.TeachExamStatistics;
import edu.fosu.teach.service.ITeachExamStatisticsService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 考试统计 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/teachExamStatistics")
public class TeachExamStatisticsController extends BaseController
{
    private String prefix = "teach/teachExamStatistics";
	
	@Autowired
	private ITeachExamStatisticsService teachExamStatisticsService;
	
	@RequiresPermissions("teach:teachExamStatistics:view")
	@GetMapping()
	public String teachExamStatistics()
	{
	    return prefix + "/teachExamStatistics";
	}
	
	/**
	 * 查询考试统计列表
	 */
	@RequiresPermissions("teach:teachExamStatistics:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachExamStatistics teachExamStatistics)
	{
		startPage();
        List<TeachExamStatistics> list = teachExamStatisticsService.selectTeachExamStatisticsList(teachExamStatistics);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出考试统计列表
	 */
	@RequiresPermissions("teach:teachExamStatistics:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachExamStatistics teachExamStatistics)
    {
    	List<TeachExamStatistics> list = teachExamStatisticsService.selectTeachExamStatisticsList(teachExamStatistics);
        ExcelUtil<TeachExamStatistics> util = new ExcelUtil<TeachExamStatistics>(TeachExamStatistics.class);
        return util.exportExcel(list, "teachExamStatistics");
    }
	
	/**
	 * 新增考试统计
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存考试统计
	 */
	@RequiresPermissions("teach:teachExamStatistics:add")
	@Log(title = "考试统计", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachExamStatistics teachExamStatistics)
	{		
		return toAjax(teachExamStatisticsService.insertTeachExamStatistics(teachExamStatistics));
	}

	/**
	 * 修改考试统计
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		TeachExamStatistics teachExamStatistics = teachExamStatisticsService.selectTeachExamStatisticsById(id);
		mmap.put("teachExamStatistics", teachExamStatistics);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存考试统计
	 */
	@RequiresPermissions("teach:teachExamStatistics:edit")
	@Log(title = "考试统计", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachExamStatistics teachExamStatistics)
	{		
		return toAjax(teachExamStatisticsService.updateTeachExamStatistics(teachExamStatistics));
	}
	
	/**
	 * 删除考试统计
	 */
	@RequiresPermissions("teach:teachExamStatistics:remove")
	@Log(title = "考试统计", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teachExamStatisticsService.deleteTeachExamStatisticsByIds(ids));
	}
	
}
