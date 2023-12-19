package edu.fosu.teach.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.TeachStatusRecordMapper;
import edu.fosu.teach.domain.TeachStatusRecord;
import edu.fosu.teach.service.ITeachStatusRecordService;
import edu.fosu.common.support.Convert;

/**
 * 学生状态更改记录 服务层实现
 *  */
@Service
public class TeachStatusRecordServiceImpl implements ITeachStatusRecordService 
{
	@Autowired
	private TeachStatusRecordMapper teachStatusRecordMapper;

	/**
     * 查询学生状态更改记录信息
         * @param id 学生状态更改记录ID
     * @return 学生状态更改记录信息
     */
    @Override
	public TeachStatusRecord selectTeachStatusRecordById(Integer id)
	{
	    return teachStatusRecordMapper.selectTeachStatusRecordById(id);
	}
	
	/**
     * 查询学生状态更改记录列表
         * @param teachStatusRecord 学生状态更改记录信息
     * @return 学生状态更改记录集合
     */
	@Override
	public List<TeachStatusRecord> selectTeachStatusRecordList(TeachStatusRecord teachStatusRecord)
	{
	    return teachStatusRecordMapper.selectTeachStatusRecordList(teachStatusRecord);
	}
	
    /**
     * 新增学生状态更改记录
         * @param teachStatusRecord 学生状态更改记录信息
     * @return 结果
     */
	@Override
	public int insertTeachStatusRecord(TeachStatusRecord teachStatusRecord)
	{
	    return teachStatusRecordMapper.insertTeachStatusRecord(teachStatusRecord);
	}
	
	/**
     * 修改学生状态更改记录
         * @param teachStatusRecord 学生状态更改记录信息
     * @return 结果
     */
	@Override
	public int updateTeachStatusRecord(TeachStatusRecord teachStatusRecord)
	{
	    return teachStatusRecordMapper.updateTeachStatusRecord(teachStatusRecord);
	}

	/**
     * 删除学生状态更改记录对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachStatusRecordByIds(String ids)
	{
		return teachStatusRecordMapper.deleteTeachStatusRecordByIds(Convert.toStrArray(ids));
	}
	
}
