package edu.fosu.teach.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.fosu.teach.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.TeachSupervisionSubjectMapper;
import edu.fosu.teach.domain.TeachSupervisionSubject;
import edu.fosu.teach.service.ITeachSupervisionSubjectService;
import edu.fosu.common.support.Convert;

/**
 * 总部督查项目 服务层实现
 *  */
@Service
public class TeachSupervisionSubjectServiceImpl implements ITeachSupervisionSubjectService 
{
	@Autowired
	private TeachSupervisionSubjectMapper teachSupervisionSubjectMapper;

	@Autowired
	private StudentMapper studentMapper;

	/**
     * 查询总部督查项目信息
         * @param id 总部督查项目ID
     * @return 总部督查项目信息
     */
    @Override
	public TeachSupervisionSubject selectTeachSupervisionSubjectById(Integer id)
	{
	    return teachSupervisionSubjectMapper.selectTeachSupervisionSubjectById(id);
	}

	/**
	 * 查询总部督查项目信息(修改1)
	 *
	 * @param id 总部督查项目ID
	 * @return 总部督查项目信息
	 */
	@Override
	public TeachSupervisionSubject selectTeachSupervisionSubjectsById(Integer id)
	{
		return teachSupervisionSubjectMapper.selectTeachSupervisionSubjectsById(id);
	}
	
	/**
     * 查询总部督查项目列表
         * @param teachSupervisionSubject 总部督查项目信息
     * @return 总部督查项目集合
     */
	@Override
	public List<TeachSupervisionSubject> selectTeachSupervisionSubjectList(TeachSupervisionSubject teachSupervisionSubject)
	{
		List<TeachSupervisionSubject> list = teachSupervisionSubjectMapper.selectTeachSupervisionSubjectList(teachSupervisionSubject);
		for (TeachSupervisionSubject supervisionSubject: list) {
			Integer classId = supervisionSubject.getClassId();
			String reslut = studentMapper.selectStudentCount(classId);
//			Integer res = Integer.parseInt(reslut);
			Map<String ,Object> map = new HashMap<>();
			map.put("num",reslut);
			supervisionSubject.setParams(map);
		}
//		System.out.println(list);
	    return list;
	}

	/**
	 * 查询总部督查项目列表
	 *
	 * @param schoolId
	 * @return 总部督查项目集合
	 */
	@Override
	public List<TeachSupervisionSubject> selectTeachSupervisionSubjectListById(Integer schoolId)
	{
		List<TeachSupervisionSubject> list = teachSupervisionSubjectMapper.selectTeachSupervisionSubjectListById(schoolId);
		for (TeachSupervisionSubject supervisionSubject: list) {
			Integer classId = supervisionSubject.getClassId();
			String reslut = studentMapper.selectStudentCount(classId);
//			Integer res = Integer.parseInt(reslut);
			Map<String ,Object> map = new HashMap<>();
			map.put("num",reslut);
			supervisionSubject.setParams(map);
		}
		return list;
		//return teachSupervisionSubjectMapper.selectTeachSupervisionSubjectListById(schoolId);
	}

    /**
     * 新增总部督查项目
         * @param teachSupervisionSubject 总部督查项目信息
     * @return 结果
     */
	@Override
	public int insertTeachSupervisionSubject(TeachSupervisionSubject teachSupervisionSubject)
	{
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String createtime = df.format(date);
		teachSupervisionSubject.setCreatetime(createtime);
	    return teachSupervisionSubjectMapper.insertTeachSupervisionSubject(teachSupervisionSubject);
	}
	
	/**
     * 修改总部督查项目
         * @param teachSupervisionSubject 总部督查项目信息
     * @return 结果
     */
	@Override
	public int updateTeachSupervisionSubject(TeachSupervisionSubject teachSupervisionSubject)
	{
	    return teachSupervisionSubjectMapper.updateTeachSupervisionSubject(teachSupervisionSubject);
	}

	/**
     * 删除总部督查项目对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachSupervisionSubjectByIds(String ids)
	{
		return teachSupervisionSubjectMapper.deleteTeachSupervisionSubjectByIds(Convert.toStrArray(ids));
	}
	
}
