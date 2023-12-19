package edu.fosu.knowledge.service;

import edu.fosu.knowledge.domain.KnowledgeMenu;
import edu.fosu.system.domain.SysRole;
import edu.fosu.system.domain.SysUser;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 菜单权限 服务层
 *  */
public interface IKnowledgeMenuService 
{
	/**
	 * 根据用户ID查询菜单
	 *
	 * @param user 用户信息
	 * @return 菜单列表
	 */
	public List<KnowledgeMenu> selectMenusByUser(SysUser user);

	/**
	 * 查询菜单集合
	 *
	 * @return 所有菜单信息
	 */
	public List<KnowledgeMenu> selectMenuAll();

	/**
	 * 根据用户ID查询权限
	 *
	 * @param userId 用户ID
	 * @return 权限列表
	 */
	public Set<String> selectPermsByUserId(Long userId);

	/**
	 * 根据角色ID查询菜单
	 *
	 * @param role 角色对象
	 * @return 菜单列表
	 */
	public List<Map<String, Object>> roleMenuTreeData(SysRole role);

	/**
	 * 查询所有菜单信息
	 *
	 * @return 菜单列表
	 */
	public List<Map<String, Object>> menuTreeData();
	public List<Map<String, Object>> menuTreeData1();

	/**
	 * 查询系统所有权限
	 *
	 * @return 权限列表
	 */
	public Map<String, String> selectPermsAll();

	/**
     * 查询菜单权限信息
         * @param menuId 菜单权限ID
     * @return 菜单权限信息
     */
	public KnowledgeMenu selectKnowledgeMenuById(Long menuId);
	/**
	 * 根据菜单ID查询信息
	 *
	 * @param menuId 菜单ID
	 * @return 菜单信息
	 */
	public KnowledgeMenu selectMenuById(Long menuId);

	/**
	 * 查询菜单数量
	 *
	 * @param parentId 菜单父ID
	 * @return 结果
	 */
	public int selectCountMenuByParentId(Long parentId);

	/**
	 * 查询菜单使用数量
	 *
	 * @param menuId 菜单ID
	 * @return 结果
	 */
	public int selectCountRoleMenuByMenuId(Long menuId);
	
	/**
     * 查询菜单权限列表
         * @param knowledgeMenu 菜单权限信息
     * @return 菜单权限集合
     */
	public List<KnowledgeMenu> selectKnowledgeMenuList(KnowledgeMenu knowledgeMenu);
	
	/**
     * 新增菜单权限
         * @param knowledgeMenu 菜单权限信息
     * @return 结果
     */
	public int insertKnowledgeMenu(KnowledgeMenu knowledgeMenu);
	
	/**
     * 修改菜单权限
         * @param knowledgeMenu 菜单权限信息
     * @return 结果
     */
	public int updateKnowledgeMenu(KnowledgeMenu knowledgeMenu);
		
	/**
     * 删除菜单权限信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteKnowledgeMenuByIds(String ids);
	/**
	 * 删除菜单管理信息
	 *
	 * @param menuId 菜单ID
	 * @return 结果
	 */
	public int deleteMenuById(Long menuId);

	/**
	 * 校验菜单名称是否唯一
	 *
	 * @param menu 菜单信息
	 * @return 结果
	 */
	public String checkMenuNameUnique(KnowledgeMenu menu);
	
}
