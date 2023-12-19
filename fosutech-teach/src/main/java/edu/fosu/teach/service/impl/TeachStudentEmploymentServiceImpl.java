package edu.fosu.teach.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.fosu.common.constant.UserConstants;
import edu.fosu.common.utils.FastJsonUtils;
import edu.fosu.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.TeachStudentEmploymentMapper;
import edu.fosu.teach.domain.TeachStudentEmployment;
import edu.fosu.teach.service.ITeachStudentEmploymentService;
import edu.fosu.common.support.Convert;

/**
 * 学生就业 服务层实现
 *  */
@Service
public class TeachStudentEmploymentServiceImpl implements ITeachStudentEmploymentService 
{
	@Autowired
	private TeachStudentEmploymentMapper teachStudentEmploymentMapper;

	/**
     * 查询学生就业信息
         * @param id 学生就业ID
     * @return 学生就业信息
     */
    @Override
	public TeachStudentEmployment selectTeachStudentEmploymentById(Integer id)
	{
	    return teachStudentEmploymentMapper.selectTeachStudentEmploymentById(id);
	}

	/**
	 * 查询学生就业信息
	 *
	 * @param schoolId 学生ID
	 * @return 学生就业信息
	 */
	@Override
	public TeachStudentEmployment selectTeachStudentEmploymentByStudentId(Integer schoolId)
	{
		return teachStudentEmploymentMapper.selectTeachStudentEmploymentByStudentId(schoolId);
	}

	/**
	 * 查询学生就业信息
	 *
	 * @param id 学生就业信息ID
	 * @return 学生就业信息
	 */
	@Override
	public TeachStudentEmployment selectTeachStudentEmploymentsById(Integer id)
	{
		TeachStudentEmployment teachStudentEmployment = teachStudentEmploymentMapper.selectTeachStudentEmploymentsById(id);
		String isTrue;
		if(teachStudentEmployment.getEmploymentIsTrue() == 1){
			isTrue = "是";
		}else {
			isTrue = "否";
		}
		Map<String,Object> map = new HashMap<>();
		map.put("employmentIsTrue",isTrue);
		teachStudentEmployment.setParams(map);
		return teachStudentEmployment;
	}
	
	/**
     * 查询学生就业列表
         * @param teachStudentEmployment 学生就业信息
     * @return 学生就业集合
     */
	@Override
	public List<TeachStudentEmployment> selectTeachStudentEmploymentList(TeachStudentEmployment teachStudentEmployment)
	{
	    return teachStudentEmploymentMapper.selectTeachStudentEmploymentList(teachStudentEmployment);
	}

	/**
	 * 校验学生是否唯一
	 *
	 * @param studentId 学生Id
	 * @return 结果
	 */
	@Override
	public String schoolIdUnique(Integer studentId){
		Long userId = StringUtils.isNull(studentId) ? -1L : studentId;
		TeachStudentEmployment info = teachStudentEmploymentMapper.schoolIdUnique(studentId);
		if (StringUtils.isNotNull(info) && info.getStudentId().longValue() == userId.longValue())
		{
			return "1";
		}
		return "0";
	}
	
    /**
     * 新增学生就业
         * @param teachStudentEmployment 学生就业信息
     * @return 结果
     */
	@Override
	public int insertTeachStudentEmployment(TeachStudentEmployment teachStudentEmployment)
	{
		int result = 0;
		List<Map<String,Object>> list = FastJsonUtils.getJsonToListMap(teachStudentEmployment.getChildren().toString());
		for (Map<String,Object> map:list) {
			Integer studentId =  Integer.parseInt(map.get("studentId").toString());
			TeachStudentEmployment studentEmployment = new TeachStudentEmployment();
			if(map.get("urbanEmployment").toString().isEmpty() == false){
				studentEmployment.setUrbanEmployment(map.get("urbanEmployment").toString());
			}
			if(map.get("probationSalary").toString().isEmpty() == false){
				String probation = map.get("probationSalary").toString();
				studentEmployment.setProbationSalary(Double.valueOf(probation));
			}
			if(map.get("obtainmentSalary").toString().isEmpty() == false){
				String obtainment = map.get("obtainmentSalary").toString();
				studentEmployment.setObtainmentSalary(Double.valueOf(obtainment));
			}
			if(map.get("employmentWay").toString().isEmpty() == false){
				studentEmployment.setEmploymentWay(map.get("employmentWay").toString());
			}
			if(map.get("verify").toString().isEmpty() == false){
				String verified = map.get("verify").toString();
				studentEmployment.setEmploymentIsTrue(Integer.parseInt(verified));
			}
			if(map.get("teacher1").toString().isEmpty() == false){
				String teacherId1 = map.get("teacher1").toString();
				studentEmployment.setTeacherEmployment(Integer.parseInt(teacherId1));
			}
			if(map.get("employmentNote").toString().isEmpty() == false){
				studentEmployment.setEmploymentNote(map.get("employmentNote").toString());
			}
			if(map.get("hiredate").toString().isEmpty() == false){
				studentEmployment.setHiredate(map.get("hiredate").toString());
			}
			if(map.get("visitTime").toString().isEmpty() == false){
				studentEmployment.setVisitTime(map.get("visitTime").toString());
			}
			if(map.get("teacher2").toString().isEmpty() == false){
				studentEmployment.setVisitTeacher(Integer.parseInt(map.get("teacher2").toString()));
			}
			if(map.get("industry").toString().isEmpty() == false){
				studentEmployment.setIndustry(map.get("industry").toString());
			}
			if(map.get("einheit").toString().isEmpty() == false){
				studentEmployment.setEinheit(map.get("einheit").toString());
			}
			studentEmployment.setStudentId(studentId);
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String createtime = df.format(date);
			studentEmployment.setEdittime(createtime);
			if(map.get("id").toString().isEmpty() == false){
				String id = map.get("id").toString();
				studentEmployment.setId(Integer.parseInt(id));
				result = teachStudentEmploymentMapper.updateTeachStudentEmployment(studentEmployment);
			}else{
				result = teachStudentEmploymentMapper.insertTeachStudentEmployment(studentEmployment);
			}
		}
	    return result;
	}
	
	/**
     * 修改学生就业
         * @param teachStudentEmployment 学生就业信息
     * @return 结果
     */
	@Override
	public int updateTeachStudentEmployment(TeachStudentEmployment teachStudentEmployment)
	{
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String createtime = df.format(date);
		teachStudentEmployment.setEdittime(createtime);
	    return teachStudentEmploymentMapper.updateTeachStudentEmployment(teachStudentEmployment);
	}

	/**
     * 删除学生就业对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachStudentEmploymentByIds(String ids)
	{
		return teachStudentEmploymentMapper.deleteTeachStudentEmploymentByIds(Convert.toStrArray(ids));
	}
	
}
