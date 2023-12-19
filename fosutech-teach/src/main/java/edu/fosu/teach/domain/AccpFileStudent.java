package edu.fosu.teach.domain;


import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;

/**
 * 学生档案表 teach_student
 *  */
public class AccpFileStudent extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	/** 中心代码 */
	@Excel(name = "中心代码")
	private String centerCode;
	/** 学生学号 */
	@Excel(name = "学生学号")
	private String kgcUid;
	/** 学生姓名 */
	@Excel(name = "学生姓名")
	private String studentName;
	/** 学生姓名拼音 */
	@Excel(name = "学生姓名拼音")
	private String studentNamePinyin;
	/** 学生性别 */
	@Excel(name = "学生性别", readConverterExp = "0=男,1=女,2=未知")
	private Integer studentSex;
	/** 身份证号 */
	@Excel(name = "证件号码")
	private String idCardNo;
	/** 教材编码 */
	@Excel(name = "教材编码")
	private String textbookNo;
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

	/** 班主任姓名 */
	@Excel(name = "班主任姓名")
	private String teacherName;
	/** 状态 */
	@Excel(name = "状态", readConverterExp = "1=在读,3=转班,4=退学,5=休学,6=转线上,7=提前就业,8=提前离校不负责就业,9=班级结课")
	private Integer status;
	/** 已持有证书 */
	@Excel(name = "已持有证书")
	private String certificate;
	/** 学历 */
	@Excel(name = "最高学历", readConverterExp = "1=小学,2=初中,3=高中,4=中专,5=中职,6=大专,7=本科,8=硕士,9=博士,10=其他")
	private Integer education;
	/** 专业 */
	@Excel(name = "专业")
	private String major;
	/** 毕业院校 */
	@Excel(name = "毕业院校")
	private String graduateInstitutions;
	/** 工作状态 */
	@Excel(name = "工作状态")
	private String operatingState;
	/** 工作单位 */
	@Excel(name = "工作单位")
	private String employer;
	/** 工作种类 */
	@Excel(name = "工作种类")
	private String jobScopes;
	/** 电话 */
	@Excel(name = "手机号码")
	private String phone;
	/** 通讯地址 */
	@Excel(name = "通讯地址")
	private String address;
	/** 邮政编码 */
	@Excel(name = "邮政编码")
	private String postalCode;
	/** 就业意向城市 */
	@Excel(name = "就业意向城市", readConverterExp = "1=武汉,2=北京,3=上海,4=深圳")
	private Integer jobCity;
	/** 就业意向职位 */
	@Excel(name = "就业意向职位")
	private String employmentPosition;
	/** 备注 */
	@Excel(name = "备注")
	private String extend2;
	/** 产品编码 */
	@Excel(name = "产品编码")
	private String productId;
	/** 学生类型 */
	@Excel(name = "学生类型")
	private String studentType;
	/** 通行证 */
	@Excel(name = "通行证")
	private String trafficPermit;
	/** 毕业时间 */
	@Excel(name = "最高学历毕业时间")
	private String graduateDate;

	public String getCenterCode() {
		return centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

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

	public String getStudentNamePinyin() {
		return studentNamePinyin;
	}

	public void setStudentNamePinyin(String studentNamePinyin) {
		this.studentNamePinyin = studentNamePinyin;
	}

	public Integer getStudentSex() {
		return studentSex;
	}

	public void setStudentSex(Integer studentSex) {
		this.studentSex = studentSex;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getTextbookNo() {
		return textbookNo;
	}

	public void setTextbookNo(String textbookNo) {
		this.textbookNo = textbookNo;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public Integer getEducation() {
		return education;
	}

	public void setEducation(Integer education) {
		this.education = education;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGraduateInstitutions() {
		return graduateInstitutions;
	}

	public void setGraduateInstitutions(String graduateInstitutions) {
		this.graduateInstitutions = graduateInstitutions;
	}

	public String getOperatingState() {
		return operatingState;
	}

	public void setOperatingState(String operatingState) {
		this.operatingState = operatingState;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getJobScopes() {
		return jobScopes;
	}

	public void setJobScopes(String jobScopes) {
		this.jobScopes = jobScopes;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getEmploymentPosition() {
		return employmentPosition;
	}

	public void setEmploymentPosition(String employmentPosition) {
		this.employmentPosition = employmentPosition;
	}

	public String getExtend2() {
		return extend2;
	}

	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getStudentType() {
		return studentType;
	}

	public void setStudentType(String studentType) {
		this.studentType = studentType;
	}

	public String getTrafficPermit() {
		return trafficPermit;
	}

	public void setTrafficPermit(String trafficPermit) {
		this.trafficPermit = trafficPermit;
	}

	public String getGraduateDate() {
		return graduateDate;
	}

	public void setGraduateDate(String graduateDate) {
		this.graduateDate = graduateDate;
	}
}
