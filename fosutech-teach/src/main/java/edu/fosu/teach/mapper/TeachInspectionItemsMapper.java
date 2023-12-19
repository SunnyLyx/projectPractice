package edu.fosu.teach.mapper;

import edu.fosu.teach.domain.TeachInspectionItems;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import edu.fosu.common.base.BaseMapper;

/**
 * 考核项（考核标准子） 数据层
 * 集成BaseMapper 长用的方式可以共用
 *  */
@MapperScan
public interface TeachInspectionItemsMapper  extends BaseMapper<TeachInspectionItems>
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
     * 删除考核项（考核标准子）
         * @param inspectionItemsId 考核项（考核标准子）ID
     * @return 结果
     */
	public int deleteTeachInspectionItemsById(Integer inspectionItemsId);
	
	/**
     * 批量删除考核项（考核标准子）
         * @param inspectionItemsIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachInspectionItemsByIds(String[] inspectionItemsIds);

	/**
	 * 通过assessId删除
	 * @param assessId
	 * @return
	 */
	public int deleteTeachInspectionItemsByAssessId(Integer assessId);
	
}