<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<script src="${cPath }/resources/ckeditor/ckeditor.js"></script>

<script type = "text/javascript" src = "https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.5.3/jspdf.min.js"></script>
<script type = "text/javascript" src = "https://html2canvas.hertzen.com/dist/html2canvas.min.js"></script>

<style>
	.text, .form-control{display: inline;}
	.check{width: 20px; height: 20px}

</style>

<form:form id="publicboxForm" modelAttribute="form" method="post" enctype="multipart/form-data" class="w-100" action="${cPath }/approval/publicformbox/publicformView/${form_code}">
	<div class = "content" style="margin: 40px 60px 0 60px">
		<div class="card card-primary" style="width: 100%;">
			<div class="card-header" >
				<h3 class="float-left mt-2">${form.form_name }</h3>
				<div class="float-right mt-2">
					<button type="button" class="btn btn-info btn-sm" id="saveBtn"
						style="border: 1px white solid;">
						<i class="fas fa-download"> </i> 다운로드
					</button>
					<div disable hidden>
					<button class="btn btn-info btn-sm" id="btnInsert"
						onclick="location.href='${cPath }/approval/publicformbox/insertform'" style="margin-top: 0px;">
						<i class="fas fa-pencil-alt"> </i> 등록
					</button>
					<button class="btn btn-info btn-sm" id="btnUpdate"
						onclick="location.href='${cPath }/approval/publicformbox/updateForm/${form_code}'" style="margin-top: 0px;">
						<i class="fas fa-pencil-alt"> </i> 수정
					</button>
					<button class="btn btn-danger btn-sm" onclick="location.href='${cPath }/approval/publicformbox/delForm'" style="margin-top: 0px;">
						<i class="fas fa-trash"> </i> 삭제
					</button>
					</div>
				</div>
			</div>
			<form role="form">
				<div class="card-body" style="width: 100%; padding: 20px 40px 20px 40px">
					<span style="display: inline-block; margin-right: 60px;" >카테고리</span> <input type="hidden" name="form_code" value="${form.form_code }">
			
					<select class="form-control select2bs4 select2-hidden-accessible" name="fc_code" style="width: 30%; margin-right: 40px;" data-select2-id="17" tabindex="-1" aria-hidden="true" >
						<option selected disabled>카테고리</option>
						<c:forEach items="${catagList }" var="catag">
							<c:set var="selected" value="${catag.fc_code eq form.fc_code ? 'selected' : ''}"></c:set>
							<option value="${catag.fc_code }" ${selected } selected disabled>${catag.fc_name }</option>
						</c:forEach>
					</select>
						
					<br><br>
					
					<div id="pdfchange" style="width: 100%; padding: 30px; border: 1px solid black;">
						${form.form_content }
					</div>
					
				</div>
			</form>
		</div>
	</div>
</form:form>



<script>

	$('#saveBtn').click(function() { // pdf저장 button id
		let pdf = new jsPDF();
		let canvas = pdf.canvas;
		const pageWidth = 210;
		const pageHeight = 295;
		canvas.width = pageWidth;
		
		let ele = document.querySelector('#pdfchange');
		
		let width = ele.offsetWidth; // 요소 px 너비
		let height = ele.offsetHeight; // 요소 px 높이
		let imgHeight = pageWidth*height/width;  // 이미지 높이값 px to mm 변환
		
		if(!ele){
			console.warn('not exist');
			return false;
		}
		 html2canvas(ele).then(function(canvas){
			 let position = 0;
			 const imgData = canvas.toDataURL('image/jpg');
						 
			 pdf.addImage(imgData,'jpg',0,position,pageWidth,imgHeight);
			 //Paging처리
			 let heightLeft = imgHeight; 
			 heightLeft -= pageHeight;
			 while(heightLeft>=0){
				 position = heightLeft - imgHeight;
				 pdf.addPage();
				 pdf.addImage(imgData,'jpg',0,position,pageWidth,imgHeight);
				 heightLeft-=pageHeight;
			 }
			 pdf.save('form.pdf');
		 });
	});
	
</script>


