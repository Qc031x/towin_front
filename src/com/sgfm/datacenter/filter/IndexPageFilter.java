package com.sgfm.datacenter.filter;

import java.io.IOException;

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
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sgfm.datacenter.action.IndexAction;
import com.sgfm.datacenter.util.AppContext;
import com.sgfm.datacenter.util.Ip.IpCommtool;

/**
 *
 * 
 * @概述：
 * @author cliu
 * @时间：2017-1-20 上午10:56:32
 */
public class IndexPageFilter implements Filter {
    private Log log = LogFactory.getLog(this.getClass());
    WebApplicationContext applicationContext = null;

    public void init(FilterConfig filterConfig) {
        applicationContext = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        long t1 = System.currentTimeMillis();
    	HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();
               String url = servletRequest.getRequestURI();
        String webapppath = servletRequest.getContextPath();
        if(url.equals("/")){
        	  ApplicationContext app = AppContext.getAppContext();
             IndexAction action = (IndexAction) app.getBean("indexAction");
        	action.indexPage2(servletRequest,servletResponse);
        	log.info(url+",本次首页请求花费："+(System.currentTimeMillis()-t1));
        	return;
        
       	  
        } 
        
        filterChain.doFilter(request, response);
        
    }
   /* public void ssoFilter(  ApplicationContext app,HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //HttpServletRequest request = (HttpServletRequest) servletRequest;
       // HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String ticket = request.getParameter("ticket");
        String url = URLEncoder.encode(request.getRequestURL().toString(), "UTF-8");
         
        if (null == username) {
            if (null != ticket && !"".equals(ticket)) {
                PostMethod postMethod = new PostMethod("http://192.168.1.130:8081/sso/ticket");
                postMethod.addParameter("ticket", ticket);
                HttpClient httpClient = new HttpClient();
                try {
                    httpClient.executeMethod(postMethod);
                    username = postMethod.getResponseBodyAsString();
                    postMethod.releaseConnection();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (null != username && !"".equals(username)) {
                    session.setAttribute("username", username);
                    LoginService loginService = (LoginService) app.getBean("loginServiceImpl");
                    tMember = this.loginService.findLoginTmemberByAccount(tAccount.getAccount());
                    filterChain.doFilter(request, response);
                } else {
                    response.sendRedirect("http://localhost:8081/sso/index.jsp?service=" + url);
                }
            } else {
                response.sendRedirect("http://localhost:8081/sso/index.jsp?service=" + url);
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }
*/

    public void destroy() {

    }

}
