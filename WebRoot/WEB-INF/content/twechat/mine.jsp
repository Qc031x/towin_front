<%@ page language="java"  pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/content/public/head.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link rel="shortcut icon" href="img/icon.ico" />
		<title>我的特权</title>
		<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="/css/base.css" />
		<link rel="stylesheet" type="text/css" href="/css/mine.css" />
	</head>
	<body>
		<%@include file="/WEB-INF/content/public/top.jsp" %>
		<div class="gary" style="height: 1px;"></div>
		<div class="mine-con">
			<p class="mine-con-title">我的特权内容</p>
			<p class="mine-con-sm">家属体检特权内容：帮助家属预约体检服务可优惠。</p>
			<p class="mine-con-sm">健康保险特权内容：购买健康保险即可优惠20元。</p>
			<p class="mine-con-sm">医疗器械特权内容：即刻购买医疗器械立减30元。</p>
		</div>
		<div class="gary"></div>
		<div class="mine-list">
			<p class="list-title">家属体检特权</p>
			<ul class="clearfix">
				<li onclick="window.location.href='http://p.51towin.com/core/product.toProductDetail.do?cgVariable.pid=1655'">
					<img src="http://120.77.214.133:8084/product/1434/productImg14918914126246068.png"/>
					<p>常规升级套餐 (男)</p>
				</li>
				<li onclick="window.location.href='http://p.51towin.com/core/product.toProductDetail.do?cgVariable.pid=1670'">
					<img src="http://120.77.214.133:8084/product/1434/productImg14918984678235545.png"/>
					<p>中老年父母套餐 (男)</p>
				</li>
				<li onclick="window.location.href='http://p.51towin.com/core/product.toProductDetail.do?cgVariable.pid=1657'">
					<img src="http://120.77.214.133:8084/product/1434/productImg14918915620593311.png"/>
					<p>常规升级套餐 (已婚女)</p>
				</li>
			</ul>
		 	 <p class="more" onclick="window.location.href='http://p.51towin.com/core/product.toProductListPage.do'">查看更多特权<img src="/img/more.png"></p> 
		</div>
		<div class="gary"></div>
		<div class="mine-list">
			<p class="list-title">医疗器械产品特权</p>
			<ul class="clearfix">
				<li onclick="window.location.href='http://detail.youzan.com/show/goods?alias=3ersjhjahk7az&from_source=pzshouye&'">
					<img src="https://img.yzcdn.cn/upload_files/2017/03/30/FnlMkv1K4xlRdpzhkNDKJ1uPoa3w.jpeg!580x580.jpg"/>
					<p>乐心智能血压计I5 GPRS</p>
				</li>
				<li onclick="window.location.href='http://detail.youzan.com/show/goods?alias=3evfnrzf7zf63&from_source=pzshouye'">
					<img src="https://img.yzcdn.cn/upload_files/2017/03/30/Fmc5GVtqBfihkZwCxqH69_cnZSbi.jpg!580x580.jpg"/>
					<p>乐心智能体重秤S3</p>
				</li>
				<li onclick="window.location.href='http://detail.youzan.com/show/goods?alias=2xiwm3mr8ahgb&from_source=pzshouye'">
					<img src="https://img.yzcdn.cn/upload_files/2017/03/30/FkA2-ejNpmmPG84OZmCZvxt3rham.jpg!580x580.jpg"/>
					<p>乐心智能体脂秤S7</p>
				</li>
			</ul>
			<p class="more" onclick="window.location.href='https://h5.youzan.com/v2/showcase/homepage?alias=csk8slt1'">查看更多特权<img src="/img/more.png"></p>
		</div>
		<div class="gary"></div>
		<div class="mine-list">
			<p class="list-title">健康保险产品特权</p>
			<ul class="clearfix">
				<li onclick="window.location.href='http://m.htbaobao.com/productdetail-normal.html?prodaid=14671078225540200&prodSubType=NA&source=144'">
					<img src="https://img.yzcdn.cn/upload_files/2017/03/08/Fqq8dzp8qUOPaIXdiXFrxOej2_mk.jpg"/>
					<p>幸孕宝</p>
				</li>
				<li onclick="window.location.href='http://m.htbaobao.com/productdetail-normal-hospital.html?prodaid=14794531754590200&prodSubType=NA&source=144'">
					<img src="https://img.yzcdn.cn/upload_files/2017/03/08/FmDQj88JnqzUaUjAYz6d38Lz0rAj.jpg"/>
					<p>臻爱医疗</p>
				</li>
				<li onclick="window.location.href='http://m.htbaobao.com/productdetail-normal.html?prodaid=14749766505400200&prodSubType=NA&source=144'">
					<img src="https://img.yzcdn.cn/upload_files/2017/03/08/FjTvLGQhA6zPDDZ6NNlmWtLKKx0c.jpg"/>
					<p>成人意外宝</p>
				</li>
			</ul>
			<p class="more" onclick="window.location.href='https://h5.youzan.com/v2/showcase/homepage?alias=csk8slt1'">查看更多特权<img src="/img/more.png"></p>
		</div>
		<div class="gary" style="min-height: 5em;"></div>
	</body>
</html>
