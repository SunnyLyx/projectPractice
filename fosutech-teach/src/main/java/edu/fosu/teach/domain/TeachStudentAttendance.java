package edu.fosu.teach.domain;

import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import edu.fosu.system.domain.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;


/**
 * 学生考勤表 teach_student_attendance
 *  */
public class TeachStudentAttendance extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	@Id
	private Integer id;
	/** 考勤表id */
	private Integer attendanceId;
	/** 学生编号 */
	private Integer studentId;
	/** 考勤编号 */
	private Integer attendance;

	private  String studentName;

	private String startTime;

	private String endTime;

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/** 所在班级 */
	@Excel(name = "班级名称", targetAttr = "className", type = Excel.Type.EXPORT)
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

	/** 学生名称 */
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

	/** 考勤 */
	@Excel(name = "考勤", targetAttr = "attendanceId", type = Excel.Type.EXPORT)
	private TeachAttendance teachAttendance;

	public TeachAttendance getTeachAttendance()
	{
		if (teachAttendance == null)
		{
			teachAttendance = new TeachAttendance();
		}
		return teachAttendance;
	}

	public void setTeachAttendance(TeachAttendance teachAttendance)
	{
		this.teachAttendance = teachAttendance;
	}

	/** 用户 */
	@Excel(name = "用户", targetAttr = "userName", type = Excel.Type.EXPORT)
	private SysUser sysUser;

	public SysUser getSysUser()
	{
		if (sysUser == null)
		{
			sysUser = new SysUser();
		}
		return sysUser;
	}

	public void setSysUser(SysUser sysUser)
	{
		this.sysUser = sysUser;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getId()
	{
		return id;
	}
	public void setAttendanceId(Integer attendanceId) 
	{
		this.attendanceId = attendanceId;
	}

	public Integer getAttendanceId() 
	{
		return attendanceId;
	}
	public void setStudentId(Integer studentId) 
	{
		this.studentId = studentId;
	}

	public Integer getStudentId() 
	{
		return studentId;
	}
	public void setAttendance(Integer attendance) 
	{
		this.attendance = attendance;
	}

	public Integer getAttendance() 
	{
		return attendance;
	}

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("attendanceId", getAttendanceId())
            .append("studentId", getStudentId())
            .append("attendance", getAttendance())
            .toString();
    }

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
}
