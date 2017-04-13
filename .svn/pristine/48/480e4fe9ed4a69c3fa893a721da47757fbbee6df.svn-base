package com.sgfm.datacenter.service.order.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgfm.datacenter.MsgConstant;
import com.sgfm.datacenter.dao.OrderDao;
import com.sgfm.datacenter.entity.SOrder;
import com.sgfm.datacenter.entity.SReservation;
import com.sgfm.datacenter.entity.TEmployeeOrder;
import com.sgfm.datacenter.service.common.CommonService;
import com.sgfm.datacenter.service.order.OrderService;
import com.taobao.api.ApiException;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private CommonService commonService;

	private Log logger = LogFactory.getLog(this.getClass()); 
	
	/**
	 * 通过订单号获取订单信息
	 * @param oid
	 * @return
	 * @author 康良玉
	 */
	
	public TEmployeeOrder findOrderByOid(String oid) {
		return orderDao.findOrderByOid(oid);
	}

	/**
	 * 修改订单状态
	 * @param orderMap
	 * @author 康良玉
	 */
	
	public void updateOrder(TEmployeeOrder temployeeOrder) {
		logger.info("修改订单状态 beg：");
		String oid = temployeeOrder.getOid();
		
		TEmployeeOrder temployeeOrder2 = orderDao.findOrderByOid(oid);
		logger.info("订单信息："+temployeeOrder2.toString());
		
		if(temployeeOrder2.getPayStatus()!=2){
			temployeeOrder.setPayStatus(2);
			logger.info("修改信息："+temployeeOrder.toString());
			orderDao.updateOrder(temployeeOrder);
			orderDao.updateReservation(temployeeOrder.getOid());
			logger.info("修改订单状态 end：");
		}
		
	}

	/**
	 * 通过oid获取支付成功页面显示的订单信息
	 * @param oid
	 * @return
	 * @author 康良玉
	 */

	public HashMap<String, Object> findPaySuccessInfoByOid(String oid) {
		return orderDao.findPaySuccessInfoByOid(oid);
	}

	public HashMap<String, Object> getReservationByOid(String oid) {
		return orderDao.getReservationByOid(oid);
	}

	/**
	 * 通过订单号获取订单信息
	 * @param oid
	 * @return
	 * @author 康良玉
	 */
	public SOrder findMallOrderByOid(String oid) {
		return orderDao.findMallOrderByOid(oid);
	}
	
	/**
	 * 修改订单状态
	 * @param orderMap
	 * @author 康良玉
	 */
	
	public void updateMallOrder(SOrder sorder) {
		logger.info("修改订单状态 beg：");
		String oid = sorder.getOid();
		
		SOrder sorder2 = orderDao.findMallOrderByOid(oid);
		logger.info("订单信息："+sorder2.toString());
		
		if(sorder2.getPayStatus()!=2){
			sorder.setPayStatus(2);
			logger.info("修改信息："+sorder.toString());
			orderDao.updateMallOrder(sorder);
			logger.info("修改订单状态 end：");
		}
		
	}


	public void sendMessage(String oid,String openid) {
		logger.info("----------------------进入推送消息方法sendMessage--------------------");
		HashMap<String, Object> loginUser=orderDao.getLoginUserByOpenid(openid);
		List<HashMap<String, Object>> srList=orderDao.getSReservationByOid(oid);
		Map<String, String> param=new HashMap<String, String>();
		String wxName="";
		if(srList.size()>0 && srList.get(0).get("ORDER_TYPE").toString().equals("2")){
			String address=orderDao.getAddressByEsidNoProvince(srList.get(0).get("ESID").toString());
			//若预约单存在预约信息且订单类型为在线支付预约，则断定此次支付是在线预约支付
			for(int i=0;i<srList.size();i++){
				if(srList.get(i).get("R_TYPE").toString().equals("2")){
					//在线支付预约
						String se="先生";
						if(srList.get(i).get("RE_SEX").toString().equals("1")){
							se="女士";
						}
						wxName+=srList.get(i).get("RE_NAME").toString()+se+",";
						param.put("name", srList.get(i).get("RE_NAME").toString()+se);
						param.put("date", srList.get(i).get("CREATER_TIME").toString());
						param.put("address", address);
					try {
						logger.info("在线预约支付成功，正在发送短信...");
						commonService.sendMessage(param, MsgConstant.TMPL_RESERVATION_NOTIFY, srList.get(i).get("RE_TEL").toString());
						logger.info("在线预约支付成功，发送短信成功！");
						//往短信记录表插入发送短信 记录
						HashMap<String, Object> addmsgMap=new HashMap<String, Object>();
						addmsgMap.put("type", "6");
						addmsgMap.put("mobile", srList.get(i).get("RE_TEL").toString());
						addmsgMap.put("user", loginUser.get("MID").toString());
						orderDao.addMsgrecord(addmsgMap);
					} catch (ApiException e) {
						e.printStackTrace();
					}
					
				}
			 }
			//微信推送消息
			Map<String, String> wxMap=new HashMap<String, String>();
			if(wxName.length()>0){
				wxName= wxName.substring(0,wxName.length()-1);
			}
			wxMap.put("uname", wxName);
			wxMap.put("pname", srList.get(0).get("P_NAME").toString());
			wxMap.put("address", address);
			wxMap.put("orderTime", srList.get(0).get("CREATER_TIME").toString());
			wxMap.put("openId",openid);
			commonService.sendWechatTemplate(wxMap); 
			
			}else{
				logger.info("----------------------进入购买体检卡方法--------------------");
				//若预约单不存在预约信息，则断定此次支付是购买体检卡支付
				List<HashMap<String,Object>> orderCards=orderDao.findOrderCardList(oid);
				param.put("num", orderCards.size()+"");
				param.put("name", orderCards.get(0).get("NAME").toString());
				String wxCardStr="";
				if(orderCards.size()>0 && orderCards.get(0).get("ORDER_TYPE").toString().equals("1")){
					//虚拟卡
					String cardStr="";
					for(int i=0;i<orderCards.size();i++){
						cardStr+="卡号"+(i+1)+":"+orderCards.get(i).get("CARD_NUMBER").toString()+",";
						cardStr+="密码:"+orderCards.get(i).get("PASSWORD").toString()+";";
						
						wxCardStr +="卡号"+(i+1)+":"+orderCards.get(i).get("CARD_NUMBER").toString()+",";
						wxCardStr+="密码:"+orderCards.get(i).get("PASSWORD").toString()+";\n";
					}
					if(cardStr.length()>0){
						cardStr=cardStr.substring(0,cardStr.length()-1);
					}
					param.put("cardinfo", cardStr);
					try {
						logger.info("购买体检虚拟卡支付成功，正在发送短信...");
						commonService.sendMessage(param, MsgConstant.TMPL_BUYXCARD_SUCCESS, loginUser.get("MOBILE").toString());
						logger.info("购买体检虚拟卡支付成功，发送短信成功");
						HashMap<String, Object> addmsgMap=new HashMap<String, Object>();
						addmsgMap.put("type", "4");
						addmsgMap.put("mobile", loginUser.get("MOBILE").toString());
						addmsgMap.put("user", loginUser.get("MID").toString());
						orderDao.addMsgrecord(addmsgMap);
					} catch (ApiException e) {
						e.printStackTrace();
					}
				}else{
					//实体卡
					try {
						logger.info("购买体检实体卡支付成功，正在发送短信...");
						commonService.sendMessage(param, MsgConstant.TMPL_BUYSCARD_SUCCESS, orderCards.get(0).get("MOBILE").toString());
						logger.info("购买体检实体卡支付成功，发送短信成功！");
						HashMap<String, Object> addmsgMap=new HashMap<String, Object>();
						addmsgMap.put("type", "5");
						addmsgMap.put("mobile", orderCards.get(0).get("MOBILE").toString());
						addmsgMap.put("user", loginUser.get("MID").toString());
						orderDao.addMsgrecord(addmsgMap);
					} catch (ApiException e) {
						e.printStackTrace();
					}
					
				}
				logger.info("购买体检卡后发送微信模板消息开始...");
				HashMap<String, Object> orderInfo=orderDao.findMallOrderInfoForWXByOid(oid);
				Map<String, String> wxMap=new HashMap<String, String>();
				if(wxName.length()>0){
					wxName= wxName.substring(0,wxName.length()-1);
				}
				wxMap.put("oid", oid);
				wxMap.put("wxCardStr", wxCardStr);
				wxMap.put("pname", orderInfo.get("NAME").toString());
				wxMap.put("buysum", orderInfo.get("BUYSUM").toString());
				wxMap.put("orderPrice", orderInfo.get("SUM_PRICE").toString());
				wxMap.put("openId",openid);
				logger.info("微信模板消息所带的参数："+JSONObject.fromObject(wxMap));
				commonService.sendWechatPayTemplate(wxMap);
				logger.info("购买体检卡后发送微信模板消息成功！！...");
			}
		
		
	}
}
