package edu.fosu.teach.domain;

import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;

    
/**
 * 班级考试表 teach_exam
 *  */
public class TeachExam extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 考试id */
	@Id
	private Integer examId;
	/** 班级编号 */
	private Integer classId;
	/** 班级名称 */
	private String className;
	/** 考试时间 */
	private String datetime;
	/** 及格线 */
	private String cutOffscores;
	/** 监考老师 */
	private Integer invigilator;
	/** 老师姓名 */
	private String teacherName;
	/** 考试地点 */
	private String address;
    /** 考试阶段 */
	private String stageId;
	private Object aaaa;
	/** 阶段 */
	private String stageName;
	/** 分部名称 */
	private String schoolName;
	/** 专业名称 */
	private String majorName;
	/** 考试通过人数 */
	private Integer pass;
	/** 考试未通过人数 */
	private Integer fail;
	/** 班级人数 */
	private Integer studentNum;
	/** 合格率 */
	private String acceptability;

	private Integer majorId;

	private String starttime;

	private String endtime;

	private String[] classes;

	public Integer getMajorId() {
		return majorId;
	}

	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}

	public String getStageId() {
		return stageId;
	}

	public void setStageId(String stageId) {
		this.stageId = stageId;
	}

	public void setExamId(Integer examId) 
	{
		this.examId = examId;
	}

	public Integer getExamId() 
	{
		return examId;
	}
	public void setClassId(Integer classId) 
	{
		this.classId = classId;
	}

	public Integer getClassId() 
	{
		return classId;
	}
	public void setDatetime(String datetime)
	{
		this.datetime = datetime;
	}

	public String getDatetime()
	{
		return datetime;
	}
	public void setCutOffscores(String cutOffscores) 
	{
		this.cutOffscores = cutOffscores;
	}

	public String getCutOffscores() 
	{
		return cutOffscores;
	}
	public void setInvigilator(Integer invigilator)
	{
		this.invigilator = invigilator;
	}

	public Integer getInvigilator()
	{
		return invigilator;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getAddress() 
	{
		return address;
	}
	public void setPass(Integer pass)
	{
		this.pass = pass;
	}

	public Integer getPass()
	{
		return pass;
	}
	public void setFail(Integer fail)
	{
		this.fail = fail;
	}

	public Integer getFail()
	{
		return fail;
	}
	public void setStudentNum(Integer studentNum)
	{
		this.studentNum = studentNum;
	}

	public Integer getStudentNum()
	{
		return studentNum;
	}
	public void setAcceptability(String acceptability)
	{
		this.acceptability = acceptability;
	}

	public String getAcceptability()
	{
		return acceptability;
	}

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("examId", getExamId())
            .append("classId", getClassId())
            .append("datetime", getDatetime())
            .append("cutOffscores", getCutOffscores())
            .append("invigilator", getInvigilator())
            .append("address", getAddress())
            .toString();
    }

	public Object getAaaa() {
		return aaaa;
	}

	public void setAaaa(Object aaaa) {
		this.aaaa = aaaa;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
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

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String[] getClasses() {
		return classes;
	}

	public void setClasses(String[] classes) {
		this.classes = classes;
	}
}
