package com.sgfm.datacenter.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sgfm.base.dao.BaseDao;
import com.sgfm.datacenter.entity.SOrder;
import com.sgfm.datacenter.entity.SReservation;
import com.sgfm.datacenter.entity.TEmployeeOrder;

@SuppressWarnings("unchecked")
@Repository
public class OrderDao extends BaseDao{

	/**
	 * 通过订单号获取订单信息
	 * @param oid
	 * @return
	 * @author 康良玉
	 */
	public TEmployeeOrder findOrderByOid(String oid){
		return (TEmployeeOrder)super.getSqlMapClientTemplate().queryForObject("OrderMap.findOrderByOid",oid);
	}
	
	/**
	 * 修改订单状态
	 * @param temployeeOrder
	 * @author 康良玉
	 */
	public void updateOrder(TEmployeeOrder temployeeOrder){
		super.getSqlMapClientTemplate().update("OrderMap.updateOrder",temployeeOrder);
	}
	
	/**
	 * 通过oid获取支付成功页面显示的订单信息
	 * @param oid
	 * @return
	 * @author 康良玉
	 */
	public HashMap<String,Object> findPaySuccessInfoByOid(String oid){
		return (HashMap<String, Object>) super.getSqlMapClientTemplate().queryForObject("OrderMap.findPaySuccessInfoByOid",oid);
	}
	/**
	 * 修改预约单状态
	 * @param oid
	 * @return
	 * @author 秦光耀
	 */
	public void updateReservation(String oid) {
		super.getSqlMapClientTemplate().update("OrderMap.updateReservation",oid);
	}

	public HashMap<String, Object> getReservationByOid(String oid) {
		return (HashMap<String, Object>) super.getSqlMapClientTemplate().queryForObject("OrderMap.getReservationByOid",oid);
	}
	
	/**
	 * 通过订单号获取订单信息
	 * @param oid
	 * @return
	 * @author 康良玉
	 */
	public SOrder findMallOrderByOid(String oid) {
		return (SOrder) super.getSqlMapClientTemplate().queryForObject("OrderMap.findMallOrderByOid", oid);
	}
	
	/**
	 * 修改订单状态
	 * @param temployeeOrder
	 * @author 康良玉
	 */
	public void updateMallOrder(SOrder sorder){
		super.getSqlMapClientTemplate().update("OrderMap.updateMallOrder",sorder);
	}

	public List<HashMap<String, Object>> getSReservationByOid(String oid) {
		return super.getSqlMapClientTemplate().queryForList("OrderMap.getSReservationByOid",oid);
	}

	public String getAddressByEsidNoProvince(String esid) {
		return (String) super.getSqlMapClientTemplate().queryForObject("OrderMap.getAddressByEsidNoProvince",esid);
	}

	public List<HashMap<String, Object>> findOrderCardList(String oid) {
		return super.getSqlMapClientTemplate().queryForList("OrderMap.findOrderCardList",oid);
	}

	public HashMap<String, Object> getLoginUserByOpenid(String openid) {
		return (HashMap<String, Object>) super.getSqlMapClientTemplate().queryForObject("OrderMap.getLoginUserByOpenid",openid);
	}

	public void addMsgrecord(HashMap<String, Object> addmsgMap) {
		super.getSqlMapClientTemplate().insert("OrderMap.addMsgrecord",addmsgMap);
	}

	public HashMap<String, Object> findMallOrderInfoForWXByOid(String oid) {
		return (HashMap<String, Object>) super.getSqlMapClientTemplate().queryForObject("OrderMap.findMallOrderInfoForWXByOid",oid);
	}
}
