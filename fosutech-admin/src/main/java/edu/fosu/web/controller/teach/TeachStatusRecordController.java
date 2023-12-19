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
import edu.fosu.teach.domain.TeachStatusRecord;
import edu.fosu.teach.service.ITeachStatusRecordService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 学生状态更改记录 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/teachStatusRecord")
public class TeachStatusRecordController extends BaseController
{
    private String prefix = "teach/teachStatusRecord";
	
	@Autowired
	private ITeachStatusRecordService teachStatusRecordService;
	
	@RequiresPermissions("teach:teachStatusRecord:view")
	@GetMapping()
	public String teachStatusRecord()
	{
	    return prefix + "/teachStatusRecord";
	}
	
	/**
	 * 查询学生状态更改记录列表
	 */
	@RequiresPermissions("teach:teachStatusRecord:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachStatusRecord teachStatusRecord)
	{
		startPage();
        List<TeachStatusRecord> list = teachStatusRecordService.selectTeachStatusRecordList(teachStatusRecord);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出学生状态更改记录列表
	 */
	@RequiresPermissions("teach:teachStatusRecord:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachStatusRecord teachStatusRecord)
    {
    	List<TeachStatusRecord> list = teachStatusRecordService.selectTeachStatusRecordList(teachStatusRecord);
        ExcelUtil<TeachStatusRecord> util = new ExcelUtil<TeachStatusRecord>(TeachStatusRecord.class);
        return util.exportExcel(list, "teachStatusRecord");
    }
	
	/**
	 * 新增学生状态更改记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存学生状态更改记录
	 */
	@RequiresPermissions("teach:teachStatusRecord:add")
	@Log(title = "学生状态更改记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachStatusRecord teachStatusRecord)
	{		
		return toAjax(teachStatusRecordService.insertTeachStatusRecord(teachStatusRecord));
	}

	/**
	 * 修改学生状态更改记录
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		TeachStatusRecord teachStatusRecord = teachStatusRecordService.selectTeachStatusRecordById(id);
		mmap.put("teachStatusRecord", teachStatusRecord);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存学生状态更改记录
	 */
	@RequiresPermissions("teach:teachStatusRecord:edit")
	@Log(title = "学生状态更改记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachStatusRecord teachStatusRecord)
	{		
		return toAjax(teachStatusRecordService.updateTeachStatusRecord(teachStatusRecord));
	}
	
	/**
	 * 删除学生状态更改记录
	 */
	@RequiresPermissions("teach:teachStatusRecord:remove")
	@Log(title = "学生状态更改记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teachStatusRecordService.deleteTeachStatusRecordByIds(ids));
	}
	
}
