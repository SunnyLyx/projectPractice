package edu.fosu.web.controller.teach;

import java.util.List;
import java.util.Map;

import edu.fosu.common.utils.DateUtils;
import edu.fosu.common.utils.spring.SpringUtils;
import edu.fosu.framework.util.ShiroUtils;
import edu.fosu.system.service.ISysUserService;
import edu.fosu.teach.service.ITeachClassesTeacherService;
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
import edu.fosu.teach.domain.TeachSatisfaction;
import edu.fosu.teach.service.ITeachSatisfactionService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 满意度 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/teachSatisfaction")
public class TeachSatisfactionController extends BaseController
{
    private String prefix = "teach/teachSatisfaction";
	
	@Autowired
	private ITeachSatisfactionService teachSatisfactionService;

	@Autowired
	private ITeachClassesTeacherService teachClassesTeacherService;

	@Autowired
	private ISysUserService sysUserService;

	@Autowired
	private TeachClassesController teachClassesController = SpringUtils.getBean(TeachClassesController.class);
	
	@RequiresPermissions("teach:teachSatisfaction:view")
	@GetMapping()
	public String teachSatisfaction()
	{
	    return prefix + "/teachSatisfaction";
	}
	
	/**
	 * 查询满意度列表
	 */
	@RequiresPermissions("teach:teachSatisfaction:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachSatisfaction teachSatisfaction)
	{
		int userno = ShiroUtils.getUserId().intValue();
		String roleNo = sysUserService.selectUserRoleGroup2(new Long((long)userno));
		if("5".equals(roleNo) || "6".equals(roleNo) || "7".equals(roleNo)){
			teachSatisfaction.setTeacherId(userno);
		}
		if("8".equals(roleNo)){
			String[] strs1 =teachClassesController.getClasses();
			teachSatisfaction.setTeacherClass(strs1);
		}
		startPage();
        List<TeachSatisfaction> list = teachSatisfactionService.selectTeachSatisfactionList(teachSatisfaction);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出满意度列表
	 */
	@RequiresPermissions("teach:teachSatisfaction:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachSatisfaction teachSatisfaction)
    {
    	List<TeachSatisfaction> list = teachSatisfactionService.selectTeachSatisfactionList(teachSatisfaction);
        ExcelUtil<TeachSatisfaction> util = new ExcelUtil<TeachSatisfaction>(TeachSatisfaction.class);
        return util.exportExcel(list, "teachSatisfaction");
    }


	/**
	 * 根据班级查询老师信息下拉
	 */
	@PostMapping("/classId")
	@ResponseBody
	public TableDataInfo listByClassId(Integer classId)
	{
		List<Map<String,Object>> list = teachClassesTeacherService.selectByClassId(classId) ;
		return getDataTable(list);
	}
	
	/**
	 * 新增满意度
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存满意度
	 */
	@RequiresPermissions("teach:teachSatisfaction:add")
	@Log(title = "满意度", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachSatisfaction teachSatisfaction)
	{
		//获取当前登陆用户
		teachSatisfaction.setCreateBy(ShiroUtils.getLoginName());
		//创建时间
		teachSatisfaction.setCreatetime(DateUtils.getNowDate());
		return toAjax(teachSatisfactionService.insertTeachSatisfaction(teachSatisfaction));
	}

	/**
	 * 修改满意度
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		TeachSatisfaction teachSatisfaction = teachSatisfactionService.selectTeachSatisfactionById(id);

		List<Map<String,Object>> list = teachClassesTeacherService.selectByClassId(teachSatisfaction.getClassId()) ;
		mmap.put("teachSatisfaction", teachSatisfaction);
		mmap.put("teacherList",list);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存满意度
	 */
	@RequiresPermissions("teach:teachSatisfaction:edit")
	@Log(title = "满意度", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachSatisfaction teachSatisfaction)
	{
		teachSatisfaction.setUpdateBy(ShiroUtils.getLoginName());
		teachSatisfaction.setUpdateTime(DateUtils.getNowDate());
		return toAjax(teachSatisfactionService.updateTeachSatisfaction(teachSatisfaction));
	}
	
	/**
	 * 删除满意度
	 */
	@RequiresPermissions("teach:teachSatisfaction:remove")
	@Log(title = "满意度", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teachSatisfactionService.deleteTeachSatisfactionByIds(ids));
	}
	
}
