package edu.fosu.common.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import edu.fosu.common.base.AjaxResult;

import java.util.Random;

/**
 * 阿里云短信发送
 *
 */
public class AliyunMsgUtil {

    //产品名称:云通信短信API产品,开发者无需替换
    private static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    private static final String domain = "dysmsapi.aliyuncs.com";
    //短信功能注册key
    private static final String accessKeyId = "LTAI75WuKVxMZz94";
    //短信功能注册secret
    private static final String accessKeySecret = "Da8R49OUDnkgTmAqHzfdrMvRmFHGLj";
    //短信签名
    private static final String signName = "科思沃斯";


    public static AjaxResult sendSms(String phoneNumber, String templateCode, String templateParam) {

        //标记是否发送成功
        boolean sendSuccess;
        //发送之后的回执信息
        String bizMessage = "";

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);

        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        } catch (ClientException e) {
            sendSuccess = false;
            bizMessage = e.getMessage();
        }

        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(phoneNumber);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(signName);
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(templateCode);
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam(templateParam);

        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        //request.setOutId("yourOutId");

        //hint 此处可能会抛出异常，注意catch
        try {
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
                //请求成功
                sendSuccess = true;
            } else {
                sendSuccess = false;
                bizMessage = sendSmsResponse.getMessage();
            }

        } catch (ClientException e) {
            sendSuccess = false;
            bizMessage = e.getMessage();
        }

        return sendSuccess ? AjaxResult.success("发送成功") : AjaxResult.error(bizMessage);
    }

    /**
     * 生成6位验证码字符串
     *
     * @return 6位验证码字符串
     */
    public static String generateIdentifyingCode() {

        String range = "0123456789";

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            //生成10以内的整数随机数
            builder.append(range.charAt(new Random().nextInt(range.length())));
        }
        return builder.toString();
    }
}
