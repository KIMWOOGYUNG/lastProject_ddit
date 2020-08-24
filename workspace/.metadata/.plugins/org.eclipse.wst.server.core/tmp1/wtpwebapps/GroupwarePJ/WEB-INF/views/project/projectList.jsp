<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<style>
	#content {padding: 30px;}
	.chkBox {width: 15px;height: 15px;}
	.icon {margin: 0px 5px 10px 0px;}
	.button {background: none;border: 0;float:left;}
	#nav{float:right;width:140px;margin-top:10px;}
	h2{margin:10px 0 30px 0;}
	#searchBtn{width:40px; heigth:40px;}
	.hide2{float:right;}
</style>

<div id="content">

	<div class="col-12">
		<div class="card">
			<div class="card-header">
				<h2>${title }</h2>
				<div class="form-group" id="searchUI">
					<select name="searchType" class="form-control select2 select2-hidden-accessible" style="width: 10%; float: left" data-select2-id="1" tabindex="-1" aria-hidden="true">
						<option value="" data-select2-id="3" selected disabled>검색 방법</option>
						<option value="dept" ${pagingVO.searchVO.searchType eq 'dept'?"selected":"" }
							data-select2-id="34">부서</option>
						<option value="pjName" ${pagingVO.searchVO.searchType eq 'pjName'?"selected":"" }
							data-select2-id="35">프로젝트명</option>
						<option value="name" ${pagingVO.searchVO.searchType eq '"name"'?"selected":"" }
							data-select2-id="36">팀원</option>
					</select>
					<div class="input-group input-group-sm"
						style="width: 40%; float: left">
						<input type="text" class="form-control float-right"
							name="searchWord" placeholder="Search" style="height: 38px;"
							value="${pagingVO.searchVO.searchWord }" />
						<div class="input-group-append">
			                <button type="submit" id="searchBtn" class="btn btn-default"><i class="fas fa-search"></i></button>
			            </div>
					</div>
				</div>
			
				<div id="nav">
					
					<button class="btn btn-primary btn-sm" onclick="insertAction()">
						<i class="fas fa-folder"> </i> 등록
					</button>
					<c:if test="${who eq 'my'}">
						<button class="btn btn-danger btn-sm" onclick="deleteAction()">
							<i class="fas fa-trash"> </i> 삭제
						</button>
					</c:if>
				</div>
			</div>
			
			<!-- 아이콘 -->

			<div class="card-body table-responsive p-0">
				<div style="margin:20px 20px 0px 20px;">
					<button class="button showBtn" id="blockBtn" data-target="#blockBody">
						<span class="oi oi-grid-three-up icon"></span>
					</button>
					<button class="button showBtn" id="tableBtn"
						data-target="#projectTable">
						<span class="oi oi-list icon"></span>
					</button>
				</div>
			
			<br>
		
				<br>
				<table class="table table-hover text-nowrap toggleShow" id="projectTable">
					<thead>
						<tr>
							<c:if test="${who  eq 'my'}">
								<th><input type="checkbox" name="checkAll" class="chkBox"
									id="th_checkAll" onclick="checkAll();" /></th>
							</c:if>
							<c:if test="${who  ne 'my'}">
								<th></th>
							</c:if>
							<th>코드</th>
							<th>부서</th>
							<th>프로젝트명</th>
							<th>팀 리더</th>
							<th>진행률</th>
							<th>중요도</th>
							<th>상태</th>
							<th class="text-center">공개</th>
						</tr>
					</thead>
					<tbody id="listBody">
		
		
					</tbody>
				</table>
		
				<div id="blockBody" class="toggleShow"></div>
				<div style="margin:20px 20px 20px 20px; float:left;width:80%;">
					<div id="pagingArea" class="d-flex ml-md-auto d-print-none">
						<div>${pagingVO.pagingHTML }</div>
					</div>
 				</div>
			</div>
		</div>
	</div>
</div>
<form id="searchForm"
	action="${pageContext.request.contextPath }/project/projectlist/${who}">
	<input type="hidden" name="page" value="${param.page }" /> 
	<input type="hidden" name="searchType" value="" /> 
	<input type="hidden" name="searchWord" value="" /> <input type="hidden" name="viewType" value="" />
	<!-- 페이지를 클릭할때 블럭인지 리스트인지 정보를 받아옴 -->
</form>

<script type="text/javascript">
	var blockBody = $("#blockBody");
	var listBody = $("#listBody");
	var projectTable = $("#projectTable");
	var searchForm = $("#searchForm").paging({
						searchUI : "#searchUI",
						searchBtn : "#searchBtn",
						pagination : "#pagingArea",
						pageParam : "page",
						byAjax : true,
						success : function(resp) {
							let projectList = resp.dataList;
							let pagingHTML = resp.pagingHTML;
							let divTags = [];
							let trTags = [];
							if (projectList.length > 0) {
								let idx = 1;
								$.each(projectList,	function(idx, project) {
									let firstCol = null;
									if (("my" == '${who}')) {
										firstCol = $("<td>").html('<input type="checkbox" class="chkBox" name="checkRow" value="'+project.project_code+'" />');
									} else {
										firstCol = $("<td>").text("");
									}
									
									//블럭형태
									let pj_rgroupList = project.pj_rgroupList;
									let pjMemDiv = $("<div>").css("height","60px");
									let plTd = "";
									if (pj_rgroupList != null && pj_rgroupList.length > 0) {
										$.each(pj_rgroupList,function(idx,pj_rgroup) {
											let pj_memberList = pj_rgroup.pj_memberList;
											if (pj_memberList != null && pj_memberList.length > 0) {
												$.each(pj_memberList,function(idx,pj_member) {
													pjMemDiv.append($("<span>").addClass("oi oi-person text-muted text-sm").css("margin","5px").text(pj_member.emp_kor + pj_rgroup.pr_name));
													if (pj_rgroup.pr_code == ("PR001")) {
														plTd = pj_member.emp_kor;
													}
												})
											}

										})
									}


									let hide = "";
									if (project.project_hide == 'Y') {
										hide = '<span class="oi oi-lock-locked hide"></span>'
										hide2 = '<span class="oi oi-lock-locked hide2"></span>'
									} else {
										hide = '<span class="oi oi-lock-unlocked hide" ></span>'
										hide2 = '<span class="oi oi-lock-unlocked hide2" ></span>'
									}
									
									let divTag = $("<div>").append($("<div>").css("display","inline").css("width","33.3%").css("float","left")
										.addClass("col-12 col-sm-6 col-md-4 align-items-stretch")
										.html($("<div>").addClass("card bg-light").css("margin","10px")
										.html($("<div>").addClass("card-header text-muted border-bottom-0")
											.html($("<p>").text(project.dept_name).append(hide2)))	
										.append($("<div>").addClass("card-body pt-0")
										.html($("<div>").addClass("row")
										.html($("<div>").addClass("col-15")
										.html($("<h2>").addClass("lead")
										.html($("<b>").text(project.project_name)))
										.append($("<p>").addClass("text-muted")
										.html($("<p>").text(project.project_sum)))
										.append(pjMemDiv)
										.append($("<div>").addClass("project_progress progress-sm")
											.html('<div class="progress progress-sm" style="width:100%;"><div class="progress-bar bg-green" role="progressbar" aria-volumenow="'
												+ project.project_progress
												+ '" aria-volumemin="0" aria-volumemax="100" style="width: '
												+ project.project_progress
												+ '%"></div></div>')))))
										.append($("<div>").addClass("card-footer")
											.html($("<div>").addClass("text-right")
												.html($("<a>").attr("data-code",project.project_code).html($("<span>").addClass("oi oi-zoom-in"))
													.attr("onclick","goDetail1(event)"))))));
									divTags.push(divTag);

									//리스트형태
									let trTag = $("<tr>").append(
													firstCol,
													$("<td>").text(project.project_code).addClass("code"),
													$("<td>").text(project.dept_name),
													$("<td>").text(project.project_name),
													$("<td>").text(plTd),
													$("<td class='project_progress'>")
														.html('<div class="progress progress-sm"><div class="progress-bar bg-green" role="progressbar" aria-volumenow="'
															+ project.project_progress+ '" aria-volumemin="0" aria-volumemax="100" style="width: '
															+ project.project_progress+ '%"></div></div><small>'
															+ project.project_progress+ '% Complete</small>'),
													$("<td>").text(project.import_name),
													$("<td>").text(project.stat_name),
													$("<td class='text-center'>>").html(hide)).attr("onclick","goDetail2(event)");
									trTags.push(trTag);
								});
								$("#pagingArea").html(pagingHTML);
							} else {
								divTags.push($("<span>").text(
										"검색된 프로젝트가 없습니다."));
								$("#pagingArea").empty();
							}
							
							blockBody.html(divTags);
							blockBody.data("currentpage", resp.currentPage);
							listBody.html(trTags);
							listBody.data("currentpage", resp.currentPage);

							searchForm.find("[name='page']").val("");
							let viewType = searchForm.find("[name='viewType']").val();

							//paging시 viewType 유지
							if (viewType) { //viewType이 있다면
								$(".toggleShow").hide();
								$(viewType).show();

							} else { //viewType이 없다면 (default)
								projectTable.hide();
								blockBody.show();
							}
						}
					}).submit();
	
//상세페이지 이동
	//블럭
	function goDetail1(event){
		var project_code = $(event.target).parent().data("code");
		var hide = $(event.target).parent().parent().parent().parent().find(".hide2");
		console.log(hide);
		if(hide.hasClass("oi-lock-locked")){
			console.log("a");
			if(${authUser.jobtitle_code eq 'JT001'}){
				console.log("b");
				location.href="${cPath}/project/eachproject/" + project_code;
			}else{
				console.log("c");
				alert("팀장 이상만 접근가능합니다.");
			}
		}else{
				console.log("d");
			location.href="${cPath}/project/eachproject/" + project_code;
		}
	}
	
	//리스트
	function goDetail2(event){
		var td = $(event.target).parent().find(".code");
		var hide = $(event.target).parent().find(".hide");
		console.log(hide);
		let project_code = td.text();
		if(hide.hasClass("oi-lock-locked")){
			if(${authUser.jobtitle_code eq 'JT001'}){
				location.href="${cPath}/project/eachproject/" + project_code;
			}else{
				alert("팀장 이상만 접근가능합니다.");
			}
		}else{
			location.href="${cPath}/project/eachproject/" + project_code;
		}
	}

	//viewType 이벤트
	$(".showBtn").on("click", function() {
		var target = $(this).data("target");
		$(".toggleShow").hide();
		$(target).show();
		// 			$(".toggleShow").toggle();
		searchForm.find("[name='viewType']").val(target);
	});

	//프로젝트 추가
	function insertAction() {
		location.href = "${pageContext.request.contextPath }/project/newProject";
	}

	//전체 선택
	function checkAll() {
		if ($("#th_checkAll").is(':checked')) {
			$("input[name=checkRow]").prop("checked", true);
		} else {
			$("input[name=checkRow]").prop("checked", false);
		}
	}

	//삭제
	function deleteAction() {
		var checkRow = "";
		$("input[name='checkRow']:checked").each(function() {
			checkRow = checkRow + $(this).val() + ",";
		});
		checkRow = checkRow.substring(0, checkRow.lastIndexOf(",")); //맨끝 콤마 지우기

		if (checkRow == '') {
			alert("삭제할 프로젝트를 선택하세요.");
			return false;
		}
		console.log("### checkRow => {}" + checkRow);

		if (confirm("프로젝트를 삭제 하시겠습니까?")) {
			$.ajax({
				url : '${pageContext.request.contextPath }/project/delProject',
				type : "POST",
				datatype : 'json',
				contentType : "application/x-www-form-urlencoded; charset=UTF-8",
				data : {
					project_code : checkRow
				},
				success : function(data) {
					alert("삭제가 완료되었습니다.");
					location.href = "${pageContext.request.contextPath }/project/projectlist/${who}";
				},
				error : function(request, status, error) {
					alert("삭제를 실패하였습니다.");
				}
			})
		}
	}
</script>