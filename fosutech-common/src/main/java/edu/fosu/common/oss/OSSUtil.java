package edu.fosu.common.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Random;


/**
 */
@Component
public class OSSUtil {

    private static Logger logger = Logger.getLogger(OSSUtil.class);
    private String endpoint ="http://oss-cn-hangzhou.aliyuncs.com";
    private String accessKeyId = "LTAIhF7G5e1HF7tt";
    private String accessKeySecret = "BTawwOGhYZuLbag2b1QunDRhcX5UTI";
    private String expireTime = "315360000000";
    //private String bucketName = "oss-test-fosutech.oss-cn-hangzhou.aliyuncs.com";
    private String bucketName = "whfosutech";
    private  String FOLDER ="image/head/";
    private OSSClient client;

    private char[] parameterArray = {'w', 'h', 'x', 'y', 'g'};
    private String imageOperationHead = "?x-oss-process=image/";
    private String resizeOperation = "resize,m_fixed";
    private String cropOperation = "crop";

    /**
     * 获取阿里云OSS客户端对象
     */
    public OSSClient getOSSClient() {
        if (null != client) {
            return client;
        }
        return new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }

    /**
     * 关闭客户端连接
     */
    public void clientShutdown() {
        if (null != client) {
            client.shutdown();
        }
    }

    /**
     * 新建Bucket
     *
     * @param bucketName
     * @return true: 新建Bucket成功
     */
    public boolean createBucket(String bucketName) {
        client = getOSSClient();
        boolean flag = true;
        if (doesBucketExist(bucketName)) {
            flag = false;
        }
        client.createBucket(bucketName);
        //设置Bucket权限: 公共读
        client.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
        return flag;
    }

    /**
     * 删除Bucket
     *
     * @param bucketName bucket名称
     */
    public boolean deleteBucket(String bucketName) {
        client = getOSSClient();
        if (!doesBucketExist(bucketName)) {
            return false;
        }
        //判断bucket下是否有文件
        List<OSSObjectSummary> bucketFiles = getBucketFiles(bucketName, "");
        if (bucketFiles.isEmpty() || 0 == bucketFiles.size()) {
            client.deleteBucket(bucketName);
            client.shutdown();
            return true;
        }
        return false;
    }

    /**
     * 根据key获取OSS服务器上的文件输入流
     *
     * @param bucketName bucket名称
     * @param key        Bucket下的文件的路径名+文件名
     */
    public InputStream getOSS2InputStream(String bucketName, String key) {
        client = getOSSClient();
        OSSObject ossObj = ossObj = client.getObject(bucketName, key);
        return ossObj.getObjectContent();
    }

    /**
     * 判断bucket是否存在
     *
     * @param bucketName
     * @return
     */
    public boolean doesBucketExist(String bucketName) {
        client = getOSSClient();
        return client.doesBucketExist(bucketName);
    }

    /**
     * 判断某个文件是否存在
     *
     * @param key
     * @param bucketName
     * @return
     */
    public boolean doesFileExist(String bucketName, String key) {
        client = getOSSClient();
        return client.doesObjectExist(bucketName, key);
    }

    /**
     * 根据key删除OSS服务器上的文件
     *
     * @param bucketName bucket名称
     * @param key        Bucket下的文件的路径名+文件名
     */
    public void deleteFile(String bucketName, String key) {
        client = getOSSClient();
        client.deleteObject(bucketName, key);
    }

    /**
     * 下载文件
     *
     * @param bucketName
     * @param key
     * @param localFilePath
     */
    public void downloadFile(String bucketName, String key, String localFilePath) {
        client = getOSSClient();
        client.getObject(new GetObjectRequest(bucketName, key), new File(localFilePath));
    }

    /**
     * 上传文件到bucket下的分级目录
     *
     * @param localPath  上传文件路径
     * @param bucketName bucket名称
     * @param diskName   上传文件的目录  如："data/img/"
     * @return String url
     */
    public String uploadFile(String localPath, String bucketName, String diskName) {
        client = getOSSClient();
        String url = null;
        try {
            File file = new File(localPath);
            InputStream is = new FileInputStream(file);
            //文件以随机数命名
            String originalFilename = file.getName();
            String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
            Random random = new Random();
            String randomFileName = IdWorker.getId() + fileSuffix;
            Long fileSize = file.length();
            //创建上传Object的Metadata
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(is.available());
            metadata.setCacheControl("no-cache");
            metadata.setHeader("Pragma", "no-cache");
            metadata.setContentEncoding("utf-8");
            metadata.setContentType(getContentType(randomFileName));
            metadata.setContentDisposition("filename/filesize=" + randomFileName + "/" + fileSize + "Byte.");
            client.putObject(bucketName, diskName + randomFileName, is, metadata);
            //设置过期时间
            Date expiration = new Date(System.currentTimeMillis() + expireTime);
            url = client.generatePresignedUrl(bucketName, diskName + randomFileName, expiration).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    /**
     * 上传文件到bucket根目录
     *
     * @param fileName
     * @param bucketName
     * @return
     */
    public String uploadFile(String fileName, String bucketName) {
        return uploadFile(fileName, bucketName, null);
    }

    /**
     * 根据文件名获取文件的URL
     *
     * @param bucketName
     * @param key        如："img/a.jpg"
     * @return
     */
    public String getFileUrl(String bucketName, String key) {
        client = getOSSClient();
        Date expiration = new Date(System.currentTimeMillis() + expireTime);
        URL url = client.generatePresignedUrl(bucketName, key, expiration);
        if (url != null) {
            return url.toString();
        }
        return null;
    }

    /**
     * 通过文件路径获取文件的contentType
     *
     * @param key
     * @return contentType
     */
    /*public String getContentType(String key) throws IOException {
        return Files.probeContentType(Paths.get(key));
    }*/

    /**
     * 获取bucket下指定路径的文件集合
     *
     * @param bucketName
     * @param prefix     子目录 如："image/"
     * @return
     */
    public List<OSSObjectSummary> getBucketFiles(String bucketName, String prefix) {
        client = getOSSClient();
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest(bucketName);
        listObjectsRequest.setPrefix(prefix);
        ObjectListing listing = client.listObjects(listObjectsRequest);
        return listing.getObjectSummaries();
    }

    /**
     * 获取bucket下的文件集合
     *
     * @param bucketName
     * @return
     */
    public List<OSSObjectSummary> getBucketFiles(String bucketName) {
        return getBucketFiles(bucketName, null);
    }

    /**
     * 图片缩放
     *
     * @param bucketName
     * @param key
     * @param w          宽
     * @param h          高
     * @return
     */
    public String resizeImage(String bucketName, String key, Integer w, Integer h) {
        String fileUrl = getFileUrl(bucketName, key);
        if (fileUrl != null) {
            if (EmptyUtils.validPropertyEmpty(w, h)) {
                return fileUrl;
            }
            return dealImageParam(fileUrl, resizeOperation, w, h);
        }
        return null;
    }

    /**
     * 图片裁剪
     *
     * @param bucketName
     * @param key
     * @return
     */
    public String cropImage(String bucketName, String key, ImageParam imageParam) {
        String fileUrl = getFileUrl(bucketName, key);
        if (fileUrl != null) {
            if (EmptyUtils.validPropertyEmpty(imageParam.getW(), imageParam.getH(), imageParam.getX(), imageParam.getY(), imageParam.getG()) || EmptyUtils.isEmpty(imageParam)) {
                return fileUrl;
            }
            return dealImageParam(fileUrl, cropOperation, imageParam.getW(), imageParam.getH(), imageParam.getX(), imageParam.getY(), imageParam.getG());
        }
        return null;
    }

    /**
     * 处理图片参数
     *
     * @param fileUrl
     * @param operation
     * @param args
     * @return
     */
    public String dealImageParam(String fileUrl, String operation, Object... args) {
        StringBuilder requestURL = new StringBuilder(fileUrl.split("\\?")[0]).append(imageOperationHead).append(operation);
        for (int i = 0; i < args.length; i++) {
            if (!EmptyUtils.isEmpty(args[i])) {
                requestURL.append(",").append(parameterArray[i]).append("_").append(args[i]);
            }
        }
        return requestURL.toString();
    }


    /*public static String picOSS( MultipartFile uploadFile) throws Exception {
        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录
        // https://ram.console.aliyun.com 创建
        String accessKeyId = "";
        String accessKeySecret = "";
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传
        long time = new Date().getTime();
	    ossClient.putObject("bucketName", "filename", new ByteArrayInputStream(uploadFile.getBytes()));
        // 关闭client
        ossClient.shutdown();
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
        String url = ossClient.generatePresignedUrl("bucketName", "filename", expiration).toString();
        return url;
    }*/
    /**
     * 上传图片至OSS
     * @param file 上传文件(文件全路径如:D://image//cake.jpg)
     * @param
     * @param如"qj_nanjing/"
     * @return String 返回的唯一MD5数字签名
     * */
    public  URL uploadObject2OSS(MultipartFile file) {
        //String bucketName = BACKET_NAME;
        String folder = FOLDER;
        URL url = null;
        //初始化OSSClient
        client = getOSSClient();
        try {
            //以输入流的形式上传文件
            InputStream inputStream = file.getInputStream();
            String path = file.getName();
            String fileName = file.getOriginalFilename();
            String randomFileName = fileName;
            Long fileSize = file.getSize();
            //创建上传Object的Metadata
            ObjectMetadata metadata = new ObjectMetadata();
            //上传的文件的长度
            metadata.setContentLength(inputStream.available());
            //指定该Object被下载时的网页的缓存行为
            metadata.setCacheControl("no-cache");
            //指定该Object下设置Header
            metadata.setHeader("Pragma", "no-cache");
            //指定该Object被下载时的内容编码格式
            metadata.setContentEncoding("utf-8");
            //文件的MIME,定义文件的类型及网页编码,决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成,
            //如果没有扩展名则填默认值application/octet-stream
            metadata.setContentType(getContentType(randomFileName));
            //指定该Object被下载时的名称(指示MINME用户代理如何显示附加的文件,打开或下载,及文件名称)
            metadata.setContentDisposition("filename/filesize=" + randomFileName + "/" + fileSize + "Byte.");
            //上传文件 (上传文件流的形式)
            PutObjectResult putResult = client.putObject(bucketName, folder + randomFileName, inputStream, metadata);
            //解析结果
            url = getUrl(client,putResult.getETag());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("上传阿里云OSS服务器异常." + e.getMessage(), e);
        }
        return url;
    }
    public  URL getUrl(OSSClient ossClient,String key) {
        // 设置URL过期时间为10年
        Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
        return url;
    }
    public  String getContentType(String fileName){
        String fileExtension=fileName.substring(fileName.lastIndexOf("."));
        if(".bmp".equalsIgnoreCase(fileExtension)){
            return "image/bmp";
        }
        if(".gif".equalsIgnoreCase(fileExtension)){
            return "image/gif";
        }
        if(".jpeg".equalsIgnoreCase(fileExtension)||".jpg".equalsIgnoreCase(fileExtension)||".png".equalsIgnoreCase(fileExtension)){
            return "image/jpeg";
        }
            return fileName;
        }




}
