package edu.fosu.teach.service;

import edu.fosu.teach.domain.TeachExam;
import java.util.List;

/**
 * 班级考试 服务层
 *  */
public interface ITeachExamService 
{
	/**
     * 查询班级考试信息
         * @param examId 班级考试ID
     * @return 班级考试信息
     */
	public TeachExam selectTeachExamById(Integer examId);

	/**
	 * 查询班级考试信息
	 *
	 * @param teachExam 班级ID
	 * @return 班级考试信息
	 */
	public List<TeachExam> selectTeachExamByClassId(TeachExam teachExam);
	
	/**
     * 查询班级考试列表
         * @param teachExam 班级考试信息
     * @return 班级考试集合
     */
	public List<TeachExam> selectTeachExamList(TeachExam teachExam);

	int selectTeachExamListCount(TeachExam teachExam);

	List<TeachExam> selectTeachExamList1(TeachExam teachExam);

	/**
	 * 查询班级考试信息
	 *
	 * @param schoolId 分部ID
	 * @return 班级考试信息
	 */
	public List<TeachExam> selectTeachExamListById(Integer schoolId);
	
	/**
     * 新增班级考试
         * @param teachExam 班级考试信息
     * @return 结果
     */
	public int insertTeachExam(TeachExam teachExam);
	
	/**
     * 修改班级考试
         * @param teachExam 班级考试信息
     * @return 结果
     */
	public int updateTeachExam(TeachExam teachExam);
		
	/**
     * 删除班级考试信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachExamByIds(String ids);
	
}
