package edu.fosu.teach.mapper;

import edu.fosu.teach.domain.TeachAssessMonth;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import edu.fosu.common.base.BaseMapper;

/**
 * 月度考核标准 数据层
 * 集成BaseMapper 长用的方式可以共用
 *  */
@MapperScan
public interface TeachAssessMonthMapper  extends BaseMapper<TeachAssessMonth>
{
	/**
     * 查询月度考核标准信息
         * @param id 月度考核标准ID
     * @return 月度考核标准信息
     */
	public TeachAssessMonth selectTeachAssessMonthById(Integer id);

	/**
	 * 查询月度考核标准信息列表ById
	 *
	 * @param schoolId 月度考核标准ID
	 * @return 月度考核标准信息
	 */
	public List<TeachAssessMonth> selectTeachAssessMonthBySchoolId(Integer schoolId);

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
     * 删除月度考核标准
         * @param id 月度考核标准ID
     * @return 结果
     */
	public int deleteTeachAssessMonthById(Integer id);
	
	/**
     * 批量删除月度考核标准
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachAssessMonthByIds(String[] ids);
	
}