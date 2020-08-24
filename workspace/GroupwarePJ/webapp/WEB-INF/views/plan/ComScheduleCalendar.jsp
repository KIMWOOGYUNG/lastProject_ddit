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
  .content {
	padding: 50px;
  }
  .imp {
  	font-weight:bold;
  }
  .container-fluid{
  	padding:0;
  }
  #content {
	padding: 50px;
  }
  .imp {
  	font-weight:bold;
  }
  h2{
  	display:inline;
  	margin-left:5px;
  }
  #tableBtn{
  	margin-left:20px;
  }
  #addSchedule{
  	float:right;
  	margin-right:8px;
  }
  
</style>
<div id="content">
	<h2>회사 일정 캘린더</h2>
    <input type="button" id="addSchedule" value="일정 등록" class="btn btn-info btn-sm" onclick="window.open('${cPath}/plan/editer', '회사 일정 등록', 'width=#, height=#')"  >
	
        
<!--         <button class="btn btn-info btn-sm" href="#" id="addBtn"> -->
<!-- 		<i class="fas fa-pencil-alt"></i>일정 등록</button> -->
        
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
        	
	        	<div>
		        	<button class="button showBtn" id="tableBtn"  onclick = "location.href = '${cPath}/plan/companyplan' ">
						<span class="oi oi-list icon"></span>
					</button>
	        	</div>
        	
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
						<th>카테고리</th>
							<td>
						<select class="modalCatag">
						<c:if test="${not empty comschedulenm}">
							<c:forEach items="${comschedulenm }" var="map">
								<option value="${map.standard_code }">${map.standard_name }</option>
							</c:forEach>
						</c:if>	
						</select>
						</td>
					</tr>
					<tr>
						<th>시작일</th>
						<td><input type="date" class="modalStartDate"></td>
					</tr>
					<tr>
						<th>종료일</th>
						<td><input type="date" class="modalEndDate"></td>
					</tr>
					<tr>
						<th>일정명</th>
						<td><input type="text" class="modalTitleName"></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><input type="text" class="modalWriter" name="emp_code" ></td>
					</tr>
					<tr>
						<th>중요도</th>
						<td>
						<select class="modalImport">
						<c:if test="${not empty comimportantnm}">
							<c:forEach items="${comimportantnm }" var="map">
								<option value="${map.standard_code }">${map.standard_name }</option>
							</c:forEach>
						</c:if>	
						</select>
						</td>
					</tr>
				</table>
			</div>
			<div class="modal-footer">
				<button type="button" id="okBtn" class="btn btn-primary mr-2">수정</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
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
	
	
	
	
 	//모달창 수정 가능/불가능
     var modalCatag= $(".modalCatag");
     var modalStartDate= $(".modalStartDate");
     var modalEndDate= $(".modalEndDate");
     var modalTitleName= $(".modalTitleName");
     var modalWriter=  $(".modalWriter");
     var modalImport=  $(".modalImport");
  
 	var diseditable = function(){ //숨기고 수정못하게 
 		$("#modalCatag").attr('hidden',true);
 		modalStartDate.attr('disabled',true);
 		modalEndDate.attr('disabled',true);
 		modalTitleName.attr('disabled',true);
 		modalWriter.attr('disabled',true);
 		$("#modalImport").attr('hidden',true);
 	}
 	var editable = function(){ //보여주고 수정하게
 		$("#modalCatag").attr('hidden',false);
 		modalStartDate.attr('disabled',false);
 		modalEndDate.attr('disabled',false);
 		modalTitleName.attr('disabled',false);
 		modalWriter.attr('disabled',false);
 		$("#modalImport").attr('hidden',false);
 	}
	
 	$("#addBtn").on("click",function(){
 		modalCatag.val('');
 		modalStartDate.val('');
 		modalEndDate.val('');
 		modalTitleName.val('');
 		modalWriter.val('');
 		modalImport.val('');
 		editable();
 		$("#modalTitle").text('회사 일정 등록');
 		$("#okBtn").text('등록');
 		$('#calendarModal').modal();
 	});
	
 	//수정 또는 등록
 	$("#okBtn").on("click",function(){
 		var cs_catag = $('input[name="modalCatag"]:checked').val();
 		var cs_startdate =  modalStartDate.val();//(yyyy-mm-dd)
 		var cs_enddate =  modalEndDate.val();//(yyyy-mm-dd)
 		var cs_title = modalTitleName.val();
 		var emp_kor = modalWriter.val();
 		var cs_important = $('input[name="modalImport"]:checked').val();
 		if($("#okBtn").text()=='삭제'){
 			$("#okBtn").on("click",function(){
 			if(confirm("정말 삭제하시겠습니까?")==true){
 				var del = 'y'; //controller에서 null return
 				$.ajax({
 					type : "POST",
 					url : "${cPath}/plan/complancalendar",  //삭제 url
 					data : {
 						cs_catag : cs_catag,
 						cs_important: cs_important,
 						del : del
 					},
 					success : function(resp) {
 						alert($("#okBtn").text()+'되었습니다');
 						$('#calendarModal').modal("hide");
 					}
 				})//ajax
 			}				
 			});
 		}
 		if($("#okBtn").text()=='등록'){
 		$.ajax({
 			type : "POST",
 			url : "${cPath}/plan/complancalendar", //업데이트 url
 			data : {
 				cs_catag : cs_catag,
 				cs_important: cs_important,
 			},
 			success : function(resp) {
 				alert($("#okBtn").text()+'되었습니다');
 				$('#calendarModal').modal("hide");
 			}
 		})//ajax
 		}
 	});
	
	
 	var eventArr = [];
 	var emp_kor = "";
 	var startdate = "";
 	var enddate = "";  
 	var title = "";
 	var content = "";
 	var catag = "";
 	var important = "";
 	
 	var getAttList = function(){
 		$.ajax({
 			url:"${cPath}/plan/complancalendar"
 		   ,contentType: "application/x-www-form-urlencoded; charset=UTF-8"
 		   ,type:"post"
 		   ,success : function(mp){
 			   console.log(mp);
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
 			      height: 750,
 			      allDay : false,
 			      events: mp,
 			      //아무것도 없는 날짜 클릭 했을 때 ->등록모달
 			      select:  function(selectionInfo) {
 			    	        console.log(selectionInfo);
 			    	       selectionInfo.end.setDate(selectionInfo.end.getDate()-1);
 			    	       
 			    	        console.log(selectionInfo.end.toLocaleDateString());
 			    	        date = new Date(selectionInfo.end.toLocaleDateString()); 
 			    	       var year = date.getFullYear();              //yyyy
 			    	      var month = (1 + date.getMonth());          //M
 			    	      month = month >= 10 ? month : '0' + month;  //month 두자리로 저장
 			    	      var day = date.getDate();                   //d
 			    	      day = day >= 10 ? day : '0' + day;          //day 두자리로 저장
 			    	  startdate = selectionInfo.startStr;
			    	  enddate = year + '-' + month + '-' + day;
//  				    	 editable();
//  				    	modalCatag.val('');
//  				 		modalStartDate.val('');
//  				 		modalEndDate.val('');
//  				 		modalTitleName.val('');
//  				 		modalWriter.val('${authUser.emp_kor}');
//  				 		modalImport.val('');
//  						 $("#modalTitle").text('회사 일정 등록');
//  						 $("#okBtn").text('등록');
//  						modalStartDate.val(selectionInfo.startStr);
//  						modalEndDate.val(selectionInfo.startStr);
//  				         $('#calendarModal').modal();
    openWin = window.open("${cPath}/plan/editer","",'top=0, left=0, width=800, height=556, directories=no, location=no, menubar=no, resizable=no, status=yes, toolbar=no');
 				     },
 			      //이미 있는 이벤트를 클릭했을 때 ->수정모달
 			      eventClick: function(info) {console.log(info);
//  			    	  let startdate = info.event.start;
//  			    	  let enddate = info.event.end;
//  			    	  let emp_kor = info.event.id;  //작성자
//  			    	  startdate = moment(startdate).format('YYYY-MM-DD');
//  			    	  enddate = moment(enddate).format('YYYY-MM-DD');
//  			    	  diseditable();
//  			    	  $(".modalCatag").find("option").each(function(index){
//  				    		 if($(this).text()==emp_kor){
//  				    			 $(".modalCatag").val($(this).val());
//  				    		 }
//  				    	  });
//  			    	  $("#modalTitle").text('회사 일정 수정');
//  			    	  $("#okBtn").text('삭제');
//  			    	  $(".modalWriter").val(emp_kor);
//  			    	  $(".modalStartDate").val(startdate);
//  			    	  $(".modalEndDate").val(enddate);
//  			    	  $(".modalTitleName").val(info.event.title);
//  			    	  $(".modalImport").find("option").each(function(index){
//  				    		 if($(this).text()==emp_kor){
//  				    			 $(".modalImport").val($(this).val());
//  				    		 }
//  				    	  });
//  			    	  $('#calendarModal').modal();
     			    content = info.event.extendedProps.content;
					  emp_kor = info.event.id;
     			      startdate = info.event.start;
     			     startdate = moment(startdate).format('YYYY-MM-DD');
     			     enddate = info.event.end;
     			    enddate = moment(enddate).format('YYYY-MM-DD');
 			    	  title = info.event.title;
 			    	  catag = info.event.extendedProps.cs_catag;
 			    	  important = info.event.extendedProps.cs_important;
 			    	  
 			    	  
 			    	 openWin = window.open("${cPath}/plan/editer","",'top=0, left=0, width=800, height=556, directories=no, location=no, menubar=no, resizable=no, status=yes, toolbar=no');
 			    	  }
 			    });
 			    calendar.render();
 		   }
 		});	
 	}
 	getAttList();
	
	

	
	
 </script>




















