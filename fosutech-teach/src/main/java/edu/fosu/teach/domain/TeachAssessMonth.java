package edu.fosu.teach.domain;


import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import edu.fosu.system.domain.SysDept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;

/**
 * 月度考核标准表 teach_assess_month
 *  */
public class TeachAssessMonth extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 阅读考核标准ID */
	@Id
	private Integer id;
	/** 考核月份 */
	private String assessMonth;
	/** 班级编号 */
	private Integer classId;

	/** 专业编号 */
	private Integer majorId;
	/** 考勤大于等于 */
	private String attendanceOne;
	/** 计算标准 */
	private String attendanceOneStandard;
	/** 考勤大于等于-考勤小于（两个值，中间用-隔开） */
	private String attendanceTwo;
	/** 计算标准 */
	private String attendanceTwoStandard;
	/** 考勤小于 */
	private String attendanceThree;
	/** 计算标准 */
	private String attendanceThreeStandard;
	/** 考试大于等于 */
	private String examOne;
	/** 计算标准 */
	private String examOneStandard;
	/** 考试大于等于-考试小于（两个值，中间用-隔开） */
	private String examTwo;
	/** 计算标准 */
	private String examTwoStandard;
	/** 考试小于 */
	private String examThree;
	/** 计算标准 */
	private String examThreeStandard;
	/** 作业大于等于 */
	private String taskOne;
	/** 计算标准 */
	private String taskOneStandard;
	/** 作业大于等于-作业小于（两个值，中间用-隔开） */
	private String taskTwo;
	/** 计算标准 */
	private String taskTwoStandard;
	/** 作业小于 */
	private String taskThree;
	/** 计算标准 */
	private String taskThreeStandard;
	/** 项目大于等于 */
	private String subjectOne;
	/** 计算标准 */
	private String subjectOneStandard;
	/** 项目大于等于-项目小于（两个值，中间用-隔开） */
	private String subjectTwo;
	/** 计算标准 */
	private String subjectTwoStandard;
	/** 项目小于 */
	private String subjectThree;
	/** 计算标准 */
	private String subjectThreeStandard;

	/**
	 * 班级
	 */
	private String className;

	private String[] teacherClass;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getMajorId() {
		return majorId;
	}

	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}

	/** 所属班级 */
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

	/** 所属分部 */
	@Excel(name = "分部名称", targetAttr = "deptName", type = Excel.Type.EXPORT)
	private SysDept sysDept;

	public SysDept getSysDept()
	{
		if (sysDept == null)
		{
			sysDept = new SysDept();
		}
		return sysDept;
	}

	public void setSysDept(SysDept sysDept)
	{
		this.sysDept = sysDept;
	}

	/** 所属专业 */
	@Excel(name = "专业名称", targetAttr = "majorName", type = Excel.Type.EXPORT)
	private TeachMajor majors;

	public TeachMajor getMajors()
	{
		if (majors == null)
		{
			majors = new TeachMajor();
		}
		return majors;
	}

	public void setMajors(TeachMajor majors)
	{
		this.majors = majors;
	}


	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setAssessMonth(String assessMonth)
	{
		this.assessMonth = assessMonth;
	}

	public String getAssessMonth()
	{
		return assessMonth;
	}
	public void setClassId(Integer classId) 
	{
		this.classId = classId;
	}

	public Integer getClassId() 
	{
		return classId;
	}
	public void setAttendanceOne(String attendanceOne) 
	{
		this.attendanceOne = attendanceOne;
	}

	public String getAttendanceOne() 
	{
		return attendanceOne;
	}
	public void setAttendanceOneStandard(String attendanceOneStandard) 
	{
		this.attendanceOneStandard = attendanceOneStandard;
	}

	public String getAttendanceOneStandard() 
	{
		return attendanceOneStandard;
	}
	public void setAttendanceTwo(String attendanceTwo) 
	{
		this.attendanceTwo = attendanceTwo;
	}

	public String getAttendanceTwo() 
	{
		return attendanceTwo;
	}
	public void setAttendanceTwoStandard(String attendanceTwoStandard) 
	{
		this.attendanceTwoStandard = attendanceTwoStandard;
	}

	public String getAttendanceTwoStandard() 
	{
		return attendanceTwoStandard;
	}
	public void setAttendanceThree(String attendanceThree) 
	{
		this.attendanceThree = attendanceThree;
	}

	public String getAttendanceThree() 
	{
		return attendanceThree;
	}
	public void setAttendanceThreeStandard(String attendanceThreeStandard) 
	{
		this.attendanceThreeStandard = attendanceThreeStandard;
	}

	public String getAttendanceThreeStandard() 
	{
		return attendanceThreeStandard;
	}
	public void setExamOne(String examOne) 
	{
		this.examOne = examOne;
	}

	public String getExamOne() 
	{
		return examOne;
	}
	public void setExamOneStandard(String examOneStandard) 
	{
		this.examOneStandard = examOneStandard;
	}

	public String getExamOneStandard() 
	{
		return examOneStandard;
	}
	public void setExamTwo(String examTwo) 
	{
		this.examTwo = examTwo;
	}

	public String getExamTwo() 
	{
		return examTwo;
	}
	public void setExamTwoStandard(String examTwoStandard) 
	{
		this.examTwoStandard = examTwoStandard;
	}

	public String getExamTwoStandard() 
	{
		return examTwoStandard;
	}
	public void setExamThree(String examThree) 
	{
		this.examThree = examThree;
	}

	public String getExamThree() 
	{
		return examThree;
	}
	public void setExamThreeStandard(String examThreeStandard) 
	{
		this.examThreeStandard = examThreeStandard;
	}

	public String getExamThreeStandard() 
	{
		return examThreeStandard;
	}
	public void setTaskOne(String taskOne) 
	{
		this.taskOne = taskOne;
	}

	public String getTaskOne() 
	{
		return taskOne;
	}
	public void setTaskOneStandard(String taskOneStandard) 
	{
		this.taskOneStandard = taskOneStandard;
	}

	public String getTaskOneStandard() 
	{
		return taskOneStandard;
	}
	public void setTaskTwo(String taskTwo) 
	{
		this.taskTwo = taskTwo;
	}

	public String getTaskTwo() 
	{
		return taskTwo;
	}
	public void setTaskTwoStandard(String taskTwoStandard) 
	{
		this.taskTwoStandard = taskTwoStandard;
	}

	public String getTaskTwoStandard() 
	{
		return taskTwoStandard;
	}
	public void setTaskThree(String taskThree) 
	{
		this.taskThree = taskThree;
	}

	public String getTaskThree() 
	{
		return taskThree;
	}
	public void setTaskThreeStandard(String taskThreeStandard) 
	{
		this.taskThreeStandard = taskThreeStandard;
	}

	public String getTaskThreeStandard() 
	{
		return taskThreeStandard;
	}
	public void setSubjectOne(String subjectOne) 
	{
		this.subjectOne = subjectOne;
	}

	public String getSubjectOne() 
	{
		return subjectOne;
	}
	public void setSubjectOneStandard(String subjectOneStandard) 
	{
		this.subjectOneStandard = subjectOneStandard;
	}

	public String getSubjectOneStandard() 
	{
		return subjectOneStandard;
	}
	public void setSubjectTwo(String subjectTwo) 
	{
		this.subjectTwo = subjectTwo;
	}

	public String getSubjectTwo() 
	{
		return subjectTwo;
	}
	public void setSubjectTwoStandard(String subjectTwoStandard) 
	{
		this.subjectTwoStandard = subjectTwoStandard;
	}

	public String getSubjectTwoStandard() 
	{
		return subjectTwoStandard;
	}
	public void setSubjectThree(String subjectThree) 
	{
		this.subjectThree = subjectThree;
	}

	public String getSubjectThree() 
	{
		return subjectThree;
	}
	public void setSubjectThreeStandard(String subjectThreeStandard) 
	{
		this.subjectThreeStandard = subjectThreeStandard;
	}

	public String getSubjectThreeStandard() 
	{
		return subjectThreeStandard;
	}

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("assessMonth", getAssessMonth())
            .append("classId", getClassId())
            .append("attendanceOne", getAttendanceOne())
            .append("attendanceOneStandard", getAttendanceOneStandard())
            .append("attendanceTwo", getAttendanceTwo())
            .append("attendanceTwoStandard", getAttendanceTwoStandard())
            .append("attendanceThree", getAttendanceThree())
            .append("attendanceThreeStandard", getAttendanceThreeStandard())
            .append("examOne", getExamOne())
            .append("examOneStandard", getExamOneStandard())
            .append("examTwo", getExamTwo())
            .append("examTwoStandard", getExamTwoStandard())
            .append("examThree", getExamThree())
            .append("examThreeStandard", getExamThreeStandard())
            .append("taskOne", getTaskOne())
            .append("taskOneStandard", getTaskOneStandard())
            .append("taskTwo", getTaskTwo())
            .append("taskTwoStandard", getTaskTwoStandard())
            .append("taskThree", getTaskThree())
            .append("taskThreeStandard", getTaskThreeStandard())
            .append("subjectOne", getSubjectOne())
            .append("subjectOneStandard", getSubjectOneStandard())
            .append("subjectTwo", getSubjectTwo())
            .append("subjectTwoStandard", getSubjectTwoStandard())
            .append("subjectThree", getSubjectThree())
            .append("subjectThreeStandard", getSubjectThreeStandard())
            .toString();
    }

	public String[] getTeacherClass() {
		return teacherClass;
	}

	public void setTeacherClass(String[] teacherClass) {
		this.teacherClass = teacherClass;
	}
}
