<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="/js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="/js/commonLib.js" type="text/javascript"></script>
<META name=viewport content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/base.css" />
<link rel="stylesheet" type="text/css" href="/css/list.css" />
<title>订单支付页面</title>

<style type="text/css">
	.paymentqie .parentLi{
		height: 50px;
		padding: 10px;
	}
	.paymentqie ul li .img{
		min-width: 18%;
	    float: left;
	}
	.paymentqie ul li .text{
		width: 65%;
	    float: left;
	}
	.paymentqie ul li .check{
		width: 15%;
	    float: left;
	    text-align: right;
	}
</style>
<script>
$(document).ready(function(){	
	$(".paymentqie span").click(function(){
		$(this).addClass('active').siblings().removeClass('active');
		var sub_chindex = $(this).index();
		$(".paymentcon .paycontent").eq(sub_chindex).show().siblings(".paycontent").hide();
	});
	$(".yuyinpay_qiea span").click(function(){
		$(this).addClass('active').siblings().removeClass('active');
		var sub_chindex = $(this).index();
		$(".yyzfklx .yuyin_pay_list").eq(sub_chindex).show().siblings(".yuyin_pay_list").hide();
	})
	$("#usryuepay").click(function(){
		if($(this).val()==0){
			$(this).val(1);$(".useryue").slideDown();
		}else{
			$(this).val(0);$(".useryue").slideUp();
		}
	})
	$(".fixarigkf").hide();
	initPayStat();
	
});
function initPayStat(){
		var ua = navigator.userAgent.toLowerCase();
		  if(ua.indexOf("micromessenger")==-1)
		   {
		       $("#wxSpan").hide();
		       
		   }
		  else{
			  $("#alipay").hide();
			  $("#payMethod").val(2);
			  }
	
}

function payWap(){
	if($('#payMethod').val()=='0'){
		$.getMyJSON("${ctx}/core/payMent.unionpayWap.do",{"order.oid":"${order['oid']}"},
			function(data){
		if(data.result=='1'){
			$('#payForm').html(data.payHtml);		  
		   document.all.pay_form.submit();
		}
			
				
			}
		); 	
	}
	else if($('#payMethod').val()=='1'){
		$.getMyJSON("${ctx}/core/payMent.aliPayWap.do",{"order.oid":"${order['oid']}"},
			function(data){
		if(data.result=='1'){
			$('#payForm').html(data.payHtml);		  
		  document.forms['alipaysubmit'].submit();
		}
			
				
			}
		); 	

	}
	else if($('#payMethod').val()=='2'){
		var str_url='';
		str_url='https://open.weixin.qq.com/connect/oauth2/authorize?';
		str_url+='appid=wx44a26b8a7ef26809&';
		str_url+='redirect_uri=http://r.51towin.com/core/payMent.wxAuthonCallBack.do&';
		str_url+='response_type=code&';
		str_url+='scope=snsapi_base&';
		str_url+='state='+"${order['oid']}";
		str_url+='#wechat_redirect';
		self.location=str_url;

	}
	
}

function payMethod(payParm){
   $('#payMethod').val(payParm);
}
</script>
</head>
<body style="min-height: inherit;">
<input type="hidden" id='payMethod' value='1'  />
	<%@include file="/WEB-INF/content/public/top.jsp" %>
	<div style="background-color: #e8e8e8">
		<br>
		<div class="time-page" style="min-height: initial;background-color: #fff;">
				<ul style="padding: 10px;">
					<li style="font-size: 15px;font-weight: bold;margin-bottom: 5px;">订单号：<span style="font-weight: initial">${order['oid']}</span></li>
					<li style="font-size: 15px;font-weight: bold;margin-bottom: 5px;">应付金额： <span style="color: #027ac8;font-weight: initial">￥${order['sumPrice']}</span></li>
					<li style="color: #999;">立即支付${order['sumPrice']}元，即可完成订单 </li>
					<li style="color: #999;">*请您在72小时内完成支付，否则订单会被自动取消 </li>
				</ul>
		</div>
	
	<br>
	<div style="background-color: #fff">
		<div class="paymentqie clearfix">
			<ul>
				<li class="parentLi" id="wxSpan">
					<span class="img"><img src="/img/wechatpay.png"/></span>
					<span class="text">
						<ul>
							<li>微信支付</li>
							<li>微信支付</li>
						</ul>
					</span>
						
					<span class="check">
						<label>
							<input type="radio" name="pay" checked onclick='payMethod("2")'/>
						</label>
					</span>
				</li>
				<li id="alipay" class="parentLi">
					<span class="img"><img src="/img/alipay.png" width="39" height="35"/></span>
					<span class="text">
						<ul>
							<li>支付宝支付</li>
							<li>推荐有支付宝的用户支付</li>
						</ul>
					</span>
					<span class="check">
						<label>
							<input type="radio" name="pay" onclick='payMethod("1")'/>
						</label>
					</span>
				</li>
				<%--<li class="parentLi">
					<span class="img"><img src="/img/visa.png"/></span>
					<span class="text">
						<ul>
							<li>银行卡支付</li>
							<li>支付信用卡储蓄卡，无需开通网银</li>
						</ul>
					</span>
					<span class="check">
						<label>
							<input type="radio" name="pay" onclick='payMethod("0")'/>
						</label>
					</span>
				</li>
			--%></ul>
		</div>
	</div>
	<p class="problem" style="float: right;color: #027ac8;height: 3rem;padding: 9px;"><u>支付遇到问题?</u></p>
	<div class="list-btn" style="min-height: 22em;">
		<input type="button" id="createOrder" value="立即支付" class="btn btn-block" onclick="payWap()"/>
	</div>
	</div>
	
</body>
</html>