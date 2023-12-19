package edu.fosu.teach.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.TeachSatisfactionMapper;
import edu.fosu.teach.domain.TeachSatisfaction;
import edu.fosu.teach.service.ITeachSatisfactionService;
import edu.fosu.common.support.Convert;

/**
 * 满意度 服务层实现
 *  */
@Service
public class TeachSatisfactionServiceImpl implements ITeachSatisfactionService 
{
	@Autowired
	private TeachSatisfactionMapper teachSatisfactionMapper;

	/**
     * 查询满意度信息
         * @param id 满意度ID
     * @return 满意度信息
     */
    @Override
	public TeachSatisfaction selectTeachSatisfactionById(Integer id)
	{
	    return teachSatisfactionMapper.selectTeachSatisfactionById(id);
	}
	
	/**
     * 查询满意度列表
         * @param teachSatisfaction 满意度信息
     * @return 满意度集合
     */
	@Override
	public List<TeachSatisfaction> selectTeachSatisfactionList(TeachSatisfaction teachSatisfaction)
	{
	    return teachSatisfactionMapper.selectTeachSatisfactionList(teachSatisfaction);
	}
	
    /**
     * 新增满意度
         * @param teachSatisfaction 满意度信息
     * @return 结果
     */
	@Override
	public int insertTeachSatisfaction(TeachSatisfaction teachSatisfaction)
	{
	    return teachSatisfactionMapper.insertTeachSatisfaction(teachSatisfaction);
	}
	
	/**
     * 修改满意度
         * @param teachSatisfaction 满意度信息
     * @return 结果
     */
	@Override
	public int updateTeachSatisfaction(TeachSatisfaction teachSatisfaction)
	{
		// TODO: 2019/3/18  代码没有写完
	    return teachSatisfactionMapper.updateTeachSatisfaction(teachSatisfaction);
	}

	/**
     * 删除满意度对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachSatisfactionByIds(String ids)
	{
		return teachSatisfactionMapper.deleteTeachSatisfactionByIds(Convert.toStrArray(ids));
	}
	
}
