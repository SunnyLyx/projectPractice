package edu.fosu.teach.service;

import edu.fosu.teach.domain.TeachSupervisionSubject;
import java.util.List;

/**
 * 总部督查项目 服务层
 *  */
public interface ITeachSupervisionSubjectService 
{
	/**
     * 查询总部督查项目信息
         * @param id 总部督查项目ID
     * @return 总部督查项目信息
     */
	public TeachSupervisionSubject selectTeachSupervisionSubjectById(Integer id);

	/**
	 * 查询总部督查项目信息(修改1)
	 *
	 * @param id 总部督查项目ID
	 * @return 总部督查项目信息
	 */
	public TeachSupervisionSubject selectTeachSupervisionSubjectsById(Integer id);
	
	/**
     * 查询总部督查项目列表
         * @param teachSupervisionSubject 总部督查项目信息
     * @return 总部督查项目集合
     */
	public List<TeachSupervisionSubject> selectTeachSupervisionSubjectList(TeachSupervisionSubject teachSupervisionSubject);

	/**
	 * 查询总部督查项目列表
	 *
	 * @param schoolId
	 * @return 总部督查项目集合
	 */
	public List<TeachSupervisionSubject> selectTeachSupervisionSubjectListById(Integer schoolId);
	
	/**
     * 新增总部督查项目
         * @param teachSupervisionSubject 总部督查项目信息
     * @return 结果
     */
	public int insertTeachSupervisionSubject(TeachSupervisionSubject teachSupervisionSubject);
	
	/**
     * 修改总部督查项目
         * @param teachSupervisionSubject 总部督查项目信息
     * @return 结果
     */
	public int updateTeachSupervisionSubject(TeachSupervisionSubject teachSupervisionSubject);
		
	/**
     * 删除总部督查项目信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachSupervisionSubjectByIds(String ids);
	
}
