package edu.fosu.teach.domain;

import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;

    
/**
 * 数据汇总（班级）表 teach_class_statistics
 *  */
public class TeachClassStatistics extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	@Id
	private String id;
	/** 班级编号 */
	private Integer classId;
	/** 创建时间 */
	private Date createtime;
	/** 统计月 */
	private String month;
	/** 出勤率 */
	private String attendence;
	/** 项目完成率 */
	private String subjectPercentageComplete;
	/** 作业完成率 */
	private String jobPercentageComplete;
	/** 考试合格率 */
	private String examAcceptability;

	private String majorName;

	private String className;

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getId()
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
	public void setMonth(String month)
	{
		this.month = month;
	}

	public String getMonth()
	{
		return month;
	}
	public void setAttendence(String attendence)
	{
		this.attendence = attendence;
	}

	public String getAttendence()
	{
		return attendence;
	}
	public void setSubjectPercentageComplete(String subjectPercentageComplete)
	{
		this.subjectPercentageComplete = subjectPercentageComplete;
	}

	public String getSubjectPercentageComplete()
	{
		return subjectPercentageComplete;
	}
	public void setJobPercentageComplete(String jobPercentageComplete)
	{
		this.jobPercentageComplete = jobPercentageComplete;
	}

	public String getJobPercentageComplete()
	{
		return jobPercentageComplete;
	}
	public void setExamAcceptability(String examAcceptability)
	{
		this.examAcceptability = examAcceptability;
	}

	public String getExamAcceptability()
	{
		return examAcceptability;
	}

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("classId", getClassId())
            .append("createtime", getCreatetime())
            .append("month", getMonth())
            .append("attendence", getAttendence())
            .append("subjectPercentageComplete", getSubjectPercentageComplete())
            .append("jobPercentageComplete", getJobPercentageComplete())
            .append("examAcceptability", getExamAcceptability())
            .toString();
    }
}
