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
import edu.fosu.teach.domain.TeachInspectionItems;
import edu.fosu.teach.service.ITeachInspectionItemsService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 考核项（考核标准子） 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/teachInspectionItems")
public class TeachInspectionItemsController extends BaseController
{
    private String prefix = "teach/teachInspectionItems";
	
	@Autowired
	private ITeachInspectionItemsService teachInspectionItemsService;
	
	@RequiresPermissions("teach:teachInspectionItems:view")
	@GetMapping()
	public String teachInspectionItems()
	{
	    return prefix + "/teachInspectionItems";
	}
	
	/**
	 * 查询考核项（考核标准子）列表
	 */
	@RequiresPermissions("teach:teachInspectionItems:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachInspectionItems teachInspectionItems)
	{
		startPage();
        List<TeachInspectionItems> list = teachInspectionItemsService.selectTeachInspectionItemsList(teachInspectionItems);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出考核项（考核标准子）列表
	 */
	@RequiresPermissions("teach:teachInspectionItems:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachInspectionItems teachInspectionItems)
    {
    	List<TeachInspectionItems> list = teachInspectionItemsService.selectTeachInspectionItemsList(teachInspectionItems);
        ExcelUtil<TeachInspectionItems> util = new ExcelUtil<TeachInspectionItems>(TeachInspectionItems.class);
        return util.exportExcel(list, "teachInspectionItems");
    }
	
	/**
	 * 新增考核项（考核标准子）
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存考核项（考核标准子）
	 */
	@RequiresPermissions("teach:teachInspectionItems:add")
	@Log(title = "考核项（考核标准子）", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachInspectionItems teachInspectionItems)
	{		
		return toAjax(teachInspectionItemsService.insertTeachInspectionItems(teachInspectionItems));
	}

	/**
	 * 修改考核项（考核标准子）
	 */
	@GetMapping("/edit/{inspectionItemsId}")
	public String edit(@PathVariable("inspectionItemsId") Integer inspectionItemsId, ModelMap mmap)
	{
		TeachInspectionItems teachInspectionItems = teachInspectionItemsService.selectTeachInspectionItemsById(inspectionItemsId);
		mmap.put("teachInspectionItems", teachInspectionItems);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存考核项（考核标准子）
	 */
	@RequiresPermissions("teach:teachInspectionItems:edit")
	@Log(title = "考核项（考核标准子）", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachInspectionItems teachInspectionItems)
	{		
		return toAjax(teachInspectionItemsService.updateTeachInspectionItems(teachInspectionItems));
	}
	
	/**
	 * 删除考核项（考核标准子）
	 */
	@RequiresPermissions("teach:teachInspectionItems:remove")
	@Log(title = "考核项（考核标准子）", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teachInspectionItemsService.deleteTeachInspectionItemsByIds(ids));
	}
	
}
