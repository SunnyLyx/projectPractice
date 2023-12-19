package edu.fosu.web.controller.teach;

import java.util.List;

import edu.fosu.framework.util.ShiroUtils;
import edu.fosu.system.domain.SysRole;
import edu.fosu.system.domain.SysUser;
import edu.fosu.system.service.ISysRoleService;
import edu.fosu.system.service.ISysUserService;
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
import edu.fosu.teach.domain.TeachAssessmentCriterion;
import edu.fosu.teach.service.ITeachAssessmentCriterionService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 考核标准 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/teachAssessmentCriterion")
public class TeachAssessmentCriterionController extends BaseController
{
    private String prefix = "teach/teachAssessmentCriterion";
	
	@Autowired
	private ITeachAssessmentCriterionService teachAssessmentCriterionService;

	@Autowired
	private ISysRoleService sysRoleService;

	@Autowired
	private ISysUserService sysUserService;
	
	@RequiresPermissions("teach:teachAssessmentCriterion:view")
	@GetMapping()
	public String teachAssessmentCriterion(ModelMap mmap)
	{
		SysRole role = new SysRole();
		List<SysRole> list = sysRoleService.selectRoleList(role);
		mmap.put("role", list);
	    return prefix + "/teachAssessmentCriterion";
	}
	
	/**
	 * 查询考核标准列表
	 */
	@RequiresPermissions("teach:teachAssessmentCriterion:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachAssessmentCriterion teachAssessmentCriterion)
	{
		int userno = ShiroUtils.getUserId().intValue();
		String roleNo = sysUserService.selectUserRoleGroup2(new Long((long)userno));
		SysUser user = sysUserService.selectUserById(new Long((long)userno));
		if("5".equals(roleNo) || "6".equals(roleNo) || "7".equals(roleNo)){
			if(user.getDeptId() != null){
				teachAssessmentCriterion.setCharacterNo(Integer.parseInt(roleNo));
				teachAssessmentCriterion.setSchoolId(user.getDeptId().intValue());
			}
		}
		if("8".equals(roleNo)){
			if(user.getDeptId() != null){
				teachAssessmentCriterion.setSchoolId(user.getDeptId().intValue());
			}
		}
		startPage();
        List<TeachAssessmentCriterion> list = teachAssessmentCriterionService.selectTeachAssessmentCriterionList(teachAssessmentCriterion);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出考核标准列表
	 */
	@RequiresPermissions("teach:teachAssessmentCriterion:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachAssessmentCriterion teachAssessmentCriterion)
    {
    	List<TeachAssessmentCriterion> list = teachAssessmentCriterionService.selectTeachAssessmentCriterionList(teachAssessmentCriterion);
        ExcelUtil<TeachAssessmentCriterion> util = new ExcelUtil<TeachAssessmentCriterion>(TeachAssessmentCriterion.class);
        return util.exportExcel(list, "teachAssessmentCriterion");
    }
	
	/**
	 * 新增考核标准
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		SysRole role = new SysRole();
		List<SysRole> list = sysRoleService.selectRoleList(role);
		int countNum = teachAssessmentCriterionService.selectCountNum();
		int num = 0;
		if(countNum != 0){
			int result = teachAssessmentCriterionService.selectId();
			if(result != 0){
				num = result+1;
			}
		}else {
			num++;
		}
		mmap.put("assessId",num);
		mmap.put("role", list);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存考核标准
	 */
	@RequiresPermissions("teach:teachAssessmentCriterion:add")
	@Log(title = "考核标准", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachAssessmentCriterion teachAssessmentCriterion)
	{		
		return toAjax(teachAssessmentCriterionService.insertTeachAssessmentCriterion(teachAssessmentCriterion));
	}

	/**
	 * 修改考核标准
	 */
	@GetMapping("/edit/{assessId}")
	public String edit(@PathVariable("assessId") Integer assessId, ModelMap mmap)
	{
		TeachAssessmentCriterion teachAssessmentCriterion = teachAssessmentCriterionService.selectTeachAssessmentCriterionById(assessId);
		SysRole role = new SysRole();
		List<SysRole> list = sysRoleService.selectRoleList(role);
		mmap.put("role", list);
		mmap.put("teachAssessmentCriterion", teachAssessmentCriterion);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存考核标准
	 */
	@RequiresPermissions("teach:teachAssessmentCriterion:edit")
	@Log(title = "考核标准", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachAssessmentCriterion teachAssessmentCriterion)
	{		
		return toAjax(teachAssessmentCriterionService.updateTeachAssessmentCriterion(teachAssessmentCriterion));
	}
	
	/**
	 * 删除考核标准
	 */
	@RequiresPermissions("teach:teachAssessmentCriterion:remove")
	@Log(title = "考核标准", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teachAssessmentCriterionService.deleteTeachAssessmentCriterionByIds(ids));
	}

	/**
	 * 查看详情
	 */
	@RequiresPermissions("teach:teachAssessmentCriterion:detail")
	@GetMapping("/detail/{assessId}")
	public String detail(@PathVariable("assessId") Integer assessId, ModelMap mmap)
	{
		TeachAssessmentCriterion teachAssessmentCriterion = teachAssessmentCriterionService.selectTeachAssessmentCriterionById(assessId);
		/*SysRole role = new SysRole();
		List<SysRole> list = sysRoleService.selectRoleList(role);
		mmap.put("role", list);*/
		mmap.put("teachAssessmentCriterion", teachAssessmentCriterion);
		return prefix + "/detail";
	}
	
}
