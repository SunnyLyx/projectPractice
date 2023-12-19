package edu.fosu.teach.service;

import edu.fosu.teach.domain.TeachStudentJob;
import java.util.List;

/**
 * 学生作业 服务层
 *  */
public interface ITeachStudentJobService 
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
     * 删除学生作业信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachStudentJobByIds(String ids);
	
}
