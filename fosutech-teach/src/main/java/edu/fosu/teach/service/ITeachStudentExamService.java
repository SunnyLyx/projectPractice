package edu.fosu.teach.service;

import edu.fosu.teach.domain.TeachStudentExam;
import java.util.List;

/**
 * 学生考试子 服务层
 *  */
public interface ITeachStudentExamService 
{
	/**
     * 查询学生考试子信息
         * @param id 学生考试子ID
     * @return 学生考试子信息
     */
	public TeachStudentExam selectTeachStudentExamById(Integer id);
	
	/**
     * 查询学生考试子列表
         * @param teachStudentExam 学生考试子信息
     * @return 学生考试子集合
     */
	public List<TeachStudentExam> selectTeachStudentExamList(TeachStudentExam teachStudentExam);

	/**
	 * 查询学生考试子列表
	 *
	 * @param teachStudentExam 学生Id
	 * @return 学生考试子集合
	 */
	public List<TeachStudentExam> selectTeachStudentExam(TeachStudentExam teachStudentExam);
	
	/**
     * 新增学生考试子
         * @param teachStudentExam 学生考试子信息
     * @return 结果
     */
	public int insertTeachStudentExam(TeachStudentExam teachStudentExam);
	
	/**
     * 修改学生考试子
         * @param teachStudentExam 学生考试子信息
     * @return 结果
     */
	public int updateTeachStudentExam(TeachStudentExam teachStudentExam);
		
	/**
     * 删除学生考试子信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachStudentExamByIds(String ids);
	
}
