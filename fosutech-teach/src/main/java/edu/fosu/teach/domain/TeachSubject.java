package edu.fosu.teach.domain;

import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;

    
/**
 * 班级项目表 teach_subject
 *  */
public class TeachSubject extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 项目id */
	@Id
	private Integer subjectId;
	/** 班级编号 */
	private Integer classId;
	/** 班级名称 */
	private String className;
	/** 项目名称 */
	private String subjectName;
	/** 项目开始时间 */
	private String starttime;
	/** 结束时间 */
	private String endtime;
	/** 子表数据 */
	private Object aaaa;
	/**
	 * 分部名称
	 */
	private String schoolName;
	/**
	 * 专业名称
	 */
	private String majorName;
	/** 作业优人数 */
	private Integer bestnum;
	/** 作业良人数 */
	private Integer goodnum;
	/** 作业差人数 */
	private Integer poornum;
	/** 作业未完成人数 */
	private Integer unfinishednum;
	/** 班级总人数 */
	private Integer studentnum;
	/** 作业优占比 */
	private String bestAttendance;
	private String[] classes;
	/** 所属专业ID */
	private Integer majorId;

	public void setSubjectId(Integer subjectId) 
	{
		this.subjectId = subjectId;
	}

	public Integer getSubjectId() 
	{
		return subjectId;
	}
	public void setClassId(Integer classId) 
	{
		this.classId = classId;
	}

	public Integer getClassId() 
	{
		return classId;
	}
	public void setSubjectName(String subjectName) 
	{
		this.subjectName = subjectName;
	}

	public String getSubjectName() 
	{
		return subjectName;
	}
	public void setStarttime(String starttime)
	{
		this.starttime = starttime;
	}

	public String getStarttime()
	{
		return starttime;
	}
	public void setEndtime(String endtime)
	{
		this.endtime = endtime;
	}

	public String getEndtime()
	{
		return endtime;
	}
	public void setBestnum(Integer bestnum)
	{
		this.bestnum = bestnum;
	}

	public Integer getBestnum()
	{
		return bestnum;
	}
	public void setGoodnum(Integer goodnum)
	{
		this.goodnum = goodnum;
	}

	public Integer getGoodnum()
	{
		return goodnum;
	}
	public void setPoornum(Integer poornum)
	{
		this.poornum = poornum;
	}

	public Integer getPoornum()
	{
		return poornum;
	}
	public void setUnfinishednum(Integer unfinishednum)
	{
		this.unfinishednum = unfinishednum;
	}

	public Integer getUnfinishednum()
	{
		return unfinishednum;
	}
	public void setStudentnum(Integer studentnum)
	{
		this.studentnum = studentnum;
	}

	public Integer getStudentnum()
	{
		return studentnum;
	}
	public void setBestAttendance(String bestAttendance)
	{
		this.bestAttendance = bestAttendance;
	}

	public String getBestAttendance()
	{
		return bestAttendance;
	}

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("subjectId", getSubjectId())
            .append("classId", getClassId())
            .append("subjectName", getSubjectName())
            .append("starttime", getStarttime())
            .append("endtime", getEndtime())
				.append("bestnum", getBestnum())
				.append("goodnum", getGoodnum())
				.append("poornum", getPoornum())
				.append("unfinishednum", getUnfinishednum())
				.append("studentnum", getStudentnum())
				.append("bestAttendance", getBestAttendance())
            .toString();
    }

	public Object getAaaa() {
		return aaaa;
	}

	public void setAaaa(Object aaaa) {
		this.aaaa = aaaa;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
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

	public String[] getClasses() {
		return classes;
	}

	public void setClasses(String[] classes) {
		this.classes = classes;
	}

	public Integer getMajorId() {
		return majorId;
	}

	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}
}
