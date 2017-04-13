package com.sgfm.datacenter.service.twechat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sgfm.base.util.Pager;

import com.taobao.api.ApiException;

public interface TwechatService {
	/**
	 * 跳转到分院列表
	 * 
	 * @return
	 * @author 秦光耀
	 */
	public List<HashMap<String, Object>> findBrandchList(HashMap<String, Object> map);

	public HashMap<String, Object> getbrandchInfoByEsid(HashMap<String, Object> map);
	/**
	 * 获取套餐信息
	 * 
	 * @return
	 * @author 秦光耀
	 */
	public Map<String, Object> getProductInfo(Map<String, Object> params);

	public HashMap<String, Object> getBatchInfoById(String batchId);


	/**
	 * 查找会员预约单
	 * @return
	 * @author 秦光耀
	 */
	public List<HashMap<String, Object>> findReservationListByEmployeeId(HashMap<String, Object> map);
	/**
	 * 预约单详情
	 * @return
	 * @author 秦光耀
	 */
	public HashMap<String, Object> getReservationDetail(HashMap<String, Object> map);
	/**
	 * 取消订单、预约单
	 * @return
	 * @author 秦光耀
	 */
	public void canelReservation(String yid);

	/**
	 * 预约时间校验
	 * @param param
	 * @return
	 * @author 靖泽宽
	 */
	public Boolean checkOrderTime(HashMap<String,Object> param);

	/**
	 * 检查批次状态
	 * @param batchId
	 * @return
	 */
	public boolean checkBatchStatus(String batchId);

	public Map<String, String> getSendCodeParam(HashMap<String, Object> param);

	public void addMsgrecord(String id);
	/**
	 * 根据esid获取单项集合
	 * @return
	 * @author 秦光耀
	 */
	public Pager getSetMealInfoList(HashMap<String, Object> map);
	public void  addMemberOrder(HashMap<String, Object> param) throws ApiException ;

	public void sendMessage(HashMap<String, Object> param);

	public List<HashMap<String, Object>> checkReservation(HashMap<String, Object> map);
}
