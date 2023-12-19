package edu.fosu.teach.domain;

import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;


/**
 * 专业表 teach_major
 *  */
public class TeachMajor extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 专业id */
	@Id
	private Integer majorId;
	/** 专业名称 */
	private String majorName;

	private Object major;

	private String majorStage;

	private Integer majorType;

	public Integer getMajorType() {
		return majorType;
	}

	public void setMajorType(Integer majorType) {
		this.majorType = majorType;
	}

	/** 阶段 */
	@Excel(name = "阶段名称", targetAttr = "stageName", type = Excel.Type.EXPORT)
	private TeachMajorStage stages;

	public TeachMajorStage getStages()
	{
		if (stages == null)
		{
			stages = new TeachMajorStage();
		}
		return stages;
	}

	public void setStages(TeachMajorStage stages)
	{
		this.stages = stages;
	}

	public String getMajorStage() {
		return majorStage;
	}

	public void setMajorStage(String majorStage) {
		this.majorStage = majorStage;
	}

	public Object getMajor() {
		return major;
	}

	public void setMajor(Object major) {
		this.major = major;
	}

	public void setMajorId(Integer majorId) 
	{
		this.majorId = majorId;
	}

	public Integer getMajorId() 
	{
		return majorId;
	}
	public void setMajorName(String majorName) 
	{
		this.majorName = majorName;
	}

	public String getMajorName() 
	{
		return majorName;
	}

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("majorId", getMajorId())
            .append("majorName", getMajorName())
            .toString();
    }
}
