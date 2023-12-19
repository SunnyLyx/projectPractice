package edu.fosu.teach.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import edu.fosu.common.constant.UserConstants;
import edu.fosu.common.exception.BusinessException;
import edu.fosu.common.utils.StringUtils;
import edu.fosu.system.mapper.SysDictDataMapper;
import edu.fosu.system.service.ISysConfigService;
import edu.fosu.teach.domain.TeachStudentEmployment;
import edu.fosu.teach.mapper.TeachClassesMapper;
import edu.fosu.teach.mapper.TeachClassesTeacherMapper;
import edu.fosu.teach.mapper.TeachStudentEmploymentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.StudentMapper;
import edu.fosu.teach.domain.Student;
import edu.fosu.teach.service.IStudentService;
import edu.fosu.common.support.Convert;

/**
 * 学生档案 服务层实现
 *  */
@Service
public class StudentServiceImpl implements IStudentService
{

	private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

	@Autowired
	private StudentMapper studentMapper;

	@Autowired
	private SysDictDataMapper sysDictDataMapper;

	@Autowired
	private TeachStudentEmploymentMapper teachStudentEmploymentMapper;

	@Autowired
	private ISysConfigService configService;

	@Autowired
    private TeachClassesMapper teachClassesMapper;

	@Autowired
	private TeachClassesTeacherMapper teachClassesTeacherMapper;

	/**
     * 查询学生档案信息
         * @param studentId 学生档案ID
     * @return 学生档案信息
     */
    @Override
	public Student selectStudentById(Integer studentId)
	{
		Student student = studentMapper.selectStudentById(studentId);
//		TeachStudentEmployment employment = teachStudentEmploymentMapper.selectTeachStudentEmploymentByStudentId(studentId);
		Integer sex = student.getStudentSex();
		String gender = "";
		if(!"".equals(sex) && sex != null){
			gender = sysDictDataMapper.selectDictLabel("sys_user_sex",sex.toString());
		}
		Integer status = student.getStatus();
		String state = "";
		if(!"".equals(status) && status != null){
			if(status == 3){
				state = "转班";
			}else {
				state = sysDictDataMapper.selectDictLabel("teach_status",status.toString());
			}
		}
		Integer education = student.getEducation();
		String edu = "";
		if(education != null && !"".equals(education)){
			edu = sysDictDataMapper.selectDictLabel("teach_education",education.toString());
		}
		Integer singleparent = student.getSingleParent();
		String single = "";
		if(!"".equals(singleparent) && singleparent != null){
			single = sysDictDataMapper.selectDictLabel("teach_single_parent",singleparent.toString());
		}
		Integer degreenature = student.getDegreeInNature();
		String nature = "";
		if(!"".equals(degreenature) && degreenature != null){
			nature = sysDictDataMapper.selectDictLabel("teach_nature",degreenature.toString());
		}
		Integer base = student.getBase();
		String basic = "";
		if(!"".equals(base) && base != null){
			basic = sysDictDataMapper.selectDictLabel("teach_basic",base.toString());
		}
		Integer job = student.getJobCity();
		String jobCity = "";
		if(!"".equals(job) && job != null){
			jobCity = sysDictDataMapper.selectDictLabel("teach_job_city",job.toString());
		}
		Integer english = student.getEnglishLevel();
		String englishLevel = "";
		if(!"".equals(english) && english != null){
			englishLevel = sysDictDataMapper.selectDictLabel("teach_english_level",english.toString());
		}

		Map<String ,Object> map = new HashMap<>();
		map.put("gender",gender);
		map.put("state",state);
		map.put("edu",edu);
		map.put("single",single);
		map.put("nature",nature);
		map.put("basic",basic);
		map.put("jobCity",jobCity);
		map.put("englishLevel",englishLevel);
//		map.put("employment",employment);
		student.setParams(map);
	    return student;
	}
	
	/**
     * 查询学生档案列表
         * @param student 学生档案信息
     * @return 学生档案集合
     */
	@Override
	public List<Student> selectStudentList(Student student)
	{
		List<Student> list = studentMapper.selectStudentList(student);
		if(list != null){
			for(Student students : list) {
				Integer classId = students.getClassNo();
				if(classId != null && classId != 0){
					List<Map<String,Object>> mapList = teachClassesTeacherMapper.selectByClassNoAndTime(classId);
					/*Set<String> set = new LinkedHashSet<>();
					set.addAll(map);
					map.clear();
					map.addAll(set);*/
					StringBuffer sb = new StringBuffer();
					StringBuffer sb1 = new StringBuffer();
					StringBuffer sb2 = new StringBuffer();
					for (Map maps: mapList) {
						String teacher = ""; //班主任
						if(maps.get("teacher") != null){
							teacher = maps.get("teacher").toString();
						}
						String instructor = ""; //教师
						if(maps.get("instructor") != null){
							instructor = maps.get("instructor").toString();
						}
						String stageName = ""; //阶段
						if(maps.get("stage_name") != null){
							stageName = maps.get("stage_name").toString();
						}
						sb.append(teacher).append("/");
						sb1.append(instructor).append("/");
						sb2.append(stageName).append("/");
					}
					Map<String,Object> maps = new HashMap<>();
					if(sb != null && !"".equals(sb) && sb.length() != 0){
						String newStr = sb.toString().substring(0,sb.length() - 1);
						maps.put("teacher",newStr);
					}
					if(sb1 != null && !"".equals(sb1) && sb1.length() != 0){
						String newStr1 = sb1.toString().substring(0,sb1.length() - 1);
						maps.put("instructor",newStr1);
					}
					if(sb2 != null && !"".equals(sb2) && sb2.length() != 0){
						String newStr2 = sb2.toString().substring(0,sb2.length() - 1);
						maps.put("stageName",newStr2);
					}
					students.setParams(maps);
				}
			}
		}
	    return list;
	}

	@Override
	public List<Student> selectclassStudents(Student student){
		return studentMapper.selectclassStudents(student);
	}

	@Override
	public List<Student> classOtherStudents(Student student){
		return studentMapper.classOtherStudents(student);
	}

	@Override
	public List<Student> classOtherStudent(Student student){
		return studentMapper.classOtherStudent(student);
	}

	/**
	 * 导出查询
	 * 查询学生档案导出列表
	 *
	 * @param ids 学生档案信息
	 * @return 学生档案集合
	 */
	@Override
	public List<Student> selectStudentByIdsAndStudent(String ids)
	{
		String[] idArray = null;
		if(ids != null){
			idArray=Convert.toStrArray(ids);
		}
		List<Student> list = studentMapper.selectStudentByIdsAndStudent(idArray);
		if(list != null){
			for(Student students : list) {
				Integer classId = students.getClassNo();
				if(classId != null && classId != 0){
					List<Map<String,Object>> mapList = teachClassesTeacherMapper.selectByClassNoAndTime(classId);
					StringBuffer sb = new StringBuffer();
					StringBuffer sb1 = new StringBuffer();
					StringBuffer sb2 = new StringBuffer();
					for (Map maps: mapList) {
						String teacher = ""; //班主任
						if(maps.get("teacher") != null){
							teacher = maps.get("teacher").toString();
						}
						String instructor = ""; //教师
						if(maps.get("instructor") != null){
							instructor = maps.get("instructor").toString();
						}
						String stageName = ""; //阶段
						if(maps.get("stage_name") != null){
							stageName = maps.get("stage_name").toString();
						}
						sb.append(teacher).append("/");
						sb1.append(instructor).append("/");
						sb2.append(stageName).append("/");
					}
					Map<String,Object> maps = new HashMap<>();
					if(sb != null && !"".equals(sb) && sb.length() != 0){
						String newStr = sb.toString().substring(0,sb.length() - 1);
						maps.put("teacher",newStr);
					}
					if(sb1 != null && !"".equals(sb1) && sb1.length() != 0){
						String newStr1 = sb1.toString().substring(0,sb1.length() - 1);
						maps.put("instructor",newStr1);
					}
					if(sb2 != null && !"".equals(sb2) && sb2.length() != 0){
						String newStr2 = sb2.toString().substring(0,sb2.length() - 1);
						maps.put("stageName",newStr2);
					}
					students.setParams(maps);
				}
			}
		}
		return list;
	}

	/**
	 * 导出查询
	 * 查询学生档案导出列表
	 *
	 * @param ids 学生档案信息
	 * @return 学生档案集合
	 */
	@Override
	public List<Student> selectStudentByIdsAndStudentAndType(String ids,Integer majorType)
	{
		String[] idArray = null;
		if(ids != null){
			idArray=Convert.toStrArray(ids);
		}
		Student student = new Student();
		student.setStudentIds(idArray);
		student.setMajorType(majorType);
		List<Student> list = studentMapper.selectStudentByIdsAndStudentAndType(student);
		if(list != null){
			for(Student students : list) {
				Integer classId = students.getClassNo();
				if(classId != null && classId != 0){
					List<Map<String,Object>> mapList = teachClassesTeacherMapper.selectByClassNoAndTime(classId);
					StringBuffer sb = new StringBuffer();
					StringBuffer sb1 = new StringBuffer();
					StringBuffer sb2 = new StringBuffer();
					for (Map maps: mapList) {
						String teacher = ""; //班主任
						if(maps.get("teacher") != null){
							teacher = maps.get("teacher").toString();
						}
						String instructor = ""; //教师
						if(maps.get("instructor") != null){
							instructor = maps.get("instructor").toString();
						}
						String stageName = ""; //阶段
						if(maps.get("stage_name") != null){
							stageName = maps.get("stage_name").toString();
						}
						sb.append(teacher).append("/");
						sb1.append(instructor).append("/");
						sb2.append(stageName).append("/");
					}
					Map<String,Object> maps = new HashMap<>();
					if(sb != null && !"".equals(sb) && sb.length() != 0){
						String newStr = sb.toString().substring(0,sb.length() - 1);
						maps.put("teacher",newStr);
					}
					if(sb1 != null && !"".equals(sb1) && sb1.length() != 0){
						String newStr1 = sb1.toString().substring(0,sb1.length() - 1);
						maps.put("instructor",newStr1);
					}
					if(sb2 != null && !"".equals(sb2) && sb2.length() != 0){
						String newStr2 = sb2.toString().substring(0,sb2.length() - 1);
						maps.put("stageName",newStr2);
					}
					students.setParams(maps);
				}
			}
		}
		return list;
	}

	/**
	 * 根据树形id查询学生档案列表
	 *
	 * @param student
	 * @return 学生档案集合
	 */
	@Override
	public List<Student> selectStudentListById(Student student) {
		List<Student> result = studentMapper.selectStudentListById(student);
		if(result != null){
			for(Student students : result) {
				Integer classId = students.getClassNo();
				if(classId != null && classId != 0){
					List<Map<String,Object>> mapList = teachClassesTeacherMapper.selectByClassNoAndTime(classId);
					StringBuffer sb = new StringBuffer();
					StringBuffer sb1 = new StringBuffer();
					StringBuffer sb2 = new StringBuffer();
					for (Map maps: mapList) {
						String teacher = ""; //班主任
						if(maps.get("teacher") != null){
							teacher = maps.get("teacher").toString();
						}
						String instructor = ""; //教师
						if(maps.get("instructor") != null){
							instructor = maps.get("instructor").toString();
						}
						String stageName = ""; //阶段
						if(maps.get("stage_name") != null){
							stageName = maps.get("stage_name").toString();
						}
						sb.append(teacher).append("/");
						sb1.append(instructor).append("/");
						sb2.append(stageName).append("/");
					}
					Map<String,Object> maps = new HashMap<>();
					if(sb != null && !"".equals(sb) && sb.length() != 0){
						String newStr = sb.toString().substring(0,sb.length() - 1);
						maps.put("teacher",newStr);
					}
					if(sb1 != null && !"".equals(sb1) && sb1.length() != 0){
						String newStr1 = sb1.toString().substring(0,sb1.length() - 1);
						maps.put("instructor",newStr1);
					}
					if(sb2 != null && !"".equals(sb2) && sb2.length() != 0){
						String newStr2 = sb2.toString().substring(0,sb2.length() - 1);
						maps.put("stageName",newStr2);
					}
					students.setParams(maps);
				}
			}
		}
		return result;
	}

	/**
	 * 根据id查询学生档案
	 *
	 * @param studentId
	 * @return 学生档案
	 */
	@Override
	public Student selectStudentsById(Integer studentId) {
		Student result = studentMapper.selectStudentsById(studentId);
		Integer status = result.getStatus();
		String state = "";
		if(!"".equals(status) && status != null){
			if(status == 3){
				state = "转班";
			}else {
				state = sysDictDataMapper.selectDictLabel("teach_status",status.toString());
			}
		}
		Map<String,Object> map = new HashMap<>();
		map.put("state",state);
		result.setParams(map);
		return result;
	}

	/**
	 * 校验课工场账号是否唯一
	 *
	 * @param student
	 * @return
	 */
	@Override
	public String checkKgcUnique(Student student) {
		List<Map<String,Object>> info = studentMapper.checkKgcUnique(student.getKgcUid());
		if (info.size() != 0) {
			for (int i=0;i<info.size();i++){
				List<String> major1 = studentMapper.selectMajorByKgcUid(student.getKgcUid());
				if(major1.size() != 0){
					for (int j=0;j<major1.size();j++){
						String major2 = studentMapper.selectMajorByClassId(student.getClassNo());
						if(StringUtils.isNotNull(major2)){
							if(major1.get(j).equals(major2)){
								return UserConstants.USER_PHONE_NOT_UNIQUE;
							}
						}else{
							return UserConstants.USER_PHONE_UNIQUE;
						}
					}
				}else {
					return UserConstants.USER_PHONE_UNIQUE;
				}
			}
		}
		return UserConstants.USER_PHONE_UNIQUE;
	}

	/**
	 * 查询班级人数
	 *
	 * @return 结果
	 */
	@Override
	public String selectStudentCount(Integer classId)
	{
		return studentMapper.selectStudentCount(classId);
	}

	/**
	 * 查询班级人数
	 *
	 * @return 结果
	 */
	@Override
	public List<Map<String,Object>> selectStudentByClassId(Integer classNo)
	{
		List<Map<String,Object>> list = studentMapper.selectStudentByClassId(classNo);
		for (Map maps:list) {
			String edu;
			if(maps.get("education") != null){
				edu = sysDictDataMapper.selectDictLabel("teach_education",maps.get("education").toString());
				maps.put("edu",edu);
			}
			Integer studentId = Integer.parseInt(maps.get("student_id").toString());
			TeachStudentEmployment teachStudentEmployment = new TeachStudentEmployment();
			teachStudentEmployment.setStudentId(studentId);
			List<Map<String,Object>> employments = teachStudentEmploymentMapper.selectEmployment(teachStudentEmployment);
			for (Map mapList:employments) {
				maps.put("id",mapList.get("id"));
				maps.put("urbanEmployment",mapList.get("urban_employment"));
				maps.put("industry",mapList.get("industry"));
				maps.put("einheit",mapList.get("einheit"));
				maps.put("probationSalary",mapList.get("probation_salary"));
				maps.put("obtainmentSalary",mapList.get("obtainment_salary"));
				maps.put("hiredate",mapList.get("hiredate"));
				maps.put("teacherEmployment",mapList.get("teacher_employment"));
				maps.put("employment",mapList.get("employment"));
				maps.put("employmentNote",mapList.get("employment_note"));
				maps.put("verified",mapList.get("employment_isTrue"));
				maps.put("visitTime",mapList.get("visit_time"));
				maps.put("visitTeacher",mapList.get("visit_teacher"));
				maps.put("visit",mapList.get("visit"));
			}
		}
		return list;
	}

	/**
     * 新增学生档案
         * @param student 学生档案信息
     * @return 结果
     */
	@Override
	public int insertStudent(Student student)
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		// new Date()为获取当前系统时间
		student.setExtend3(df.format(new Date()));
	    return studentMapper.insertStudent(student);
	}
	
	/**
     * 修改学生档案
         * @param student 学生档案信息
     * @return 结果
     */
	@Override
	public int updateStudent(Student student)
	{
	    return studentMapper.updateStudent(student);
	}

	/**
     * 删除学生档案对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteStudentByIds(String ids)
	{
		return studentMapper.deleteStudentByIds(Convert.toStrArray(ids));
	}

	/**
	 * 导入学生数据
	 *
	 * @param studentList 学生数据列表
	 * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
	 * @param operName 操作用户
	 * @return 结果
	 */
	@Override
	public String importStudent(List<Student> studentList, Boolean isUpdateSupport, String operName)
	{
		if (StringUtils.isNull(studentList) || studentList.size() == 0)
		{
			throw new BusinessException("导入学生数据不能为空！");
		}
		int successNum = 0;
		int failureNum = 0;
		StringBuilder successMsg = new StringBuilder();
		StringBuilder failureMsg = new StringBuilder();
		for (Student student : studentList)
		{
			try
			{
				// 验证是否存在这个课工场UID+专业
				//Student stu = studentMapper.selectStudentByKgcUid(student.getKgcUid());
				String className = student.getClasses().getClassName();
				if(className != null && className != "" && className.length() != 0){
					student.setCreateBy(operName);
					Integer classId = teachClassesMapper.selectByClassName(className);
					List<String> major1 = studentMapper.selectMajorByKgcUid(student.getKgcUid());
					if(major1.size() != 0){
						for (int i=0;i<major1.size();i++){
							String major2 = studentMapper.selectMajorByClassId(classId);
							if(StringUtils.isNotNull(major2)){
								if(major1.get(i).equals(major2)){
									failureNum++;
									failureMsg.append("<br/>" + failureNum + "、学生 " + student.getStudentName() + " 已存在");
								}else{
									SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
									//毕业时间
									int legalLen = 10;
									if ((student.getGraduateDate().length() != legalLen) && student.getGraduateDate().length() != 0) {
										Date date = new Date(student.getGraduateDate());
										student.setGraduateDate(dateFormat.format(date));
									}

									//进班时间
									if ((student.getStartTime().length() != legalLen) && student.getStartTime().length() != 0) {
										Date date1 = new Date(student.getStartTime());
										student.setStartTime(dateFormat.format(date1));
									}

									//班级id
									student.setClassNo(classId);
									SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
									// new Date()为获取当前系统时间
									student.setExtend3(df.format(new Date()));
									this.insertStudent(student);
									successNum++;
									successMsg.append("<br/>" + successNum + "、学生 " + student.getStudentName() + " 导入成功");
								}
							}else{
								SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
								//毕业时间
								int legalLen = 10;
								if ((student.getGraduateDate().length() != legalLen) && student.getGraduateDate().length() != 0) {
									Date date = new Date(student.getGraduateDate());
									student.setGraduateDate(dateFormat.format(date));
								}

								//进班时间
								if ((student.getStartTime().length() != legalLen) && student.getStartTime().length() != 0) {
									Date date1 = new Date(student.getStartTime());
									student.setStartTime(dateFormat.format(date1));
								}

								//班级id
								student.setClassNo(classId);
								SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
								// new Date()为获取当前系统时间
								student.setExtend3(df.format(new Date()));
								this.insertStudent(student);
								successNum++;
								successMsg.append("<br/>" + successNum + "、学生 " + student.getStudentName() + " 导入成功");
							}
						}
					}else {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
						//毕业时间
						int legalLen = 10;
						if ((student.getGraduateDate().length() != legalLen) && student.getGraduateDate().length() != 0) {
							Date date = new Date(student.getGraduateDate());
							student.setGraduateDate(dateFormat.format(date));
						}

						//进班时间
						if ((student.getStartTime().length() != legalLen) && student.getStartTime().length() != 0) {
							Date date1 = new Date(student.getStartTime());
							student.setStartTime(dateFormat.format(date1));
						}

						//班级id
						student.setClassNo(classId);
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
						// new Date()为获取当前系统时间
						student.setExtend3(df.format(new Date()));
						this.insertStudent(student);
						successNum++;
						successMsg.append("<br/>" + successNum + "、学生 " + student.getStudentName() + " 导入成功");
					}

				}
				else if (isUpdateSupport)
				{
					student.setUpdateBy(operName);
					if(className != null && className != "" && className.length() != 0){
						Integer classId = teachClassesMapper.selectByClassName(className);
						student.setClassNo(classId);
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
						//毕业时间
						int legalLen = 10;
						if ((student.getGraduateDate().length() != legalLen) && student.getGraduateDate().length() != 0) {
							Date date = new Date(student.getGraduateDate());
							student.setGraduateDate(dateFormat.format(date));
						}

						//进班时间
						if ((student.getStartTime().length() != legalLen) && student.getStartTime().length() != 0) {
							Date date1 = new Date(student.getStartTime());
							student.setGraduateDate(dateFormat.format(date1));
						}

						//班级id
						student.setClassNo(classId);
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
						// new Date()为获取当前系统时间
						student.setExtend3(df.format(new Date()));
					}
					this.updateStudent(student);
					successNum++;
					successMsg.append("<br/>" + successNum + "、学生 " + student.getStudentName() + " 更新成功");
				}
				else
				{
					failureNum++;
					failureMsg.append("<br/>" + failureNum + "、学生 " + student.getStudentName() + " 已存在");
				}
			}
			catch (Exception e)
			{
				failureNum++;
				String msg = "<br/>" + failureNum + "、学生 " + student.getStudentName() + " 导入失败：";
				failureMsg.append(msg + e.getMessage());
				log.error(msg, e);
			}
		}
		if (failureNum > 0)
		{
			failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
			throw new BusinessException(failureMsg.toString());
		}
		else
		{
			successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
		}
		return successMsg.toString();
	}

	@Override
	public int selectStudentSum(int classId){
		return Integer.parseInt(studentMapper.selectStudentCount(classId));
	}
}
