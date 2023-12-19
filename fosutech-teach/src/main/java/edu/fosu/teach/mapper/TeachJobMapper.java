package edu.fosu.teach.mapper;

import edu.fosu.teach.domain.TeachJob;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import edu.fosu.common.base.BaseMapper;

/**
 * 班级作业 数据层
 * 集成BaseMapper 长用的方式可以共用
 *  */
@MapperScan
public interface TeachJobMapper  extends BaseMapper<TeachJob>
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

	int selectSum();

	int selectMaxId();
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
     * 删除班级作业
         * @param jobId 班级作业ID
     * @return 结果
     */
	public int deleteTeachJobById(Integer jobId);
	
	/**
     * 批量删除班级作业
         * @param jobIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachJobByIds(String[] jobIds);

	int selectTeachJobListCount(TeachJob teachJob);
	
}