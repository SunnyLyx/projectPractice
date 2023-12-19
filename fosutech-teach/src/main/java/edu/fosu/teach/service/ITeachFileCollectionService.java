package edu.fosu.teach.service;

import edu.fosu.teach.domain.TeachFileCollection;
import java.util.List;

/**
 * 学生档案收集 服务层
 *  */
public interface ITeachFileCollectionService 
{
	/**
     * 查询学生档案收集信息
         * @param studentId 学生档案收集ID
     * @return 学生档案收集信息
     */
	public TeachFileCollection selectTeachFileCollectionById(Integer studentId);
	
	/**
     * 查询学生档案收集列表
         * @param teachFileCollection 学生档案收集信息
     * @return 学生档案收集集合
     */
	public List<TeachFileCollection> selectTeachFileCollectionList(TeachFileCollection teachFileCollection);
	
	/**
     * 新增学生档案收集
         * @param teachFileCollection 学生档案收集信息
     * @return 结果
     */
	public int insertTeachFileCollection(TeachFileCollection teachFileCollection);
	
	/**
     * 修改学生档案收集
         * @param teachFileCollection 学生档案收集信息
     * @return 结果
     */
	public int updateTeachFileCollection(TeachFileCollection teachFileCollection);
		
	/**
     * 删除学生档案收集信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachFileCollectionByIds(String ids);
	
}
