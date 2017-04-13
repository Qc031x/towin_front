package com.sgfm.datacenter.action.payment;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sgfm.base.action.BaseAction;
import com.sgfm.base.util.PropsLoader;
import com.sgfm.datacenter.MsgConstant;
import com.sgfm.datacenter.entity.TEmployeeOrder;
import com.sgfm.datacenter.service.common.CommonService;
import com.sgfm.datacenter.service.login.LoginService;
import com.sgfm.datacenter.service.order.OrderService;
import com.sgfm.datacenter.service.twechat.TwechatService;
import com.sgfm.datacenter.wxsendmsg.SysOfficeAccountSendMsg;
import com.taobao.api.ApiException;
import com.tencent.WXPay;
import com.tencent.business.ScanPayBusiness.ResultListener;
import com.tencent.common.Configure;
import com.tencent.common.RandomStringGenerator;
import com.tencent.common.Signature;
import com.tencent.common.XMLParser;
import com.tencent.protocol.order.ResultListenerImpl2;
import com.tencent.protocol.order.ScanAddOrderReqData;

@Controller
@Scope("prototype")
public class payMentAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	private Log logger = LogFactory.getLog(this.getClass()); 
	
	private String payType = "";
	private static String indexUrl = "";
	
	@Autowired
    private PropsLoader propsLoader;
	@Autowired
	private TwechatService twechatservice;
	@Autowired
	private OrderService orderService;
	@Autowired
	private LoginService loginService;
	@Autowired
	private CommonService commonService;
	@PostConstruct
 	public void init() {
 		 payType = propsLoader.props.getProperty("tw.payType");
 		 indexUrl = propsLoader.props.getProperty("twMall.url");
 	}
	
	/**
	 * 微信授权回调
	 * @return
	 */
	public String wxAuthonCallBack(){
		HashMap<String,Object> res = new HashMap<String,Object>();
		
		try {
			String code=this.getRequest().getParameter("code");
	 		String state=this.getRequest().getParameter("state");
	 		logger.info("微信授权回调wxAuthonCallBack: wx1qaz0okm9ijn2wsxCallBack: beg"+(new Date()).toLocaleString());	
	 		
	 		logger.info("state=" + state); 
	 		logger.info("code=" + code);
			
			//通过code换取网页授权access_token(为了获取openid)
			StringBuffer wapurl = new StringBuffer("https://api.weixin.qq.com/sns/oauth2/access_token?");
			//https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
			wapurl.append("appid="+Configure.getAppid());
			wapurl.append("&secret=ce5575b427a386ce491e2549a515c4b0");
			wapurl.append("&code="+code);
			wapurl.append("&grant_type=authorization_code");
			logger.info("wapurl=" + wapurl);
			
			WXPay wapPost=new WXPay(); 
			ResultListener r2=new ResultListenerImpl2();
			//获取通过wapurl返回的json数据
			String json =wapPost.getWapToken(wapurl.toString(), new ScanAddOrderReqData(),r2);
			logger.info("====json=" + json); 
			
			JSONObject dataJson = JSONObject.fromObject(json);  
  	        String openid= (String)dataJson.get("openid");
  	        logger.info("====openid=" + openid);
  	        
  	        //通过调用微信的统一下单接口获取prepay_id(预支付交易会话标识)
  	        String args[] =getWxPrepayId(openid,state);
  	        logger.info(" args0="+args[0]+"  \n args[1] ="+args[1]);
			
			String timeStamp=String.valueOf(System.currentTimeMillis());
			res.put("appId", Configure.getAppid());
			res.put("timeStamp", timeStamp.substring(0,10));
			res.put("nonceStr",RandomStringGenerator.getRandomStringByLength(32));
			res.put("package","prepay_id="+args[0]);
			res.put("signType","MD5");
     		String sign = Signature.getSign(res);
     		res.put("sign",sign);
     		res.put("oid", state);
     		logger.info("====res=" + res);
     		
     		this.getRequest().setAttribute("data", res);
			
		} catch (Exception e) {
			logger.info(e.toString());
		}
		
		return super.toContentView("payment", "wx_wap_pay");
	}
	
	/**
	 * 通过调用微信的统一下单接口获取prepay_id(预支付交易会话标识)
	 * @param openid
	 * @param oid
	 * @return
	 */
	public String[] getWxPrepayId(String openid,String oid){
		   logger.info("获取getWxPrepayId  openid="+openid+" oid="+oid);
	 	   try {	
	 	   		TEmployeeOrder orderTemp = orderService.findOrderByOid(oid);
	 	   		logger.info("获取orderTemp"+orderTemp.toString());
	 	   		if(orderTemp==null || orderTemp.getOrderPay()<=0)return null;
	 	   		double priceint=orderTemp.getOrderPay();
	 	   		String price=String.valueOf(priceint);
	 			if(payType.equals("N"))
	 			   price = "0.01";//正式环境后需要屏蔽
	 			String xml=creatWxQrcode(oid,price,openid);
	 			Map<String,Object>xml_map=XMLParser.getMapFromXML(xml);
	 			String args[]=new String[2];
	 			args[0]=(String)xml_map.get("prepay_id");
	 			args[1]=(String)xml_map.get("sign");
	 		   return args;
	 		} catch (ParserConfigurationException e) {
	 			
	 			e.printStackTrace();
	 		} catch (IOException e) {
	 		
	 			e.printStackTrace();
	 		} catch (SAXException e) {
	 			
	 			e.printStackTrace();
	 		} 
	    
	 		return null;
	 		
	 	}
	
	/**
	 * 通过调用微信的统一下单接口获取prepay_id(预支付交易会话标识)
	 * @param oid
	 * @param price
	 * @param openid
	 * @return
	 */
	public String creatWxQrcode(String oid,String price,String openid){
   	 logger.info("获取 creatWxQrcode beg");
		 String post_xml="";
		 try {
			WXPay testWx=new WXPay();  
			 String appid = "";
			 String mch_id = "";       
			 String nonce_str = RandomStringGenerator.getRandomStringByLength(32);
			 String body = "天问订单";
			 String out_trade_no= ""+oid;
			 double total_fee =0;
			 String total_fee1="0";
			
			 if(price.equals("0.01")){
				 total_fee=1;
				 total_fee1="1";
			 }
			 else{			
				 total_fee = Double.parseDouble(price)*100;
				 BigDecimal   b   =   new   BigDecimal(total_fee);  
				 total_fee   =   b.setScale(0,   BigDecimal.ROUND_HALF_UP).doubleValue();  
				 
				 String s = String.valueOf(total_fee);
				 String newD = s.substring(0,s.indexOf("."));
				 total_fee1=newD;
			 }
			 
			 String spbill_create_ip = this.getRequest().getRemoteAddr();
			 String notify_url=indexUrl+"core/payMent.wx1QAZXSW2YKCallBack.do";

			 String trade_type  = "JSAPI";
   
			 ScanAddOrderReqData scanAddOrderReqData=new ScanAddOrderReqData( appid, mch_id, nonce_str, body, out_trade_no, total_fee1,
			  		 spbill_create_ip,  notify_url,  trade_type,openid);
			 ResultListener r2=new ResultListenerImpl2();
			 logger.info("获取 creatWxQrcode beg2");
			 post_xml=  testWx.doAddOrderBusiness(scanAddOrderReqData, r2);
			 logger.info("获取 creatWxQrcode beg3 :"+post_xml);
		} catch (Exception e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return post_xml;
	}
	
	/**
	 * 异步接收微信支付结果通知的回调地址
	 * @return
	 * @throws ApiException 
	 */
	public String wx1QAZXSW2YKCallBack() throws Exception  {
 		
 		logger.info("微信支付异步回调 beg%%%%:"+(new Date()).toLocaleString());
 		HttpServletRequest request= this.getRequest();
 		HttpServletResponse response= this.getResponse();
 		String result = "";	
 		 //示例报文
 		 // String xml = "<xml><appid><![CDATA[wxb4dc385f953b356e]]></appid><bank_type><![CDATA[CCB_CREDIT]]></bank_type><cash_fee><![CDATA[1]]></cash_fee><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[Y]]></is_subscribe><mch_id><![CDATA[1228442802]]></mch_id><nonce_str><![CDATA[1002477130]]></nonce_str><openid><![CDATA[o-HREuJzRr3moMvv990VdfnQ8x4k]]></openid><out_trade_no><![CDATA[1000000000051249]]></out_trade_no><result_code><![CDATA[SUCCESS]]></result_code><return_code><![CDATA[SUCCESS]]></return_code><sign><![CDATA[1269E03E43F2B8C388A414EDAE185CEE]]></sign><time_end><![CDATA[20150324100405]]></time_end><total_fee>1</total_fee><trade_type><![CDATA[JSAPI]]></trade_type><transaction_id><![CDATA[1009530574201503240036299496]]></transaction_id></xml>";
 		 String inputLine;
 		 String notityXml = "";
 		 String resXml = "";
 		try {
 		    while ((inputLine = request.getReader().readLine()) != null) {
	 		       notityXml += inputLine;
	 		 }
 		     request.getReader().close();
 		 } catch (Exception e) {
	 		 e.printStackTrace();
	 		 logger.info("微信支付回调 异常:"+(new Date()).toLocaleString());
 		 }
 		 

 		 logger.info("微信支付回调接收到的报文:"+(new Date()).toLocaleString()+"  "+notityXml);

 		 Map m = parseXmlToList2(notityXml);
 		// WxPayResult wpr = new WxPayResult();
 		// wpr.setAppid(m.get("appid").toString());
 		String return_code= m.get("return_code").toString();
 		String oid= m.get("out_trade_no").toString();
 		String openid = m.get("openid").toString();
 		double total_fee = Double.valueOf(m.get("total_fee").toString());
 		logger.info("微信支付return_code报文:"+(new Date()).toLocaleString()+"  "+return_code);
 		logger.info("微信支付out_trade_no报文:"+oid);
 		logger.info("微信支付openid报文:"+openid);
 		logger.info("微信支付total_fee报文:"+total_fee);
 		if("SUCCESS".equals(return_code)){
 			
 			TEmployeeOrder temployeeOrder = new TEmployeeOrder();
 			temployeeOrder.setOid(oid);
 			temployeeOrder.setPayType(1);
 			temployeeOrder.setPayUser(openid);
 			temployeeOrder.setTotalPay(total_fee/100);
 			
 			//修改订单状态
 			orderService.updateOrder(temployeeOrder);
 			
 			//发送短信
 			HashMap<String, Object> reservation=orderService.getReservationByOid(oid);
 			System.out.println("-----------------------///"+reservation.get("EMPOYEE_ID")+"//---------------------");
 			reservation.put("employeeId", reservation.get("EMPOYEE_ID").toString());
 			Map<String, String> sendMap=twechatservice.getSendCodeParam(reservation);
 			final Map<String, String> params=new HashMap<String, String>();
			params.put("name", sendMap.get("NAME").toString());
			params.put("date", reservation.get("ORDER_TIME").toString());
			params.put("PRODUCT_TYPE", reservation.get("PRODUCT_TYPE").toString());
			String address=loginService.getAddressByEsid(reservation.get("ESID").toString());
			params.put("address", address);
			params.put("openid", openid);	
			commonService.sendMessage(params, MsgConstant.TMPL_RESERVATION_NOTIFY, sendMap.get("MOBILE").toString());
			twechatservice.addMsgrecord(reservation.get("EMPOYEE_ID").toString());
		    new Thread(){  
            		    public void run() {  
            		    	 try {
            		    		 logger.info("进入付款成功发送公众号模板 begin");
								SysOfficeAccountSendMsg.sendOfficiaAccountsMsg(1, params,"");
								logger.info("进入付款成功发送公众号模板 end");
							} catch (Exception e) {
							
								e.printStackTrace();
							}
            		    };  
		            	}.start();  
		
	
			this.setToSession("isReservation", "1");
	 		 //支付成功
	 		resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"+ "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
 		 }
 		else{
 		 resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
 		 + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
 		 }
 		logger.info("微信支付回调数据结束");
 		
 		 try {
 			//通知微信支付成功
 			BufferedOutputStream out3 = new BufferedOutputStream(response.getOutputStream());
 			logger.info("微信支付resXml.getBytes()报文:"+resXml.getBytes());
 			out3.write(resXml.getBytes());
 			 out3.flush();
 			 out3.close();
 		} catch (IOException e) {
 		
 			e.printStackTrace();
 		}
 		return resXml;
 	}
	
	private Map parseXmlToList2(String xml) {
     	logger.info("微信支付解析xml参数: parseXmlToList2: beg"+(new Date()).toLocaleString());
     	 Map retMap = new HashMap();
     	 try {
	     	 StringReader read = new StringReader(xml);
	     	 // 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
	     	InputSource source = new InputSource(read);
	     	 // 创建一个新的SAXBuilder
	     	 SAXBuilder sb = new SAXBuilder();
	     	 // 通过输入源构造一个Document
	     	 org.jdom.Document doc =  sb.build(source);
	     	 Element root = (Element) doc.getRootElement();// 指向根节点
	     	List<Element> es = root.getChildren();
	     	 if (es != null && es.size() != 0) {
		     	 for (Element element : es) {
		     	 retMap.put(element.getName(), element.getValue());
		     	 }
	     	 }
     	 } catch (Exception e) {
     		 e.printStackTrace();
     	 }
	     	 logger.info("微信支付解析xml参数: parseXmlToList2: end"+(new Date()).toLocaleString());
	     	 return retMap;
     }
	
	/**
	 * 跳转到支付成功页面
	 * @return
	 * @author 康良玉
	 */
	public String paySuccess(){
		try {
			this.setToSession("isReservation", "1");
			String oid = super.getRequest().getParameter("oid");
			HashMap<String, Object> order = orderService.findPaySuccessInfoByOid(oid);
			super.getRequest().setAttribute("order", order);
		} catch (Exception e) {
			this.logger.error(e);
		}
		return super.toContentView("payment", "pay_success");
	}
    //微信回调的获取粉丝的openId，粉丝预约后，推送公众号消息给粉丝
	public String wxSendMsgCallBack(){
		HashMap<String,Object> res = new HashMap<String,Object>();
		
		try {
			String code=this.getRequest().getParameter("code");
	 		String state=this.getRequest().getParameter("state");
	 		logger.info("微信授权回调wxSendMsgCallBackbeg"+(new Date()).toLocaleString());	
	 		
	 		logger.info("wxSendMsgCallBack state@cache_key=" + state); 
	 		logger.info("wxSendMsgCallBack code=" + code);
			
			//通过code换取网页授权access_token(为了获取openid)
			StringBuffer wapurl = new StringBuffer("https://api.weixin.qq.com/sns/oauth2/access_token?");		
			wapurl.append("appid="+Configure.getAppid());
			wapurl.append("&secret=ce5575b427a386ce491e2549a515c4b0");
			wapurl.append("&code="+code);
			wapurl.append("&grant_type=authorization_code");
			logger.info("wapurl=" + wapurl);
			
			WXPay wapPost=new WXPay(); 
			ResultListener r2=new ResultListenerImpl2();
			//获取通过wapurl返回的json数据
			String json =wapPost.getWapToken(wapurl.toString(), new ScanAddOrderReqData(),r2);
			logger.info("wxSendMsgCallBack获取OpenId====json=" + json); 
			
			JSONObject dataJson = JSONObject.fromObject(json);  
  	        String openid= (String)dataJson.get("openid");
  	        logger.info("wxSendMsgCallBack====openid=" + openid);
  	         HashMap <String,Object> data=(HashMap <String,Object>)SysOfficeAccountSendMsg.sys_wxmsg_type.get(state);
  	         data.put("touser", openid);
  	        json=JSONObject.fromObject(data).toString();
         	logger.info("进入wxSendMsgCallBack-> json="+json);
         	String url="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+data.get("access_token");
         	new SysOfficeAccountSendMsg().httpPostWithJSON(url,json);
		} catch (Exception e) {
			logger.info(e.toString());
		}
		
		return super.toContentView("twechat", "revSuccess");
	}
}
