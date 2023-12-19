package edu.fosu.teach.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import edu.fosu.common.exception.BusinessException;
import edu.fosu.common.utils.FastJsonUtils;
import edu.fosu.system.mapper.SysDictDataMapper;
import edu.fosu.teach.domain.TeachClassesTeacher;
import edu.fosu.teach.mapper.StudentMapper;
import edu.fosu.teach.mapper.TeachClassesTeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.TeachClassesMapper;
import edu.fosu.teach.domain.TeachClasses;
import edu.fosu.teach.service.ITeachClassesService;
import edu.fosu.common.support.Convert;

/**
 * 班级 服务层实现
 *  */
@Service
public class TeachClassesServiceImpl implements ITeachClassesService 
{
	@Autowired
	private TeachClassesMapper teachClassesMapper;

	@Autowired
	private TeachClassesTeacherMapper teachClassesTeacherMapper;

	@Autowired
	private StudentMapper studentMapper;

	@Autowired
	private SysDictDataMapper sysDictDataMapper;

	/**
     * 查询班级信息
         * @param classId 班级ID
     * @return 班级信息
     */
    @Override
	public TeachClasses selectTeachClassesById(Integer classId)
	{
	    return teachClassesMapper.selectTeachClassesById(classId);
	}

	/**
	 * 查询班级信息
	 *
	 * @param classId 班级ID
	 * @return 班级信息
	 */
	@Override
	public TeachClasses selectTeachClassById(Integer classId)
	{
		return teachClassesMapper.selectTeachClassById(classId);
	}

	/**
     * 查询班级列表
         * @param teachClasses 班级信息
     * @return 班级集合
     */
	@Override
	public List<TeachClasses> selectTeachClassesList(TeachClasses teachClasses)
	{
		List<TeachClasses> list = teachClassesMapper.selectTeachClassesList(teachClasses);
		if(list != null){
			for (TeachClasses classes:list) {
				Integer majorType = classes.getMajorType();
				String typeName = "";
				if(!"".equals(majorType) && majorType != null){
					typeName = sysDictDataMapper.selectDictLabel("teach_major_type",majorType.toString());
					classes.setTypeName(typeName);
				}
			}
		}
	    return list;
	}

	@Override
	public List<Map> selecttongji(int classId)
	{
		return studentMapper.selecttongji(classId);
	}

	@Override
	public List<String> selectClassesBySchoolId(int deptId)
	{
		return teachClassesMapper.selectClassesBySchoolId(deptId);
	}

	@Override
	public List<String> selectAllClasses(){
		return teachClassesMapper.selectAllClasses();
	}

	/**
     * 新增班级
         * @param teachClasses 班级信息
     * @return 结果
     */
	@Override
	public int insertTeachClasses(TeachClasses teachClasses)
	{
		TeachClasses teachClasses11 = new TeachClasses();
		teachClasses11.setClassName(teachClasses.getClassName());
		int count = teachClassesMapper.selectCount(teachClasses11);
		if (count > 0){
			return -1;
		}else {
			int id = 1;
			int sum = teachClassesMapper.selectSum();
			if(sum > 0) {
				id = teachClassesMapper.selectMaxId() + 1;
			}
			teachClasses.setClassId(id);
			SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
			String datetime = tempDate.format(new Date());
			teachClasses.setCreatetime(datetime);
			int a = teachClassesMapper.insertTeachClasses(teachClasses);
			if(a > 0){
				List<Map<String,Object>> list = FastJsonUtils.getJsonToListMap(teachClasses.getAaaa().toString());
				for (Map<String,Object> map:list) {
					Integer teacherId =  Integer.parseInt(map.get("teacherId1").toString());
					String stageId =  map.get("stageId").toString();
					String stageStarttime = map.get("stageStarttime").toString();
					TeachClassesTeacher teachClassesTeacher = new TeachClassesTeacher();
					if(map.get("stageEndtime").toString().isEmpty() == false){
						teachClassesTeacher.setStageEndtime(map.get("stageEndtime").toString());
					}
					if(map.get("teacherId2").toString().isEmpty() == false){
						teachClassesTeacher.setInstructorId(Integer.parseInt(map.get("teacherId2").toString()));
					}
					if(map.get("teacherId3").toString().isEmpty() == false){
						teachClassesTeacher.setAssistantId(Integer.parseInt(map.get("teacherId3").toString()));
					}
					teachClassesTeacher.setId(UUID.randomUUID().toString());
					teachClassesTeacher.setClassId(id);
					teachClassesTeacher.setStageId(stageId);
					teachClassesTeacher.setTeacherId(teacherId);
					teachClassesTeacher.setStageStarttime(stageStarttime);
					int b = teachClassesTeacherMapper.insertSelective(teachClassesTeacher);
					if(b <= 0){
						return b;
					}
				}
			}
			return a;
		}
	}
	
	/**
     * 修改班级
         * @param teachClasses 班级信息
     * @return 结果
     */
	@Override
	public int updateTeachClasses(TeachClasses teachClasses)
	{
		int a = teachClassesMapper.updateByPrimaryKeySelective(teachClasses);
		if(a > 0){
			List<Map<String,Object>> list = FastJsonUtils.getJsonToListMap(teachClasses.getAaaa().toString());
			for (Map<String,Object> map:list) {
				Integer teacherId =  Integer.parseInt(map.get("teacherId1").toString());
				String stageId =  map.get("stageId").toString();
				String stageStarttime = map.get("stageStarttime").toString();
				TeachClassesTeacher teachClassesTeacher = new TeachClassesTeacher();
				if(map.get("stageEndtime").toString().isEmpty() == false){
					teachClassesTeacher.setStageEndtime(map.get("stageEndtime").toString());
				}
				if(map.get("teacherId2").toString().isEmpty() == false){
					teachClassesTeacher.setInstructorId(Integer.parseInt(map.get("teacherId2").toString()));
				}
				if(map.get("teacherId3").toString().isEmpty() == false){
					teachClassesTeacher.setAssistantId(Integer.parseInt(map.get("teacherId3").toString()));
				}
				teachClassesTeacher.setTeacherId(teacherId);
				teachClassesTeacher.setStageId(stageId);
				teachClassesTeacher.setStageStarttime(stageStarttime);
				int b = 0;
				if("".equals(map.get("id"))){
					teachClassesTeacher.setClassId(teachClasses.getClassId());
					teachClassesTeacher.setId(UUID.randomUUID().toString());
					b = teachClassesTeacherMapper.insertSelective(teachClassesTeacher);
				}else{
					teachClassesTeacher.setId(map.get("id").toString());
					b = teachClassesTeacherMapper.updateByPrimaryKeySelective(teachClassesTeacher);
				}
				if(b <= 0){
					return b;
				}
			}
		}
	    return a;
	}

	/**
     * 删除班级对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachClassesByIds(String ids)
	{
		int b = studentMapper.selectClassStudents(ids);
		if(b > 0){
			return -1;
		}else {
			int a = teachClassesTeacherMapper.deleteTeachClassesTeacherByClassIds(Convert.toStrArray(ids));
			if (a>0){
				return teachClassesMapper.deleteTeachClassesByIds(Convert.toStrArray(ids));
			}else {
				return a;
			}
		}
	}

	@Override
	public int changeTeachClassesByIds(String ids) {
		return teachClassesMapper.changeTeachClassesByIds(ids);
	}

	/**
	 * 班级连接状态修改
	 *
	 * @param teachClasses 班级信息
	 * @return 结果
	 */
	@Override
	public int changeStatus(TeachClasses teachClasses)
	{
		return teachClassesMapper.updateTeachClasses(teachClasses);
	}
}
