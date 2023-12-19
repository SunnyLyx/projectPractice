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
import edu.fosu.teach.domain.Major;
import edu.fosu.teach.service.IMajorService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 专业 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/major")
public class MajorController extends BaseController
{
    private String prefix = "teach/major";
	
	@Autowired
	private IMajorService majorService;
	
	@RequiresPermissions("teach:major:view")
	@GetMapping()
	public String major()
	{
	    return prefix + "/major";
	}
	
	/**
	 * 查询专业列表
	 */
	@RequiresPermissions("teach:major:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Major major)
	{
		startPage();
        List<Major> list = majorService.selectMajorList(major);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出专业列表
	 */
	@RequiresPermissions("teach:major:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Major major)
    {
    	List<Major> list = majorService.selectMajorList(major);
        ExcelUtil<Major> util = new ExcelUtil<Major>(Major.class);
        return util.exportExcel(list, "major");
    }
	
	/**
	 * 新增专业
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存专业
	 */
	@RequiresPermissions("teach:major:add")
	@Log(title = "专业", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Major major)
	{		
		return toAjax(majorService.insertMajor(major));
	}

	/**
	 * 修改专业
	 */
	@GetMapping("/edit/{majorId}")
	public String edit(@PathVariable("majorId") Integer majorId, ModelMap mmap)
	{
		Major major = majorService.selectMajorById(majorId);
		mmap.put("major", major);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存专业
	 */
	@RequiresPermissions("teach:major:edit")
	@Log(title = "专业", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Major major)
	{		
		return toAjax(majorService.updateMajor(major));
	}
	
	/**
	 * 删除专业
	 */
	@RequiresPermissions("teach:major:remove")
	@Log(title = "专业", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(majorService.deleteMajorByIds(ids));
	}
	
}
