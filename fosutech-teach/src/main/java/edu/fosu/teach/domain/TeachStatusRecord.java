package edu.fosu.teach.domain;

import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import edu.fosu.system.domain.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;

    
/**
 * 学生状态更改记录表 teach_status_record
 *  */
public class TeachStatusRecord extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 状态记录编号 */
	@Id
	private Integer id;
	/** 用户id */
	private Integer userId;
	/** 学生Id */
	private Integer studentId;
	/** 更改类型 */
	private String changeType;
	/** 更改内容 */
	private String changeContent;
	/** 更改时间 */
	private String changeTime;

	private String userName;

	private String upTime;

	public String getUpTime() {
		return upTime;
	}

	public void setUpTime(String upTime) {
		this.upTime = upTime;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setUserId(Integer userId) 
	{
		this.userId = userId;
	}

	public Integer getUserId() 
	{
		return userId;
	}
	public void setChangeType(String changeType) 
	{
		this.changeType = changeType;
	}

	public String getChangeType() 
	{
		return changeType;
	}
	public void setChangeContent(String changeContent) 
	{
		this.changeContent = changeContent;
	}

	public String getChangeContent() 
	{
		return changeContent;
	}
	public void setChangeTime(String changeTime)
	{
		this.changeTime = changeTime;
	}

	public String getChangeTime()
	{
		return changeTime;
	}

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("changeType", getChangeType())
            .append("changeContent", getChangeContent())
            .append("changeTime", getChangeTime())
            .toString();
    }
}
