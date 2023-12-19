package edu.fosu.teach.mapper;

import edu.fosu.teach.domain.TeachSupervisionExam;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import edu.fosu.common.base.BaseMapper;

/**
 * 总部督查考试 数据层
 * 集成BaseMapper 长用的方式可以共用
 *  */
@MapperScan
public interface TeachSupervisionExamMapper  extends BaseMapper<TeachSupervisionExam>
{
	/**
     * 查询总部督查考试信息
         * @param id 总部督查考试ID
     * @return 总部督查考试信息
     */
	public TeachSupervisionExam selectTeachSupervisionExamById(Integer id);
	
	/**
     * 查询总部督查考试列表
         * @param teachSupervisionExam 总部督查考试信息
     * @return 总部督查考试集合
     */
	public List<TeachSupervisionExam> selectTeachSupervisionExamList(TeachSupervisionExam teachSupervisionExam);

	/**
	 * 查询总部督查考试列表ById
	 *
	 * @param schoolId
	 * @return 总部督查考试集合
	 */
	public List<TeachSupervisionExam> selectTeachSupervisionExamListById(Integer schoolId);
	
	/**
     * 新增总部督查考试
         * @param teachSupervisionExam 总部督查考试信息
     * @return 结果
     */
	public int insertTeachSupervisionExam(TeachSupervisionExam teachSupervisionExam);
	
	/**
     * 修改总部督查考试
         * @param teachSupervisionExam 总部督查考试信息
     * @return 结果
     */
	public int updateTeachSupervisionExam(TeachSupervisionExam teachSupervisionExam);
	
	/**
     * 删除总部督查考试
         * @param id 总部督查考试ID
     * @return 结果
     */
	public int deleteTeachSupervisionExamById(Integer id);
	
	/**
     * 批量删除总部督查考试
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachSupervisionExamByIds(String[] ids);
	
}