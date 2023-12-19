package edu.fosu.teach.service;

import edu.fosu.teach.domain.TeachAttendance;
import java.util.List;

/**
 * 班级考勤 服务层
 *  */
public interface ITeachAttendanceService 
{
	/**
     * 查询班级考勤信息
         * @param attendanceId 班级考勤ID
     * @return 班级考勤信息
     */
	public TeachAttendance selectTeachAttendanceById(Integer attendanceId);
	
	/**
     * 查询班级考勤列表
         * @param teachAttendance 班级考勤信息
     * @return 班级考勤集合
     */
	public List<TeachAttendance> selectTeachAttendanceList(TeachAttendance teachAttendance);

	List<TeachAttendance> selectTeachAttendanceList1(TeachAttendance teachAttendance);

	int selectTeachAttendanceListCount(TeachAttendance teachAttendance);
	
	/**
     * 新增班级考勤
         * @param teachAttendance 班级考勤信息
     * @return 结果
     */
	public int insertTeachAttendance(TeachAttendance teachAttendance);
	
	/**
     * 修改班级考勤
         * @param teachAttendance 班级考勤信息
     * @return 结果
     */
	public int updateTeachAttendance(TeachAttendance teachAttendance);
		
	/**
     * 删除班级考勤信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachAttendanceByIds(String ids);
	
}
