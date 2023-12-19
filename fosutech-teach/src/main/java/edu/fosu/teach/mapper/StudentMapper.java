package edu.fosu.teach.mapper;

import edu.fosu.teach.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 学生档案 数据层
 *  */
public interface StudentMapper 
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
	 * @return 学生档案集合
	 */
	public Student selectStudentsById(Integer studentId);

	/**
	 * 导出查询
	 * @return
	 */
	public List<Student> selectStudentByIdsAndStudent(String[] studentIds);

	/**
	 * 导出查询(分类)
	 * @return
	 */
	public List<Student> selectStudentByIdsAndStudentAndType(Student student);

	/**
	 * 校验课工场账号是否唯一
	 *
	 * @param kgcUid 课工场账号
	 * @return 结果
	 */
	public List<Map<String,Object>> checkKgcUnique(String kgcUid);

	public List<String> selectMajorByKgcUid(String kgcUid);

	public String selectMajorByClassId(Integer classNo);

	/**
	 * 查询班级人数
	 *
	 * @param classId 查询条件
	 * @return 结果
	 */
	public String selectStudentCount(Integer classId);

	/**
	 * 通过KgcUid查询学生
	 *
	 * @param kgcUid 课工场UID
	 * @return 学生档案信息
	 */
	public Student selectStudentByKgcUid(String kgcUid);

	/**
	 * 根据班级编号查询在读学生信息
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
     * 删除学生档案
         * @param studentId 学生档案ID
     * @return 结果
     */
	public int deleteStudentById(Integer studentId);
	
	/**
     * 批量删除学生档案
         * @param studentIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteStudentByIds(String[] studentIds);

	int selectClassStudents(String id);

	List<Map> selecttongji(int classId);
	
}