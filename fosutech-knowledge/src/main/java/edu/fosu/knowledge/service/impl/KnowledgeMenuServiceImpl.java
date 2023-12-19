package edu.fosu.knowledge.service.impl;

import java.text.MessageFormat;
import java.util.*;

import edu.fosu.common.constant.UserConstants;
import edu.fosu.common.utils.StringUtils;
import edu.fosu.knowledge.domain.KnowledgeMenu;
import edu.fosu.knowledge.mapper.KnowledgeMenuMapper;
import edu.fosu.knowledge.service.IKnowledgeMenuService;
import edu.fosu.system.domain.SysRole;
import edu.fosu.system.domain.SysUser;
import edu.fosu.system.mapper.SysRoleMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.common.support.Convert;

/**
 * 菜单权限 服务层实现
 *  */
@Service
public class KnowledgeMenuServiceImpl implements IKnowledgeMenuService
{
	public static final String PREMISSION_STRING = "perms[\"{0}\"]";

	@Autowired
	private KnowledgeMenuMapper knowledgeMenuMapper;

	@Autowired
	private SysRoleMenuMapper roleMenuMapper;

	@Override
	public List<KnowledgeMenu> selectMenusByUser(SysUser user) {
		List<KnowledgeMenu> menus = new LinkedList<KnowledgeMenu>();
		// 管理员显示所有菜单信息
		if (user.isAdmin())
		{
			menus = knowledgeMenuMapper.selectMenuNormalAll();
		}
		else
		{
			menus = knowledgeMenuMapper.selectMenusByUserId(user.getUserId());
		}
		return getChildPerms(menus, 0);
	}

	@Override
	public List<KnowledgeMenu> selectMenuAll() {
		return knowledgeMenuMapper.selectMenuAll();
	}

	@Override
	public Set<String> selectPermsByUserId(Long userId) {
		List<String> perms = knowledgeMenuMapper.selectPermsByUserId(userId);
		Set<String> permsSet = new HashSet<>();
		for (String perm : perms)
		{
			if (StringUtils.isNotEmpty(perm))
			{
				permsSet.addAll(Arrays.asList(perm.trim().split(",")));
			}
		}
		return permsSet;
	}

	@Override
	public List<Map<String, Object>> roleMenuTreeData(SysRole role) {
		Long roleId = role.getRoleId();
		List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();
		List<KnowledgeMenu> menuList = knowledgeMenuMapper.selectMenuAll();
		if (StringUtils.isNotNull(roleId))
		{
			List<String> roleMenuList = knowledgeMenuMapper.selectMenuTree(roleId);
			trees = getTrees(menuList, true, roleMenuList, true);
		}
		else
		{
			trees = getTrees(menuList, false, null, true);
		}
		return trees;
	}

	@Override
	public List<Map<String, Object>> menuTreeData() {
		List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();
		List<KnowledgeMenu> menuList = knowledgeMenuMapper.selectMenuAll();
		trees = getTrees(menuList, false, null, false);
		return trees;
	}

	@Override
	public List<Map<String, Object>> menuTreeData1() {
		List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();
		List<KnowledgeMenu> menuList = knowledgeMenuMapper.selectMenuAll();
		trees = getTrees1(menuList, false, null);
		return trees;
	}

	@Override
	public Map<String, String> selectPermsAll() {
		LinkedHashMap<String, String> section = new LinkedHashMap<>();
		List<KnowledgeMenu> permissions = knowledgeMenuMapper.selectMenuAll();
		if (StringUtils.isNotEmpty(permissions))
		{
			for (KnowledgeMenu menu : permissions)
			{
				section.put(menu.getUrl(), MessageFormat.format(PREMISSION_STRING, menu.getPerms()));
			}
		}
		return section;
	}

	/**
     * 查询菜单权限信息
         * @param menuId 菜单权限ID
     * @return 菜单权限信息
     */
    @Override
	public KnowledgeMenu selectKnowledgeMenuById(Long menuId)
	{
	    return knowledgeMenuMapper.selectKnowledgeMenuById(menuId);
	}

	@Override
	public KnowledgeMenu selectMenuById(Long menuId) {
		return knowledgeMenuMapper.selectMenuById(menuId);
	}

	@Override
	public int selectCountMenuByParentId(Long parentId) {
		return knowledgeMenuMapper.selectCountMenuByParentId(parentId);
	}

	/**
	 * 查询菜单使用数量
	 *
	 * @param menuId 菜单ID
	 * @return 结果
	 */
	@Override
	public int selectCountRoleMenuByMenuId(Long menuId)
	{
		return roleMenuMapper.selectCountRoleMenuByMenuId(menuId);
	}

	/**
     * 查询菜单权限列表
         * @param knowledgeMenu 菜单权限信息
     * @return 菜单权限集合
     */
	@Override
	public List<KnowledgeMenu> selectKnowledgeMenuList(KnowledgeMenu knowledgeMenu)
	{
	    return knowledgeMenuMapper.selectKnowledgeMenuList(knowledgeMenu);
	}
	
    /**
     * 新增菜单权限
         * @param knowledgeMenu 菜单权限信息
     * @return 结果
     */
	@Override
	public int insertKnowledgeMenu(KnowledgeMenu knowledgeMenu)
	{
	    return knowledgeMenuMapper.insertKnowledgeMenu(knowledgeMenu);
	}
	
	/**
     * 修改菜单权限
         * @param knowledgeMenu 菜单权限信息
     * @return 结果
     */
	@Override
	public int updateKnowledgeMenu(KnowledgeMenu knowledgeMenu)
	{
	    return knowledgeMenuMapper.updateKnowledgeMenu(knowledgeMenu);
	}

	/**
     * 删除菜单权限对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteKnowledgeMenuByIds(String ids)
	{
		return knowledgeMenuMapper.deleteKnowledgeMenuByIds(Convert.toStrArray(ids));
	}
	/**
	 * 删除菜单管理信息
	 *
	 * @param menuId 菜单ID
	 * @return 结果
	 */
	@Override
	public int deleteMenuById(Long menuId)
	{
		return knowledgeMenuMapper.deleteMenuById(menuId);
	}

	@Override
	public String checkMenuNameUnique(KnowledgeMenu menu) {
		Long menuId = StringUtils.isNull(menu.getMenuId()) ? -1L : menu.getMenuId();
		KnowledgeMenu info = knowledgeMenuMapper.checkMenuNameUnique(menu.getMenuName(), menu.getParentId());
		if (StringUtils.isNotNull(info) && info.getMenuId().longValue() != menuId.longValue())
		{
			return UserConstants.MENU_NAME_NOT_UNIQUE;
		}
		return UserConstants.MENU_NAME_UNIQUE;
	}

	/**
	 * 根据父节点的ID获取所有子节点
	 *
	 * @param list 分类表
	 * @param parentId 传入的父节点ID
	 * @return String
	 */
	public List<KnowledgeMenu> getChildPerms(List<KnowledgeMenu> list, int parentId)
	{
		List<KnowledgeMenu> returnList = new ArrayList<KnowledgeMenu>();
		for (Iterator<KnowledgeMenu> iterator = list.iterator(); iterator.hasNext();)
		{
			KnowledgeMenu t = (KnowledgeMenu) iterator.next();
			// 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
			if (t.getParentId() == parentId)
			{
				recursionFn(list, t);
				returnList.add(t);
			}
		}
		return returnList;
	}

	/**
	 * 递归列表
	 *
	 * @param list
	 * @param t
	 */
	private void recursionFn(List<KnowledgeMenu> list, KnowledgeMenu t)
	{
		// 得到子节点列表
		List<KnowledgeMenu> childList = getChildList(list, t);
		t.setChildren(childList);
		for (KnowledgeMenu tChild : childList)
		{
			if (hasChild(list, tChild))
			{
				// 判断是否有子节点
				Iterator<KnowledgeMenu> it = childList.iterator();
				while (it.hasNext())
				{
					KnowledgeMenu n = (KnowledgeMenu) it.next();
					recursionFn(list, n);
				}
			}
		}
	}

	/**
	 * 得到子节点列表
	 */
	private List<KnowledgeMenu> getChildList(List<KnowledgeMenu> list, KnowledgeMenu t)
	{
		List<KnowledgeMenu> tlist = new ArrayList<KnowledgeMenu>();
		Iterator<KnowledgeMenu> it = list.iterator();
		while (it.hasNext())
		{
			KnowledgeMenu n = (KnowledgeMenu) it.next();
			if (n.getParentId().longValue() == t.getMenuId().longValue())
			{
				tlist.add(n);
			}
		}
		return tlist;
	}

	/**
	 * 判断是否有子节点
	 */
	private boolean hasChild(List<KnowledgeMenu> list, KnowledgeMenu t)
	{
		return getChildList(list, t).size() > 0 ? true : false;
	}

	/**
	 * 对象转菜单树
	 *
	 * @param menuList 菜单列表
	 * @param isCheck 是否需要选中
	 * @param roleMenuList 角色已存在菜单列表
	 * @param permsFlag 是否需要显示权限标识
	 * @return
	 */
	public List<Map<String, Object>> getTrees(List<KnowledgeMenu> menuList, boolean isCheck, List<String> roleMenuList,
											  boolean permsFlag)
	{
		List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();
		for (KnowledgeMenu menu : menuList)
		{
			Map<String, Object> deptMap = new HashMap<String, Object>();
			deptMap.put("id", menu.getMenuId());
			deptMap.put("pId", menu.getParentId());
			deptMap.put("name", transMenuName(menu, roleMenuList, permsFlag));
			deptMap.put("title", menu.getMenuName());
			if (isCheck)
			{
				deptMap.put("checked", roleMenuList.contains(menu.getMenuId() + menu.getPerms()));
			}
			else
			{
				deptMap.put("checked", false);
			}
			trees.add(deptMap);
		}
		return trees;
	}

	public String transMenuName(KnowledgeMenu menu, List<String> roleMenuList, boolean permsFlag)
	{
		StringBuffer sb = new StringBuffer();
		sb.append(menu.getMenuName());
		if (permsFlag)
		{
			sb.append("<font color=\"#888\">&nbsp;&nbsp;&nbsp;" + menu.getPerms() + "</font>");
		}
		return sb.toString();
	}

	/**
	 * 对象转分部树
	 *
	 * @param menuList 菜单列表
	 * @param isCheck 是否需要选中
	 * @param roleMenuList 角色已存在菜单列表
	 * @return
	 */
	public List<Map<String, Object>> getTrees1(List<KnowledgeMenu> menuList, boolean isCheck, List<String> roleMenuList)
	{

		List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();
		for (KnowledgeMenu menu : menuList)
		{
			Map<String, Object> deptMap = new HashMap<String, Object>();
			deptMap.put("id", menu.getMenuId());
			deptMap.put("pId", menu.getParentId());
			deptMap.put("name", menu.getMenuName());
			deptMap.put("title", menu.getMenuName());
			if (isCheck)
			{
				deptMap.put("checked", roleMenuList.contains(menu.getMenuId() + menu.getMenuName()));
			}
			else
			{
				deptMap.put("checked", false);
			}
			trees.add(deptMap);
		}
		return trees;
	}

}
