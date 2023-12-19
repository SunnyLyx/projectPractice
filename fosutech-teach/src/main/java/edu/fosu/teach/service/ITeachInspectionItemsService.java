package edu.fosu.teach.service;

import edu.fosu.teach.domain.TeachInspectionItems;
import java.util.List;

/**
 * 考核项（考核标准子） 服务层
 *  */
public interface ITeachInspectionItemsService 
{
	/**
     * 查询考核项（考核标准子）信息
         * @param inspectionItemsId 考核项（考核标准子）ID
     * @return 考核项（考核标准子）信息
     */
	public TeachInspectionItems selectTeachInspectionItemsById(Integer inspectionItemsId);
	
	/**
     * 查询考核项（考核标准子）列表
         * @param teachInspectionItems 考核项（考核标准子）信息
     * @return 考核项（考核标准子）集合
     */
	public List<TeachInspectionItems> selectTeachInspectionItemsList(TeachInspectionItems teachInspectionItems);
	
	/**
     * 新增考核项（考核标准子）
         * @param teachInspectionItems 考核项（考核标准子）信息
     * @return 结果
     */
	public int insertTeachInspectionItems(TeachInspectionItems teachInspectionItems);
	
	/**
     * 修改考核项（考核标准子）
         * @param teachInspectionItems 考核项（考核标准子）信息
     * @return 结果
     */
	public int updateTeachInspectionItems(TeachInspectionItems teachInspectionItems);
		
	/**
     * 删除考核项（考核标准子）信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachInspectionItemsByIds(String ids);
	
}
