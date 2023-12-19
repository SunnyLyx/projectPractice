package edu.fosu.teach.mapper;

import edu.fosu.teach.domain.TeachStudentSubject;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import edu.fosu.common.base.BaseMapper;

/**
 * 学生项目 数据层
 * 集成BaseMapper 长用的方式可以共用
 *  */
@MapperScan
public interface TeachStudentSubjectMapper  extends BaseMapper<TeachStudentSubject>
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
     * 删除学生项目
         * @param id 学生项目ID
     * @return 结果
     */
	public int deleteTeachStudentSubjectById(Integer id);
	
	/**
     * 批量删除学生项目
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachStudentSubjectByIds(String[] ids);
	
}