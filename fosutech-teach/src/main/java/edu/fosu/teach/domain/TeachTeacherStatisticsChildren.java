package edu.fosu.teach.domain;

import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;


/**
 * 数据统计（教师）子表 teach_teacher_statistics_children
 *  */
public class TeachTeacherStatisticsChildren extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	@Id
	private Integer id;
	/** 月度统计表id */
	private Integer teacherStatisticsId;
	/** 考核项编号 */
	private Integer inspectionItemsNo;
	/** 考核项完成率 */
	private Double percentageComplete;
	/** 考核项得分 */
	private Double grade;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setTeacherStatisticsId(Integer teacherStatisticsId) 
	{
		this.teacherStatisticsId = teacherStatisticsId;
	}

	public Integer getTeacherStatisticsId() 
	{
		return teacherStatisticsId;
	}
	public void setInspectionItemsNo(Integer inspectionItemsNo) 
	{
		this.inspectionItemsNo = inspectionItemsNo;
	}

	public Integer getInspectionItemsNo() 
	{
		return inspectionItemsNo;
	}
	public void setPercentageComplete(Double percentageComplete) 
	{
		this.percentageComplete = percentageComplete;
	}

	public Double getPercentageComplete() 
	{
		return percentageComplete;
	}
	public void setGrade(Double grade) 
	{
		this.grade = grade;
	}

	public Double getGrade() 
	{
		return grade;
	}

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("teacherStatisticsId", getTeacherStatisticsId())
            .append("inspectionItemsNo", getInspectionItemsNo())
            .append("percentageComplete", getPercentageComplete())
            .append("grade", getGrade())
            .toString();
    }
}
