package edu.fosu.system.mapper;

import java.util.List;
import edu.fosu.system.domain.SysPost;

/**
 * 职位信息 数据层
 */
public interface SysPostMapper
{
    /**
     * 查询职位数据集合
         * @param post 职位信息
     * @return 职位数据集合
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
     */
    public int deletePostByIds(Long[] ids);

    /**
     * 修改职位信息
         * @param post 职位信息
     * @return 结果
     */
    public int updatePost(SysPost post);

    /**
     * 新增职位信息
         * @param post 职位信息
     * @return 结果
     */
    public int insertPost(SysPost post);

    /**
     * 校验职位名称
         * @param postName 职位名称
     * @return 结果
     */
    public SysPost checkPostNameUnique(String postName);

    /**
     * 校验职位编码
         * @param postCode 职位编码
     * @return 结果
     */
    public SysPost checkPostCodeUnique(String postCode);
}
