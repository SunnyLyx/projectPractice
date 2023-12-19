package edu.fosu.teach.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.TeachInspectionItemsMapper;
import edu.fosu.teach.domain.TeachInspectionItems;
import edu.fosu.teach.service.ITeachInspectionItemsService;
import edu.fosu.common.support.Convert;

/**
 * 考核项（考核标准子） 服务层实现
 *  */
@Service
public class TeachInspectionItemsServiceImpl implements ITeachInspectionItemsService 
{
	@Autowired
	private TeachInspectionItemsMapper teachInspectionItemsMapper;

	/**
     * 查询考核项（考核标准子）信息
         * @param inspectionItemsId 考核项（考核标准子）ID
     * @return 考核项（考核标准子）信息
     */
    @Override
	public TeachInspectionItems selectTeachInspectionItemsById(Integer inspectionItemsId)
	{
	    return teachInspectionItemsMapper.selectTeachInspectionItemsById(inspectionItemsId);
	}
	
	/**
     * 查询考核项（考核标准子）列表
         * @param teachInspectionItems 考核项（考核标准子）信息
     * @return 考核项（考核标准子）集合
     */
	@Override
	public List<TeachInspectionItems> selectTeachInspectionItemsList(TeachInspectionItems teachInspectionItems)
	{
	    return teachInspectionItemsMapper.selectTeachInspectionItemsList(teachInspectionItems);
	}
	
    /**
     * 新增考核项（考核标准子）
         * @param teachInspectionItems 考核项（考核标准子）信息
     * @return 结果
     */
	@Override
	public int insertTeachInspectionItems(TeachInspectionItems teachInspectionItems)
	{
	    return teachInspectionItemsMapper.insertTeachInspectionItems(teachInspectionItems);
	}
	
	/**
     * 修改考核项（考核标准子）
         * @param teachInspectionItems 考核项（考核标准子）信息
     * @return 结果
     */
	@Override
	public int updateTeachInspectionItems(TeachInspectionItems teachInspectionItems)
	{
	    return teachInspectionItemsMapper.updateTeachInspectionItems(teachInspectionItems);
	}

	/**
     * 删除考核项（考核标准子）对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachInspectionItemsByIds(String ids)
	{
		return teachInspectionItemsMapper.deleteTeachInspectionItemsByIds(Convert.toStrArray(ids));
	}
	
}
