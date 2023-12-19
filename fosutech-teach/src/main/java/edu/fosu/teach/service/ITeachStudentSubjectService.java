package edu.fosu.teach.service;

import edu.fosu.teach.domain.TeachStudentSubject;
import java.util.List;

/**
 * 学生项目 服务层
 *  */
public interface ITeachStudentSubjectService 
{
	/**
     * 查询学生项目信息
         * @param id 学生项目ID
     * @return 学生项目信息
     */
	public TeachStudentSubject selectTeachStudentSubjectById(Integer id);
	
	/**
     * 查询学生项目列表
         * @param teachStudentSubject 学生项目信息
     * @return 学生项目集合
     */
	public List<TeachStudentSubject> selectTeachStudentSubjectList(TeachStudentSubject teachStudentSubject);

	/**
	 * 查询学生项目列表
	 *
	 * @param studentId 学生Id
	 * @return 学生项目集合
	 */
	public List<TeachStudentSubject> selectTeachStudentSubject(Integer studentId);
	
	/**
     * 新增学生项目
         * @param teachStudentSubject 学生项目信息
     * @return 结果
     */
	public int insertTeachStudentSubject(TeachStudentSubject teachStudentSubject);
	
	/**
     * 修改学生项目
         * @param teachStudentSubject 学生项目信息
     * @return 结果
     */
	public int updateTeachStudentSubject(TeachStudentSubject teachStudentSubject);
		
	/**
     * 删除学生项目信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachStudentSubjectByIds(String ids);
	
}
