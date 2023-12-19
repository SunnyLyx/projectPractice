package edu.fosu.teach.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.TeachClassStatisticsMapper;
import edu.fosu.teach.domain.TeachClassStatistics;
import edu.fosu.teach.service.ITeachClassStatisticsService;
import edu.fosu.common.support.Convert;

/**
 * 数据汇总（班级） 服务层实现
 *  */
@Service
public class TeachClassStatisticsServiceImpl implements ITeachClassStatisticsService 
{
	@Autowired
	private TeachClassStatisticsMapper teachClassStatisticsMapper;

	/**
     * 查询数据汇总（班级）信息
         * @param id 数据汇总（班级）ID
     * @return 数据汇总（班级）信息
     */
    @Override
	public TeachClassStatistics selectTeachClassStatisticsById(Integer id)
	{
	    return teachClassStatisticsMapper.selectTeachClassStatisticsById(id);
	}
	
	/**
     * 查询数据汇总（班级）列表
         * @param teachClassStatistics 数据汇总（班级）信息
     * @return 数据汇总（班级）集合
     */
	@Override
	public List<TeachClassStatistics> selectTeachClassStatisticsList(TeachClassStatistics teachClassStatistics)
	{
	    return teachClassStatisticsMapper.selectTeachClassStatisticsList(teachClassStatistics);
	}
	
    /**
     * 新增数据汇总（班级）
         * @param teachClassStatistics 数据汇总（班级）信息
     * @return 结果
     */
	@Override
	public int insertTeachClassStatistics(TeachClassStatistics teachClassStatistics)
	{
	    return teachClassStatisticsMapper.insertTeachClassStatistics(teachClassStatistics);
	}
	
	/**
     * 修改数据汇总（班级）
         * @param teachClassStatistics 数据汇总（班级）信息
     * @return 结果
     */
	@Override
	public int updateTeachClassStatistics(TeachClassStatistics teachClassStatistics)
	{
	    return teachClassStatisticsMapper.updateTeachClassStatistics(teachClassStatistics);
	}

	/**
     * 删除数据汇总（班级）对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachClassStatisticsByIds(String ids)
	{
		return teachClassStatisticsMapper.deleteTeachClassStatisticsByIds(Convert.toStrArray(ids));
	}
	
}
