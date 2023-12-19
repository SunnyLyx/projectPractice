package edu.fosu.teach.mapper;

import edu.fosu.teach.domain.TeachMajor;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import edu.fosu.common.base.BaseMapper;

/**
 * 专业 数据层
 * 集成BaseMapper 长用的方式可以共用
 *  */
@MapperScan
public interface TeachMajorMapper  extends BaseMapper<TeachMajor>
{
	/**
     * 查询专业信息
         * @param majorId 专业ID
     * @return 专业信息
     */
	public TeachMajor selectTeachMajorById(Integer majorId);
	
	/**
     * 查询专业列表
         * @param teachMajor 专业信息
     * @return 专业集合
     */
	public List<TeachMajor> selectTeachMajorList(TeachMajor teachMajor);
	
	/**
     * 新增专业
         * @param teachMajor 专业信息
     * @return 结果
     */
	public int insertTeachMajor(TeachMajor teachMajor);
	
	/**
     * 修改专业
         * @param teachMajor 专业信息
     * @return 结果
     */
	public int updateTeachMajor(TeachMajor teachMajor);
	
	/**
     * 删除专业
         * @param majorId 专业ID
     * @return 结果
     */
	public int deleteTeachMajorById(Integer majorId);
	
	/**
     * 批量删除专业
         * @param majorIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachMajorByIds(String[] majorIds);

	/**
	 * 查询最新id
	 * @return
	 */
	public int selectId();

	/**
	 * 查询id有没有值
	 */
	public int selectCountNum();

	/**
	 * 校验专业名称是否唯一
	 *
	 * @param majorName 专业名称
	 * @return 结果
	 */
	public TeachMajor checkMajorNameUnique(String majorName);
	
}