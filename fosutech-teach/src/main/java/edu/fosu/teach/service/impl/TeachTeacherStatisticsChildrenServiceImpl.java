package edu.fosu.teach.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.TeachTeacherStatisticsChildrenMapper;
import edu.fosu.teach.domain.TeachTeacherStatisticsChildren;
import edu.fosu.teach.service.ITeachTeacherStatisticsChildrenService;
import edu.fosu.common.support.Convert;

/**
 * 数据统计（教师）子 服务层实现
 *  */
@Service
public class TeachTeacherStatisticsChildrenServiceImpl implements ITeachTeacherStatisticsChildrenService 
{
	@Autowired
	private TeachTeacherStatisticsChildrenMapper teachTeacherStatisticsChildrenMapper;

	/**
     * 查询数据统计（教师）子信息
         * @param id 数据统计（教师）子ID
     * @return 数据统计（教师）子信息
     */
    @Override
	public TeachTeacherStatisticsChildren selectTeachTeacherStatisticsChildrenById(Integer id)
	{
	    return teachTeacherStatisticsChildrenMapper.selectTeachTeacherStatisticsChildrenById(id);
	}
	
	/**
     * 查询数据统计（教师）子列表
         * @param teachTeacherStatisticsChildren 数据统计（教师）子信息
     * @return 数据统计（教师）子集合
     */
	@Override
	public List<TeachTeacherStatisticsChildren> selectTeachTeacherStatisticsChildrenList(TeachTeacherStatisticsChildren teachTeacherStatisticsChildren)
	{
	    return teachTeacherStatisticsChildrenMapper.selectTeachTeacherStatisticsChildrenList(teachTeacherStatisticsChildren);
	}
	
    /**
     * 新增数据统计（教师）子
         * @param teachTeacherStatisticsChildren 数据统计（教师）子信息
     * @return 结果
     */
	@Override
	public int insertTeachTeacherStatisticsChildren(TeachTeacherStatisticsChildren teachTeacherStatisticsChildren)
	{
	    return teachTeacherStatisticsChildrenMapper.insertTeachTeacherStatisticsChildren(teachTeacherStatisticsChildren);
	}
	
	/**
     * 修改数据统计（教师）子
         * @param teachTeacherStatisticsChildren 数据统计（教师）子信息
     * @return 结果
     */
	@Override
	public int updateTeachTeacherStatisticsChildren(TeachTeacherStatisticsChildren teachTeacherStatisticsChildren)
	{
	    return teachTeacherStatisticsChildrenMapper.updateTeachTeacherStatisticsChildren(teachTeacherStatisticsChildren);
	}

	/**
     * 删除数据统计（教师）子对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachTeacherStatisticsChildrenByIds(String ids)
	{
		return teachTeacherStatisticsChildrenMapper.deleteTeachTeacherStatisticsChildrenByIds(Convert.toStrArray(ids));
	}
	
}
