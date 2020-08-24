<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<script src="${cPath }/resources/ckeditor/ckeditor.js"></script>

<style>
	.text, .form-control{display: inline;}
	.check{width: 20px; height: 20px}

</style>

<form:form id="publicboxForm" modelAttribute="form" method="post" class="w-100" action="${cPath }/approval/publicformbox/${state }/${form_code }">

	<div class = "content" style="margin: 40px 60px 0 60px">
		<div class="card card-primary" style="width: 100%;">
			<div class="card-header" >
			<c:if test="${empty form}">
				<span>공용서식 등록</span>
<%-- 				공용서식 추가 <h3 class="card-title">${form.form_code }</h3> --%>
			</c:if>
			<c:if test="${not empty form}">
				 <h3 class="card-title">${form.form_name }</h3>
			</c:if>
			</div>
			<form role="form">
				<div class="card-body" style="width: 100%; padding: 20px 40px 20px 40px">
					<input type="hidden" name="form_code" value="${form.form_code }">
					
					<span class="text" style="margin-right: 60px">카테고리</span>
					
					<select class="form-control select2bs4 select2-hidden-accessible" name="fc_code" style="width: 30%; margin-right: 40px;" data-select2-id="17" tabindex="-1" aria-hidden="true" > 
						<option selected disabled>카테고리</option>
						<c:forEach items="${catagList }" var="catag">
							<c:set var="selected" value="${catag.fc_code eq form.fc_code ? 'selected' : ''}"></c:set>
							<option value="${catag.fc_code }" ${selected }>${catag.fc_name }</option>
						</c:forEach>
					</select>
					<br><br>
					
					<span class="text" style="margin-right: 90px">제목</span> 
						<input class="form-control" type="text" style="width: 80%" name="form_name" value="${form.form_name }">
					<br><br>
					<span class="text" style="margin-right: 60px">내용</span><br><br>
					<textarea class="form-control" id="report_content" name="form_content"> ${form.form_content } </textarea> 
					<br><br>
					<c:if test="${empty form}">
					<button type="submit" class="btn btn-primary" id="save" style="margin-left: 50%">등록</button>
					</c:if>
					<c:if test="${not empty form}">
					<button type="submit" class="btn btn-primary" id="save" style="margin-left: 50%">수정</button>
					</c:if>
				</div>
			</form>
		</div>
	</div>
</form:form>

<script>
	
	$()
	CKEDITOR.replace('report_content',{
		 // Adding drag and drop image upload.
	      uploadUrl: '${pageContext.request.contextPath}/board/image?command=QuickUpload&type=Files&responseType=json',
	
	     // Configure your file manager integration. This example uses CKFinder 3 for PHP.
	      filebrowserImageUploadUrl: '${pageContext.request.contextPath}/board/image?command=QuickUpload&type=Images',
	});
	
</script>


