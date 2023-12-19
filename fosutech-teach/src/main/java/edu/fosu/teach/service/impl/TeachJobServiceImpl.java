package edu.fosu.teach.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import edu.fosu.common.utils.FastJsonUtils;
import edu.fosu.teach.domain.TeachStudentJob;
import edu.fosu.teach.mapper.TeachStudentJobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.TeachJobMapper;
import edu.fosu.teach.domain.TeachJob;
import edu.fosu.teach.service.ITeachJobService;
import edu.fosu.common.support.Convert;

/**
 * 班级作业 服务层实现
 *  */
@Service
public class TeachJobServiceImpl implements ITeachJobService 
{
	@Autowired
	private TeachJobMapper teachJobMapper;

	@Autowired
	private TeachStudentJobMapper teachStudentJobMapper;

	/**
     * 查询班级作业信息
         * @param jobId 班级作业ID
     * @return 班级作业信息
     */
    @Override
	public TeachJob selectTeachJobById(Integer jobId)
	{
	    return teachJobMapper.selectTeachJobById(jobId);
	}
	
	/**
     * 查询班级作业列表
         * @param teachJob 班级作业信息
     * @return 班级作业集合
     */
	@Override
	public List<TeachJob> selectTeachJobList(TeachJob teachJob)
	{
	    if(teachJob.getDatetime() == null || teachJob.getDatetime().equals("")){
			return teachJobMapper.selectTeachJobList(teachJob);
		}else{
	    	String datetime = teachJob.getDatetime();
			String startTime = datetime.substring(0,10);
			String endTime = datetime.substring(13);
			teachJob.setStarttime(startTime);
			teachJob.setEndtime(endTime);
			return teachJobMapper.selectTeachJobList(teachJob);
		}
	}

	@Override
	public List<TeachJob> selectTeachJobList1(TeachJob teachJob)
	{return teachJobMapper.selectTeachJobList1(teachJob);}
	
    /**
     * 新增班级作业
         * @param teachJob 班级作业信息
     * @return 结果
     */
	@Override
	public int insertTeachJob(TeachJob teachJob)
	{
		//获取今天年月日并转化为String类型
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
		String datetime = tempDate.format(new Date());
		//获取昨天年月日并转化为String类型
		Calendar ca = Calendar.getInstance();//得到一个Calendar的实例
		ca.setTime(new Date()); //设置时间为当前时间
		ca.add(Calendar.DATE, -1); //天减1
		Date lastDate = ca.getTime(); //结果
		String yesterday = tempDate.format(lastDate);
		String Jobdatetime = teachJob.getDatetime();
		//if(yesterday.equals(Jobdatetime) || datetime.equals(Jobdatetime)) {
			int id = 1;
			int sum = teachJobMapper.selectSum();
			if (sum > 0) {
				id = teachJobMapper.selectMaxId() + 1;
			}
			teachJob.setJobId(id);
			List<Map<String, Object>> list = FastJsonUtils.getJsonToListMap(teachJob.getAaaa().toString());
			teachJob.setStudentnum(list.size());
			int workbestnum = 0;
			int workgoodnum = 0;
			int workpoornum = 0;
			int worknosubmitnum = 0;
			for (Map<String, Object> map : list) {
				Integer submit = Integer.parseInt(map.get("stuSelectId").toString());
				if (submit == 1) {
					workbestnum += 1;
				}
				if (submit == 2) {
					workgoodnum += 1;
				}
				if (submit == 3) {
					workpoornum += 1;
				}
				if (submit == 4) {
					worknosubmitnum += 1;
				}
			}
			teachJob.setWorkbestnum(workbestnum);
			teachJob.setWorkgoodnum(workgoodnum);
			teachJob.setWorkpoornum(workpoornum);
			teachJob.setWorknosubmitnum(worknosubmitnum);
			String classHomeworkAttendance = String.format("%.0f", Double.valueOf(Double.valueOf(workbestnum + workgoodnum) / Double.valueOf(list.size())) * 100).concat("%");
			teachJob.setClassHomeworkAttendance(classHomeworkAttendance);
			int a = teachJobMapper.insertSelective(teachJob);
			if (a > 0) {
				for (Map<String, Object> map : list) {
					Integer studentId = Integer.parseInt(map.get("studentId").toString());
					Integer jobResult = Integer.parseInt(map.get("stuSelectId").toString());
					TeachStudentJob teachStudentJob = new TeachStudentJob();
					teachStudentJob.setId(UUID.randomUUID().toString());
					teachStudentJob.setJobId(id);
					teachStudentJob.setStudentId(studentId);
					teachStudentJob.setJobResult(jobResult);
					int b = teachStudentJobMapper.insertSelective(teachStudentJob);
					if (b <= 0) {
						return b;
					}
				}
			}
			return a;
		/*}
		return -2;*/
	}
	
	/**
     * 修改班级作业
         * @param teachJob 班级作业信息
     * @return 结果
     */
	@Override
	public int updateTeachJob(TeachJob teachJob)
	{
		List< Map<String,Object>> list = FastJsonUtils.getJsonToListMap(teachJob.getAaaa().toString());
		teachJob.setStudentnum(list.size());
		int workbestnum = 0;
		int workgoodnum = 0;
		int workpoornum = 0;
		int worknosubmitnum = 0;
		for (Map<String,Object> map:list) {
			Integer submit =  Integer.parseInt(map.get("stuSelectId").toString());
			if(submit == 1){
				workbestnum += 1;
			}
			if(submit == 2){
				workgoodnum += 1;
			}
			if(submit == 3){
				workpoornum += 1;
			}
			if(submit == 4){
				worknosubmitnum += 1;
			}
		}
		teachJob.setWorkbestnum(workbestnum);
		teachJob.setWorkgoodnum(workgoodnum);
		teachJob.setWorkpoornum(workpoornum);
		teachJob.setWorknosubmitnum(worknosubmitnum);
		String classHomeworkAttendance = String.format("%.0f", Double.valueOf(Double.valueOf(workbestnum+workgoodnum)/Double.valueOf(list.size()))*100).concat("%");
		teachJob.setClassHomeworkAttendance(classHomeworkAttendance);
		int a = teachJobMapper.updateByPrimaryKeySelective(teachJob);
		if(a > 0){
			for (Map<String,Object> map:list) {
				Integer studentId = Integer.parseInt(map.get("studentId").toString());
				Integer jobResult = Integer.parseInt(map.get("stuSelectId").toString());
				String id = map.get("id").toString();
				TeachStudentJob teachStudentJob = new TeachStudentJob();
				teachStudentJob.setId(id);
				teachStudentJob.setStudentId(studentId);
				teachStudentJob.setJobResult(jobResult);
				int b = teachStudentJobMapper.updateByPrimaryKeySelective(teachStudentJob);
				if(b <= 0){
					return b;
				}
			}
		}
		return a;
	}

	/**
     * 删除班级作业对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachJobByIds(String ids)
	{
		int a = teachStudentJobMapper.deleteTeachStudentJobByIds(Convert.toStrArray(ids));
		if(a > 0 ){
			return teachJobMapper.deleteTeachJobByIds(Convert.toStrArray(ids));
		}
		return  a;
	}

	@Override
	public int selectTeachJobListCount(TeachJob teachJob){
		return teachJobMapper.selectTeachJobListCount(teachJob);
	}
}
