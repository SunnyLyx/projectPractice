package edu.fosu.teach.domain;

import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import edu.fosu.system.domain.SysDept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;

    
/**
 * 班级表 teach_classes
 *  */
public class TeachClasses extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 班级ID */
	@Id
	private Integer classId;
	/** 班级名称 */
	private String className;
	/** 所属分部ID */
	private Integer schoolId;
	/** 所属专业ID */
	private Integer majorId;
	/** 当前阶段 */
	private String stageNew;
	/** 阶段开始时间 */
	private String stageStarttime;
	/** 阶段结束时间 */
	private String stageEndtime;
	/** 创建时间 */
	private String createtime;
	private Object aaaa;
	/** 阶段 */
	private String stageName;
	/** 分部名称 */
	private String schoolName;
	/** 专业名称 */
	private String majorName;

	private String[] classes;

	private Integer zaidu;
	private Integer tuixue;
	private Integer xiuxue;
	private Integer xianshang;
	private Integer tiqianjiuye;
	private Integer lixiao;
	private Integer jieke;
	/* 专业类型 */
	private Integer majorType;
	private String typeName;
	/* 连接状态 */
	private Integer linkStatus;

	public Integer getLinkStatus() {
		return linkStatus;
	}

	public void setLinkStatus(Integer linkStatus) {
		this.linkStatus = linkStatus;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getMajorType() {
		return majorType;
	}

	public void setMajorType(Integer majorType) {
		this.majorType = majorType;
	}
	/*	*//** 所属分部 *//*
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

	*//** 所属专业 *//*
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

	*//** 所属专业 *//*
	@Excel(name = "阶段名称", targetAttr = "stageName", type = Excel.Type.EXPORT)
	private TeachMajorStage majorStage;

	public TeachMajorStage getTeachMajorStage()
	{
		if (majorStage == null)
		{
			majorStage = new TeachMajorStage();
		}
		return majorStage;
	}*/

	public void setClassId(Integer classId) 
	{
		this.classId = classId;
	}

	public Integer getClassId() 
	{
		return classId;
	}
	public void setClassName(String className) 
	{
		this.className = className;
	}

	public String getClassName() 
	{
		return className;
	}
	public void setSchoolId(Integer schoolId) 
	{
		this.schoolId = schoolId;
	}

	public Integer getSchoolId() 
	{
		return schoolId;
	}
	public void setMajorId(Integer majorId) 
	{
		this.majorId = majorId;
	}

	public Integer getMajorId() 
	{
		return majorId;
	}
	public void setStageNew(String stageNew) 
	{
		this.stageNew = stageNew;
	}

	public String getStageNew() 
	{
		return stageNew;
	}
	public void setStageStarttime(String stageStarttime)
	{
		this.stageStarttime = stageStarttime;
	}

	public String getStageStarttime()
	{
		return stageStarttime;
	}
	public void setStageEndtime(String stageEndtime)
	{
		this.stageEndtime = stageEndtime;
	}

	public String getStageEndtime()
	{
		return stageEndtime;
	}
	public void setCreatetime(String createtime)
	{
		this.createtime = createtime;
	}

	public String getCreatetime()
	{
		return createtime;
	}

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("classId", getClassId())
            .append("className", getClassName())
            .append("schoolId", getSchoolId())
            .append("majorId", getMajorId())
            .append("stageNew", getStageNew())
            .append("stageStarttime", getStageStarttime())
            .append("stageEndtime", getStageEndtime())
            .append("createtime", getCreatetime())
            .toString();
    }

	public Object getAaaa() {
		return aaaa;
	}

	public void setAaaa(Object aaaa) {
		this.aaaa = aaaa;
	}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String[] getClasses() {
		return classes;
	}

	public void setClasses(String[] classes) {
		this.classes = classes;
	}

	public Integer getZaidu() {
		return zaidu;
	}

	public void setZaidu(Integer zaidu) {
		this.zaidu = zaidu;
	}

	public Integer getTuixue() {
		return tuixue;
	}

	public void setTuixue(Integer tuixue) {
		this.tuixue = tuixue;
	}

	public Integer getXiuxue() {
		return xiuxue;
	}

	public void setXiuxue(Integer xiuxue) {
		this.xiuxue = xiuxue;
	}

	public Integer getXianshang() {
		return xianshang;
	}

	public void setXianshang(Integer xianshang) {
		this.xianshang = xianshang;
	}

	public Integer getTiqianjiuye() {
		return tiqianjiuye;
	}

	public void setTiqianjiuye(Integer tiqianjiuye) {
		this.tiqianjiuye = tiqianjiuye;
	}

	public Integer getLixiao() {
		return lixiao;
	}

	public void setLixiao(Integer lixiao) {
		this.lixiao = lixiao;
	}

	public Integer getJieke() {
		return jieke;
	}

	public void setJieke(Integer jieke) {
		this.jieke = jieke;
	}
}
