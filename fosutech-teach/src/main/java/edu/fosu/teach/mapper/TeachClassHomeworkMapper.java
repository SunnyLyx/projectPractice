package edu.fosu.teach.mapper;

import edu.fosu.teach.domain.TeachClassHomework;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import edu.fosu.common.base.BaseMapper;

/**
 * 班级作业统计 数据层
 * 集成BaseMapper 长用的方式可以共用
 *  */
@MapperScan
public interface TeachClassHomeworkMapper  extends BaseMapper<TeachClassHomework>
{
	/**
     * 查询班级作业统计信息
         * @param id 班级作业统计ID
     * @return 班级作业统计信息
     */
	public TeachClassHomework selectTeachClassHomeworkById(Integer id);
	
	/**
     * 查询班级作业统计列表
         * @param teachClassHomework 班级作业统计信息
     * @return 班级作业统计集合
     */
	public List<TeachClassHomework> selectTeachClassHomeworkList(TeachClassHomework teachClassHomework);
	
	/**
     * 新增班级作业统计
         * @param teachClassHomework 班级作业统计信息
     * @return 结果
     */
	public int insertTeachClassHomework(TeachClassHomework teachClassHomework);
	
	/**
     * 修改班级作业统计
         * @param teachClassHomework 班级作业统计信息
     * @return 结果
     */
	public int updateTeachClassHomework(TeachClassHomework teachClassHomework);
	
	/**
     * 删除班级作业统计
         * @param id 班级作业统计ID
     * @return 结果
     */
	public int deleteTeachClassHomeworkById(Integer id);
	
	/**
     * 批量删除班级作业统计
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachClassHomeworkByIds(String[] ids);

	/**
	 * 统计班级作业情况
	 * @return
	 */
	List<TeachClassHomework> selectTeachClassHomeworkTask();
}