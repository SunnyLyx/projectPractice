package edu.fosu.teach.mapper;

import edu.fosu.teach.domain.TeachMajorStatistics;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import edu.fosu.common.base.BaseMapper;

/**
 * 数据汇总（专业） 数据层
 * 集成BaseMapper 长用的方式可以共用
 *  */
@MapperScan
public interface TeachMajorStatisticsMapper  extends BaseMapper<TeachMajorStatistics>
{
	/**
     * 查询数据汇总（专业）信息
         * @param id 数据汇总（专业）ID
     * @return 数据汇总（专业）信息
     */
	public TeachMajorStatistics selectTeachMajorStatisticsById(Integer id);
	
	/**
     * 查询数据汇总（专业）列表
         * @param teachMajorStatistics 数据汇总（专业）信息
     * @return 数据汇总（专业）集合
     */
	public List<TeachMajorStatistics> selectTeachMajorStatisticsList(TeachMajorStatistics teachMajorStatistics);
	
	/**
     * 新增数据汇总（专业）
         * @param teachMajorStatistics 数据汇总（专业）信息
     * @return 结果
     */
	public int insertTeachMajorStatistics(TeachMajorStatistics teachMajorStatistics);
	
	/**
     * 修改数据汇总（专业）
         * @param teachMajorStatistics 数据汇总（专业）信息
     * @return 结果
     */
	public int updateTeachMajorStatistics(TeachMajorStatistics teachMajorStatistics);
	
	/**
     * 删除数据汇总（专业）
         * @param id 数据汇总（专业）ID
     * @return 结果
     */
	public int deleteTeachMajorStatisticsById(Integer id);
	
	/**
     * 批量删除数据汇总（专业）
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachMajorStatisticsByIds(String[] ids);
	
}