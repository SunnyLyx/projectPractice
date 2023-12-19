package edu.fosu.knowledge.service.impl;

import java.util.List;

import edu.fosu.knowledge.domain.KnowledgeOss;
import edu.fosu.knowledge.mapper.KnowledgeOssMapper;
import edu.fosu.knowledge.service.IKnowledgeOssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fosu.common.support.Convert;

/**
 * 文件上传 服务层实现
 *  */
@Service
public class KnowledgeOssServiceImpl implements IKnowledgeOssService
{
	@Autowired
	private KnowledgeOssMapper knowledgeOssMapper;

	/**
     * 查询文件上传信息
         * @param id 文件上传ID
     * @return 文件上传信息
     */
    @Override
	public KnowledgeOss selectKnowledgeOssById(Long id)
	{
	    return knowledgeOssMapper.selectKnowledgeOssById(id);
	}
	
	/**
     * 查询文件上传列表
         * @param knowledgeOss 文件上传信息
     * @return 文件上传集合
     */
	@Override
	public List<KnowledgeOss> selectKnowledgeOssList(KnowledgeOss knowledgeOss)
	{
	    return knowledgeOssMapper.selectKnowledgeOssList(knowledgeOss);
	}
	
    /**
     * 新增文件上传
         * @param knowledgeOss 文件上传信息
     * @return 结果
     */
	@Override
	public int insertKnowledgeOss(KnowledgeOss knowledgeOss)
	{
	    return knowledgeOssMapper.insertKnowledgeOss(knowledgeOss);
	}

	/**
     * 修改文件上传
         * @param knowledgeOss 文件上传信息
     * @return 结果
     */
	@Override
	public int updateKnowledgeOss(KnowledgeOss knowledgeOss)
	{
	    return knowledgeOssMapper.updateKnowledgeOss(knowledgeOss);
	}

	/**
     * 删除文件上传对象
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteKnowledgeOssByIds(String ids)
	{
		return knowledgeOssMapper.deleteKnowledgeOssByIds(Convert.toStrArray(ids));
	}
	
}
