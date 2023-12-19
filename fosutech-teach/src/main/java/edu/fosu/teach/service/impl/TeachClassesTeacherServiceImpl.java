package edu.fosu.teach.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.TeachClassesTeacherMapper;
import edu.fosu.teach.domain.TeachClassesTeacher;
import edu.fosu.teach.service.ITeachClassesTeacherService;
import edu.fosu.common.support.Convert;

/**
 * 班级教师（班级子） 服务层实现
 *  */
@Service
public class TeachClassesTeacherServiceImpl implements ITeachClassesTeacherService 
{
	@Autowired
	private TeachClassesTeacherMapper teachClassesTeacherMapper;

	/**
     * 查询班级教师（班级子）信息
         * @param id 班级教师（班级子）ID
     * @return 班级教师（班级子）信息
     */
    @Override
	public TeachClassesTeacher selectTeachClassesTeacherById(Integer id)
	{
	    return teachClassesTeacherMapper.selectTeachClassesTeacherById(id);
	}
	
	/**
     * 查询班级教师（班级子）列表
         * @param teachClassesTeacher 班级教师（班级子）信息
     * @return 班级教师（班级子）集合
     */
	@Override
	public List<TeachClassesTeacher> selectTeachClassesTeacherList(TeachClassesTeacher teachClassesTeacher)
	{
	    return teachClassesTeacherMapper.selectTeachClassesTeacherList(teachClassesTeacher);
	}
	
    /**
     * 新增班级教师（班级子）
         * @param teachClassesTeacher 班级教师（班级子）信息
     * @return 结果
     */
	@Override
	public int insertTeachClassesTeacher(TeachClassesTeacher teachClassesTeacher)
	{
	    return teachClassesTeacherMapper.insertTeachClassesTeacher(teachClassesTeacher);
	}
	
	/**
     * 修改班级教师（班级子）
         * @param teachClassesTeacher 班级教师（班级子）信息
     * @return 结果
     */
	@Override
	public int updateTeachClassesTeacher(TeachClassesTeacher teachClassesTeacher)
	{
	    return teachClassesTeacherMapper.updateTeachClassesTeacher(teachClassesTeacher);
	}

	/**
     * 删除班级教师（班级子）对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachClassesTeacherByIds(String ids)
	{
		return teachClassesTeacherMapper.deleteTeachClassesTeacherByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除班级教师（班级子）对象
	 *
	 * @return 结果
	 */
	@Override
	public int deleteTeachClassesTeacherById(TeachClassesTeacher teachClassesTeacher)
	{
		if("".equals(teachClassesTeacher.getId())){
			return 1;
		}
		return teachClassesTeacherMapper.delete(teachClassesTeacher);
	}

	/**
	 * 根据班级查询班级老师
	 * @param classId
	 * @return
	 */
    @Override
    public List<Map<String, Object>> selectByClassId(Integer classId) {
        return teachClassesTeacherMapper.selectByClassId(classId);
    }

    @Override
	public List<String> selectTeachClasses(TeachClassesTeacher teachClassesTeacher){
		return teachClassesTeacherMapper.selectTeachClasses(teachClassesTeacher);
	}
}
