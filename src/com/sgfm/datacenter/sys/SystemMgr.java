package com.sgfm.datacenter.sys;

import java.util.Timer;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.sgfm.datacenter.service.common.CommonService;
import com.sgfm.datacenter.service.common.impl.CommonServiceImpl;
import com.sgfm.datacenter.util.AppContext;

@Component
public class SystemMgr {
	private static Logger logger = Logger.getLogger(SystemMgr.class.getName());
	private Timer TimerUtil;
	private final static long OverdueOrderClear = 1000 * 60 * 60 * 24;
    private static int i=0;

    @Autowired
    private CommonService commonService;
    
	//@Autowired
	//private MemcachedManager mc;

	@PostConstruct
	public void init() {
//		if(i==0){
//			new Thread() {
//				@Override
//				public void run() {
//					try{
//						i++;
//						Thread.sleep(6*1000);
//		            		
//					}catch (Exception e) {
//						logger.error(e.getMessage(), e);
//					}
//					logger.info("预约平台wap初始化服务开始");
//					CommHashMap cm = new CommHashMap();   //用来实例化CommHashMap的构造函数，给静态的对象赋予托管对象
//					MemcachedManager mc=new MemcachedManager();
//					mc.init();
//					LuceneData.createProductIndex();
//					LuceneData.createStoreIndex();
//					logger.info("预约平台wap初始化服务结束");
//				}
//			}.start();
//		}
		//commonService.doDropTable();
	}

}
