package edu.fosu.teach.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.SchoolMapper;
import edu.fosu.teach.domain.School;
import edu.fosu.teach.service.ISchoolService;
import edu.fosu.common.support.Convert;

/**
 * 分部 服务层实现
 *  */
@Service
public class SchoolServiceImpl implements ISchoolService 
{
	@Autowired
	private SchoolMapper schoolMapper;

	/**
     * 查询分部信息
         * @param schoolId 分部ID
     * @return 分部信息
     */
    @Override
	public School selectSchoolById(Integer schoolId)
	{
	    return schoolMapper.selectSchoolById(schoolId);
	}
	
	/**
     * 查询分部列表
         * @param school 分部信息
     * @return 分部集合
     */
	@Override
	public List<School> selectSchoolList(School school)
	{
	    return schoolMapper.selectSchoolList(school);
	}

    /**
     * 新增分部
         * @param school 分部信息
     * @return 结果
     */
	@Override
	public int insertSchool(School school)
	{
		school.setDatetime(new Date());
	    return schoolMapper.insertSchool(school);
	}
	
	/**
     * 修改分部
         * @param school 分部信息
     * @return 结果
     */
	@Override
	public int updateSchool(School school)
	{
	    return schoolMapper.updateSchool(school);
	}

	/**
     * 删除分部对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSchoolByIds(String ids)
	{
		return schoolMapper.deleteSchoolByIds(Convert.toStrArray(ids));
	}
	
}
