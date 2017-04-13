//id为 allmap 的div渲染地图
var map = new BMap.Map("allmap");
//获取用户当前位置（中文地址）
var myLocalAddress;
//医院地址信息弹窗
var searchInfoWindow = null;
var endAddress=$("#address").val();
//驾车
var driving;
//公交
var transit;
//步行
var walking;
$(document).ready(function(){
	$.showLoading("正在加载地图...");//地图初始化友好提示
	var point = new BMap.Point(116.331398,39.897445);//初始化坐标位置
	map.centerAndZoom(point,12);//初始化坐标居中且初始化地图比例
	map.enableScrollWheelZoom(true);  //显示所在位置的图标
	//创建信息窗口对象内容  动态数据
	var imgurl;
	if($("#img").val() == null || $("#img").val() == "" || $("#img").val() == "/" || $("#img").val() == "//"){
		imgurl='/img/nohospital_small.jpg'
	}else{
		imgurl='http://120.77.214.133:8084/shop/'+$("#img").val();
	}
	var content = '<div style="margin:0;line-height:20px;padding:2px;">' +
    '<img src="'+imgurl+'" alt="" style="float:right;zoom:1;overflow:hidden;width:80px;height:80px;margin-left:3px;"/>' +
    '<button class="toHere" style="float:right;position:absolute;bottom:0px;right:10px;background-color: #fff;color: #247dbe;border: 0px;">到这里去</button>'+
    '<span style="font-size: 14px;font-weight: bold;">'+$("#ename").val()+'</span><br>'+
    '地址：'+endAddress+'<br/>电话：'+$("#tel").val()+'<br/>简介：' +$("#description").val()+
    '</div>';
	
	// 添加定位控件
	  var geolocationControl = new BMap.GeolocationControl();
	  geolocationControl.addEventListener("locationSuccess", function(e){
	    // 定位成功事件
	    var address = '';
	    address += e.addressComponent.province;
	    address += e.addressComponent.city;
	    address += e.addressComponent.district;
	    address += e.addressComponent.street;
	    address += e.addressComponent.streetNumber;
	    //endAddress= address;
	    //byBus(address,endAddress)
	  });
	  geolocationControl.addEventListener("locationError",function(e){
	    // 定位失败事件
	    alert(e.message);
	  });
	  map.addControl(geolocationControl);
	
	// 创建地址解析器实例 重新定位目标地址
	var myGeo = new BMap.Geocoder();
	myGeo.getPoint(endAddress, function(point){
		if (point) {
			map.centerAndZoom(point, 16);
			var marker = new BMap.Marker(point); //创建marker对象
			var infoWindow = new BMap.InfoWindow(content);  // 创建信息窗口对象
			marker.addEventListener("click", function(e){
				this.openInfoWindow(infoWindow);
			    $("#BMapLib_sendToPhone0").hide();
			   })
			map.addOverlay(marker);

			 driving = new BMap.DrivingRoute(map, {renderOptions: {map: map, panel: "r-result", autoViewport: true}});
			 transit = new BMap.TransitRoute(map, {renderOptions: {map: map, panel: "r-result", autoViewport: true}});
			 walking = new BMap.WalkingRoute(map, {renderOptions: {map: map, panel: "r-result", autoViewport: true}});	  
			map.addEventListener("tilesloaded",function(){//地图加载完成
				$.closeLoading();
				if(myLocalAddress == null){
					myAddress();
					//searchInfoWindow.open(marker);
					$("#BMapLib_sendToPhone0").hide();
					marker.openInfoWindow(infoWindow);
					}
				$(".toHere").click(function(){
					$(".mapChooseType .car").addClass("active").siblings("a").removeClass("active");
					$.showLoading("正在规划路线");
					driving.search(myLocalAddress, endAddress);
				})
			});
		}else{
			alert("您选择地址没有解析到结果!");
		}
	}, "深圳市"); 
	
	
	$(".mapChooseType a").click(function(){
		$(this).addClass("active").siblings("a").removeClass("active");
		$.showLoading("正在规划路线");
		if($(this).hasClass("car")){
			driving.search(myLocalAddress, endAddress);
		}else if($(this).hasClass("bus")){
			transit.search(myLocalAddress, endAddress);
		}else if($(this).hasClass("foot")){
			walking.search(myLocalAddress, endAddress);
		}
		
	})
	
	
	
})

//定位当前位置方法（仅仅获取中文地址并赋值给全局变量 myLocalAddress，无其他操作）
function myAddress(){
	$.closeLoading();
	$.showLoading("正在为您定位");
	var myPoint = null;
	var geolocation = new BMap.Geolocation();
	geolocation.getCurrentPosition(function(r){
		if(this.getStatus() == BMAP_STATUS_SUCCESS){
			var mk = new BMap.Marker(r.point);
			//map.addOverlay(mk);
			//map.panTo(r.point);
			//alert('您的位置：'+r.point.lng+','+r.point.lat);
			myPoint =new BMap.Point(r.point.lng,r.point.lat);

			var geoc = new BMap.Geocoder();       
			geoc.getLocation(myPoint, function(rs){
				var addComp = rs.addressComponents;
				myLocalAddress=addComp.province + addComp.city + addComp.district + addComp.street + addComp.streetNumber;
				$.closeLoading();
			});   
			
		}
		else {
			myPoint =new BMap.Point(114.02597366,22.54605355);
			return myPoint;
		}        
	},{enableHighAccuracy: true})
}

function myPoint(){
	var myPoint = null;
	var geolocation = new BMap.Geolocation();
	geolocation.getCurrentPosition(function(r){
		if(this.getStatus() == BMAP_STATUS_SUCCESS){
			var mk = new BMap.Marker(r.point);
			map.addOverlay(mk);
			map.panTo(r.point);
			//alert('您的位置：'+r.point.lng+','+r.point.lat);
			myPoint =new BMap.Point(r.point.lng,r.point.lat);
			return myPoint;
			
		}
		else {
			myPoint =new BMap.Point(114.02597366,22.54605355);
			return myPoint;
		}        
	},{enableHighAccuracy: true})
}

//地址解析
function addressToPoint(address){
	var myGeo = new BMap.Geocoder();
	myGeo.getPoint(address, function(point){
		if (point) {
			return point;
		}else{
			alert("您选择地址没有解析到结果!");
		}
	}, "深圳市"); 

}
