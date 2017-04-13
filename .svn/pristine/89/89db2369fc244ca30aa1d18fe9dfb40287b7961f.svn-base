package com.sgfm.datacenter.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.sgfm.base.dao.BaseDao;

@Repository
public class TwechatDao extends BaseDao {
	public List<HashMap<String, Object>> findBrandchList(HashMap<String, Object> map) {
		return super.getSqlMapClientTemplate().queryForList("TwechatMap.findBrandchList",map);
	}

	public HashMap<String, Object> getbrandchInfoByEsid(HashMap<String, Object> map) {
		return (HashMap<String, Object>) super.getSqlMapClientTemplate().queryForObject("TwechatMap.getbrandchInfoByEsid",map);
	}

	public List<HashMap<String, Object>> findBrandchImgByEsid(String esid) {
		return super.getSqlMapClientTemplate().queryForList("TwechatMap.findBrandchImgByEsid",esid);
	}

	public List<HashMap<String, Object>> getProductId(Map<String, Object> params) {
		return super.getSqlMapClientTemplate().queryForList("TwechatMap.getProductId",params);
	}

	public List<HashMap<String, Object>> getDiyProductId(Map<String, Object> params) {
		return  super.getSqlMapClientTemplate().queryForList("TwechatMap.getDiyProductId",params);
	}

	public List<HashMap<String, Object>> getSetmealInfoByPid(String productId) {
		return  super.getSqlMapClientTemplate().queryForList("TwechatMap.getSetmealInfoByPid",productId);
	}

	public List<HashMap<String, Object>>  getDiySetmealInfoByPid(String diyProductId) {
		return super.getSqlMapClientTemplate().queryForList("TwechatMap.getDiySetmealInfoByPid",diyProductId);
	}

	public List<Map<String, Object>> getDiyProductPackages(String diyProductId) {
		return super.getSqlMapClientTemplate().queryForList("TwechatMap.getDiyProductPackages",diyProductId);
	}

	public HashMap<String, Object> getProductDetail(String pid) {
		return (HashMap<String, Object>) super.getSqlMapClientTemplate().queryForObject("TwechatMap.getProductDetail",pid);
	}

	public HashMap<String, Object> getDiyProductDetail(String pid) {
		return (HashMap<String, Object>) super.getSqlMapClientTemplate().queryForObject("TwechatMap.getDiyProductDetail",pid);
	}

	public HashMap<String, Object> getBatchRoleByEmployee(
			Map<String, Object> params) {
		return (HashMap<String, Object>) super.getSqlMapClientTemplate().queryForObject("TwechatMap.getBatchRoleByEmployee",params);
	}

	public HashMap<String, Object> getBatchInfoById(String batchId) {
		return (HashMap<String, Object>) super.getSqlMapClientTemplate().queryForObject("TwechatMap.getBatchInfoById",batchId);
	}
	/**
	 * 创建订单
	 * @return
	 * @author 秦光耀
	 */
	public void createEmployeeOrder(HashMap<String, Object> param) {
		super.getSqlMapClientTemplate().insert("TwechatMap.createEmployeeOrder",param);
	}
	/**
	 * 创建预约单
	 * @return
	 * @author 秦光耀
	 */
	public int createEmployeeYY(HashMap<String, Object> param) {
		return  (Integer) super.getSqlMapClientTemplate().insert("TwechatMap.createEmployeeYY",param);
	}
	/**
	 * 查找会员预约单
	 * @return
	 * @author 秦光耀
	 */
	public List<HashMap<String, Object>> findReservationListByEmployeeId(
			HashMap<String, Object> map) {
		return super.getSqlMapClientTemplate().queryForList("TwechatMap.findReservationListByEmployeeId",map);
	}

	public HashMap<String, Object> getReservationDetail(HashMap<String, Object> map) {
		return (HashMap<String, Object>) super.getSqlMapClientTemplate().queryForObject("TwechatMap.getReservationDetail",map);
	}

	public void updateEmployeeYY(HashMap<String, Object> param) {
		super.getSqlMapClientTemplate().insert("TwechatMap.updateEmployeeYY",param);
	}

	public void updateEmployeeOrder(HashMap<String, Object> param) {
		super.getSqlMapClientTemplate().insert("TwechatMap.updateEmployeeOrder",param);
	}

	public void canelReservation(String yid) {
		super.getSqlMapClientTemplate().update("TwechatMap.canelReservation",yid);
	}

	public void canelOrderByOid(String yid) {
		super.getSqlMapClientTemplate().update("TwechatMap.canelOrderByOid",yid);
	}

	public int checkBatchStatus(String batchId) {
		return (Integer)getSqlMapClientTemplate().queryForObject("TwechatMap.checkBatchStatus", batchId);
	}

	public Map<String, String> getSendCodeParam(HashMap<String, Object> param) {
		return (Map<String, String>) super.getSqlMapClientTemplate().queryForObject("TwechatMap.getSendCodeParam",param);
	}

	public void addMsgrecord(String id) {
		super.getSqlMapClientTemplate().insert("TwechatMap.addMsgrecord",id);
	}

	public int getSetMealInfoListCount(HashMap<String, Object> map) {
		return (Integer) super.getSqlMapClientTemplate().queryForObject("TwechatMap.getSetMealInfoListCount",map);
	}

	public List<HashMap<String, Object>> getSetMealInfoList(HashMap<String, Object> map) {
		return super.getSqlMapClientTemplate().queryForList("TwechatMap.getSetMealInfoList",map);
	}

	public void addEmployeeSetMeal(final HashMap<String, Object> param) {
		String sids=param.get("setmealIds").toString();
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=sf.format(new Date());
		param.put("createTime", time);
		final String[] sidList=sids.split(",");
		getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
				
				public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
					executor.startBatch();
					for (int i = 0; i < sidList.length; i++) {
						param.put("sid", sidList[i]);
						executor.insert("TwechatMap.addEmployeeSetMeal", param);
					}
					return executor.executeBatch();
				}
				
			});
	}

	public List<HashMap<String, Object>> findSetMealListByYid(String yid) {
		return super.getSqlMapClientTemplate().queryForList("TwechatMap.findSetMealListByYid",yid);
	}

	public List<HashMap<String, Object>> checkReservation(HashMap<String, Object> map) {
		return super.getSqlMapClientTemplate().queryForList("TwechatMap.checkReservation",map);
	}
	
}
