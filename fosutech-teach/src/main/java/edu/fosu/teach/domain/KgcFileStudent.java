package edu.fosu.teach.domain;


import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;

/**
 * 学生档案表 teach_student
 *  */
public class KgcFileStudent extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	/** 产品uid */
	@Excel(name = "产品UID")
	private String productId;

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


	/** 课工场uid */
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
	/** 邮箱 */
	@Excel(name = "邮箱")
	private String mail;
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
	/** 英语水平 */
	@Excel(name = "英语水平", readConverterExp = "1=零基础,2=初级（学过26个字母等基本知识）,3=中级（系统学过英语，但掌握一般）,4=高级（四级水平）")
	private Integer englishLevel;
	/** 是否有基础（0，无；1，有） */
	@Excel(name = "所学专业是否有基础", readConverterExp = "1=否,2=是")
	private Integer base;
	/** 备注 */
	@Excel(name = "备注")
	private String extend2;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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

	public Integer getEnglishLevel() {
		return englishLevel;
	}

	public void setEnglishLevel(Integer englishLevel) {
		this.englishLevel = englishLevel;
	}

	public Integer getBase() {
		return base;
	}

	public void setBase(Integer base) {
		this.base = base;
	}

	public String getExtend2() {
		return extend2;
	}

	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}
}
