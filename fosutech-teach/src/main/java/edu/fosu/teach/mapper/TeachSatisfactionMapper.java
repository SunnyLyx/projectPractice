package edu.fosu.teach.mapper;

import edu.fosu.teach.domain.TeachSatisfaction;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import edu.fosu.common.base.BaseMapper;

/**
 * 满意度 数据层
 * 集成BaseMapper 长用的方式可以共用
 *  */
@MapperScan
public interface TeachSatisfactionMapper  extends BaseMapper<TeachSatisfaction>
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
     * 删除满意度
         * @param id 满意度ID
     * @return 结果
     */
	public int deleteTeachSatisfactionById(Integer id);
	
	/**
     * 批量删除满意度
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachSatisfactionByIds(String[] ids);
	
}