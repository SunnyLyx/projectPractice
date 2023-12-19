package edu.fosu.teach.domain;


import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import edu.fosu.system.domain.SysDept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 学生档案表 teach_student
 *  */
public class Student extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 学生ID */
	//@Excel(name = "学生ID")
	private Integer studentId;

	/** 寝室编号 */
	@Excel(name = "项目编号")
	private String dormitory;

	/** 1所在班级 */
	@Excel(name = "班级名称", targetAttr = "className")
	private TeachClasses classes;

	public Student() {
	}

	public TeachClasses getClasses()
	{
		if (classes == null)
		{
			classes = new TeachClasses();
		}
		return classes;
	}

	public void setClasses(TeachClasses classes)
	{
		this.classes = classes;
	}
	/** 2学生姓名 */
	@Excel(name = "姓名")
	private String studentName;

	/** 3学生性别 */
	@Excel(name = "性别", readConverterExp = "0=男,1=女,2=未知")
	private Integer studentSex;

	/** 4民族 */
	@Excel(name = "民族")
	private Integer ethnic;


	/** 5身份证号 */
	@Excel(name = "身份证号")
	private String idCardNo;

	/** 6出生年月 */
	@Excel(name = "出生日期")
	private Date birthday;

	/** 7籍贯 */
	@Excel(name = "生源省")
	private String nativePlace;

	/** 8家庭地址 */
	@Excel(name = "生源市")
	private String studentFatherPhone;

	/** 9学历 */
	@Excel(name = "学历", readConverterExp = "1=小学,2=初中,3=高中,4=中专,5=中职,6=大专,7=本科,8=硕士,9=博士,10=其他")
	private Integer education;

	/** 10家庭地址 */
	@Excel(name = "工作单位")
	private String studentFatherUnit;

	/** 11家庭地址 */
	@Excel(name = "通讯地址")
	private String address;

	/** 12邮政编码 */
	@Excel(name = "邮编")
	private String postalCode;

	/** 13电话 */
	@Excel(name = "电话")
	private String phone;

	/** 14邮箱 */
	@Excel(name = "邮箱")
	private String mail;

	/** 15报档时间 */
	@Excel(name = "开始时间")
	private String startTime;

	/** 16毕业时间 */
	@Excel(name = "结束时间")
	private String graduateDate;

	/** 17学生项目地址 */
	@Excel(name = "学时")
	private String postname;

	/** 18备注 */
	@Excel(name = "出勤率")
	private String studentFatherName;

	/** 19学生姓名拼音 */
	@Excel(name = "任课老师")
	private String studentNamePinyin;

	/** 20通行证 */
	@Excel(name = "班主任")
	private String trafficPermit;

	/** 21毕业院校 */
	@Excel(name = "毕业学校")
	private String graduateInstitutions;

	/** 22专业 */
	@Excel(name = "毕业专业")
	private String major;

	/** 23就业意向城市 */
	@Excel(name = "就业意向")
	private String textbookNo;

	/** 24学前工作经历 */
	@Excel(name = "缴费金额")
	private String workExperience;

	/** 25课工场账号 */
	@Excel(name = "教材版本")
	private String kgcNo;

	/** 26课工场昵称 */
	@Excel(name = "分部代码")
	private String kgcNickname;

	/** 27课工场uid */
	@Excel(name = "学号")
	private String kgcUid;

	/** 与紧急联系人关系 */
	@Excel(name = "准考证号")
	private String emergencyContact;
	/** 紧急联系人电话 */
	@Excel(name = "登录口令")
	private String emergencyContactPhone;

	/** 备注 */
	@Excel(name = "备注")
	private String extend2;

	/** 学历性质 */
//	@Excel(name = "学历性质", readConverterExp = "1=普通,2=成人,3=自考,4=网络")
	private Integer degreeInNature;

	/** 学生来源 */
//	@Excel(name = "学生来源", readConverterExp = "1=升学,2=口碑,3=社招,4=院校")
	private Integer extend1;
	/** 英语水平 */
//	@Excel(name = "英语水平", readConverterExp = "1=零基础,2=初级（学过26个字母等基本知识）,3=中级（系统学过英语，但掌握一般）,4=高级（四级水平）")
	private Integer englishLevel;
	/** 是否有基础（0，无；1，有） */
//	@Excel(name = "所学专业是否有基础", readConverterExp = "1=否,2=是")
	private Integer base;



	/** 所属专业 */
//	@Excel(name = "专业名称", targetAttr = "majorName", type = Excel.Type.EXPORT)
	private TeachMajor majors;

	public TeachMajor getMajors()
	{
		if (majors == null)
		{
			majors = new TeachMajor();
		}
		return majors;
	}

	public void setMajors(TeachMajor majors)
	{
		this.majors = majors;
	}
	/** 状态 */
//	@Excel(name = "状态", readConverterExp = "1=在读,3=转班,4=退学,5=休学,6=转线上,7=提前就业,8=提前离校不负责就业,9=班级结课")
	private Integer status;

	private Integer jobCity;
	/** 政治面貌 */
	private Integer politicsStatus;
	/** qq号码 */
	private String qq;
	/** 生源市 */
	private Integer city;

	/** 班级编号 */
	//@Excel(name = "班级编号", type = Excel.Type.IMPORT)
	private Integer classNo;

	/** 学生父亲电话 */

	/** 学生母亲姓名 */
	private String studentMotherName;
	/** 学生母亲电话 */
	private String studentMotherPhone;
	/** 学生母亲工作单位 */
	private String studentMotherUnit;
	/** 学生家庭其他成员 */
	private String studentAnotherName;
	/** 是否单亲家庭（0，否；1，是） */
	private Integer singleParent;

	/** 时间 */
	private String upTime;

	public String getUpTime() {
		return upTime;
	}

	public void setUpTime(String upTime) {
		this.upTime = upTime;
	}

	/** 创建时间 */
	private String extend3;

	/** 阶段名称 */
	private String stageName;

	private String oldClass;

	private String className;

	private String[] teacherClass;

	private Integer schoolId;

	private int number;

	private String ids;

	private Integer majorType;

	private Integer serial;

	private String[] studentIds;

	public String[] getStudentIds() {
		return studentIds;
	}

	public void setStudentIds(String[] studentIds) {
		this.studentIds = studentIds;
	}

	public Integer getSerial() {
		return serial;
	}

	public void setSerial(Integer serial) {
		this.serial = serial;
	}

	public Integer getMajorType() {
		return majorType;
	}

	public void setMajorType(Integer majorType) {
		this.majorType = majorType;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public String getEmergencyContactPhone() {
		return emergencyContactPhone;
	}

	public void setEmergencyContactPhone(String emergencyContactPhone) {
		this.emergencyContactPhone = emergencyContactPhone;
	}

	public Integer getJobCity() {
		return jobCity;
	}

	public void setJobCity(Integer jobCity) {
		this.jobCity = jobCity;
	}

	public String getTrafficPermit() {
		return trafficPermit;
	}

	public void setTrafficPermit(String trafficPermit) {
		this.trafficPermit = trafficPermit;
	}

	public String getTextbookNo() {
		return textbookNo;
	}

	public void setTextbookNo(String textbookNo) {
		this.textbookNo = textbookNo;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStudentNamePinyin() {
		return studentNamePinyin;
	}

	public void setStudentNamePinyin(String studentNamePinyin) {
		this.studentNamePinyin = studentNamePinyin;
	}

	public String[] getTeacherClass() {
		return teacherClass;
	}

	public void setTeacherClass(String[] teacherClass) {
		this.teacherClass = teacherClass;
	}

	public String getOldClass() {
		return oldClass;
	}

	public void setOldClass(String oldClass) {
		this.oldClass = oldClass;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}



	/**
	 * 阶段
	 */
	private TeachMajorStage majorStage;

	public TeachMajorStage getMajorStage()
	{
		if (majorStage == null)
		{
			majorStage = new TeachMajorStage();
		}
		return majorStage;
	}

	public void setMajorStage(TeachMajorStage majorStage)
	{
		this.majorStage = majorStage;
	}

	/** 所属分部 */
	//@Excel(name = "分部名称", targetAttr = "deptName", type = Excel.Type.EXPORT)
	private SysDept sysDept;

	public SysDept getSysDept()
	{
		if (sysDept == null)
		{
            sysDept = new SysDept();
		}
		return sysDept;
	}

	public void setSysDept(SysDept sysDept)
	{
		this.sysDept = sysDept;
	}



	public void setStudentId(Integer studentId) 
	{
		this.studentId = studentId;
	}

	public Integer getStudentId() 
	{
		return studentId;
	}
	public void setKgcNo(String kgcNo) 
	{
		this.kgcNo = kgcNo;
	}

	public String getKgcNo() 
	{
		return kgcNo;
	}
	public void setKgcUid(String kgcUid) 
	{
		this.kgcUid = kgcUid;
	}

	public String getKgcUid() 
	{
		return kgcUid;
	}
	public void setKgcNickname(String kgcNickname) 
	{
		this.kgcNickname = kgcNickname;
	}

	public String getKgcNickname() 
	{
		return kgcNickname;
	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
	}
	public void setStartTime(String startTime)
	{
		this.startTime = startTime;
	}

	public String getStartTime()
	{
		return startTime;
	}
	public void setPostname(String postname)
	{
		this.postname = postname;
	}

	public String getPostname()
	{
		return postname;
	}
	public void setStudentName(String studentName) 
	{
		this.studentName = studentName;
	}

	public String getStudentName() 
	{
		return studentName;
	}
	public void setStudentSex(Integer studentSex) 
	{
		this.studentSex = studentSex;
	}

	public Integer getStudentSex() 
	{
		return studentSex;
	}
	public void setEthnic(Integer ethnic) 
	{
		this.ethnic = ethnic;
	}

	public Integer getEthnic() 
	{
		return ethnic;
	}
	public void setNativePlace(String nativePlace) 
	{
		this.nativePlace = nativePlace;
	}

	public String getNativePlace() 
	{
		return nativePlace;
	}
	public void setIdCardNo(String idCardNo) 
	{
		this.idCardNo = idCardNo;
	}

	public String getIdCardNo() 
	{
		return idCardNo;
	}
	public void setBirthday(Date birthday) 
	{
		this.birthday = birthday;
	}

	public Date getBirthday() 
	{
		return birthday;
	}
	public void setEducation(Integer education) 
	{
		this.education = education;
	}

	public Integer getEducation() 
	{
		return education;
	}
	public void setPoliticsStatus(Integer politicsStatus) 
	{
		this.politicsStatus = politicsStatus;
	}

	public Integer getPoliticsStatus() 
	{
		return politicsStatus;
	}
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getPhone() 
	{
		return phone;
	}
	public void setMail(String mail) 
	{
		this.mail = mail;
	}

	public String getMail() 
	{
		return mail;
	}
	public void setQq(String qq) 
	{
		this.qq = qq;
	}

	public String getQq() 
	{
		return qq;
	}
	public void setCity(Integer city) 
	{
		this.city = city;
	}

	public Integer getCity() 
	{
		return city;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getAddress() 
	{
		return address;
	}
	public void setClassNo(Integer classNo) 
	{
		this.classNo = classNo;
	}

	public Integer getClassNo() 
	{
		return classNo;
	}
	public void setDormitory(String dormitory) 
	{
		this.dormitory = dormitory;
	}

	public String getDormitory() 
	{
		return dormitory;
	}
	public void setStudentFatherName(String studentFatherName) 
	{
		this.studentFatherName = studentFatherName;
	}

	public String getStudentFatherName() 
	{
		return studentFatherName;
	}
	public void setStudentFatherPhone(String studentFatherPhone) 
	{
		this.studentFatherPhone = studentFatherPhone;
	}

	public String getStudentFatherPhone() 
	{
		return studentFatherPhone;
	}
	public void setStudentFatherUnit(String studentFatherUnit) 
	{
		this.studentFatherUnit = studentFatherUnit;
	}

	public String getStudentFatherUnit() 
	{
		return studentFatherUnit;
	}
	public void setStudentMotherName(String studentMotherName) 
	{
		this.studentMotherName = studentMotherName;
	}

	public String getStudentMotherName() 
	{
		return studentMotherName;
	}
	public void setStudentMotherPhone(String studentMotherPhone) 
	{
		this.studentMotherPhone = studentMotherPhone;
	}

	public String getStudentMotherPhone() 
	{
		return studentMotherPhone;
	}
	public void setStudentMotherUnit(String studentMotherUnit) 
	{
		this.studentMotherUnit = studentMotherUnit;
	}

	public String getStudentMotherUnit() 
	{
		return studentMotherUnit;
	}
	public void setStudentAnotherName(String studentAnotherName) 
	{
		this.studentAnotherName = studentAnotherName;
	}

	public String getStudentAnotherName() 
	{
		return studentAnotherName;
	}
	public void setSingleParent(Integer singleParent) 
	{
		this.singleParent = singleParent;
	}

	public Integer getSingleParent() 
	{
		return singleParent;
	}
	public void setExtend1(Integer extend1)
	{
		this.extend1 = extend1;
	}

	public Integer getExtend1()
	{
		return extend1;
	}
	public void setExtend2(String extend2) 
	{
		this.extend2 = extend2;
	}

	public String getExtend2() 
	{
		return extend2;
	}
	public void setExtend3(String extend3) 
	{
		this.extend3 = extend3;
	}

	public String getExtend3() 
	{
		return extend3;
	}
	public void setGraduateInstitutions(String graduateInstitutions) 
	{
		this.graduateInstitutions = graduateInstitutions;
	}

	public String getGraduateInstitutions() 
	{
		return graduateInstitutions;
	}
	public void setWorkExperience(String workExperience) 
	{
		this.workExperience = workExperience;
	}

	public String getWorkExperience() 
	{
		return workExperience;
	}
	public void setBase(Integer base) 
	{
		this.base = base;
	}

	public Integer getBase() 
	{
		return base;
	}
	public void setEnglishLevel(Integer englishLevel)
	{
		this.englishLevel = englishLevel;
	}

	public Integer getEnglishLevel()
	{
		return englishLevel;
	}
	public void setDegreeInNature(Integer degreeInNature) 
	{
		this.degreeInNature = degreeInNature;
	}

	public Integer getDegreeInNature() 
	{
		return degreeInNature;
	}
	public void setGraduateDate(String graduateDate)
	{
		this.graduateDate = graduateDate;
	}

	public String getGraduateDate()
	{
		return graduateDate;
	}
	public void setMajor(String major) 
	{
		this.major = major;
	}

	public String getMajor() 
	{
		return major;
	}

    @Override
	public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("studentId", getStudentId())
            .append("kgcNo", getKgcNo())
            .append("kgcUid", getKgcUid())
            .append("kgcNickname", getKgcNickname())
            .append("status", getStatus())
            .append("startTime", getStartTime())
            .append("postname", getPostname())
            .append("studentName", getStudentName())
            .append("studentSex", getStudentSex())
            .append("ethnic", getEthnic())
            .append("nativePlace", getNativePlace())
            .append("idCardNo", getIdCardNo())
            .append("birthday", getBirthday())
            .append("education", getEducation())
            .append("politicsStatus", getPoliticsStatus())
            .append("phone", getPhone())
            .append("mail", getMail())
            .append("qq", getQq())
            .append("city", getCity())
            .append("address", getAddress())
            .append("classNo", getClassNo())
            .append("dormitory", getDormitory())
            .append("studentFatherName", getStudentFatherName())
            .append("studentFatherPhone", getStudentFatherPhone())
            .append("studentFatherUnit", getStudentFatherUnit())
            .append("studentMotherName", getStudentMotherName())
            .append("studentMotherPhone", getStudentMotherPhone())
            .append("studentMotherUnit", getStudentMotherUnit())
            .append("studentAnotherName", getStudentAnotherName())
            .append("singleParent", getSingleParent())
            .append("extend1", getExtend1())
            .append("extend2", getExtend2())
            .append("extend3", getExtend3())
            .append("graduateInstitutions", getGraduateInstitutions())
            .append("workExperience", getWorkExperience())
            .append("base", getBase())
            .append("englishLevel", getEnglishLevel())
            .append("degreeInNature", getDegreeInNature())
            .append("graduateDate", getGraduateDate())
            .append("major", getMajor())
            .toString();
    }

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
}
