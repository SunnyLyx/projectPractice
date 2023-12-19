package edu.fosu.teach.domain;

import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import edu.fosu.system.domain.SysDept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;

    
/**
 * 总部督查项目表 teach_supervision_subject
 *  */
public class TeachSupervisionSubject extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	@Id
	private Integer id;
	/** 班级编号 */
	private Integer classId;
	/** 创建时间 */
	private String createtime;
	/** 项目编号 */
	private Integer subjectId;
	/** 分部合格率 */
	private Double schoolAcceptability;
	/** 总部合格率 */
	private Double headquartersAcceptability;
	/** 抽查个数 */
	private Integer randomNumber;
	/** 抽查合格率 */
	private Double randomAcceptability;

	private Integer majorId;

	private String className;

	private Integer studentNum;

	public Integer getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(Integer studentNum) {
		this.studentNum = studentNum;
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

	/** 所属分部 */
	@Excel(name = "分部名称", targetAttr = "deptName", type = Excel.Type.EXPORT)
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
	@Excel(name = "专业名称", targetAttr = "majorName", type = Excel.Type.EXPORT)
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

	/** 所属项目 */
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

	/** 学生 */
	@Excel(name = "学生名称", targetAttr = "studentName", type = Excel.Type.EXPORT)
	private Student student;

	public Student getStudent()
	{
		if (student == null)
		{
			student = new Student();
		}
		return student;
	}

	public void setStudent(Student student)
	{
		this.student = student;
	}

	public Integer getMajorId() {
		return majorId;
	}

	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
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
	public void setSubjectId(Integer subjectId) 
	{
		this.subjectId = subjectId;
	}

	public Integer getSubjectId() 
	{
		return subjectId;
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
            .append("subjectId", getSubjectId())
            .append("schoolAcceptability", getSchoolAcceptability())
            .append("headquartersAcceptability", getHeadquartersAcceptability())
            .append("randomNumber", getRandomNumber())
            .append("randomAcceptability", getRandomAcceptability())
            .toString();
    }
}
