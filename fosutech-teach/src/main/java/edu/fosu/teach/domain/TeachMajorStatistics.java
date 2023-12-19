package edu.fosu.teach.domain;

import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;

    
/**
 * 数据汇总（专业）表 teach_major_statistics
 *  */
public class TeachMajorStatistics extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	@Id
	private Integer id;
	/** 专业编号 */
	private Integer majorId;
	/** 创建时间 */
	private Date createtime;
	/** 统计月 */
	private Date month;
	/** attendence */
	private Double attendence;
	/** 项目完成率 */
	private Double subjectPercentageComplete;
	/** 作业完成率 */
	private Double jobPercentageComplete;
	/** 考试合格率 */
	private Double examAcceptability;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setMajorId(Integer majorId) 
	{
		this.majorId = majorId;
	}

	public Integer getMajorId() 
	{
		return majorId;
	}
	public void setCreatetime(Date createtime) 
	{
		this.createtime = createtime;
	}

	public Date getCreatetime() 
	{
		return createtime;
	}
	public void setMonth(Date month) 
	{
		this.month = month;
	}

	public Date getMonth() 
	{
		return month;
	}
	public void setAttendence(Double attendence) 
	{
		this.attendence = attendence;
	}

	public Double getAttendence() 
	{
		return attendence;
	}
	public void setSubjectPercentageComplete(Double subjectPercentageComplete) 
	{
		this.subjectPercentageComplete = subjectPercentageComplete;
	}

	public Double getSubjectPercentageComplete() 
	{
		return subjectPercentageComplete;
	}
	public void setJobPercentageComplete(Double jobPercentageComplete) 
	{
		this.jobPercentageComplete = jobPercentageComplete;
	}

	public Double getJobPercentageComplete() 
	{
		return jobPercentageComplete;
	}
	public void setExamAcceptability(Double examAcceptability) 
	{
		this.examAcceptability = examAcceptability;
	}

	public Double getExamAcceptability() 
	{
		return examAcceptability;
	}

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("majorId", getMajorId())
            .append("createtime", getCreatetime())
            .append("month", getMonth())
            .append("attendence", getAttendence())
            .append("subjectPercentageComplete", getSubjectPercentageComplete())
            .append("jobPercentageComplete", getJobPercentageComplete())
            .append("examAcceptability", getExamAcceptability())
            .toString();
    }
}
