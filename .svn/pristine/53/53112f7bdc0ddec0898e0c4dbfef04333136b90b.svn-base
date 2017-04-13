package com.sgfm.datacenter.service.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sgfm.datacenter.entity.SOrder;
import com.sgfm.datacenter.entity.SReservation;
import com.sgfm.datacenter.entity.TEmployeeOrder;

public interface OrderService {
	
	/**
	 * 通过订单号获取订单信息
	 * @param oid
	 * @return
	 * @author 康良玉
	 */
	public TEmployeeOrder findOrderByOid(String oid);
	
	/**
	 * 修改订单状态
	 * @param orderMap
	 * @author 康良玉
	 */
	public void updateOrder(TEmployeeOrder temployeeOrder);
	
	/**
	 * 通过oid获取支付成功页面显示的订单信息
	 * @param oid
	 * @return
	 * @author 康良玉
	 */
	public HashMap<String,Object> findPaySuccessInfoByOid(String oid);

	public HashMap<String, Object> getReservationByOid(String oid);
	
	/**
	 * 通过订单号获取订单信息
	 * @param oid
	 * @return
	 * @author 康良玉
	 */
	public SOrder findMallOrderByOid(String oid);
	
	/**
	 * 通过订单号获取订单信息
	 * @param oid
	 * @return
	 * @author 康良玉
	 */
	public void updateMallOrder(SOrder sorder);

	public void sendMessage(String oid,String openid);

}
