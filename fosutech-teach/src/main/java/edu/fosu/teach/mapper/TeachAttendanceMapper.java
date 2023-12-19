package edu.fosu.teach.mapper;

import edu.fosu.teach.domain.TeachAttendance;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import edu.fosu.common.base.BaseMapper;

/**
 * 班级考勤 数据层
 * 集成BaseMapper 长用的方式可以共用
 *  */
@MapperScan
public interface TeachAttendanceMapper  extends BaseMapper<TeachAttendance>
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

	public int selectMaxId();

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
     * 删除班级考勤
         * @param attendanceId 班级考勤ID
     * @return 结果
     */
	public int deleteTeachAttendanceById(Integer attendanceId);
	
	/**
     * 批量删除班级考勤
         * @param attendanceIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachAttendanceByIds(String[] attendanceIds);
	
}