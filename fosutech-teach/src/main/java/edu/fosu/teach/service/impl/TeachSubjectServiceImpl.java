package edu.fosu.teach.service.impl;

import java.util.List;
import java.util.Map;

import edu.fosu.common.utils.FastJsonUtils;
import edu.fosu.teach.domain.TeachStudentSubject;
import edu.fosu.teach.mapper.TeachStudentSubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.TeachSubjectMapper;
import edu.fosu.teach.domain.TeachSubject;
import edu.fosu.teach.service.ITeachSubjectService;
import edu.fosu.common.support.Convert;

/**
 * 班级项目 服务层实现
 *  */
@Service
public class TeachSubjectServiceImpl implements ITeachSubjectService 
{
	@Autowired
	private TeachSubjectMapper teachSubjectMapper;

	@Autowired
	private TeachStudentSubjectMapper teachStudentSubjectMapper;

	/**
     * 查询班级项目信息
         * @param subjectId 班级项目ID
     * @return 班级项目信息
     */
    @Override
	public TeachSubject selectTeachSubjectById(Integer subjectId)
	{
	    return teachSubjectMapper.selectTeachSubjectById(subjectId);
	}
	
	/**
     * 查询班级项目列表
         * @param teachSubject 班级项目信息
     * @return 班级项目集合
     */
	@Override
	public List<TeachSubject> selectTeachSubjectList(TeachSubject teachSubject)
	{
		if(teachSubject.getStarttime() == null || teachSubject.getStarttime().equals("")) {
			return teachSubjectMapper.selectTeachSubjectList(teachSubject);
		}else{
			String time = teachSubject.getStarttime();
			String startTime = time.substring(0,10);
			String endTime = time.substring(13);
			teachSubject.setStarttime(startTime);
			teachSubject.setEndtime(endTime);
			return teachSubjectMapper.selectTeachSubjectList(teachSubject);
		}
	}

	@Override
	public int selectTeachSubjectListCount(TeachSubject teachSubject)
	{
			return teachSubjectMapper.selectTeachSubjectListCount(teachSubject);

	}

	@Override
	public List<TeachSubject> selectTeachSubjectList1(TeachSubject teachSubject) {
		return teachSubjectMapper.selectTeachSubjectList1(teachSubject);
	}
	
    /**
     * 新增班级项目
         * @param teachSubject 班级项目信息
     * @return 结果
     */
	@Override
	public int insertTeachSubject(TeachSubject teachSubject)
	{
		int id = 1;
		int sum = teachSubjectMapper.selectSum();
		if(sum > 0) {
			id = teachSubjectMapper.selectMaxId() + 1;
		}
		teachSubject.setSubjectId(id);
		List<Map<String,Object>> list = FastJsonUtils.getJsonToListMap(teachSubject.getAaaa().toString());
		teachSubject.setStudentnum(list.size());
		int bestnum = 0;
		int goodnum = 0;
		int poornum = 0;
		int unfinishednum = 0;
		for (Map<String,Object> map:list) {
			Integer submit =  Integer.parseInt(map.get("stuSelectId").toString());
			if(submit == 1){
				bestnum += 1;
			}
			if(submit == 2){
				goodnum += 1;
			}
			if(submit == 3){
				poornum += 1;
			}
			if(submit == 4){
				unfinishednum += 1;
			}
		}
		teachSubject.setBestnum(bestnum);
		teachSubject.setGoodnum(goodnum);
		teachSubject.setPoornum(poornum);
		teachSubject.setUnfinishednum(unfinishednum);
		String bestAttendance = String.format("%.0f", Double.valueOf(Double.valueOf(bestnum+goodnum)/Double.valueOf(list.size()))*100).concat("%");
		teachSubject.setBestAttendance(bestAttendance);
		int a = teachSubjectMapper.insertSelective(teachSubject);
		if(a > 0){
			for (Map<String,Object> map:list) {
				Integer studentId =  Integer.parseInt(map.get("studentId").toString());
				Integer submit =  Integer.parseInt(map.get("stuSelectId").toString());
				TeachStudentSubject teachStudentSubject = new TeachStudentSubject();
				teachStudentSubject.setSubjectId(id);
				teachStudentSubject.setStudentId(studentId);
				teachStudentSubject.setSubmit(submit);
				if(map.containsKey("url")){
					teachStudentSubject.setSubjectUrl(map.get("url").toString());
				}
				if(map.containsKey("evaluate")){
					teachStudentSubject.setEvaluate(map.get("evaluate").toString());
				}
				int b = teachStudentSubjectMapper.insertSelective(teachStudentSubject);
				if(b <= 0){
					return b;
				}
			}
		}
		return a;
	}
	
	/**
     * 修改班级项目
         * @param teachSubject 班级项目信息
     * @return 结果
     */
	@Override
	public int updateTeachSubject(TeachSubject teachSubject)
	{
		List<Map<String,Object>> list = FastJsonUtils.getJsonToListMap(teachSubject.getAaaa().toString());
		teachSubject.setStudentnum(list.size());
		int bestnum = 0;
		int goodnum = 0;
		int poornum = 0;
		int unfinishednum = 0;
		for (Map<String,Object> map:list) {
			Integer submit =  Integer.parseInt(map.get("stuSelectId").toString());
			if(submit == 1){
				bestnum += 1;
			}
			if(submit == 2){
				goodnum += 1;
			}
			if(submit == 3){
				poornum += 1;
			}
			if(submit == 4){
				unfinishednum += 1;
			}
		}
		teachSubject.setBestnum(bestnum);
		teachSubject.setGoodnum(goodnum);
		teachSubject.setPoornum(poornum);
		teachSubject.setUnfinishednum(unfinishednum);
		String bestAttendance = String.format("%.0f", Double.valueOf(Double.valueOf(bestnum+goodnum)/Double.valueOf(list.size()))*100).concat("%");
		teachSubject.setBestAttendance(bestAttendance);
		int a = teachSubjectMapper.updateByPrimaryKeySelective(teachSubject);
		if(a > 0){
			for (Map<String,Object> map:list) {
				Integer studentId = Integer.parseInt(map.get("studentId").toString());
				Integer submit = Integer.parseInt(map.get("stuSelectId").toString());
				int id = Integer.parseInt(map.get("id").toString());
				TeachStudentSubject teachStudentSubject = new TeachStudentSubject();
				teachStudentSubject.setId(id);
				teachStudentSubject.setStudentId(studentId);
				teachStudentSubject.setSubmit(submit);
				if(map.containsKey("url")){
					teachStudentSubject.setSubjectUrl(map.get("url").toString());
				}
				if(map.containsKey("evaluate")){
					teachStudentSubject.setEvaluate(map.get("evaluate").toString());
				}
				int b = teachStudentSubjectMapper.updateByPrimaryKeySelective(teachStudentSubject);
				if(b <= 0){
					return b;
				}
			}
		}
	    return a;
	}

	/**
     * 删除班级项目对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachSubjectByIds(String ids)
	{
		System.out.println(ids);
		System.out.println(Convert.toStrArray(ids));
		int a = teachStudentSubjectMapper.deleteTeachStudentSubjectByIds(Convert.toStrArray(ids));
		if(a > 0){
			teachSubjectMapper.deleteTeachSubjectByIds(Convert.toStrArray(ids));
		}
		return a;
	}
	
}
