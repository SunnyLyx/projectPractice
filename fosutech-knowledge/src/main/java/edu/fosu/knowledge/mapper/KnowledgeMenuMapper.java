package edu.fosu.knowledge.mapper;

import edu.fosu.knowledge.domain.KnowledgeMenu;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.spring.annotation.MapperScan;
import edu.fosu.common.base.BaseMapper;

/**
 * 菜单权限 数据层
 * 集成BaseMapper 长用的方式可以共用
 *  */
@MapperScan
public interface KnowledgeMenuMapper  extends BaseMapper<KnowledgeMenu>
{
	/**
	 * 查询系统所有菜单（含按钮）
	 *
	 * @return 菜单列表
	 */
	public List<KnowledgeMenu> selectMenuAll();

	/**
	 * 查询系统正常显示菜单（不含按钮）
	 *
	 * @return 菜单列表
	 */
	public List<KnowledgeMenu> selectMenuNormalAll();

	/**
	 * 根据用户ID查询菜单
	 *
	 * @param userId 用户ID
	 * @return 菜单列表
	 */
	public List<KnowledgeMenu> selectMenusByUserId(Long userId);

	/**
	 * 根据用户ID查询权限
	 *
	 * @param userId 用户ID
	 * @return 权限列表
	 */
	public List<String> selectPermsByUserId(Long userId);

	/**
	 * 根据角色ID查询菜单
	 *
	 * @param roleId 角色ID
	 * @return 菜单列表
	 */
	public List<String> selectMenuTree(Long roleId);

	/**
     * 查询菜单权限信息
         * @param menuId 菜单权限ID
     * @return 菜单权限信息
     */
	public KnowledgeMenu selectKnowledgeMenuById(Long menuId);
	
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
     * 删除菜单权限
         * @param menuId 菜单权限ID
     * @return 结果
     */
	public int deleteKnowledgeMenuById(Long menuId);
	
	/**
     * 批量删除菜单权限
         * @param menuIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteKnowledgeMenuByIds(String[] menuIds);
	/**
	 * 删除菜单管理信息
	 *
	 * @param menuId 菜单ID
	 * @return 结果
	 */
	public int deleteMenuById(Long menuId);

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
	 * 校验菜单名称是否唯一
	 *
	 * @param menuName 菜单名称
	 * @param parentId 父菜单ID
	 * @return 结果
	 */
	public KnowledgeMenu checkMenuNameUnique(@Param("menuName") String menuName, @Param("parentId") Long parentId);
	
}