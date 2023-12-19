package edu.fosu.teach.mapper;

import edu.fosu.teach.domain.TeachExam;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import edu.fosu.common.base.BaseMapper;

/**
 * 班级考试 数据层
 * 集成BaseMapper 长用的方式可以共用
 *  */
@MapperScan
public interface TeachExamMapper  extends BaseMapper<TeachExam>
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
	 * @param schoolId 分部ID
	 * @return 班级考试信息
	 */
	public List<TeachExam> selectTeachExamListById(Integer schoolId);

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

	int selectSum();

	int selectCountByaa(TeachExam teachExam);

	int selectMaxId();
	
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
     * 删除班级考试
         * @param examId 班级考试ID
     * @return 结果
     */
	public int deleteTeachExamById(Integer examId);
	
	/**
     * 批量删除班级考试
         * @param examIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachExamByIds(String[] examIds);
	
}