package edu.fosu.teach.service;

import edu.fosu.teach.domain.TeachClassesTeacher;

import java.util.List;
import java.util.Map;

/**
 * 班级教师（班级子） 服务层
 *  */
public interface ITeachClassesTeacherService 
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
     * 删除班级教师（班级子）信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachClassesTeacherByIds(String ids);

	/**
	 * 删除班级教师（班级子）信息
	 *
	 * @return 结果
	 */
	public int deleteTeachClassesTeacherById(TeachClassesTeacher teachClassesTeacher);

	/**
	 * 根据编辑查询班级老师
	 * @param classId
	 * @return
	 */
    List<Map<String, Object>> selectByClassId(Integer classId);

	/**
	 * 查询班级
	 * @param teachClassesTeacher
	 * @return
	 */
	List<String> selectTeachClasses(TeachClassesTeacher teachClassesTeacher);

}
