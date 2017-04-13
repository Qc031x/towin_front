<%@ page language="java"  pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/content/public/head.jsp" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>会员中心-我的预约</title>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="/css/base.css" />
		<link rel="stylesheet" type="text/css" href="/css/chooseHospital.css" />
		<link href="/css/twui-dialog.css" rel="stylesheet" type="text/css" />
		
	</head>

	<body>
		<%@include file="/WEB-INF/content/public/top.jsp" %>
		<c:if test="${fn:length(reservation)==0}">
			<p style="text-align: center;padding: 30px;font-size: 14px">————您还未预约体检————</p>
		</c:if>
		<c:forEach items="${reservation}" var="list" varStatus="index">
			<p><span style="float: left;height: 25px">提交时间：${fn:substring(list.CREATE_TIME,0,10 )}</span>
				<span style="float: right;">
					<c:if test="${list.PAY_STATUS == 0}">
						<input type="button" style="float: left;width: 55px;height: 20px;border-radius: 3px;border: 0;margin: 0 2px auto;background-color: #227cbd;color: white;"  value="立即支付" onclick="window.location.href='/core/twechat.toPayMent.do?oid=${list.OID}&sumPrice=${list.PRODUCT_PRICE - list.MY_WALLET}'">
					</c:if>
					<c:if test="${list.ORDER_STATUS != 1}">
						<input type="button" style="float: left;width: 55px;height: 20px;border-radius: 3px;border: 0;margin: 0 2px auto;background-color: #227cbd;color: white;"  value="重新预约" onclick="window.location.href='${ctx}/core/twechat.toBranchList.do'">
						<input type="button" style="float: left;width: 55px;height: 20px;border-radius: 3px;border: 0;margin: 0 2px auto;background-color: #227cbd;color: white;"  value="取消预约" onclick="canelYY(${list.YID});">
					</c:if>
				</span>
			</p>
			<div class="hospital" onclick="window.location.href='/core/twechat.toReservationDetail.do?yid=${list.YID}'">
				<div class="hospital-content clearfix">
					<div class="img clearfix">
						<img src="${ctxImg}/shop/${list.CSID}/${list.ESID}/${list.IMG_URL}"/>
					</div>
					<div class="describe">
						<p>${list.NAME }</p>
						<p>预约状态：
							<c:choose>
								<c:when test="${list.PAY_STATUS == 0}">
									<span style="color: #f76300">未支付</span>
								</c:when>
								<c:when test="${list.PAY_STATUS == 2 && list.ORDER_STATUS==0}">
									<span style="color: #f76300">已支付  未体检</span>
								</c:when>
								<c:when test="${list.PAY_STATUS == 2 && list.ORDER_STATUS==1}">
									<span style="color: #f76300">已支付  已体检</span>
								</c:when>
								<c:when test="${list.PAY_STATUS == null && list.ORDER_STATUS==0}">
									<span style="color: #f76300">未体检</span>
								</c:when>
								<c:when test="${list.PAY_STATUS == null && list.ORDER_STATUS==1}">
									<span style="color: #f76300">已体检</span>
								</c:when>
							</c:choose>
						</p>
						<p>体检时间：${list.ORDER_TIME }</p>
						<p>套餐金额：￥${list.PRODUCT_PRICE}
								<c:if test="${list.PRODUCT_PRICE > list.MY_WALLET}">
								（自付：￥${list.PRODUCT_PRICE - list.MY_WALLET}）
								</c:if>
						</p>
					</div>
				</div>
			</div>
		</c:forEach>
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
		
			/*confirmMsg("是否取消预约？", function(){
				 $.getJSON("/core/twechat.canelReservation.do",data ,function(data){   
						if(data.returncode == 0){
								location.reload();			
							}
				});
			});*/
		}
		
	</script>
</html>