package edu.fosu.teach.service.impl;

import java.util.*;

import edu.fosu.common.utils.FastJsonUtils;
import edu.fosu.teach.domain.TeachInspectionItems;
import edu.fosu.teach.mapper.TeachInspectionItemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.TeachAssessmentCriterionMapper;
import edu.fosu.teach.domain.TeachAssessmentCriterion;
import edu.fosu.teach.service.ITeachAssessmentCriterionService;
import edu.fosu.common.support.Convert;

/**
 * 考核标准 服务层实现
 *  */
@Service
public class TeachAssessmentCriterionServiceImpl implements ITeachAssessmentCriterionService 
{
	@Autowired
	private TeachAssessmentCriterionMapper teachAssessmentCriterionMapper;

	@Autowired
	private TeachInspectionItemsMapper teachInspectionItemsMapper;

	/**
     * 查询考核标准信息
         * @param assessId 考核标准ID
     * @return 考核标准信息
     */
    @Override
	public TeachAssessmentCriterion selectTeachAssessmentCriterionById(Integer assessId)
	{
	    return teachAssessmentCriterionMapper.selectTeachAssessmentCriterionById(assessId);
	}
	
	/**
     * 查询考核标准列表
         * @param teachAssessmentCriterion 考核标准信息
     * @return 考核标准集合
     */
	@Override
	public List<TeachAssessmentCriterion> selectTeachAssessmentCriterionList(TeachAssessmentCriterion teachAssessmentCriterion)
	{
		List<TeachAssessmentCriterion> list = teachAssessmentCriterionMapper.selectTeachAssessmentCriterionList(teachAssessmentCriterion);
		if(list != null){
			for(TeachAssessmentCriterion assessmentCriterion : list){
				Integer assessId = assessmentCriterion.getAssessId();
				TeachInspectionItems teachInspectionItems = new TeachInspectionItems();
				teachInspectionItems.setAssessId(assessId);
				List<TeachInspectionItems> itemsList = teachInspectionItemsMapper.selectTeachInspectionItemsList(teachInspectionItems);
				StringBuilder sb = new StringBuilder();
				for(TeachInspectionItems items : itemsList){
					sb.append(items.getInspectionItemsWeight()).append("/");
				}

				Map<String ,Object> map = new HashMap<>();
				if(sb != null && !"".equals(sb) && sb.length() != 0){
					String newStr = sb.toString().substring(0,sb.length() - 1);
					map.put("inspectionItemsWeight",newStr);
					assessmentCriterion.setParams(map);
				}
			}
		}
	    return list;
	}

	/**
	 * 查询最新id
	 * @return
	 */
	@Override
	public int selectId(){
		return teachAssessmentCriterionMapper.selectId();
	}

	@Override
	public int selectCountNum(){
		return teachAssessmentCriterionMapper.selectCountNum();
	}
	
    /**
     * 新增考核标准
         * @param teachAssessmentCriterion 考核标准信息
     * @return 结果
     */
	@Override
	public int insertTeachAssessmentCriterion(TeachAssessmentCriterion teachAssessmentCriterion)
	{
		int result = teachAssessmentCriterionMapper.insertTeachAssessmentCriterion(teachAssessmentCriterion);
		if(result > 0){
			List<Map<String,Object>> list = FastJsonUtils.getJsonToListMap(teachAssessmentCriterion.getAssess().toString());
			for (Map<String,Object> map:list) {
				String items = map.get("items").toString();
				Integer itemsNo =  Integer.parseInt(map.get("itemsNo").toString());
				TeachInspectionItems teachInspectionItems = new TeachInspectionItems();
				teachInspectionItems.setInspectionItemsId(UUID.randomUUID().toString());
				teachInspectionItems.setAssessId(teachAssessmentCriterion.getAssessId());
				teachInspectionItems.setInspectionItemsWeight(items);
				teachInspectionItems.setInspectionItemsNo(itemsNo);
				teachInspectionItemsMapper.insertTeachInspectionItems(teachInspectionItems);
			}
		}else {
			return result;
		}
		return result;
	}
	
	/**
     * 修改考核标准
         * @param teachAssessmentCriterion 考核标准信息
     * @return 结果
     */
	@Override
	public int updateTeachAssessmentCriterion(TeachAssessmentCriterion teachAssessmentCriterion)
	{
		int result = teachAssessmentCriterionMapper.updateTeachAssessmentCriterion(teachAssessmentCriterion);
		if(result > 0){
			List<Map<String,Object>> list = FastJsonUtils.getJsonToListMap(teachAssessmentCriterion.getAssess().toString());
			for (Map<String,Object> map:list) {
				String items = map.get("items").toString();
				Integer itemsNo =  Integer.parseInt(map.get("itemsNo").toString());
				String itemsId = map.get("itemsId").toString();
				TeachInspectionItems teachInspectionItems = new TeachInspectionItems();
				teachInspectionItems.setAssessId(teachAssessmentCriterion.getAssessId());
				teachInspectionItems.setInspectionItemsWeight(items);
				teachInspectionItems.setInspectionItemsNo(itemsNo);
				if(itemsId == null || itemsId.length() == 0){
					teachInspectionItems.setInspectionItemsId(UUID.randomUUID().toString());
					int i = teachInspectionItemsMapper.insertTeachInspectionItems(teachInspectionItems);
//					System.out.println(i);
				}else {
					teachInspectionItems.setInspectionItemsId(itemsId);
					teachInspectionItemsMapper.updateTeachInspectionItems(teachInspectionItems);
				}
			}
		}else {
			return result;
		}
		return result;
	}

	/**
     * 删除考核标准对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachAssessmentCriterionByIds(String ids)
	{
		String data[] = Convert.toStrArray(ids);
		int result = 0;
		for(int i = 0;i<data.length;i++){
			int id = Integer.parseInt(data[i]);
			result = teachInspectionItemsMapper.deleteTeachInspectionItemsByAssessId(id);
		}
		int res;
		if(result > 0){
			res = teachAssessmentCriterionMapper.deleteTeachAssessmentCriterionByIds(Convert.toStrArray(ids));
		}else {
			res = teachAssessmentCriterionMapper.deleteTeachAssessmentCriterionByIds(Convert.toStrArray(ids));
		}
		return res;
	}
	
}
