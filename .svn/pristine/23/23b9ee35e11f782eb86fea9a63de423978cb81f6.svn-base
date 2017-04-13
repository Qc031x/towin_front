<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/content/public/tags.jsp" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link rel="shortcut icon" href="img/icon.ico" />
		<title>天问大健康服务平台</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/index-base.css" />
		<link rel="stylesheet" type="text/css" href="css/index-style.css" />
		<script src="/js/jquery-1.11.1.min.js" type="text/javascript"></script>
	</head>

	<body>
		<input type="hidden" value="${backUrl}" id="backUrl">
		<div class="banner">
			<img src="img/banner.png" class="banner-img"/>
			<div class="local" onclick="window.location.href='${PCPTSERVER}/core/login.goCity.do?openId=${user_openid}'">
				<img src="img/local1.png" class="local-img"/>
				<span class="cityName">${cityName}</span>
			</div>
		</div>
		<div class="inter-btn">
			<input type="button" id="" value="企业员工体检预约" class="btn btn-block" onclick="window.location.href='/content/twechat.login.do'"/>
		</div>
		<div class="list">
			<ul class="clearfix">
				<li onclick="window.location.href='${PCPTSERVER}/core/shop.toEntityShopListPage.do?openId=${user_openid}'">
					<img src="img/zyy.png"/>
					<p>找医院</p>
				</li>
				<li onclick="window.location.href='${PCPTSERVER}/core/product.toProductListPage.do?openId=${user_openid}'">
					<img src="img/ztc.png"/>
					<p>找套餐</p>
				</li>
				<li onclick="window.location.href='${PCPTSERVER}/content/product.cardList.do?openId=${user_openid}'">
					<img src="img/card.png"/>
					<p>天问一卡通</p>
				</li>
				<li onclick="window.location.href='${PCPTSERVER}/content/reservation.rs_login.do?openId=${user_openid}'">
					<img src="img/kmyy.png"/>
					<p>卡密预约</p>
				</li>
			</ul>
		</div>
		<div class="hot-sell">
			<p class="hot-sell-p">天问热卖</p>
			<ul class="clearfix hot-sell-list">
				<li onclick="window.location.href='${PCPTSERVER}/core/product.toProductListPage.do?cgVariable.categoryidOne=zlntj&openId=${user_openid}'">
					<img src="img/zlntj.png"/>
					<p>中老年体检</p>
				</li>
				<li onclick="window.location.href='${PCPTSERVER}/core/product.toProductListPage.do?cgVariable.categoryidOne=cgtj&openId=${user_openid}'">
					<img src="img/cgtj.png"/>
					<p>常规体检</p>
				</li>
				<li onclick="window.location.href='${PCPTSERVER}/core/product.toProductListPage.do?cgVariable.categoryidOne=zljc&openId=${user_openid}'">
					<img src="img/zljc.png"/>
					<p>肿瘤检测</p>
				</li>
				<li onclick="window.location.href='${PCPTSERVER}/core/product.toProductListPage.do?cgVariable.categoryidOne=fktj&openId=${user_openid}'">
					<img src="img/fktj.png"/>
					<p>妇科体检</p>
				</li>
			</ul>
			<ul class="clearfix hot-sell-list">
				<li onclick="window.location.href='${PCPTSERVER}/core/product.toProductListPage.do?cgVariable.categoryidOne=qstj&openId=${user_openid}'">
					<img src="img/qstj.png"/>
					<p>全身体检</p>
				</li>
				<li onclick="window.location.href='${PCPTSERVER}/core/product.toProductListPage.do?cgVariable.categoryidOne=rztj&openId=${user_openid}'">
					<img src="img/rztj.png"/>
					<p>入职体检</p>
				</li>
				<li onclick="window.location.href='https://h5.youzan.com/v2/tag/7ae4e4dz?reft=1490079381676&spm=f46838890'">
					<img src="img/ylqx.png"/>
					<p>医疗器械</p>
				</li>
				<li onclick="window.location.href='https://h5.youzan.com/v2/showcase/component?alias=16fmasbyj&reft=1490079503265&spm=f46838890'">
					<img src="img/jkbx.png"/>
					<p>健康保险</p>
				</li>
			</ul>
			<input type="hidden" value="${backUrl}" id="backUrl">
			<input type="hidden" value="${backOpenid}" id="backOpenid">
		<script>
			//window.location = "http://p.51towin.com/core/user.findUserReservation.do";
			if($("#backUrl").val() != "" && $("#backUrl").val() != null){
				var url = $("#backUrl").val() + "?openId=" + $("#backOpenid").val();
				alert(url)
				window.location = url;
			}
		</script>
		</div>
		<div class="footer">
			<p>客服热线：400-661-6669</p>
		</div>
	</body>
<script src="/js/js.cookie.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
	var cityName = Cookies.get('cookie_cityName');
	$(".cityName").text(cityName);
});
</script>
</html>