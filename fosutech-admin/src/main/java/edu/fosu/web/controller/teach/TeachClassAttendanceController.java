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
import edu.fosu.teach.domain.TeachClassAttendance;
import edu.fosu.teach.service.ITeachClassAttendanceService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 班级出勤率统计 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/teachClassAttendance")
public class TeachClassAttendanceController extends BaseController
{
    private String prefix = "teach/teachClassAttendance";
	
	@Autowired
	private ITeachClassAttendanceService teachClassAttendanceService;
	
	@RequiresPermissions("teach:teachClassAttendance:view")
	@GetMapping()
	public String teachClassAttendance()
	{
	    return prefix + "/teachClassAttendance";
	}
	
	/**
	 * 查询班级出勤率统计列表
	 */
	@RequiresPermissions("teach:teachClassAttendance:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachClassAttendance teachClassAttendance)
	{
		startPage();
        List<TeachClassAttendance> list = teachClassAttendanceService.selectTeachClassAttendanceList(teachClassAttendance);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出班级出勤率统计列表
	 */
	@RequiresPermissions("teach:teachClassAttendance:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachClassAttendance teachClassAttendance)
    {
    	List<TeachClassAttendance> list = teachClassAttendanceService.selectTeachClassAttendanceList(teachClassAttendance);
        ExcelUtil<TeachClassAttendance> util = new ExcelUtil<TeachClassAttendance>(TeachClassAttendance.class);
        return util.exportExcel(list, "teachClassAttendance");
    }
	
	/**
	 * 新增班级出勤率统计
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存班级出勤率统计
	 */
	@RequiresPermissions("teach:teachClassAttendance:add")
	@Log(title = "班级出勤率统计", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachClassAttendance teachClassAttendance)
	{		
		return toAjax(teachClassAttendanceService.insertTeachClassAttendance(teachClassAttendance));
	}

	/**
	 * 修改班级出勤率统计
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		TeachClassAttendance teachClassAttendance = teachClassAttendanceService.selectTeachClassAttendanceById(id);
		mmap.put("teachClassAttendance", teachClassAttendance);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存班级出勤率统计
	 */
	@RequiresPermissions("teach:teachClassAttendance:edit")
	@Log(title = "班级出勤率统计", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachClassAttendance teachClassAttendance)
	{		
		return toAjax(teachClassAttendanceService.updateTeachClassAttendance(teachClassAttendance));
	}
	
	/**
	 * 删除班级出勤率统计
	 */
	@RequiresPermissions("teach:teachClassAttendance:remove")
	@Log(title = "班级出勤率统计", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teachClassAttendanceService.deleteTeachClassAttendanceByIds(ids));
	}
	
}
