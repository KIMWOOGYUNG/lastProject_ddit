    <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<script src="${cPath }/resources/ckeditor/ckeditor.js"></script>

<style>
	.text, .form-control{display: inline;}
	.check{width: 20px; height: 20px}

</style>

<form:form id="worklogForm" modelAttribute="worklog" method="post" enctype="multipart/form-data" class="w-100" action="${cPath }/work/mywork/insertdiary">
	<div class = "content" style="margin: 40px 60px 0 60px">
		<div class="card card-primary" style="width: 100%;">
			<div class="card-header" >
				<h3 class="card-title">업무일지 작성</h3>
			</div>
			<form role="form">
				<div class="card-body" style="width: 100%; padding: 20px 40px 20px 40px">
					<input type="hidden" name="wlcode" value="${worklog.wl_code }">
				
					<span class="text" style="margin-right: 60px">제목</span> 
						<input class="form-control" type="text" style="width: 80%" name="wl_title" value="${worklog.wl_title }"><br><br>
						
					<span class="text" style="margin-right: 60px">종류</span> 
					<select class="form-control select2bs4 select2-hidden-accessible" name="wl_catag" style="width: 30%; margin-right: 40px;" data-select2-id="17" tabindex="-1" aria-hidden="true" >
						<option selected disabled>종류</option>
						<option>주간</option>
					</select><br><br>
					
					<span class="text" style="margin-right: 60px">부서</span> 
					<input class="form-control" type="hidden" style="width: 30%; margin-right: 150px;" name="dept"  value="${authUser.dept_code }">
					<input class="form-control" type="text" style="width: 30%; margin-right: 150px; background-color: white;"value="${authUser.dept_name }" disabled="disabled">
<!-- 					<select class="dynamicElement form-control select2bs4 select2-hidden-accessible" style="width: 30%; margin-right: 40px;" data-select2-id="17" tabindex="-1" aria-hidden="true"  -->
<%-- 							name="dept" data-url="<c:url value= '/work/getDeptList'/>"> --%>
<!-- 						<option selected disabled>부서</option> -->
<!-- 					</select>  -->
					
					<span class="text" style="margin-right: 60px">팀</span> 
					<input class="form-control" type="hidden" style="width: 30%; " name="team_code" value="${authUser.team_code }">
					<input class="form-control" type="text" style="width: 30%; background-color: white;" value="${authUser.team_name }" disabled="disabled"><br><br>
<!-- 					<select class="dynamicElement form-control select2bs4 select2-hidden-accessible" style="width: 30%; margin-right: 40px;" data-select2-id="17" tabindex="-1" aria-hidden="true"  -->
<%-- 							name="team_code" data-url="<c:url value= '/work/getTeamList'/>"> --%>
<!-- 						<option selected disabled>팀</option> -->
<!-- 					</select><br><br> -->
					
					<span class="text" style="margin-right: 45px">업무일</span> <input class="form-control" type="date" style="width: 80%" name="wl_date" value="${worklog.wl_date }"><br><br>
					
					
					<c:if test="${not empty worklog.attatchList }">
						<c:forEach items="${worklog.attatchList }" var="attatch" varStatus="vs">
							<span class="eachAttatch">${attatch.org_name }
								<span class="delBtn" data-attno="${attatch.wl_attcode }"> <ion-icon name="trash-outline"></ion-icon></span>
								${not vs.last? "&nbsp;" : "" }
							</span>
						</c:forEach>
					</c:if>
					<span class="text" style="margin-right: 60px">첨부</span> 
					<!-- 첨부파일 -->
			        <input type="button" id="btnAttatch" class="btn btn-default" value="파일첨부" onclick="fileAttatch()">
			        <div id="attatchDiv"  style="display: inline-block;"></div><br><br>
			         
					
					<span class="text" style="margin-right: 60px">내용</span><br><br>
					<textarea class="form-control" id="worklog_content" name="wl_content" value="${worklog.wl_content }"> </textarea> 
					<br><br>
				</div>
				<div class="card-footer">
					<button type="submit" class="btn btn-primary float-right" id="save" >등록</button>
				</div>
			</form>
		</div>
	</div>
</form:form>

<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/dynamicSelect.js?time=${System.currentTimeMillis()}"></script>

<script>
	function fileAttatch(){
	    $("#attatchDiv").append("<input type='file' name='wl_files' style='margin:10px'/>");
	 }
 
	$()
	CKEDITOR.replace('worklog_content',{
		 // Adding drag and drop image upload.
	      uploadUrl: '${pageContext.request.contextPath}/board/image?command=QuickUpload&type=Files&responseType=json',
	
	     // Configure your file manager integration. This example uses CKFinder 3 for PHP.
	      filebrowserImageUploadUrl: '${pageContext.request.contextPath}/board/image?command=QuickUpload&type=Images',
	});
	
	var worklogForm = $("#worklogForm");
	$(".delBtn").on("click", function(){
		let wl_attcode = $(this).data("wl_attcode");
		worklogForm.append(
			$("<input>").attr({
				type : "text"
				, name : "deleteAttatches"
				, value : wl_attcode
			})		
		);
		$(this).parent("span:first").remove();
	}); 
	
	
	$("#exampleCheck1").on("click", function(){
		if($(this).attr("checked", true)){
			$(this).val("Y");
		}
	});

	
	// 부서 동적 셀렉박스
	optionPtrn = "<option value='%V' %S>%T</option>";
	var deptTag = $("select[name='dept']").data("success", function(resp){
		
		var html = "";
		$.each(resp, function(i, dept){
			var selected = "";
			if(dept.dept_name == '${worklog.dept_code}'){
				selected = "selected"; 
			}
			html += optionPtrn.replace("%V", dept.dept_code)
							  .replace("%T", dept.dept_name)
							  .replace("%S", selected);
		});
		deptTag.append(html);
	}).on("change", function(){
		let dept_code = $(this).val();
		
		team_codeTag.trigger("renew", {
			dept_code : dept_code
		});

	});
	
	var team_codeTag = $("select[name='team_code']").data("success", function(resp){
		var html = "<option value=''>팀</option>";
		$.each(resp, function(i, team){
			var selected = "";
			if(team.team_name == '${worklog.team_code}'){
				selected = "selected";
			}
			html += optionPtrn.replace("%V", team.team_code)
							  .replace("%T", team.team_name)
							  .replace("%S", selected);
		});
		team_codeTag.html(html);
	});
	
	
	
	$(".dynamicElement").dynamicSelect();
	
</script>