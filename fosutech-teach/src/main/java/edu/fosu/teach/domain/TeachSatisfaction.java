package edu.fosu.teach.domain;

import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;

    
/**
 * 满意度表 teach_satisfaction
 *  */
public class TeachSatisfaction extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	@Id
	private Integer id;
	/** 班级编号 */
	private Integer classId;

	/**
	 * 班级名称
	 */
	private String className;
	/**
	 * 老师名称
	 */
	private String teacherName;

	/** 评级时间 */
	private Date createtime;
	/** 教师编号 */
	private Integer teacherId;
	/** 满意度 */
	private Double satisfaction;

	private String[] teacherClass;

	public String[] getTeacherClass() {
		return teacherClass;
	}

	public void setTeacherClass(String[] teacherClass) {
		this.teacherClass = teacherClass;
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

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setClassId(Integer classId) 
	{
		this.classId = classId;
	}

	public Integer getClassId() 
	{
		return classId;
	}
	public void setCreatetime(Date createtime) 
	{
		this.createtime = createtime;
	}

	public Date getCreatetime() 
	{
		return createtime;
	}
	public void setTeacherId(Integer teacherId) 
	{
		this.teacherId = teacherId;
	}

	public Integer getTeacherId() 
	{
		return teacherId;
	}
	public void setSatisfaction(Double satisfaction) 
	{
		this.satisfaction = satisfaction;
	}

	public Double getSatisfaction() 
	{
		return satisfaction;
	}

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("classId", getClassId())
            .append("createtime", getCreatetime())
            .append("teacherId", getTeacherId())
            .append("satisfaction", getSatisfaction())
            .toString();
    }
}
