package edu.fosu.teach.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.TeachStudentSubjectMapper;
import edu.fosu.teach.domain.TeachStudentSubject;
import edu.fosu.teach.service.ITeachStudentSubjectService;
import edu.fosu.common.support.Convert;

/**
 * 学生项目 服务层实现
 *  */
@Service
public class TeachStudentSubjectServiceImpl implements ITeachStudentSubjectService 
{
	@Autowired
	private TeachStudentSubjectMapper teachStudentSubjectMapper;

	/**
     * 查询学生项目信息
         * @param id 学生项目ID
     * @return 学生项目信息
     */
    @Override
	public TeachStudentSubject selectTeachStudentSubjectById(Integer id)
	{
	    return teachStudentSubjectMapper.selectTeachStudentSubjectById(id);
	}
	
	/**
     * 查询学生项目列表
         * @param teachStudentSubject 学生项目信息
     * @return 学生项目集合
     */
	@Override
	public List<TeachStudentSubject> selectTeachStudentSubjectList(TeachStudentSubject teachStudentSubject)
	{
	    return teachStudentSubjectMapper.selectTeachStudentSubjectList(teachStudentSubject);
	}

	/**
	 * 查询学生项目列表
	 *
	 * @param studentId 学生Id
	 * @return 学生项目集合
	 */
	@Override
	public List<TeachStudentSubject> selectTeachStudentSubject(Integer studentId){
		return teachStudentSubjectMapper.selectTeachStudentSubject(studentId);
	}
	
    /**
     * 新增学生项目
         * @param teachStudentSubject 学生项目信息
     * @return 结果
     */
	@Override
	public int insertTeachStudentSubject(TeachStudentSubject teachStudentSubject)
	{
	    return teachStudentSubjectMapper.insertTeachStudentSubject(teachStudentSubject);
	}
	
	/**
     * 修改学生项目
         * @param teachStudentSubject 学生项目信息
     * @return 结果
     */
	@Override
	public int updateTeachStudentSubject(TeachStudentSubject teachStudentSubject)
	{
	    return teachStudentSubjectMapper.updateTeachStudentSubject(teachStudentSubject);
	}

	/**
     * 删除学生项目对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachStudentSubjectByIds(String ids)
	{
		return teachStudentSubjectMapper.deleteTeachStudentSubjectByIds(Convert.toStrArray(ids));
	}
	
}
