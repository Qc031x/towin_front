package com.sgfm.datacenter.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sgfm.base.util.PropsLoader;
import com.sgfm.datacenter.SysConstant;
import com.sgfm.datacenter.entity.TMember;
import com.sgfm.datacenter.login.model.AuthorizedInfo;
import com.sgfm.datacenter.util.SpringContext;

/**
 * 权限验证过滤器
 * 
 * @概述：
 * @author cliu
 * @时间：2017-1-21 上午09:00
 */
public class FRONTRightLimitFilter implements Filter {
    private Log log = LogFactory.getLog(this.getClass());
    WebApplicationContext applicationContext = null;

    public void init(FilterConfig filterConfig) {
        applicationContext = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
    }
    public boolean checkCookInfo(HttpServletRequest httpservletrequest){
    	try {
    		
    		String requrl=	httpservletrequest.getRequestURI();   	
    		Enumeration  head_names=	httpservletrequest.getHeaderNames();
    		String head_str="";
    		while(head_names.hasMoreElements()){//以此取出头信息
    			   String headerName=(String)head_names.nextElement();
    		       String headerValue=httpservletrequest.getHeader(headerName);//取出头信息内容
    		       head_str+=headerName+":"+headerValue+"\n";

    		}	
    		
    		  if(requrl.indexOf("checkAccountOrRegister")>0){
    			   if(head_str.indexOf("yk_wap_cook_flag")>0){
    				   log.info("Y手机短信获取验证码有cookie"+"\n"); 
    	    			return true;
    	    		}
    			   else{
    				   log.info("N手机短信获取验证码没有cookie"+"\n"); 
    				   return false;
    			   }
      			
      		}
    		
    		 
    	} catch (Exception e) {
    		
    		e.printStackTrace();
    	}
    	return true;
    	
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        long t1 = System.currentTimeMillis();
        
    	HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();

        // 获得页面地址，如:/DataCenter/contentRoot/login.do
        String url = servletRequest.getRequestURI();
        //beg 短信攻击处理
//        if(!checkCookInfo(servletRequest)){
//			return;
//		}
     
        //end 短信攻击处理
        log.info(url+",wap请求原始地址："+"\n");
        String webapppath = servletRequest.getContextPath();
       /* if(url.equals("/")){
        	
        	  ApplicationContext app = AppContext.getAppContext();
        	  IndexAction action = (IndexAction) app.getBean("indexAction");
        	  action.indexPage(servletRequest,servletResponse);
        	return;
        }*/

        /*
         * 这里将会从session中获得用户对象，并判断是否为空，如果为空，则证明该用户没有正常登录，程序将会跳转到错误页面提示用户登录
         */
        /*TMember authorizedUser = (TMember) session.getAttribute(SysConstant.SYS_MEMBER_LOG_SUCC_INFO);*/
        Object employeeId = session.getAttribute("employeeId");
        if (employeeId == null) {
            if (checkUrl(webapppath, url)) {
                // 登录、验证用户名、验证密码url等放行。
//            	String cityInfo = (String) servletRequest.getSession().getAttribute(SysConstant.SYS_CITYID);
//            	if(cityInfo==null)
//            		setSessionCityInfo(servletRequest,servletResponse);
                filterChain.doFilter(request, response);
                return;
            } else {
               servletResponse.sendRedirect(webapppath + "/");
            // 	servletResponse.getWriter().write("<div style='display:none'>DataCenter Session Timeout</div> <script>self.location=window.location.href.substring(0,window.location.href.indexOf('DataCenter')+10);</script>");
            	//servletResponse.getWriter().write("<div style='display:none'>DataCenter Session Timeout</div> <script>alert(33)</script>");
            	// filterChain.doFilter(request, response);
            	return;
            }

        } else {
           

        }

        // 如果用户为注销动作,直接跳转到登录页面
        if (url.equalsIgnoreCase(webapppath + "/contentRoot/loginOut.do")) {
         //   session.removeAttribute(SysConstant.LOGIN_AUTHORIZEDUSERINFO);
            session.invalidate();// 清空session
            employeeId = null;
            servletResponse.sendRedirect(webapppath + "/contentRoot/login.do");
            return;
        }
        filterChain.doFilter(request, response);
        
        log.info(url+",本次请求花费："+(System.currentTimeMillis()-t1));
    }

    /**
     * 检查当前请求URL是否不需要拦截.
     * 
     * @param webapppath 项目部署目录
     * @param requestUrl 当前的请求URL
     * @return true表示不需要拦截
     */
    private boolean checkUrl(String webapppath, String requestUrl) {
        PropsLoader loader = (PropsLoader) SpringContext.getBean("propsLoader");
        String urlStr = loader.props.getProperty("request.url.no.intercept");
        String[] urls = urlStr.split(";");
        for (String url : urls) {
            if ((webapppath + url).trim().equalsIgnoreCase(requestUrl)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Function: 验证该用户是否可以访问此URL
     * 
     * @param auth 保存授权信息的对象
     * @param authURL 当前要访问道页面
     * @return
     */
    private boolean verifyPageAuth(AuthorizedInfo authInfo, String authURL) {
        boolean result = false;
        if (authInfo != null) {

            Map mapUrl = authInfo.getUrlMap();
            if (mapUrl.containsKey(authURL)) {
                return true;
            }
            Map map = (Map) applicationContext.getServletContext().getAttribute("");
            // Map map=authInfo.getAllMap();
            if (!map.containsKey(authURL)) {
                return true;
            }

        }
        return result;
    }

    public void destroy() {

    }
    public void setSessionCityInfo(HttpServletRequest request,HttpServletResponse response){
 	   
//    	try {    		
// 
//    		String cityInfo = (String) request.getSession().getAttribute(SysConstant.SYS_CITYID);
//    		//如果用户是第一次返回我们的首页，session里面没有值
//    		if(cityInfo == null){
//        		IPSeeker ipSeeker = IPSeeker.getInstance();
//        		String ip = ipSeeker.getIp(request);
//        		//String ip="219.137.150.255";
//        		 ApplicationContext app = AppContext.getAppContext();
//        		 ProductService productService = (ProductService) app.getBean("productServiceImpl");
//        		String country = ipSeeker.getCountry(ip);
//        		List<HashMap<String, Object>> CityList = productService.findAllCity();
//        		boolean flag=false;
//        		for (int i = 0; i < CityList.size(); i++) {
//    				//area = userService.findAreaById(Integer.parseInt(String.valueOf(CityList.get(i).get("ID"))));
//        			String cityTitle=CityList.get(i).get("TITLE").toString();
//        			String cityId=CityList.get(i).get("ID").toString();
//    				if(country.indexOf(cityTitle) > -1){
//    					//获取首页城市
//    					request.setAttribute("cityname", cityTitle);
//    			       	//city = String.valueOf(cityId);
//    			       	request.getSession().setAttribute(SysConstant.SYS_CITYID, cityId);
//    			    	request.getSession().setAttribute(SysConstant.SYS_CITYNAME, cityTitle);
//    			    	 String cityArea= IpCommtool.getMapByCityId(cityId);
//    			    	request.getSession().setAttribute(SysConstant.SYS_CITYAREANO, cityArea);
//    			       	flag=true;
//    			       	break;
//    				}
//    			}
//        		if(!flag){
//					request.setAttribute("cityname", "深圳");
//					//city = "10312";
//					request.getSession().setAttribute(SysConstant.SYS_CITYID, "10312");
//					request.getSession().setAttribute(SysConstant.SYS_CITYNAME, "深圳");
//					request.getSession().setAttribute(SysConstant.SYS_CITYAREANO, "0755");
//					
//				}
//    		}
//    		else{
//    			
//    			
//    		}
//    	
//    		
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
    	
    	
	}

}
