package edu.fosu.teach.service;

import edu.fosu.teach.domain.TeachSubjectAttendance;
import java.util.List;

/**
 * 作业统计 服务层
 *  */
public interface ITeachSubjectAttendanceService 
{
	/**
     * 查询作业统计信息
         * @param id 作业统计ID
     * @return 作业统计信息
     */
	public TeachSubjectAttendance selectTeachSubjectAttendanceById(Integer id);
	
	/**
     * 查询作业统计列表
         * @param teachSubjectAttendance 作业统计信息
     * @return 作业统计集合
     */
	public List<TeachSubjectAttendance> selectTeachSubjectAttendanceList(TeachSubjectAttendance teachSubjectAttendance);
	
	/**
     * 新增作业统计
         * @param teachSubjectAttendance 作业统计信息
     * @return 结果
     */
	public int insertTeachSubjectAttendance(TeachSubjectAttendance teachSubjectAttendance);
	
	/**
     * 修改作业统计
         * @param teachSubjectAttendance 作业统计信息
     * @return 结果
     */
	public int updateTeachSubjectAttendance(TeachSubjectAttendance teachSubjectAttendance);
		
	/**
     * 删除作业统计信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachSubjectAttendanceByIds(String ids);


	/**
	 * 定时任务统计班级项目情况
	 * @return
	 */
	List<TeachSubjectAttendance> selectTeachSubjectAttendanceTask();
}
