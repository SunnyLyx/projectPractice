package edu.fosu.teach.service;

import edu.fosu.teach.domain.TeachStudentAttendance;
import java.util.List;

/**
 * 学生考勤 服务层
 *  */
public interface ITeachStudentAttendanceService 
{
	/**
     * 查询学生考勤信息
         * @param id 学生考勤ID
     * @return 学生考勤信息
     */
	public TeachStudentAttendance selectTeachStudentAttendanceById(Integer id);
	
	/**
     * 查询学生考勤列表
         * @param teachStudentAttendance 学生考勤信息
     * @return 学生考勤集合
     */
	public List<TeachStudentAttendance> selectTeachStudentAttendanceList(TeachStudentAttendance teachStudentAttendance);

	/**
	 * 查询学生考勤
	 *
	 * @param teachStudentAttendance 学生ID
	 * @return 学生考勤
	 */
	public List<TeachStudentAttendance> selectTeachStudentAttendance(TeachStudentAttendance teachStudentAttendance);
	
	/**
     * 新增学生考勤
         * @param teachStudentAttendance 学生考勤信息
     * @return 结果
     */
	public int insertTeachStudentAttendance(TeachStudentAttendance teachStudentAttendance);
	
	/**
     * 修改学生考勤
         * @param teachStudentAttendance 学生考勤信息
     * @return 结果
     */
	public int updateTeachStudentAttendance(TeachStudentAttendance teachStudentAttendance);
		
	/**
     * 删除学生考勤信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachStudentAttendanceByIds(String ids);
	
}
