package edu.fosu.teach.domain;

import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;

    
/**
 * 班级作业表 teach_job
 *  */
public class TeachJob extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 作业编号 */
	@Id
	private Integer jobId;
	/** 班级编号 */
	private Integer classId;
	/** 作业时间 */
	private String datetime;
	/** 阶段章节 */
	private String jobStage;
	/** 作业内容 */
	private String jobContent;
	/** 子表数据 */
	private Object aaaa;
	/** 班级名称 */
	private String className;
	/** 分部名称 */
	private String schoolName;
	/** 专业名称 */
	private String majorName;
	/** 开始时间 */
	private String starttime;
	/** 结束时间 */
	private String endtime;
	/** 作业优人数 */
	private Integer workbestnum;
	/** 作业良人数 */
	private Integer workgoodnum;
	/** 作业差人数 */
	private Integer workpoornum;
	/** 未交人数 */
	private Integer worknosubmitnum;
	/** 班级作业优占比 */
	private Integer studentnum;
	/** 班级作业合格率 */
	private String classHomeworkAttendance;
	private String[] classes;
	/** 所属专业ID */
	private Integer majorId;

	public void setJobId(Integer jobId) 
	{
		this.jobId = jobId;
	}

	public Integer getJobId() 
	{
		return jobId;
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
	public void setJobContent(String jobContent) 
	{
		this.jobContent = jobContent;
	}

	public String getJobContent() 
	{
		return jobContent;
	}
	public void setWorkbestnum(Integer workbestnum)
	{
		this.workbestnum = workbestnum;
	}

	public Integer getWorkbestnum()
	{
		return workbestnum;
	}
	public void setWorkgoodnum(Integer workgoodnum)
	{
		this.workgoodnum = workgoodnum;
	}

	public Integer getWorkgoodnum()
	{
		return workgoodnum;
	}
	public void setWorkpoornum(Integer workpoornum)
	{
		this.workpoornum = workpoornum;
	}

	public Integer getWorkpoornum()
	{
		return workpoornum;
	}
	public void setWorknosubmitnum(Integer worknosubmitnum)
	{
		this.worknosubmitnum = worknosubmitnum;
	}

	public Integer getWorknosubmitnum()
	{
		return worknosubmitnum;
	}
	public void setStudentnum(Integer studentnum)
	{
		this.studentnum = studentnum;
	}

	public Integer getStudentnum()
	{
		return studentnum;
	}
	public void setClassHomeworkAttendance(String classHomeworkAttendance)
	{
		this.classHomeworkAttendance = classHomeworkAttendance;
	}

	public String getClassHomeworkAttendance()
	{
		return classHomeworkAttendance;
	}

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("jobId", getJobId())
            .append("classId", getClassId())
            .append("datetime", getDatetime())
            .append("jobContent", getJobContent())
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

	public String getJobStage() {
		return jobStage;
	}

	public void setJobStage(String jobStage) {
		this.jobStage = jobStage;
	}

	public Integer getMajorId() {
		return majorId;
	}

	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}
}
