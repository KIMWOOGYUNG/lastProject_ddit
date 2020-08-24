<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!-- fullCalendar -->
<link rel="stylesheet"
	href="${cPath }/resources/plugins/fullcalendar/main.min.css">
<link rel="stylesheet"
	href="${cPath }/resources/plugins/fullcalendar-daygrid/main.min.css">
<link rel="stylesheet"
	href="${cPath }/resources/plugins/fullcalendar-timegrid/main.min.css">
<link rel="stylesheet"
	href="${cPath }/resources/plugins/fullcalendar-bootstrap/main.min.css">
<style>
#calendar {
	max-width: auto;
	margin: 0 auto;
}

h2 {
	display: inline-block;
}
</style>
<section class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3">
				<div class="sticky-top mb-3">
					<!-- /.card -->
				</div>
			</div>
		</div>
		<!-- /.col -->
		<div class="col-md-12">
			<div class="card ">
				<div class="card-header">
					<div class="col-sm-12">
						<h2>${title }</h2>
						<button class="btn btn-info btn-sm float-right" id="goPageBtn"
						value=${title eq '근태현황'? '"attcheck"':'"writeApproval"' }
						>
						${title eq '근태현황'? '출퇴근체크':'휴가원 작성 바로가기' }
							<i class="fas fa-angle-double-right"></i> 
						</button>
					</div>
				</div>
				<div class="card-body p-0">

					<!-- THE CALENDAR -->
					<div id="calendar"></div>
				</div>
				<!-- /.card-body -->
			</div>
			<!-- /.card -->
		</div>
		<!-- /.col -->
	</div>
	<!-- /.row -->
</section>

<!-- fullCalendar 2.2.5 -->
<script src="${cPath }/resources/plugins/moment/moment.min.js"></script>
<script src="${cPath }/resources/plugins/fullcalendar/main.min.js"></script>
<script
	src="${cPath }/resources/plugins/fullcalendar-daygrid/main.min.js"></script>
<script
	src="${cPath }/resources/plugins/fullcalendar-timegrid/main.min.js"></script>
<script
	src="${cPath }/resources/plugins/fullcalendar-interaction/main.min.js"></script>
<script
	src="${cPath }/resources/plugins/fullcalendar-bootstrap/main.min.js"></script>
<script type="text/javascript">
// var eventArr = [];
var getAttList = function(){
	$.ajax({
		url:"${cPath}/mypage/${state}"
	   ,contentType: "application/x-www-form-urlencoded; charset=UTF-8"
	   ,type:"post"
	   ,success : function(mp){
		   //출근시간
// 		   let list = mp;
// 		   $.each(list, function(idx, item){
// 			   let myEvent = new Object();
// 			   myEvent.title = item.title;
// 			   myEvent.start = item.start;
// 			   myEvent.end = item.end;
// 			   myEvent.backgroundColor = item.color;
// 	           myEvent.borderColor = item.color;
// 			   eventArr.push(myEvent);
// 		   });
		   var calendarEl = document.getElementById('calendar');
		 //캘린더생성
		var calendar = new FullCalendar.Calendar(calendarEl, {
		 	plugins : [ 'interaction', 'dayGrid', 'timeGrid', 'list' ],
		 	header : {
		 		left : 'prev,next today',
		 		center : 'title',
		 		right : 'dayGridMonth,timeGridWeek,timeGridDay,listMonth'
		 	},
		 	navLinks : true, // can click day/week names to navigate views
		 	selectMirror : true,
		 	eventLimit : true,
		 	navLinks : true,
		 	events: mp,
		 	displayEventTime: false,
		 	editable  : false,
		 	allDay : false,
		 	height: 770
		 });
		 calendar.render();
	   }
	});	
}
getAttList();
$("#goPageBtn").on("click",function(){
	var temp = $("#goPageBtn").val();
	var url="";
	if(temp=='attcheck'){
  		var today = new Date();
  		//출근체크날짜구하기
	    var year = today.getFullYear();              //yyyy
	    var month = (1 + today.getMonth());          //M
	    month = month >= 10 ? month : '0' + month;  //month 두자리로 저장
	    var day = today.getDate();                   //d
	    day = day >= 10 ? day : '0' + day;          //day 두자리로 저장
	    var cws_code = year + '' + month + '' + day;       //'-' 추가하여 yyyy-mm-dd 형태 생성 가능
	    var todayStr = year +"년 "+month+"월 "+day+"일 ";
		//출근체크시간구하기
	    var hour = today.getHours();
	    var min = today.getMinutes();
	    var checkTime = hour + ""+ min;
			$.ajax({
				type : "POST"
				,url : "${cPath}/attCheck.do"
			 	,data:{cws_code:cws_code,checkTime:checkTime}
				,success:function(resp){
					alert(todayStr+resp);
				}
			});
	}else{
		//approvalWrite.approval
		location.href="${cPath}/approval/approvalwrite";
	}
	
	
});

</script>