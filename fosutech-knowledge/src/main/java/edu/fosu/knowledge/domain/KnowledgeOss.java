package edu.fosu.knowledge.domain;

import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.Date;

    
/**
 * 文件上传表 knowledge_oss
 *  */
public class KnowledgeOss extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 编号 */
	@Id
	private Long id;
	/** 文件名 */
	private String fileName;
	/** 文件后缀名 */
	private String fileSuffix;
	/** URL地址 */
	private String url;
	/** 创建时间 */
	/*private Date createTime;
	*//** 上传人 *//*
	private String createBy;*/
	/** 服务商 */
	private Integer service;
	/** 菜单id */
	private Integer menuId;
	/** 状态 */
	private String status;
	/**  */
	private String extend1;
	/**  */
	private String extend2;
	/**  */
	private String extend3;
	/**  */
	private String extend4;
	/**  */
	private String extend5;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setFileName(String fileName) 
	{
		this.fileName = fileName;
	}

	public String getFileName() 
	{
		return fileName;
	}
	public void setFileSuffix(String fileSuffix) 
	{
		this.fileSuffix = fileSuffix;
	}

	public String getFileSuffix() 
	{
		return fileSuffix;
	}
	public void setUrl(String url) 
	{
		this.url = url;
	}

	public String getUrl() 
	{
		return url;
	}
	/*public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setCreateBy(String createBy) 
	{
		this.createBy = createBy;
	}

	public String getCreateBy() 
	{
		return createBy;
	}*/
	public void setService(Integer service) 
	{
		this.service = service;
	}

	public Integer getService() 
	{
		return service;
	}
	public void setMenuId(Integer menuId) 
	{
		this.menuId = menuId;
	}

	public Integer getMenuId() 
	{
		return menuId;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setExtend1(String extend1) 
	{
		this.extend1 = extend1;
	}

	public String getExtend1() 
	{
		return extend1;
	}
	public void setExtend2(String extend2) 
	{
		this.extend2 = extend2;
	}

	public String getExtend2() 
	{
		return extend2;
	}
	public void setExtend3(String extend3) 
	{
		this.extend3 = extend3;
	}

	public String getExtend3() 
	{
		return extend3;
	}
	public void setExtend4(String extend4) 
	{
		this.extend4 = extend4;
	}

	public String getExtend4() 
	{
		return extend4;
	}
	public void setExtend5(String extend5) 
	{
		this.extend5 = extend5;
	}

	public String getExtend5() 
	{
		return extend5;
	}

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("fileName", getFileName())
            .append("fileSuffix", getFileSuffix())
            .append("url", getUrl())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("service", getService())
            .append("menuId", getMenuId())
            .append("status", getStatus())
            .append("extend1", getExtend1())
            .append("extend2", getExtend2())
            .append("extend3", getExtend3())
            .append("extend4", getExtend4())
            .append("extend5", getExtend5())
            .toString();
    }
}
