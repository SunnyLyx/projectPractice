package edu.fosu.teach.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.TeachClassAttendanceMapper;
import edu.fosu.teach.domain.TeachClassAttendance;
import edu.fosu.teach.service.ITeachClassAttendanceService;
import edu.fosu.common.support.Convert;

/**
 * 班级出勤率统计 服务层实现
 *  */
@Service
public class TeachClassAttendanceServiceImpl implements ITeachClassAttendanceService 
{
	@Autowired
	private TeachClassAttendanceMapper teachClassAttendanceMapper;

	/**
     * 查询班级出勤率统计信息
         * @param id 班级出勤率统计ID
     * @return 班级出勤率统计信息
     */
    @Override
	public TeachClassAttendance selectTeachClassAttendanceById(Integer id)
	{
	    return teachClassAttendanceMapper.selectTeachClassAttendanceById(id);
	}
	
	/**
     * 查询班级出勤率统计列表
         * @param teachClassAttendance 班级出勤率统计信息
     * @return 班级出勤率统计集合
     */
	@Override
	public List<TeachClassAttendance> selectTeachClassAttendanceList(TeachClassAttendance teachClassAttendance)
	{
	    return teachClassAttendanceMapper.selectTeachClassAttendanceList(teachClassAttendance);
	}
	
    /**
     * 新增班级出勤率统计
         * @param teachClassAttendance 班级出勤率统计信息
     * @return 结果
     */
	@Override
	public int insertTeachClassAttendance(TeachClassAttendance teachClassAttendance)
	{
	    return teachClassAttendanceMapper.insertTeachClassAttendance(teachClassAttendance);
	}
	
	/**
     * 修改班级出勤率统计
         * @param teachClassAttendance 班级出勤率统计信息
     * @return 结果
     */
	@Override
	public int updateTeachClassAttendance(TeachClassAttendance teachClassAttendance)
	{
	    return teachClassAttendanceMapper.updateTeachClassAttendance(teachClassAttendance);
	}

	/**
     * 删除班级出勤率统计对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachClassAttendanceByIds(String ids)
	{
		return teachClassAttendanceMapper.deleteTeachClassAttendanceByIds(Convert.toStrArray(ids));
	}

    @Override
    public List<TeachClassAttendance> selectTeachClassAttendanceTask() {
        return teachClassAttendanceMapper.selectTeachClassAttendanceTask();
    }

}
