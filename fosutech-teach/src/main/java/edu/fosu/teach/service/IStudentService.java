package edu.fosu.teach.service;

import edu.fosu.teach.domain.Student;
import java.util.List;
import java.util.Map;

/**
 * 学生档案 服务层
 *  */
public interface IStudentService 
{
	/**
     * 查询学生档案信息
         * @param studentId 学生档案ID
     * @return 学生档案信息
     */
	public Student selectStudentById(Integer studentId);
	
	/**
     * 查询学生档案列表
         * @param student 学生档案信息
     * @return 学生档案集合
     */
	public List<Student> selectStudentList(Student student);

	List<Student> selectclassStudents(Student student);

	List<Student> classOtherStudents(Student student);

	List<Student> classOtherStudent(Student student);


	/**
	 * 导出查询
	 * 查询学生档案列表
	 *
	 * @param ids 学生档案信息
	 * @return 学生档案集合
	 */
	public List<Student> selectStudentByIdsAndStudent(String ids);

	/**
	 * 导出查询
	 * 查询学生档案列表
	 *
	 * @param ids 学生档案信息
	 * @return 学生档案集合
	 */
	public List<Student> selectStudentByIdsAndStudentAndType(String ids,Integer majorType);

	/**
	 * 根据树形id查询学生档案列表
	 *
	 * @param student
	 * @return 学生档案集合
	 */
	public List<Student> selectStudentListById(Student student);

	/**
	 * 根据id查询学生档案
	 *
	 * @param studentId
	 * @return 学生档案
	 */
	public Student selectStudentsById(Integer studentId);


	/**
	 * 校验课工场账号是否唯一
	 *
	 * @param student
	 * @return 结果
	 */
	public String checkKgcUnique(Student student);

	/**
	 * 查询班级人数
	 *
	 * @param classId
	 * @return 结果
	 */
	public String selectStudentCount(Integer classId);

	/**
	 * 根据班级id查询在读学生信息
	 * @param classNo
	 * @return
	 */
	public List<Map<String,Object>> selectStudentByClassId(Integer classNo);
	
	/**
     * 新增学生档案
         * @param student 学生档案信息
     * @return 结果
     */
	public int insertStudent(Student student);
	
	/**
     * 修改学生档案
         * @param student 学生档案信息
     * @return 结果
     */
	public int updateStudent(Student student);
		
	/**
     * 删除学生档案信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteStudentByIds(String ids);

	/**
	 * 导入学生数据
	 *
	 * @param sudentList 学生数据列表
	 * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
	 * @param operName 操作用户
	 * @return 结果
	 */
	public String importStudent(List<Student> sudentList, Boolean isUpdateSupport, String operName);

	int selectStudentSum(int classId);
	
}
