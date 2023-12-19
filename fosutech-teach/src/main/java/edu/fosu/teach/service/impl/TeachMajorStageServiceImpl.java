package edu.fosu.teach.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.TeachMajorStageMapper;
import edu.fosu.teach.domain.TeachMajorStage;
import edu.fosu.teach.service.ITeachMajorStageService;
import edu.fosu.common.support.Convert;

/**
 * 专业阶段（专业子） 服务层实现
 *  */
@Service
public class TeachMajorStageServiceImpl implements ITeachMajorStageService 
{
	@Autowired
	private TeachMajorStageMapper teachMajorStageMapper;

	/**
     * 查询专业阶段（专业子）信息
         * @param id 专业阶段（专业子）ID
     * @return 专业阶段（专业子）信息
     */
    @Override
	public TeachMajorStage selectTeachMajorStageById(String id)
	{
	    return teachMajorStageMapper.selectTeachMajorStageById(id);
	}
	
	/**
     * 查询专业阶段（专业子）列表
         * @param teachMajorStage 专业阶段（专业子）信息
     * @return 专业阶段（专业子）集合
     */
	@Override
	public List<TeachMajorStage> selectTeachMajorStageList(TeachMajorStage teachMajorStage)
	{
	    return teachMajorStageMapper.selectTeachMajorStageList(teachMajorStage);
	}
	
    /**
     * 新增专业阶段（专业子）
         * @param teachMajorStage 专业阶段（专业子）信息
     * @return 结果
     */
	@Override
	public int insertTeachMajorStage(TeachMajorStage teachMajorStage)
	{
	    return teachMajorStageMapper.insertTeachMajorStage(teachMajorStage);
	}
	
	/**
     * 修改专业阶段（专业子）
         * @param teachMajorStage 专业阶段（专业子）信息
     * @return 结果
     */
	@Override
	public int updateTeachMajorStage(TeachMajorStage teachMajorStage)
	{
	    return teachMajorStageMapper.updateTeachMajorStage(teachMajorStage);
	}

	/**
     * 删除专业阶段（专业子）对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachMajorStageByIds(String ids)
	{
		return teachMajorStageMapper.deleteTeachMajorStageByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除专业阶段（专业子）对象
	 *
	 * @param id 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteTeachMajorStageById(String id)
	{
		return teachMajorStageMapper.deleteTeachMajorStageById(id);
	}
	
}
