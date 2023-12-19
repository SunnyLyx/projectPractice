package edu.fosu.system.service;

import java.util.List;
import java.util.Map;
import edu.fosu.system.domain.SysDept;
import edu.fosu.system.domain.SysRole;

/**
 * 分部管理 服务层
 */
public interface ISysDeptService
{
    /**
     * 查询分部管理数据
         * @param dept 分部信息
     * @return 分部信息集合
     */
    public List<SysDept> selectDeptList(SysDept dept);

    /**
     * 查询分部管理树
         * @param dept 分部信息
     * @return 所有分部信息
     */
    public List<Map<String, Object>> selectDeptTree(SysDept dept);

    /**
     * 根据角色ID查询菜单
     *
     * @param role 角色对象
     * @return 菜单列表
     */
    public List<Map<String, Object>> roleDeptTreeData(SysRole role);

    /**
     * 查询分部人数
         * @param parentId 父分部ID
     * @return 结果
     */
    public int selectDeptCount(Long parentId);

    /**
     * 查询分部是否存在用户
         * @param deptId 分部ID
     * @return 结果 true 存在 false 不存在
     */
    public boolean checkDeptExistUser(Long deptId);

    /**
     * 删除分部管理信息
         * @param deptId 部门ID
     * @return 结果
     */
    public int deleteDeptById(Long deptId);

    /**
     * 新增保存部门信息
         * @param dept 部门信息
     * @return 结果
     */
    public int insertDept(SysDept dept);

    /**
     * 修改保存部门信息
         * @param dept 部门信息
     * @return 结果
     */
    public int updateDept(SysDept dept);

    /**
     * 根据部门ID查询信息
         * @param deptId 部门ID
     * @return 部门信息
     */
    public SysDept selectDeptById(Long deptId);

    /**
     * 校验部门名称是否唯一
         * @param dept 部门信息
     * @return 结果
     */
    public String checkDeptNameUnique(SysDept dept);
}
