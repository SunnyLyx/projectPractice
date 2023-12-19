package edu.fosu.teach.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.TeachStudentJobMapper;
import edu.fosu.teach.domain.TeachStudentJob;
import edu.fosu.teach.service.ITeachStudentJobService;
import edu.fosu.common.support.Convert;

/**
 * 学生作业 服务层实现
 *  */
@Service
public class TeachStudentJobServiceImpl implements ITeachStudentJobService 
{
	@Autowired
	private TeachStudentJobMapper teachStudentJobMapper;

	/**
     * 查询学生作业信息
         * @param id 学生作业ID
     * @return 学生作业信息
     */
    @Override
	public TeachStudentJob selectTeachStudentJobById(Integer id)
	{
	    return teachStudentJobMapper.selectTeachStudentJobById(id);
	}
	
	/**
     * 查询学生作业列表
         * @param teachStudentJob 学生作业信息
     * @return 学生作业集合
     */
	@Override
	public List<TeachStudentJob> selectTeachStudentJobList(TeachStudentJob teachStudentJob)
	{
	    return teachStudentJobMapper.selectTeachStudentJobList(teachStudentJob);
	}

	/**
	 * 查询学生作业列表
	 *
	 * @param teachStudentJob 学生id
	 * @return 学生作业集合
	 */
	@Override
	public List<TeachStudentJob> selectTeachStudentJob(TeachStudentJob teachStudentJob){
		return teachStudentJobMapper.selectTeachStudentJob(teachStudentJob);
	}
	
    /**
     * 新增学生作业
         * @param teachStudentJob 学生作业信息
     * @return 结果
     */
	@Override
	public int insertTeachStudentJob(TeachStudentJob teachStudentJob)
	{
	    return teachStudentJobMapper.insertTeachStudentJob(teachStudentJob);
	}
	
	/**
     * 修改学生作业
         * @param teachStudentJob 学生作业信息
     * @return 结果
     */
	@Override
	public int updateTeachStudentJob(TeachStudentJob teachStudentJob)
	{
	    return teachStudentJobMapper.updateTeachStudentJob(teachStudentJob);
	}

	/**
     * 删除学生作业对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachStudentJobByIds(String ids)
	{
		return teachStudentJobMapper.deleteTeachStudentJobByIds(Convert.toStrArray(ids));
	}
	
}
