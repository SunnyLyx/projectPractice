package edu.fosu.teach.domain;

import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;


/**
 * 学生考试子表 teach_student_exam
 *  */
public class TeachStudentExam extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	@Id
	private Integer id;
	/** 考试编号 */
	private Integer examId;
	/** 学生编号 */
	private Integer studentId;
	/** 学生姓名 */
	private String studentName;
	/** 成绩 */
	private String score;
	/** 备注 */
	private String remark;

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

	/** 考试 */
	private TeachExam teachExam;

	public TeachExam getTeachExam()
	{
		if (teachExam == null)
		{
			teachExam = new TeachExam();
		}
		return teachExam;
	}

	public void setTeachExam(TeachExam teachExam)
	{
		this.teachExam = teachExam;
	}

	/** 阶段 */
	private TeachMajorStage majorStage;

	public TeachMajorStage getMajorStage()
	{
		if (majorStage == null)
		{
			majorStage = new TeachMajorStage();
		}
		return majorStage;
	}

	public void setMajorStage(TeachMajorStage majorStage)
	{
		this.majorStage = majorStage;
	}




	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setExamId(Integer examId) 
	{
		this.examId = examId;
	}

	public Integer getExamId() 
	{
		return examId;
	}
	public void setStudentId(Integer studentId) 
	{
		this.studentId = studentId;
	}

	public Integer getStudentId() 
	{
		return studentId;
	}
	public void setScore(String score) 
	{
		this.score = score;
	}

	public String getScore() 
	{
		return score;
	}
	@Override
	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	@Override
    public String getRemark()
	{
		return remark;
	}

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("examId", getExamId())
            .append("studentId", getStudentId())
            .append("score", getScore())
            .append("remark", getRemark())
            .toString();
    }

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
}
