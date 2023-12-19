package edu.fosu.system.mapper;

import java.util.List;
import edu.fosu.system.domain.SysRoleDept;

/**
 * 角色与分部关联表 数据层
 */
public interface SysRoleDeptMapper
{
    /**
     * 通过角色ID删除角色和分部关联
         * @param roleId 角色ID
     * @return 结果
     */
    public int deleteRoleDeptByRoleId(Long roleId);

    /**
     * 批量删除角色分部关联信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRoleDept(Long[] ids);

    /**
     * 查询分部使用数量
         * @param deptId 分部ID
     * @return 结果
     */
    public int selectCountRoleDeptByDeptId(Long deptId);

    /**
     * 批量新增角色分部信息
         * @param roleDeptList 角色分部列表
     * @return 结果
     */
    public int batchRoleDept(List<SysRoleDept> roleDeptList);
}
