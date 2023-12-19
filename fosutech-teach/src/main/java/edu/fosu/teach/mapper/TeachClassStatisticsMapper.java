package edu.fosu.teach.mapper;

import edu.fosu.teach.domain.TeachClassStatistics;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import edu.fosu.common.base.BaseMapper;

/**
 * 数据汇总（班级） 数据层
 * 集成BaseMapper 长用的方式可以共用
 *  */
@MapperScan
public interface TeachClassStatisticsMapper  extends BaseMapper<TeachClassStatistics>
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
     * 删除数据汇总（班级）
         * @param id 数据汇总（班级）ID
     * @return 结果
     */
	public int deleteTeachClassStatisticsById(Integer id);
	
	/**
     * 批量删除数据汇总（班级）
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachClassStatisticsByIds(String[] ids);
	
}