package com.sgfm.datacenter.timer;

import java.util.TimerTask;

import org.springframework.stereotype.Component;
@Component
/*public class ContractTimer extends TimerTask {*/
public class ContractTimer {
   /* private static final Logger log = Logger.getLogger(ContractTimer.class);
    @Autowired
    private PropsLoader propsLoader;
    @Autowired
    OegpClient oegpClient;
    @Autowired
    private ContractService contractService;
    private AtomicInteger count=new AtomicInteger();
    public ContractTimer() {
    }

    @Override
    public void run() {
        try {
        	if (count.incrementAndGet()>5) {
        		count.set(0);
        		ContractTimer.log.info("--------------------合同定时器正常工作------------------");
    		}
			this.sendContract();
		} catch (Exception e) {
			e.printStackTrace();
			ContractTimer.log.info("合同定时器异常"+e.getMessage());
		}
    }

    *//**
     * 同步合同发送
     * @throws Exception 
     *//*
    public void sendContract() throws Exception {
        Integer Send_Size = Integer.parseInt(this.propsLoader.props.getProperty("contract.xml.send.size"));
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("pageSize", Send_Size);
        param.put("startRow", 0);
        List<Contract> list_con = null;
        while (true) {
        	log.info("---同步合同查询开始----");
        	long t2=System.currentTimeMillis();
            list_con = this.contractService.findSynchContract(param);
            log.info("---同步合同查询完成耗时："+(System.currentTimeMillis()-t2));
            Map<String, List<Contract>> syn_ct = new HashMap<String, List<Contract>>();
            if (list_con != null && list_con.size() > 0) {
            	filterSystem(list_con,syn_ct);
                log.info(Send_Size+"个合同同步开始发送----");
                long t1=System.currentTimeMillis();
                Iterator<String> it = syn_ct.keySet().iterator();
                while (it.hasNext()) {
                    String key = it.next();
                    List<Contract> lists = syn_ct.get(key);
                    DataSynchBean jms = new DataSynchBean();
                    jms.addUpdList(lists,"",BuildMethodEnum.OPERATE_ALL_NULL);
                    Map<String, Object> paMap = new HashMap<String, Object>();
                    paMap.put("transicSysTag", key);
                    jms.sendMsg(QueueEnum.QUEUE_INTENTION_CONTRACT, paMap);
                } 
                log.info(Send_Size+"个合同同步发送成功耗时:"+(System.currentTimeMillis()-t1));
                
                log.info(Send_Size+"个合同同步删除开始----");
                long t3=System.currentTimeMillis();
                this.contractService.delSynchContract(list_con);
                log.info(Send_Size+"个合同同步删除结束:"+(System.currentTimeMillis()-t3));
            } else {
                break;
            }
        }
    }
    public void filterSystem(List<Contract> list_obj, Map<String, List<Contract>> synchro) {
    	Map<String,Contract> temp_map=new HashMap<String,Contract>();
    	long t1=System.currentTimeMillis();
    	log.info("------遍历合同并去掉重复,当有重复意向时使用最后插入的意向开始");
		for (Contract ct : list_obj) {
			String key=ct.getIntentionId().toString()+ct.getContractId();
			Contract map_inten=temp_map.get(key);
			if (map_inten==null) {
				temp_map.put(key,ct);
			}else{
				if(map_inten.getInsertDate().before(ct.getInsertDate())){//当前对象的时间在map中对象的时间之后
					temp_map.put(key, ct);   //替换内存中的意向
				}
			}
		}
		log.info("------遍历合同并去掉重复,当有重复意向时使用最后插入的意向结束耗时："+(System.currentTimeMillis()-t1));
		Collection<Contract> synList=temp_map.values();
		String flag=null;
		for (Contract synct : synList) {
			flag=synct.getIntentionId().toString().substring(0,SysConstant.SUBSTRING)+synct.getSystemsource();
			List<Contract> list = synchro.get(flag);
			if (list == null) {
				list = new ArrayList<Contract>();
				synchro.put(flag, list);
			}
			list.add(synct);
		}
    }*/
}
