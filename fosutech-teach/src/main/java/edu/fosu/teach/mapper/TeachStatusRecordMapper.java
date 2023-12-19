package edu.fosu.teach.mapper;

import edu.fosu.teach.domain.TeachStatusRecord;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import edu.fosu.common.base.BaseMapper;

/**
 * 学生状态更改记录 数据层
 * 集成BaseMapper 长用的方式可以共用
 *  */
@MapperScan
public interface TeachStatusRecordMapper  extends BaseMapper<TeachStatusRecord>
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
     * 删除学生状态更改记录
         * @param id 学生状态更改记录ID
     * @return 结果
     */
	public int deleteTeachStatusRecordById(Integer id);
	
	/**
     * 批量删除学生状态更改记录
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachStatusRecordByIds(String[] ids);
	
}