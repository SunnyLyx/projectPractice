package edu.fosu.system.mapper;

import edu.fosu.common.base.BaseMapper;
import edu.fosu.system.domain.SysOss;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * 文件上传
 */
@MapperScan
public interface SysOssMapper extends BaseMapper<SysOss>
{
}
