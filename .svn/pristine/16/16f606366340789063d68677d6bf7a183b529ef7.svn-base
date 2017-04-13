package com.sgfm.datacenter.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sgfm.base.dao.BaseDao;

@Repository
public class EmployeeDao extends BaseDao {
	/**
	 * 根据员工登录 的名字， 身份证号码 或手机，获取当前员工的批次集合
	 * @author cliu
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String ,Object>> getBatchListByEmployeeId(HashMap<String, Object> param) {
		return super.getSqlMapClientTemplate().queryForList("EmployeeMap.getBatchListByEmployeeId",param);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getEmployeeInfo(HashMap<String, String> params) {
		return (Map<String, Object>) getSqlMapClientTemplate().queryForObject("EmployeeMap.getEmployeeInfo", params);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getCheckupBatchInfo(Map<String, Object> employee) {
		return getSqlMapClientTemplate().queryForList("EmployeeMap.getCheckupBatchInfo", employee);
	}
	
	/**
	 * 校验员工是否有预约单
	 * @param param
	 * @return
	 */
	public List<Map<String,Object>> checkEmployeeReservation(HashMap<String, String> param){
		return super.getSqlMapClientTemplate().queryForList("EmployeeMap.checkEmployeeReservation",param);
	}
	/**
	 * 根据esid获取详细地址
	 * @param param
	 * @return
	 * @author 秦光耀
	 */
	public String getAddressByEsid(String esid) {
		return (String) super.getSqlMapClientTemplate().queryForObject("EmployeeMap.getAddressByEsid",esid);
	}
	
}
