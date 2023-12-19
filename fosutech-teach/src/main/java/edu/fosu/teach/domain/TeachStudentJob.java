package edu.fosu.teach.domain;

import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;


/**
 * 学生作业表 teach_student_job
 *  */
public class TeachStudentJob extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	@Id
	private String id;
	/** 作业表编号 */
	private Integer jobId;
	/** 学生编号 */
	private Integer studentId;
	/** 作业评价编号 */
	private Integer jobResult;
	/** 学生姓名 */
	private String studentName;

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

	/** 作业 */
	private TeachJob teachJob;

	public TeachJob getTeachJob()
	{
		if (teachJob == null)
		{
			teachJob = new TeachJob();
		}
		return teachJob;
	}

	public void setTeachJob(TeachJob teachJob)
	{
		this.teachJob = teachJob;
	}


	public void setId(String id)
	{
		this.id = id;
	}

	public String getId()
	{
		return id;
	}
	public void setJobId(Integer jobId) 
	{
		this.jobId = jobId;
	}

	public Integer getJobId() 
	{
		return jobId;
	}
	public void setStudentId(Integer studentId) 
	{
		this.studentId = studentId;
	}

	public Integer getStudentId() 
	{
		return studentId;
	}
	public void setJobResult(Integer jobResult) 
	{
		this.jobResult = jobResult;
	}

	public Integer getJobResult() 
	{
		return jobResult;
	}

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("jobId", getJobId())
            .append("studentId", getStudentId())
            .append("jobResult", getJobResult())
            .toString();
    }

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
}
