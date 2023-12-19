package edu.fosu.teach.service;

import edu.fosu.teach.domain.TeachClassStatistics;
import java.util.List;

/**
 * 数据汇总（班级） 服务层
 *  */
public interface ITeachClassStatisticsService 
{
	/**
     * 查询数据汇总（班级）信息
         * @param id 数据汇总（班级）ID
     * @return 数据汇总（班级）信息
     */
	public TeachClassStatistics selectTeachClassStatisticsById(Integer id);
	
	/**
     * 查询数据汇总（班级）列表
         * @param teachClassStatistics 数据汇总（班级）信息
     * @return 数据汇总（班级）集合
     */
	public List<TeachClassStatistics> selectTeachClassStatisticsList(TeachClassStatistics teachClassStatistics);
	
	/**
     * 新增数据汇总（班级）
         * @param teachClassStatistics 数据汇总（班级）信息
     * @return 结果
     */
	public int insertTeachClassStatistics(TeachClassStatistics teachClassStatistics);
	
	/**
     * 修改数据汇总（班级）
         * @param teachClassStatistics 数据汇总（班级）信息
     * @return 结果
     */
	public int updateTeachClassStatistics(TeachClassStatistics teachClassStatistics);
		
	/**
     * 删除数据汇总（班级）信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachClassStatisticsByIds(String ids);
	
}
