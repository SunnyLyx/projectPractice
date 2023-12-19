package edu.fosu.teach.domain;

import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;

    
/**
 * 班级作业统计表 teach_class_homework
 *  */
public class TeachClassHomework extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	@Id
	private Integer id;
	/** 班级ID */
	private String classId;
	/** 作业时间 */
	private Date homeworkDatetime;
	/** 作业内容 */
	private String jobContent;
	/** 专业 */
	private String lesson;
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
	public void setHomeworkDatetime(Date homeworkDatetime) 
	{
		this.homeworkDatetime = homeworkDatetime;
	}

	public Date getHomeworkDatetime() 
	{
		return homeworkDatetime;
	}
	public void setJobContent(String jobContent) 
	{
		this.jobContent = jobContent;
	}

	public String getJobContent() 
	{
		return jobContent;
	}
	public void setLesson(String lesson) 
	{
		this.lesson = lesson;
	}

	public String getLesson() 
	{
		return lesson;
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
            .append("id", getId())
            .append("classId", getClassId())
            .append("homeworkDatetime", getHomeworkDatetime())
            .append("jobContent", getJobContent())
            .append("lesson", getLesson())
            .append("workbestnum", getWorkbestnum())
            .append("workgoodnum", getWorkgoodnum())
            .append("workpoornum", getWorkpoornum())
            .append("worknosubmitnum", getWorknosubmitnum())
            .append("studentnum", getStudentnum())
            .append("classHomeworkAttendance", getClassHomeworkAttendance())
            .toString();
    }
}
