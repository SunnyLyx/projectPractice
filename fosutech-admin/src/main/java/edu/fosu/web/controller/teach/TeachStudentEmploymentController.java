package edu.fosu.web.controller.teach;

import java.util.List;
import java.util.Map;

import edu.fosu.common.utils.spring.SpringUtils;
import edu.fosu.teach.domain.Student;
import edu.fosu.teach.domain.TeachMajor;
import edu.fosu.teach.service.IStudentService;
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
import edu.fosu.teach.domain.TeachStudentEmployment;
import edu.fosu.teach.service.ITeachStudentEmploymentService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 学生就业 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/teachStudentEmployment")
public class TeachStudentEmploymentController extends BaseController
{
    private String prefix = "teach/teachStudentEmployment";
	
	@Autowired
	private ITeachStudentEmploymentService teachStudentEmploymentService;

	@Autowired
    private IStudentService studentService;

	@Autowired
	private ITeachMajorService teachMajorService;

	@Autowired
	private TeachClassesController teachClassesController = SpringUtils.getBean(TeachClassesController.class);
	
	@RequiresPermissions("teach:teachStudentEmployment:view")
	@GetMapping()
	public String teachStudentEmployment(ModelMap mmap)
	{
		TeachMajor major = new TeachMajor();
		List<TeachMajor> list = teachMajorService.selectTeachMajorList(major);
		mmap.put("major", list);
	    return prefix + "/teachStudentEmployment";
	}
	
	/**
	 * 查询学生就业列表
	 */
	@RequiresPermissions("teach:teachStudentEmployment:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachStudentEmployment teachStudentEmployment)
	{
		String[] strs1 =teachClassesController.getClasses();
		teachStudentEmployment.setTeacherClass(strs1);
		startPage();
        List<TeachStudentEmployment> list = teachStudentEmploymentService.selectTeachStudentEmploymentList(teachStudentEmployment);
		return getDataTable(list);
	}

	/**
	 * 查询学生就业列表
	 */
//	@RequiresPermissions("teach:teachStudentEmployment:list")
	@PostMapping("/employment")
	@ResponseBody
	public TeachStudentEmployment employment(Integer studentId)
	{
		TeachStudentEmployment list = teachStudentEmploymentService.selectTeachStudentEmploymentByStudentId(studentId);
		return list;
	}

	/**
	 * 校验学生是否唯一
	 */
	@PostMapping("/schoolIdUnique")
	@ResponseBody
	public String schoolIdUnique(Integer studentId)
	{
		return teachStudentEmploymentService.schoolIdUnique(studentId);
	}
	
	
	/**
	 * 导出学生就业列表
	 */
	@RequiresPermissions("teach:teachStudentEmployment:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachStudentEmployment teachStudentEmployment)
    {
    	List<TeachStudentEmployment> list = teachStudentEmploymentService.selectTeachStudentEmploymentList(teachStudentEmployment);
        ExcelUtil<TeachStudentEmployment> util = new ExcelUtil<TeachStudentEmployment>(TeachStudentEmployment.class);
        return util.exportExcel(list, "teachStudentEmployment");
    }
	
	/**
	 * 新增学生就业
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
        /*Student student = new Student();
        List<Student> list = studentService.selectStudentList(student);
        mmap.put("student", list);*/
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存学生就业
	 */
	@RequiresPermissions("teach:teachStudentEmployment:add")
	@Log(title = "学生就业", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachStudentEmployment teachStudentEmployment)
	{		
		return toAjax(teachStudentEmploymentService.insertTeachStudentEmployment(teachStudentEmployment));
	}

	/**
	 * 修改学生就业
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		TeachStudentEmployment teachStudentEmployment = teachStudentEmploymentService.selectTeachStudentEmploymentById(id);
		mmap.put("teachStudentEmployment", teachStudentEmployment);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存学生就业
	 */
	@RequiresPermissions("teach:teachStudentEmployment:edit")
	@Log(title = "学生就业", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachStudentEmployment teachStudentEmployment)
	{		
		return toAjax(teachStudentEmploymentService.updateTeachStudentEmployment(teachStudentEmployment));
	}
	
	/**
	 * 删除学生就业
	 */
	@RequiresPermissions("teach:teachStudentEmployment:remove")
	@Log(title = "学生就业", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teachStudentEmploymentService.deleteTeachStudentEmploymentByIds(ids));
	}

	/**
	 * 查看详情
	 */
	@RequiresPermissions("teach:teachStudentEmployment:detail")
	@GetMapping("/detail/{id}")
	public String detail(@PathVariable("id") Integer id, ModelMap mmap)
	{
		TeachStudentEmployment teachStudentEmployment = teachStudentEmploymentService.selectTeachStudentEmploymentsById(id);
		mmap.put("teachStudentEmployment", teachStudentEmployment);
		return prefix + "/detail";
	}
	
}
