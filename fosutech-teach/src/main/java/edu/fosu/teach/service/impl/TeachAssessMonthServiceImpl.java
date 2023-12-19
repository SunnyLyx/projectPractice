package edu.fosu.teach.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.TeachAssessMonthMapper;
import edu.fosu.teach.domain.TeachAssessMonth;
import edu.fosu.teach.service.ITeachAssessMonthService;
import edu.fosu.common.support.Convert;

/**
 * 月度考核标准 服务层实现
 *  */
@Service
public class TeachAssessMonthServiceImpl implements ITeachAssessMonthService 
{
	@Autowired
	private TeachAssessMonthMapper teachAssessMonthMapper;

	/**
     * 查询月度考核标准信息
         * @param id 月度考核标准ID
     * @return 月度考核标准信息
     */
    @Override
	public TeachAssessMonth selectTeachAssessMonthById(Integer id)
	{
	    return teachAssessMonthMapper.selectTeachAssessMonthById(id);
	}

	/**
	 * 查询月度考核标准信息ById
	 *
	 * @param id 月度考核标准ID
	 * @return 月度考核标准信息
	 */
	@Override
	public TeachAssessMonth selectTeachAssessMonthListById(Integer id)
	{
		return teachAssessMonthMapper.selectTeachAssessMonthListById(id);
	}
	
	/**
     * 查询月度考核标准列表
         * @param teachAssessMonth 月度考核标准信息
     * @return 月度考核标准集合
     */
	@Override
	public List<TeachAssessMonth> selectTeachAssessMonthList(TeachAssessMonth teachAssessMonth)
	{
		String sourceStr = teachAssessMonth.getAssessMonth();
		Map<String,Object> param = new HashMap<>();
		if(sourceStr != null && !sourceStr.equals("") && sourceStr.length() != 0){
			String[] sourceStrArray = sourceStr.split(" ~ ");
			for (int i = 0; i < sourceStrArray.length; i++) {
				param.put("beginTime",sourceStrArray[0]);
				param.put("endTime",sourceStrArray[1]);
			}
		}
		teachAssessMonth.setParams(param);

		List<TeachAssessMonth> teachAssessMonths = teachAssessMonthMapper.selectTeachAssessMonthList(teachAssessMonth);

		List<TeachAssessMonth> months = new ArrayList<TeachAssessMonth>();
		for(int i = 0 ; i < teachAssessMonths.size() ; i++) {
			String one = teachAssessMonths.get(i).getAttendanceOne();
			String oneStandard = teachAssessMonths.get(i).getAttendanceOneStandard();
			String two = teachAssessMonths.get(i).getAttendanceTwo();
			String twoStandard = teachAssessMonths.get(i).getAttendanceTwoStandard();
			String three = teachAssessMonths.get(i).getAttendanceThree();
			String threeStandard = teachAssessMonths.get(i).getAttendanceThreeStandard();
			String examOne = teachAssessMonths.get(i).getExamOne();
			String examOneStandard = teachAssessMonths.get(i).getExamOneStandard();
			String examTwo = teachAssessMonths.get(i).getExamTwo();
			String examTwoStandard = teachAssessMonths.get(i).getExamTwoStandard();
			String examThree = teachAssessMonths.get(i).getExamThree();
			String examThreeStandard = teachAssessMonths.get(i).getExamThreeStandard();
			String taskOne = teachAssessMonths.get(i).getTaskOne();
			String taskOneStandard = teachAssessMonths.get(i).getTaskOneStandard();
			String taskTwo = teachAssessMonths.get(i).getTaskTwo();
			String taskTwoStandard = teachAssessMonths.get(i).getTaskTwoStandard();
			String taskThree = teachAssessMonths.get(i).getTaskThree();
			String taskThreeStandard = teachAssessMonths.get(i).getTaskThreeStandard();
			String subjectOne = teachAssessMonths.get(i).getSubjectOne();
			String subjectOneStandard = teachAssessMonths.get(i).getSubjectOneStandard();
			String subjectTwo = teachAssessMonths.get(i).getSubjectTwo();
			String subjectTwoStandard = teachAssessMonths.get(i).getSubjectTwoStandard();
			String subjectThree = teachAssessMonths.get(i).getSubjectThree();
			String subjectThreeStandard = teachAssessMonths.get(i).getSubjectThreeStandard();
			String attendance =">"+one+":"+oneStandard+" "+two+":"+twoStandard+" "+"<"+three+":"+threeStandard;
			String exam =">"+examOne+":"+examOneStandard+" "+examTwo+":"+examTwoStandard+" "+"<"+examThree+":"+examThreeStandard;
			String task =">"+taskOne+":"+taskOneStandard+" "+taskTwo+":"+taskTwoStandard+" "+"<"+taskThree+":"+taskThreeStandard;
			String subject =">"+subjectOne+":"+subjectOneStandard+" "+subjectTwo+":"+subjectTwoStandard+" "+"<"+subjectThree+":"+subjectThreeStandard;
//			System.out.println("subject:"+subject);
			TeachAssessMonth assessMonth = new TeachAssessMonth();
			assessMonth.setClasses(teachAssessMonths.get(i).getClasses());
			assessMonth.setClassId(teachAssessMonths.get(i).getClassId());
			assessMonth.setId(teachAssessMonths.get(i).getId());
			assessMonth.setAssessMonth(teachAssessMonths.get(i).getAssessMonth());
			assessMonth.setMajors(teachAssessMonths.get(i).getMajors());
			assessMonth.setSysDept(teachAssessMonths.get(i).getSysDept());
			assessMonth.setAttendanceOne(attendance);
			assessMonth.setExamOne(exam);
			assessMonth.setTaskOne(task);
			assessMonth.setSubjectOne(subject);
			months.add(assessMonth);
		}
	    return months;
	}

	/**
	 * 查询月度考核标准信息列表ById
	 *
	 * @param schoolId 月度考核标准ID
	 * @return 月度考核标准信息
	 */
	@Override
	public List<TeachAssessMonth> selectTeachAssessMonthBySchoolId(Integer schoolId){

		List<TeachAssessMonth> teachAssessMonths = teachAssessMonthMapper.selectTeachAssessMonthBySchoolId(schoolId);

		List<TeachAssessMonth> months = new ArrayList<TeachAssessMonth>();
		for(int i = 0 ; i < teachAssessMonths.size() ; i++) {
			System.out.println(teachAssessMonths.get(i).getAttendanceOne());
			String one = teachAssessMonths.get(i).getAttendanceOne();
			String oneStandard = teachAssessMonths.get(i).getAttendanceOneStandard();
			String two = teachAssessMonths.get(i).getAttendanceTwo();
			String twoStandard = teachAssessMonths.get(i).getAttendanceTwoStandard();
			String three = teachAssessMonths.get(i).getAttendanceThree();
			String threeStandard = teachAssessMonths.get(i).getAttendanceThreeStandard();
			String examOne = teachAssessMonths.get(i).getExamOne();
			String examOneStandard = teachAssessMonths.get(i).getExamOneStandard();
			String examTwo = teachAssessMonths.get(i).getExamTwo();
			String examTwoStandard = teachAssessMonths.get(i).getExamTwoStandard();
			String examThree = teachAssessMonths.get(i).getExamThree();
			String examThreeStandard = teachAssessMonths.get(i).getExamThreeStandard();
			String taskOne = teachAssessMonths.get(i).getTaskOne();
			String taskOneStandard = teachAssessMonths.get(i).getTaskOneStandard();
			String taskTwo = teachAssessMonths.get(i).getTaskTwo();
			String taskTwoStandard = teachAssessMonths.get(i).getTaskTwoStandard();
			String taskThree = teachAssessMonths.get(i).getTaskThree();
			String taskThreeStandard = teachAssessMonths.get(i).getTaskThreeStandard();
			String subjectOne = teachAssessMonths.get(i).getSubjectOne();
			String subjectOneStandard = teachAssessMonths.get(i).getSubjectOneStandard();
			String subjectTwo = teachAssessMonths.get(i).getSubjectTwo();
			String subjectTwoStandard = teachAssessMonths.get(i).getSubjectTwoStandard();
			String subjectThree = teachAssessMonths.get(i).getSubjectThree();
			String subjectThreeStandard = teachAssessMonths.get(i).getSubjectThreeStandard();
			String attendance =">"+one+":"+oneStandard+" "+two+":"+twoStandard+" "+"<"+three+":"+threeStandard;
			String exam =">"+examOne+":"+examOneStandard+" "+examTwo+":"+examTwoStandard+" "+"<"+examThree+":"+examThreeStandard;
			String task =">"+taskOne+":"+taskOneStandard+" "+taskTwo+":"+taskTwoStandard+" "+"<"+taskThree+":"+taskThreeStandard;
			String subject =">"+subjectOne+":"+subjectOneStandard+" "+subjectTwo+":"+subjectTwoStandard+" "+"<"+subjectThree+":"+subjectThreeStandard;
//			System.out.println("subject:"+subject);
			TeachAssessMonth assessMonth = new TeachAssessMonth();
			assessMonth.setClasses(teachAssessMonths.get(i).getClasses());
			assessMonth.setClassId(teachAssessMonths.get(i).getClassId());
			assessMonth.setId(teachAssessMonths.get(i).getId());
			assessMonth.setAssessMonth(teachAssessMonths.get(i).getAssessMonth());
			assessMonth.setMajors(teachAssessMonths.get(i).getMajors());
			assessMonth.setSysDept(teachAssessMonths.get(i).getSysDept());
			assessMonth.setAttendanceOne(attendance);
			assessMonth.setExamOne(exam);
			assessMonth.setTaskOne(task);
			assessMonth.setSubjectOne(subject);
			months.add(assessMonth);
		}
		return months;
	}

    /**
     * 新增月度考核标准
         * @param teachAssessMonth 月度考核标准信息
     * @return 结果
     */
	@Override
	public int insertTeachAssessMonth(TeachAssessMonth teachAssessMonth)
	{
	    return teachAssessMonthMapper.insertTeachAssessMonth(teachAssessMonth);
	}
	
	/**
     * 修改月度考核标准
         * @param teachAssessMonth 月度考核标准信息
     * @return 结果
     */
	@Override
	public int updateTeachAssessMonth(TeachAssessMonth teachAssessMonth)
	{
	    return teachAssessMonthMapper.updateTeachAssessMonth(teachAssessMonth);
	}

	/**
     * 删除月度考核标准对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachAssessMonthByIds(String ids)
	{
		return teachAssessMonthMapper.deleteTeachAssessMonthByIds(Convert.toStrArray(ids));
	}
	
}
