package edu.fosu.teach.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.TeachClassHomeworkMapper;
import edu.fosu.teach.domain.TeachClassHomework;
import edu.fosu.teach.service.ITeachClassHomeworkService;
import edu.fosu.common.support.Convert;

/**
 * 班级作业统计 服务层实现
 *  */
@Service
public class TeachClassHomeworkServiceImpl implements ITeachClassHomeworkService 
{
	@Autowired
	private TeachClassHomeworkMapper teachClassHomeworkMapper;

	/**
     * 查询班级作业统计信息
         * @param id 班级作业统计ID
     * @return 班级作业统计信息
     */
    @Override
	public TeachClassHomework selectTeachClassHomeworkById(Integer id)
	{
	    return teachClassHomeworkMapper.selectTeachClassHomeworkById(id);
	}
	
	/**
     * 查询班级作业统计列表
         * @param teachClassHomework 班级作业统计信息
     * @return 班级作业统计集合
     */
	@Override
	public List<TeachClassHomework> selectTeachClassHomeworkList(TeachClassHomework teachClassHomework)
	{
	    return teachClassHomeworkMapper.selectTeachClassHomeworkList(teachClassHomework);
	}
	
    /**
     * 新增班级作业统计
         * @param teachClassHomework 班级作业统计信息
     * @return 结果
     */
	@Override
	public int insertTeachClassHomework(TeachClassHomework teachClassHomework)
	{
	    return teachClassHomeworkMapper.insertTeachClassHomework(teachClassHomework);
	}
	
	/**
     * 修改班级作业统计
         * @param teachClassHomework 班级作业统计信息
     * @return 结果
     */
	@Override
	public int updateTeachClassHomework(TeachClassHomework teachClassHomework)
	{
	    return teachClassHomeworkMapper.updateTeachClassHomework(teachClassHomework);
	}

	/**
     * 删除班级作业统计对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachClassHomeworkByIds(String ids)
	{
		return teachClassHomeworkMapper.deleteTeachClassHomeworkByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<TeachClassHomework> selectTeachClassHomeworkTask() {
		return teachClassHomeworkMapper.selectTeachClassHomeworkTask();
	}

}
