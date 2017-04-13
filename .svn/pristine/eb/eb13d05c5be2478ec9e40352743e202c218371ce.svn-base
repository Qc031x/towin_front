package com.sgfm.datacenter.service.PCUser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpException;

import net.sf.json.JSONObject;

/**
 * 公共方法处理接口
 * 2016年12月24日14:31:24
 *
 */
public interface UserService {
	
	public JSONObject doGetUserOpenid(String code) throws HttpException, IOException;
	
	public JSONObject doGetUserInfoByWXCode(String code) throws HttpException, IOException;
	
	//public void doCheckMemberInfo(Map<String, Object> param);
	
	public HashMap<String, Object> findMemberByOpenid(HashMap<String, Object> param);
	
}
