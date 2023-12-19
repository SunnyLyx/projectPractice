package edu.fosu.teach.service;

import edu.fosu.teach.domain.TeachClasses;
import java.util.List;
import java.util.Map;

/**
 * 班级 服务层
 *  */
public interface ITeachClassesService 
{
	/**
     * 查询班级信息
         * @param classId 班级ID
     * @return 班级信息
     */
	public TeachClasses selectTeachClassesById(Integer classId);

	/**
	 * 查询班级信息
	 *
	 * @param classId 班级ID
	 * @return 班级信息
	 */
	public TeachClasses selectTeachClassById(Integer classId);
	
	/**
     * 查询班级列表
         * @param teachClasses 班级信息
     * @return 班级集合
     */
	public List<TeachClasses> selectTeachClassesList(TeachClasses teachClasses);

	List<Map> selecttongji(int classId);

	List<String> selectClassesBySchoolId(int deptId);

	List<String> selectAllClasses();
	
	/**
     * 新增班级
         * @param teachClasses 班级信息
     * @return 结果
     */
	public int insertTeachClasses(TeachClasses teachClasses);
	
	/**
     * 修改班级
         * @param teachClasses 班级信息
     * @return 结果
     */
	public int updateTeachClasses(TeachClasses teachClasses);
		
	/**
     * 删除班级信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachClassesByIds(String ids);

	int changeTeachClassesByIds(String ids);

	/**
	 * 班级连接状态修改
	 *
	 * @param teachClasses 班级信息
	 * @return 结果
	 */
	public int changeStatus(TeachClasses teachClasses);
	
}
