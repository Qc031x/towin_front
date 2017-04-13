<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" src="${ctx}/js/duibi.js"></script>
<script type="text/javascript" src="${ctx}/js/json2.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	dp.init();
	
	var login = '${account_log_succ_info.id}';
	
	if(login == ''){
		$("#guanzhu1").show();
		$("#guanzhu2").hide();
		$("#guanzhu1").fancybox({'centerOnScroll':true});
	}else{
		$("#guanzhu2").show();
		$("#guanzhu1").hide();
	}
});


</script>
<script type="text/javascript">	
function optionDiff(){
	if(dp.getprocount()!=2){
		alert('比对商品必须有2个商品')
		return;
	}

		window.open('${ctx}/content/product.diffProduct.do?pid1='+dp.product1.pid+'&pid2='+dp.product2.pid);
	//window.open('../../search/brand_search/diffProduct.jsp?pid1='+dp.product1.pid+'&pid2='+dp.product2.pid);
	
}
</script>

<div class="clear"></div>
<div class="fix_right">
	<div class="fix_right_leftan">
        <div class="zjczan">
            <a class="duibi" href="javascript:void(0);"><span>套餐对比</span><em></em></a>
            <a class="kefu" href="http://crm2.qq.com/page/portalpage/wpa.php?uin=4008557000&aty=0&a=0&curl=&ty=1" target="_blank"><span>QQ客服</span></a>
            <a class="guanzhu" href="javascript:void(0);"><span>我的关注</span></a>
            <a class="fixewm"><span class="fixrigewm"><img src="${ctx }/images/fixrigewm.png" /></span></a>
        </div>
        <div class="bottomzcan">
        	<a class="huitop" href="javascript:void(0);"><span>回顶部</span></a>
            <a class="fankui" href="javascript:void(0);"><span>留言反馈</span></a>
        </div>
    </div>
    <div class="fix_rightcon">
    	<div class="rixrigtit"><span class="tit">套餐对比</span><span class="guanbi"></span></div>
        <div class="fixduibicon">
        	<div class="nopro">对比库里要有两个套餐才能对比，现在是否<a href="">添加套餐</a>？</div>
            <div class="duibipro">
            </div>
            <div class="lijiduibian"><a href="javascript:void(0):">对　比</a></div>
        </div>
    </div>
</div>
<div class="clear"></div>
