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
  h2 {
    display: inline-block;
}
#content {padding: 30px;}
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
            <div class="card">
            <div class="card-header">
           <div class="col-sm-12">
            <h2>휴일 정보 등록</h2>
                    <button class="btn btn-info btn-sm float-right" id="addBtn">
		<i class="fas fa-pencil-alt"></i> 휴일등록	</button>
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
						<th>날짜</th>
						<td><input type="date" class="modalDate"></td>
					</tr>
					<tr>
						<th>휴일명</th>
						<td><input type="text" class="modalVacaName"></td>
					</tr>
					<tr>
						<th>근무기준</th>
						<td>
						<select class="modalStd">
						<c:if test="${not empty cwsCodes}">
							<c:forEach items="${cwsCodes }" var="cwsoption">
<%-- 								<c:set var="selected" --%>
<%-- 									value="${()cwsoption.standard_code eq  }"/> --%>
								<option value="${cwsoption.standard_code }">${cwsoption.standard_name }</option>
							</c:forEach>
						</c:if>	
						</select>
						</td>
					</tr>
					<tr id="reapet" hidden=true>
						<th>반복설정</th>
						<td>
						   <input type="radio" name="repeat" value="yearly"> 매년
     					   <input type="radio" name="repeat" value="noRepeat"> 반복없음
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
		$.ajax({
			url:"${cPath}/hr/att/holiday"
		   ,contentType: "application/x-www-form-urlencoded; charset=UTF-8"
		   ,type:"post"
		   ,success : function(mp){
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
			      events: mp,      
			      height: 770,
			      //아무것도 없는 날짜 클릭 했을 때 ->등록모달
			      select:  function(selectionInfo) {
				    	 editable();
				 		 modalVacaName.val('');
				 		 modalStd.val('');
						 $("#modalTitle").text('휴일정보등록');
						 $("#okBtn").text('등록');
						 modalDate.val(selectionInfo.startStr);
				         $('#calendarModal').modal();
				     },
			      //이미 있는 이벤트를 클릭했을 때 ->수정모달
			      eventClick: function(info) {
			    	  let date = info.event.start;
			    	  let stdName = info.event.id;
			    	  date = moment(date).format('YYYY-MM-DD');
			    	  diseditable();
			    	  $("#modalTitle").text('휴일정보수정');
			    	  $("#okBtn").text('삭제');
			    	  $(".modalDate").val(date);
			    	  $(".modalVacaName").val(info.event.title);
			    	  //select값 미리 세팅하기 
			    	  $(".modalStd").find("option").each(function(index){
			    		 if($(this).text()==stdName){
			    			 $(".modalStd").val($(this).val());
			    		 }
			    	  });
			    	  $('#calendarModal').modal();
			    	  }
			    });
			    calendar.render();
		   }
		});	
	
	
	//모달창 수정 가능/불가능
    var modalDate= $(".modalDate");
    var modalVacaName= $(".modalVacaName");
    var modalStd=  $(".modalStd");
    
	var diseditable = function(){ //숨기고 수정못하게 
		modalDate.attr('disabled',true);
		modalVacaName.attr('disabled',true);
		modalStd.attr('disabled',true);
		 $("#reapet").attr('hidden',true);
	}
	var editable = function(){ //보여주고 수정하게
		modalDate.attr('disabled',false);
		modalVacaName.attr('disabled',false);
		modalStd.attr('disabled',false);
		 $("#reapet").attr('hidden',false);
	}
	
	$("#addBtn").on("click",function(){
		modalDate.val('');
		modalVacaName.val('');
		modalStd.val('');
		editable();
		$("#modalTitle").text('휴일정보등록');
		$("#okBtn").text('등록');
		$('#calendarModal').modal();
	});
	
	//삭제 또는 등록
	$("#okBtn").on("click",function(){
		var cws_code =  $(".modalDate").val();//(yyyy-mm-dd)
		var cws_name = $(".modalVacaName").val();
		var standard_code = $(".modalStd").val();
		var repeat = $('input[name="repeat"]:checked').val();
		if($("#okBtn").text()=='삭제'){
			$("#okBtn").on("click",function(){
			if(confirm("정말 삭제하시겠습니까?")==true){
				var del = 'y'; //controller에서 null return
				$.ajax({
					type : "POST",
					url : "${cPath}/hr/att/holiday/delete",
					data : {
						cws_code : cws_code,
						standard_code : 'CWS100',
						repeat:repeat,
						del : del
					},
					success : function(resp) {
						alert($("#okBtn").text()+'되었습니다');
						$('#calendarModal').modal("hide");
						location.reload();
					}
				})//ajax
			}				
			});
		}
		if($("#okBtn").text()=='등록'){
		$.ajax({
			type : "POST",
			url : "${cPath}/hr/att/holiday/update",
			data : {
				cws_code : cws_code,
				cws_name : cws_name,
				standard_code : standard_code,
				repeat:repeat,
			},
			success : function(resp) {
				alert($("#okBtn").text()+'되었습니다');
				$('#calendarModal').modal("hide");
				location.reload();
			}
		})//ajax
		}
	});
	
	
</script>