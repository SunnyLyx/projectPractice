package edu.fosu.teach.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.TeachTeacherStatisticsMapper;
import edu.fosu.teach.domain.TeachTeacherStatistics;
import edu.fosu.teach.service.ITeachTeacherStatisticsService;
import edu.fosu.common.support.Convert;

/**
 * 数据汇总（教师） 服务层实现
 *  */
@Service
public class TeachTeacherStatisticsServiceImpl implements ITeachTeacherStatisticsService 
{
	@Autowired
	private TeachTeacherStatisticsMapper teachTeacherStatisticsMapper;

	/**
     * 查询数据汇总（教师）信息
         * @param id 数据汇总（教师）ID
     * @return 数据汇总（教师）信息
     */
    @Override
	public TeachTeacherStatistics selectTeachTeacherStatisticsById(Integer id)
	{
	    return teachTeacherStatisticsMapper.selectTeachTeacherStatisticsById(id);
	}
	
	/**
     * 查询数据汇总（教师）列表
         * @param teachTeacherStatistics 数据汇总（教师）信息
     * @return 数据汇总（教师）集合
     */
	@Override
	public List<TeachTeacherStatistics> selectTeachTeacherStatisticsList(TeachTeacherStatistics teachTeacherStatistics)
	{
	    return teachTeacherStatisticsMapper.selectTeachTeacherStatisticsList(teachTeacherStatistics);
	}
	
    /**
     * 新增数据汇总（教师）
         * @param teachTeacherStatistics 数据汇总（教师）信息
     * @return 结果
     */
	@Override
	public int insertTeachTeacherStatistics(TeachTeacherStatistics teachTeacherStatistics)
	{
	    return teachTeacherStatisticsMapper.insertTeachTeacherStatistics(teachTeacherStatistics);
	}
	
	/**
     * 修改数据汇总（教师）
         * @param teachTeacherStatistics 数据汇总（教师）信息
     * @return 结果
     */
	@Override
	public int updateTeachTeacherStatistics(TeachTeacherStatistics teachTeacherStatistics)
	{
	    return teachTeacherStatisticsMapper.updateTeachTeacherStatistics(teachTeacherStatistics);
	}

	/**
     * 删除数据汇总（教师）对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachTeacherStatisticsByIds(String ids)
	{
		return teachTeacherStatisticsMapper.deleteTeachTeacherStatisticsByIds(Convert.toStrArray(ids));
	}
	
}
