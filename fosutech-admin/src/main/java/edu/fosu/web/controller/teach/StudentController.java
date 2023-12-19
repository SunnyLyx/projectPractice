package edu.fosu.web.controller.teach;

import java.text.SimpleDateFormat;
import java.util.*;

import edu.fosu.common.utils.FastJsonUtils;
import edu.fosu.common.utils.spring.SpringUtils;
import edu.fosu.framework.util.ShiroUtils;
import edu.fosu.system.service.ISysDictDataService;
import edu.fosu.system.service.ISysUserService;
import edu.fosu.teach.domain.*;
import edu.fosu.teach.service.*;
import net.sf.json.JSONObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import edu.fosu.common.annotation.Log;
import edu.fosu.common.enums.BusinessType;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 学生档案 信息操作处理
 *  */
@Controller
@RequestMapping("/teach/student")
public class StudentController extends BaseController
{
    private String prefix = "teach/student";
	
	@Autowired
	private IStudentService studentService;

	@Autowired
	private ITeachClassesService teachClassesService;

	@Autowired
	private ITeachStudentEmploymentService teachStudentEmploymentService;

	@Autowired
	private ITeachStatusRecordService teachStatusRecordService;

	@Autowired
	private ISysDictDataService sysDictDataService;

	@Autowired
    private ITeachStudentAttendanceService teachStudentAttendanceService;

	@Autowired
	private ISysUserService sysUserService;

	@Autowired
	private TeachClassesController teachClassesController = SpringUtils.getBean(TeachClassesController.class);
	
	@RequiresPermissions("teach:student:view")
	@GetMapping()
	public String student()
	{
		int userno = ShiroUtils.getUserId().intValue();
		String roleNo = sysUserService.selectUserRoleGroup2(new Long((long)userno));
		if("5".equals(roleNo) || "6".equals(roleNo) || "7".equals(roleNo) || "8".equals(roleNo)){
			return prefix + "/student1";
		}else{
			return prefix + "/student";
		}
	}
	
	/**
	 * 查询学生档案列表
	 */
	@RequiresPermissions("teach:student:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Student student)
	{
		String[] strs1 =teachClassesController.getClasses();
		student.setTeacherClass(strs1);
		startPage();
        List<Student> list = studentService.selectStudentList(student);
		return getDataTable(list);
	}

	/**
	 * 查询班级在读学生
	 */
	@RequiresPermissions("teach:student:classStudents")
	@PostMapping("/classStudents")
	@ResponseBody
	public TableDataInfo classStudents(Student student)
	{
		List<Student> list = studentService.selectclassStudents(student);
		return getDataTable(list);
	}

	/**
	 * 查询班级异常状态学生
	 */
	@RequiresPermissions("teach:student:classOtherStudents")
	@PostMapping("/classOtherStudents")
	@ResponseBody
	public TableDataInfo classOtherStudents(Student student)
	{
		List<Student> list = studentService.classOtherStudents(student);
		return getDataTable(list);
	}

	/**
	 * 查询班级异常状态学生(不包含“提前就业”、“结课”学生)
	 */
	@RequiresPermissions("teach:student:classOtherStudent")
	@PostMapping("/classOtherStudent")
	@ResponseBody
	public TableDataInfo classOtherStudent(Student student)
	{
		List<Student> list = studentService.classOtherStudent(student);
		return getDataTable(list);
	}

	/**
	 * 选择list
	 */
	@GetMapping("/selectList")
	public String selectList(ModelMap mmap)
	{
		Student student = new Student();
		List<Student> list = studentService.selectStudentList(student);
		mmap.put("student", list);
		return prefix + "/list";
	}

	/**
	 * 查询学生档案列表
	 */
	@RequiresPermissions("teach:student:list")
	@PostMapping("/listById")
	@ResponseBody
	public TableDataInfo listById(Student student)
	{
		startPage();
		List<Student> list = studentService.selectStudentListById(student);
		return getDataTable(list);
	}

	@RequiresPermissions("teach:student:updateState")
//	@Log(title = "更改学生状态", businessType = BusinessType.UPDATE)
	@GetMapping("/updateState/{studentId}")
	public String updateState(@PathVariable("studentId") Integer studentId, ModelMap mmap)
	{
		mmap.put("student", studentService.selectStudentById(studentId));
		return prefix + "/updateState";
	}

	@PostMapping("/updateState")
	@ResponseBody
	public AjaxResult updateStateSave(Student student)
	{
		Integer zhuangtai = student.getStatus();
		if(zhuangtai == 3){
			String status = "换班";
			String oldClass = student.getOldClass();
			String className = student.getClassName();
			TeachStatusRecord teachStatusRecord = new TeachStatusRecord();
			teachStatusRecord.setUserId(Integer.parseInt(ShiroUtils.getUserId().toString()));
			teachStatusRecord.setStudentId(student.getStudentId());
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String createtime = df.format(date);
			teachStatusRecord.setChangeTime(createtime);
			teachStatusRecord.setChangeType(status);
			teachStatusRecord.setChangeContent("从“"+oldClass+"”换到“"+className+"”");
			teachStatusRecord.setUpTime(student.getUpTime());
			int i = teachStatusRecordService.insertTeachStatusRecord(teachStatusRecord);
			zhuangtai = 1;
			student.setStatus(zhuangtai);
		}else if(zhuangtai == 2){
			String state = student.getStatus().toString();
			String status = sysDictDataService.selectDictLabel("teach_status",state);
			TeachStatusRecord teachStatusRecord = new TeachStatusRecord();
			teachStatusRecord.setUserId(Integer.parseInt(ShiroUtils.getUserId().toString()));
			teachStatusRecord.setStudentId(student.getStudentId());
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String createtime = df.format(date);
			teachStatusRecord.setChangeTime(createtime);
			teachStatusRecord.setChangeType("状态变动");
			teachStatusRecord.setChangeContent("“"+status+"”");
			teachStatusRecord.setUpTime(student.getUpTime());
			teachStatusRecordService.insertTeachStatusRecord(teachStatusRecord);
			zhuangtai = 1;
			student.setStatus(zhuangtai);
		}else{
			String state = student.getStatus().toString();
			String status = sysDictDataService.selectDictLabel("teach_status",state);
			TeachStatusRecord teachStatusRecord = new TeachStatusRecord();
			teachStatusRecord.setUserId(Integer.parseInt(ShiroUtils.getUserId().toString()));
			teachStatusRecord.setStudentId(student.getStudentId());
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String createtime = df.format(date);
			teachStatusRecord.setChangeTime(createtime);
			teachStatusRecord.setChangeType("状态变动");
			teachStatusRecord.setChangeContent("更改状态为“"+status+"”");
			teachStatusRecord.setUpTime(student.getUpTime());
			int i = teachStatusRecordService.insertTeachStatusRecord(teachStatusRecord);
		}
		int result = studentService.updateStudent(student);
		return toAjax(result);
	}

	//查看详情
	@RequiresPermissions("teach:student:detail")
	@GetMapping("/detail/{studentId}")
	public String detail(@PathVariable("studentId") Integer studentId, ModelMap mmap)
	{
		TeachStudentEmployment employment = teachStudentEmploymentService.selectTeachStudentEmploymentByStudentId(studentId);
		mmap.put("student", studentService.selectStudentById(studentId));
		mmap.put("employment",employment);
		return prefix + "/detail";
	}

	/**
	 * 校验课工场账号是否唯一
	 */
	@PostMapping("/checkKgcUnique")
	@ResponseBody
	public String checkKgcUnique(Student student)
	{
		return studentService.checkKgcUnique(student);
	}

	/**
	 * 根据班级查询在读学生信息
	 */
	@PostMapping("/listByClassNo")
	@ResponseBody
	public TableDataInfo listByClassNo(Student student)
	{
		startPage();
		List<Map<String,Object>> list = studentService.selectStudentByClassId(student.getClassNo());
		return getDataTable(list);
	}
	
	
	/**
	 * 导出学生档案列表
	 */
	@RequiresPermissions("teach:student:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Student student,String ids)
    {
		System.out.println("export");
		List<Student> list = null;
		if(ids != null){
			list = studentService.selectStudentByIdsAndStudent(ids);
		}else {
			list = studentService.selectStudentList(student);
		}
        ExcelUtil<Student> util = new ExcelUtil<Student>(Student.class);
        return util.exportExcel(list, "学生管理");
    }

	/**
	 * 导出学生档案列表（分类型查询）
	 */
	@GetMapping("/export1")
	public String export1()
	{
		return prefix + "/popout";
	}

	/**
	 * 导出课工场学生档案列表
	 */
	@RequiresPermissions("teach:student:export")
	@PostMapping("/exportKgc")
	@ResponseBody
	public AjaxResult exportKgc(Student student)
	{
		List<KgcStudent> kgcList = null;
		student.setMajorType(student.getNumber());
		if(student.getIds() != null){
			kgcList = new ArrayList<>();
			List<Student> list = studentService.selectStudentByIdsAndStudentAndType(student.getIds(),student.getMajorType());
			for (Student stu:list) {
				KgcStudent kgcStudent = new KgcStudent();
				String className = stu.getClasses().getClassName();//班级编号（名称）
				String kgcUid = stu.getKgcUid();  //课工场uid
				String studentName = stu.getStudentName();  //学生姓名
				String idCardNo = stu.getIdCardNo();  //身份证号
				String phone = stu.getPhone();  //手机号码
				String mail = stu.getMail();  //邮箱
				Integer education = stu.getEducation();  //最高学历
				String graduateInstitutions = stu.getGraduateInstitutions();  //毕业院校
				String major = stu.getMajor();  //专业
				Integer degreeInNature = stu.getDegreeInNature(); //学历性质
				String workExperience = stu.getWorkExperience(); //学前经历
				Integer extend1 = stu.getExtend1(); //学生来源
				Integer englishLevel = stu.getEnglishLevel(); //英语水平
				Integer base = stu.getBase(); //所学专业是否有基础
				String kgcNo = stu.getKgcNo(); //课工场账号
				String kgcNickname = stu.getKgcNickname(); //课工场昵称
				String graduateDate = stu.getGraduateDate(); //最高学历毕业时间
				String majorName = stu.getMajors().getMajorName(); //专业名称
				Integer status = stu.getStatus(); //状态
				String extend2 = stu.getExtend2(); //备注
				String startTime = stu.getStartTime(); //进班时间
				String postname = stu.getPostname(); //学生项目地址
				Integer studentSex = stu.getStudentSex();  //学生性别
				String nativePlace = stu.getNativePlace(); //籍贯
				String address = stu.getAddress();  //家庭地址
				String emergencyContact = stu.getEmergencyContact(); //与紧急联系人关系
				String emergencyContactPhone = stu.getEmergencyContactPhone(); //紧急联系人电话
				kgcStudent.setClassName(className);
				kgcStudent.setKgcUid(kgcUid);
				kgcStudent.setStudentName(studentName);
				kgcStudent.setIdCardNo(idCardNo);
				kgcStudent.setPhone(phone);
				kgcStudent.setMail(mail);
				kgcStudent.setEducation(education);
				kgcStudent.setGraduateInstitutions(graduateInstitutions);
				kgcStudent.setMajor(major);  //大学学的专业
				kgcStudent.setDegreeInNature(degreeInNature);
				kgcStudent.setWorkExperience(workExperience);
				kgcStudent.setExtend1(extend1);
				kgcStudent.setEnglishLevel(englishLevel);
				kgcStudent.setBase(base);
				kgcStudent.setKgcNo(kgcNo);
				kgcStudent.setKgcNickname(kgcNickname);
				kgcStudent.setGraduateDate(graduateDate);
				kgcStudent.setMajorName(majorName);
				kgcStudent.setStatus(status);
				kgcStudent.setExtend2(extend2);
				kgcStudent.setStartTime(startTime);
				kgcStudent.setPostname(postname);
				kgcStudent.setStudentSex(studentSex);
				kgcStudent.setNativePlace(nativePlace);
				kgcStudent.setAddress(address);
				kgcStudent.setEmergencyContact(emergencyContact);
				kgcStudent.setEmergencyContactPhone(emergencyContactPhone);
				kgcList.add(kgcStudent);
			}
		}else {
			kgcList = new ArrayList<>();
			List<Student> list = studentService.selectStudentList(student);
			for (Student stu:list) {
				KgcStudent kgcStudent = new KgcStudent();
				String className = stu.getClasses().getClassName();//班级编号（名称）
				String kgcUid = stu.getKgcUid();  //课工场uid
				String studentName = stu.getStudentName();  //学生姓名
				String idCardNo = stu.getIdCardNo();  //身份证号
				String phone = stu.getPhone();  //手机号码
				String mail = stu.getMail();  //邮箱
				Integer education = stu.getEducation();  //最高学历
				String graduateInstitutions = stu.getGraduateInstitutions();  //毕业院校
				String major = stu.getMajor();  //专业
				Integer degreeInNature = stu.getDegreeInNature(); //学历性质
				String workExperience = stu.getWorkExperience(); //学前经历
				Integer extend1 = stu.getExtend1(); //学生来源
				Integer englishLevel = stu.getEnglishLevel(); //英语水平
				Integer base = stu.getBase(); //所学专业是否有基础
				String kgcNo = stu.getKgcNo(); //课工场账号
				String kgcNickname = stu.getKgcNickname(); //课工场昵称
				String graduateDate = stu.getGraduateDate(); //最高学历毕业时间
				String majorName = stu.getMajors().getMajorName(); //专业名称
				Integer status = stu.getStatus(); //状态
				String extend2 = stu.getExtend2(); //备注
				String startTime = stu.getStartTime(); //进班时间
				String postname = stu.getPostname();  //项目地址
				Integer studentSex = stu.getStudentSex();  //学生性别
				String nativePlace = stu.getNativePlace(); //籍贯
				String address = stu.getAddress();  //家庭地址
				String emergencyContact = stu.getEmergencyContact(); //与紧急联系人关系
				String emergencyContactPhone = stu.getEmergencyContactPhone(); //紧急联系人电话
				kgcStudent.setClassName(className);
				kgcStudent.setKgcUid(kgcUid);
				kgcStudent.setStudentName(studentName);
				kgcStudent.setIdCardNo(idCardNo);
				kgcStudent.setPhone(phone);
				kgcStudent.setMail(mail);
				kgcStudent.setEducation(education);
				kgcStudent.setGraduateInstitutions(graduateInstitutions);
				kgcStudent.setMajor(major);  //大学学的专业
				kgcStudent.setDegreeInNature(degreeInNature);
				kgcStudent.setWorkExperience(workExperience);
				kgcStudent.setExtend1(extend1);
				kgcStudent.setEnglishLevel(englishLevel);
				kgcStudent.setBase(base);
				kgcStudent.setKgcNo(kgcNo);
				kgcStudent.setKgcNickname(kgcNickname);
				kgcStudent.setGraduateDate(graduateDate);
				kgcStudent.setMajorName(majorName);
				kgcStudent.setStatus(status);
				kgcStudent.setExtend2(extend2);
				kgcStudent.setStartTime(startTime);
				kgcStudent.setPostname(postname);
				kgcStudent.setStudentSex(studentSex);
				kgcStudent.setNativePlace(nativePlace);
				kgcStudent.setAddress(address);
				kgcStudent.setEmergencyContact(emergencyContact);
				kgcStudent.setEmergencyContactPhone(emergencyContactPhone);
				kgcList.add(kgcStudent);
			}
		}
		ExcelUtil<KgcStudent> util = new ExcelUtil<KgcStudent>(KgcStudent.class);
		return util.exportExcel(kgcList, "课工场学生信息");
	}

	/**
	 * 导出课工场学生档案列表
	 */
	@RequiresPermissions("teach:student:export")
	@PostMapping("/exportKgcFile")
	@ResponseBody
	public AjaxResult exportKgcFile(Student student)
	{
		List<KgcFileStudent> kgcFileList = null;
		student.setMajorType(student.getNumber());
		if(student.getIds() != null){
			kgcFileList = new ArrayList<>();
			List<Student> list = studentService.selectStudentByIdsAndStudentAndType(student.getIds(),student.getMajorType());
			for (Student stu:list) {
				KgcFileStudent kgcFileStudent = new KgcFileStudent();
				String className = stu.getClasses().getClassName();//班级编号（名称）
				String kgcUid = stu.getKgcUid();  //课工场uid
				String studentName = stu.getStudentName();  //学生姓名
				String idCardNo = stu.getIdCardNo();  //身份证号
				String phone = stu.getPhone();  //手机号码
				String mail = stu.getMail();  //邮箱
				Integer education = stu.getEducation();  //最高学历
				String graduateInstitutions = stu.getGraduateInstitutions();  //毕业院校
				String major = stu.getMajor();  //专业
				Integer degreeInNature = stu.getDegreeInNature(); //学历性质
				String workExperience = stu.getWorkExperience(); //学前经历
				Integer extend1 = stu.getExtend1(); //学生来源
				Integer englishLevel = stu.getEnglishLevel(); //英语水平
				Integer base = stu.getBase(); //所学专业是否有基础
				String extend2 = stu.getExtend2(); //备注
				kgcFileStudent.setClassName(className);
				kgcFileStudent.setKgcUid(kgcUid);
				kgcFileStudent.setStudentName(studentName);
				kgcFileStudent.setIdCardNo(idCardNo);
				kgcFileStudent.setPhone(phone);
				kgcFileStudent.setMail(mail);
				kgcFileStudent.setEducation(education);
				kgcFileStudent.setGraduateInstitutions(graduateInstitutions);
				kgcFileStudent.setMajor(major);  //大学学的专业
				kgcFileStudent.setDegreeInNature(degreeInNature);
				kgcFileStudent.setWorkExperience(workExperience);
				kgcFileStudent.setExtend1(extend1);
				kgcFileStudent.setEnglishLevel(englishLevel);
				kgcFileStudent.setBase(base);
				kgcFileStudent.setExtend2(extend2);
				kgcFileList.add(kgcFileStudent);
			}
		}else {
			kgcFileList = new ArrayList<>();
			List<Student> list = studentService.selectStudentList(student);
			for (Student stu:list) {
				KgcFileStudent kgcFileStudent = new KgcFileStudent();
				String className = stu.getClasses().getClassName();//班级编号（名称）
				String kgcUid = stu.getKgcUid();  //课工场uid
				String studentName = stu.getStudentName();  //学生姓名
				String idCardNo = stu.getIdCardNo();  //身份证号
				String phone = stu.getPhone();  //手机号码
				String mail = stu.getMail();  //邮箱
				Integer education = stu.getEducation();  //最高学历
				String graduateInstitutions = stu.getGraduateInstitutions();  //毕业院校
				String major = stu.getMajor();  //专业
				Integer degreeInNature = stu.getDegreeInNature(); //学历性质
				String workExperience = stu.getWorkExperience(); //学前经历
				Integer extend1 = stu.getExtend1(); //学生来源
				Integer englishLevel = stu.getEnglishLevel(); //英语水平
				Integer base = stu.getBase(); //所学专业是否有基础
				String extend2 = stu.getExtend2(); //备注
				kgcFileStudent.setClassName(className);
				kgcFileStudent.setKgcUid(kgcUid);
				kgcFileStudent.setStudentName(studentName);
				kgcFileStudent.setIdCardNo(idCardNo);
				kgcFileStudent.setPhone(phone);
				kgcFileStudent.setMail(mail);
				kgcFileStudent.setEducation(education);
				kgcFileStudent.setGraduateInstitutions(graduateInstitutions);
				kgcFileStudent.setMajor(major);  //大学学的专业
				kgcFileStudent.setDegreeInNature(degreeInNature);
				kgcFileStudent.setWorkExperience(workExperience);
				kgcFileStudent.setExtend1(extend1);
				kgcFileStudent.setEnglishLevel(englishLevel);
				kgcFileStudent.setBase(base);
				kgcFileStudent.setExtend2(extend2);
				kgcFileList.add(kgcFileStudent);
			}
		}
		ExcelUtil<KgcFileStudent> util = new ExcelUtil<KgcFileStudent>(KgcFileStudent.class);
		return util.exportExcel(kgcFileList, "课工场学生档案信息");
	}

	/**
	 * 导出ACCP学生列表
	 */
	@RequiresPermissions("teach:student:export")
	@PostMapping("/exportAccp")
	@ResponseBody
	public AjaxResult exportAccp(Student student)
	{
		List<AccpStudent> accpStudentList = null;
		student.setMajorType(student.getNumber());
		if(student.getIds() != null){
			accpStudentList = new ArrayList<>();
			List<Student> list = studentService.selectStudentByIdsAndStudentAndType(student.getIds(),student.getMajorType());
			for (Student stu:list) {
				AccpStudent accpStudent = new AccpStudent();
				String className = stu.getClasses().getClassName();//班级编号（名称）
				String kgcUid = stu.getKgcUid();  //课工场uid
				String studentName = stu.getStudentName();  //学生姓名
				String idCardNo = stu.getIdCardNo();  //身份证号
				String phone = stu.getPhone();  //手机号码
				Integer education = stu.getEducation();  //最高学历
				String graduateInstitutions = stu.getGraduateInstitutions();  //毕业院校
				String major = stu.getMajor();  //专业
				Integer degreeInNature = stu.getDegreeInNature(); //学历性质
				String workExperience = stu.getWorkExperience(); //学前经历
				Integer extend1 = stu.getExtend1(); //学生来源
				String graduateDate = stu.getGraduateDate(); //最高学历毕业时间
				Integer status = stu.getStatus(); //状态
				String extend2 = stu.getExtend2(); //备注
				String startTime = stu.getStartTime(); //进班时间
				String postname = stu.getPostname(); //学生项目地址
				Integer studentSex = stu.getStudentSex(); //学生性别
				String nativePlace = stu.getNativePlace(); //籍贯
				String address = stu.getAddress(); //家庭地址
				String emergencyContact = stu.getEmergencyContact(); //与紧急联系人关系
				String emergencyContactPhone = stu.getEmergencyContactPhone(); //紧急联系人电话
				String studentNamePinyin = stu.getStudentNamePinyin();  //学生姓名拼音
				String textbookNo = stu.getTextbookNo(); //教材编码
				String postalCode = stu.getPostalCode(); //邮政编码
				Integer jobCity = stu.getJobCity();  //就业意向城市
				String trafficPermit = stu.getTrafficPermit();  //通行证
				accpStudent.setClassName(className);
				accpStudent.setKgcUid(kgcUid);
				accpStudent.setStudentName(studentName);
				accpStudent.setIdCardNo(idCardNo);
				accpStudent.setPhone(phone);
				accpStudent.setEducation(education);
				accpStudent.setGraduateInstitutions(graduateInstitutions);
				accpStudent.setMajor(major);  //大学学的专业
				accpStudent.setDegreeInNature(degreeInNature);
				accpStudent.setWorkExperience(workExperience);
				accpStudent.setExtend1(extend1);
				accpStudent.setGraduateDate(graduateDate);
				accpStudent.setStatus(status);
				accpStudent.setExtend2(extend2);
				accpStudent.setStartTime(startTime);
				accpStudent.setPostname(postname);
				accpStudent.setStudentSex(studentSex);
				accpStudent.setNativePlace(nativePlace);
				accpStudent.setAddress(address);
				accpStudent.setEmergencyContact(emergencyContact);
				accpStudent.setEmergencyContactPhone(emergencyContactPhone);
				accpStudent.setStudentNamePinyin(studentNamePinyin);
				accpStudent.setTextbookNo(textbookNo);
				accpStudent.setPostalCode(postalCode);
				accpStudent.setJobCity(jobCity);
				accpStudent.setTrafficPermit(trafficPermit);
				accpStudentList.add(accpStudent);
			}
		}else {
			accpStudentList = new ArrayList<>();
			List<Student> list = studentService.selectStudentList(student);
			for (Student stu:list) {
				AccpStudent accpStudent = new AccpStudent();
				String className = stu.getClasses().getClassName();//班级编号（名称）
				String kgcUid = stu.getKgcUid();  //课工场uid
				String studentName = stu.getStudentName();  //学生姓名
				String idCardNo = stu.getIdCardNo();  //身份证号
				String phone = stu.getPhone();  //手机号码
				Integer education = stu.getEducation();  //最高学历
				String graduateInstitutions = stu.getGraduateInstitutions();  //毕业院校
				String major = stu.getMajor();  //专业
				Integer degreeInNature = stu.getDegreeInNature(); //学历性质
				String workExperience = stu.getWorkExperience(); //学前经历
				Integer extend1 = stu.getExtend1(); //学生来源
				String graduateDate = stu.getGraduateDate(); //最高学历毕业时间
				Integer status = stu.getStatus(); //状态
				String extend2 = stu.getExtend2(); //备注
				String startTime = stu.getStartTime(); //进班时间
				String postname = stu.getPostname(); //学生项目地址
				Integer studentSex = stu.getStudentSex(); //学生性别
				String nativePlace = stu.getNativePlace(); //籍贯
				String address = stu.getAddress(); //家庭地址
				String emergencyContact = stu.getEmergencyContact(); //与紧急联系人关系
				String emergencyContactPhone = stu.getEmergencyContactPhone(); //紧急联系人电话
				String studentNamePinyin = stu.getStudentNamePinyin();  //学生姓名拼音
				String textbookNo = stu.getTextbookNo(); //教材编码
				String postalCode = stu.getPostalCode(); //邮政编码
				Integer jobCity = stu.getJobCity();  //就业意向城市
				String trafficPermit = stu.getTrafficPermit();  //通行证
				accpStudent.setClassName(className);
				accpStudent.setKgcUid(kgcUid);
				accpStudent.setStudentName(studentName);
				accpStudent.setIdCardNo(idCardNo);
				accpStudent.setPhone(phone);
				accpStudent.setEducation(education);
				accpStudent.setGraduateInstitutions(graduateInstitutions);
				accpStudent.setMajor(major);  //大学学的专业
				accpStudent.setDegreeInNature(degreeInNature);
				accpStudent.setWorkExperience(workExperience);
				accpStudent.setExtend1(extend1);
				accpStudent.setGraduateDate(graduateDate);
				accpStudent.setStatus(status);
				accpStudent.setExtend2(extend2);
				accpStudent.setStartTime(startTime);
				accpStudent.setPostname(postname);
				accpStudent.setStudentSex(studentSex);
				accpStudent.setNativePlace(nativePlace);
				accpStudent.setAddress(address);
				accpStudent.setEmergencyContact(emergencyContact);
				accpStudent.setEmergencyContactPhone(emergencyContactPhone);
				accpStudent.setStudentNamePinyin(studentNamePinyin);
				accpStudent.setTextbookNo(textbookNo);
				accpStudent.setPostalCode(postalCode);
				accpStudent.setJobCity(jobCity);
				accpStudent.setTrafficPermit(trafficPermit);
				accpStudentList.add(accpStudent);
			}
		}
		ExcelUtil<AccpStudent> util = new ExcelUtil<AccpStudent>(AccpStudent.class);
		return util.exportExcel(accpStudentList, "ACCP学生信息");
	}

	/**
	 * 导出ACCP学生档案列表
	 */
	@RequiresPermissions("teach:student:export")
	@PostMapping("/exportAccpFile")
	@ResponseBody
	public AjaxResult exportAccpFile(Student student)
	{
		List<AccpFileStudent> accpFileStudentList = null;
		student.setMajorType(student.getNumber());
		if(student.getIds() != null){
			accpFileStudentList = new ArrayList<>();
			List<Student> list = studentService.selectStudentByIdsAndStudentAndType(student.getIds(),student.getMajorType());
			for (Student stu:list) {
				AccpFileStudent accpFileStudent = new AccpFileStudent();
				String className = stu.getClasses().getClassName();//班级编号（名称）
				String kgcUid = stu.getKgcUid();  //课工场uid
				String studentName = stu.getStudentName();  //学生姓名
				String idCardNo = stu.getIdCardNo();  //身份证号
				String phone = stu.getPhone();  //手机号码
				Integer education = stu.getEducation();  //最高学历
				String graduateInstitutions = stu.getGraduateInstitutions();  //毕业院校
				String major = stu.getMajor();  //专业
				String graduateDate = stu.getGraduateDate(); //最高学历毕业时间
				Integer status = stu.getStatus(); //状态
				String extend2 = stu.getExtend2(); //备注
				Integer studentSex = stu.getStudentSex(); //学生性别
				String address = stu.getAddress(); //家庭地址
				String studentNamePinyin = stu.getStudentNamePinyin();  //学生姓名拼音
				String textbookNo = stu.getTextbookNo(); //教材编码
				String postalCode = stu.getPostalCode(); //邮政编码
				Integer jobCity = stu.getJobCity();  //就业意向城市
				String trafficPermit = stu.getTrafficPermit();  //通行证
				accpFileStudent.setClassName(className);
				accpFileStudent.setKgcUid(kgcUid);
				accpFileStudent.setStudentName(studentName);
				accpFileStudent.setIdCardNo(idCardNo);
				accpFileStudent.setPhone(phone);
				accpFileStudent.setEducation(education);
				accpFileStudent.setGraduateInstitutions(graduateInstitutions);
				accpFileStudent.setMajor(major);  //大学学的专业
				accpFileStudent.setGraduateDate(graduateDate);
				accpFileStudent.setStatus(status);
				accpFileStudent.setExtend2(extend2);
				accpFileStudent.setStudentSex(studentSex);
				accpFileStudent.setAddress(address);
				accpFileStudent.setStudentNamePinyin(studentNamePinyin);
				accpFileStudent.setTextbookNo(textbookNo);
				accpFileStudent.setPostalCode(postalCode);
				accpFileStudent.setJobCity(jobCity);
				accpFileStudent.setTrafficPermit(trafficPermit);
				accpFileStudentList.add(accpFileStudent);
			}
		}else {
			accpFileStudentList = new ArrayList<>();
			List<Student> list = studentService.selectStudentList(student);
			for (Student stu:list) {
				AccpFileStudent accpFileStudent = new AccpFileStudent();
				String className = stu.getClasses().getClassName();//班级编号（名称）
				String kgcUid = stu.getKgcUid();  //课工场uid
				String studentName = stu.getStudentName();  //学生姓名
				String idCardNo = stu.getIdCardNo();  //身份证号
				String phone = stu.getPhone();  //手机号码
				Integer education = stu.getEducation();  //最高学历
				String graduateInstitutions = stu.getGraduateInstitutions();  //毕业院校
				String major = stu.getMajor();  //专业
				String graduateDate = stu.getGraduateDate(); //最高学历毕业时间
				Integer status = stu.getStatus(); //状态
				String extend2 = stu.getExtend2(); //备注
				Integer studentSex = stu.getStudentSex(); //学生性别
				String address = stu.getAddress(); //家庭地址
				String studentNamePinyin = stu.getStudentNamePinyin();  //学生姓名拼音
				String textbookNo = stu.getTextbookNo(); //教材编码
				String postalCode = stu.getPostalCode(); //邮政编码
				Integer jobCity = stu.getJobCity();  //就业意向城市
				String trafficPermit = stu.getTrafficPermit();  //通行证
				accpFileStudent.setClassName(className);
				accpFileStudent.setKgcUid(kgcUid);
				accpFileStudent.setStudentName(studentName);
				accpFileStudent.setIdCardNo(idCardNo);
				accpFileStudent.setPhone(phone);
				accpFileStudent.setEducation(education);
				accpFileStudent.setGraduateInstitutions(graduateInstitutions);
				accpFileStudent.setMajor(major);  //大学学的专业
				accpFileStudent.setGraduateDate(graduateDate);
				accpFileStudent.setStatus(status);
				accpFileStudent.setExtend2(extend2);
				accpFileStudent.setStudentSex(studentSex);
				accpFileStudent.setAddress(address);
				accpFileStudent.setStudentNamePinyin(studentNamePinyin);
				accpFileStudent.setTextbookNo(textbookNo);
				accpFileStudent.setPostalCode(postalCode);
				accpFileStudent.setJobCity(jobCity);
				accpFileStudent.setTrafficPermit(trafficPermit);
				accpFileStudentList.add(accpFileStudent);
			}
		}
		ExcelUtil<AccpFileStudent> util = new ExcelUtil<AccpFileStudent>(AccpFileStudent.class);
		return util.exportExcel(accpFileStudentList, "ACCP学生档案信息");
	}
	
	/**
	 * 新增学生档案
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存学生档案
	 */
	@RequiresPermissions("teach:student:add")
	@Log(title = "学生档案", businessType = BusinessType.INSERT)
	@PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
	@ResponseBody
	public AjaxResult addSave(Student student)
	{
		return toAjax(studentService.insertStudent(student));
	}

	/**
	 * 修改学生档案
	 */
	@GetMapping("/edit/{studentId}")
	public String edit(@PathVariable("studentId") Integer studentId, ModelMap mmap)
	{
		Student student = studentService.selectStudentsById(studentId);
//		System.out.println(student);
		mmap.put("student", student);

	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存学生档案
	 */
	@RequiresPermissions("teach:student:edit")
	@Log(title = "学生档案", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
    @Transactional(rollbackFor = Exception.class)
	@ResponseBody
	public AjaxResult editSave(Student student)
	{
//		System.out.println(student.getClassNo());
		int result = studentService.updateStudent(student);
		return toAjax(result);
	}
	
	/**
	 * 删除学生档案
	 */
	@RequiresPermissions("teach:student:remove")
	@Log(title = "学生档案", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(studentService.deleteStudentByIds(ids));
	}

	/**
	 * 导入
	 * @param file
	 * @param updateSupport
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("teach:student:import")
	@PostMapping("/importData")
	@ResponseBody
	public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
	{
		ExcelUtil<Student> util = new ExcelUtil<Student>(Student.class);
		List<Student> userList = util.importExcels(file.getInputStream());
		String operName = getSysUser().getLoginName();
		String message = studentService.importStudent(userList, updateSupport, operName);
		return AjaxResult.success(message);
	}

	@RequiresPermissions("system:user:view")
	@GetMapping("/importTemplate")
	@ResponseBody
	public AjaxResult importTemplate()
	{
		ExcelUtil<Student> util = new ExcelUtil<Student>(Student.class);
		return util.importTemplateExcel("学生信息表模板");
	}
	
}
