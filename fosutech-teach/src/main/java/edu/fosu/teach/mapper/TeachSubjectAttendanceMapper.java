package edu.fosu.teach.mapper;

import edu.fosu.teach.domain.TeachSubjectAttendance;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import edu.fosu.common.base.BaseMapper;

/**
 * 作业统计 数据层
 * 集成BaseMapper 长用的方式可以共用
 *  */
@MapperScan
public interface TeachSubjectAttendanceMapper  extends BaseMapper<TeachSubjectAttendance>
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
     * 删除作业统计
         * @param id 作业统计ID
     * @return 结果
     */
	public int deleteTeachSubjectAttendanceById(Integer id);
	
	/**
     * 批量删除作业统计
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachSubjectAttendanceByIds(String[] ids);

	/**
	 * 定时任务统计班级项目情况
	 * @return
	 */
	List<TeachSubjectAttendance> selectTeachSubjectAttendanceTask();
}