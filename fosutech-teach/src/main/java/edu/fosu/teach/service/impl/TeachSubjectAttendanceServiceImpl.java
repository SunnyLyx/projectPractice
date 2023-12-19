package edu.fosu.teach.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.TeachSubjectAttendanceMapper;
import edu.fosu.teach.domain.TeachSubjectAttendance;
import edu.fosu.teach.service.ITeachSubjectAttendanceService;
import edu.fosu.common.support.Convert;

/**
 * 作业统计 服务层实现
 *  */
@Service
public class TeachSubjectAttendanceServiceImpl implements ITeachSubjectAttendanceService 
{
	@Autowired
	private TeachSubjectAttendanceMapper teachSubjectAttendanceMapper;

	/**
     * 查询作业统计信息
         * @param id 作业统计ID
     * @return 作业统计信息
     */
    @Override
	public TeachSubjectAttendance selectTeachSubjectAttendanceById(Integer id)
	{
	    return teachSubjectAttendanceMapper.selectTeachSubjectAttendanceById(id);
	}
	
	/**
     * 查询作业统计列表
         * @param teachSubjectAttendance 作业统计信息
     * @return 作业统计集合
     */
	@Override
	public List<TeachSubjectAttendance> selectTeachSubjectAttendanceList(TeachSubjectAttendance teachSubjectAttendance)
	{
	    return teachSubjectAttendanceMapper.selectTeachSubjectAttendanceList(teachSubjectAttendance);
	}
	
    /**
     * 新增作业统计
         * @param teachSubjectAttendance 作业统计信息
     * @return 结果
     */
	@Override
	public int insertTeachSubjectAttendance(TeachSubjectAttendance teachSubjectAttendance)
	{
	    return teachSubjectAttendanceMapper.insertTeachSubjectAttendance(teachSubjectAttendance);
	}
	
	/**
     * 修改作业统计
         * @param teachSubjectAttendance 作业统计信息
     * @return 结果
     */
	@Override
	public int updateTeachSubjectAttendance(TeachSubjectAttendance teachSubjectAttendance)
	{
	    return teachSubjectAttendanceMapper.updateTeachSubjectAttendance(teachSubjectAttendance);
	}

	/**
     * 删除作业统计对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachSubjectAttendanceByIds(String ids)
	{
		return teachSubjectAttendanceMapper.deleteTeachSubjectAttendanceByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<TeachSubjectAttendance> selectTeachSubjectAttendanceTask() {
		return teachSubjectAttendanceMapper.selectTeachSubjectAttendanceTask();
	}

}
