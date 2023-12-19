package edu.fosu.teach.mapper;

import edu.fosu.teach.domain.TeachClassAttendance;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import edu.fosu.common.base.BaseMapper;

/**
 * 班级出勤率统计 数据层
 * 集成BaseMapper 长用的方式可以共用
 *  */
@MapperScan
public interface TeachClassAttendanceMapper  extends BaseMapper<TeachClassAttendance>
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
     * 删除班级出勤率统计
         * @param id 班级出勤率统计ID
     * @return 结果
     */
	public int deleteTeachClassAttendanceById(Integer id);
	
	/**
     * 批量删除班级出勤率统计
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachClassAttendanceByIds(String[] ids);

    List<TeachClassAttendance> selectTeachClassAttendanceTask();
}