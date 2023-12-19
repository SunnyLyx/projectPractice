package edu.fosu.teach.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.ClassesMapper;
import edu.fosu.teach.domain.Classes;
import edu.fosu.teach.service.IClassesService;
import edu.fosu.common.support.Convert;

/**
 * 班级 服务层实现
 *  */
@Service
public class ClassesServiceImpl implements IClassesService 
{
	@Autowired
	private ClassesMapper classesMapper;

	/**
     * 查询班级信息
         * @param classId 班级ID
     * @return 班级信息
     */
    @Override
	public Classes selectClassesById(Integer classId)
	{
	    return classesMapper.selectClassesById(classId);
	}
	
	/**
     * 查询班级列表
         * @param classes 班级信息
     * @return 班级集合
     */
	@Override
	public List<Classes> selectClassesList(Classes classes)
	{
	    return classesMapper.selectClassesList(classes);
	}
	
    /**
     * 新增班级
         * @param classes 班级信息
     * @return 结果
     */
	@Override
	public int insertClasses(Classes classes)
	{
	    return classesMapper.insertClasses(classes);
	}
	
	/**
     * 修改班级
         * @param classes 班级信息
     * @return 结果
     */
	@Override
	public int updateClasses(Classes classes)
	{
//	    return classesMapper.updateByPrimaryKey(classes);
		return classesMapper.updateClasses(classes);
	}

	/**
     * 删除班级对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteClassesByIds(String ids)
	{
		return classesMapper.deleteClassesByIds(Convert.toStrArray(ids));
	}
	
}
