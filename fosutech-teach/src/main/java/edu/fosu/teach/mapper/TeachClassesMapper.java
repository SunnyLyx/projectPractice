package edu.fosu.teach.mapper;

import edu.fosu.teach.domain.TeachClasses;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import edu.fosu.common.base.BaseMapper;

/**
 * 班级 数据层
 * 集成BaseMapper 长用的方式可以共用
 *  */
@MapperScan
public interface TeachClassesMapper  extends BaseMapper<TeachClasses>
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

	List<String> selectClassesBySchoolId(int deptId);

	List<String> selectAllClasses();

	int selectSum();

	int selectMaxId();

	public int selectByClassName(String className);
	
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
     * 删除班级
         * @param classId 班级ID
     * @return 结果
     */
	public int deleteTeachClassesById(Integer classId);
	
	/**
     * 批量删除班级
         * @param classIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachClassesByIds(String[] classIds);

	int changeTeachClassesByIds(String classId);

	int selectCountByMajor(String majorId);
}