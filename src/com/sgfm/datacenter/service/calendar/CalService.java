package com.sgfm.datacenter.service.calendar;

import java.util.HashMap;
import java.util.Map;

public interface CalService {
		
	/**
	 * 获取单日策略
	 * @param map
	 * @return
	 * @author 康良玉
	 */
	public Map<String, Object> findDayPolicy(HashMap<String, Object> map);
	
	
	/**
	 * 根据esid，date获取预约日历
	 * @param esid
	 * @param date
	 * @return
	 * @author 康良玉
	 */
	public Map<String ,String[]> getRiDataByEsid(String esid,String date);
}
