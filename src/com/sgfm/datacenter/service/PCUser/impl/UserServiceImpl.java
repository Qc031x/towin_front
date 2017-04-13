package com.sgfm.datacenter.service.PCUser.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.ejb.FinderException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.EntityEnclosingMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.validator.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgfm.datacenter.SysConstant;
import com.sgfm.datacenter.dao.CommonDao;
import com.sgfm.datacenter.dao.PCUserDao;
import com.sgfm.datacenter.service.PCUser.UserService;
import com.sgfm.datacenter.service.common.CommonService;
import com.sgfm.datacenter.util.SysUtils;
import com.sgfm.datacenter.util.TbMsgUtil;
import com.taobao.api.ApiException;

import common.Logger;
import net.sf.json.JSONObject;

@Service
public class UserServiceImpl implements UserService {
	
	private Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private PCUserDao userDao;
	
//	public void doCheckMemberInfo(Map<String, Object> param){
//		//微信端企业员工预约获取的用户微信信息
////		HashMap<String, Object> userinfo = userDao.findMemInfoByOpenidOrMobile(param);
////		if(SysUtils.isEmpty(userinfo)){
////			HashMap<String, Object> newMember = new HashMap<String, Object>();
////			newMember.put("", value)
////		}
//	}
	

	public JSONObject doGetUserInfoByWXCode(String code) throws HttpException, IOException {
		return getUserInfo(doGetUserOpenid(code));
	}
	
	public JSONObject doGetUserOpenid(String code) throws HttpException, IOException {
		JSONObject accessToken = getUserAccessToken(code); // 网页授权access_token
		logger.info("获取的授权access_token:----" + accessToken);
		return accessToken;
	}

	private JSONObject getUserAccessToken(String code) throws HttpException, IOException {
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+SysConstant.WX_APP_ID+"&secret="+SysConstant.WX_APP_SECRET+"&code="
				+ code + "&grant_type=authorization_code";
		String data = postHttpReq(url);
		JSONObject json = null;
		try {
			json = JSONObject.fromObject(URLDecoder.decode(data, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return json;
	}

	private JSONObject getUserInfo(JSONObject json) throws HttpException, IOException {
		String url = "https://api.weixin.qq.com/sns/userinfo?access_token=" + json.optString("access_token")
				+ "&openid=" + json.optString("openid") + "&lang=zh_CN";
		String data = postHttpReq(url);
		JSONObject userInfo = JSONObject.fromObject(data);
		return userInfo;
	}

	public static String postHttpReq(String url) throws HttpException, IOException {
		HttpClient httpClient = new HttpClient();
		EntityEnclosingMethod postMethod = new PostMethod(url);
		postMethod.setRequestHeader("Content-Type", "application/octet-stream");

		String responseMsg = "";
		int statusCode = 0;
		try {
			statusCode = httpClient.executeMethod(postMethod);// 发送请求
			// responseMsg = postMethod.getResponseBodyAsString();// 获取返回值
			BufferedReader reader = new BufferedReader(new InputStreamReader(postMethod.getResponseBodyAsStream()));
			StringBuffer stringBuffer = new StringBuffer();
			String str = "";
			while ((str = reader.readLine()) != null) {
				stringBuffer.append(str);
			}
			responseMsg = stringBuffer.toString();
		} finally {
			postMethod.releaseConnection();// 释放连接
		}

		return responseMsg;
	}

	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
	
	public HashMap<String, Object> findMemberByOpenid(HashMap<String, Object> param){
		return userDao.findMemInfoByOpenidOrMobile(param);
	}

}
