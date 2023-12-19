package edu.fosu.teach.mapper;

import edu.fosu.teach.domain.TeachSubject;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import edu.fosu.common.base.BaseMapper;

/**
 * 班级项目 数据层
 * 集成BaseMapper 长用的方式可以共用
 *  */
@MapperScan
public interface TeachSubjectMapper  extends BaseMapper<TeachSubject>
{
	/**
     * 查询班级项目信息
         * @param subjectId 班级项目ID
     * @return 班级项目信息
     */
	public TeachSubject selectTeachSubjectById(Integer subjectId);
	
	/**
     * 查询班级项目列表
         * @param teachSubject 班级项目信息
     * @return 班级项目集合
     */
	public List<TeachSubject> selectTeachSubjectList(TeachSubject teachSubject);

	int selectTeachSubjectListCount(TeachSubject teachSubject);

	List<TeachSubject> selectTeachSubjectList1(TeachSubject teachSubject);

	int selectSum();

	int selectMaxId();

	/**
     * 新增班级项目
         * @param teachSubject 班级项目信息
     * @return 结果
     */
	public int insertTeachSubject(TeachSubject teachSubject);
	
	/**
     * 修改班级项目
         * @param teachSubject 班级项目信息
     * @return 结果
     */
	public int updateTeachSubject(TeachSubject teachSubject);
	
	/**
     * 删除班级项目
         * @param subjectId 班级项目ID
     * @return 结果
     */
	public int deleteTeachSubjectById(Integer subjectId);
	
	/**
     * 批量删除班级项目
         * @param subjectIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachSubjectByIds(String[] subjectIds);
	
}