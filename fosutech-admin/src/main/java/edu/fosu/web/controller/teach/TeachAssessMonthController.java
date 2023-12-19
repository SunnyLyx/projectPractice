package edu.fosu.web.controller.teach;

import java.util.List;

import edu.fosu.common.utils.spring.SpringUtils;
import edu.fosu.framework.util.ShiroUtils;
import edu.fosu.system.service.ISysUserService;
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
import edu.fosu.teach.domain.TeachAssessMonth;
import edu.fosu.teach.service.ITeachAssessMonthService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 月度考核标准 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/teachAssessMonth")
public class TeachAssessMonthController extends BaseController
{
    private String prefix = "teach/teachAssessMonth";
	
	@Autowired
	private ITeachAssessMonthService teachAssessMonthService;

	@Autowired
	private ITeachMajorService teachMajorService;

	@Autowired
	private ISysUserService sysUserService;

	@Autowired
	private TeachClassesController teachClassesController = SpringUtils.getBean(TeachClassesController.class);
	
	@RequiresPermissions("teach:teachAssessMonth:view")
	@GetMapping()
	public String teachAssessMonth(ModelMap mmap)
	{
		TeachMajor major = new TeachMajor();
		List<TeachMajor> list = teachMajorService.selectTeachMajorList(major);
		mmap.put("major", list);
		int userno = ShiroUtils.getUserId().intValue();
		String roleNo = sysUserService.selectUserRoleGroup2(new Long((long)userno));
		if("5".equals(roleNo) || "6".equals(roleNo) || "7".equals(roleNo) || "8".equals(roleNo)){
			return prefix + "/teachAssessMonth1";
		}else{
			return prefix + "/teachAssessMonth";
		}
	}
	
	/**
	 * 查询月度考核标准列表
	 */
	@RequiresPermissions("teach:teachAssessMonth:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachAssessMonth teachAssessMonth)
	{
		String[] strs1 =teachClassesController.getClasses();
		teachAssessMonth.setTeacherClass(strs1);
		startPage();
        List<TeachAssessMonth> list = teachAssessMonthService.selectTeachAssessMonthList(teachAssessMonth);
		return getDataTable(list);
	}

	/**
	 * 查询学生档案列表
	 */
//	@RequiresPermissions("teach:student:listById")
	@PostMapping("/listById")
	@ResponseBody
	public TableDataInfo listById(Integer schoolId)
	{
		startPage();
		List<TeachAssessMonth> list = teachAssessMonthService.selectTeachAssessMonthBySchoolId(schoolId);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出月度考核标准列表
	 */
	@RequiresPermissions("teach:teachAssessMonth:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachAssessMonth teachAssessMonth)
    {
    	List<TeachAssessMonth> list = teachAssessMonthService.selectTeachAssessMonthList(teachAssessMonth);
        ExcelUtil<TeachAssessMonth> util = new ExcelUtil<TeachAssessMonth>(TeachAssessMonth.class);
        return util.exportExcel(list, "teachAssessMonth");
    }
	
	/**
	 * 新增月度考核标准
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存月度考核标准
	 */
	@RequiresPermissions("teach:teachAssessMonth:add")
	@Log(title = "月度考核标准", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachAssessMonth teachAssessMonth)
	{
		int result = teachAssessMonthService.insertTeachAssessMonth(teachAssessMonth);
		return toAjax(result);
	}

	/**
	 * 修改月度考核标准
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		TeachAssessMonth teachAssessMonth = teachAssessMonthService.selectTeachAssessMonthListById(id);
		mmap.put("teachAssessMonth", teachAssessMonth);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存月度考核标准
	 */
	@RequiresPermissions("teach:teachAssessMonth:edit")
	@Log(title = "月度考核标准", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachAssessMonth teachAssessMonth)
	{		
		return toAjax(teachAssessMonthService.updateTeachAssessMonth(teachAssessMonth));
	}
	
	/**
	 * 删除月度考核标准
	 */
	@RequiresPermissions("teach:teachAssessMonth:remove")
	@Log(title = "月度考核标准", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teachAssessMonthService.deleteTeachAssessMonthByIds(ids));
	}
	
}
