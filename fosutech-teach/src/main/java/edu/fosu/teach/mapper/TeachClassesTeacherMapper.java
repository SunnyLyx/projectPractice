package edu.fosu.teach.mapper;

import edu.fosu.teach.domain.TeachClassesTeacher;
import java.util.List;
import java.util.Map;

import tk.mybatis.spring.annotation.MapperScan;
import edu.fosu.common.base.BaseMapper;

/**
 * 班级教师（班级子） 数据层
 * 集成BaseMapper 长用的方式可以共用
 *  */
@MapperScan
public interface TeachClassesTeacherMapper  extends BaseMapper<TeachClassesTeacher>
{
	/**
     * 查询班级教师（班级子）信息
         * @param id 班级教师（班级子）ID
     * @return 班级教师（班级子）信息
     */
	public TeachClassesTeacher selectTeachClassesTeacherById(Integer id);
	
	/**
     * 查询班级教师（班级子）列表
         * @param teachClassesTeacher 班级教师（班级子）信息
     * @return 班级教师（班级子）集合
     */
	public List<TeachClassesTeacher> selectTeachClassesTeacherList(TeachClassesTeacher teachClassesTeacher);
	
	/**
     * 新增班级教师（班级子）
         * @param teachClassesTeacher 班级教师（班级子）信息
     * @return 结果
     */
	public int insertTeachClassesTeacher(TeachClassesTeacher teachClassesTeacher);
	
	/**
     * 修改班级教师（班级子）
         * @param teachClassesTeacher 班级教师（班级子）信息
     * @return 结果
     */
	public int updateTeachClassesTeacher(TeachClassesTeacher teachClassesTeacher);
	
	/**
     * 删除班级教师（班级子）
         * @param id 班级教师（班级子）ID
     * @return 结果
     */
	public int deleteTeachClassesTeacherById(Integer id);
	
	/**
     * 批量删除班级教师（班级子）
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachClassesTeacherByIds(String[] ids);

	int deleteTeachClassesTeacherByClassIds(String[] ids);

	/**
	 * 根据班级编号查询老师信息
	 * @param classId
	 * @return
	 */
    List<Map<String, Object>> selectByClassId(Integer classId);

	/**
	 * 根据班级编号查询班主任信息
	 * @param classId
	 * @return
	 */
	List<String> selectByClassNo(Integer classId);
	List<Map<String,Object>> selectTeacherByClassNo(Integer classId);

	/**
	 * 根据班级编号查询当前阶段，教师信息
	 * @param classId
	 * @return
	 */
	List<Map<String,Object>> selectByClassNoAndTime(Integer classId);


	List<String> selectTeachClasses(TeachClassesTeacher teachClassesTeacher);

}