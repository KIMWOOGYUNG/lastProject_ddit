<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!-- <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"> -->
<!-- <script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script> -->


<link href="${cPath }/resources/css/adminlte.min.css">
<link href="${cPath }/resources/css/adminlte.plugins.min.css">
<script src="${cPath }/resources/js/dashboard.js"></script>




<style type="text/css">	
	/* banner */
	.banner {position: relative; width: 600px; height: 300px; top: 50px;  margin:0 auto; padding:0; overflow: hidden;}
	.banner ul {position: absolute; margin: 0px; padding:0; list-style: none; }
	.banner ul li {float: left; width: 600px; height: 300px; margin:0; padding:0;}

</style>

  <!-- fullCalendar -->
  <link rel="stylesheet" href="${cPath }/resources/plugins/fullcalendar/main.min.css">
  <link rel="stylesheet" href="${cPath }/resources/plugins/fullcalendar-daygrid/main.min.css">
  <link rel="stylesheet" href="${cPath }/resources/plugins/fullcalendar-timegrid/main.min.css">
  <link rel="stylesheet" href="${cPath }/resources/plugins/fullcalendar-bootstrap/main.min.css">

<script src="//www.google-analytics.com/analytics.js"></script>
<script src="${cPath }/resources/plugins/chart.js/Chart.min.js"></script>
<script src="${cPath}/resources/plugins/chart.js/Chartutil.js"></script>
<style>
canvas {
	-moz-user-select: none;
	-webkit-user-select: none;
	-ms-user-select: none;
}

.emp_img {
	width:40px; 
	height:45px; 
	border-radius:50%;

.box{
	cursor:move;
}
}
</style>
<style type="text/css">/* Chart.js */
@keyframes chartjs-render-animation{from{opacity:.99}to{opacity:1}}.chartjs-render-monitor{animation:chartjs-render-animation 1ms}.chartjs-size-monitor,.chartjs-size-monitor-expand,.chartjs-size-monitor-shrink{position:absolute;direction:ltr;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1}.chartjs-size-monitor-expand>div{position:absolute;width:1000000px;height:1000000px;left:0;top:0}.chartjs-size-monitor-shrink>div{position:absolute;width:200%;height:200%;left:0;top:0}</style>


    <!-- Content Header (Page header) -->
    <div class="content-header">
<!--       <div class="container-fluid"> -->
<!--         <div class="row mb-2"> -->
<!--           <div class="col-sm-6"> -->
<!--             <h1 class="m-0 text-dark">메인입니다</h1> -->
<!--           </div>/.col -->
<!--           <div class="col-sm-6"> -->
<!--             <ol class="breadcrumb float-sm-right"> -->
<!--               <li class="breadcrumb-item"><a href="#">Home</a></li> -->
<!--               <li class="breadcrumb-item active">Dashboard v1</li> -->
<!--             </ol> -->
<!--           </div>/.col -->
<!--         </div>/.row -->
<!--       </div>/.container-fluid -->
    </div>
    <!-- /.content-header -->

<!-- 	<div class="content-header"> -->
	
<!-- 	</div> -->

    <!-- Main content -->
    <section class="content">
    	<div class = "container-fluid">
	 		<div class="row">
				<!-- 롤링 배너 -->
				<div class="aa" style="display: inline; float: left; margin-left: 15px">
	          		<div class="banner" style="top: 0px; border-radius: 7px;">
	            		<ul>
						<li><img src="${cPath }/resources/images/Ideology.png" width=600px height="300px"></li>
						<li><img src="${cPath }/resources/images/banner.jpg" width="600px" height="300px"></li>
						<li><img src="${cPath }/resources/images/cro.png" width="600px" height="300px"></li>
						<li><img src="${cPath }/resources/images/banner2.jpg" width="600px" height="300px"></li>
						<li><img src="${cPath }/resources/images/banner3.jpg" width="600px" height="300px"></li>
						<li><img src="${cPath }/resources/images/banner5.jpg" width="600px" height="300px"></li>
					</ul>
	          		</div>
	          	</div>
	        		
	        	<!-- 결재(기안서 작성), 일일업무일지 작성 바로가기 아이콘 -->
	        	<div class="bb" style="display: inline; float: left;">
		           	<a class="btn btn-app" style="width: 220px; height: 300px; background-color: white;  border-radius: 7px;" href="${cPath }/approval/approvalwrite">
			        	<img src="${cPath }/resources/images/content2.png" style="width: 200px; height: 210px;"><br><br><br>기안서 작성
			        </a>
		           	<a class="btn btn-app" style="width: 220px; height: 300px; background-color: white;  border-radius: 7px; margin: 0 0 10px 5px;" href="${cPath }/work/mywork/insertdiary/daydiary">
			            <img src="${cPath }/resources/images/content.png" style="width: 200px; height: 210px;"><br><br><br>일일업무일지 작성
			        </a>
		        </div>
		        
		        <!-- 내 근태현황 (통계) barchart -->
		        <div class="card" style="display: inline; float: left; margin:0px 0px 0px 10px; height: 295px;">
					<div id="container" style="width: 54%; height: 295px" onclick="myattCal()">
						<div class="chartjs-size-monitor">
							<div class="chartjs-size-monitor-expand">
								<div class=""></div>
							</div>
							<div class="chartjs-size-monitor-shrink">
								<div class=""></div>
							</div>
						</div>
						<canvas id="canvas" style="display: block; " width="1000" height="450" class="chartjs-render-monitor"></canvas>
					</div>
				</div>
			</div>
		
<!-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->

		<!-- 왼쪽섹션 -->
		<div class="row">
			<section class="container col-lg-7 connectedSortable ui-sortable">
			
				<!-- 공지사항 -->
				<div class="card">
					<div class="card-header ui-sortable-handle" style="cursor: move;">
						<h3 class="card-title">
							<ion-icon name="megaphone-outline"></ion-icon> 공지사항
						</h3>
					</div>
					<!-- /.card-header -->
					<div class="card-body">
						<div class="tab-content p-0">
							<!-- Morris chart - Sales -->
							<div class="chart tab-pane active" id="revenue-chart"
								style="position: relative; height: 300px;">
								<table class="table table-hover text-nowrap">
									<thead>
										<tr>
											<th>#</th>
											<th>제목</th>
											<th>작성일</th>
											<th>조회수</th>
										</tr>
									</thead>
									<tbody>
										<c:choose>
											<c:when test="${not empty NoticeList }">
												<c:forEach items="${NoticeList }" var="notice">
													<tr>
														<td>${notice.rnum }</td>
														<td><a
															href="${cPath }/board/boardList/boardView/${notice.board_code}/${notice.board_catag}">${notice.board_title }</a></td>
														<td>${notice.board_date }</td>
														<td>${notice.board_hit }</td>
													</tr>
												</c:forEach>
											</c:when>
										</c:choose>
									</tbody>
								</table>

							</div>
						</div>
						<!-- /.card-body -->
					</div>
				</div>



				<!-- 내 프로젝트 -->
				<div class="card" style="position: relative; left: 0px; top: 0px;">
					<div class="card-header ui-sortable-handle" style="cursor: move;">
						<h3 class="card-title">
							<i class="ion ion-clipboard mr-1"></i> 내 프로젝트
						</h3>
					</div>


					<c:choose>
						<c:when test="${project ne null }">
							<!-- /.card-header -->
							<div class="card-body">
								<p>
									<b>${project.project_name }</b>
								</p>
								<c:if test="${not empty project.pj_rgroupList}">
									<c:forEach items="${project.pj_rgroupList}" var="pj_rgroup">
										<c:set var="prCode" value="${pj_rgroup.pr_code}" />
										<c:forEach items="${pj_rgroup.pj_memberList }" var="pj_member">
											<c:if test="${not empty prCode}">
												<li class="list-inline-item"
													style="display: inline; margin-right: 30px;">
													<div
														style="display: inline; float: left; width: 50px; height: 90px; margin: 10px">
														<img alt="" class="emp_img"
															src="${cPath }/approval/download/emp/${pj_member.emp_attcode}">
														<p>${pj_member.emp_kor }<br>&nbsp;&nbsp;&nbsp;${pj_rgroup.pr_name }
														</p>
													</div>
												</li>
											</c:if>
										</c:forEach>
									</c:forEach>
								</c:if>


								<div>
									<div class="progress progress" style="width: 100%;">
										<div class="progress-bar bg-blue" role="progressbar"
											aria-volumenow="44" aria-volumemin="0" aria-volumemax="100"
											style="width: ${project.project_progress}%">${project.project_progress}%</div>
									</div>
								</div>
							</div>
							<!-- /.card-body -->

						</c:when>
						<c:otherwise>
							<div class="card-body">진행중인 프로젝트가 없습니다.</div>
						</c:otherwise>
					</c:choose>
					<div class="card-footer clearfix">
						<button type="button" class="btn btn-info float-right" onclick="myproject()">
							자세히</button>
					</div>
				</div>

			</section>

			<!-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->

			<!-- 오른쪽 섹션 -->
			<section class="col-lg-5 connectedSortable ui-sortable">

				<!-- 내 일정 달력 -->
				<div class="card">
					<div class="card-header ui-sortable-handle" style="cursor: move;">
						<h3 class="card-title">
							<ion-icon name="calendar-outline"></ion-icon> 내 일정
						</h3>
					</div>
					<div class="card-body" onclick = "mycal()">
						<div id="calendar"></div>
					</div>
					<!-- /.card-body-->
				</div>

			</section>
			<!-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->

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

			<script>
		// 롤링 배너
		var banner = $(".banner").find("ul");

		var bannerWidth = banner.children().outerWidth();//이미지의 폭
		var bannerHeight = banner.children().outerHeight(); // 높이
		var length = banner.children().length;//이미지의 갯수
		var rollingId;

		//정해진 초마다 함수 실행
		rollingId = setInterval(function() { rollingStart(); }, 4000);//다음 이미지로 롤링 애니메이션 할 시간차
    
		function rollingStart() {
			banner.css("width", bannerWidth * length + "px");
			banner.css("height", bannerHeight + "px");
			//alert(bannerHeight);
			//배너의 좌측 위치를 옮겨 준다.
			banner.animate({left: - bannerWidth + "px"}, 2000, function() { //숫자는 롤링 진행되는 시간이다.
				//첫번째 이미지를 마지막 끝에 복사(이동이 아니라 복사)해서 추가한다.
				$(this).append("<li>" + $(this).find("li:first").html() + "</li>");
				//뒤로 복사된 첫번재 이미지는 필요 없으니 삭제한다.
				$(this).find("li:first").remove();
				//다음 움직임을 위해서 배너 좌측의 위치값을 초기화 한다.
				$(this).css("left", 0);
				//이 과정을 반복하면서 계속 롤링하는 배너를 만들 수 있다.
			});
		}
//---------------------------------------------------------------------------------------------------------------------------------------------------------------
		// 근태관리 바차트
		var nomal = ${nomal};
		var late = ${late};
		console.log(nomal);
		console.log(late);
		var color = Chart.helpers.color;
		var barChartData = {
			labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
			datasets: [{
				label: '정상출근',
				backgroundColor: color(window.chartColors.blue).alpha(0.5).rgbString(),
				borderColor: window.chartColors.blue,
				borderWidth: 1,
				data: nomal
			}, {
				label: '지각',
				backgroundColor: color(window.chartColors.red).alpha(0.5).rgbString(),
				borderColor: window.chartColors.red,
				borderWidth: 1,
				data:late
				
			}]

		};

		window.onload = function() {
			var ctx = document.getElementById('canvas').getContext('2d');
			window.myBar = new Chart(ctx, {
				type: 'bar',
				data: barChartData,
				options: {
					responsive: true,
					legend: {
						position: 'top',
					},
					title: {
						display: true,
					}
				}
			});

		};
//----------------------------------------------------------------------------------------------------------------------------------------------
	// 내일정
	var eventArr = [];
 	var startdate = "";
 	var enddate = "";  
 	var title = "";
 	var emp_kor = "";
 	var content = "";
 	var important = "";
 	
 	var getAttList = function(){
 		$.ajax({
 			url:"${cPath}/plan/myplancalendar/all"
 		   ,contentType: "application/x-www-form-urlencoded; charset=UTF-8"
 		   ,type:"post"
 		   ,success : function(mp){
 			   //console.log(mp);
 			   //출근시간
 			   var calendarEl = document.getElementById('calendar');
 			    var calendar = new FullCalendar.Calendar(calendarEl, {
 			      plugins: [ 'interaction', 'dayGrid', 'timeGrid', 'list','interactionPlugin' ],
 			      header: {
 			        left: 'prev,next today',
 			        center: 'title',
 			        right: 'dayGridMonth,timeGridWeek,timeGridDay,listMonth'
 			      },
 			      navLinks: true, // can click day/week names to navigate views
 			      businessHours: true, // display business hours
 			      selectable: true,
 			      selectMirror: true,
 			      eventLimit: true,
 			      navLinks: true,
 			      displayEventTime: false,
			      allDay : false,
 			      events: mp      //아무것도 없는 날짜 클릭 했을 때 ->등록모달
  			     
 			      
 			    });
 			    calendar.render();
 		   }
 		});	
 	}
 	getAttList();
 	
 	
//---------------------------------------------------------------------------------------------------------------------------------------------
	// 근태 통계 들어가기
	function myattCal(){
		location.href = "${cPath}/mypage/myAttCalendar";
	}
//---------------------------------------------------------------------------------------------------------------------------------------------
	// 내 프로젝트 들어가기
	function myproject(){
		location.href = "${cPath}/project/projectlist/my";
	}

//---------------------------------------------------------------------------------------------------------------------------------------------
	// 내일정 들어가기
	function mycal(){
		location.href = "${cPath}/plan/myplancalendar/all "
	}
//---------------------------------------------------------------------------------------------------------------------------------------------



	$(function(){
		let valUP = getCookie('popUP');
	
		if( valUP ==  null){		
			window.open('${cPath}/noticePopUp','공지사항','width=795, height=610, location=no,toolbar=no, menubar=no, scrollbars=no');
		}

	})
	

	 function getCookie(name) {
			var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
			return value? value[2] : null;
	};
</script>