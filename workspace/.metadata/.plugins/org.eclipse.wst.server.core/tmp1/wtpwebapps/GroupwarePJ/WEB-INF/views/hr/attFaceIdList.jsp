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

<section class="content">
	<div class="container-fluid" id="content">
		<div class="row">
			<div class="col-12">
				<!-- 없애면안됨 -->
				<div class="col-12">
					<div class="card">
						<div class="card-header">
							<h2>FaceID관리</h2>
						</div>
						<!-- /.card-header -->
						<div class="card-body">
							<div id="myTable_wrapper"
								class="dataTables_wrapper dt-bootstrap4">
								<div class="col-12">
									<table id="myTable" class="table table-hover"	cellspacing="0" width="100%">
										<thead>
											<tr>
												<th>부서</th>
												<th>사원번호</th>
												<th>성명</th>
												<th>직급</th>
												<th>FACEID</th>
												<th>대체얼굴</th>
											</tr>
										</thead>
									</table>
								</div>
							</div>
						</div>
						<!-- /.card-body -->
					</div>
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
    stateSave: true,
    ajax:{
  	  "type":"POST"
  	  ,"url": "${cPath}/hr/att/faceid"
  	  ,"dataType":"json"
    },
    columns:[
  		   {data:"dept_name"}
  		  ,{data:"emp_code"}
  		  ,{data:"emp_kor"}
  		  ,{data:"position_name"}
  		  ,{data:"faceid1"}
  		  ,{data:"faceid2"}
  	  ]
    , "columnDefs": {
            className: "dt-head-center"
        }
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
//테이블 클릭하면 새창
$('#myTable tbody').on('click', 'tr', function () {
	   var data = myDataTable.row( this ).data();
	   var emp_code = data.emp_code;
	   openWin = window.open("${cPath}/hr/att/faceid/add/"+emp_code,"",
			   'top=0, left=0, width=700, height=750, directories=no, location=no, menubar=no, resizable=no, status=yes, toolbar=no');
// 	   $('#modal').modal();
		//새창띄우기
});

</script>