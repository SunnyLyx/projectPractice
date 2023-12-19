package edu.fosu.teach.service;

import edu.fosu.teach.domain.TeachSubject;
import java.util.List;

/**
 * 班级项目 服务层
 *  */
public interface ITeachSubjectService 
{
	/**
     * 查询班级项目信息
         * @param subjectId 班级项目ID
     * @return 班级项目信息
     */
	public TeachSubject selectTeachSubjectById(Integer subjectId);
	
	/**
     * 查询班级项目列表
         * @param teachSubject 班级项目信息
     * @return 班级项目集合
     */
	public List<TeachSubject> selectTeachSubjectList(TeachSubject teachSubject);

	int selectTeachSubjectListCount(TeachSubject teachSubject);

	List<TeachSubject> selectTeachSubjectList1(TeachSubject teachSubject);
	
	/**
     * 新增班级项目
         * @param teachSubject 班级项目信息
     * @return 结果
     */
	public int insertTeachSubject(TeachSubject teachSubject);
	
	/**
     * 修改班级项目
         * @param teachSubject 班级项目信息
     * @return 结果
     */
	public int updateTeachSubject(TeachSubject teachSubject);
		
	/**
     * 删除班级项目信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachSubjectByIds(String ids);
	
}
