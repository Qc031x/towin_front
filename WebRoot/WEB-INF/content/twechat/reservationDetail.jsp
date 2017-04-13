<%@ page language="java"  pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/content/public/head.jsp" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>会员中心-预约详情</title>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="/css/base.css" />
		<link rel="stylesheet" type="text/css" href="/css/myOrder.css" />
		<link href="/css/twui-dialog.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
			.time-page ul li label{
				padding-right: 5px;
			}
		</style>
	</head>

	<body>
		<%@include file="/WEB-INF/content/public/top.jsp" %>
		<div class="gary"></div>
		<div class="order-introduce">
			<p>员工姓名：<span>${info.baseInfo.TRUE_NAME}
				<c:choose>
					<c:when test="${info.baseInfo.PAY_STATUS == 0}">
						<span style="color: #f76300">(未支付)</span>
					</c:when>
					<c:when test="${info.baseInfo.PAY_STATUS == 2 && info.baseInfo.ORDER_STATUS==0}">
						<span style="color: #f76300">(已支付  未体检)</span>
					</c:when>
					<c:when test="${info.baseInfo.PAY_STATUS == 2 && info.baseInfo.ORDER_STATUS==1}">
						<span style="color: #f76300">(已支付  已体检)</span>
					</c:when>
					<c:when test="${info.baseInfo.PAY_STATUS == null && info.baseInfo.ORDER_STATUS==0}">
						<span style="color: #f76300">(未体检)</span>
					</c:when>
					<c:when test="${info.baseInfo.PAY_STATUS == null && info.baseInfo.ORDER_STATUS==1}">
						<span style="color: #f76300">(已体检)</span>
					</c:when>
				</c:choose>
			</span></p>
			<p>发起单位：<span>${info.baseInfo.COMPANY_NAME}</span></p>
			<p>身份证号：<span>${info.baseInfo.IDCARD}</span></p>
			<p>电话号码：<span>${info.baseInfo.MOBILE}</span></p>
			<p>体检时间：<span>${info.baseInfo.ORDER_TIME}</span></p>
			<p>体检医院：<span>${info.baseInfo.ENAME}</span></p>
			<p>
				医院地址：<span>${info.baseInfo.PROVINCE}${info.baseInfo.CITY}${info.baseInfo.AREA}${info.baseInfo.ADDRESS}</span>
				<span style="padding: 0 5px" onclick="window.location.href='/content/twechat.map.do?address=${info.baseInfo.PROVINCE}${info.baseInfo.CITY}${info.baseInfo.AREA}${info.baseInfo.ADDRESS}&ename=${info.baseInfo.ENAME}&description=${info.baseInfo.DESCRIPTION }&tel=${info.baseInfo.TEL }&img=${info.img.CSID}/${info.img.ESID}/${info.img.IMG_URL}'">
					<img src="/img/local.png" width="15rem">
				</span>
			</p>
			<p>体检套餐：<span>
							<c:choose>
								<c:when test="${info.baseInfo.PRODUCT_TYPE==1}">
									${info.baseInfo.PRODUCT_NAME}
								</c:when>
								<c:when test="${info.baseInfo.PRODUCT_TYPE==2}">
									${info.baseInfo.DIY_PRODUCT_NAME}
								</c:when>
								<c:when test="${info.baseInfo.PRODUCT_TYPE==3}">
									单项自定义套餐
								</c:when>
								<c:when test="${info.baseInfo.PRODUCT_TYPE==4}">
									固定项&单项自定义套餐
								</c:when>
							</c:choose>
						</span></p>
			<p>咨询电话：<span>${info.baseInfo.TEL}</span></p>
			<p>套餐价格：<span>￥${info.baseInfo.PRODUCT_PRICE}</span></p>
			<p>我的钱包：<span>￥${info.baseInfo.MY_WALLET}</span></p>
			<c:if test="${info.baseInfo.PRODUCT_PRICE > info.baseInfo.MY_WALLET}">
				<p>自费金额：<span>￥${info.baseInfo.PRODUCT_PRICE - info.baseInfo.MY_WALLET}</span></p>
				<p>支付状态：<span>
					<c:if test="${info.baseInfo.PAY_STATUS == 0}">未支付</c:if>
					<c:if test="${info.baseInfo.PAY_STATUS == 2}">已支付</c:if>
					<c:if test="${info.baseInfo.PAY_STATUS == 3}">退款中</c:if>
					<c:if test="${info.baseInfo.PAY_STATUS == 4}">已退款</c:if>
				</span></p>
			</c:if>
		</div>
		
		<%@include file="/WEB-INF/content/twechat/myOrder.jsp" %>
		
				
		
			<c:if test="${info.baseInfo.PRODUCT_PRICE > info.baseInfo.MY_WALLET && info.baseInfo.PAY_STATUS == 0}">
				<div class="order-btn">
					<input type="button" id="" value="去支付（￥${info.baseInfo.PRODUCT_PRICE - info.baseInfo.MY_WALLET}）" class="btn btn-block" onclick="window.location.href='/core/twechat.toPayMent.do?oid=${info.baseInfo.OID}&sumPrice=${info.baseInfo.PRODUCT_PRICE - info.baseInfo.MY_WALLET}'"/>
				</div>
			</c:if>
			<c:if test="${info.baseInfo.ORDER_STATUS != 1}">
				<div class="order-btn">
					<input type="button" id="" value="重新预约" class="btn btn-block" onclick="toBrandPage();"/>
				</div>
				<div class="order-btn" style="min-height: 5em;">
					<input type="button" id="" value="取消预约" class="btn btn-block" onclick="canelYY(${info.baseInfo.YID});"/>
				</div>
			</c:if>
			<c:if test="${info.baseInfo.PAY_STATUS == null && info.baseInfo.ORDER_STATUS==1}">
				<div class="order-btn" style="min-height: 5em;">
					<input type="button" id="" value="查看体检报告" class="btn btn-block"/>
				</div>
			</c:if>
			<%--<input type="button" id="" value="返回" class="btn btn-block" onclick="javascript:history.back(-1);"/>--%>
			<%--<input type="button" id="" value="下载文件" class="btn btn-block" onclick="downLoadFile();"/>--%>
	</body>
	<script src="/js/twui-dialog.js" type="text/javascript"></script>
	<script type="text/javascript">
	function canelYY(yid){
		var data={"yid":yid};
		$.confirm("确认取消?", "您确定要取消预约吗?", function() {
				 $.getJSON("/core/twechat.canelReservation.do",data ,function(data){   
						if(data.returncode == 0){
								location.reload();			
							}
				});
	        }, function() {
	          //取消操作
	        });
		}
	function downLoadFile(){
		window.location.href="/core/twechat.downLoadFileUtil.do?fileName="+encodeURI (encodeURI("模块分工.xls"));
	}
	</script>
</html>