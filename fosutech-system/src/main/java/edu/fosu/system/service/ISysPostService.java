package edu.fosu.system.service;

import java.util.List;
import edu.fosu.system.domain.SysPost;

/**
 * 职位信息 服务层
 */
public interface ISysPostService
{
    /**
     * 查询职位信息集合
         * @param post 职位信息
     * @return 职位信息集合
     */
    public List<SysPost> selectPostList(SysPost post);

    /**
     * 查询所有职位
         * @return 职位列表
     */
    public List<SysPost> selectPostAll();

    /**
     * 根据用户ID查询职位
         * @param userId 用户ID
     * @return 职位列表
     */
    public List<SysPost> selectPostsByUserId(Long userId);

    /**
     * 通过职位ID查询职位信息
         * @param postId 职位ID
     * @return 角色对象信息
     */
    public SysPost selectPostById(Long postId);

    /**
     * 批量删除职位信息
         * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
    public int deletePostByIds(String ids) throws Exception;

    /**
     * 新增保存职位信息
         * @param post 职位信息
     * @return 结果
     */
    public int insertPost(SysPost post);

    /**
     * 修改保存职位信息
         * @param post 职位信息
     * @return 结果
     */
    public int updatePost(SysPost post);

    /**
     * 通过职位ID查询职位使用数量
         * @param postId 职位ID
     * @return 结果
     */
    public int countUserPostById(Long postId);

    /**
     * 校验职位名称
         * @param post 职位信息
     * @return 结果
     */
    public String checkPostNameUnique(SysPost post);

    /**
     * 校验职位编码
         * @param post 职位信息
     * @return 结果
     */
    public String checkPostCodeUnique(SysPost post);
}
