package com.sgfm.datacenter.service.login;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface LoginService {
	
	public HashMap<String,Object> doMemberLogin(Map<String,String> reqParm);

	public Map<String, Object> getCheckupInfo(HashMap<String, String> params);
	
	/**
	 * 校验员工是否有预约单
	 * @param param
	 * @return
	 */
	public List<Map<String,Object>> checkEmployeeReservation(HashMap<String, String> param);

	/**
	 * 根据esid获取详细地址
	 * @param param
	 * @return
	 * @author 秦光耀
	 */
	public String getAddressByEsid(String string);
	
	public List<HashMap<String, Object>> findValidCity();
}
