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
import edu.fosu.teach.domain.TeachClassHomework;
import edu.fosu.teach.service.ITeachClassHomeworkService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 班级作业统计 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/teachClassHomework")
public class TeachClassHomeworkController extends BaseController
{
    private String prefix = "teach/teachClassHomework";
	
	@Autowired
	private ITeachClassHomeworkService teachClassHomeworkService;
	
	@RequiresPermissions("teach:teachClassHomework:view")
	@GetMapping()
	public String teachClassHomework()
	{
	    return prefix + "/teachClassHomework";
	}
	
	/**
	 * 查询班级作业统计列表
	 */
	@RequiresPermissions("teach:teachClassHomework:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachClassHomework teachClassHomework)
	{
		startPage();
        List<TeachClassHomework> list = teachClassHomeworkService.selectTeachClassHomeworkList(teachClassHomework);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出班级作业统计列表
	 */
	@RequiresPermissions("teach:teachClassHomework:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachClassHomework teachClassHomework)
    {
    	List<TeachClassHomework> list = teachClassHomeworkService.selectTeachClassHomeworkList(teachClassHomework);
        ExcelUtil<TeachClassHomework> util = new ExcelUtil<TeachClassHomework>(TeachClassHomework.class);
        return util.exportExcel(list, "teachClassHomework");
    }
	
	/**
	 * 新增班级作业统计
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存班级作业统计
	 */
	@RequiresPermissions("teach:teachClassHomework:add")
	@Log(title = "班级作业统计", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachClassHomework teachClassHomework)
	{		
		return toAjax(teachClassHomeworkService.insertTeachClassHomework(teachClassHomework));
	}

	/**
	 * 修改班级作业统计
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		TeachClassHomework teachClassHomework = teachClassHomeworkService.selectTeachClassHomeworkById(id);
		mmap.put("teachClassHomework", teachClassHomework);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存班级作业统计
	 */
	@RequiresPermissions("teach:teachClassHomework:edit")
	@Log(title = "班级作业统计", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachClassHomework teachClassHomework)
	{		
		return toAjax(teachClassHomeworkService.updateTeachClassHomework(teachClassHomework));
	}
	
	/**
	 * 删除班级作业统计
	 */
	@RequiresPermissions("teach:teachClassHomework:remove")
	@Log(title = "班级作业统计", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teachClassHomeworkService.deleteTeachClassHomeworkByIds(ids));
	}
	
}
