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
import edu.fosu.teach.domain.TeachSubjectAttendance;
import edu.fosu.teach.service.ITeachSubjectAttendanceService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 作业统计 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/teachSubjectAttendance")
public class TeachSubjectAttendanceController extends BaseController
{
    private String prefix = "teach/teachSubjectAttendance";
	
	@Autowired
	private ITeachSubjectAttendanceService teachSubjectAttendanceService;
	
	@RequiresPermissions("teach:teachSubjectAttendance:view")
	@GetMapping()
	public String teachSubjectAttendance()
	{
	    return prefix + "/teachSubjectAttendance";
	}
	
	/**
	 * 查询作业统计列表
	 */
	@RequiresPermissions("teach:teachSubjectAttendance:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachSubjectAttendance teachSubjectAttendance)
	{
		startPage();
        List<TeachSubjectAttendance> list = teachSubjectAttendanceService.selectTeachSubjectAttendanceList(teachSubjectAttendance);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出作业统计列表
	 */
	@RequiresPermissions("teach:teachSubjectAttendance:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachSubjectAttendance teachSubjectAttendance)
    {
    	List<TeachSubjectAttendance> list = teachSubjectAttendanceService.selectTeachSubjectAttendanceList(teachSubjectAttendance);
        ExcelUtil<TeachSubjectAttendance> util = new ExcelUtil<TeachSubjectAttendance>(TeachSubjectAttendance.class);
        return util.exportExcel(list, "teachSubjectAttendance");
    }
	
	/**
	 * 新增作业统计
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存作业统计
	 */
	@RequiresPermissions("teach:teachSubjectAttendance:add")
	@Log(title = "作业统计", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachSubjectAttendance teachSubjectAttendance)
	{		
		return toAjax(teachSubjectAttendanceService.insertTeachSubjectAttendance(teachSubjectAttendance));
	}

	/**
	 * 修改作业统计
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		TeachSubjectAttendance teachSubjectAttendance = teachSubjectAttendanceService.selectTeachSubjectAttendanceById(id);
		mmap.put("teachSubjectAttendance", teachSubjectAttendance);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存作业统计
	 */
	@RequiresPermissions("teach:teachSubjectAttendance:edit")
	@Log(title = "作业统计", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachSubjectAttendance teachSubjectAttendance)
	{		
		return toAjax(teachSubjectAttendanceService.updateTeachSubjectAttendance(teachSubjectAttendance));
	}
	
	/**
	 * 删除作业统计
	 */
	@RequiresPermissions("teach:teachSubjectAttendance:remove")
	@Log(title = "作业统计", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teachSubjectAttendanceService.deleteTeachSubjectAttendanceByIds(ids));
	}
	
}
