<%@ page language="java"  pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/content/public/head.jsp" %>
<!DOCTYPE html>
<html style="cursor:pointer">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<meta name="format-detection" content="telephone=no" />
		<link rel="shortcut icon" href="/img/icon.ico" />
		<title>选择套餐</title>
		<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="/css/base.css" />
		<link rel="stylesheet" type="text/css" href="/css/list.css" />
		<link rel="stylesheet" type="text/css" href="/css/twui-dialog.css" />
		<style type="text/css">
			.pagination>li>a, .pagination>li>span{
				padding:0;
				font-size:1.6rem;
				margin-left:0;
				display:block;
				width:2.5rem;
				height:2.5rem;
				line-height:2.5rem;
			}
			#selectSetMeal span{
				padding: 10px;
				white-space:nowrap;
			}
			#selectSetMeal li .delbtn{
				color: red;
			    border: 1px solid red;
			    padding: 0px 4px;
			    float: right;
			    border-radius: 50%;
			    margin-right: 5px;
			}
			#selectSetMeal3 li .delbtn{
				color: red;
			    border: 1px solid red;
			    padding: 0px 4px;
			    float: right;
			    border-radius: 50%;
			    margin-right: 5px;
			}
			#bar-second nav ul{
				white-space:nowrap;
				padding-left: 15%;
			}
			#bar-third nav ul{
				white-space:nowrap;
				padding-left: 15%;
			}
			.optional-content .optional-bar-second ul.myPagination li a {
			    color: #333;
			}
			#selectSetMeal li .lfsetmeal{
				padding: 0px;
				white-space: initial;
				font-weight: initial;
				font-size:initial;
			}
			#selectSetMeal3 li .lfsetmeal{
				padding: 0px;
				white-space: initial;
				font-weight: initial;
				font-size:initial;
			}
		</style>
	</head>
	<body>
		<input type="hidden" id="esid" value="${params.esid}">
		<input type="hidden" id="batchId" value="${params.batchId }">
		<input type="hidden" id="orderTime" value="${params.orderTime}">
		<input type="hidden" id="pid" value="${map.productDetail.PID }">
		<input type="hidden" id="diyPid" value="${map.diyProductDetail.CUSTOM_ID }">
		
		<%@include file="/WEB-INF/content/public/top.jsp" %>
		<div class="listPage clearfix">
			<div id="productTypeTitle">
			<c:choose>
			<c:when test="${map.diyProductDetail !=null && map.productDetail ==null}">
				<ul class="listPageNav clearfix" style="width: 100%;border:inherit;border-radius:inherit;">
					<li class="nav-active" style="width: 100%;background: #027ac8;color:#fff">自选套餐</li>
					<input type="hidden" id="productType" value="2">
				</ul>
			</c:when>
			<c:otherwise>
				<ul class="listPageNav clearfix tagulTaocan">
					<li class="nav-active fixed" productType="1">固定套餐</li>
					<li class="optional" productType="2">自选套餐 </li>
					<input type="hidden" id="productType" value="1">
				</ul>
			</c:otherwise>
			</c:choose>
			</div>
			<div class="fixed-content" ${map.productDetail !=null?'' : 'style="display:none;"'}>
				<p>省时省心省力一键下单，方便快捷</p>
				<p style="font-size: 1.7rem;">固定项目</p>
				<ul class="select clearfix">
					
					<li class="clearfix">
						<div class="number title">
							编号
						</div>
						<div class="content title">
							体检项目
						</div>
					</li>
					
					<c:forEach items="${map.productInfo}" var="product" varStatus="index">
						<li class="list-content clearfix ${index.first?'list-content-click':'' }">
						<div class="number">
							${index.index+1}
						</div>
						<div class="content">
							<p class="content-title">${product.MODEL_NAME}</p>
							<p class="introduction">${product.CONTEXT}</p>
						</div>
					</li>
					</c:forEach>
				</ul>
				<div class="fixed-money">
					<p class="fixed-money-title">您目前的体检套餐：固定套餐</p>
					<ul class="clearfix">
						<li>
							<p>固定套餐金额</p>
							<p class="money">￥${map.productDetail.SHOP_PRICE==null?'0':map.productDetail.SHOP_PRICE}</p>
							<input type="hidden" id="gdtcPriceInput" value="${map.productDetail.SHOP_PRICE}">
						</li>
						<li>
							<p>您的钱包余额</p>
							<p class="money">￥ ${map.bdRole2.ROLE_LIMIT==null?map.bdRole1.ROLE_LIMIT:map.bdRole2.ROLE_LIMIT}</p>
							<input type="hidden" id="roleLimit1" value="${map.bdRole1.ROLE_LIMIT }">
						</li>
						<li>
							<p>还需支付</p>
							<p class="money" id="shouldPay1">
								<c:if test="${(map.productDetail.SHOP_PRICE - map.bdRole1.ROLE_LIMIT) > 0}">
									￥${(map.productDetail.SHOP_PRICE - map.bdRole1.ROLE_LIMIT) }
								</c:if>
								<c:if test="${(map.productDetail.SHOP_PRICE - map.bdRole1.ROLE_LIMIT) <= 0}">
									0
								</c:if>
							</p>
						</li>
					</ul>
				</div>
			</div>
			<div class="optional-content" ${map.productDetail !=null ?'style="display:none;"' : 'style="display:block;"'}>
				<p class="optional-content-title">您可以根据自身的实际情况自由选择套餐组合</p>
					<ul class="optional-bar clearfix" id="diyTopTitle">
						<c:if test="${map.diyProductInfo !=null}">
							<li style="width: 27%" class="bar-active optional-bar-first-bar" diyType="1">固定&包</li>
						</c:if>	
						<c:if test="${map.productInfo !=null}">
							<li style="width: 35%" class="optional-bar-third-bar" diyType="3" id="gdAndDx">固定&自选单项</li>
						</c:if>
							<li style="width: 27%;display: none;" class="optional-bar-second-bar" diyType="2" id="Dx">自选单项</li>
							
						
						
					</ul>
					<div class="gary"></div>
			<%-- 固定&包 --%>		
			<div class="optional-bar-first" id="bar-first" ${map.diyProductInfo ==null ?'style="display:none;"' : 'style="display:block;"'}>		
				<%@include file="/WEB-INF/content/twechat/bar-first.jsp" %>
			</div>
			<%-- 单项自定义 --%>	
			<div class="optional-bar-second" id="bar-second" style="display: none;">
				<%@include file="/WEB-INF/content/twechat/bar-second.jsp" %>
			</div>
			
			<%-- 固定&单项 --%>	
			<div class="optional-bar-third" id="bar-third" style="display: none;">
				<%@include file="/WEB-INF/content/twechat/bar-third.jsp" %>
			</div>
				
				
				<div class="gary" style="margin-top: 2rem;"></div>
				
				<div class="optional-money">
					<p class="optional-money-title">您目前的体检套餐：自选套餐</p>
					<p class="optional-money-title" style="font-size: 1.2rem;color: #737373;">*当自选套餐价格超出您的专属金额时，余下金额需要自行支付</p>
					<ul class="clearfix">
						<li>
							<p>自选套餐金额</p>
							<p class="money" id="divProductPrice">￥${map.diyProductDetail.PRICE}</p>
							<input id="divProductPriceInput" type="hidden" value="${map.diyProductDetail.PRICE}">
						</li>
						<li>
							<p>您的钱包余额</p>
							<p class="money" id="myLimit">￥${map.bdRole2.ROLE_LIMIT }</p>
							<input id="roleLimit2" type="hidden" value="${map.bdRole2.ROLE_LIMIT }">
						</li>
						<li>
							<p>还需支付</p>
							<p class="money" id="shouldPay2">
								<c:if test="${(map.diyProductDetail.PRICE - map.bdRole2.ROLE_LIMIT) > 0}">
									￥${(map.diyProductDetail.PRICE-map.bdRole2.ROLE_LIMIT)}
								</c:if>
								<c:if test="${(map.diyProductDetail.PRICE - map.bdRole2.ROLE_LIMIT) <= 0}">
									0
								</c:if>
						</li>
					</ul>
				</div>
			</div>
		</div>
		
		<div class="list-btn">
					<c:if test="${(map.diyProductDetail.PRICE - map.bdRole2.ROLE_LIMIT) > 0}">
						<input type="button" id="createOrder" value="确认付款" class="btn btn-block" />
					</c:if>
					<c:if test="${(map.diyProductDetail.PRICE - map.bdRole2.ROLE_LIMIT) <= 0}">
						<input type="button" id="createOrder" value="提交预约" class="btn btn-block" />
					</c:if>
				</div>

	</body>
	<script src="/js/jquery.fly.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="/js/list.js" type="text/javascript" charset="utf-8"></script>
	<script src="/js/commonLib.js" type="text/javascript" charset="utf-8"></script>
	<script src="/js/twui-dialog.js" type="text/javascript" ></script>
<script type="text/javascript">
		$(document).ready(function(){
			$("#createOrder").on("click",function(){
				var url = '${ctx}/core/twechat.checkBatchStatus.do', data = {'batchId':$('#batchId').val()};
				$.getMyJSON2(url, data, function(data) {
					if (data.returncode==0) {
						var productType=$("#productType").val();
						if(productType!="1"){
							var myWallet=$("#roleLimit2").val();
							var productPrice=$("#divProductPrice").text().replace("￥","");
							if((parseFloat(myWallet)*0.9) > parseFloat(productPrice)){
								var ye=parseFloat(myWallet)-parseFloat(productPrice);
								$.confirm("温馨提示", "您还有"+ye.toFixed(2)+"元未使用，是否继续提交预约？", function(){
									createOrder();
								},function(){
									
								})
							}else{
								createOrder();
							}
						}else{
							createOrder();
						}
					} else {
						$.alert("服务器提示",data.errmsg,"确定")
					}
				})
			});	
			
		})
	
	    function checkOrderTime(){
	       var url ="/core/twechat.checkOrderTime.do",data={"orderTime":$("#orderTime").val(),"esid":$("#esid").val()};
		   	$.getMyJSON(url,data,function(data){
		       if(data.returncode==1){
		    	   $.alert("服务器提示","该日期无效，请重新选择！","确定");
		         return false;
		       }
		       	 createOrder();  
		   	});		
	    }
	
		function createOrder(){
			$.showLoading("正在提交，请稍后");
			var esid=$("#esid").val();
			var orderTime=$("#orderTime").val();
			var pid="";
			var productPrice="";
			var myWallet=0
			var orderPay=$("#shouldPay1").text().replace("￥","");
			var productType=$("#productType").val();
				if(productType==1){
					pid=$("#pid").val();
					productPrice=$("#gdtcPriceInput").val();
					myWallet=$("#roleLimit1").val();
				}else{
					pid=$("#diyPid").val();
					productPrice=$("#divProductPrice").text().replace("￥","");
					myWallet=$("#roleLimit2").val();
					orderPay=$("#shouldPay2").text().replace("￥","");
					//
					if(productType==4){
						pid=$("#pid").val();
					}
				}
			var setmealIds="";
			if(productType==2){
				$(".clearfix .click").each(function(){
					setmealIds+=$(this).attr("pageid")+",";
				})
			}else if(productType==3){
				$("#selectSetMeal").find(".setmeal").each(function(){
					setmealIds+=$(this).attr("sid")+",";
				})
				if(setmealIds.length <= 0){
					
					setTimeout(function(){
						$.closeLoading();
						$.alert("提示","请选择至少一项自定义体检单项内容。","确定");
					},600);
					return false;
				}
			}else if(productType==4){
				$("#selectSetMeal3").find(".setmeal").each(function(){
					setmealIds+=$(this).attr("sid")+",";
				})
				if(setmealIds.length <= 0){
					$.closeLoading();
					$.alert("提示","请选择自定义体检单项，否则请预约固定套餐。","确定");
					return false;
				}
			}
			
			if(setmealIds.length>0){
				setmealIds=setmealIds.substring(0, setmealIds.length-1);
			}
			
			
			var type="0";
				if(parseInt(orderPay)>0){
				type="1";
				}
			
			var data={"esid":esid,"orderTime":orderTime,"pid":pid,
					  "productPrice":productPrice,"productType":productType,"setmealIds":setmealIds,"myWallet":myWallet,"orderPay":orderPay,"type":type};
		 	console.info(data);
			$.getJSON("${ctx}/core/twechat.createOrde.do",data ,function(data){   
			if(data.returncode == 0){
				var oid=data.data[0];
				//var catchkey=data.data[1];
				$.closeLoading();
				if(type=="1"){
					window.location.href="/core/twechat.toPayMent.do?oid="+oid+"&sumPrice="+orderPay;
				}else{
			  window.location.href="/core/twechat.toReservationDetail.do";
				  /*   var str_url='';
					str_url='https://open.weixin.qq.com/connect/oauth2/authorize?';
					str_url+='appid=wx44a26b8a7ef26809&';
					str_url+='redirect_uri=http://r.51towin.com/core/payMent.wxSendMsgCallBack.do&';
					str_url+='response_type=code&';
					str_url+='scope=snsapi_base&';
					str_url+='state='+catchkey;
					str_url+='#wechat_redirect';
					self.location=str_url;
					*/
				}
				
				}
			}); 
			
		}
	</script>
</html>