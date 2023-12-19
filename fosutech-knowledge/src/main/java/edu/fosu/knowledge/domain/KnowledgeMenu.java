package edu.fosu.knowledge.domain;

import edu.fosu.common.annotation.Excel;
import edu.fosu.common.base.BaseEntity;
import edu.fosu.system.domain.SysMenu;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 菜单权限表 knowledge_menu
 *  */
public class KnowledgeMenu extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 菜单ID */
	@Id
	private Long menuId;
	/** 菜单名称 */
	private String menuName;
	/** 父菜单ID */
	private Long parentId;
	/** 显示顺序 */
	private Integer orderNum;
	/** 请求地址 */
	private String url;
	/** 菜单类型（M目录 C菜单 F按钮） */
	private String menuType;
	/** 菜单状态（0显示 1隐藏） */
	private String visible;
	/** 权限标识 */
	private String perms;
	/** 菜单图标 */
	private String icon;
	/** 创建者 */
	/*private String createBy;
	*//** 创建时间 *//*
	private Date createTime;
	*//** 更新者 *//*
	private String updateBy;
	*//** 更新时间 *//*
	private Date updateTime;
	*//** 备注 *//*
	private String remark;*/
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

	/** 父菜单名称 */
	private String parentName;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	/** 子菜单 */
	private List<KnowledgeMenu> children = new ArrayList<KnowledgeMenu>();

	public List<KnowledgeMenu> getChildren()
	{
		return children;
	}

	public void setChildren(List<KnowledgeMenu> children)
	{
		this.children = children;
	}

	public void setMenuId(Long menuId) 
	{
		this.menuId = menuId;
	}

	public Long getMenuId() 
	{
		return menuId;
	}
	public void setMenuName(String menuName) 
	{
		this.menuName = menuName;
	}

	public String getMenuName() 
	{
		return menuName;
	}
	public void setParentId(Long parentId) 
	{
		this.parentId = parentId;
	}

	public Long getParentId() 
	{
		return parentId;
	}
	public void setOrderNum(Integer orderNum) 
	{
		this.orderNum = orderNum;
	}

	public Integer getOrderNum() 
	{
		return orderNum;
	}
	public void setUrl(String url) 
	{
		this.url = url;
	}

	public String getUrl() 
	{
		return url;
	}
	public void setMenuType(String menuType) 
	{
		this.menuType = menuType;
	}

	public String getMenuType() 
	{
		return menuType;
	}
	public void setVisible(String visible) 
	{
		this.visible = visible;
	}

	public String getVisible() 
	{
		return visible;
	}
	public void setPerms(String perms) 
	{
		this.perms = perms;
	}

	public String getPerms() 
	{
		return perms;
	}
	public void setIcon(String icon) 
	{
		this.icon = icon;
	}

	public String getIcon() 
	{
		return icon;
	}
	/*public void setCreateBy(String createBy)
	{
		this.createBy = createBy;
	}

	public String getCreateBy() 
	{
		return createBy;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateBy(String updateBy) 
	{
		this.updateBy = updateBy;
	}

	public String getUpdateBy() 
	{
		return updateBy;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}*/
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
            .append("menuId", getMenuId())
            .append("menuName", getMenuName())
            .append("parentId", getParentId())
            .append("orderNum", getOrderNum())
            .append("url", getUrl())
            .append("menuType", getMenuType())
            .append("visible", getVisible())
            .append("perms", getPerms())
            .append("icon", getIcon())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("extend1", getExtend1())
            .append("extend2", getExtend2())
            .append("extend3", getExtend3())
            .append("extend4", getExtend4())
            .append("extend5", getExtend5())
            .toString();
    }
}
