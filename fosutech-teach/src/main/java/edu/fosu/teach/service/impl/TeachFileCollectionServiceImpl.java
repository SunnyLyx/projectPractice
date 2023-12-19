package edu.fosu.teach.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.fosu.system.mapper.SysDictDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.TeachFileCollectionMapper;
import edu.fosu.teach.domain.TeachFileCollection;
import edu.fosu.teach.service.ITeachFileCollectionService;
import edu.fosu.common.support.Convert;

/**
 * 学生档案收集 服务层实现
 *  */
@Service
public class TeachFileCollectionServiceImpl implements ITeachFileCollectionService 
{
	@Autowired
	private TeachFileCollectionMapper teachFileCollectionMapper;

	@Autowired
	private SysDictDataMapper sysDictDataMapper;


	/**
     * 查询学生档案收集信息
         * @param studentId 学生档案收集ID
     * @return 学生档案收集信息
     */
    @Override
	public TeachFileCollection selectTeachFileCollectionById(Integer studentId)
	{
		TeachFileCollection teachFileCollection = teachFileCollectionMapper.selectTeachFileCollectionById(studentId);
		if(teachFileCollection != null){
			//性别
			Integer sex = teachFileCollection.getStudentSex();
			String gender = "";
			if(!"".equals(sex) && sex != null){
				gender = sysDictDataMapper.selectDictLabel("sys_user_sex",sex.toString());
			}
			//状态
			Integer status = teachFileCollection.getStatus();
			String state = "";
			if(!"".equals(status) && status != null){
				if(status == 3){
					state = "转班";
				}else {
					state = sysDictDataMapper.selectDictLabel("teach_status",status.toString());
				}
			}
			//学历
			Integer education = teachFileCollection.getEducation();
			String edu = "";
			if(education != null && !"".equals(education)){
				edu = sysDictDataMapper.selectDictLabel("teach_education",education.toString());
			}
			//学历性质
			Integer degreenature = teachFileCollection.getDegreeInNature();
			String nature = "";
			if(!"".equals(degreenature) && degreenature != null){
				nature = sysDictDataMapper.selectDictLabel("teach_nature",degreenature.toString());
			}
			//是否有基础
			Integer base = teachFileCollection.getBase();
			String basic = "";
			if(!"".equals(base) && base != null){
				basic = sysDictDataMapper.selectDictLabel("teach_basic",base.toString());
			}
			//意向工作城市
			Integer job = teachFileCollection.getJobCity();
			String jobCity = "";
			if(!"".equals(job) && job != null){
				jobCity = sysDictDataMapper.selectDictLabel("teach_job_city",job.toString());
			}
			//英语水平
			Integer english = teachFileCollection.getEnglishLevel();
			String englishLevel = "";
			if(!"".equals(english) && english != null){
				englishLevel = sysDictDataMapper.selectDictLabel("teach_english_level",english.toString());
			}
			//学生来源
			Integer studentSource = teachFileCollection.getExtend1();
			String source = "";
			if(!"".equals(studentSource) && studentSource != null){
				source = sysDictDataMapper.selectDictLabel("teach_student_source",english.toString());
			}

			Map<String ,Object> map = new HashMap<>();
			map.put("gender",gender);
			map.put("state",state);
			map.put("edu",edu);
			map.put("nature",nature);
			map.put("basic",basic);
			map.put("jobCity",jobCity);
			map.put("englishLevel",englishLevel);
			map.put("source",source);
			teachFileCollection.setParams(map);
		}
	    return teachFileCollection;
	}
	
	/**
     * 查询学生档案收集列表
         * @param teachFileCollection 学生档案收集信息
     * @return 学生档案收集集合
     */
	@Override
	public List<TeachFileCollection> selectTeachFileCollectionList(TeachFileCollection teachFileCollection)
	{
	    return teachFileCollectionMapper.selectTeachFileCollectionList(teachFileCollection);
	}
	
    /**
     * 新增学生档案收集
         * @param teachFileCollection 学生档案收集信息
     * @return 结果
     */
	@Override
	public int insertTeachFileCollection(TeachFileCollection teachFileCollection)
	{
	    return teachFileCollectionMapper.insertTeachFileCollection(teachFileCollection);
	}
	
	/**
     * 修改学生档案收集
         * @param teachFileCollection 学生档案收集信息
     * @return 结果
     */
	@Override
	public int updateTeachFileCollection(TeachFileCollection teachFileCollection)
	{
	    return teachFileCollectionMapper.updateTeachFileCollection(teachFileCollection);
	}

	/**
     * 删除学生档案收集对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachFileCollectionByIds(String ids)
	{
		return teachFileCollectionMapper.deleteTeachFileCollectionByIds(Convert.toStrArray(ids));
	}
	
}
