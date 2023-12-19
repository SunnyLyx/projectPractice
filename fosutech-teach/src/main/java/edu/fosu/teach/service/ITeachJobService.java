package edu.fosu.teach.service;

import edu.fosu.teach.domain.TeachJob;
import java.util.List;

/**
 * 班级作业 服务层
 *  */
public interface ITeachJobService 
{
	/**
     * 查询班级作业信息
         * @param jobId 班级作业ID
     * @return 班级作业信息
     */
	public TeachJob selectTeachJobById(Integer jobId);
	
	/**
     * 查询班级作业列表
         * @param teachJob 班级作业信息
     * @return 班级作业集合
     */
	public List<TeachJob> selectTeachJobList(TeachJob teachJob);

	List<TeachJob> selectTeachJobList1(TeachJob teachJob);
	
	/**
     * 新增班级作业
         * @param teachJob 班级作业信息
     * @return 结果
     */
	public int insertTeachJob(TeachJob teachJob);
	
	/**
     * 修改班级作业
         * @param teachJob 班级作业信息
     * @return 结果
     */
	public int updateTeachJob(TeachJob teachJob);
		
	/**
     * 删除班级作业信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachJobByIds(String ids);

	int selectTeachJobListCount(TeachJob teachJob);
	
}
