package edu.fosu.teach.service.impl;

import java.util.*;

import edu.fosu.common.utils.FastJsonUtils;
import edu.fosu.common.utils.StringUtils;
import edu.fosu.teach.domain.TeachMajorStage;
import edu.fosu.teach.mapper.TeachClassesMapper;
import edu.fosu.teach.mapper.TeachMajorStageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.TeachMajorMapper;
import edu.fosu.teach.domain.TeachMajor;
import edu.fosu.teach.service.ITeachMajorService;
import edu.fosu.common.support.Convert;

/**
 * 专业 服务层实现
 *  */
@Service
public class TeachMajorServiceImpl implements ITeachMajorService 
{
	@Autowired
	private TeachMajorMapper teachMajorMapper;

	@Autowired
	private TeachMajorStageMapper teachMajorStageMapper;

	@Autowired
	private TeachClassesMapper teachClassesMapper;

	/**
     * 查询专业信息
         * @param majorId 专业ID
     * @return 专业信息
     */
    @Override
	public TeachMajor selectTeachMajorById(Integer majorId)
	{
	    return teachMajorMapper.selectTeachMajorById(majorId);
	}
	
	/**
     * 查询专业列表
         * @param teachMajor 专业信息
     * @return 专业集合
     */
	@Override
	public List<TeachMajor> selectTeachMajorList(TeachMajor teachMajor)
	{
		List<TeachMajor> result = teachMajorMapper.selectTeachMajorList(teachMajor);

		List<TeachMajor> teachMajorList = new ArrayList<TeachMajor>();
		if(result != null){
			for(TeachMajor major : result){
				Integer majorId = major.getMajorId();//直接操作TeachMajor对象
				String majorName = major.getMajorName();
				Integer majorType = major.getMajorType();
				TeachMajorStage majorStage = new TeachMajorStage();
				majorStage.setMajorId(majorId);
				List<TeachMajorStage> list = teachMajorStageMapper.selectTeachMajorStageList(majorStage);
				StringBuilder sb = new StringBuilder();
				for(TeachMajorStage teachMajorStage : list){
					sb.append(teachMajorStage.getStageName()).append("/");
				}
				TeachMajor majors = new TeachMajor();
				majors.setMajorId(majorId);
				majors.setMajorName(majorName);
				majors.setMajorType(majorType);
				if(sb != null && !"".equals(sb) && sb.length() != 0){
					String newStr = sb.toString().substring(0,sb.length() - 1);
					majors.setMajorStage(newStr);
				}
				teachMajorList.add(majors);
			}
		}
	    return teachMajorList;
	}

	/**
	 * 查询专业列表
	 *
	 * @param teachMajor 专业信息
	 * @return 专业集合
	 */
	@Override
	public HashMap<String, List<TeachMajor>> selectTeachMajorListAndStage(TeachMajor teachMajor)
	{
		List<TeachMajor> result = teachMajorMapper.selectTeachMajorList(teachMajor);

		List<TeachMajor> teachMajorList = new ArrayList<TeachMajor>();
		if(result != null){
			for(TeachMajor major : result){
				Integer majorId = major.getMajorId();//直接操作TeachMajor对象
				String majorName = major.getMajorName();
				Integer majorType = major.getMajorType();
				TeachMajorStage majorStage = new TeachMajorStage();
				majorStage.setMajorId(majorId);
				List<TeachMajorStage> list = teachMajorStageMapper.selectTeachMajorStageList(majorStage);
				StringBuilder sb = new StringBuilder();
				for(TeachMajorStage teachMajorStage : list){
					sb.append(teachMajorStage.getStageName()).append("/");
				}
				TeachMajor majors = new TeachMajor();
				majors.setMajorId(majorId);
				majors.setMajorName(majorName);
				majors.setMajorType(majorType);
				if(sb != null && !"".equals(sb) && sb.length() != 0){
					String newStr = sb.toString().substring(0,sb.length() - 1);
					majors.setMajorStage(newStr);
				}
				teachMajorList.add(majors);
			}
		}
		HashMap<String, List<TeachMajor>> map = new HashMap<>();
		map.put("original", result);
		map.put("modified", teachMajorList);

		return map;
	}
    /**
     * 新增专业
         * @param teachMajor 专业信息
     * @return 结果
     */
	@Override
	public int insertTeachMajor(TeachMajor teachMajor)
	{
//		System.out.println(teachMajor.getMajor());
		int result = teachMajorMapper.insertTeachMajor(teachMajor);
		if(result > 0){
			List<Map<String,Object>> list = FastJsonUtils.getJsonToListMap(teachMajor.getMajor().toString());
			for (Map<String,Object> map:list) {
				String stagename = map.get("stage").toString();
				Integer sort =  Integer.parseInt(map.get("no").toString());
				TeachMajorStage teachMajorStage = new TeachMajorStage();
				teachMajorStage.setId(UUID.randomUUID().toString());
				teachMajorStage.setMajorId(teachMajor.getMajorId());
				teachMajorStage.setStageName(stagename);
				teachMajorStage.setSort(sort);
				teachMajorStageMapper.insertTeachMajorStage(teachMajorStage);
			}
		}else {
			return result;
		}
	    return result;
	}
	
	/**
     * 修改专业
         * @param teachMajor 专业信息
     * @return 结果
     */
	@Override
	public int updateTeachMajor(TeachMajor teachMajor)
	{
//		System.out.println(teachMajor.getMajor());
		int result = teachMajorMapper.updateTeachMajor(teachMajor);
		if(result > 0){
			List<Map<String,Object>> list = FastJsonUtils.getJsonToListMap(teachMajor.getMajor().toString());
			for (Map<String,Object> map:list) {
				String stagename = map.get("stage").toString();
				Integer sort =  Integer.parseInt(map.get("no").toString());
				String stageId = map.get("id").toString();
				TeachMajorStage teachMajorStage = new TeachMajorStage();
				teachMajorStage.setMajorId(teachMajor.getMajorId());
				teachMajorStage.setStageName(stagename);
				teachMajorStage.setSort(sort);
				if(stageId == null || stageId.length() == 0){
					teachMajorStage.setId(UUID.randomUUID().toString());
					int i = teachMajorStageMapper.insertTeachMajorStage(teachMajorStage);
//					System.out.println(i);
				}else {
					teachMajorStage.setId(stageId);
					teachMajorStageMapper.updateTeachMajorStage(teachMajorStage);
				}
			}
		}else {
			return result;
		}
		return result;
	    //return teachMajorMapper.updateTeachMajor(teachMajor);
	}

	/**
     * 删除专业对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachMajorByIds(String ids)
	{
		int a = teachClassesMapper.selectCountByMajor(ids);
		if(a>0){
			return -1;
		}else {
			String data[] = Convert.toStrArray(ids);
			int result = 0;
			for(int i = 0;i<data.length;i++){
				int id = Integer.parseInt(data[i]);
				result = teachMajorStageMapper.deleteTeachMajorStageByMajorId(id);
			}
			int res;
			if(result > 0){
				res = teachMajorMapper.deleteTeachMajorByIds(Convert.toStrArray(ids));
			}else {
				res = teachMajorMapper.deleteTeachMajorByIds(Convert.toStrArray(ids));
			}
			return res;
		}
	}

	/**
	 * 查询最新id
	 * @return
	 */
	@Override
	public int selectId(){
		return teachMajorMapper.selectId();
	}

	@Override
	public int selectCountNum(){
		return teachMajorMapper.selectCountNum();
	}

	/**
	 * 校验专业名称是否唯一
	 *
	 * @param teachMajor
	 * @return
	 */
	@Override
	public String checkMajorNameUnique(TeachMajor teachMajor) {
		String majorName = teachMajor.getMajorName();
		TeachMajor info = teachMajorMapper.checkMajorNameUnique(majorName);
		if (StringUtils.isNotNull(info))
		{
			return "1";
		}
		return "0";
	}
}
