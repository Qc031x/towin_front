package com.sgfm.datacenter.service.common.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.EntityEnclosingMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.validator.Var;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgfm.datacenter.SysConstant;
import com.sgfm.datacenter.dao.CommonDao;
import com.sgfm.datacenter.service.common.CommonService;
import com.sgfm.datacenter.util.SysUtils;
import com.sgfm.datacenter.util.TbMsgUtil;
import com.taobao.api.ApiException;

import common.Logger;
import net.sf.json.JSONObject;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CommonDao commonDao;
	
	private final Logger logger = Logger.getLogger(this.getClass());
	/**
	 * 
	 * @param params
	 * @param templateName
	 * @param mobile
	 * @return Map<String,Object>
	 * 			key   ：   value
	 * 		success   ：   true ： 成功，   false ： 失败
	 * 		   msg    ：    返回消息提示
	 * @throws ApiException
	 */
	public Map<String, Object> sendMessage(Map<String, String> params, String templateName, String mobile) throws ApiException {
		Map<String, Object> info = new HashMap<String, Object>();
		StringBuilder sb = new StringBuilder();
		if (checkTodayMsgCount()) {
			info.put("success", false);
			sb.append("当日短信发送量已经到达上限！");
			logger.info(sb.toString());
			info.put("msg", sb.toString());
			return info;
		}
		Boolean flag = TbMsgUtil.sendMessage(params, templateName, mobile);
		if (flag) {
			sb.append("发送成功!");
		} else {
			sb.append("发送失败!");
		}
		logger.info(sb.toString());
		info.put("success", flag);
		info.put("msg", sb.toString());
		return info;
	}
	
	private boolean checkTodayMsgCount() {
		String date = new SimpleDateFormat("yyyy-MM-ss", Locale.CHINA).format(new Date());
		return commonDao.getTodayMsgCount(date) > SysConstant.MSG_CHECKCOUNT;
	}

	//预约成功发送微信模板消息
	public void sendWechatTemplate(Map<String, String> map) {

		String openId=map.get("openId");
		String result=null;
		String accessToken=getAccessToken();
		String url="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+accessToken;
    	String temp_id="ZfQubvedaUXvV94PmlDSUbgIeIrfhc2LCGAaAl99Q0w";
    	Map <String,Object> body=new HashMap<String,Object> ();
    	Map <String,Object> data=new HashMap<String,Object> ();
    	Map <String,Object> dataNode=new HashMap<String,Object> ();
    	
    	body.put("touser", openId);
    	body.put("template_id", temp_id);
    	body.put("url", "http://p.51towin.com/core/user.findUserReservation.do?openId="+openId);
    	
    	String first="亲，您于"+(new Date()).toLocaleString()+"提交了体检预约单";
    	dataNode.put("value",first);
    	dataNode.put("color", "#173177"); 
    	data.put("first", dataNode);
    	
    	//体检人
    	dataNode=new HashMap<String,Object> ();
    	String name =(String)map.get("uname");
    	dataNode.put("value", name);
    	dataNode.put("color", "#173177");
    	data.put("keyword1", dataNode);
    	
    	//体检套餐
    	dataNode=new HashMap<String,Object> ();
    	String product=map.get("pname")+"(地址:"+map.get("address")+")";
    	dataNode.put("value", product);
    	dataNode.put("color", "#173177");
    	data.put("keyword2", dataNode);
    	
    	//预约时间
    	dataNode=new HashMap<String,Object> ();
    	String orderTime = (String)map.get("orderTime");
    	dataNode.put("value", orderTime);
    	dataNode.put("color", "#173177");
    	data.put("keyword3", dataNode);
    	
    	body.put("data", data);
    	
    	
    	HttpPost httpPost = new HttpPost(url);
		DefaultHttpClient httpClient=new DefaultHttpClient();
		String json=JSONObject.fromObject(body).toString();
		StringEntity se = new StringEntity(json,"UTF-8");
	    se.setContentType("text/json");
	    se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
	    httpPost.setEntity(se);
	    HttpResponse response;
		try {
			response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
	        result = EntityUtils.toString(entity, "UTF-8");
	        logger.info("httpPostWithJSON 返回结果 : result:"+result);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//获取微信access_token
	public String getAccessToken(){
		String result=null;
		String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx44a26b8a7ef26809&secret=ce5575b427a386ce491e2549a515c4b0";
		HttpPost httpPost = new HttpPost(url);
		DefaultHttpClient httpClient=new DefaultHttpClient();
		HttpResponse response;
		try {
			response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			String getReturn = EntityUtils.toString(entity, "UTF-8");
			if(getReturn.indexOf("access_token")>=0){
				result= JSONObject.fromObject(getReturn).get("access_token").toString();
				logger.info("成功获取access_token！");
			}else{
				logger.info("获取access_token失败！");
			}
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
//	public void doGetSecretCode(){
//		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+SysConstant.APP_ID+""
//				+ "&redirect_uri=http://r.51towin.com/core/login.getUserOpenid.do&response_type=code&scope=snsapi_base#wechat_redirect";
//	}
//	
//	public JSONObject doGetUserInfoByWXCode(String code) {
//		JSONObject accessToken = getUserAccessToken(code); // 网页授权access_token
//		return getUserInfo(accessToken);
//	}
//
//	private JSONObject getUserAccessToken(String code) {
//		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx5fe648be5a0c3aef&secret=ec496b9b6940e653761d88aede0c3fc6&code=" + code + "&grant_type=authorization_code";
//		String data = postHttpReq(url);
//		JSONObject json = null;
//		try {
//			json = JSONObject.fromObject(URLDecoder.decode(data, "UTF-8"));
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		return json;
//	}
//
//	private JSONObject getUserInfo(JSONObject json) {
//		String url = "https://api.weixin.qq.com/sns/userinfo?access_token=" + json.optString("access_token") + "&openid=" + json.optString("openid") + "&lang=zh_CN";
//		String data = postHttpReq(url);
//		JSONObject userInfo = JSONObject.fromObject(data);
//		return userInfo;
//	}
//
//	public static String postHttpReq(String url) {
//		HttpClient httpClient = new HttpClient();
//		EntityEnclosingMethod postMethod = new PostMethod(url);
//		postMethod.setRequestHeader("Content-Type", "application/octet-stream");
//
//		String responseMsg = "";
//		int statusCode = 0;
//		try {
//			statusCode = httpClient.executeMethod(postMethod);// 发送请求
//			// responseMsg = postMethod.getResponseBodyAsString();// 获取返回值
//			BufferedReader reader = new BufferedReader(new InputStreamReader(postMethod.getResponseBodyAsStream()));
//			StringBuffer stringBuffer = new StringBuffer();
//			String str = "";
//			while ((str = reader.readLine()) != null) {
//				stringBuffer.append(str);
//			}
//			responseMsg = stringBuffer.toString();
//		} catch (HttpException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			postMethod.releaseConnection();// 释放连接
//		}
//
//		return responseMsg;
//	}

	public void sendWechatPayTemplate(Map<String, String> map) {
		String openId=map.get("openId");
		String result=null;
		String accessToken=getAccessToken();
		String url="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+accessToken;
    	String temp_id="LVu02DVo44QJWvz4whiyyGPDOV5U7PDo3uelPMetqqg";
    	Map <String,Object> body=new HashMap<String,Object> ();
    	Map <String,Object> data=new HashMap<String,Object> ();
    	Map <String,Object> dataNode=new HashMap<String,Object> ();
    	
    	body.put("touser", openId);
    	body.put("template_id", temp_id);
    	
    	String first="你好，恭喜您于"+(new Date()).toLocaleString()+"成功购买了"+map.get("buysum").toString()+"个体检套餐";
    	dataNode.put("value",first);
    	dataNode.put("color", "#173177"); 
    	data.put("first", dataNode);
    	
    	//订单编号
    	dataNode=new HashMap<String,Object> ();
    	dataNode.put("value", map.get("oid"));
    	dataNode.put("color", "#173177");
    	data.put("keyword1", dataNode);
    	
    	//商品详情
    	dataNode=new HashMap<String,Object> ();
    	String product=null;
    	if(SysUtils.isEmpty(map.get("wxCardStr"))){
    	 product=map.get("pname")+"\n商品将以邮寄方式送达给您，请耐心等待";
    	 body.put("url", "http://p.51towin.com/content/reservation.rs_login.do?openId="+openId);
    	}else{
    	 product=map.get("pname")+"\n卡密信息:"+map.get("wxCardStr");
    	 body.put("url", "http://p.51towin.com/core/user.findUserCard.do?openId="+openId);
    	}
    	
    	dataNode.put("value", product);
    	dataNode.put("color", "#173177");
    	data.put("keyword2", dataNode);
    	
    	//订单金额
    	dataNode=new HashMap<String,Object> ();
    	dataNode.put("value", map.get("orderPrice"));
    	dataNode.put("color", "#173177");
    	data.put("keyword3", dataNode);
    	
    	//备注
    	dataNode=new HashMap<String,Object> ();
    	dataNode.put("value", "请您在3个月内使用该商品，否则视为作废，谢谢您的支持与使用 ！服务热线：400-6616669");
    	dataNode.put("color", "#173177");
    	data.put("remark", dataNode);
    	
    	body.put("data", data);
    	
    	
    	HttpPost httpPost = new HttpPost(url);
		DefaultHttpClient httpClient=new DefaultHttpClient();
		String json=JSONObject.fromObject(body).toString();
		StringEntity se = new StringEntity(json,"UTF-8");
	    se.setContentType("text/json");
	    se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
	    httpPost.setEntity(se);
	    HttpResponse response;
		try {
			response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
	        result = EntityUtils.toString(entity, "UTF-8");
	        logger.info("httpPostWithJSON 返回结果 : result:"+result);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
