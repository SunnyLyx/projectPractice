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
import edu.fosu.teach.domain.TeachMajorStage;
import edu.fosu.teach.service.ITeachMajorStageService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 专业阶段 信息操作处理
 *
 *  */
@Controller
@RequestMapping("/teach/teachMajorStage")
public class TeachMajorStageController extends BaseController
{
    private String prefix = "teach/teachMajorStage";

	@Autowired
	private ITeachMajorStageService teachMajorStageService;

	@RequiresPermissions("teach:teachMajorStage:view")
	@GetMapping()
	public String teachMajorStage()
	{
	    return prefix + "/teachMajorStage";
	}

	/**
	 * 查询专业阶段列表
	 */
	@RequiresPermissions("teach:teachMajorStage:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachMajorStage teachMajorStage)
	{
		startPage();
        List<TeachMajorStage> list = teachMajorStageService.selectTeachMajorStageList(teachMajorStage);
		return getDataTable(list);
	}


	/**
	 * 导出专业阶段列表
	 */
	@RequiresPermissions("teach:teachMajorStage:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachMajorStage teachMajorStage)
    {
    	List<TeachMajorStage> list = teachMajorStageService.selectTeachMajorStageList(teachMajorStage);
        ExcelUtil<TeachMajorStage> util = new ExcelUtil<TeachMajorStage>(TeachMajorStage.class);
        return util.exportExcel(list, "teachMajorStage");
    }

	/**
	 * 新增专业阶段
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}

	/**
	 * 新增保存专业阶段
	 */
	@RequiresPermissions("teach:teachMajorStage:add")
	@Log(title = "专业阶段", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachMajorStage teachMajorStage)
	{
		return toAjax(teachMajorStageService.insertTeachMajorStage(teachMajorStage));
	}

	/**
	 * 修改专业阶段
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TeachMajorStage teachMajorStage = teachMajorStageService.selectTeachMajorStageById(id);
		mmap.put("teachMajorStage", teachMajorStage);
	    return prefix + "/edit";
	}

	/**
	 * 修改保存专业阶段
	 */
	@RequiresPermissions("teach:teachMajorStage:edit")
	@Log(title = "专业阶段", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachMajorStage teachMajorStage)
	{
		return toAjax(teachMajorStageService.updateTeachMajorStage(teachMajorStage));
	}

	/**
	 * 删除专业阶段
	 */
	@RequiresPermissions("teach:teachMajorStage:remove")
	@Log(title = "专业阶段", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teachMajorStageService.deleteTeachMajorStageByIds(ids));
	}

	/**
	 * 删除专业阶段
	 */
	@RequiresPermissions("teach:teachMajorStage:remove")
	@Log(title = "专业阶段", businessType = BusinessType.DELETE)
	@PostMapping( "/delete")
	@ResponseBody
	public AjaxResult delete(String id)
	{
		return toAjax(teachMajorStageService.deleteTeachMajorStageById(id));
	}
	
}
