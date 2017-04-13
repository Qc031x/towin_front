<!DOCTYPE HTML>
<html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name=viewport content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name = "format-detection" content = "telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<title>卡密预约登录</title>
<link href="/css/style.css" type="text/css" rel="stylesheet">
<link href="/css/sgfmform.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/placeHolderTips.js"></script>
<script type="text/javascript" src="/js/jquery.sgfmform.js"></script>
<script type="text/javascript" src="/js/wx_login.js"></script>
</head>

<div class="headtop">
    <a class="back" href="javascript:history.go(-1);" title="返回上一页"></a>
    <p>卡密预约登录</p>
</div>

<div class="clear"></div>

<div class="topblank"></div>

<form id="makePoint">
<div class="yuyue_login">
    <div class="xiang">
        <input class="inputk ys1" type="text" tips="请输入卡号" name="reservation.card" datatype="*" nullmsg="请填写卡号!" errormsg="请填写正确卡号!" />
      
    </div>
    <div class="xiang">
        <input class="inputk" type="password" tips="请输入密码" name="reservation.password" datatype="*" nullmsg="请输入密码!" errormsg="请输入正确密码!"  />
      
    </div>
</div>

<div class="reg_an"><a href="javascript:void(0);" id="subRe">登录预约</a></div>
</form>

<div class="yuyue_login_tips">
	<h2>预约须知</h2>
    <p>1.需提前至少两天预约你的体检时间和地点。</p>
    <p>2.预约提交后您的信息将在24小时内处理完成。</p>
    <p>3.预约成功后您将在24小时内收到确定体检信息。</p>
    <p>4.凭短信携带有效证件前往体检。</p>
    <p>5.如果您没有卡号卡密，请前往<a style="color:#1aa9b9;" target=_blank href='${csThirdInfo.SHOP_URL}'>${csThirdInfo.SHOP_NAME}</a>购买。</p>
</div>

<div class="tech">
	<div class="tech_tip">技术支持:</div>
	<div class="tech_con">
		<p>国内领先的体检预约平台 www.1k360.com</p>
		<p>深圳市一康网络科技有限公司 400-855-7000</p>
	</div>
</div>

</body>
</html>