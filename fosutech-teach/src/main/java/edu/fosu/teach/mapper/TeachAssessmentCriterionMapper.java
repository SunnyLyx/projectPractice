package edu.fosu.teach.mapper;

import edu.fosu.teach.domain.TeachAssessmentCriterion;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import edu.fosu.common.base.BaseMapper;

/**
 * 考核标准 数据层
 * 集成BaseMapper 长用的方式可以共用
 *  */
@MapperScan
public interface TeachAssessmentCriterionMapper  extends BaseMapper<TeachAssessmentCriterion>
{
	/**
     * 查询考核标准信息
         * @param assessId 考核标准ID
     * @return 考核标准信息
     */
	public TeachAssessmentCriterion selectTeachAssessmentCriterionById(Integer assessId);
	
	/**
     * 查询考核标准列表
         * @param teachAssessmentCriterion 考核标准信息
     * @return 考核标准集合
     */
	public List<TeachAssessmentCriterion> selectTeachAssessmentCriterionList(TeachAssessmentCriterion teachAssessmentCriterion);

	/**
	 * 查询最新id
	 * @return
	 */
	public int selectId();

	/**
	 * 查询id数量
	 */
	public int selectCountNum();
	
	/**
     * 新增考核标准
         * @param teachAssessmentCriterion 考核标准信息
     * @return 结果
     */
	public int insertTeachAssessmentCriterion(TeachAssessmentCriterion teachAssessmentCriterion);
	
	/**
     * 修改考核标准
         * @param teachAssessmentCriterion 考核标准信息
     * @return 结果
     */
	public int updateTeachAssessmentCriterion(TeachAssessmentCriterion teachAssessmentCriterion);
	
	/**
     * 删除考核标准
         * @param assessId 考核标准ID
     * @return 结果
     */
	public int deleteTeachAssessmentCriterionById(Integer assessId);
	
	/**
     * 批量删除考核标准
         * @param assessIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachAssessmentCriterionByIds(String[] assessIds);
	
}