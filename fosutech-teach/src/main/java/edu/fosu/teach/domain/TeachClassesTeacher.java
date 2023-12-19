package edu.fosu.teach.domain;

import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;


/**
 * 班级教师（班级子）表 teach_classes_teacher
 *  */
public class TeachClassesTeacher extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	@Id
	private String id;
	/** 职务（0，班主任；1，教师；2，助教） */
	private Integer post;
	/** 阶段ID */
	private String stageId;
	/** 班主任ID */
	private Integer teacherId;
	/** 教师ID */
	private Integer instructorId;
	/** 助教ID */
	private Integer assistantId;
	/** 班级编号 */
	private Integer classId;
	private  String teacherName;
	private  String teacherName2;
	private  String teacherName3;
	/** 阶段开始时间 */
	private String stageStarttime;
	/** 阶段结束时间 */
	private String stageEndtime;


	public void setId(String id)
	{
		this.id = id;
	}

	public String getId()
	{
		return id;
	}
	public void setPost(Integer post) 
	{
		this.post = post;
	}

	public Integer getPost() 
	{
		return post;
	}
	public void setStageId(String stageId)
	{
		this.stageId = stageId;
	}

	public String getStageId()
	{
		return stageId;
	}
	public void setTeacherId(Integer teacherId) 
	{
		this.teacherId = teacherId;
	}

	public Integer getTeacherId() 
	{
		return teacherId;
	}
	public void setClassId(Integer classId) 
	{
		this.classId = classId;
	}

	public Integer getClassId() 
	{
		return classId;
	}

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("post", getPost())
            .append("stageId", getStageId())
            .append("teacherId", getTeacherId())
            .append("classId", getClassId())
            .toString();
    }

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getStageStarttime() {
		return stageStarttime;
	}

	public void setStageStarttime(String stageStarttime) {
		this.stageStarttime = stageStarttime;
	}

	public String getStageEndtime() {
		return stageEndtime;
	}

	public void setStageEndtime(String stageEndtime) {
		this.stageEndtime = stageEndtime;
	}

	public Integer getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(Integer instructorId) {
		this.instructorId = instructorId;
	}

	public Integer getAssistantId() {
		return assistantId;
	}

	public void setAssistantId(Integer assistantId) {
		this.assistantId = assistantId;
	}

	public String getTeacherName2() {
		return teacherName2;
	}

	public void setTeacherName2(String teacherName2) {
		this.teacherName2 = teacherName2;
	}

	public String getTeacherName3() {
		return teacherName3;
	}

	public void setTeacherName3(String teacherName3) {
		this.teacherName3 = teacherName3;
	}
}
