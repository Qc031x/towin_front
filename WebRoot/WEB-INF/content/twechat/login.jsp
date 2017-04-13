<%@ page language="java"  pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/content/public/head.jsp" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link rel="shortcut icon" href="/../img/icon.ico" />
		<title>登录</title>
		<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="/css/base.css" />
		<link rel="stylesheet" type="text/css" href="/css/index.css" />
		
		<link rel="stylesheet" type="text/css" href="/css/twui-dialog.css">
	</head>

	<body>
		<div class="index-logo">
			<img src="../img/logo.png" />
		</div>
		<!--<p class="index-title">集线上信息服务与线下医疗服务为一体的大健康平台</p>-->
		<div class="index-title">
			<img src="../img/title.png" />
		</div>
		
		<form id=loginForm >
			<div class="index-login">
				<div class="index-login-user">
					<img src="../img/user.png" />
					<input type="text" id="true_name" name="true_name" value="" placeholder="请输入姓名" class="form-control" />
				</div>
				<div class="index-login-psd">
					<img src="../img/psd.png" />
					<input type="text" id="mobileOrIdcard" name="mobileOrIdcard" value="" placeholder="请输入手机号/身份证号码" class="form-control" />
				</div>
			</div>
					<div class="wrong" style="width: 73%;margin: 0 auto;color: red;display: none">
						<label id="labWrong"><span id='loginVaildTips'></span></label>
					</div>
			<div class="index-check">
				<span class="remember check"></span>
				<span>记住密码</span>
				<input type="hidden" value="1" id="remember" name="remember">
			</div>
			<div class="index-btn">
				<input type="button" id="" value="登录" class="btn btn-block" onclick="login()" />
			</div>
		</form>
			
		<div class="index-footer">
			<p>天问（深圳）医疗服务有限公司</p>
		</div>

	</body>
	
<script src="/js/jquery.sgfmform.js" type="text/javascript"></script>	
<script src="/js/js.cookie.js" type="text/javascript"></script>
<script type="text/javascript" src="/js/twui-dialog.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$(".index-check .remember").click(function() {
		$(".index-check .remember").toggleClass("check")
	})
	
    var true_name = Cookies.get('true_name');
	var mobileOrIdcard = Cookies.get('mobileOrIdcard');
	
	if(true_name != "" && true_name != undefined){
		$("#true_name").val(true_name);
	}
	
	if(mobileOrIdcard != "" && mobileOrIdcard != undefined){
		$("#mobileOrIdcard").val(mobileOrIdcard);
	}

	$("#loginForm").sgfmform({
        ajaxurl:"/core/login.doMemberLogin.do",
		tiptype:2,
		submittype:2,
		callback:function(data,url){
			if(data.returncode == 1){
				$.closeLoading();
				$(".wrong").fadeIn();
			    $("#loginVaildTips").html(data.errmsg);
			     return false;
			}
			if(data.data[0] == null){
				$.closeLoading();
       		 	$(".wrong").fadeIn();
			    $("#loginVaildTips").html('<p>登录失败，原因可能是：</p><p>1、您输入的账号密码不正确</p><p>2、贵公司暂没有给您安排体检</p>');
			     return false;
			}
        	var batchSum=data.data[0].batchSum;
        	var html='';
        	
        	if(batchSum==0){
        		$.closeLoading();
        		 $(".wrong").fadeIn();
			    $("#loginVaildTips").html('<p>登录失败，原因可能是：</p><p>1、您输入的账号密码不正确</p><p>2、贵公司暂没有给您安排体检</p>');
			     return false;
        	}
        	if(batchSum==1){
        		$.closeLoading();
        	    window.location.href="/core/login.loginSuccess.do?batchId="+data.data[0].batchInfo[0].BATCH_ID+"&employeeId="+data.data[0].batchInfo[0].EMPLOYEE_ID;
        	}
        	if(batchSum>1){
				var batchData=[];
				for(var i=0;i<batchSum;i++){
					 batchData.push({"id":data.data[0].batchInfo[i].BATCH_ID ,"id2":data.data[0].batchInfo[i].EMPLOYEE_ID , "name":data.data[0].batchInfo[i].NAME});
	        	}
				$.closeLoading();	 
				$(".wrong").fadeOut();
        		$.choose("请选中一个批次进入",batchData,function(bat_id,employeeId){
        			window.location.href="/core/login.loginSuccess.do?batchId="+bat_id+"&employeeId="+employeeId;
        		},function(){
        			
        		});
			}
        	
		}
	});
	$(':checkbox').click(function(){
        if($(this).is( ":checked" )){
        	$("#remember").val(1);
        }else{
        	$("#remember").val(0);
        }
    });
	
	
});
function login(){
	
   if($("#true_name").val()==''){		
		$(".wrong").fadeIn();
	    $("#loginVaildTips").html('请输入姓名!');
	    window.setTimeout(function(){
	    	$(".wrong").fadeOut();
	    },2000);
	    return;
	}
	if($("#mobileOrIdcard").val()==''){
		$(".wrong").fadeIn();
	    $("#loginVaildTips").html('请输入手机号码或者身份证号码!'); 
	    window.setTimeout(function(){
	    	$(".wrong").fadeOut();
	    },2000);
	    return;
	}
	$.showLoading("正在加载批次信息");
    $("#loginForm").submit();
	
}

</script>
</html>