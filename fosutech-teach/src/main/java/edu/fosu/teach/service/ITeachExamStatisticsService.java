package edu.fosu.teach.service;

import edu.fosu.teach.domain.TeachExamStatistics;
import java.util.List;

/**
 * 考试统计 服务层
 *  */
public interface ITeachExamStatisticsService 
{
	/**
     * 查询考试统计信息
         * @param id 考试统计ID
     * @return 考试统计信息
     */
	public TeachExamStatistics selectTeachExamStatisticsById(Integer id);
	
	/**
     * 查询考试统计列表
         * @param teachExamStatistics 考试统计信息
     * @return 考试统计集合
     */
	public List<TeachExamStatistics> selectTeachExamStatisticsList(TeachExamStatistics teachExamStatistics);
	
	/**
     * 新增考试统计
         * @param teachExamStatistics 考试统计信息
     * @return 结果
     */
	public int insertTeachExamStatistics(TeachExamStatistics teachExamStatistics);
	
	/**
     * 修改考试统计
         * @param teachExamStatistics 考试统计信息
     * @return 结果
     */
	public int updateTeachExamStatistics(TeachExamStatistics teachExamStatistics);
		
	/**
     * 删除考试统计信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachExamStatisticsByIds(String ids);

	/**
	 * 统计考试信息
	 * @return
	 */
	List<TeachExamStatistics> selectTeachExamStatisticsTask();
}
