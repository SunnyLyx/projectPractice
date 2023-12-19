package edu.fosu.teach.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.teach.mapper.MajorMapper;
import edu.fosu.teach.domain.Major;
import edu.fosu.teach.service.IMajorService;
import edu.fosu.common.support.Convert;

/**
 * 专业 服务层实现
 *  */
@Service
public class MajorServiceImpl implements IMajorService 
{
	@Autowired
	private MajorMapper majorMapper;

	/**
     * 查询专业信息
         * @param majorId 专业ID
     * @return 专业信息
     */
    @Override
	public Major selectMajorById(Integer majorId)
	{
	    return majorMapper.selectMajorById(majorId);
	}
	
	/**
     * 查询专业列表
         * @param major 专业信息
     * @return 专业集合
     */
	@Override
	public List<Major> selectMajorList(Major major)
	{
	    return majorMapper.selectMajorList(major);
	}
	
    /**
     * 新增专业
         * @param major 专业信息
     * @return 结果
     */
	@Override
	public int insertMajor(Major major)
	{
	    return majorMapper.insertMajor(major);
	}
	
	/**
     * 修改专业
         * @param major 专业信息
     * @return 结果
     */
	@Override
	public int updateMajor(Major major)
	{
	    return majorMapper.updateMajor(major);
	}

	/**
     * 删除专业对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMajorByIds(String ids)
	{
		return majorMapper.deleteMajorByIds(Convert.toStrArray(ids));
	}
	
}
