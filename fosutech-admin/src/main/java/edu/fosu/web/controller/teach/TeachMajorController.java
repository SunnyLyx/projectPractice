package edu.fosu.web.controller.teach;

import java.util.*;

import edu.fosu.teach.service.ITeachMajorStageService;
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
import edu.fosu.teach.domain.TeachMajor;
import edu.fosu.teach.service.ITeachMajorService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 专业 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/teachMajor")
public class TeachMajorController extends BaseController
{
    private String prefix = "teach/teachMajor";
	
	@Autowired
	private ITeachMajorService teachMajorService;

	@RequiresPermissions("teach:teachMajor:view")
	@GetMapping()
	public String teachMajor()
	{
	    return prefix + "/teachMajor";
	}
	
	/**
	 * 查询专业列表
	 */
	@RequiresPermissions("teach:teachMajor:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachMajor teachMajor)
	{
		startPage();
		HashMap<String, List<TeachMajor>> map = teachMajorService.selectTeachMajorListAndStage(teachMajor);

        List<TeachMajor> original = map.get("original");
		List<TeachMajor> modified = map.get("modified");
		TableDataInfo originList = getDataTable(original);
		TableDataInfo modifyList = getDataTable(modified);
		modifyList.setTotal(originList.getTotal());
		return modifyList;
	}
	
	
	/**
	 * 导出专业列表
	 */
	@RequiresPermissions("teach:teachMajor:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachMajor teachMajor)
    {
    	List<TeachMajor> list = teachMajorService.selectTeachMajorList(teachMajor);
        ExcelUtil<TeachMajor> util = new ExcelUtil<TeachMajor>(TeachMajor.class);
        return util.exportExcel(list, "teachMajor");
    }
	
	/**
	 * 新增专业
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		int countNum = teachMajorService.selectCountNum();
		int num = 0;
		if(countNum != 0){
			int result = teachMajorService.selectId();
			if(result != 0){
				num = result+1;
			}
		}else {
			num++;
		}
		mmap.put("majorId",num);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存专业
	 */
	@RequiresPermissions("teach:teachMajor:add")
	@Log(title = "专业", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachMajor teachMajor)
	{
		return toAjax(teachMajorService.insertTeachMajor(teachMajor));
	}

	/**
	 * 修改专业
	 */
	@GetMapping("/edit/{majorId}")
	public String edit(@PathVariable("majorId") Integer majorId, ModelMap mmap)
	{
		TeachMajor teachMajor = teachMajorService.selectTeachMajorById(majorId);
		mmap.put("teachMajor", teachMajor);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存专业
	 */
	@RequiresPermissions("teach:teachMajor:edit")
	@Log(title = "专业", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachMajor teachMajor)
	{		
		return toAjax(teachMajorService.updateTeachMajor(teachMajor));
	}
	
	/**
	 * 删除专业
	 */
	@RequiresPermissions("teach:teachMajor:remove")
	@Log(title = "专业", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		int a = teachMajorService.deleteTeachMajorByIds(ids);
		if(a == -1){
			AjaxResult ajaxResult = new AjaxResult();
			ajaxResult.put("code", 1);
			ajaxResult.put("msg", "该专业下已存在班级，不可删除！");
			return ajaxResult;
		}else {
			return toAjax(a);
		}
	}

	/**
	 * 校验专业名称是否唯一
	 */
	@PostMapping("/checkMajorNameUnique")
	@ResponseBody
	public String checkMajorNameUnique(TeachMajor teachMajor)
	{
		return teachMajorService.checkMajorNameUnique(teachMajor);
	}
	
}
