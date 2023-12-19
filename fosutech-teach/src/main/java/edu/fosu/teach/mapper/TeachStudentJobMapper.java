package edu.fosu.teach.mapper;

import edu.fosu.teach.domain.TeachStudentJob;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import edu.fosu.common.base.BaseMapper;

/**
 * 学生作业 数据层
 * 集成BaseMapper 长用的方式可以共用
 *  */
@MapperScan
public interface TeachStudentJobMapper  extends BaseMapper<TeachStudentJob>
{
	/**
     * 查询学生作业信息
         * @param id 学生作业ID
     * @return 学生作业信息
     */
	public TeachStudentJob selectTeachStudentJobById(Integer id);
	
	/**
     * 查询学生作业列表
         * @param teachStudentJob 学生作业信息
     * @return 学生作业集合
     */
	public List<TeachStudentJob> selectTeachStudentJobList(TeachStudentJob teachStudentJob);

	/**
	 * 查询学生作业列表
	 *
	 * @param teachStudentJob 学生id
	 * @return 学生作业集合
	 */
	public List<TeachStudentJob> selectTeachStudentJob(TeachStudentJob teachStudentJob);
	
	/**
     * 新增学生作业
         * @param teachStudentJob 学生作业信息
     * @return 结果
     */
	public int insertTeachStudentJob(TeachStudentJob teachStudentJob);
	
	/**
     * 修改学生作业
         * @param teachStudentJob 学生作业信息
     * @return 结果
     */
	public int updateTeachStudentJob(TeachStudentJob teachStudentJob);
	
	/**
     * 删除学生作业
         * @param id 学生作业ID
     * @return 结果
     */
	public int deleteTeachStudentJobById(Integer id);
	
	/**
     * 批量删除学生作业
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachStudentJobByIds(String[] ids);
	
}