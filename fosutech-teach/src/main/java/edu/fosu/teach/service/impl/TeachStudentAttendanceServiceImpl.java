package edu.fosu.teach.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.TeachStudentAttendanceMapper;
import edu.fosu.teach.domain.TeachStudentAttendance;
import edu.fosu.teach.service.ITeachStudentAttendanceService;
import edu.fosu.common.support.Convert;

/**
 * 学生考勤 服务层实现
 *  */
@Service
public class TeachStudentAttendanceServiceImpl implements ITeachStudentAttendanceService 
{
	@Autowired
	private TeachStudentAttendanceMapper teachStudentAttendanceMapper;

	/**
     * 查询学生考勤信息
         * @param id 学生考勤ID
     * @return 学生考勤信息
     */
    @Override
	public TeachStudentAttendance selectTeachStudentAttendanceById(Integer id)
	{
	    return teachStudentAttendanceMapper.selectTeachStudentAttendanceById(id);
	}
	
	/**
     * 查询学生考勤列表
         * @param teachStudentAttendance 学生考勤信息
     * @return 学生考勤集合
     */
	@Override
	public List<TeachStudentAttendance> selectTeachStudentAttendanceList(TeachStudentAttendance teachStudentAttendance)
	{
	    return teachStudentAttendanceMapper.selectTeachStudentAttendanceList(teachStudentAttendance);
	}

	/**
	 * 查询学生考勤列表
	 *
	 * @param teachStudentAttendance 学生考勤信息
	 * @return 学生考勤集合
	 */
	@Override
	public List<TeachStudentAttendance> selectTeachStudentAttendance(TeachStudentAttendance teachStudentAttendance)
	{
		List<TeachStudentAttendance> teachStudentAttendances = teachStudentAttendanceMapper.selectTeachStudentAttendance(teachStudentAttendance);
		return teachStudentAttendances;
	}

    /**
     * 新增学生考勤
         * @param teachStudentAttendance 学生考勤信息
     * @return 结果
     */
	@Override
	public int insertTeachStudentAttendance(TeachStudentAttendance teachStudentAttendance)
	{
	    return teachStudentAttendanceMapper.insertTeachStudentAttendance(teachStudentAttendance);
	}
	
	/**
     * 修改学生考勤
         * @param teachStudentAttendance 学生考勤信息
     * @return 结果
     */
	@Override
	public int updateTeachStudentAttendance(TeachStudentAttendance teachStudentAttendance)
	{
	    return teachStudentAttendanceMapper.updateTeachStudentAttendance(teachStudentAttendance);
	}

	/**
     * 删除学生考勤对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachStudentAttendanceByIds(String ids)
	{
		return teachStudentAttendanceMapper.deleteTeachStudentAttendanceByIds(Convert.toStrArray(ids));
	}
	
}
