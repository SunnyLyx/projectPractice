package edu.fosu.teach.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.TeachExamStatisticsMapper;
import edu.fosu.teach.domain.TeachExamStatistics;
import edu.fosu.teach.service.ITeachExamStatisticsService;
import edu.fosu.common.support.Convert;

/**
 * 考试统计 服务层实现
 *  */
@Service
public class TeachExamStatisticsServiceImpl implements ITeachExamStatisticsService 
{
	@Autowired
	private TeachExamStatisticsMapper teachExamStatisticsMapper;

	/**
     * 查询考试统计信息
         * @param id 考试统计ID
     * @return 考试统计信息
     */
    @Override
	public TeachExamStatistics selectTeachExamStatisticsById(Integer id)
	{
	    return teachExamStatisticsMapper.selectTeachExamStatisticsById(id);
	}
	
	/**
     * 查询考试统计列表
         * @param teachExamStatistics 考试统计信息
     * @return 考试统计集合
     */
	@Override
	public List<TeachExamStatistics> selectTeachExamStatisticsList(TeachExamStatistics teachExamStatistics)
	{
	    return teachExamStatisticsMapper.selectTeachExamStatisticsList(teachExamStatistics);
	}
	
    /**
     * 新增考试统计
         * @param teachExamStatistics 考试统计信息
     * @return 结果
     */
	@Override
	public int insertTeachExamStatistics(TeachExamStatistics teachExamStatistics)
	{
	    return teachExamStatisticsMapper.insertTeachExamStatistics(teachExamStatistics);
	}
	
	/**
     * 修改考试统计
         * @param teachExamStatistics 考试统计信息
     * @return 结果
     */
	@Override
	public int updateTeachExamStatistics(TeachExamStatistics teachExamStatistics)
	{
	    return teachExamStatisticsMapper.updateTeachExamStatistics(teachExamStatistics);
	}

	/**
     * 删除考试统计对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachExamStatisticsByIds(String ids)
	{
		return teachExamStatisticsMapper.deleteTeachExamStatisticsByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<TeachExamStatistics> selectTeachExamStatisticsTask()
	{
		return teachExamStatisticsMapper.selectTeachExamStatisticsTask();
	}
}
