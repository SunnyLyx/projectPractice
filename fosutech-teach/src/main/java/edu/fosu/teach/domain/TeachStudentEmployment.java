package edu.fosu.teach.domain;

import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;

    
/**
 * 学生就业表 teach_student_employment
 *  */
public class TeachStudentEmployment extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 就业编号 */
	@Id
	private Integer id;
	/** 学生编号 */
	private Integer studentId;
	/** 更新时间 */
	private String edittime;
	/** 就业方式 */
	private String employmentWay;
	/** 入职时间 */
	private String hiredate;
	/** 就业城市 */
	private String urbanEmployment;
	/** 单位 */
	private String einheit;
	/** 所属行业 */
	private String industry;
	/** 试用薪资 */
	private Double probationSalary;
	/** 转正薪资 */
	private Double obtainmentSalary;
	/**  */
	private String obligate;
	/** 就业老师 */
	private Integer teacherEmployment;
	/** 就业备注 */
	private String employmentNote;
	/** 就业属实 */
	private Integer employmentIsTrue;
	/** 回访老师 */
	private Integer visitTeacher;
	/** 回访时间 */
	private String visitTime;

	private String studentName;

	private String majorName;

	private String className;

	private Integer majorId;

	private Object children;

	private String[] teacherClass;

	private String employment;

	private String visit;

	public String getEmployment() {
		return employment;
	}

	public void setEmployment(String employment) {
		this.employment = employment;
	}

	public String getVisit() {
		return visit;
	}

	public void setVisit(String visit) {
		this.visit = visit;
	}

	public Object getChildren() {
		return children;
	}

	public void setChildren(Object children) {
		this.children = children;
	}

	public Integer getMajorId() {
		return majorId;
	}

	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getTeacherEmployment() {
		return teacherEmployment;
	}

	public void setTeacherEmployment(Integer teacherEmployment) {
		this.teacherEmployment = teacherEmployment;
	}

	public String getEmploymentNote() {
		return employmentNote;
	}

	public void setEmploymentNote(String employmentNote) {
		this.employmentNote = employmentNote;
	}

	public Integer getEmploymentIsTrue() {
		return employmentIsTrue;
	}

	public void setEmploymentIsTrue(Integer employmentIsTrue) {
		this.employmentIsTrue = employmentIsTrue;
	}

	public Integer getVisitTeacher() {
		return visitTeacher;
	}

	public void setVisitTeacher(Integer visitTeacher) {
		this.visitTeacher = visitTeacher;
	}

	public String getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}

	/** 所属学生 */
	@Excel(name = "学生名称", targetAttr = "studentName", type = Excel.Type.EXPORT)
	private Student student;

	public Student getStudent()
	{
		if (student == null)
		{
			student = new Student();
		}
		return student;
	}

	public void setStudent(Student student)
	{
		this.student = student;
	}


	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setStudentId(Integer studentId) 
	{
		this.studentId = studentId;
	}

	public Integer getStudentId() 
	{
		return studentId;
	}
	public void setEdittime(String edittime)
	{
		this.edittime = edittime;
	}

	public String getEdittime()
	{
		return edittime;
	}
	public void setEmploymentWay(String employmentWay) 
	{
		this.employmentWay = employmentWay;
	}

	public String getEmploymentWay() 
	{
		return employmentWay;
	}
	public void setHiredate(String hiredate)
	{
		this.hiredate = hiredate;
	}

	public String getHiredate()
	{
		return hiredate;
	}
	public void setUrbanEmployment(String urbanEmployment) 
	{
		this.urbanEmployment = urbanEmployment;
	}

	public String getUrbanEmployment() 
	{
		return urbanEmployment;
	}
	public void setEinheit(String einheit) 
	{
		this.einheit = einheit;
	}

	public String getEinheit() 
	{
		return einheit;
	}
	public void setIndustry(String industry) 
	{
		this.industry = industry;
	}

	public String getIndustry() 
	{
		return industry;
	}
	public void setProbationSalary(Double probationSalary) 
	{
		this.probationSalary = probationSalary;
	}

	public Double getProbationSalary() 
	{
		return probationSalary;
	}
	public void setObtainmentSalary(Double obtainmentSalary) 
	{
		this.obtainmentSalary = obtainmentSalary;
	}

	public Double getObtainmentSalary() 
	{
		return obtainmentSalary;
	}
	public void setObligate(String obligate) 
	{
		this.obligate = obligate;
	}

	public String getObligate() 
	{
		return obligate;
	}

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("studentId", getStudentId())
            .append("edittime", getEdittime())
            .append("employmentWay", getEmploymentWay())
            .append("hiredate", getHiredate())
            .append("urbanEmployment", getUrbanEmployment())
            .append("einheit", getEinheit())
            .append("industry", getIndustry())
            .append("probationSalary", getProbationSalary())
            .append("obtainmentSalary", getObtainmentSalary())
            .append("obligate", getObligate())
            .toString();
    }

	public String[] getTeacherClass() {
		return teacherClass;
	}

	public void setTeacherClass(String[] teacherClass) {
		this.teacherClass = teacherClass;
	}
}
