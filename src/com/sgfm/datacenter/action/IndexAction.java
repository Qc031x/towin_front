package com.sgfm.datacenter.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sgfm.base.action.BaseAction;
import com.sgfm.base.util.StringUtil;
import com.sgfm.datacenter.SysConstant;
import com.sgfm.datacenter.entity.TArea;
import com.sgfm.datacenter.entity.TMember;
import com.sgfm.datacenter.service.PCUser.UserService;
import com.sgfm.datacenter.service.common.CommonService;
import com.sgfm.datacenter.service.common.impl.CommonServiceImpl;
import com.sgfm.datacenter.service.login.LoginService;
import com.sgfm.datacenter.util.AppContext;
import com.sgfm.datacenter.util.CookieUtil;
import com.sgfm.datacenter.util.SysUtils;
import com.sgfm.datacenter.util.Ip.IPSeeker;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
public class IndexAction extends BaseAction {

	private static final long serialVersionUID = -5393176239119452130L;
	private Log logger = LogFactory.getLog(IndexAction.class);

	private TArea area = new TArea();

	private LoginService loginService;

	public IndexAction() {
		// TODO Auto-generated constructor stub
		ApplicationContext app = AppContext.getAppContext();
		logger.info("app的bean数量1----" + app.getBeanDefinitionCount());
		loginService = (LoginService) app.getBean("loginServiceImpl");
	}

	@Autowired
	private UserService userService;

	public void indexPage2(HttpServletRequest request, HttpServletResponse response) {

		try {
			logger.info("微信返回code:------" + request.getParameter("code"));
//			logger.info("跳转页面openid:------" + request.getParameter("openid"));
//			if (!StringUtil.isBlank(request.getParameter("openid"))) {
//				request.setAttribute("openid", request.getParameter("openid"));
//			}
			logger.info("session的openid:----" + request.getSession().getAttribute(SysConstant.USER_OPENID) +"-------"+ new Date().toLocaleString());
			if (!StringUtil.isBlank(request.getParameter("code")) && SysUtils.isEmpty(request.getSession().getAttribute(SysConstant.USER_OPENID))) {
				JSONObject data = userService.doGetUserOpenid(request.getParameter("code"));

				logger.info("微信返回用户信息:\n------" + data);
				logger.info("微信indexPage2:openid------=" + data.optString("openid"));
				request.getSession().setAttribute(SysConstant.USER_OPENID, data.optString("openid"));
				
				logger.info("微信state参数:------" + request.getParameter("state") + "-----" + new Date().toLocaleString());
				if(request.getParameter("state").split("-")[0].equals("2") && request.getParameter("state").split("-").length > 1){
					//重定向到首页重新获取openid的参数
					String backUrl = request.getParameter("state").split("-")[1];
					logger.info("重定向的URL:-----" + backUrl + "-----" + new Date().toLocaleString());
					TMember tMember = (TMember) request.getSession().getAttribute(SysConstant.SYS_MEMBER_LOG_SUCC_INFO);
					if(SysUtils.isEmpty(tMember)){
						HashMap<String, Object> param = new HashMap<String, Object>();
						param.put("openid", data.optString("openid"));
						HashMap<String, Object> memberInfo = userService.findMemberByOpenid(param);
						request.getSession().setAttribute(SysConstant.SYS_MEMBER_LOG_SUCC_INFO, memberInfo);
					}
					request.setAttribute("backUrl", backUrl);
					request.setAttribute("backOpenid", data.optString("openid"));
				}

				// if(!data.isNullObject()){
				// Map<String, Object> param = data;
				// userService.doCheckMemberInfo(param);
				// }
			}
			// 获取城市cookie beg
			String cityName = CookieUtil.getCookieValue(request, "cookie_cityName");
			// cook有城市定位
			if (!StringUtil.isBlank(cityName)) {
				request.setAttribute("cityName", "深圳");
			}
			// 如果cook没有城市定位信息，我们就以用户的当前手机浏览器ip地址来定位城市
			else {
				IPSeeker ipSeeker = IPSeeker.getInstance();
				String ip = ipSeeker.getIp(request);
				// String ip="219.137.150.255";
				String country = ipSeeker.getCountry(ip);
				logger.info("app的bean数量2----" + AppContext.getAppContext().getBeanDefinitionCount());
				List<HashMap<String, Object>> CityList = loginService.findValidCity();
				boolean flag = false;
				for (int i = 0; i < CityList.size(); i++) {
					String cityTitle = CityList.get(i).get("TITLE").toString();
					String cityId = CityList.get(i).get("ID").toString();
					if (country.indexOf(cityTitle) > -1) {
						// 获取首页城市
						request.setAttribute("cityName", cityTitle);
						flag = true;
						break;
					}
				}
				if (!flag) {
					request.setAttribute("cityName", "深圳");
				}

			}
			// 获取城市cookie end
			request.getRequestDispatcher("/indexMain.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();

		}
		// return super.toContentView("porduct", "succ");

	}

	/*
	 * 设置首页所需数据
	 */
	private void setIndexData(HttpServletRequest request, HttpServletResponse response, String city) {

		// request.setAttribute("bannerList",
		// CommHashMap.getHashMapIndexBannerList(MemcachedConstant.YY_INDEXBANNER+city));

	}

}