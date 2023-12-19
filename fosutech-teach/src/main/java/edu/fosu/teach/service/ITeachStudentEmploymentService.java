package edu.fosu.teach.service;

import edu.fosu.teach.domain.TeachStudentEmployment;
import java.util.List;
import java.util.Map;

/**
 * 学生就业 服务层
 *  */
public interface ITeachStudentEmploymentService 
{
	/**
     * 查询学生就业信息
         * @param id 学生就业ID
     * @return 学生就业信息
     */
	public TeachStudentEmployment selectTeachStudentEmploymentById(Integer id);

	/**
	 * 查询学生就业信息
	 *
	 * @param schoolId 学生ID
	 * @return 学生就业信息
	 */
	public TeachStudentEmployment selectTeachStudentEmploymentByStudentId(Integer schoolId);

	/**
	 * 查询学生就业信息
	 *
	 * @param id 就业信息ID
	 * @return 学生就业信息
	 */
	public TeachStudentEmployment selectTeachStudentEmploymentsById(Integer id);
	
	/**
     * 查询学生就业列表
         * @param teachStudentEmployment 学生就业信息
     * @return 学生就业集合
     */
	public List<TeachStudentEmployment> selectTeachStudentEmploymentList(TeachStudentEmployment teachStudentEmployment);

	/**
	 * 校验学生是否唯一
	 *
	 * @param studentId 学生Id
	 * @return 结果
	 */
	public String schoolIdUnique(Integer studentId);
	
	/**
     * 新增学生就业
         * @param teachStudentEmployment 学生就业信息
     * @return 结果
     */
	public int insertTeachStudentEmployment(TeachStudentEmployment teachStudentEmployment);
	
	/**
     * 修改学生就业
         * @param teachStudentEmployment 学生就业信息
     * @return 结果
     */
	public int updateTeachStudentEmployment(TeachStudentEmployment teachStudentEmployment);
		
	/**
     * 删除学生就业信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachStudentEmploymentByIds(String ids);
	
}
