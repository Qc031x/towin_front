package com.sgfm.datacenter.action.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sgfm.base.action.BaseAction;
import com.sgfm.datacenter.service.order.OrderService;

@Controller
@Scope("prototype")
public class OrderAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private OrderService orderService;

}
