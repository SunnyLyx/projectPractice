package edu.fosu.teach.mapper;

import edu.fosu.teach.domain.TeachSupervisionSubject;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import edu.fosu.common.base.BaseMapper;

/**
 * 总部督查项目 数据层
 * 集成BaseMapper 长用的方式可以共用
 *  */
@MapperScan
public interface TeachSupervisionSubjectMapper  extends BaseMapper<TeachSupervisionSubject>
{
	/**
     * 查询总部督查项目信息
         * @param id 总部督查项目ID
     * @return 总部督查项目信息
     */
	public TeachSupervisionSubject selectTeachSupervisionSubjectById(Integer id);

	/**
	 * 查询总部督查项目信息(修改1)
	 *
	 * @param id 总部督查项目ID
	 * @return 总部督查项目信息
	 */
	public TeachSupervisionSubject selectTeachSupervisionSubjectsById(Integer id);
	
	/**
     * 查询总部督查项目列表
         * @param teachSupervisionSubject 总部督查项目信息
     * @return 总部督查项目集合
     */
	public List<TeachSupervisionSubject> selectTeachSupervisionSubjectList(TeachSupervisionSubject teachSupervisionSubject);

	/**
	 * 查询总部督查项目列表
	 *
	 * @param schoolId 分部id
	 * @return 总部督查项目集合
	 */
	public List<TeachSupervisionSubject> selectTeachSupervisionSubjectListById(Integer schoolId);
	
	/**
     * 新增总部督查项目
         * @param teachSupervisionSubject 总部督查项目信息
     * @return 结果
     */
	public int insertTeachSupervisionSubject(TeachSupervisionSubject teachSupervisionSubject);
	
	/**
     * 修改总部督查项目
         * @param teachSupervisionSubject 总部督查项目信息
     * @return 结果
     */
	public int updateTeachSupervisionSubject(TeachSupervisionSubject teachSupervisionSubject);
	
	/**
     * 删除总部督查项目
         * @param id 总部督查项目ID
     * @return 结果
     */
	public int deleteTeachSupervisionSubjectById(Integer id);
	
	/**
     * 批量删除总部督查项目
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachSupervisionSubjectByIds(String[] ids);
	
}