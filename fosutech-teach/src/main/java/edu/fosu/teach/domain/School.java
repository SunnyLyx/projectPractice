package edu.fosu.teach.domain;


import edu.fosu.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;

/**
 * 分部表 teach_school
 *  */
public class School extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 分部id */
	@Id
	private Integer schoolId;
	/** 分部名称 */
	private String schoolName;
	/** 校长 */
	private String headmaster;
	/** 副校长 */
	private String president;
	/**  */
	private Date datetime;

	public void setSchoolId(Integer schoolId) 
	{
		this.schoolId = schoolId;
	}

	public Integer getSchoolId() 
	{
		return schoolId;
	}
	public void setSchoolName(String schoolName) 
	{
		this.schoolName = schoolName;
	}

	public String getSchoolName() 
	{
		return schoolName;
	}
	public void setHeadmaster(String headmaster) 
	{
		this.headmaster = headmaster;
	}

	public String getHeadmaster() 
	{
		return headmaster;
	}
	public void setPresident(String president) 
	{
		this.president = president;
	}

	public String getPresident() 
	{
		return president;
	}
	public void setDatetime(Date datetime) 
	{
		this.datetime = datetime;
	}

	public Date getDatetime() 
	{
		return datetime;
	}

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("schoolId", getSchoolId())
            .append("schoolName", getSchoolName())
            .append("headmaster", getHeadmaster())
            .append("president", getPresident())
            .append("datetime", getDatetime())
            .toString();
    }
}
