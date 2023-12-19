package edu.fosu.teach.domain;


import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;

/**
 * 学生档案表 teach_student
 *  */
public class AccpStudent extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	/** 所在班级 */
	//@Excel(name = "班级编号", targetAttr = "className")
	private TeachClasses classes;

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
	@Excel(name = "班级编号")
	private String className;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}


	/** 学生uid */
	@Excel(name = "学生UID")
	private String kgcUid;
	/** 学生姓名 */
	@Excel(name = "学生姓名")
	private String studentName;
	/** 身份证号 */
	@Excel(name = "身份证号")
	private String idCardNo;
	/** 电话 */
	@Excel(name = "手机号码")
	private String phone;
	/** 学历 */
	@Excel(name = "最高学历", readConverterExp = "1=小学,2=初中,3=高中,4=中专,5=中职,6=大专,7=本科,8=硕士,9=博士,10=其他")
	private Integer education;
	/** 毕业院校 */
	@Excel(name = "毕业院校")
	private String graduateInstitutions;
	/** 专业 */
	@Excel(name = "专业")
	private String major;
	/** 学历性质 */
	@Excel(name = "学历性质", readConverterExp = "1=普通,2=成人,3=自考,4=网络")
	private Integer degreeInNature;
	/** 学前工作经历 */
	@Excel(name = "学前经历")
	private String workExperience;
	/** 学生来源 */
	@Excel(name = "学生来源", readConverterExp = "1=升学,2=口碑,3=社招,4=院校")
	private Integer extend1;
	/** 毕业时间 */
	@Excel(name = "最高学历毕业时间")
	private String graduateDate;
	/** 所属专业 */
	/*@Excel(name = "专业名称", targetAttr = "majorName", type = Excel.Type.EXPORT)
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
	}*/
	/** 状态 */
	@Excel(name = "状态", readConverterExp = "1=在读,3=转班,4=退学,5=休学,6=转线上,7=提前就业,8=提前离校不负责就业,9=班级结课")
	private Integer status;
	/** 备注 */
	@Excel(name = "备注")
	private String extend2;
	/** 报档时间 */
	@Excel(name = "进班时间")
	private String startTime;
	/** 学生项目地址 */
	@Excel(name = "学生项目地址")
	private String postname;
	/** 学生性别 */
	@Excel(name = "学生性别", readConverterExp = "0=男,1=女,2=未知")
	private Integer studentSex;
	/** 籍贯 */
	@Excel(name = "籍贯")
	private String nativePlace;
	/** 家庭地址 */
	@Excel(name = "家庭地址")
	private String address;
	/** 与紧急联系人关系 */
	@Excel(name = "与紧急联系人关系")
	private String emergencyContact;
	/** 紧急联系人电话 */
	@Excel(name = "紧急联系人电话")
	private String emergencyContactPhone;
	/** 学生姓名拼音 */
	@Excel(name = "学生姓名拼音")
	private String studentNamePinyin;
	/** 教材编码 */
	@Excel(name = "教材编码")
	private String textbookNo;
	/** 邮政编码 */
	@Excel(name = "邮政编码")
	private String postalCode;
	/** 就业意向城市 */
	@Excel(name = "就业意向城市", readConverterExp = "1=武汉,2=北京,3=上海,4=深圳")
	private Integer jobCity;
	/** 通行证 */
	@Excel(name = "通行证")
	private String trafficPermit;

	public String getKgcUid() {
		return kgcUid;
	}

	public void setKgcUid(String kgcUid) {
		this.kgcUid = kgcUid;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getEducation() {
		return education;
	}

	public void setEducation(Integer education) {
		this.education = education;
	}

	public String getGraduateInstitutions() {
		return graduateInstitutions;
	}

	public void setGraduateInstitutions(String graduateInstitutions) {
		this.graduateInstitutions = graduateInstitutions;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Integer getDegreeInNature() {
		return degreeInNature;
	}

	public void setDegreeInNature(Integer degreeInNature) {
		this.degreeInNature = degreeInNature;
	}

	public String getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}

	public Integer getExtend1() {
		return extend1;
	}

	public void setExtend1(Integer extend1) {
		this.extend1 = extend1;
	}

	public String getGraduateDate() {
		return graduateDate;
	}

	public void setGraduateDate(String graduateDate) {
		this.graduateDate = graduateDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getExtend2() {
		return extend2;
	}

	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getPostname() {
		return postname;
	}

	public void setPostname(String postname) {
		this.postname = postname;
	}

	public Integer getStudentSex() {
		return studentSex;
	}

	public void setStudentSex(Integer studentSex) {
		this.studentSex = studentSex;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getStudentNamePinyin() {
		return studentNamePinyin;
	}

	public void setStudentNamePinyin(String studentNamePinyin) {
		this.studentNamePinyin = studentNamePinyin;
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
}
