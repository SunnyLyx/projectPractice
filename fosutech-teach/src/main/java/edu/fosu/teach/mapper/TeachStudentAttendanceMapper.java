package edu.fosu.teach.mapper;

import edu.fosu.teach.domain.TeachStudentAttendance;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import edu.fosu.common.base.BaseMapper;

/**
 * 学生考勤 数据层
 * 集成BaseMapper 长用的方式可以共用
 *  */
@MapperScan
public interface TeachStudentAttendanceMapper  extends BaseMapper<TeachStudentAttendance>
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
     * 删除学生考勤
         * @param id 学生考勤ID
     * @return 结果
     */
	public int deleteTeachStudentAttendanceById(Integer id);
	
	/**
     * 批量删除学生考勤
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachStudentAttendanceByIds(String[] ids);

	/**
	 * 批量删除学生考勤
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteTeachStudentAttendanceByAttendanceIds(String[] ids);
	
}