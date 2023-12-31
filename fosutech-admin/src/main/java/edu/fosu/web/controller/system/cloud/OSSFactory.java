package edu.fosu.web.controller.system.cloud;

import com.alibaba.fastjson.JSON;
import edu.fosu.common.utils.spring.SpringUtils;
import edu.fosu.system.service.ISysConfigService;
import edu.fosu.web.controller.system.cloud.CloudConstant.CloudService;

/**
 * 文件上传Factory
 */
public final class OSSFactory
{
    private static ISysConfigService sysConfigService;
    static
    {
        OSSFactory.sysConfigService = (ISysConfigService) SpringUtils.getBean(ISysConfigService.class);
    }

    public static CloudStorageService build()
    {
        String jsonconfig = sysConfigService.selectConfigByKey(CloudConstant.CLOUD_STORAGE_CONFIG_KEY);
        // 获取云存储配置信息
        CloudStorageConfig config = JSON.parseObject(jsonconfig, CloudStorageConfig.class);
        if (config.getType() == CloudService.QINIU.getValue())
        {
            return new QiniuCloudStorageService(config);
        }
        else if (config.getType() == CloudService.ALIYUN.getValue())
        {
            return new AliyunCloudStorageService(config);
        }
        else if (config.getType() == CloudService.QCLOUD.getValue())
        {
            return new QcloudCloudStorageService(config);
        }
        return null;
    }
}
