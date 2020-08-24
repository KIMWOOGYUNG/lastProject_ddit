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
     <h2>내 일정 캘린더</h2>
     <input type="button" id="addSchedule" value="일정등록" class="btn btn-info btn-sm" onclick="window.open('${cPath}/plan/msediter', '내일정등록', 'width=#, height=#')"> 
        
<!--         <button class="btn btn-info btn-sm" href="#" id="addBtn"> -->
<!-- <i class="fas fa-pencil-alt"></i>일정등록</button> -->
      <div class="container-fluid">
		<div class="row">
	        <div class="col-md-3">
	          <div class="sticky-top mb-3">
	            <!-- /.card -->
	          </div>
	        </div>
	     </div>
	  </div> 
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
				<div class="button showBtn" id="tableBtn"  data-target="#addressTable" onclick = "location.href = '${cPath}/plan/myplanbox/${type2}' ">
					<span class="oi oi-list icon"></span>
				</div>	
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
      

<!-- 모달-->
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
<c:if test="${not empty myimportantnm}">
<c:forEach items="${myimportantnm }" var="map">
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




 //모달창수정가능/불가능
     var modalStartDate= $(".modalStartDate");
     var modalEndDate= $(".modalEndDate");
     var modalTitleName= $(".modalTitleName");
     var modalWriter=  $(".modalWriter");
     var modalImport=  $(".modalImport");
  
 var diseditable = function(){ //숨기고수정못하게
 modalStartDate.attr('disabled',true);
 modalEndDate.attr('disabled',true);
 modalTitleName.attr('disabled',true);
 modalWriter.attr('disabled',true);
 $("#modalImport").attr('hidden',true);
 }
 var editable = function(){ //보여주고수정하게
 modalStartDate.attr('disabled',false);
 modalEndDate.attr('disabled',false);
 modalTitleName.attr('disabled',false);
 modalWriter.attr('disabled',false);
 $("#modalImport").attr('hidden',false);
 }

 $("#addBtn").on("click",function(){
 modalStartDate.val('');
 modalEndDate.val('');
 modalTitleName.val('');
 modalWriter.val('');
 modalImport.val('');
 editable();
 $("#modalTitle").text('내일정등록');
 $("#okBtn").text('등록');
 $('#calendarModal').modal();
 });

 //수정또는등록
 $("#okBtn").on("click",function(){
 var del = ''
 var ms_startdate =  modalStartDate.val();//(yyyy-mm-dd)
 var ms_enddate =  modalEndDate.val();//(yyyy-mm-dd)
 var ms_title = modalEndDate.val();
 var standard_code = modalTitleName.val();
 var emp_code = modalWriter.val();
 var ms_important = $('input[name="modalImport"]:checked').val();
 if($("#okBtn").text()=='삭제'){
 $("#okBtn").on("click",function(){
 if(confirm("정말 삭제하시겠습니까")==true){
 var del = 'y' //controller에서null return
 $.ajax({
 type : "POST",
 url : "${cPath}/plan/myplancalendar",  //삭제url
 data : {
 ms_important: modalImport,
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
 url : "${cPath}/plan/myplancalendar", //업데이트url
 data : {
 ms_important: modalImport,
 del : del
 },
 success : function(resp) {
 alert($("#okBtn").text()+'되었습니다');
 $('#calendarModal').modal("hide");
 }
 })//ajax
 }
 });


 var eventArr = [];
 var startdate = ""
 var enddate = ""  
 var title = ""
 var emp_kor = ""
 var content = ""
 var important = ""
 
 var getAttList = function(){
 $.ajax({
 url:"${cPath}/plan/myplancalendar/${type}"
 ,contentType: "application/x-www-form-urlencoded; charset=UTF-8"
 ,type:"post"
 ,success : function(mp){
 //console.log(mp);
 
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
 events: mp,      //아무것도없는날짜클릭했을때->등록모달
  select:  function(selectionInfo) {
  console.log(selectionInfo);
selectionInfo.end.setDate(selectionInfo.end.getDate()-1);

console.log(selectionInfo.end.toLocaleDateString());
date = new Date(selectionInfo.end.toLocaleDateString()); 
var year = date.getFullYear();              //yyyy
var month = (1 + date.getMonth());          //M
month = month >= 10 ? month : '0' + month;  //month 두자리로저장
var day = date.getDate();                   //d
day = day >= 10 ? day : '0' + day;          //day 두자리로저장

startdate = selectionInfo.startStr;
enddate = year + '-' + month + '-' + day;
//  editable();
//  modalTitleName.val('');
//  modalImport.val('');
//  $("#modalTitle").text('내일정등록');
//  $("#okBtn").text('등록');
//  modalStartDate.val(selectionInfo.startStr);
//  modalEndDate.val(selectionInfo.startStr);
//  $('#calendarModal').modal();

  window.open("${cPath}/plan/msediter","",'top=0, left=0, width=800, height=556, directories=no, location=no, menubar=no, resizable=no, status=yes, toolbar=no')  ;   
  },
 //이미있는이벤트를클릭했을때->수정모달
 eventClick: function(info) {
//  console.log(info);
//  let startdate = info.event.start;
//  let enddate = info.event.end;
//  let emp_kor = info.event.id;
//  let project_name = info.event._def.extendedProps.projectnm;
//  startdate = moment(startdate).format('YYYY-MM-DD');
//  enddate = moment(enddate).format('YYYY-MM-DD');
//  diseditable();
//  $("#modalTitle").text('내일정수정');
//  $("#okBtn").text('삭제');
//  $(".modalWriter").val(emp_kor);
//  $(".modalStartDate").val(startdate);
//  $(".modalEndDate").val(enddate);
//  $(".modalTitleName").val(info.event.title);
//  $(".modalProject").val(project_name);
//  $(".modalImport").find("option").each(function(index){
//  if($(this).text()==emp_kor){
//  $(".modalImport").val($(this).val());
//  }
//  });
//  $('#calendarModal').modal();
 console.log(info);
 content = info.event.extendedProps.content;
emp_kor = info.event.id;
     startdate = info.event.start;
     startdate = moment(startdate).format('YYYY-MM-DD');
     enddate = info.event.end;
     enddate = moment(enddate).format('YYYY-MM-DD');
 title = info.event.title;
 important = info.event.extendedProps.ms_important;
 
 
 
 
 window.open("${cPath}/plan/msediter","",'top=0, left=0, width=800, height=556, directories=no, location=no, menubar=no, resizable=no, status=yes, toolbar=no')  ;   
 }
 });
 calendar.render();
 }
 });
 }
 getAttList();





 </script>




















