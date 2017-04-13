/*
 * 日历控件使用指南
 * 1、页面中需要使用日历控件则需要在Jsp的<head>部分引入：
 * <script type="text/javascript" src="${ctx}/js/ykcalendar.js"></script>
 * 2、日历控件通过获取页面标签id为page_esid获取门店id的值（必须提供），通过获取页面标签id为pid获取产品id的值（根据功能需求选择提供）
 * 3、根据使用场景的不同提供两种方式初始化日历
 * (1)根据产品查看与产品相关各门店的预约日历通过调用方法ykrili.init()完成日历初始化
 * (2)查看门店的预约日历通过调用ykrili.getjiazairili()完成日历初始化
 * 4、提供日历可选中功能，需向初始化方法传值1，如ykrili.getjiazairili(1)
 * 5、提供日历的编辑功能，需向初始化方法传值8(在商家修改日历的场景中存在)，如ykrili.getjiazairili(8)
 */
function Calendar(){
	var stylenum=0;
	this.sourceType="";
	this.init=function(type){
		stylenum++;
		if(stylenum<2 && type==1){
			$("head").append("<style type='text/css'>.yue_rili .yue_day li.future{cursor:pointer;} .yue_rili .yue_day li.future:hover{background:#eee;}</style>");
		}
		$(".lookrili").click(function(){
			var url = "/core/product.getAllEntityshopByPid.do",
				data = {"product.pid" : $("#pid").val()},
				pid = $("#pid").val();

			$.getMyJSON(url,data,function(data){
				$(".mdxzan .mdcitylist a").remove()
				var title0 = data[0].TITLE.substr(0, data[0].TITLE.length - 1);
				$(".mdxzan .mdcitylist").append("<a onclick='ykrili.getentityshop("+data[0].ID+","+pid+")' class='active' href='javascript:void(0)'>"+title0+"</a>")
				for(var i = 1; i < data.length; i++){
					var title = data[i].TITLE.substr(0, data[i].TITLE.length - 1);
					$(".mdxzan .mdcitylist").append("<a onclick='ykrili.getentityshop("+data[i].ID+","+pid+")' href='javascript:void(0)'>"+title+"</a>")
				}
				$(".fixrilitmbg .mdxzan .mdcitylist a").click(function(){
					$(this).addClass("active").siblings("a").removeClass("active");
				});
				getEntityshop(data[0].ID,pid);

			});
		});
	}
	this.getjiazairili=function(type){
		calendar.sourceType=type;

		stylenum++;
		if(stylenum<2 && type==1){
			$("head").append("<style type='text/css'>.yue_rili .yue_day li.future{cursor:pointer;} .yue_rili .yue_day li.future:hover{background:#eee;}</style>");
		}
		$(".riliqiean1").remove();
		$(".riliqiean2").remove();
		$(".riliyear").before("<div class='riliqiean1'></div>");
		$(".riliyear").after("<div class='riliqiean2'></div>");
		jiazhairili();
	}
	var getEntityshop=function(id,pid){
		//alert(id+","+pid)
		var url = "/core/product.getEntityshop.do",
			data = {"cgVariable.pid" : pid, "cgVariable.ids" : id};

		//return false;
		$.getMyJSON(url,data,function(data){
			$(".mdlist div").remove();
			for(var i = 0; i < data.length; i++){
				//$(".mdlist").append("<div class='list'><p><a target='_blank' href='/core/product.findMedicalinstitutionProduct.do?cgVariable.esid="+data[i].ESID+"'>【"+data[i].BNAME+"】"+data[i].NAME+"</a></p><p>地址："+data[i].ADDRESS+"</p><span esid="+data[i].ESID+" class='checkrili'>查看可预约日期</span></div>");
				$(".mdlist").append("<div class='list'><p>【"+data[i].BNAME+"】"+data[i].NAME+"</p><p>地址："+data[i].ADDRESS+"</p><span esid="+data[i].ESID+" class='checkrili'>查看可预约日期</span></div>");
			}
			if($(".mdxzan .mdcitylist a").length < 10){
				$(".mdxzan span").remove()
			}
			//jiazhairili();
			$(".fixrilitmbg .mdlist .list .checkrili").click(function(){

				$(".fixrilitmbg .fenyuantit").text($(this).parents(".list").find("a").text());
				$(".fixrilitmbg .fixmddiv").fadeOut();
				$(".fixrilitmbg .rilidiv").fadeIn();
				//alert($(this).attr("esid"))
				$("#page_esid").val($(this).attr("esid"));

				$(".riliqiean1").remove();
				$(".riliqiean2").remove();
				$(".riliyear").before("<div class='riliqiean1'></div>");
				$(".riliyear").after("<div class='riliqiean2'></div>");
				jiazhairili();
			});
		});
	}
	this.getentityshop=function(id,pid){
		getEntityshop(id,pid);
	}
	var jiazhairili=function(){
		var today = new Date();
		year = today.getFullYear();
		month = today.getMonth()+1;
		thisDay = today.getDate();
		firstDay = today;
		firstDay.setDate(1);
		startDay = firstDay.getDay();
		oldyear= today.getFullYear();
		oldmonth= today.getMonth()+1;
		
		//限制可见日期为批次有效期
		var batchStartTime=$("#batchStartTime").val().split("-");
		year=batchStartTime[0];
		month=parseInt(batchStartTime[1]);
		thisDay=parseInt(batchStartTime[2]);
		
		var today2 = new Date(year+"/"+month+"/" + thisDay);
		
		if(today.getTime() > today2.getTime()){
			today=today;
			year=today.getFullYear();
			month=(today.getMonth()+1);
			thisDay=today.getDay();
		}else{
			today=today2;
		}
		firstDay = today;
		firstDay.setDate(1);
		startDay = firstDay.getDay();
		
		$("#xlyear").empty();
		$("#xlyear").text(year);
		$("#xlmonth").empty();
		$("#xlmonth").text(month);
		
		var xyyue=oldmonth-1;
		$("#xlmonth option:lt("+xyyue+")").attr("disabled",true);
		chushirili(today,year,month,thisDay,startDay);
		var today2,year2,month2,thisDay2,startDay2,today3,year3,month3,thisDay3,startDay3;

		$(".riliqiean1").click(function(){
			var xlnian2=$("#xlyear").text();
			var xlyue2=$("#xlmonth").text();
			$("#xlmonth option").removeAttr("disabled");
			month3=Number(xlyue2)-1;
			
			var batchStartTime = new Date($("#batchStartTime").val().replace(/-/g,   "/"));
			var upMothDay;
			if(month3==0){
				upMothDay = Number(xlnian2)-1 + "/12/01";
			}else{
				upMothDay = xlnian2 + "/" +month3 + "/01";
			}
			upMothDay = new Date(upMothDay);
			upMothDay = new Date(upMothDay.getFullYear(),(upMothDay.getMonth()+1),1);
			//上个月的最后一天
			upMothDay = new Date(upMothDay-86400000);  
			
			if(upMothDay < batchStartTime ){return;}
			
			if(month3==0){
				if(xlnian2==oldyear){
					month=month3=xlyue2;
					year=year3=xlnian2;
					$("#xlmonth option:lt("+xyyue+")").attr("disabled",true);
				}else{
					month=month3=12;
					year=year3=Number(xlnian2)-1;
					if(year3==oldyear){
						$("#xlmonth option:lt("+xyyue+")").attr("disabled",true);
					}
				}
			}else{
				if(xlnian2==oldyear){
					$("#xlmonth option:lt("+xyyue+")").attr("disabled",true);
					if(xlyue2==oldmonth){
						month=month3=Number(xlyue2);
					}else{
						month=month3=Number(xlyue2)-1;
					}
				}else{
					month=month3=Number(xlyue2)-1;
				}
				year=year3=Number(xlnian2);
			}
			
			$("#xlyear").text(year3);
			$("#xlmonth").text(month3);
			today3 = new Date(year3+"/"+month3+"/01");
			startDay3 = today3.getDay();
			if(year3==batchStartTime[0] && month3==parseInt(batchStartTime[1])){
				chushirili(today3,year3,month3,thisDay,startDay3);
			}else{
				chushirili(today3,year3,month3,0,startDay3);
			}
		})

		$(".riliqiean2").click(function(){
			var xlnian2=$("#xlyear").text();
			var xlyue2=$("#xlmonth").text();
			$("#xlmonth option").removeAttr("disabled");
			month3=Number(xlyue2)+1;
			
			var batchEndTime = new Date($("#batchEndTime").val().replace(/-/g,   "/"));
			var nextMothDay;
			if(month3==13){
				nextMothDay = Number(xlnian2)+1 + "/01/01";
			}else{
				nextMothDay = xlnian2 + "/" +month3 + "/01";
			}
			nextMothDay = new Date(nextMothDay);
			if(nextMothDay>batchEndTime){return;}
				
			if(month3==13){
				month=month3=1;
				year=year3=Number(xlnian2)+1;
			}else{
				month=month3=Number(xlyue2)+1;
				year=year3=xlnian2;
				if(year==oldyear){
					$("#xlmonth option:lt("+xyyue+")").attr("disabled",true);
				}
			}
		
			$("#xlyear").text(year3);
			//alert(month3)
			$("#xlmonth").text(month3);
			today3 = new Date(year3+"/"+month3+"/01");
			startDay3 = today3.getDay();
			chushirili(today3,year3,month3,0,startDay3);
		})

		$("#xlyear").change(function(){
			$("#xlmonth option").removeAttr("disabled");
			var xlnian=$("#xlyear").text();
			var xlyue=$("#xlmonth").text();
			if(xlnian==oldyear){
				if(xlyue<=oldmonth){
					xlyue=oldmonth;
					$("#xlmonth option:lt("+xyyue+")").attr("disabled",true);
					today2 = new Date(xlnian+"/"+xlyue+"/01");
					month=month2=xlyue;
					year=year2=xlnian;
					startDay2 = today2.getDay();
					chushirili(today2,year2,month2,thisDay,startDay2);
				}else{
					today2 = new Date(xlnian+"/"+xlyue+"/01");
					month=month2=xlyue;
					year=year2=xlnian;
					startDay2 = today2.getDay();
					chushirili(today2,year2,month2,0,startDay2);
				}
			}else{
				today2 = new Date(xlnian+"/"+xlyue+"/01");
				month=month2=xlyue;
				year=year2=xlnian;
				startDay2 = today2.getDay();
				chushirili(today2,year2,month2,0,startDay2);
			}
		})

		$("#xlmonth").change(function(){
			var xlnian=$("#xlyear").text();
			var xlyue=$("#xlmonth").text();
			today2 = new Date(xlnian+"/"+xlyue+"/01");
			month=month2=xlyue;
			year=year2=xlnian;
			if(xlnian==oldyear){
				if(xlyue<=oldmonth){
					xlyue=oldmonth;
					$("#xlmonth option:lt("+xyyue+")").attr("disabled",true);
					today2 = new Date(xlnian+"/"+xlyue+"/01");
					month=month2=xlyue;
					year=year2=xlnian;
					startDay2 = today2.getDay();
					chushirili(today2,year2,month2,thisDay,startDay2);
				}else{
					today2 = new Date(xlnian+"/"+xlyue+"/01");
					month=month2=xlyue;
					year=year2=xlnian;
					startDay2 = today2.getDay();
					chushirili(today2,year2,month2,0,startDay2);
				}
			}else{
				today2 = new Date(xlnian+"/"+xlyue+"/01");
				month=month2=xlyue;
				year=year2=xlnian;
				startDay2 = today2.getDay();
				chushirili(today2,year2,month2,0,startDay2);
			}
		});

		for(i=0;i<24;i++){
			$(".zttimes").append("<option value='"+i+"'>"+i+"</option>");
		};
		for(i=0;i<60;i++){
			$(".zttimef").append("<option value='"+i+"'>"+i+"</option>");
			$(".zttimem").append("<option value='"+i+"'>"+i+"</option>");
		};
	}

	var initRiData =function(year,month,thisDay,startDay){

		//beg 通过json改变日历
		var currDate=year+"-"+month+"-"+thisDay;
		var esid=$('#page_esid').val();
		var url = "/core/twechat.getRiDataByEsid.do";
		jQuery.post(url,
			{
				"esid":esid,"date":currDate
			}, function (data) {
				//alert(data[0]["args2"])
				DATEINFO=data[0]["args1"];
				DATEREVINFO=data[0]["args2"];
				// alert(DATEINFO+"\n"+DATEREVINFO)

				var today2 = new Date();
				var batchEndTime=$("#batchEndTime").val().split("-");
				var batchStartTime=$("#batchStartTime").val().split("-");
				$(".yue_rili .yue_day li").remove();
				for (i=0; i<startDay; i++) {$(".yue_rili .yue_day").append("<li></li>");}
				for (i=1; i<=DATEINFO.length; i++) {
					if(i<today2.getDate() &&year==today2.getFullYear()&&(month==today2.getMonth()+1)){
						$(".yue_rili .yue_day").append("<li class='over'>"+ i +"</li>");
					}else if(i == today2.getDate()&&year==today2.getFullYear()&&(month==today2.getMonth()+1)){
						var temp=year+"-"+(month<10?'0'+month:month)+"-"+(i<10?'0'+i:i);
						if(DATEREVINFO[i-1]=="1"){
							$(".yue_rili .yue_day").append("<li class='today' date="+temp+" bool='true'>"+ i +"<br>"+" <span id=ykbackrl_"+temp+"  class='zt1'>今天</span>"+"</li>");
						}else{
							$(".yue_rili .yue_day").append("<li class='today' date="+temp+" bool='flase'>"+ i +"<br>"+" <span id=ykbackrl_"+temp+"  class='zt1'>今天</span>"+"</li>");
						}
					}else if(i < batchStartTime[2]&&year==batchStartTime[0]&&(month==batchStartTime[1])){
						$(".yue_rili .yue_day").append("<li class='over'>"+ i +"</li>");
					}else if(i > batchEndTime[2]&&year==batchEndTime[0]&&(month==batchEndTime[1])){
						$(".yue_rili .yue_day").append("<li class='over'>"+ i +"</li>");
					}else{
						var temp=year+"-"+(month<10?'0'+month:month)+"-"+(i<10?'0'+i:i);
						//0 今天以前  1 今天以后可以约。 2今天以后可以约，但由于假日策略已经使其变为”休息“了，
						//3 默认策略的人数导致其“已满”，4 默认策略（如下班时间到18：00后）导致其“暂停预约”，5节假日策略导致
						var textIsRev=getRevDayText(DATEREVINFO[i-1],temp,i)
						$(".yue_rili .yue_day").append(textIsRev);
						//	$(".yue_rili .yue_day").append("<li class='future' date="+year+"-"+month+"-"+i+">"+ i +"<br><span class='zt1'>可约</span><a href='#tanbianjidiv'><em>编辑</em></a></li>");
						//$(".yue_rili .yue_day").append("<li class='future' date="+temp+">"+ i +"<br>"+textIsRev+"</li>");
						//$(".yue_rili .yue_day").append("<li class='future' date="+year+"-"+month+"-"+i+">"+ i +"<br><span class='zt1'>可约</span><a href='#tanbianjidiv'><em>编辑</em></a></li>");
						//$(".yue_rili .yue_day").append("<li class='disfuture' date="+year+"-"+month+"-"+i+">"+ i +"<br><span class='zt2'>已满,假日,休息,暂停预约<span><a href='#tanbianjidiv'><em>编辑</em></a></li>");

					}
					
					if(i==DATEINFO.length){
						$.closeLoading();
					}
				}
				$(".yue_rili").each(function(){
					var geshu=$(this).find(".yue_day li").length;
					if(28<geshu && geshu<35){
						for(var k=geshu;k<35;k++)
						{$(this).find(".yue_day").append("<li class='disabled'></li>");};
					}else if(35<geshu && geshu<42){
						for(var m=geshu;m<42;m++)
						{$(this).find(".yue_day").append("<li class='disabled'></li>");}
					}
				})
				if($(".banduansfy").hasClass("checklookrili")){
					$(".yue_rili .yue_day li.future").click(function(){
						$(".checklookrili").val($(this).attr("date"));
						$(".fixrilitmbg").fadeOut();
						$(".checklookrili").show();
					})
				}
				$(".yue_rili .yue_day li.future").click(function(){
					$(".yydata").val($(this).attr("date"));
					$(".fixrilitmbg").fadeOut();
				})
				if(calendar.sourceType==8){
					//单日策略点击
					$(".yue_rili .yue_day li").click(function(){
						if($("#ykbackrl_"+$(this).attr("date")).text()=="可约"){
							$("#selectDate").text($(this).attr("date"));
							$(this).addClass("active").siblings().removeClass("active");
						}else{
							if($(this).attr("bool")=="true"){
								$("#selectDate").text($(this).attr("date"));
								$(this).addClass("active").siblings().removeClass("active");
							}else{
								$.alert("提示","请选择有效预约日期");
								return;
							}
						}
						
					})
				}

			}
		);
		//end   通过json改变日历
	}

	var getRevDayText =function(text,temp,tempData,count){
		var textIsRev="可约";

		if(calendar.sourceType==8){
			/*textIsRev= "<li class='future' date="+temp+">"+ i +"<br>"+" <span id=ykbackrl_"+temp+"  class='zt1'>"+textIsRev+"</span>"+"</li>";*/   //刘翀
			textIsRev= "<li class='future' date="+temp+">"+ i +"<br>"+" <span id=ykbackrl_"+temp+"  class='zt1'>"+textIsRev+"</span>"+"</li>"; //康良玉
			// " <span id=ykbackrl_"+temp+"  class='zt1'>"+textIsRev+"</span>";
			if(text=='2'){

				textIsRev="休息";
				textIsRev= "<li class='disfuture' date="+temp+">"+ i +"<br>"+"<span id=ykbackrl_"+temp+"  class='zt2'>"+textIsRev+"</span>"+"</li>";
				// "<span id=ykbackrl_"+temp+"  class='zt2'>"+textIsRev+"</span>";

			}
			else if(text=='3'){

				textIsRev="已满";
				textIsRev= "<li class='disfuture' date="+temp+">"+ i +"<br>"+"<span id=ykbackrl_"+temp+"  class='zt2'>"+textIsRev+"</span>"+"</li>";
				// textIsRev= "<span id=ykbackrl_"+temp+"  class='zt2'>"+textIsRev+"</span>";

			}
			else if(text=='4'){

				textIsRev="暂停";
				textIsRev= "<li class='disfuture' date="+temp+">"+ i +"<br>"+"<span id=ykbackrl_"+temp+"  class='zt2'>"+textIsRev+"</span>"+"</li>";
				// textIsRev= "<span id=ykbackrl_"+temp+"  class='zt2'>"+textIsRev+"</span>";
			}
			else if(text=='5'){

				textIsRev="假日";
				textIsRev= "<li class='disfuture' date="+temp+">"+ i +"<br>"+"<span id=ykbackrl_"+temp+"  class='zt2'>"+textIsRev+"</span>"+"</li>";
				// textIsRev= "<span id=ykbackrl_"+temp+"  class='zt2'>"+textIsRev+"</span>";
			}
			//如果是可约，并且是商户中心设置日历，则可以让其编辑

			if(text=='1'){

				textIsRev="可约";
				textIsRev= "<li class='future' date="+temp+">"+ i +"<br>"+" <span id=ykbackrl_"+temp+"  class='zt1'>"+textIsRev+"</span>"+"</li>";
				;
			}
		}else{
			textIsRev= "<li class='future' date="+temp+">"+ i +"<br>"+" <span id=ykbackrl_"+temp+"  class='zt1'>"+textIsRev+"</span>"+"</li>";
			// " <span id=ykbackrl_"+temp+"  class='zt1'>"+textIsRev+"</span>";
			if(text=='2'){

				textIsRev="休息";
				textIsRev= "<li class='disfuture' date="+temp+">"+ i +"<br>"+"<span id=ykbackrl_"+temp+"  class='zt2'>"+textIsRev+"</span>"+"</li>";
				// "<span id=ykbackrl_"+temp+"  class='zt2'>"+textIsRev+"</span>";

			}
			else if(text=='3'){

				textIsRev="已满";
				textIsRev= "<li class='disfuture' date="+temp+">"+ i +"<br>"+"<span id=ykbackrl_"+temp+"  class='zt2'>"+textIsRev+"</span>"+"</li>";
				// textIsRev= "<span id=ykbackrl_"+temp+"  class='zt2'>"+textIsRev+"</span>";

			}
			else if(text=='4'){

				textIsRev="暂停";
				textIsRev= "<li class='disfuture' date="+temp+">"+ i +"<br>"+"<span id=ykbackrl_"+temp+"  class='zt2'>"+textIsRev+"</span>"+"</li>";
				// textIsRev= "<span id=ykbackrl_"+temp+"  class='zt2'>"+textIsRev+"</span>";
			}
			else if(text=='5'){

				textIsRev="假日";
				textIsRev= "<li class='disfuture' date="+temp+">"+ i +"<br>"+"<span id=ykbackrl_"+temp+"  class='zt2'>"+textIsRev+"</span>"+"</li>";
				// textIsRev= "<span id=ykbackrl_"+temp+"  class='zt2'>"+textIsRev+"</span>";
			}
		}


		return textIsRev;
	}

	var chushirili =function(today,year,month,thisDay,startDay){
		//$(".shuchu").text(today+","+year+","+month+","+thisDay+","+startDay);
		$("#xlyear option").attr("selected",false);
		$("#xlyear option[id=y_"+year+"]").attr("selected",true);
		$("#xlmonth option").attr("selected",false);
		$("#xlmonth option[id=m_"+month+"]").attr("selected",true);

		var monthDays = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) monthDays[1] = 29;
		daysOfCurrentMonth = monthDays[today.getMonth()];
		$(".yue_rili .yue_day li").remove();
		for (i=0; i<startDay; i++) {$(".yue_rili .yue_day").append("<li></li>");}
		for (i=1; i<=daysOfCurrentMonth; i++) {
			$(".yue_rili .yue_day").append("<li class='over'>"+ i +"</li>");
		 }
		//beg
		//var currDate=year+"-"+month+"-"+thisDay;
		initRiData(year,month,thisDay,startDay);
		//end
	}
}
var calendar = new Calendar();
