package edu.fosu.teach.domain;


import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;

/**
 * 班级考勤表 teach_attendance
 *  */
public class TeachAttendance extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 考勤ID */
	@Id
	private Integer attendanceId;
	/** 班级编号 */
	private Integer classId;
	/** 上课老师编号 */
	private Integer teacherId;
	/** 考勤日期 */
	private String attendanceDatetime;
	private String startDatetime;
	private String endDatetime;
	/** 考勤时段 */
	private String attendancePeriod;
	/** 教室 */
	private String classroom;
	/** 课程编号 */
	private Integer lesson;

	/**
	 * 子表数据
	 */
	private Object aaaa;

	/**
	 * 班级名称
	 */
	private String className;
	/**
	 * 老师名称
	 */
	private String teacherName;
	/**
	 * 分部名称
	 */
	private String schoolName;
	/**
	 * 专业名称
	 */
	private String majorName;
	/** 正常出勤人数 */
	private Integer attendancenum;
	/** 请假人数 */
	private Integer leavenum;
	/** 旷课人数 */
	private Integer truancynum;
	/** 迟到人数 */
	private Integer latenum;
	/** 早退人数 */
	private Integer leaveearlynum;
	/** 班级总人数 */
	private Integer studentnum;
	/** 班级正常出勤率 */
	private String classAttendance;
	private String[] classes;
	/** 所属专业ID */
	private Integer majorId;

	public void setAttendanceId(Integer attendanceId)
	{
		this.attendanceId = attendanceId;
	}

	public Integer getAttendanceId()
	{
		return attendanceId;
	}
	public void setClassId(Integer classId) 
	{
		this.classId = classId;
	}

	public Integer getClassId() 
	{
		return classId;
	}
	public void setTeacherId(Integer teacherId) 
	{
		this.teacherId = teacherId;
	}

	public Integer getTeacherId() 
	{
		return teacherId;
	}
	public void setAttendanceDatetime(String attendanceDatetime)
	{
		this.attendanceDatetime = attendanceDatetime;
	}

	public String getAttendanceDatetime()
	{
		return attendanceDatetime;
	}
	public void setAttendancePeriod(String attendancePeriod) 
	{
		this.attendancePeriod = attendancePeriod;
	}

	public String getAttendancePeriod() 
	{
		return attendancePeriod;
	}
	public void setClassroom(String classroom) 
	{
		this.classroom = classroom;
	}

	public String getClassroom() 
	{
		return classroom;
	}
	public void setLesson(Integer lesson) 
	{
		this.lesson = lesson;
	}

	public Integer getLesson() 
	{
		return lesson;
	}
	public void setAttendancenum(Integer attendancenum)
	{
		this.attendancenum = attendancenum;
	}

	public Integer getAttendancenum()
	{
		return attendancenum;
	}
	public void setLeavenum(Integer leavenum)
	{
		this.leavenum = leavenum;
	}

	public Integer getLeavenum()
	{
		return leavenum;
	}
	public void setTruancynum(Integer truancynum)
	{
		this.truancynum = truancynum;
	}

	public Integer getTruancynum()
	{
		return truancynum;
	}
	public void setLatenum(Integer latenum)
	{
		this.latenum = latenum;
	}

	public Integer getLatenum()
	{
		return latenum;
	}
	public void setLeaveearlynum(Integer leaveearlynum)
	{
		this.leaveearlynum = leaveearlynum;
	}

	public Integer getLeaveearlynum()
	{
		return leaveearlynum;
	}
	public void setStudentnum(Integer studentnum)
	{
		this.studentnum = studentnum;
	}

	public Integer getStudentnum()
	{
		return studentnum;
	}

	public String getClassAttendance() {
		return classAttendance;
	}

	public void setClassAttendance(String classAttendance) {
		this.classAttendance = classAttendance;
	}

    @Override
	public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("attendanceId", getAttendanceId())
            .append("classId", getClassId())
            .append("teacherId", getTeacherId())
            .append("attendanceDatetime", getAttendanceDatetime())
            .append("attendancePeriod", getAttendancePeriod())
            .append("classroom", getClassroom())
            .append("lesson", getLesson())
				.append("attendancenum", getAttendancenum())
				.append("leavenum", getLeavenum())
				.append("truancynum", getTruancynum())
				.append("latenum", getLatenum())
				.append("leaveearlynum", getLeaveearlynum())
				.append("studentnum", getStudentnum())
				.append("classAttendance", getClassAttendance())
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

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
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

	public String getStartDatetime() {
		return startDatetime;
	}

	public void setStartDatetime(String startDatetime) {
		this.startDatetime = startDatetime;
	}

	public String getEndDatetime() {
		return endDatetime;
	}

	public void setEndDatetime(String endDatetime) {
		this.endDatetime = endDatetime;
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
