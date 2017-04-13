package com.sgfm.datacenter.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sgfm.base.dao.BaseDao;

@Repository
public class CommonDao extends BaseDao {

	public int getTodayMsgCount(String date) {
		return (Integer) getSqlMapClientTemplate().queryForObject("CommonMap.getTodayMsgCount", date);
	}
	
}

	
	
		

