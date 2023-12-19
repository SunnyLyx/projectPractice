package edu.fosu.teach.mapper;

import edu.fosu.teach.domain.TeachFileCollection;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import edu.fosu.common.base.BaseMapper;

/**
 * 学生档案收集 数据层
 * 集成BaseMapper 长用的方式可以共用
 *  */
@MapperScan
public interface TeachFileCollectionMapper  extends BaseMapper<TeachFileCollection>
{
	/**
     * 查询学生档案收集信息
         * @param studentId 学生档案收集ID
     * @return 学生档案收集信息
     */
	public TeachFileCollection selectTeachFileCollectionById(Integer studentId);
	
	/**
     * 查询学生档案收集列表
         * @param teachFileCollection 学生档案收集信息
     * @return 学生档案收集集合
     */
	public List<TeachFileCollection> selectTeachFileCollectionList(TeachFileCollection teachFileCollection);
	
	/**
     * 新增学生档案收集
         * @param teachFileCollection 学生档案收集信息
     * @return 结果
     */
	public int insertTeachFileCollection(TeachFileCollection teachFileCollection);
	
	/**
     * 修改学生档案收集
         * @param teachFileCollection 学生档案收集信息
     * @return 结果
     */
	public int updateTeachFileCollection(TeachFileCollection teachFileCollection);
	
	/**
     * 删除学生档案收集
         * @param studentId 学生档案收集ID
     * @return 结果
     */
	public int deleteTeachFileCollectionById(Integer studentId);
	
	/**
     * 批量删除学生档案收集
         * @param studentIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachFileCollectionByIds(String[] studentIds);
	
}