package edu.fosu.teach.domain;


import edu.fosu.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;

/**
 * 考核项（考核标准子）表 teach_inspection_items
 *  */
public class TeachInspectionItems extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 考核项id */
	@Id
	private String inspectionItemsId;
	/** 考核标准（父表）编号 */
	private Integer assessId;
	/** 考核项编号 */
	private Integer inspectionItemsNo;
	/** 考核项权重 */
	private String inspectionItemsWeight;

	public void setInspectionItemsId(String inspectionItemsId)
	{
		this.inspectionItemsId = inspectionItemsId;
	}

	public String getInspectionItemsId()
	{
		return inspectionItemsId;
	}
	public void setAssessId(Integer assessId) 
	{
		this.assessId = assessId;
	}

	public Integer getAssessId() 
	{
		return assessId;
	}
	public void setInspectionItemsNo(Integer inspectionItemsNo) 
	{
		this.inspectionItemsNo = inspectionItemsNo;
	}

	public Integer getInspectionItemsNo() 
	{
		return inspectionItemsNo;
	}
	public void setInspectionItemsWeight(String inspectionItemsWeight) 
	{
		this.inspectionItemsWeight = inspectionItemsWeight;
	}

	public String getInspectionItemsWeight() 
	{
		return inspectionItemsWeight;
	}

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("inspectionItemsId", getInspectionItemsId())
            .append("assessId", getAssessId())
            .append("inspectionItemsNo", getInspectionItemsNo())
            .append("inspectionItemsWeight", getInspectionItemsWeight())
            .toString();
    }
}
