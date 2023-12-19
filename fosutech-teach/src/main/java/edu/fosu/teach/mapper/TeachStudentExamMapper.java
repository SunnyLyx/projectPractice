package edu.fosu.teach.mapper;

import edu.fosu.teach.domain.TeachStudentExam;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import edu.fosu.common.base.BaseMapper;

/**
 * 学生考试子 数据层
 * 集成BaseMapper 长用的方式可以共用
 *  */
@MapperScan
public interface TeachStudentExamMapper  extends BaseMapper<TeachStudentExam>
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
     * 删除学生考试子
         * @param id 学生考试子ID
     * @return 结果
     */
	public int deleteTeachStudentExamById(Integer id);
	
	/**
     * 批量删除学生考试子
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachStudentExamByIds(String[] ids);

	int deleteTeachStudentExamByExamIds(String[] ids);
	
}