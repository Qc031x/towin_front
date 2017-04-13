package com.sgfm.datacenter.action.PCUser;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sgfm.base.action.BaseAction;
import com.sgfm.base.util.StringUtil;
import com.sgfm.datacenter.SysConstant;
import com.sgfm.datacenter.exception.AppException;
import com.sgfm.datacenter.service.PCUser.UserService;
import com.sgfm.datacenter.util.JsonResponseResult;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction {

	private static final long serialVersionUID = 2978575235806313066L;

	private Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private UserService userService;
	
//	public String getUserOpenid(){
//		JsonResponseResult result = null;
//		try {
//			
//			logger.info("微信回调成功, 返回code---" + super.getRequest().getParameter("code"));
//			JSONObject userinfo = userService.doGetUserInfoByWXCode(super.getRequest().getParameter("code"));
//			logger.info("返回用户信息:/n" + userinfo);
//			Map<String, Object> map = userinfo;
//			userService.doCheckMemberInfo(map);
//
//		} catch (final AppException app) {
//			this.logger.error(app);
//			final String msg = this.getText(app.getMessage());
//			result = JsonResponseResult.createFalied(msg);
//			super.jsonResult = JSONObject.fromObject(result).toString();
//		} catch (final Exception e) {
//			this.logger.error(e);
//			final String msg = this.getText("datacenter.action.LoginAction.exception");
//			result = JsonResponseResult.createFalied(msg);
//			super.jsonResult = JSONObject.fromObject(result).toString();
//		}
//		return BaseAction.JSON;
//	}
}