package edu.fosu.teach.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import edu.fosu.common.utils.FastJsonUtils;
import edu.fosu.teach.domain.TeachStudentAttendance;
import edu.fosu.teach.mapper.TeachStudentAttendanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.TeachAttendanceMapper;
import edu.fosu.teach.domain.TeachAttendance;
import edu.fosu.teach.service.ITeachAttendanceService;
import edu.fosu.common.support.Convert;

/**
 * 班级考勤 服务层实现
 *  */
@Service
public class TeachAttendanceServiceImpl implements ITeachAttendanceService 
{
	@Autowired
	private TeachAttendanceMapper teachAttendanceMapper;

	@Autowired
	private TeachStudentAttendanceMapper teachStudentAttendanceMapper;

	/**
     * 查询班级考勤信息
         * @param attendanceId 班级考勤ID
     * @return 班级考勤信息
     */
    @Override
	public TeachAttendance selectTeachAttendanceById(Integer attendanceId)
	{
	    return teachAttendanceMapper.selectTeachAttendanceById(attendanceId);
	}
	
	/**
     * 查询班级考勤列表
         * @param teachAttendance 班级考勤信息
     * @return 班级考勤集合
     */
	@Override
	public List<TeachAttendance> selectTeachAttendanceList(TeachAttendance teachAttendance)
	{
		if(teachAttendance.getAttendanceDatetime() == null || teachAttendance.getAttendanceDatetime().equals("")){
			return teachAttendanceMapper.selectTeachAttendanceList(teachAttendance);
		}else{
			String attendanceDatetime = teachAttendance.getAttendanceDatetime();
			String startTime = attendanceDatetime.substring(0,10);
			String endTime = attendanceDatetime.substring(13);
			teachAttendance.setStartDatetime(startTime);
			teachAttendance.setEndDatetime(endTime);
			return teachAttendanceMapper.selectTeachAttendanceList(teachAttendance);
		}
	}

	@Override
	public List<TeachAttendance> selectTeachAttendanceList1(TeachAttendance teachAttendance) {
		return teachAttendanceMapper.selectTeachAttendanceList1(teachAttendance);
	}

	@Override
	public int selectTeachAttendanceListCount(TeachAttendance teachAttendance){
		return teachAttendanceMapper.selectTeachAttendanceListCount(teachAttendance);
	}

    /**
     * 新增班级考勤
         * @param teachAttendance 班级考勤信息
     * @return 结果
     */
	@Override
	public int insertTeachAttendance(TeachAttendance teachAttendance)
	{
		/*//获取今天年月日并转化为String类型
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
		String datetime = tempDate.format(new Date());
		//获取昨天年月日并转化为String类型
		Calendar ca = Calendar.getInstance();//得到一个Calendar的实例
		ca.setTime(new Date()); //设置时间为当前时间
		ca.add(Calendar.DATE, -1); //天减1
		Date lastDate = ca.getTime(); //结果
		String yesterday = tempDate.format(lastDate);
		String attendanceDatetime = teachAttendance.getAttendanceDatetime();
		if(yesterday.equals(attendanceDatetime) || datetime.equals(attendanceDatetime)){*/
			//判断是否已为该班该课程添加过考勤
			/*TeachAttendance teachAttendance1 = new TeachAttendance();
			teachAttendance1.setClassId(teachAttendance.getClassId());
			teachAttendance1.setLesson(teachAttendance.getLesson());
			teachAttendance1.setAttendanceDatetime(teachAttendance.getAttendanceDatetime());
			int b = teachAttendanceMapper.selectCount(teachAttendance1);
			if(b == 0){*/
				//查询当前表中是否有数据，没数据则将id设为0，有数据则查出当前数据中最大id值加1作为新数据id
				int id = teachAttendanceMapper.selectCount(new TeachAttendance());
				if(id > 0){
					id = teachAttendanceMapper.selectMaxId() + 1;
				}
				List< Map<String,Object>> list = FastJsonUtils.getJsonToListMap(teachAttendance.getAaaa().toString());
				teachAttendance.setStudentnum(list.size());
				int attendancenum = 0;
				int leavenum = 0;
				int truancynum = 0;
				int latenum = 0;
				int leaveearlynum = 0;
				for (Map<String,Object> map:list) {
					Integer attendance =  Integer.parseInt(map.get("stuSelectId").toString());
					if(attendance == 1){
						attendancenum += 1;
					}
					if(attendance == 2){
						leavenum += 1;
					}
					if(attendance == 3){
						truancynum += 1;
					}
					if(attendance == 4){
						latenum += 1;
					}
					if(attendance == 5){
						leaveearlynum += 1;
					}
				}
				teachAttendance.setAttendancenum(attendancenum);
				teachAttendance.setLeavenum(leavenum);
				teachAttendance.setTruancynum(truancynum);
				teachAttendance.setLatenum(latenum);
				teachAttendance.setLeaveearlynum(leaveearlynum);
				String acceptability = String.format("%.0f", Double.valueOf(Double.valueOf(attendancenum+latenum)/Double.valueOf(list.size()))*100).concat("%");
				teachAttendance.setClassAttendance(acceptability);
				teachAttendance.setAttendanceId(id);
				int a = teachAttendanceMapper.insertSelective(teachAttendance);
				//判断父表数据是否添加成功，成功则开始添加子表数据
				if(a > 0){
					//List< Map<String,Object>> list = FastJsonUtils.getJsonToListMap(teachAttendance.getAaaa().toString());
					for (Map<String,Object> map:list) {
						Integer studentId =  Integer.parseInt(map.get("studentId").toString());
						Integer attendance =  Integer.parseInt(map.get("stuSelectId").toString());
						TeachStudentAttendance teachStudentAttendance = new TeachStudentAttendance();
						teachStudentAttendance.setAttendanceId(id);
						teachStudentAttendance.setAttendance(attendance);
						teachStudentAttendance.setStudentId(studentId);
						int c = teachStudentAttendanceMapper.insertSelective(teachStudentAttendance);
						if(c <= 0){
							return c;
						}
					}
					return a;
				}else {
					return a;
				}
			/*}
			return -1;*/
		/*}
		return -2;*/
	}
	
	/**
     * 修改班级考勤
         * @param teachAttendance 班级考勤信息
     * @return 结果
     */
	@Override
	public int updateTeachAttendance(TeachAttendance teachAttendance) {
		List< Map<String,Object>> list = FastJsonUtils.getJsonToListMap(teachAttendance.getAaaa().toString());
		teachAttendance.setStudentnum(list.size());
		int attendancenum = 0;
		int leavenum = 0;
		int truancynum = 0;
		int latenum = 0;
		int leaveearlynum = 0;
		for (Map<String,Object> map:list) {
			Integer attendance =  Integer.parseInt(map.get("stuSelectId").toString());
			if(attendance == 1){
				attendancenum += 1;
			}
			if(attendance == 2){
				leavenum += 1;
			}
			if(attendance == 3){
				truancynum += 1;
			}
			if(attendance == 4){
				latenum += 1;
			}
			if(attendance == 5){
				leaveearlynum += 1;
			}
		}
		teachAttendance.setAttendancenum(attendancenum);
		teachAttendance.setLeavenum(leavenum);
		teachAttendance.setTruancynum(truancynum);
		teachAttendance.setLatenum(latenum);
		teachAttendance.setLeaveearlynum(leaveearlynum);
		String acceptability = String.format("%.0f", Double.valueOf(Double.valueOf(attendancenum+latenum)/Double.valueOf(list.size()))*100).concat("%");
		teachAttendance.setClassAttendance(acceptability);
		//先修改父表信息
		int a = teachAttendanceMapper.updateByPrimaryKeySelective(teachAttendance);
		//父表修改成功进入子表信息的修改
		if(a > 0) {
			//List<Map<String, Object>> list = FastJsonUtils.getJsonToListMap(teachAttendance.getAaaa().toString());
			for (Map<String, Object> map : list) {
				Integer studentId = Integer.parseInt(map.get("studentId").toString());
				Integer attendance = Integer.parseInt(map.get("stuSelectId").toString());
				int id = Integer.parseInt(map.get("id").toString());
				TeachStudentAttendance teachStudentAttendance = new TeachStudentAttendance();
				teachStudentAttendance.setId(id);
				teachStudentAttendance.setAttendance(attendance);
				teachStudentAttendance.setStudentId(studentId);
				int b = teachStudentAttendanceMapper.updateByPrimaryKeySelective(teachStudentAttendance);
				if (b <= 0) {
					return b;
				}
			}
		}
		return a;
	}

	/**
     * 删除班级考勤对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachAttendanceByIds(String ids)
	{
		int a = teachStudentAttendanceMapper.deleteTeachStudentAttendanceByAttendanceIds(Convert.toStrArray(ids));
		if(a > 0){
			return teachAttendanceMapper.deleteTeachAttendanceByIds(Convert.toStrArray(ids));
		}
		return a;
	}
	
}
