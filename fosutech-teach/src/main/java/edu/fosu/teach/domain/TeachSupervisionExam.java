package edu.fosu.teach.domain;

import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import edu.fosu.system.domain.SysDept;
import edu.fosu.system.domain.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;

    
/**
 * 总部督查考试表 teach_supervision_exam
 *  */
public class TeachSupervisionExam extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	@Id
	private Integer id;
	/** 班级编号 */
	private Integer classId;
	/** 创建时间 */
	private String createtime;
	/** 考试编号 */
	private Integer examId;
	/** 分部合格率 */
	private Double schoolAcceptability;
	/** 总部合格率 */
	private Double headquartersAcceptability;
	/** 抽查个数 */
	private Integer randomNumber;
	/** 抽查合格率 */
	private Double randomAcceptability;

	private Integer majorId;

	private Integer stageId;

	private String className;

	/** 所在班级 */
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

	/** 所属分部 */
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
	private TeachMajor majors;

	public TeachMajor getMajors()
	{
		if (majors == null)
		{
			majors = new TeachMajor();
		}
		return majors;
	}

	public void setMajors(TeachMajor majors)
	{
		this.majors = majors;
	}

	/** 用户 */
	private SysUser sysUser;

	public SysUser getSysUser()
	{
		if (sysUser == null)
		{
			sysUser = new SysUser();
		}
		return sysUser;
	}

	public void setSysUser(SysUser sysUser)
	{
		this.sysUser = sysUser;
	}

	/** 考试 */
	private TeachExam exam;

	public TeachExam getExam()
	{
		if (exam == null)
		{
			exam = new TeachExam();
		}
		return exam;
	}
	public void setExam(TeachExam exam)
	{
		this.exam = exam;
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


	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getMajorId() {
		return majorId;
	}

	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}

	public Integer getStageId() {
		return stageId;
	}

	public void setStageId(Integer stageId) {
		this.stageId = stageId;
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
	public void setCreatetime(String createtime)
	{
		this.createtime = createtime;
	}

	public String getCreatetime()
	{
		return createtime;
	}
	public void setExamId(Integer examId) 
	{
		this.examId = examId;
	}

	public Integer getExamId() 
	{
		return examId;
	}
	public void setSchoolAcceptability(Double schoolAcceptability) 
	{
		this.schoolAcceptability = schoolAcceptability;
	}

	public Double getSchoolAcceptability() 
	{
		return schoolAcceptability;
	}
	public void setHeadquartersAcceptability(Double headquartersAcceptability) 
	{
		this.headquartersAcceptability = headquartersAcceptability;
	}

	public Double getHeadquartersAcceptability() 
	{
		return headquartersAcceptability;
	}
	public void setRandomNumber(Integer randomNumber) 
	{
		this.randomNumber = randomNumber;
	}

	public Integer getRandomNumber() 
	{
		return randomNumber;
	}
	public void setRandomAcceptability(Double randomAcceptability) 
	{
		this.randomAcceptability = randomAcceptability;
	}

	public Double getRandomAcceptability() 
	{
		return randomAcceptability;
	}

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("classId", getClassId())
            .append("createtime", getCreatetime())
            .append("examId", getExamId())
            .append("schoolAcceptability", getSchoolAcceptability())
            .append("headquartersAcceptability", getHeadquartersAcceptability())
            .append("randomNumber", getRandomNumber())
            .append("randomAcceptability", getRandomAcceptability())
            .toString();
    }
}
