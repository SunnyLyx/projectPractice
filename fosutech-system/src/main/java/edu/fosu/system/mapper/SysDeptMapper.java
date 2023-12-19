package edu.fosu.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import edu.fosu.system.domain.SysDept;

/**
 * 分部管理 数据层
 */
public interface SysDeptMapper
{
    /**
     * 查询分部人数
         * @param dept 分部信息
     * @return 结果
     */
    public int selectDeptCount(SysDept dept);

    /**
     * 查询分部是否存在用户
         * @param deptId 分部ID
     * @return 结果
     */
    public int checkDeptExistUser(Long deptId);

    /**
     * 查询分部管理数据
         * @param dept 分部信息
     * @return 分部信息集合
     */
    public List<SysDept> selectDeptList(SysDept dept);

    /**
     * 删除分部管理信息
         * @param deptId 分部ID
     * @return 结果
     */
    public int deleteDeptById(Long deptId);

    /**
     * 新增分部信息
         * @param dept 分部信息
     * @return 结果
     */
    public int insertDept(SysDept dept);

    /**
     * 修改分部信息
         * @param dept 分部信息
     * @return 结果
     */
    public int updateDept(SysDept dept);

    /**
     * 修改子元素关系
         * @param depts 子元素
     * @return 结果
     */
    public int updateDeptChildren(@Param("depts") List<SysDept> depts);

    /**
     * 根据分部ID查询信息
         * @param deptId 分部ID
     * @return 分部信息
     */
    public SysDept selectDeptById(Long deptId);

    /**
     * 校验分部名称是否唯一
         * @param deptName 分部名称
     * @param parentId 父分部ID
     * @return 结果
     */
    public SysDept checkDeptNameUnique(@Param("deptName") String deptName, @Param("parentId") Long parentId);

    /**
     * 根据角色ID查询分部
     *
     * @param roleId 角色ID
     * @return 分部列表
     */
    public List<String> selectRoleDeptTree(Long roleId);

    /**
     * 修改所在分部的父级分部状态
         * @param dept 分部
     */
    public void updateDeptStatus(SysDept dept);
}
