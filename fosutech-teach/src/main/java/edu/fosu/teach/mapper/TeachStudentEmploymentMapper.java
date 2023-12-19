package edu.fosu.teach.mapper;

import edu.fosu.teach.domain.TeachStudentEmployment;
import java.util.List;
import java.util.Map;

import tk.mybatis.spring.annotation.MapperScan;
import edu.fosu.common.base.BaseMapper;

/**
 * 学生就业 数据层
 * 集成BaseMapper 长用的方式可以共用
 *  */
@MapperScan
public interface TeachStudentEmploymentMapper  extends BaseMapper<TeachStudentEmployment>
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
     * 查询学生就业列表
         * @param teachStudentEmployment 学生就业信息
     * @return 学生就业集合
     */
	public List<TeachStudentEmployment> selectTeachStudentEmploymentList(TeachStudentEmployment teachStudentEmployment);

	/**
	 * 查询学生就业信息ById
	 *
	 * @param id 学生就业信息id
	 * @return 学生就业集合
	 */
	public TeachStudentEmployment selectTeachStudentEmploymentsById(Integer id);

	/**
	 * 查询学生就业列表ByStudentId
	 *
	 * @param teachStudentEmployment 学生就业信息
	 * @return 学生就业集合
	 */
	public List<Map<String,Object>> selectEmployment(TeachStudentEmployment teachStudentEmployment);

	/**
	 * 校验学生是否唯一
	 *
	 * @param studentId 学生Id
	 * @return 结果
	 */
	public TeachStudentEmployment schoolIdUnique(Integer studentId);
	
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
     * 删除学生就业
         * @param id 学生就业ID
     * @return 结果
     */
	public int deleteTeachStudentEmploymentById(Integer id);
	
	/**
     * 批量删除学生就业
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachStudentEmploymentByIds(String[] ids);
	
}