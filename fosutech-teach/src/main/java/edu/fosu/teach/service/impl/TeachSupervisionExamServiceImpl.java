package edu.fosu.teach.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.fosu.teach.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.TeachSupervisionExamMapper;
import edu.fosu.teach.domain.TeachSupervisionExam;
import edu.fosu.teach.service.ITeachSupervisionExamService;
import edu.fosu.common.support.Convert;

/**
 * 总部督查考试 服务层实现
 *  */
@Service
public class TeachSupervisionExamServiceImpl implements ITeachSupervisionExamService 
{
	@Autowired
	private TeachSupervisionExamMapper teachSupervisionExamMapper;

	@Autowired
	private StudentMapper studentMapper;

	/**
     * 查询总部督查考试信息
         * @param id 总部督查考试ID
     * @return 总部督查考试信息
     */
    @Override
	public TeachSupervisionExam selectTeachSupervisionExamById(Integer id)
	{
	    return teachSupervisionExamMapper.selectTeachSupervisionExamById(id);
	}
	
	/**
     * 查询总部督查考试列表
         * @param teachSupervisionExam 总部督查考试信息
     * @return 总部督查考试集合
     */
	@Override
	public List<TeachSupervisionExam> selectTeachSupervisionExamList(TeachSupervisionExam teachSupervisionExam)
	{
		List<TeachSupervisionExam> list = teachSupervisionExamMapper.selectTeachSupervisionExamList(teachSupervisionExam);
		for (TeachSupervisionExam supervisionExam: list) {
			Integer classId = supervisionExam.getClassId();
			String reslut = studentMapper.selectStudentCount(classId);
//			Integer res = Integer.parseInt(reslut);
			Map<String ,Object> map = new HashMap<>();
			map.put("num",reslut);
			supervisionExam.setParams(map);
		}
		return list;
	}

	/**
	 * 查询总部督查考试列表ById
	 *
	 * @param schoolId
	 * @return 总部督查考试集合
	 */
	@Override
	public List<TeachSupervisionExam> selectTeachSupervisionExamListById(Integer schoolId)
	{
		List<TeachSupervisionExam> list = teachSupervisionExamMapper.selectTeachSupervisionExamListById(schoolId);
		for (TeachSupervisionExam supervisionExam: list) {
			Integer classId = supervisionExam.getClassId();
			String reslut = studentMapper.selectStudentCount(classId);
//			Integer res = Integer.parseInt(reslut);
			Map<String ,Object> map = new HashMap<>();
			map.put("num",reslut);
			supervisionExam.setParams(map);
		}
		return list;
	}
	
    /**
     * 新增总部督查考试
         * @param teachSupervisionExam 总部督查考试信息
     * @return 结果
     */
	@Override
	public int insertTeachSupervisionExam(TeachSupervisionExam teachSupervisionExam)
	{
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String createtime = df.format(date);
		teachSupervisionExam.setCreatetime(createtime);
	    return teachSupervisionExamMapper.insertTeachSupervisionExam(teachSupervisionExam);
	}
	
	/**
     * 修改总部督查考试
         * @param teachSupervisionExam 总部督查考试信息
     * @return 结果
     */
	@Override
	public int updateTeachSupervisionExam(TeachSupervisionExam teachSupervisionExam)
	{
	    return teachSupervisionExamMapper.updateTeachSupervisionExam(teachSupervisionExam);
	}

	/**
     * 删除总部督查考试对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachSupervisionExamByIds(String ids)
	{
		return teachSupervisionExamMapper.deleteTeachSupervisionExamByIds(Convert.toStrArray(ids));
	}
	
}
