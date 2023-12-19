package edu.fosu.teach.mapper;

import edu.fosu.teach.domain.School;
import java.util.List;
import tk.mybatis.spring.annotation.MapperScan;
import edu.fosu.common.base.BaseMapper;

/**
 * 分部 数据层
 * 集成BaseMapper 长用的方式可以共用
 *  */
@MapperScan
public interface SchoolMapper  extends BaseMapper<School>
{
	/**
     * 查询分部信息
         * @param schoolId 分部ID
     * @return 分部信息
     */
	public School selectSchoolById(Integer schoolId);
	
	/**
     * 查询分部列表
         * @param school 分部信息
     * @return 分部集合
     */
	public List<School> selectSchoolList(School school);

	/**
     * 新增分部
         * @param school 分部信息
     * @return 结果
     */
	public int insertSchool(School school);
	
	/**
     * 修改分部
         * @param school 分部信息
     * @return 结果
     */
	public int updateSchool(School school);
	
	/**
     * 删除分部
         * @param schoolId 分部ID
     * @return 结果
     */
	public int deleteSchoolById(Integer schoolId);
	
	/**
     * 批量删除分部
         * @param schoolIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteSchoolByIds(String[] schoolIds);
	
}