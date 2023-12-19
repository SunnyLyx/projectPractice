package edu.fosu.teach.service;

import edu.fosu.teach.domain.TeachSatisfaction;
import java.util.List;

/**
 * 满意度 服务层
 *  */
public interface ITeachSatisfactionService 
{
	/**
     * 查询满意度信息
         * @param id 满意度ID
     * @return 满意度信息
     */
	public TeachSatisfaction selectTeachSatisfactionById(Integer id);
	
	/**
     * 查询满意度列表
         * @param teachSatisfaction 满意度信息
     * @return 满意度集合
     */
	public List<TeachSatisfaction> selectTeachSatisfactionList(TeachSatisfaction teachSatisfaction);
	
	/**
     * 新增满意度
         * @param teachSatisfaction 满意度信息
     * @return 结果
     */
	public int insertTeachSatisfaction(TeachSatisfaction teachSatisfaction);
	
	/**
     * 修改满意度
         * @param teachSatisfaction 满意度信息
     * @return 结果
     */
	public int updateTeachSatisfaction(TeachSatisfaction teachSatisfaction);
		
	/**
     * 删除满意度信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachSatisfactionByIds(String ids);
	
}
