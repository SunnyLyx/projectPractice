package edu.fosu.teach.service;

import edu.fosu.teach.domain.TeachMajor;

import java.util.HashMap;
import java.util.List;

/**
 * 专业 服务层
 *  */
public interface ITeachMajorService 
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

	HashMap<String, List<TeachMajor>> selectTeachMajorListAndStage(TeachMajor teachMajor);

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
     * 删除专业信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachMajorByIds(String ids);

	/**
	 * 查询最新id
	 * @return
	 */
	public int selectId();

	/**
	 * 查询id数量
	 */
	public int selectCountNum();

	/**
	 * 校验专业名称是否唯一
	 *
	 * @param teachMajor
	 * @return 结果
	 */
	public String checkMajorNameUnique(TeachMajor teachMajor);
	
}
