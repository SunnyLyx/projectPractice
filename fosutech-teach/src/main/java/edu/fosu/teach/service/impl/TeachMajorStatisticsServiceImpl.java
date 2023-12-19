package edu.fosu.teach.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.TeachMajorStatisticsMapper;
import edu.fosu.teach.domain.TeachMajorStatistics;
import edu.fosu.teach.service.ITeachMajorStatisticsService;
import edu.fosu.common.support.Convert;

/**
 * 数据汇总（专业） 服务层实现
 *  */
@Service
public class TeachMajorStatisticsServiceImpl implements ITeachMajorStatisticsService 
{
	@Autowired
	private TeachMajorStatisticsMapper teachMajorStatisticsMapper;

	/**
     * 查询数据汇总（专业）信息
         * @param id 数据汇总（专业）ID
     * @return 数据汇总（专业）信息
     */
    @Override
	public TeachMajorStatistics selectTeachMajorStatisticsById(Integer id)
	{
	    return teachMajorStatisticsMapper.selectTeachMajorStatisticsById(id);
	}
	
	/**
     * 查询数据汇总（专业）列表
         * @param teachMajorStatistics 数据汇总（专业）信息
     * @return 数据汇总（专业）集合
     */
	@Override
	public List<TeachMajorStatistics> selectTeachMajorStatisticsList(TeachMajorStatistics teachMajorStatistics)
	{
	    return teachMajorStatisticsMapper.selectTeachMajorStatisticsList(teachMajorStatistics);
	}
	
    /**
     * 新增数据汇总（专业）
         * @param teachMajorStatistics 数据汇总（专业）信息
     * @return 结果
     */
	@Override
	public int insertTeachMajorStatistics(TeachMajorStatistics teachMajorStatistics)
	{
	    return teachMajorStatisticsMapper.insertTeachMajorStatistics(teachMajorStatistics);
	}
	
	/**
     * 修改数据汇总（专业）
         * @param teachMajorStatistics 数据汇总（专业）信息
     * @return 结果
     */
	@Override
	public int updateTeachMajorStatistics(TeachMajorStatistics teachMajorStatistics)
	{
	    return teachMajorStatisticsMapper.updateTeachMajorStatistics(teachMajorStatistics);
	}

	/**
     * 删除数据汇总（专业）对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachMajorStatisticsByIds(String ids)
	{
		return teachMajorStatisticsMapper.deleteTeachMajorStatisticsByIds(Convert.toStrArray(ids));
	}
	
}
