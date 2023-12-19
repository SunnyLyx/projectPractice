package edu.fosu.teach.mapper;

import edu.fosu.teach.domain.TeachMajorStage;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import edu.fosu.common.base.BaseMapper;

/**
 * 专业阶段（专业子） 数据层
 * 集成BaseMapper 长用的方式可以共用
 *  */
@MapperScan
public interface TeachMajorStageMapper  extends BaseMapper<TeachMajorStage>
{
	/**
     * 查询专业阶段（专业子）信息
         * @param id 专业阶段（专业子）ID
     * @return 专业阶段（专业子）信息
     */
	public TeachMajorStage selectTeachMajorStageById(String id);
	
	/**
     * 查询专业阶段（专业子）列表
         * @param teachMajorStage 专业阶段（专业子）信息
     * @return 专业阶段（专业子）集合
     */
	public List<TeachMajorStage> selectTeachMajorStageList(TeachMajorStage teachMajorStage);
	
	/**
     * 新增专业阶段（专业子）
         * @param teachMajorStage 专业阶段（专业子）信息
     * @return 结果
     */
	public int insertTeachMajorStage(TeachMajorStage teachMajorStage);
	
	/**
     * 修改专业阶段（专业子）
         * @param teachMajorStage 专业阶段（专业子）信息
     * @return 结果
     */
	public int updateTeachMajorStage(TeachMajorStage teachMajorStage);
	
	/**
     * 删除专业阶段（专业子）
         * @param id 专业阶段（专业子）ID
     * @return 结果
     */
	public int deleteTeachMajorStageById(String id);
	
	/**
     * 批量删除专业阶段（专业子）
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachMajorStageByIds(String[] ids);

	/**
	 * 根据专业id删除阶段
	 * @param majorId
	 * @return
	 */
	public int deleteTeachMajorStageByMajorId(Integer majorId);
	
}