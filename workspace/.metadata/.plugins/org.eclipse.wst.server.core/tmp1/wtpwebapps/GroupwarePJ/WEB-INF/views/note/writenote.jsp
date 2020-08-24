<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style>
  #msg_content{
        width: 80%;
        height: 200px;
      }
</style>
<section class="content-header">
	<div class="container-fluid">
		<div class="row mb-2">
			<div class="col-sm-6">
				<h1>쪽지 쓰기</h1>
				<br>
			</div>
		</div>
	</div>
	<!-- /.container-fluid -->
</section>

<!-- Bootstrap4 Duallistbox -->
<link rel="stylesheet"
	href="${cPath }/resources/plugins/bootstrap4-duallistbox/bootstrap-duallistbox.min.css">
<!-- Bootstrap4 Duallistbox -->
<script
	src="${pageContext.request.contextPath }/resources/plugins/bootstrap4-duallistbox/jquery.bootstrap-duallistbox.min.js"></script>

<div class="content">

	<!-- Horizontal Form -->
	<div class="card card-info">
		<div class="card-header">
			<h3 class="card-title">쪽지쓰기</h3>
		</div>
		<!-- /.card-header -->

		<div class="card-body">
			<div class="send_window">
				<label class="emp_receiver" id="emp_receiver">받는이</label> 
				<input type="text" class="emp_kor" id="emp_kors" name="emp_receiver"
					value="${emp_receiver }">
				<!-- 주소록 버튼 -->
				<button type="button" class="btn btn-secondary" id="btnAddEmp"
					data-toggle="modal" data-target="#modal-lg">
					<i class="fas fa-users"></i>
				</button>
			</div>

			<div class="form-group">
				<label for="inputDescription">내용</label>
				<!--쪽지쓰기form . -->
				<form:form id="writer" method="post" enctype="multipart/form-data"
					class="w-100"
					action="${pageContext.request.contextPath }/note/writenote">
					<div class="text2">
					
					</div>
					<c:if test="${emp_code ne null}">
					<input type="hidden" class="text2" name="emp_receivers"
						value="${emp_code}">
					</c:if>
					<!-- 수신자 -->
					<textarea class="form-control" name="msg_content" id="msg_content" rows="1"  >${msg_content}</textarea>
					<input type="hidden" name="emp_sender" id="send">

				</form:form>
			</div>


		</div>
		<!-- /.card-body -->
		<div class="card-footer" align="center">
			<button type="submit" class="btn btn-info" id="subbtn">보내기</button>
			<input type="button" class="btn btn-secondary mr-2" value="뒤로가기"
				onclick="history.back();"/>
		</div>

	</div>
	<!-- /.card -->
</div>
<!-- 팀원 -->
<!-- SweetAlert2 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/plugins/sweetalert2-theme-bootstrap-4/bootstrap-4.min.css">
<script
	src="${pageContext.request.contextPath }/resources/plugins/sweetalert2/sweetalert2.min.js"></script>

<!-- summernote -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/plugins/summernote/summernote-bs4.css">
<script
	src="${pageContext.request.contextPath }/resources/plugins/summernote/summernote-bs4.min.js"></script>

<!-- Bootstrap4 Duallistbox -->
<script
	src="${pageContext.request.contextPath }/resources/plugins/bootstrap4-duallistbox/jquery.bootstrap-duallistbox.min.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/dynamicSelect.js?time=${System.currentTimeMillis()}"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/paging.js?time=${System.currentTimeMillis()}"></script>




<!-- 팀원추가모달창 -->
<script type="text/javascript">
	//Bootstrap Duallistbox
	$('.duallistbox').bootstrapDualListbox()
</script>

<form id="searchForm" action="${cPath }/note/writenote">
	<input type="hidden" name="page" value="${param.page }" /> <input type="hidden" name="dept_code" value="" /> 
	<input type="hidden"name="team_code" value="" />
</form>

<!-- 팀원 모달창 -->
<div class="modal fade show" id="modal-lg" aria-modal="true"
	style="padding-right: 17px; display: none;">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">사원 주소록</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>

			<div class="modal-body">
				<div class="form-inline mb-2" id="searchUI">
					<select class="dynamicElement form-control mr-2" name="dept_code"
						data-url="<c:url value='/addTeam/getDeptList.do'/>">
						<option selected disabled>부서</option>

					</select> <select class="dynamicElement form-control mr-2" name="team_code"
						data-url="<c:url value='/addTeam/getTeamList.do' />">

					</select> <input class="btn btn-success mr-2" type="button" value="검색"
						id="searchBtn">
				</div>

				<table class="table">
					<thead>
						<tr>
							<th></th>
							<th>사원명</th>
							<th>직급</th>
						</tr>
					</thead>
					<tbody id="listBody">

					</tbody>
					<tfoot>
						<tr>
							<td colspan="3">
								<nav id="pagingArea">${pagingVO.pagingHTML }</nav>
							</td>
						</tr>
					</tfoot>
				</table>

				<hr>

				<table class="table">
					<thead>
						<tr>
							<th></th>
							<th>사원명</th>
							<th>직급</th>
						</tr>
					</thead>
					<tbody id="addedBody">
						<c:if test="${emp_code ne null }"> 
						<tr data-code="${emp_code }">
							<td></td>
							<td>${emp_receiver }</td>
							<td>${position_name }</td>
							<td>
							<p><button class="btn btn-default" id="addTM" style="margin-left:10px;">삭제</button></p>
							</td>
						</tr>
						</c:if>
					</tbody>
				</table>
			</div>


			<div class="modal-footer justify-content-between">
				<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
				<button type="button" class="btn btn-primary" data-dismiss="modal"
					aria-label="Close" id="addAll">완료</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>



<script>

	$('#msg_content').focus(function() {
	  $(this).setCursorPosition(1);
	});
	//팀원 목록에 추가
	$("#listBody").on("click", "button", function() {
		let clickData = $(this).parents("tr");
		let data_code = clickData.attr("data-code");
		let sameData = $("#addedBody").find("tr[data-code=" + data_code + "]");
		let cloneTag = clickData.clone();
		cloneTag.find("button").text("삭제");
		let tags = []

		if (sameData.length > 0) {
			return;
		} else {
			$("#addedBody").append(cloneTag);
		}
	})

	//팀원 목록에서 삭제
	$("#addedBody").on("click", "button", function() {
		let clickData = $(this).parents("tr");
		clickData.remove();
	})

	//부서 선택시
	var optionPtrn = "<option value='%V' %S>%T</option>";
	var deptTag = $("select[name='dept_code']").data(
			"success",
			function(resp) {
				var html = "";
				$.each(resp, function(idx, dept) {
					html += optionPtrn.replace("%V", dept.dept_code).replace(
							"%T", dept.dept_name);
				});
				deptTag.append(html);
			}).on("change", function() {
		let dept_code = $(this).val();

		teamTag.trigger("renew", {
			dept_code : dept_code
		});
	});

	//팀 선택시
	var teamTag = $("select[name='team_code']").data(
			"success",
			function(resp) {
				var html = "<option selected disabled>팀</option>";
				$.each(resp, function(idx, team) {
					html += optionPtrn.replace("%V", team.team_code).replace(
							"%T", team.team_name);
				});
				teamTag.html(html);
			});

	$(".dynamicElement").dynamicSelect();

	//사원 검색
	var listBody = $("#listBody");
	var searchForm = $("#searchForm")
			.paging(
					{
						searchUI : "#searchUI",
						searchBtn : "#searchBtn",
						pagination : "#pagingArea",
						pageParam : "page",
						byAjax : true,
						success : function(resp) {
							console.log("resp : " + resp)
							let empList = resp.dataList;
							let pagingHTML = resp.pagingHTML;
							let trTags = [];
							if (empList.length > 0) {
								$.each(empList,function(idx, emp) {
									let trTag = $("<tr>").append(
													$("<td>"),
													$("<td>").text(emp.emp_kor),
													$("<td>").text(emp.position_name),
													$("<p>").html('<button class="btn btn-default" id="addTM" style="margin-left:10px;">추가</button>')
													).attr("data-code",emp.emp_code);
													trTags.push(trTag);
												});
							}
							listBody.html(trTags);
							listBody.data("currentPage", resp.currentPage);
							$("#pagingArea").html(pagingHTML);
							searchForm.find("[name='page']").val("");
						}
					});

	searchForm.submit();

	//팀원 목록 추가 완료
	$("#addAll").on("click", function() {
		
		let datalist = $("#addedBody").find("tr");
		let tags = [];
		let name = "";
		$.each(datalist,function(idx,item){
			 let emp_code = $(item).attr("data-code");
			 let tag = $("<input>").attr({"type":"hidden","value":emp_code,"name":"emp_receivers"})
			 let emp_kor = $(this).children().eq(1).text();
			 if(idx == 0){
				 name += emp_kor;
			 }else{
				 name += ", "+emp_kor;
			 }
			 tags.push(tag);
		 })
		 
		$(".text2").html(tags)
		$("#emp_kors").val(name); //수신자
		
		
		
// 		let added_emp_name = "";
// 		let added_emp = "";
// 		$("#addedBody").find("tr").each(function() {
// 			added_emp_name = $(this).children().eq(1).text();
// 			added_emp += added_emp_name;
// 		})
		
		
		
		
		
// 		$("#").val(added_emp); //보낸이 
		// 				$("#tmDiv").addClass("form-control").html(added_emp);
	});

	
	
	
	//보내기 버튼
	$("#subbtn").on("click", function() {
// 		console.log("dwd")
		$("#writer").submit()
	})
</script>
