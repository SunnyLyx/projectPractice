package edu.fosu.teach.service;

import edu.fosu.teach.domain.School;
import java.util.List;

/**
 * 分部 服务层
 *  */
public interface ISchoolService 
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
     * 删除分部信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSchoolByIds(String ids);
	
}
