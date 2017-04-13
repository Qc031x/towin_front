<!DOCTYPE HTML>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" src="/js/commonLib.js"></script>
<script>
$(document).ready(function(){
	var leftTool = ($("#leftTool").val() == undefined || $("#leftTool").val() == '' ) ? 999 : $("#leftTool").val();
	//alert(leftTool)

	$(".user_left li:eq("+leftTool+") a").addClass("active");
	
	var url = "${ctx}/core/user.userInfomation.do",
		data = {};
	$.getMyJSON(url,data,function(data){
		var sex = data.sex;
		var img = data.img;
		var name = data.nickName == '' ? data.account : data.nickName;
		name = data.name == '' ? name : data.name;
		$(".user_left .user_name").text(name);
		if(img == ''){
			if(sex == '0'){
				$(".userinfo .pic img").attr("src", "../images/boy.jpg")
			}else{
				$(".userinfo .pic img").attr("src", "../images/gril.jpg")
			}
		}else{
			$(".userinfo .pic img").attr("src", "../images/"+img);
		}
	});
});
</script>
<input type="hidden" id="leftTool" value="${leftTool}" />
<div class="user_left">
    	<div class="user_letf_title"><a class="user" href="${ctx}/core/user.findUserIndex.do">会员中心</a></div>
        <div class="userinfo">
        	<div class="pic">
        		<img src="" />
        	</div>
            <div class="info">
            	<p>欢迎回来</p>
                <p class="user_name"></p>
                <p><a class="changeinfo" href="${ctx}/core/user.toUpdateMemberInfo.do">修改资料</a></p>
            </div>
        </div>
        <div class="user_leftnav">
        	<div class="leftnavtit">订单中心</div>
            <ul>
            	<li><a id="myorder" href="${ctx}/core/user.findUserOrder.do">我的订单</a></li>
                <li><a id="mycardpwd" href="${ctx}/core/user.findUserCard.do">我购买的卡密</a></li><%--
                <li><a id="mybusinesspackage" href="">我的企业套餐</a></li>
                --%><li><a id="myreservation" href="${ctx}/core/user.findMyTreservation.do">我的预约</a></li>
            </ul>
        </div>
        <div class="user_leftnav">
        	<div class="leftnavtit">体检报告管理</div>
            <ul>
            	<li><a id="reportsave" href="${ctx}/core/user.addCheckFilesInfo.do">体检报告储存</a></li>
                <li><a id="reportfile"  href="${ctx}/core/user.findCheckFilesInfo.do">体检报告档案</a></li>
            </ul>
        </div>
        <div class="user_leftnav">
        	<div class="leftnavtit">账户中心</div>
            <ul>
            	<li><a id="accbalance"  href="${ctx}/core/user.findUserCoupon.do">我的优惠券余额</a></li>
                <li><a id="myintegral"  href="${ctx}/core/user.findUserIntegration.do">我的积分</a></li>
                <li><a id="applyreceipt"  href="${ctx}/core/user.findUserReceipt.do">申请发票</a></li>
            </ul>
        </div>
        <div class="user_leftnav">
        	<div class="leftnavtit">资料设置</div>
            <ul>
            	<li><a id="peopleinfo"  href="${ctx}/core/user.findPersonnelInfo.do">常用人员信息</a></li>
                <li><a id="address"  href="${ctx}/core/user.findPersonneAdrlInfo.do">常用地址管理</a></li>
            </ul>
        </div>
        <div class="user_leftnav">
        	<div class="leftnavtit">服务中心</div>
            <ul>
            	<li><a id="myconcern"  href="${ctx}/core/user.myAttentionlInfo.do">我的关注</a></li>
                <li><a id="p_evaluate"  href="${ctx}/core/user.productAssesslInfo.do">商品评价</a></li>
                <li><a id="suggestion"  href="${ctx}/core/user.mySuggestInfo.do">意见建议</a></li>
            </ul>
        </div>
    </div>