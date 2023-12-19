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
import edu.fosu.teach.domain.TeachMajorStatistics;
import edu.fosu.teach.service.ITeachMajorStatisticsService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 数据汇总（专业） 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/teachMajorStatistics")
public class TeachMajorStatisticsController extends BaseController
{
    private String prefix = "teach/teachMajorStatistics";
	
	@Autowired
	private ITeachMajorStatisticsService teachMajorStatisticsService;

	@Autowired
	private ITeachMajorService teachMajorService;
	
	@RequiresPermissions("teach:teachMajorStatistics:view")
	@GetMapping()
	public String teachMajorStatistics(ModelMap mmap)
	{
		TeachMajor major = new TeachMajor();
		List<TeachMajor> list = teachMajorService.selectTeachMajorList(major);
		mmap.put("major", list);
	    return prefix + "/teachMajorStatistics";
	}
	
	/**
	 * 查询数据汇总（专业）列表
	 */
	@RequiresPermissions("teach:teachMajorStatistics:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachMajorStatistics teachMajorStatistics)
	{
		startPage();
        List<TeachMajorStatistics> list = teachMajorStatisticsService.selectTeachMajorStatisticsList(teachMajorStatistics);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出数据汇总（专业）列表
	 */
	@RequiresPermissions("teach:teachMajorStatistics:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachMajorStatistics teachMajorStatistics)
    {
    	List<TeachMajorStatistics> list = teachMajorStatisticsService.selectTeachMajorStatisticsList(teachMajorStatistics);
        ExcelUtil<TeachMajorStatistics> util = new ExcelUtil<TeachMajorStatistics>(TeachMajorStatistics.class);
        return util.exportExcel(list, "teachMajorStatistics");
    }
	
	/**
	 * 新增数据汇总（专业）
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存数据汇总（专业）
	 */
	@RequiresPermissions("teach:teachMajorStatistics:add")
	@Log(title = "数据汇总（专业）", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachMajorStatistics teachMajorStatistics)
	{		
		return toAjax(teachMajorStatisticsService.insertTeachMajorStatistics(teachMajorStatistics));
	}

	/**
	 * 修改数据汇总（专业）
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		TeachMajorStatistics teachMajorStatistics = teachMajorStatisticsService.selectTeachMajorStatisticsById(id);
		mmap.put("teachMajorStatistics", teachMajorStatistics);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存数据汇总（专业）
	 */
	@RequiresPermissions("teach:teachMajorStatistics:edit")
	@Log(title = "数据汇总（专业）", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachMajorStatistics teachMajorStatistics)
	{		
		return toAjax(teachMajorStatisticsService.updateTeachMajorStatistics(teachMajorStatistics));
	}
	
	/**
	 * 删除数据汇总（专业）
	 */
	@RequiresPermissions("teach:teachMajorStatistics:remove")
	@Log(title = "数据汇总（专业）", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teachMajorStatisticsService.deleteTeachMajorStatisticsByIds(ids));
	}
	
}
