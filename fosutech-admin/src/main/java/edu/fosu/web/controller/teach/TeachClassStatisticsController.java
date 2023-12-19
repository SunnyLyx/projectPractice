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
import edu.fosu.teach.domain.TeachClassStatistics;
import edu.fosu.teach.service.ITeachClassStatisticsService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 数据汇总（班级） 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/teachClassStatistics")
public class TeachClassStatisticsController extends BaseController
{
    private String prefix = "teach/teachClassStatistics";
	
	@Autowired
	private ITeachClassStatisticsService teachClassStatisticsService;

	@Autowired
	private ITeachMajorService teachMajorService;
	
	@RequiresPermissions("teach:teachClassStatistics:view")
	@GetMapping()
	public String teachClassStatistics(ModelMap mmap)
	{
		TeachMajor major = new TeachMajor();
		List<TeachMajor> list = teachMajorService.selectTeachMajorList(major);
		mmap.put("major", list);
	    return prefix + "/teachClassStatistics";
	}
	
	/**
	 * 查询数据汇总（班级）列表
	 */
	@RequiresPermissions("teach:teachClassStatistics:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachClassStatistics teachClassStatistics)
	{
		startPage();
        List<TeachClassStatistics> list = teachClassStatisticsService.selectTeachClassStatisticsList(teachClassStatistics);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出数据汇总（班级）列表
	 */
	@RequiresPermissions("teach:teachClassStatistics:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachClassStatistics teachClassStatistics)
    {
    	List<TeachClassStatistics> list = teachClassStatisticsService.selectTeachClassStatisticsList(teachClassStatistics);
        ExcelUtil<TeachClassStatistics> util = new ExcelUtil<TeachClassStatistics>(TeachClassStatistics.class);
        return util.exportExcel(list, "teachClassStatistics");
    }
	
	/**
	 * 新增数据汇总（班级）
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存数据汇总（班级）
	 */
	@RequiresPermissions("teach:teachClassStatistics:add")
	@Log(title = "数据汇总（班级）", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachClassStatistics teachClassStatistics)
	{		
		return toAjax(teachClassStatisticsService.insertTeachClassStatistics(teachClassStatistics));
	}

	/**
	 * 修改数据汇总（班级）
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		TeachClassStatistics teachClassStatistics = teachClassStatisticsService.selectTeachClassStatisticsById(id);
		mmap.put("teachClassStatistics", teachClassStatistics);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存数据汇总（班级）
	 */
	@RequiresPermissions("teach:teachClassStatistics:edit")
	@Log(title = "数据汇总（班级）", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachClassStatistics teachClassStatistics)
	{		
		return toAjax(teachClassStatisticsService.updateTeachClassStatistics(teachClassStatistics));
	}
	
	/**
	 * 删除数据汇总（班级）
	 */
	@RequiresPermissions("teach:teachClassStatistics:remove")
	@Log(title = "数据汇总（班级）", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teachClassStatisticsService.deleteTeachClassStatisticsByIds(ids));
	}
	
}
