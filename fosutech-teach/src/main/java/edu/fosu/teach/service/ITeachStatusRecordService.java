package edu.fosu.teach.service;

import edu.fosu.teach.domain.TeachStatusRecord;
import java.util.List;

/**
 * 学生状态更改记录 服务层
 *  */
public interface ITeachStatusRecordService 
{
	/**
     * 查询学生状态更改记录信息
         * @param id 学生状态更改记录ID
     * @return 学生状态更改记录信息
     */
	public TeachStatusRecord selectTeachStatusRecordById(Integer id);
	
	/**
     * 查询学生状态更改记录列表
         * @param teachStatusRecord 学生状态更改记录信息
     * @return 学生状态更改记录集合
     */
	public List<TeachStatusRecord> selectTeachStatusRecordList(TeachStatusRecord teachStatusRecord);
	
	/**
     * 新增学生状态更改记录
         * @param teachStatusRecord 学生状态更改记录信息
     * @return 结果
     */
	public int insertTeachStatusRecord(TeachStatusRecord teachStatusRecord);
	
	/**
     * 修改学生状态更改记录
         * @param teachStatusRecord 学生状态更改记录信息
     * @return 结果
     */
	public int updateTeachStatusRecord(TeachStatusRecord teachStatusRecord);
		
	/**
     * 删除学生状态更改记录信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachStatusRecordByIds(String ids);
	
}
