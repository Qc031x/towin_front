package com.sgfm.datacenter.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sgfm.base.dao.BaseDao;
import com.sgfm.datacenter.entity.TAutoStrategy;
import com.sgfm.datacenter.entity.THolidayStrategy;
import com.sgfm.datacenter.entity.TPlaydayStrategy;
import com.sgfm.datacenter.entity.TSigndayStrategy;

@SuppressWarnings("unchecked")
@Repository
public class CalDao extends BaseDao {
	
	/**
	 * 得到默认策略
	 * @param esid
	 * @return
	 * @author 康良玉
	 */
	public HashMap<String, Object> findDefaultPolicy(String esid) {
		return (HashMap<String, Object>) super.getSqlMapClientTemplate().queryForObject("CalMap.findDefaultPolicy", esid);
	}

	/**
	 * 得到休息策略 
	 * @param esid
	 * @return
	 * @author 康良玉
	 */
	public HashMap<String, Object> findRestPolicy(String esid) {
		return (HashMap<String, Object>) super.getSqlMapClientTemplate().queryForObject("CalMap.findRestPolicy", esid);
	}

	/**
	 * 得到假日策略
	 * @param esid
	 * @return
	 * @author 康良玉
	 */
	public List<HashMap<String, Object>> findHolidayPolicy(String esid) {
		return super.getSqlMapClientTemplate().queryForList("CalMap.findHolidayPolicy", esid);
	}

	/**
	 * 得到单日策略
	 * @param esid
	 * @return
	 * @author 康良玉
	 */
	public HashMap<String, Object> findDayPolicy(HashMap<String, Object> map) {
		return (HashMap<String, Object>) super.getSqlMapClientTemplate().queryForObject("CalMap.findDayPolicy", map);
	}
	
	
	/**
     * 查询门店的默认策略。<br>
     */
    public TAutoStrategy getAutoStgByEsidAndDate(String esid)
    {
        return (TAutoStrategy)super.getSqlMapClientTemplate().queryForObject("CalMap.getAutoStgByEsidAndDate",esid);
    }
    public List<Map<String,Object>> getReservationByEcd(Map<String,Object> map)
    {
        return (List<Map<String,Object>>)super.getSqlMapClientTemplate().queryForList("CalMap.getReservationByEcd",map);
    }
    
    public TPlaydayStrategy  getPlayStgByEsid(String esid)
    {
        return (TPlaydayStrategy)super.getSqlMapClientTemplate().queryForObject("CalMap.getPlayStgByEsid", esid);
    }
    public List<THolidayStrategy>  getHolidStgByEsid(Map<String,Object> map)
    {
        return (List<THolidayStrategy>)super.getSqlMapClientTemplate().queryForList("CalMap.getHolidStgByEsid",  map);
    }
    
    
    public List< TSigndayStrategy>  getSignStgByEsid(Map<String,Object> map)
    {
        return (List< TSigndayStrategy>)super.getSqlMapClientTemplate().queryForList("CalMap.getSignStgByEsid",  map);
    }
    public Integer  getRevCountByEsid(Map<String,Object> map)
    {
        return (Integer)super.getSqlMapClientTemplate().queryForObject("CalMap.getRevCountByEsid",  map);
    }
    
    public String findSingleDateCount(Map<String, Object> map){
		return (String) super.getSqlMapClientTemplate().queryForObject("CalMap.findSingleDateCount", map);
	}
  
    
    public List<HashMap<String, Object>> checkOrderTimePlayDay(HashMap<String,Object> param) {
		return super.getSqlMapClientTemplate().queryForList("CalMap.checkOrderTimePlayDay", param);
	}
    
    public List<HashMap<String, Object>> checkOrderTimeHoliday(HashMap<String,Object> param) {
		return super.getSqlMapClientTemplate().queryForList("CalMap.checkOrderTimeHoliday", param);
	}
    
    public List<HashMap<String, Object>> checkOrderTimeSignday(HashMap<String,Object> param) {
		return super.getSqlMapClientTemplate().queryForList("CalMap.checkOrderTimeSignday", param);
	}
    
}
