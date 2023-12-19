package edu.fosu.web.controller.teach;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import edu.fosu.common.utils.StringUtils;
import edu.fosu.teach.domain.Student;
import edu.fosu.teach.mapper.StudentMapper;
import edu.fosu.teach.service.IStudentService;
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
import edu.fosu.teach.domain.TeachFileCollection;
import edu.fosu.teach.service.ITeachFileCollectionService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 学生档案收集 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/teachFileCollection")
public class TeachFileCollectionController extends BaseController
{
    private String prefix = "teach/teachFileCollection";
	
	@Autowired
	private ITeachFileCollectionService teachFileCollectionService;

	@Autowired
	private IStudentService studentService;

	@Autowired
	private StudentMapper studentMapper;
	
	@RequiresPermissions("teach:teachFileCollection:view")
	@GetMapping()
	public String teachFileCollection()
	{
	    return prefix + "/teachFileCollection";
	}
	
	/**
	 * 查询学生档案收集列表
	 */
	@RequiresPermissions("teach:teachFileCollection:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeachFileCollection teachFileCollection)
	{
		startPage();
        List<TeachFileCollection> list = teachFileCollectionService.selectTeachFileCollectionList(teachFileCollection);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出学生档案收集列表
	 */
	@RequiresPermissions("teach:teachFileCollection:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachFileCollection teachFileCollection)
    {
    	List<TeachFileCollection> list = teachFileCollectionService.selectTeachFileCollectionList(teachFileCollection);
        ExcelUtil<TeachFileCollection> util = new ExcelUtil<TeachFileCollection>(TeachFileCollection.class);
        return util.exportExcel(list, "teachFileCollection");
    }
	
	/**
	 * 新增学生档案收集
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存学生档案收集
	 */
	@RequiresPermissions("teach:teachFileCollection:add")
	@Log(title = "学生档案收集", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeachFileCollection teachFileCollection)
	{		
		return toAjax(teachFileCollectionService.insertTeachFileCollection(teachFileCollection));
	}

	/**
	 * 修改学生档案收集
	 */
	@GetMapping("/edit/{studentId}")
	public String edit(@PathVariable("studentId") Integer studentId, ModelMap mmap)
	{
		TeachFileCollection teachFileCollection = teachFileCollectionService.selectTeachFileCollectionById(studentId);
		mmap.put("teachFileCollection", teachFileCollection);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存学生档案收集
	 */
	@RequiresPermissions("teach:teachFileCollection:edit")
	@Log(title = "学生档案收集", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeachFileCollection teachFileCollection)
	{		
		return toAjax(teachFileCollectionService.updateTeachFileCollection(teachFileCollection));
	}
	
	/**
	 * 删除学生档案收集
	 */
	@RequiresPermissions("teach:teachFileCollection:remove")
	@Log(title = "学生档案收集", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teachFileCollectionService.deleteTeachFileCollectionByIds(ids));
	}

	//查看详情
	@RequiresPermissions("teach:teachFileCollection:detail")
	@GetMapping("/detail/{studentId}")
	public String detail(@PathVariable("studentId") Integer studentId, ModelMap mmap)
	{
		mmap.put("teachFileCollection", teachFileCollectionService.selectTeachFileCollectionById(studentId));
		return prefix + "/detail";
	}

	@RequiresPermissions("teach:teachFileCollection:updateAudit")
	@Log(title = "审批通过", businessType = BusinessType.UPDATE)
	@PostMapping("/updateAudit")
	@ResponseBody
	public AjaxResult updateAudit(TeachFileCollection teachFileCollection)
	{
		TeachFileCollection collection = teachFileCollectionService.selectTeachFileCollectionById(teachFileCollection.getStudentId());
		String kgcUid = collection.getKgcUid(); //课工场UID
		if(kgcUid != null && !"".equals(kgcUid)){
			int result = teachFileCollectionService.updateTeachFileCollection(teachFileCollection);
			if(result > 0){
				String name = collection.getStudentName(); //学生姓名
				//String time = collection.getExtend3(); //创建时间
				Integer base = collection.getBase(); //是否有基础
				Integer nature = collection.getDegreeInNature(); //学历性质
				Integer education = collection.getEducation(); //学历
				Integer english = collection.getEnglishLevel(); //英语水平
				Integer jobCity = collection.getJobCity(); //就业意向城市
				Integer status = collection.getStatus(); //状态
				Integer gender = collection.getStudentSex(); //性别
				String address = collection.getAddress(); //地址
				Integer classId = collection.getClassNo(); //班级编号
				String contact = collection.getEmergencyContact(); //与紧急联络人的关系
				String contactPhone = collection.getEmergencyContactPhone(); //紧急联系人电话
				String extend2 = collection.getExtend2(); //备注
				String graduateDate = collection.getGraduateDate(); //毕业时间
				String graduateInstitutions = collection.getGraduateInstitutions(); //毕业院校
				String idCardNo = collection.getIdCardNo(); //身份证
				String kgcNickname = collection.getKgcNickname(); //课工场昵称
				String kgcNo = collection.getKgcNo(); //课工场编号
				//String kgcUid = collection.getKgcUid(); //课工场UID
				String mail = collection.getMail(); //邮箱
				String major = collection.getMajor(); //学前专业
				String nativePlace = collection.getNativePlace(); //籍贯
				String phone = collection.getPhone(); //手机号
				String postalCode = collection.getPostalCode(); //邮政编码
				String postname = collection.getPostname(); //学生项目的地址
				String startTime = collection.getStartTime(); //进班时间
				String studentNamePinyin = collection.getStudentNamePinyin(); //学生姓名拼音
				String textbookNo = collection.getTextbookNo(); //教材编号
				String trafficPermit = collection.getTrafficPermit(); //通行证
				String workExperience = collection.getWorkExperience(); //学前工作经历
				Integer extend1 = collection.getExtend1();  //学生来源
				Student student = new Student();
				student.setStudentName(name);
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				// new Date()为获取当前系统时间
				student.setExtend3(df.format(new Date()));
				student.setBase(base);
				student.setDegreeInNature(nature);
				student.setEducation(education);
				student.setEnglishLevel(english);
				student.setJobCity(jobCity);
				student.setStatus(status);
				student.setStudentSex(gender);
				student.setAddress(address);
				student.setClassNo(classId);
				student.setEmergencyContact(contact);
				student.setEmergencyContactPhone(contactPhone);
				student.setExtend2(extend2);
				student.setGraduateDate(graduateDate);
				student.setGraduateInstitutions(graduateInstitutions);
				student.setIdCardNo(idCardNo);
				student.setKgcNickname(kgcNickname);
				student.setKgcNo(kgcNo);
				student.setKgcUid(kgcUid);
				student.setMail(mail);
				student.setMajor(major);
				student.setNativePlace(nativePlace);
				student.setPhone(phone);
				student.setPostalCode(postalCode);
				student.setPostname(postname);
				student.setStartTime(startTime);
				student.setStudentNamePinyin(studentNamePinyin);
				student.setTextbookNo(textbookNo);
				student.setTrafficPermit(trafficPermit);
				student.setWorkExperience(workExperience);
				student.setExtend1(extend1);
				String outcomes = studentService.checkKgcUnique(student);
				if(outcomes == "1"){
					TeachFileCollection fileCollection = new TeachFileCollection();
					fileCollection.setStudentId(teachFileCollection.getStudentId());
					fileCollection.setExtend5(0);
					teachFileCollectionService.updateTeachFileCollection(fileCollection);
					AjaxResult json = new AjaxResult();
					json.put("code", 1);
					json.put("msg", "该学生此专业已存在！");
					return json;
				}else {
					int res = studentService.insertStudent(student);
				}
			}
			return toAjax(result);
		}else {
			AjaxResult json = new AjaxResult();
			json.put("code", 1);
			json.put("msg", "请完善必填信息！");
			return json;
		}
	}
}
