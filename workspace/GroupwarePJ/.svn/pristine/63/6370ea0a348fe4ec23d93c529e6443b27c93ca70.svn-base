<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 

<div class="col-12">
	<div class="card">
		<div class="card-header">
			<h2 class="card-title">게시판</h2>
			
			<br><br>
			
			<div id = "top">
			<div class = "form-group" id = "searchUI">
				<select name = "searchType" class="form-control select2 select2-hidden-accessible" style="width: 10%;float:left" data-select2-id="1" tabindex="-1" aria-hidden="true">
					<option value="" ${empty pagingVO.searchVO.searchType?"selected":"" }>전체</option>
					<option value="board_title" ${pagingVO.searchVO.searchType eq 'board_title'?"selected":"" }> 제목 </option>
					<option value="emp_code" ${pagingVO.searchVO.searchType eq 'emp_code'?"selected":"" }> 작성자 </option>
					<option value="board_content" ${pagingVO.searchVO.searchType eq 'board_content'?"selected":"" }> 내용 </option>
				</select>
				<p class="input-group input-group-sm" style="width: 40%; float:left">
					<input type="text" class="form-control float-right" name="searchWord" placeholder="Search" style="height:38px;" 
					value="${pagingVO.searchVO.searchWord }" onkeyup="event.keyCode==13?$('#searchBtn').trigger('click'):'';"/>
					<div class="input-group-append">
						<input class="btn btn-default " type="button" value="검색" id="searchBtn">
						<input class="btn btn-default" type="button" value="글 작성" 
						onclick="location.href='<c:url value="/board/boardList/insertForm"/>';" />
					</div>
				</p>
			</div>
			</div>
			<br>
			<div class="card-tools">
				<div class="input-group input-group-sm" id="searchUI" style="width: 150px;"> </div>
			</div>
		</div>
		<!-- /.card-header -->
		<div class="card-body table-responsive p-0">
			<table class="table table-hover text-nowrap" id="formTable">
				<thead>
					<tr>
						<th>#</th>
						<th>카테고리</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody id="listBody">

				</tbody>

			</table>
			<nav id="pagingArea" class="d-flex ml-md-auto d-print-none">
				${pagingVO.pagingHTML }</nav>
		</div>
		<!-- /.card-body -->
	</div>
	<!-- /.card -->
</div>

<form id="searchForm" action="${pageContext.request.contextPath }/board/boardList/all">
	<input type="hidden" name="page" value="${param.page }"/>
	<input type="hidden" name="searchType" value=""/>
	<input type="hidden" name="searchWord" value=""/>
</form>

<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/paging.js"></script>
<script type="text/javascript">

	var listBody = $("#listBody");
	var searchForm = $("#searchForm").paging({
		searchUI:"#searchUI",
		searchBtn:"#searchBtn",
		pagination:"#pagingArea",
		pageParam:"page",
		byAjax:true,
		success:function(resp){
			let boardList = resp.dataList;
			let pagingHTML = resp.pagingHTML;
			let trTags = [];
			if(boardList.length>0){
				$.each(boardList, function(idx, board){
					let trTag = $("<tr>").append(
									$("<td>").text(board.rnum)
									,$("<td>").text(board.board_catag)
									, $("<td>").html(
										$("<a>").attr("href", "${cPath }/board/boardList/boardView/"+board.board_code)
												.html(board.board_title)													
									)
									, $("<td>").text(board.emp_code)
									, $("<td>").text(board.board_date)
									, $("<td>").text(board.board_hit));
					trTags.push(trTag);
				});
				$("#pagingArea").html(pagingHTML);
			}else{
				trTags.push($("<tr>").html($("<td colspan='8'>").text("조건에 맞는 게시글이 없음.")));
				$("#pagingArea").empty();
			}
			listBody.html(trTags);
			listBody.data("currentpage", resp.currentPage);
			searchForm.find("[name='page']").val("");
		}
	}).submit();
	
	
</script>
