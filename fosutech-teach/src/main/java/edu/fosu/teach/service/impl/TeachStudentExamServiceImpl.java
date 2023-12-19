package edu.fosu.teach.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.TeachStudentExamMapper;
import edu.fosu.teach.domain.TeachStudentExam;
import edu.fosu.teach.service.ITeachStudentExamService;
import edu.fosu.common.support.Convert;

/**
 * 学生考试子 服务层实现
 *  */
@Service
public class TeachStudentExamServiceImpl implements ITeachStudentExamService 
{
	@Autowired
	private TeachStudentExamMapper teachStudentExamMapper;

	/**
     * 查询学生考试子信息
         * @param id 学生考试子ID
     * @return 学生考试子信息
     */
    @Override
	public TeachStudentExam selectTeachStudentExamById(Integer id)
	{
	    return teachStudentExamMapper.selectTeachStudentExamById(id);
	}
	
	/**
     * 查询学生考试子列表
         * @param teachStudentExam 学生考试子信息
     * @return 学生考试子集合
     */
	@Override
	public List<TeachStudentExam> selectTeachStudentExamList(TeachStudentExam teachStudentExam)
	{
	    return teachStudentExamMapper.selectTeachStudentExamList(teachStudentExam);
	}

	/**
	 * 查询学生考试子列表
	 *
	 * @param teachStudentExam 学生Id
	 * @return 学生考试子集合
	 */
	@Override
	public List<TeachStudentExam> selectTeachStudentExam(TeachStudentExam teachStudentExam){
		return teachStudentExamMapper.selectTeachStudentExam(teachStudentExam);
	}
	
    /**
     * 新增学生考试子
         * @param teachStudentExam 学生考试子信息
     * @return 结果
     */
	@Override
	public int insertTeachStudentExam(TeachStudentExam teachStudentExam)
	{
	    return teachStudentExamMapper.insertTeachStudentExam(teachStudentExam);
	}
	
	/**
     * 修改学生考试子
         * @param teachStudentExam 学生考试子信息
     * @return 结果
     */
	@Override
	public int updateTeachStudentExam(TeachStudentExam teachStudentExam)
	{
	    return teachStudentExamMapper.updateTeachStudentExam(teachStudentExam);
	}

	/**
     * 删除学生考试子对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachStudentExamByIds(String ids)
	{
		return teachStudentExamMapper.deleteTeachStudentExamByIds(Convert.toStrArray(ids));
	}
	
}
