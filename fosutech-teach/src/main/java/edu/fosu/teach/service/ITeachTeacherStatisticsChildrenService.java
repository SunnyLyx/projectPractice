package edu.fosu.teach.service;

import edu.fosu.teach.domain.TeachTeacherStatisticsChildren;
import java.util.List;

/**
 * 数据统计（教师）子 服务层
 *  */
public interface ITeachTeacherStatisticsChildrenService 
{
	/**
     * 查询数据统计（教师）子信息
         * @param id 数据统计（教师）子ID
     * @return 数据统计（教师）子信息
     */
	public TeachTeacherStatisticsChildren selectTeachTeacherStatisticsChildrenById(Integer id);
	
	/**
     * 查询数据统计（教师）子列表
         * @param teachTeacherStatisticsChildren 数据统计（教师）子信息
     * @return 数据统计（教师）子集合
     */
	public List<TeachTeacherStatisticsChildren> selectTeachTeacherStatisticsChildrenList(TeachTeacherStatisticsChildren teachTeacherStatisticsChildren);
	
	/**
     * 新增数据统计（教师）子
         * @param teachTeacherStatisticsChildren 数据统计（教师）子信息
     * @return 结果
     */
	public int insertTeachTeacherStatisticsChildren(TeachTeacherStatisticsChildren teachTeacherStatisticsChildren);
	
	/**
     * 修改数据统计（教师）子
         * @param teachTeacherStatisticsChildren 数据统计（教师）子信息
     * @return 结果
     */
	public int updateTeachTeacherStatisticsChildren(TeachTeacherStatisticsChildren teachTeacherStatisticsChildren);
		
	/**
     * 删除数据统计（教师）子信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachTeacherStatisticsChildrenByIds(String ids);
	
}
