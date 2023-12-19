package edu.fosu.teach.service;

import edu.fosu.teach.domain.TeachClassAttendance;
import java.util.List;

/**
 * 班级出勤率统计 服务层
 *  */
public interface ITeachClassAttendanceService 
{
	/**
     * 查询班级出勤率统计信息
         * @param id 班级出勤率统计ID
     * @return 班级出勤率统计信息
     */
	public TeachClassAttendance selectTeachClassAttendanceById(Integer id);
	
	/**
     * 查询班级出勤率统计列表
         * @param teachClassAttendance 班级出勤率统计信息
     * @return 班级出勤率统计集合
     */
	public List<TeachClassAttendance> selectTeachClassAttendanceList(TeachClassAttendance teachClassAttendance);
	
	/**
     * 新增班级出勤率统计
         * @param teachClassAttendance 班级出勤率统计信息
     * @return 结果
     */
	public int insertTeachClassAttendance(TeachClassAttendance teachClassAttendance);
	
	/**
     * 修改班级出勤率统计
         * @param teachClassAttendance 班级出勤率统计信息
     * @return 结果
     */
	public int updateTeachClassAttendance(TeachClassAttendance teachClassAttendance);
		
	/**
     * 删除班级出勤率统计信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachClassAttendanceByIds(String ids);

	/**
	 * 定时任务统计班级每天出勤信息
	 * @return
	 */
	List<TeachClassAttendance> selectTeachClassAttendanceTask();
}
