package edu.fosu.teach.domain;


import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import edu.fosu.system.domain.SysDept;
import edu.fosu.system.domain.SysRole;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;

/**
 * 考核标准表 teach_assessment_criterion
 *  */
public class TeachAssessmentCriterion extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 考核标准ID */
	@Id
	private Integer assessId;
	/** 分部编号 */
	private Integer schoolId;
	/** 角色编号 */
	private Integer characterNo;
	/** 考核占分比 */
	private String assessProportion;

	private String roleName;

	private Object assess;

	public Object getAssess() {
		return assess;
	}

	public void setAssess(Object assess) {
		this.assess = assess;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	/** 考核项权重 */
	@Excel(name = "考核项权重名称", targetAttr = "inspectionItemsWeight", type = Excel.Type.EXPORT)
	private TeachInspectionItems inspectionItems;

	public TeachInspectionItems getInspectionItems()
	{
		if (inspectionItems == null)
		{
			inspectionItems = new TeachInspectionItems();
		}
		return inspectionItems;
	}

	public void setInspectionItems(TeachInspectionItems inspectionItems)
	{
		this.inspectionItems = inspectionItems;
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

	/** 角色 */
	@Excel(name = "角色名称", targetAttr = "roleName", type = Excel.Type.EXPORT)
	private SysRole sysRole;

	public SysRole getSysRole()
	{
		if (sysRole == null)
		{
			sysRole = new SysRole();
		}
		return sysRole;
	}

	public void setSysRole(SysRole sysRole)
	{
		this.sysRole = sysRole;
	}


	public void setAssessId(Integer assessId) 
	{
		this.assessId = assessId;
	}

	public Integer getAssessId() 
	{
		return assessId;
	}
	public void setSchoolId(Integer schoolId) 
	{
		this.schoolId = schoolId;
	}

	public Integer getSchoolId() 
	{
		return schoolId;
	}
	public void setCharacterNo(Integer characterNo) 
	{
		this.characterNo = characterNo;
	}

	public Integer getCharacterNo() 
	{
		return characterNo;
	}
	public void setAssessProportion(String assessProportion) 
	{
		this.assessProportion = assessProportion;
	}

	public String getAssessProportion() 
	{
		return assessProportion;
	}

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("assessId", getAssessId())
            .append("schoolId", getSchoolId())
            .append("characterNo", getCharacterNo())
            .append("assessProportion", getAssessProportion())
            .toString();
    }
}
