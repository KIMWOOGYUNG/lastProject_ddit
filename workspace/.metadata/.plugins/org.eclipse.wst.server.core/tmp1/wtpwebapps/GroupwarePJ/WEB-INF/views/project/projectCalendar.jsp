<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

	
  <!-- fullCalendar -->
  <link rel="stylesheet" href="${cPath }/resources/plugins/fullcalendar/main.min.css">
  <link rel="stylesheet" href="${cPath }/resources/plugins/fullcalendar-daygrid/main.min.css">
  <link rel="stylesheet" href="${cPath }/resources/plugins/fullcalendar-timegrid/main.min.css">
  <link rel="stylesheet" href="${cPath }/resources/plugins/fullcalendar-bootstrap/main.min.css">
<style>
  #calendar {
    max-width: auto;
    margin: 0 auto;
  } 
  #content {
	padding: 50px;
  }
  .imp {
  	font-weight:bold;
  }
  .container-fluid{
  	padding:0;
  }
  .btnMove{
  	float:right;
  	margin-right:8px;
  }
  h2{
  	display:inline;
  }
</style>
<div id="content">
	<h2>일감 캘린더</h2>
	<button class="btnMove btn btn-primary" onclick="location.href='${cPath}/project/newTask/myTask/${project_code }'">일감 등록</button>
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
          <div class="card card-primary">
            <div class="card-body p-0">
            	<section class="content-header">
					<div class="container-fluid">
						<span class="imp">중요도</span> &nbsp;
						<span class="oi oi-minus text-danger"></span>&nbsp;<span>높음</span>&nbsp;&nbsp;
						<span class="oi oi-minus text-warning"></span>&nbsp;<span>중간</span>&nbsp;&nbsp;
						<span class="oi oi-minus text-info"></span>&nbsp;<span>낮음</span>
					</div>
				</section>
              <!-- THE CALENDAR -->
              <div id="calendar">
              </div>
            </div>
            <!-- /.card-body -->
          </div>
          <!-- /.card -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
</div>
<!-- 모달 -->
<div id="calendarModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 id="modalTitle" class="modal-title"></h4>
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">×</span> <span class="sr-only">close</span>
				</button>
			</div>
			<div class="modal-body">
				<table class="table table-bordered" id="modal">
					<tr>
						<th>일감명</th>
						<td><input type="text" class="modalTaskName"></td>
					</tr>
					<tr>
						<th>담당자</th>
						<td><input type="text" class="modalEmp"></td>
					</tr>
					<tr>
						<th>시작일</th>
						<td><input type="date" class="modalStart"></td>
					</tr>
					<tr>
						<th>종료일</th>
						<td><input type="date" class="modalEnd"></td>
					</tr>
					<tr>
						<th>진척도</th>
						<td><input type="text" class="modalProgress"></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>
<!-- fullCalendar 2.2.5 -->
<script src="${cPath }/resources/plugins/moment/moment.min.js"></script>
<script src="${cPath }/resources/plugins/fullcalendar/main.min.js"></script>
<script src="${cPath }/resources/plugins/fullcalendar-daygrid/main.min.js"></script>
<script src="${cPath }/resources/plugins/fullcalendar-timegrid/main.min.js"></script>
<script src="${cPath }/resources/plugins/fullcalendar-interaction/main.min.js"></script>
<script src="${cPath }/resources/plugins/fullcalendar-bootstrap/main.min.js"></script>
	
<script>
	
	//모달창 클래스
	var modalTaskName= $(".modalTaskName");
	var modalEmp= $(".modalEmp");
	var modalStart= $(".modalStart");
	var modalEnd= $(".modalEnd");
	var modalProgress=  $(".modalProgress");
	
	var setting = function(){ 
		modalTaskName.attr('disabled',true);
		modalEmp.attr('disabled',true);
		modalStart.attr('disabled',true);
		modalEnd.attr('disabled',true);
		modalProgress.attr('disabled',true);
	}

	var getTaskList = function(){
		$.ajax({
			url:"${cPath}/project/projectplan/${project_code}/calendar"
		   ,contentType: "application/x-www-form-urlencoded; charset=UTF-8"
		   ,type:"post"
		   ,success : function(mp){
			   var calendarEl = document.getElementById('calendar');
			    var calendar = new FullCalendar.Calendar(calendarEl, {
			      plugins: [ 'interaction', 'dayGrid', 'timeGrid', 'list','interactionPlugin'],
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
			      height: 770,
			      editable: true,
			      droppable: true,
			      draggable: true,
			      events: mp,
 			      //일정 클릭시
			      eventClick: function(info) {
			    	  console.log(info);
			    	  let name = info.event.title;
			    	  let start = info.event.start;
			    	  let end = info.event.end;
			    	  let emp = info.event._def.extendedProps.emp;
			    	  let progress = info.event._def.extendedProps.progress;
			    	  start = moment(start).format('YYYY-MM-DD');
			    	  end = moment(end).format('YYYY-MM-DD');
			    	  setting();
			    	  $("#modalTitle").text('일감 상세정보');
			    	  $("#okBtn").text('삭제');
			    	  $(".modalTaskName").val(name);
			    	  $(".modalEmp").val(emp);
			    	  $(".modalStart").val(start);
			    	  $(".modalEnd").val(end);
			    	  $(".modalProgress").val(progress);
			    	  $('#calendarModal').modal();
			      },
			    	  
			      //이벤트 드롭시
		    	  eventDrop: function(info, oldEvent) { 
		    		  let id = info.event.id;
		    		  let start = info.event.start;
		    		  let end = info.event.end;
		    		  start = moment(start).format('YYYY-MM-DD');
		    		  end = moment(end).format('YYYY-MM-DD');
			    	  console.log(info.event.title + " was moved "); 
			    	  
			    	  if (!confirm("'" + info.event.title + "'의 일정을 수정하시겠습니까?")) { 
			    		  info.revert();
			    		  alert("일정 변경을 취소하였습니다.");
			    	  }else{
				    	  $.ajax({
				    		 url : "${cPath}/project/projectplan/${project_code}/updateCalendar",
				    		 type : "POST",
				    		 data : {
				    			 task_code : id,
				    			 task_start : start,
				    			 task_end : end
				    		 },
				    		 dataType : "html",
				    		 success : function(resp){
				    			 alert(resp);
				    		 }
				    	  });
			    		  
			    	  }
			      },
			      
			    //이벤트 리사이징
			    eventResize: function (info) {
			    	let id = info.event.id;
					let start = info.event.start;
					let end = info.event.end;
					start = moment(start).format('YYYY-MM-DD');
					end = moment(end).format('YYYY-MM-DD');
					console.log(info.event.title + " was moved "); 
					
			        if (!confirm("'" + info.event.title + "'의 일정을 수정하시겠습니까?")) { 
			    		info.revert();
			    		alert("일정 변경을 취소하였습니다.");
			    	}else{
				        $.ajax({
				    		 url : "${cPath}/project/projectplan/${project_code}/updateCalendar",
				    		 type : "POST",
				    		 data : {
				    			 task_code : id,
				    			 task_start : start,
				    			 task_end : end
				    		 },
				    		 dataType : "html",
				    		 success : function(resp){
				    			 alert(resp);
				    		 }
				    	});
			    	}
		    	  
			    }
			      
			    });
			    calendar.render();
		   }
		});	
	}
	getTaskList();
	
</script>