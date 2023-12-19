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
import edu.fosu.teach.domain.TeachSubject;
import edu.fosu.teach.service.ITeachSubjectService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 班级项目 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/teachSubject")
public class TeachSubjectController extends BaseController
{
    private String prefix = "teach/teachSubject";
	
	@Autowired
	private ITeachSubjectService teachSubjectService;

	@Autowired
	private TeachClassesController teachClassesController = SpringUtils.getBean(TeachClassesController.class);

	@Autowired
	private ISysUserService sysUserService;

	@Autowired
	private ITeachMajorService teachMajorService;


	@RequiresPermissions("teach:teachSubject:view")
	@GetMapping()
	public String teachSubject(ModelMap mmap)
	{
		TeachMajor major = new TeachMajor();
		List<TeachMajor> list2 = teachMajorService.selectTeachMajorList(major);
		mmap.put("major", list2);
		return prefix + "/teachSubject";
	}
	
	/**
	 * 查询班级项目列表
	 */
	@RequiresPermissions("teach:teachSubject:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachSubject teachSubject)
	{
		String[] strs1 =teachClassesController.getClasses();
		teachSubject.setClasses(strs1);
		startPage();
        List<TeachSubject> list = teachSubjectService.selectTeachSubjectList(teachSubject);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出班级项目列表
	 */
	@RequiresPermissions("teach:teachSubject:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachSubject teachSubject)
    {
    	List<TeachSubject> list = teachSubjectService.selectTeachSubjectList(teachSubject);
        ExcelUtil<TeachSubject> util = new ExcelUtil<TeachSubject>(TeachSubject.class);
        return util.exportExcel(list, "teachSubject");
    }
	
	/**
	 * 新增班级项目
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{int userno = ShiroUtils.getUserId().intValue();
		String roleNo = sysUserService.selectUserRoleGroup2(new Long((long)userno));
		if("9".equals(roleNo) || "1".equals(roleNo) || "11".equals(roleNo) || "8".equals(roleNo)){
			mmap.put("quanxian",0);
		}else {
			mmap.put("quanxian",1);
		}
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存班级项目
	 */
	@RequiresPermissions("teach:teachSubject:add")
	@Log(title = "班级项目", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachSubject teachSubject)
	{		
		return toAjax(teachSubjectService.insertTeachSubject(teachSubject));
	}

	/**
	 * 修改班级项目
	 */
	@GetMapping("/edit/{subjectId}")
	public String edit(@PathVariable("subjectId") Integer subjectId, ModelMap mmap)
	{
		TeachSubject teachSubject = teachSubjectService.selectTeachSubjectById(subjectId);
		mmap.put("teachSubject", teachSubject);
	    return prefix + "/edit";
	}

	/**
	 * 班级项目详情
	 */
	@RequiresPermissions("teach:teachSubject:detail")
	@GetMapping("/detail/{subjectId}")
	public String detail(@PathVariable("subjectId") Integer subjectId, ModelMap mmap)
	{
		TeachSubject teachSubject = teachSubjectService.selectTeachSubjectById(subjectId);
		mmap.put("teachSubject", teachSubject);
		return prefix + "/detail";
	}
	
	/**
	 * 修改保存班级项目
	 */
	@RequiresPermissions("teach:teachSubject:edit")
	@Log(title = "班级项目", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachSubject teachSubject)
	{		
		return toAjax(teachSubjectService.updateTeachSubject(teachSubject));
	}
	
	/**
	 * 删除班级项目
	 */
	@RequiresPermissions("teach:teachSubject:remove")
	@Log(title = "班级项目", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teachSubjectService.deleteTeachSubjectByIds(ids));
	}
	
}
