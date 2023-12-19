package edu.fosu.teach.domain;

import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;

    
/**
 * 考试统计表 teach_exam_statistics
 *  */
public class TeachExamStatistics extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	@Id
	private Integer id;
	/** 班级编号 */
	private Integer classId;
	/** 考试时间 */
	private String examTime;
	/** 考试阶段 */
	private String stageId;
	/** 考试通过人数 */
	private Integer pass;
	/** 考试未通过人数 */
	private Integer fail;
	/** 班级人数 */
	private Integer studentNum;
	/** 合格率 */
	private String acceptability;
	/** 监考老师 */
	private Integer invigilator;
	/** 考试地点 */
	private String address;
	/** 老师姓名 */
	private String teacherName;
	/** 阶段 */
	private String stageName;
	/** 班级名称 */
	private String className;

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
	public void setExamTime(String examTime)
	{
		this.examTime = examTime;
	}

	public String getExamTime()
	{
		return examTime;
	}
	public void setStageId(String stageId) 
	{
		this.stageId = stageId;
	}

	public String getStageId() 
	{
		return stageId;
	}
	public void setPass(Integer pass) 
	{
		this.pass = pass;
	}

	public Integer getPass() 
	{
		return pass;
	}
	public void setFail(Integer fail) 
	{
		this.fail = fail;
	}

	public Integer getFail() 
	{
		return fail;
	}
	public void setStudentNum(Integer studentNum) 
	{
		this.studentNum = studentNum;
	}

	public Integer getStudentNum() 
	{
		return studentNum;
	}
	public void setAcceptability(String acceptability) 
	{
		this.acceptability = acceptability;
	}

	public String getAcceptability() 
	{
		return acceptability;
	}
	public void setInvigilator(Integer invigilator) 
	{
		this.invigilator = invigilator;
	}

	public Integer getInvigilator() 
	{
		return invigilator;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getAddress() 
	{
		return address;
	}

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("classId", getClassId())
            .append("examTime", getExamTime())
            .append("stageId", getStageId())
            .append("pass", getPass())
            .append("fail", getFail())
            .append("studentNum", getStudentNum())
            .append("acceptability", getAcceptability())
            .append("invigilator", getInvigilator())
            .append("address", getAddress())
            .toString();
    }

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}
