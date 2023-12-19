package edu.fosu.web.controller.knowledge;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import edu.fosu.common.exception.oss.OssException;
import edu.fosu.framework.util.ShiroUtils;
import edu.fosu.framework.util.ValidatorUtils;
import edu.fosu.knowledge.domain.KnowledgeOss;
import edu.fosu.knowledge.service.IKnowledgeOssService;
import edu.fosu.system.service.ISysConfigService;
import edu.fosu.web.controller.system.cloud.CloudConstant;
import edu.fosu.web.controller.system.cloud.CloudStorageConfig;
import edu.fosu.web.controller.system.cloud.CloudStorageService;
import edu.fosu.web.controller.system.cloud.OSSFactory;
import edu.fosu.web.controller.system.cloud.valdator.AliyunGroup;
import edu.fosu.web.controller.system.cloud.valdator.QcloudGroup;
import edu.fosu.web.controller.system.cloud.valdator.QiniuGroup;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import edu.fosu.common.annotation.Log;
import edu.fosu.common.enums.BusinessType;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传 信息操作处理
 *  */
@Controller
@RequestMapping("/knowledge/knowledgeOss")
public class KnowledgeOssController extends BaseController
{
    private String prefix = "knowledge/knowledgeOss";

	private final static String KEY = CloudConstant.CLOUD_STORAGE_CONFIG_KEY;
	
	@Autowired
	private IKnowledgeOssService knowledgeOssService;

	@Autowired
	private ISysConfigService sysConfigService;
	
	@RequiresPermissions("knowledge:knowledgeOss:view")
	@GetMapping()
	public String knowledgeOss()
	{
	    return prefix + "/knowledgeOss";
	}
	
	/**
	 * 查询文件上传列表
	 */
	@RequiresPermissions("knowledge:knowledgeOss:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(KnowledgeOss knowledgeOss)
	{
		startPage();
        List<KnowledgeOss> list = knowledgeOssService.selectKnowledgeOssList(knowledgeOss);
		return getDataTable(list);
	}

	/**
	 * 云存储配置信息
	 */
	@RequestMapping("config")
	@RequiresPermissions("knowledge:knowledgeOss:config")
	public String config(Model model)
	{
		String jsonconfig = sysConfigService.selectConfigByKey(CloudConstant.CLOUD_STORAGE_CONFIG_KEY);
		// 获取云存储配置信息
		CloudStorageConfig config = JSON.parseObject(jsonconfig, CloudStorageConfig.class);
		model.addAttribute("config", config);
		return prefix + "/config";
	}

	/**
	 * 保存云存储配置信息
	 */
	@RequestMapping("saveConfig")
	@RequiresPermissions("knowledge:knowledgeOss:config")
	@ResponseBody
	public AjaxResult saveConfig(CloudStorageConfig config)
	{
		// 校验类型
		ValidatorUtils.validateEntity(config);
		if (config.getType() == CloudConstant.CloudService.QINIU.getValue())
		{
			// 校验七牛数据
			ValidatorUtils.validateEntity(config, QiniuGroup.class);
		}
		else if (config.getType() == CloudConstant.CloudService.ALIYUN.getValue())
		{
			// 校验阿里云数据
			ValidatorUtils.validateEntity(config, AliyunGroup.class);
		}
		else if (config.getType() == CloudConstant.CloudService.QCLOUD.getValue())
		{
			// 校验腾讯云数据
			ValidatorUtils.validateEntity(config, QcloudGroup.class);
		}
		return toAjax(sysConfigService.updateValueByKey(KEY, JSON.toJSONString(config)));
	}
	
	/**
	 * 导出文件上传列表
	 */
	@RequiresPermissions("knowledge:knowledgeOss:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(KnowledgeOss knowledgeOss)
    {
    	List<KnowledgeOss> list = knowledgeOssService.selectKnowledgeOssList(knowledgeOss);
        ExcelUtil<KnowledgeOss> util = new ExcelUtil<KnowledgeOss>(KnowledgeOss.class);
        return util.exportExcel(list, "knowledgeOss");
    }
	
	/**
	 * 新增文件上传
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存文件上传
	 */
	@RequiresPermissions("knowledge:knowledgeOss:add")
	@Log(title = "文件上传", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(KnowledgeOss knowledgeOss)
	{
		knowledgeOss.setCreateBy(ShiroUtils.getLoginName());
		knowledgeOss.setCreateTime(new Date());
		return toAjax(knowledgeOssService.insertKnowledgeOss(knowledgeOss));
	}

	/**
	 * 上传文件
	 */
	@RequestMapping("/upload")
	@RequiresPermissions("knowledge:knowledgeOss:add")
	@ResponseBody
	public AjaxResult upload(KnowledgeOss knowledgeOss,@RequestParam("file") MultipartFile file) throws Exception
	{
		if (file.isEmpty())
		{
			throw new OssException("上传文件不能为空");
		}
		// 上传文件
		String fileName = file.getOriginalFilename();
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		CloudStorageService storage = OSSFactory.build();
		String url = storage.uploadSuffix(file.getBytes(), suffix);
		// 保存文件信息
		KnowledgeOss ossEntity = new KnowledgeOss();
		ossEntity.setUrl(url);
		ossEntity.setFileSuffix(suffix);
		ossEntity.setCreateBy(ShiroUtils.getLoginName());
		ossEntity.setFileName(fileName);
		ossEntity.setCreateTime(new Date());
		ossEntity.setService(storage.getService());
		ossEntity.setMenuId(knowledgeOss.getMenuId());
		ossEntity.setExtend1("3");
		return toAjax(knowledgeOssService.insertKnowledgeOss(ossEntity)).put("url", ossEntity.getUrl()).put("fileName",ossEntity.getFileName());
	}

	/**
	 * 修改文件上传
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		KnowledgeOss knowledgeOss = knowledgeOssService.selectKnowledgeOssById(id);
		mmap.put("knowledgeOss", knowledgeOss);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存文件上传
	 */
	@RequiresPermissions("knowledge:knowledgeOss:edit")
	@Log(title = "文件上传", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(KnowledgeOss knowledgeOss)
	{		
		return toAjax(knowledgeOssService.updateKnowledgeOss(knowledgeOss));
	}

	@GetMapping("editor")
	@RequiresPermissions("knowledge:knowledgeOss:add")
	public String editor()
	{
		return prefix + "/editor";
	}

	/**
	 * 删除文件上传
	 */
	@RequiresPermissions("knowledge:knowledgeOss:remove")
	@Log(title = "文件上传", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(knowledgeOssService.deleteKnowledgeOssByIds(ids));
	}
	
}
