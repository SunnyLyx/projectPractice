package edu.fosu.teach.domain;

import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;


/**
 * 专业阶段（专业子）表 teach_major_stage
 *  */
public class TeachMajorStage extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	@Id
	private String id;
	/** 专业编号 */
	private Integer majorId;
	/** 阶段名称 */
	private String stageName;
	/** 排序 */
	private Integer sort;

	public void setId(String id)
	{
		this.id = id;
	}

	public String getId()
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
	public void setStageName(String stageName) 
	{
		this.stageName = stageName;
	}

	public String getStageName() 
	{
		return stageName;
	}
	public void setSort(Integer sort) 
	{
		this.sort = sort;
	}

	public Integer getSort() 
	{
		return sort;
	}

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("majorId", getMajorId())
            .append("stageName", getStageName())
            .append("sort", getSort())
            .toString();
    }
}
