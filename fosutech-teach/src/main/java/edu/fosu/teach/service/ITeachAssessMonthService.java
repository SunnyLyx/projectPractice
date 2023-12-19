package edu.fosu.teach.service;

import edu.fosu.teach.domain.TeachAssessMonth;
import java.util.List;

/**
 * 月度考核标准 服务层
 *  */
public interface ITeachAssessMonthService 
{
	/**
     * 查询月度考核标准信息
         * @param id 月度考核标准ID
     * @return 月度考核标准信息
     */
	public TeachAssessMonth selectTeachAssessMonthById(Integer id);

	/**
	 * 查询月度考核标准信息通过id
	 *
	 * @param id 月度考核标准ID
	 * @return 月度考核标准信息
	 */
	public TeachAssessMonth selectTeachAssessMonthListById(Integer id);
	
	/**
     * 查询月度考核标准列表
         * @param teachAssessMonth 月度考核标准信息
     * @return 月度考核标准集合
     */
	public List<TeachAssessMonth> selectTeachAssessMonthList(TeachAssessMonth teachAssessMonth);

	/**
	 * 查询月度考核标准信息列表ById
	 *
	 * @param schoolId 月度考核标准ID
	 * @return 月度考核标准信息
	 */
	public List<TeachAssessMonth> selectTeachAssessMonthBySchoolId(Integer schoolId);
	
	/**
     * 新增月度考核标准
         * @param teachAssessMonth 月度考核标准信息
     * @return 结果
     */
	public int insertTeachAssessMonth(TeachAssessMonth teachAssessMonth);
	
	/**
     * 修改月度考核标准
         * @param teachAssessMonth 月度考核标准信息
     * @return 结果
     */
	public int updateTeachAssessMonth(TeachAssessMonth teachAssessMonth);
		
	/**
     * 删除月度考核标准信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachAssessMonthByIds(String ids);
	
}
