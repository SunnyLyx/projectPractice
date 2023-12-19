package edu.fosu.knowledge.service;

import edu.fosu.knowledge.domain.KnowledgeOss;
import java.util.List;

/**
 * 文件上传 服务层
 *  */
public interface IKnowledgeOssService 
{
	/**
     * 查询文件上传信息
         * @param id 文件上传ID
     * @return 文件上传信息
     */
	public KnowledgeOss selectKnowledgeOssById(Long id);
	
	/**
     * 查询文件上传列表
         * @param knowledgeOss 文件上传信息
     * @return 文件上传集合
     */
	public List<KnowledgeOss> selectKnowledgeOssList(KnowledgeOss knowledgeOss);
	
	/**
     * 新增文件上传
         * @param knowledgeOss 文件上传信息
     * @return 结果
     */
	public int insertKnowledgeOss(KnowledgeOss knowledgeOss);
	
	/**
     * 修改文件上传
         * @param knowledgeOss 文件上传信息
     * @return 结果
     */
	public int updateKnowledgeOss(KnowledgeOss knowledgeOss);
		
	/**
     * 删除文件上传信息
         * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteKnowledgeOssByIds(String ids);
	
}
