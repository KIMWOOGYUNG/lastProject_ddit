<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<script src="${cPath }/resources/ckeditor/ckeditor.js"></script>

<style>
	.text, .form-control{display: inline;}
	.check{width: 20px; height: 20px}
</style>

<form:form id="boardForm" modelAttribute="board_code"  method="post" enctype="multipart/form-data" class="w-100" action="${pageContext.request.contextPath }/board/boardList/${state }/${board_code}/${pos}">
	<div id="content">
		<div class="card card-info">
			<div class="card-header">
				<c:if test="${empty board_code}">
					<h3>게시글 작성</h3>
				</c:if>
				<c:if test="${not empty board_code}">
					<h3 class="card-title">${board.board_title }</h3>
				</c:if>
			</div>
			<form role="board">
				<div class="card-body" style="width: 100%; padding: 20px 40px 20px 40px">
					<input type="hidden" name="board_code" value="${board.board_code}" />
					<input type="hidden" name="parent_board" value="${board.parent_board}" />
					<input type="hidden" name="emp_code" value="${board.emp_code }" />
					<input type="hidden" name="board_date" value="${board.board_date }" />
					<input type="hidden" name="board_hit" value="${board.board_hit }" />
					<input type="hidden" name="board_hit" value="${board.parent_board }" />
					
					<span class="text" style="margin-right: 64px">카테고리</span> <select class="form-control select2bs4 select2-hidden-accessible"
						name="board_catag" style="width: 30%; margin-right: 40px;"
						data-select2-id="17" tabindex="-1" aria-hidden="true">
						<option selected disabled>카테고리</option>
						<c:forEach items="${catagList }" var="catag">
							<c:set var="selected"
								value="${catag.standard_code eq board.board_catag ? 'selected' : ''}"></c:set>
							<option value="${catag.standard_code }" ${selected }>${catag.standard_name }</option>
						</c:forEach>
					</select> <br><br>
					<span class="text" style="margin-right: 64px">첨부파일</span>
						 <input type="button" id="btnAttatch" class="btn btn-default" value="파일첨부" onclick="fileAttatch()">
						 <div id="attatchDiv"  style="display: inline-block;"></div>
				<c:if test="${not empty board.attatchList }">
					<span class="text" style="margin-right: 64px">기존파일</span>
					<c:forEach items="${board.attatchList }" var="attatch" varStatus="vs">
						<span class="eachAttatch">${attatch.org_name }
						<span class="delBtn" data-attno="${attatch.board_attcode }">[DEL]</span>${not vs.last ? "&nbsp;" : "" }</span>
					</c:forEach>
				</c:if>
				<br><br>
					<span class="text" style="margin-right: 95px">제목</span> 
						<input class="form-control" type="text" style="width: 80%" name="board_title" value="${board.board_title }">
					<br><br>
					<span class="text" style="margin-right: 60px">내용</span><br><br>
						<textarea class="form-control" id="board_content" name="board_content">${board.board_content }</textarea> 
					<br><br>
					<c:if test = "${empty board_code }">
						<button type="submit" class="btn btn-primary" id="save" style="margin-left: 50%" style="margin-top: 0px;"><i class="fas fa-pencil-alt"> </i>등록</button>
					</c:if>
					<c:if test = "${not empty board_code }">
						<button type="submit" class="btn btn-primary" id="save" style="margin-left: 50%" style="margin-top: 0px;"><i class="fas fa-pencil-alt"> </i>수정</button>
					</c:if>
					<button class="btn btn-primary"
						id="btnUpdate" style="margin-top: 0px;"
						onclick="location.href='${cPath }/board/boardList/${board_catag}'" style="margin-top: 0px;">
						목록
					</button>	
						
				</div>
			</form>
		</div>
	</div>
</form:form>

<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/dynamicSelect.js?time=${System.currentTimeMillis()}"></script>
<script type="text/javascript">
	// 첨부파일
	function fileAttatch(){
	    $("#attatchDiv").append("<input type='file' name='board_files' style='margin:10px'/>");
	 }
	// 내용 작성
	CKEDITOR.replace("board_content", {
		 // Adding drag and drop image upload.
	      uploadUrl: '${pageContext.request.contextPath}/board/image?command=QuickUpload&type=Files&responseType=json',

	    // Configure your file manager integration. This example uses CKFinder 3 for PHP.
		//filebrowserImageUploadUrl: '${pageContext.request.contextPath}/board/image?command=QuickUpload&type=Images',
	      filebrowserUploadUrl:'${pageContext.request.contextPath}/mine/imageUpload.do'
	});	
	//첨부파일 삭제
	var boardForm = $("#boardForm");
	$(".delBtn").on("click", function(){
		let board_attcode = $(this).data("board_attcode");
		boardForm.append(
			$("<input>").attr({
				type:"text"
				, name:"deleteAttatches"
				, value:board_attcode
			})	
		);
		$(this).parent("span:first").remove();		
	});
	
</script>