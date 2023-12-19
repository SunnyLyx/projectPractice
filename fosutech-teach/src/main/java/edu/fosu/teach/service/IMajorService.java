package edu.fosu.teach.service;

import edu.fosu.teach.domain.Major;
import java.util.List;

/**
 * 专业 服务层
 *  */
public interface IMajorService 
{
	/**
     * 查询专业信息
         * @param majorId 专业ID
     * @return 专业信息
     */
	public Major selectMajorById(Integer majorId);
	
	/**
     * 查询专业列表
         * @param major 专业信息
     * @return 专业集合
     */
	public List<Major> selectMajorList(Major major);
	
	/**
     * 新增专业
         * @param major 专业信息
     * @return 结果
     */
	public int insertMajor(Major major);
	
	/**
     * 修改专业
         * @param major 专业信息
     * @return 结果
     */
	public int updateMajor(Major major);
		
	/**
     * 删除专业信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMajorByIds(String ids);
	
}
