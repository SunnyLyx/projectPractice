package edu.fosu.teach.domain;

import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;

    
/**
 * 班级出勤率统计表 teach_class_attendance
 *  */
public class TeachClassAttendance extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	@Id
	private Integer id;
	/** 班级ID */
	private String classId;
	/** 老师ID */
	private String teacherId;

	/**
	 * 班级名称
	 */
	private String className;
	/**
	 * 老师名称
	 */
	private String teacherName;
	/** 考勤时间 */
	private Date attendanceDatetime;
	/** 考勤教室 */
	private String classroom;
	/** 考勤专业 */
	private String lesson;
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

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setClassId(String classId) 
	{
		this.classId = classId;
	}

	public String getClassId() 
	{
		return classId;
	}
	public void setTeacherId(String teacherId) 
	{
		this.teacherId = teacherId;
	}

	public String getTeacherId() 
	{
		return teacherId;
	}
	public void setAttendanceDatetime(Date attendanceDatetime) 
	{
		this.attendanceDatetime = attendanceDatetime;
	}

	public Date getAttendanceDatetime() 
	{
		return attendanceDatetime;
	}
	public void setClassroom(String classroom) 
	{
		this.classroom = classroom;
	}

	public String getClassroom() 
	{
		return classroom;
	}
	public void setLesson(String lesson) 
	{
		this.lesson = lesson;
	}

	public String getLesson() 
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

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("classId", getClassId())
            .append("teacherId", getTeacherId())
            .append("attendanceDatetime", getAttendanceDatetime())
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
}
