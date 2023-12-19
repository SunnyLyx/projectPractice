package edu.fosu.common.exception.oss;

/**
 * OSS信息异常类
 */
public class OssException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public OssException(String msg)
    {
        super(msg);
    }
}
