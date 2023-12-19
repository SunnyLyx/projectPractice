package edu.fosu.teach.domain;


import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import edu.fosu.system.domain.SysDept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;

/**
 * 班级表 teach_classes
 *  */
public class Classes extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 班级ID */
	@Id
	private Integer classId;
	/** 班级名称 */
	private String className;
	/** 所属分部ID */
	private Integer schoolId;
	/** 所属专业ID */
	private Integer majorId;
	/** 当前阶段 */
	private String stageNew;
	/** 阶段开始时间 */
	private Date stageStarttime;
	/** 阶段结束时间 */
	private Date stageEndtime;
	/** 班主任 */
	private Integer headTeacher;
	/** 教师1 */
	private Integer teacherOne;
	/** 教师2 */
	private Integer teacherTwo;
	/** 教师3 */
	private Integer teacherThree;
	/** 教师4 */
	private Integer teacherFour;
	/** 助教 */
	private Integer teachingAssistant;

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
	private Major majors;

	public Major getMajors()
	{
		if (majors == null)
		{
			majors = new Major();
		}
		return majors;
	}

	public void setMajors(Major majors)
	{
		this.majors = majors;
	}

	public void setClassId(Integer classId) 
	{
		this.classId = classId;
	}

	public Integer getClassId() 
	{
		return classId;
	}
	public void setClassName(String className) 
	{
		this.className = className;
	}

	public String getClassName() 
	{
		return className;
	}
	public void setSchoolId(Integer schoolId) 
	{
		this.schoolId = schoolId;
	}

	public Integer getSchoolId() 
	{
		return schoolId;
	}
	public void setMajorId(Integer majorId) 
	{
		this.majorId = majorId;
	}

	public Integer getMajorId() 
	{
		return majorId;
	}
	public void setStageNew(String stageNew) 
	{
		this.stageNew = stageNew;
	}

	public String getStageNew() 
	{
		return stageNew;
	}
	public void setStageStarttime(Date stageStarttime)
	{
		this.stageStarttime = stageStarttime;
	}

	public Date getStageStarttime() 
	{
		return stageStarttime;
	}
	public void setStageEndtime(Date stageEndtime) 
	{
		this.stageEndtime = stageEndtime;
	}

	public Date getStageEndtime() 
	{
		return stageEndtime;
	}
	public void setHeadTeacher(Integer headTeacher) 
	{
		this.headTeacher = headTeacher;
	}

	public Integer getHeadTeacher() 
	{
		return headTeacher;
	}
	public void setTeacherOne(Integer teacherOne) 
	{
		this.teacherOne = teacherOne;
	}

	public Integer getTeacherOne() 
	{
		return teacherOne;
	}
	public void setTeacherTwo(Integer teacherTwo) 
	{
		this.teacherTwo = teacherTwo;
	}

	public Integer getTeacherTwo() 
	{
		return teacherTwo;
	}
	public void setTeacherThree(Integer teacherThree) 
	{
		this.teacherThree = teacherThree;
	}

	public Integer getTeacherThree() 
	{
		return teacherThree;
	}
	public void setTeacherFour(Integer teacherFour) 
	{
		this.teacherFour = teacherFour;
	}

	public Integer getTeacherFour() 
	{
		return teacherFour;
	}
	public void setTeachingAssistant(Integer teachingAssistant) 
	{
		this.teachingAssistant = teachingAssistant;
	}

	public Integer getTeachingAssistant() 
	{
		return teachingAssistant;
	}

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("classId", getClassId())
            .append("className", getClassName())
            .append("schoolId", getSchoolId())
            .append("majorId", getMajorId())
            .append("stageNew", getStageNew())
            .append("stageStarttime", getStageStarttime())
            .append("stageEndtime", getStageEndtime())
            .append("headTeacher", getHeadTeacher())
            .append("teacherOne", getTeacherOne())
            .append("teacherTwo", getTeacherTwo())
            .append("teacherThree", getTeacherThree())
            .append("teacherFour", getTeacherFour())
            .append("teachingAssistant", getTeachingAssistant())
            .toString();
    }
}
