package edu.fosu.teach.mapper;

import edu.fosu.teach.domain.Classes;
import java.util.List;
import java.util.Map;

import tk.mybatis.spring.annotation.MapperScan;
import edu.fosu.common.base.BaseMapper;

/**
 * 班级 数据层
 * 集成BaseMapper 长用的方式可以共用
 *  */
@MapperScan
public interface ClassesMapper  extends BaseMapper<Classes>
{
	/**
     * 查询班级信息
         * @param classId 班级ID
     * @return 班级信息
     */
	public Classes selectClassesById(Integer classId);
	
	/**
     * 查询班级列表
         * @param classes 班级信息
     * @return 班级集合
     */
	public List<Classes> selectClassesList(Classes classes);
	
	/**
     * 新增班级
         * @param classes 班级信息
     * @return 结果
     */
	public int insertClasses(Classes classes);
	
	/**
     * 修改班级
         * @param classes 班级信息
     * @return 结果
     */
	public int updateClasses(Classes classes);
	
	/**
     * 删除班级
         * @param classId 班级ID
     * @return 结果
     */
	public int deleteClassesById(Integer classId);
	
	/**
     * 批量删除班级
         * @param classIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteClassesByIds(String[] classIds);
	
}