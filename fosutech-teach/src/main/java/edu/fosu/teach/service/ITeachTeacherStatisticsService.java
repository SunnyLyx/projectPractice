package edu.fosu.teach.service;

import edu.fosu.teach.domain.TeachTeacherStatistics;
import java.util.List;

/**
 * 数据汇总（教师） 服务层
 *  */
public interface ITeachTeacherStatisticsService 
{
	/**
     * 查询数据汇总（教师）信息
         * @param id 数据汇总（教师）ID
     * @return 数据汇总（教师）信息
     */
	public TeachTeacherStatistics selectTeachTeacherStatisticsById(Integer id);
	
	/**
     * 查询数据汇总（教师）列表
         * @param teachTeacherStatistics 数据汇总（教师）信息
     * @return 数据汇总（教师）集合
     */
	public List<TeachTeacherStatistics> selectTeachTeacherStatisticsList(TeachTeacherStatistics teachTeacherStatistics);
	
	/**
     * 新增数据汇总（教师）
         * @param teachTeacherStatistics 数据汇总（教师）信息
     * @return 结果
     */
	public int insertTeachTeacherStatistics(TeachTeacherStatistics teachTeacherStatistics);
	
	/**
     * 修改数据汇总（教师）
         * @param teachTeacherStatistics 数据汇总（教师）信息
     * @return 结果
     */
	public int updateTeachTeacherStatistics(TeachTeacherStatistics teachTeacherStatistics);
		
	/**
     * 删除数据汇总（教师）信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachTeacherStatisticsByIds(String ids);
	
}
