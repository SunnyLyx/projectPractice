package edu.fosu.teach.domain;


import edu.fosu.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 专业表 teach_major
 *  */
public class Major extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 专业id */
	private Integer majorId;
	/** 分部id */
	private Integer schoolId;
	/** 专业名称 */
	private String majorName;
	/** 阶段一 */
	private String stageOne;
	/** 阶段二 */
	private String stageTwo;
	/** 阶段三 */
	private String stageThree;
	/** 阶段四 */
	private String stageFour;

	public void setMajorId(Integer majorId) 
	{
		this.majorId = majorId;
	}

	public Integer getMajorId() 
	{
		return majorId;
	}
	public void setSchoolId(Integer schoolId) 
	{
		this.schoolId = schoolId;
	}

	public Integer getSchoolId() 
	{
		return schoolId;
	}
	public void setMajorName(String majorName) 
	{
		this.majorName = majorName;
	}

	public String getMajorName() 
	{
		return majorName;
	}
	public void setStageOne(String stageOne) 
	{
		this.stageOne = stageOne;
	}

	public String getStageOne() 
	{
		return stageOne;
	}
	public void setStageTwo(String stageTwo) 
	{
		this.stageTwo = stageTwo;
	}

	public String getStageTwo() 
	{
		return stageTwo;
	}
	public void setStageThree(String stageThree) 
	{
		this.stageThree = stageThree;
	}

	public String getStageThree() 
	{
		return stageThree;
	}
	public void setStageFour(String stageFour) 
	{
		this.stageFour = stageFour;
	}

	public String getStageFour() 
	{
		return stageFour;
	}

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("majorId", getMajorId())
            .append("schoolId", getSchoolId())
            .append("majorName", getMajorName())
            .append("stageOne", getStageOne())
            .append("stageTwo", getStageTwo())
            .append("stageThree", getStageThree())
            .append("stageFour", getStageFour())
            .toString();
    }
}
