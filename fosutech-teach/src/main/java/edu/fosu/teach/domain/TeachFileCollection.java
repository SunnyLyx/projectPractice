package edu.fosu.teach.domain;

import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;

    
/**
 * 学生档案收集表 teach_file_collection
 *  */
public class TeachFileCollection extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 学生ID */
	@Id
	private Integer studentId;
	/** 课工场账号 */
	private String kgcNo;
	/** 课工场uid */
	private String kgcUid;
	/** 课工场昵称 */
	private String kgcNickname;
	/** 状态 */
	private Integer status;
	/** 进班时间(报档时间) */
	private String startTime;
	/** 学生项目的地址 */
	private String postname;
	/** 学生姓名 */
	private String studentName;
	/** 学生性别 */
	private Integer studentSex;
	/** 籍贯 */
	private String nativePlace;
	/** 身份证号 */
	private String idCardNo;
	/** 学历 */
	private Integer education;
	/** 电话 */
	private String phone;
	/** 邮箱 */
	private String mail;
	/** 家庭地址 */
	private String address;
	/** 班级编号 */
	private Integer classNo;
	/** 学生来源 */
	private Integer extend1;
	/** 备注 */
	private String extend2;
	/** 创建时间 */
	private String extend3;
	/** 毕业院校 */
	private String graduateInstitutions;
	/** 学前工作经历 */
	private String workExperience;
	/** 是否有基础（0，无；1，有） */
	private Integer base;
	/** 英语水平(编号) */
	private Integer englishLevel;
	/** 学历性质 */
	private Integer degreeInNature;
	/** 毕业时间 */
	private String graduateDate;
	/** 专业 */
	private String major;
	/** 时间 */
	private String upTime;
	/** 与紧急联络人的关系 */
	private String emergencyContact;
	/** 紧急联系人电话 */
	private String emergencyContactPhone;
	/** 就业意向城市（编号） */
	private Integer jobCity;
	/** 教材编号 */
	private String textbookNo;
	/** 通行证 */
	private String trafficPermit;
	/** 邮政编码 */
	private String postalCode;
	/** 学生姓名拼音 */
	private String studentNamePinyin;
	/** 班级名称 */
	private String extend4;
	/** 是否通过 */
	private Integer extend5;
	/* 班级名称 */
	private String className;
	/* 修改时间 */
	private String modifyTime;
	/* 创建人 */
	private Integer createUser;
	/* 修改人 */
	private Integer modifyUser;

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Integer getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}

	public Integer getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(Integer modifyUser) {
		this.modifyUser = modifyUser;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
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
	public void setEducation(Integer education) 
	{
		this.education = education;
	}

	public Integer getEducation() 
	{
		return education;
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
	public void setUpTime(String upTime) 
	{
		this.upTime = upTime;
	}

	public String getUpTime() 
	{
		return upTime;
	}
	public void setEmergencyContact(String emergencyContact) 
	{
		this.emergencyContact = emergencyContact;
	}

	public String getEmergencyContact() 
	{
		return emergencyContact;
	}
	public void setEmergencyContactPhone(String emergencyContactPhone) 
	{
		this.emergencyContactPhone = emergencyContactPhone;
	}

	public String getEmergencyContactPhone() 
	{
		return emergencyContactPhone;
	}
	public void setJobCity(Integer jobCity) 
	{
		this.jobCity = jobCity;
	}

	public Integer getJobCity() 
	{
		return jobCity;
	}
	public void setTextbookNo(String textbookNo) 
	{
		this.textbookNo = textbookNo;
	}

	public String getTextbookNo() 
	{
		return textbookNo;
	}
	public void setTrafficPermit(String trafficPermit) 
	{
		this.trafficPermit = trafficPermit;
	}

	public String getTrafficPermit() 
	{
		return trafficPermit;
	}
	public void setPostalCode(String postalCode) 
	{
		this.postalCode = postalCode;
	}

	public String getPostalCode() 
	{
		return postalCode;
	}
	public void setStudentNamePinyin(String studentNamePinyin) 
	{
		this.studentNamePinyin = studentNamePinyin;
	}

	public String getStudentNamePinyin() 
	{
		return studentNamePinyin;
	}
	public void setExtend4(String extend4) 
	{
		this.extend4 = extend4;
	}

	public String getExtend4() 
	{
		return extend4;
	}
	public void setExtend5(Integer extend5)
	{
		this.extend5 = extend5;
	}

	public Integer getExtend5()
	{
		return extend5;
	}

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("studentId", getStudentId())
            .append("kgcNo", getKgcNo())
            .append("kgcUid", getKgcUid())
            .append("kgcNickname", getKgcNickname())
            .append("status", getStatus())
            .append("startTime", getStartTime())
            .append("postname", getPostname())
            .append("studentName", getStudentName())
            .append("studentSex", getStudentSex())
            .append("nativePlace", getNativePlace())
            .append("idCardNo", getIdCardNo())
            .append("education", getEducation())
            .append("phone", getPhone())
            .append("mail", getMail())
            .append("address", getAddress())
            .append("classNo", getClassNo())
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
            .append("upTime", getUpTime())
            .append("emergencyContact", getEmergencyContact())
            .append("emergencyContactPhone", getEmergencyContactPhone())
            .append("jobCity", getJobCity())
            .append("textbookNo", getTextbookNo())
            .append("trafficPermit", getTrafficPermit())
            .append("postalCode", getPostalCode())
            .append("studentNamePinyin", getStudentNamePinyin())
            .append("extend4", getExtend4())
            .append("extend5", getExtend5())
            .toString();
    }
}
