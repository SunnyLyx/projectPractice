package edu.fosu.teach.domain;

import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;


/**
 * 学生项目表 teach_student_subject
 *  */
public class TeachStudentSubject extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	@Id
	private Integer id;
	/** 项目id */
	private Integer subjectId;
	/**  */
	private Integer studentId;
	private String studentName;
	private Integer submit;
	/**  */
	private String subjectUrl;
	/** 评价 */
	private String evaluate;

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

	/** 项目 */
	@Excel(name = "项目名称", targetAttr = "subjectName", type = Excel.Type.EXPORT)
	private TeachSubject subject;

	public TeachSubject getSubject()
	{
		if (subject == null)
		{
			subject = new TeachSubject();
		}
		return subject;
	}

	public void setSubject(TeachSubject subject)
	{
		this.subject = subject;
	}


	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setSubjectId(Integer subjectId) 
	{
		this.subjectId = subjectId;
	}

	public Integer getSubjectId() 
	{
		return subjectId;
	}
	public void setStudentId(Integer studentId) 
	{
		this.studentId = studentId;
	}

	public Integer getStudentId() 
	{
		return studentId;
	}
	public void setSubjectUrl(String subjectUrl) 
	{
		this.subjectUrl = subjectUrl;
	}

	public String getSubjectUrl() 
	{
		return subjectUrl;
	}
	public void setEvaluate(String evaluate)
	{
		this.evaluate = evaluate;
	}

	public String getEvaluate()
	{
		return evaluate;
	}

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("subjectId", getSubjectId())
            .append("studentId", getStudentId())
            .append("subjectUrl", getSubjectUrl())
            .append("evaluate", getEvaluate())
            .toString();
    }

	public Integer getSubmit() {
		return submit;
	}

	public void setSubmit(Integer submit) {
		this.submit = submit;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
}
