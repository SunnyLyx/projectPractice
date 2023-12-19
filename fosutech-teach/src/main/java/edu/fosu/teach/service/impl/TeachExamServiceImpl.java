package edu.fosu.teach.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import edu.fosu.common.utils.FastJsonUtils;
import edu.fosu.teach.domain.TeachStudentExam;
import edu.fosu.teach.mapper.TeachStudentExamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.TeachExamMapper;
import edu.fosu.teach.domain.TeachExam;
import edu.fosu.teach.service.ITeachExamService;
import edu.fosu.common.support.Convert;

/**
 * 班级考试 服务层实现
 *  */
@Service
public class TeachExamServiceImpl implements ITeachExamService 
{
	@Autowired
	private TeachExamMapper teachExamMapper;

	@Autowired
	private TeachStudentExamMapper teachStudentExamMapper;

	/**
     * 查询班级考试信息
         * @param examId 班级考试ID
     * @return 班级考试信息
     */
    @Override
	public TeachExam selectTeachExamById(Integer examId)
	{
	    return teachExamMapper.selectTeachExamById(examId);
	}

	/**
	 * 查询班级考试信息
	 *
	 * @param teachExam 班级ID
	 * @return 班级考试信息
	 */
	@Override
	public List<TeachExam> selectTeachExamByClassId(TeachExam teachExam){
		return teachExamMapper.selectTeachExamByClassId(teachExam);
	}
	
	/**
     * 查询班级考试列表
         * @param teachExam 班级考试信息
     * @return 班级考试集合
     */
	@Override
	public List<TeachExam> selectTeachExamList(TeachExam teachExam)
	{
	    return teachExamMapper.selectTeachExamList(teachExam);
	}

	@Override
	public int selectTeachExamListCount(TeachExam teachExam)
	{
		return teachExamMapper.selectTeachExamListCount(teachExam);
	}

	@Override
	public List<TeachExam> selectTeachExamList1(TeachExam teachExam)
	{
		return teachExamMapper.selectTeachExamList1(teachExam);
	}

	/**
	 * 查询班级考试信息
	 *
	 * @param schoolId 分部ID
	 * @return 班级考试信息
	 */
	@Override
	public List<TeachExam> selectTeachExamListById(Integer schoolId){
		return teachExamMapper.selectTeachExamListById(schoolId);
	}
	
    /**
     * 新增班级考试
         * @param teachExam 班级考试信息
     * @return 结果
     */
	@Override
	public int insertTeachExam(TeachExam teachExam)
	{
		//获取今天年月日并转化为String类型
		/*SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
		String datetime = tempDate.format(new Date());
		//获取昨天年月日并转化为String类型
		Calendar ca = Calendar.getInstance();//得到一个Calendar的实例
		ca.setTime(new Date()); //设置时间为当前时间
		ca.add(Calendar.DATE, -1); //天减1
		Date lastDate = ca.getTime(); //结果
		String yesterday = tempDate.format(lastDate);
		String Examdatetime = teachExam.getDatetime();*/
		//if(yesterday.equals(Examdatetime) || datetime.equals(Examdatetime)) {
			/*TeachExam teachExam2 = new TeachExam();
			teachExam2.setClassId(teachExam.getClassId());
			teachExam2.setStageId(teachExam.getStageId());
			teachExam2.setStarttime(yesterday);
			if(yesterday.equals(Examdatetime)){
				teachExam2.setEndtime(datetime);
			}else {
				teachExam2.setEndtime(Examdatetime);
			}
			int aa = teachExamMapper.selectCountByaa(teachExam2);
			if (aa == 0){*/
				int id = 1;
				int sum = teachExamMapper.selectSum();
				if (sum > 0) {
					id = teachExamMapper.selectMaxId() + 1;
				}
				teachExam.setExamId(id);
				List<Map<String, Object>> list = FastJsonUtils.getJsonToListMap(teachExam.getAaaa().toString());
				teachExam.setStudentNum(list.size());
				int pass = 0;
				for (Map<String, Object> map : list) {
					if (map.containsKey("score")) {
						Integer score = Integer.parseInt(map.get("score").toString());
						Integer cutOffscores = Integer.valueOf(teachExam.getCutOffscores());
						if (score >= cutOffscores) {
							pass += 1;
						}
					}
				}
				teachExam.setPass(pass);
				teachExam.setFail(list.size() - pass);
				String acceptability = String.format("%.0f", Double.valueOf(Double.valueOf(pass) / Double.valueOf(list.size())) * 100).concat("%");
				teachExam.setAcceptability(acceptability);
				int a = teachExamMapper.insertSelective(teachExam);
				if (a > 0) {
					for (Map<String, Object> map : list) {
						Integer studentId = Integer.parseInt(map.get("studentId").toString());
						TeachStudentExam teachStudentExam = new TeachStudentExam();
						teachStudentExam.setExamId(id);
						teachStudentExam.setStudentId(studentId);
						if (map.containsKey("score")) {
							teachStudentExam.setScore(map.get("score").toString());
						}
						if (map.containsKey("remark")) {
							teachStudentExam.setRemark(map.get("remark").toString());
						}
						int b = teachStudentExamMapper.insertSelective(teachStudentExam);
						if (b <= 0) {
							return b;
						}
					}
				}
				return a;
			/*}else {
				return -1;
			}*/
		/*}
		return -2;*/
	}
	
	/**
     * 修改班级考试
         * @param teachExam 班级考试信息
     * @return 结果
     */
	@Override
	public int updateTeachExam(TeachExam teachExam)
	{
		List<Map<String,Object>> list = FastJsonUtils.getJsonToListMap(teachExam.getAaaa().toString());
		teachExam.setStudentNum(list.size());
		int pass = 0;
		for (Map<String,Object> map:list) {
			if (map.containsKey("score")) {
				Integer score = Integer.parseInt(map.get("score").toString());
				Integer cutOffscores = Integer.valueOf(teachExam.getCutOffscores());
				if (score >= cutOffscores) {
					pass += 1;
				}
			}
		}
		teachExam.setPass(pass);
		teachExam.setFail(list.size() - pass);
		String acceptability = String.format("%.0f", Double.valueOf(Double.valueOf(pass)/Double.valueOf(list.size()))*100).concat("%");
		teachExam.setAcceptability(acceptability);
	    int a = teachExamMapper.updateByPrimaryKeySelective(teachExam);
	    if(a > 0){
			for (Map<String,Object> map:list) {
				Integer studentId =  Integer.parseInt(map.get("studentId").toString());
				Integer id = Integer.parseInt(map.get("id").toString());
				TeachStudentExam teachStudentExam = new TeachStudentExam();
				teachStudentExam.setId(id);
				teachStudentExam.setStudentId(studentId);
				if(map.containsKey("score")){
					teachStudentExam.setScore(map.get("score").toString());
				}
				if(map.containsKey("remark")){
					teachStudentExam.setRemark(map.get("remark").toString());
				}
				int b = teachStudentExamMapper.updateByPrimaryKeySelective(teachStudentExam);
				if(b <= 0){
					return b;
				}
			}
		}
		return a;
	}

	/**
     * 删除班级考试对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachExamByIds(String ids)
	{
		int a = teachStudentExamMapper.deleteTeachStudentExamByExamIds(Convert.toStrArray(ids));
		if(a > 0){
			teachExamMapper.deleteTeachExamByIds(Convert.toStrArray(ids));
		}
		return a;
	}
	
}
