package com.sgfm.datacenter.wxsendmsg;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLContext;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.tencent.business.ScanPayBusiness;
import com.tencent.business.ScanPayBusiness.ResultListener;
import com.tencent.protocol.order.ResultListenerImpl2;
import com.tencent.protocol.order.ScanAddOrderReqData;

/**
 * User: liuchong
 * Date: 2017/3/2
 * Time: 14:36
 */
public class SysOfficeAccountSendMsg{
	    public static  Map <String,Object> sys_wxmsg_type=new HashMap<String,Object> ();
	    private static Log logger = LogFactory.getLog(SysOfficeAccountSendMsg.class);
	    
	    private static final String APPLICATION_JSON = "application/json";	    
	    private static final String CONTENT_TYPE_TEXT_JSON = "text/json";
	    //HTTP请求器
	    private CloseableHttpClient httpClient;
	    //表示请求器是否已经做了初始化工作
	    private boolean hasInit = false;
	    // 1表示员工预约后， map<String ,Object> key说明:name员工姓名| productType 套餐类型1固定，2，3自定义| address 分院地址|date 体检时间
       public static String sendOfficiaAccountsMsg(int type,Map <String,Object> msg) throws Exception
       {
    	   // 获取公众号的access_token
    	      String cache_key="";
	    	   String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx44a26b8a7ef26809&secret=ce5575b427a386ce491e2549a515c4b0";
	     	  String  responseString= sendHttpsPost(url);             
	     	  JSONObject dataJson = JSONObject.fromObject(responseString);  
	 	      String access_token= (String)dataJson.get("access_token");
	 	      Map <String,Object> parm=new HashMap<String,Object> ();
	 	      Map <String,Object> data=new HashMap<String,Object> ();
	 	      Map <String,Object> dataChildNode=null;
    	      //如果是员工提交预约单，触发公众号推送
              if(type==1){
            	url="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+access_token;
            	String temp_id="ZfQubvedaUXvV94PmlDSUbgIeIrfhc2LCGAaAl99Q0w";
            	parm.put("touser", "opid");
                //	获取openId
            	
            	
            	parm.put("template_id", temp_id);
            	parm.put("url", "http://r.51towin.com/core/twechat.toReservationDetail.do?yid="+msg.get("yid"));
            	parm.put("topcolor", "#FF0000");
            	parm.put("access_token", access_token);//缓存起公众号的access_token给发起模板消息时候调用
            	dataChildNode=new HashMap<String,Object> ();
            	//String frist = URLEncoder.encode("亲，您于"+""+"提交了体检预约单",  "GBK");
            	String frist = "亲，您于"+(new Date()).toLocaleString()+"提交了体检预约单";
            	dataChildNode.put("value",frist );
            	dataChildNode.put("color", "#173177");
            	data.put("first", dataChildNode);
            	
            	dataChildNode=new HashMap<String,Object> ();
            	//String name = URLEncoder.encode((String)msg.get("name"), "GBK");
            	String name =(String)msg.get("name");
            	dataChildNode.put("value", name);
            	dataChildNode.put("color", "#173177");
            	data.put("keyword1", dataChildNode);
            	
            	dataChildNode=new HashMap<String,Object> ();
            	String product=((String)msg.get("productType")).equals("1")?"固定套餐":"自定义套餐"+"(地址:"+msg.get("address")+")";
            	//product = URLEncoder.encode(product,  "GBK");
            	dataChildNode.put("value", product);
            	dataChildNode.put("color", "#173177");
            	data.put("keyword2", dataChildNode);
            	
            	dataChildNode=new HashMap<String,Object> ();
            	//String orderTime = URLEncoder.encode((String)msg.get("orderTime"),  "GBK");
            	String orderTime = (String)msg.get("orderTime");
            	dataChildNode.put("value", orderTime);
            	dataChildNode.put("color", "#173177");
            	data.put("keyword3", dataChildNode);
            	
            	parm.put("data", data);
            //	String json=JSONObject.fromObject(parm).toString();
            	//logger.info("进入sendOfficiaAccountsMsg-> json="+json);
            	
            	//定义临时本地缓存，保存发送微信公众号的信息
            	//Map <String,Object> SYS_WX_TYPE=new HashMap<String,Object> ();
            	// cache_key=String.valueOf(System.currentTimeMillis());
            	//sys_wxmsg_type.put(cache_key, parm);
            	logger.info("进入sendOfficiaAccountsMsg 保存到cache的parm-> ="+parm+"@cache_key="+cache_key+"--openid="+(String)msg.get("openid"));
            	//requestOpenId(cache_key);
            	sendtempleMsg((String)msg.get("openid"),  parm);
              }
              return cache_key;
       }
       //支付发送公众号消息。
       public static void   sendOfficiaAccountsMsg(int type,Map <String,String> msg,String str) throws Exception{
    	   logger.info("进入重载sendOfficiaAccountsMsg");
    	   Map <String,Object> parm=new HashMap <String,Object> ();
    	   parm.put("orderTime", msg.get("date"));
    	   parm.put("name", msg.get("name"));
    	   parm.put("address", msg.get("address"));
    	   parm.put("productType", msg.get("PRODUCT_TYPE"));  
    	   parm.put("openid", msg.get("openid"));  
    	   logger.info("进入重载parm->="+parm);
    	   sendOfficiaAccountsMsg(1,parm);
    	   
       }
       //发送模板消息
       public static void sendtempleMsg(String openid,Map <String,Object>  parm){	   
    	      parm.put("touser", openid);
          	 String url="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+parm.get("access_token");
         	String json=JSONObject.fromObject(parm).toString();
          	logger.info("进入sendtempleMsg-> json="+json);
       	     try {
				new SysOfficeAccountSendMsg().httpPostWithJSON(url,json);
			} catch (Exception e) {
			
				e.printStackTrace();
			}
       }
    //调用微信获取access_token的接口，https 参数为xml类型，目前
   public static String sendHttpsPost(String url) throws Exception{		
			ScanPayBusiness s= new ScanPayBusiness();
			ResultListener r2=new ResultListenerImpl2();
			String  responseString =s.sendRevMsgMember(url,new ScanAddOrderReqData(), r2);
			logger.info("进入获取sendHttpsPost->responseString-> json="+responseString);
        	
	        return responseString;
   }
   
   public static void requestOpenId(String cacheKey) throws Exception{		
	   String str_url="";
		str_url="https://open.weixin.qq.com/connect/oauth2/authorize?";
		str_url+="appid=wx44a26b8a7ef26809&";
		str_url+="redirect_uri=http://r.51towin.com/core/payMent.wxSendMsgCallBack.do&";
		str_url+="response_type=code&";
		str_url+="scope=snsapi_base&";
		str_url+="state="+cacheKey;
		str_url+="#wechat_redirect";
		sendHttpsPost(str_url);

}
   public void init() { 
       try {
           SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
               //信任所有
               public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                   return true;
               }}).build();
           SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory( sslContext);
           httpClient =HttpClients.custom().setSSLSocketFactory(sslsf).build();
           hasInit = true;
       } catch (Exception e) {
           e.printStackTrace();
       }
     
   }

public  void httpPostWithJSON(String url, String json) throws Exception {
	logger.info("进入https httpPostWithJSON ->url="+url+" \n   json="+json);
    if (!hasInit) {
        init();
    }

       // 将JSON进行UTF-8编码,以便传输中文
	   String result = null;
	   String encoderJson = json;  
	  // encoderJson= URLDecoder.decode(json, "GBK");
       //String encoderJson = URLEncoder.encode(json, HTTP.UTF_8);      
       DefaultHttpClient httpClient = new DefaultHttpClient();
       HttpPost httpPost = new HttpPost(url);
      // httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);     
       StringEntity se = new StringEntity(encoderJson,"UTF-8");
       se.setContentType(CONTENT_TYPE_TEXT_JSON);
       se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
       logger.info("输出encoderJson ->="+encoderJson);
       httpPost.setEntity(se);
       HttpResponse response=  httpClient.execute(httpPost);
       HttpEntity entity = response.getEntity();

       result = EntityUtils.toString(entity, "UTF-8");
       logger.info("httpPostWithJSON 返回结果 : result:"+result);
   }
}
