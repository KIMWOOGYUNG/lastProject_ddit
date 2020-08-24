<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
  <!-- DataTables -->
  <link rel="stylesheet" href="${cPath }/resources/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="${cPath }/resources/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
  <link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.6.2/css/buttons.dataTables.min.css    ">
<style>
	#content {padding: 30px;}
</style>
<!-- <section class="content-header"> -->
<!--       <div class="container-fluid"> -->
<!--         <div class="row mb-2"> -->
<!--           <div class="col-sm-6"> -->
<!--             <h1>월별 근태 현황</h1> -->
<!--           </div> -->
<!--         </div> -->
<!--       </div>/.container-fluid -->
<!-- </section> -->
<section class="content">
	<div class="container-fluid" id="content">
		<div class="row">
			<div class="col-12">
				<!-- 없애면안됨 -->
					<div class="card">
						<div class="card-header">
						<h2>월별 근태 현황</h2>
						<button class="btn btn-info btn-sm float-right" id="restBtn">초기화</button>
							<button class="btn btn-primary btn-sm float-right" id="searchBtn1">조회</button>
							<select class="dynamicElement form-control float-right" id="selectedMonth"	name="selectedMonth"><!-- 동적생성 -->	</select>
							<select class="dynamicElement form-control float-right" id="selectedYear" name="selectedYear"><!-- 동적생성 --></select>
						</div>
						<!-- /.card-header -->
						<div class="card-body">
							<div id="myTable_wrapper"
								class="dataTables_wrapper dt-bootstrap4">
								<div class="col-12">
									<table id="myTable" class="table table-hover"	cellspacing="0" width="100%">
										<thead>
											<tr>
												<th>연도</th>
												<th>월</th>
												<th>부서</th>
												<th>사원번호</th>
												<th>사원명</th>
												<th>직급</th>
												<th>정상출근</th>
												<th>휴무일</th>
												<th>휴가</th>
												<th>지각</th>
												<th>결근</th>
												<th>공가</th>
												<th>병가</th>
											</tr>
										</thead>
									</table>
								</div>
							</div>
						</div>
						<!-- /.card-body -->
					</div>
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container-fluid -->
</section>

<!-- DataTables -->
<script src="${cPath }/resources/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${cPath }/resources/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="${cPath }/resources/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="${cPath }/resources/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>

<script src="https://cdn.datatables.net/buttons/1.6.2/js/dataTables.buttons.min.js   "></script>
<script src="https://cdn.datatables.net/buttons/1.6.2/js/buttons.flash.min.js        "></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js         "></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js    "></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js      "></script>
<script src="https://cdn.datatables.net/buttons/1.6.2/js/buttons.html5.min.js        "></script>
<script src="https://cdn.datatables.net/buttons/1.6.2/js/buttons.print.min.js        "></script>
<!-- dynamicSelect -->
<script type="text/javascript" src="${cPath }/resources/js/dynamicSelect.js?time=${System.currentTimeMillis()}"></script>
<script type="text/javascript">
//연도, 월 세팅 (오늘 날짜 받아서 동적으로 생성) 
//오늘날짜get , option세팅
var today = new Date();
var nowYear = today.getFullYear();
var nowMonth = (today.getMonth());
var optionPtrn = "<option value='%V'>%T</option>";
//연도세팅
var yearSetting = $("select[name='selectedYear']");
var html = "<option disabled selected>년도</option>";
for (var i = nowYear; i >= 1990; i--) {
	html += optionPtrn.replace("%V", i).replace("%T", i + "년");
}
yearSetting.html(html).css("width","200px");
var monthSetting = $("select[name='selectedMonth']");
html = "<option disabled selected>월</option>";
for (var i = 0; i < 12; i++) {
	if(i<9){
	html += optionPtrn.replace("%V", '0'+(i+1)).replace("%T", (i + 1) + "월");
	}else{
	html += optionPtrn.replace("%V", (i+1)).replace("%T", (i + 1) + "월");
	}
}
monthSetting.html(html).css("width","200px");
yearSetting.on("change", function() {
	var selectYear = $(this).val();
	//연도에 따른 월 세팅 
	var html2 = ""
	if (parseInt(selectYear) == nowYear) { //올해면 올해 월까지 표현 
		monthSetting.find('option').hide();
		monthSetting.find('option:lt(' + (nowMonth + 2) + ')').show();
	} else { //올해 아니면 12월 다 표현
		monthSetting.find('option').show();
	}
	monthSetting.trigger("renew", { //연도가 바뀌면 월 세팅도 변경되도록 
	});
});
yearSetting.change();

$.fn.dataTable.ext.search.push(
	    function( settings, data, dataIndex, dataObject ) {
	    	let selected = deptSelect.val();
	    	if(!selected){
	    		return true;
	    	}else{
	    	return  selected == dataObject.dept_code;
	    	}
	    }
	);
//datatable세팅
	var myDataTable= $("#myTable").DataTable({
	searching: true,
	"destroy":true,
    "responsive": true,
    "autoWidth": false,
    dom: 'lfrtipB',
    buttons: [
        'copy', 'csv', 'excel', 'print'
    ],
    ajax:{
  	  "type":"POST"
  	  ,"url": "${cPath}/hr/att/monthlyList"
  	  ,"dataType":"json"
  	  ,"data": {"selectedYear":"","selectedMonth":""}
    },
    "language": {
        "emptyTable": "해당기간에 사원 근태현황이 없습니다."
      },
    columns:[
  		  {data:"year"}
  		  ,{data:"month"}
  		  ,{data:"dept_name"}
  		  ,{data:"emp_code"}
  		  ,{data:"emp_kor"}
  		  ,{data:"position_name"}
  		  ,{data:"normal"}
  		  ,{data:"holiday"}
  		  ,{data:"vaca"}
  		  ,{data:"late"}
  		  ,{data:"absent"}
  		  ,{data:"official"}
  		  ,{data:"sick"}
  	  ]
  });
  
//부서 드롭박스 동적생성 
var optionPtrn = "<option value='%V'>%T</option>";
var deptSelect = $('<select id="deptOpt" class="dynamicElement form-control" name="dept_code"/>').on("change",function(){
	myDataTable.draw();
});
	$('div').find(".dataTables_length").after(deptSelect);
	$('#deptOpt').attr("data-url","<c:url value='/hr/att/ip/getDeptName.do'/>");
	$('#deptOpt').attr("style","width:240px");
				var dept_nameTag = $("select[name='dept_code']").data(
						"success",
						function(resp) {
							var html = optionPtrn.replace("%V", '').replace("%T", '전체 부서');
							$.each(resp, function(idx, dept) {
								html += optionPtrn.replace("%V", dept.dept_code).replace(
										"%T", dept.dept_name);
							});
							dept_nameTag.html(html);
						});		
	$(".dynamicElement").dynamicSelect();
	
//datatable변경할 ajax 
var ajaxList = function(selectedYear,selectedMonth){
	$.ajax({
		  	  "type":"POST"
		  	  	  ,"url": "${cPath}/hr/att/monthlyList"
		  	  	  ,"dataType":"json"
		  	  	  ,"data": {"selectedYear":$("#selectedYear").val(),"selectedMonth":$("#selectedMonth").val()}
		  	  	  ,success: function(resp){
		  	  		myDataTable.clear();
		  	  		myDataTable.rows.add(resp.data);
		  	  		myDataTable.draw();
		  	  	  }
		  	  		 // $('form').serialize()
		  	    });
}
//조회버튼눌렀을때
var searchBtn1 = $("#searchBtn1").on("click",function(){
	let selectedYear = $("#selectedYear").val();
	let selectedMonth = $("#selectedMonth").val();
	ajaxList(selectedYear,selectedMonth);
});

$("#restBtn").on("click",function(){
	$("#selectedYear").val("");
	$("#selectedMonth").val("");
	ajaxList();
});

//엑셀,카피,CSV,Print 버튼
$(".dt-buttons").children().attr("class","btn btn-primary btn-sm");

</script>