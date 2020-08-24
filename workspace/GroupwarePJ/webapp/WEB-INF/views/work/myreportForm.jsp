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

<form:form id="reportForm" modelAttribute="report" method="post" enctype="multipart/form-data" class="w-100" action="${cPath }/work/workreport/insertreport">
	<div class = "content" style="margin: 40px 60px 0 60px">
		<div class="card card-primary" style="width: 100%;">
			<div class="card-header" >
				<h3 class="card-title">업무보고 작성</h3>
			</div>
			<form role="form">
				<div class="card-body" style="width: 100%; padding: 20px 40px 20px 40px">
					<input type="hidden" name="report_code" value="${report.report_code }">
				
					<span class="text" style="margin-right: 30px">일지첨부</span> 
					<button  id="att" type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#exampleModal"> 첨부 </button><br><br>
<!-- 					<input type="button " id="att" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#exampleModal"><br><br> -->
					
					
					<span class="text" style="margin-right: 60px">제목</span> 
						<input class="form-control" type="text" style="width: 80%" name="report_title" value="${report.report_title }"><br><br>
<%-- 						<form:errors path="wl_title" element="span" cssClass="error"/> --%>
					
					<span class="text" style="margin-right: 60px">부서</span> 
					<select class="dynamicElement form-control select2bs4 select2-hidden-accessible" style="width: 30%; margin-right: 40px;" data-select2-id="17" tabindex="-1" aria-hidden="true" 
							name="dept" data-url="<c:url value= '/work/getDeptList'/>">
						<option selected disabled>부서</option>
					</select> 
					
					<span class="text" style="margin-right: 60px">팀</span> 
					<select class="dynamicElement form-control select2bs4 select2-hidden-accessible" style="width: 30%; margin-right: 40px;" data-select2-id="17" tabindex="-1" aria-hidden="true" 
							name="team_code" data-url="<c:url value= '/work/getTeamList'/>">
						<option selected disabled>팀</option>
					</select><br><br>
					
					<span class="text" style="margin-right: 45px">보고일</span> 
					<input class="form-control" type="date" style="width: 80%" name="report_date" value="${report.report_date }"><br><br>
					
					<span class="text" style="margin-right: 30px">보고대상</span> 
					<select class="dynamicElement form-control select2bs4 select2-hidden-accessible" style="width: 30%; margin-right: 40px;" data-select2-id="17" tabindex="-1" aria-hidden="true" 
							name="emp_target" data-url="<c:url value= '/work/getEmpList'/>">
						<option selected disabled>보고대상</option>
					</select><br><br>
					
<!-- 					<span class="text" style="margin-right: 23px">도장/사인</span>  -->
<!-- 					<input type="file" name="report_stamp"><br><br> -->

<%-- 					<c:if test="${not empty worklog.attatchList }"> --%>
<%-- 						<c:forEach items="${worklog.attatchList }" var="attatch" varStatus="vs"> --%>
<%-- 							<span class="eachAttatch">${attatch.org_name } --%>
<%-- 								<span class="delBtn" data-attno="${attatch.wl_attcode }">[DEL]</span> --%>
<%-- 								${not vs.last? "&nbsp;" : "" } --%>
<!-- 							</span> -->
<%-- 						</c:forEach> --%>
<%-- 					</c:if> --%>

					<div style="display: none" id="orgatt">
					
					</div><br>
					<span class="text" style="margin-right: 60px">첨부</span> 
					<!-- 첨부파일 -->
			        <input type="button" id="btnAttatch" class="btn btn-default" value="파일첨부" onclick="fileAttatch()">
			        <div id="attatchDiv"  style="display: inline-block;"></div><br><br>
					
					
					<span class="text" style="margin-right: 60px">내용</span><br><br>
					<textarea class="form-control" id="report_content" name="report_content" value="${report.report_content }"> </textarea> 
					
				</div>
					<div class="card-footer">
						<button type="submit" class="btn btn-primary float-right" id="save">등록</button>
					</div>
			</form>
		</div>
	</div>
</form:form>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-scrollable modal-xl">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">팀 일지 목록</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      	<table class="table">
      		<thead>
      			<tr>
      				<th>#</th>
      				<th>작성일</th>
      				<th>일지제목</th>
      			</tr>
      		</thead>
      		<tbody id="listBody">
      		
      		</tbody>
      	</table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>


<form id="searchForm" action="${cPath }/work/workreport/insertreport">
	<input type="hidden" name="page" value="${param.page }"/>
</form>

<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/dynamicSelect.js?time=${System.currentTimeMillis()}"></script>
<script>
	function fileAttatch(){
	    $("#attatchDiv").append("<input type='file' name='re_files' style='margin:10px'/>");
	 }

	$()
	CKEDITOR.replace('report_content',{
		 // Adding drag and drop image upload.
	      uploadUrl: '${pageContext.request.contextPath}/board/image?command=QuickUpload&type=Files&responseType=json',
	
	     // Configure your file manager integration. This example uses CKFinder 3 for PHP.
	      filebrowserImageUploadUrl: '${pageContext.request.contextPath}/board/image?command=QuickUpload&type=Images',
	});
	
	var reportForm = $("#reportForm");
	$(".delBtn").on("click", function(){
		let report_attcode = $(this).data("report_attcode");
		reportForm.append(
			$("<input>").attr({
				type : "text"
				, name : "deleteAttatches"
				, value : report_attcode
			})		
		);
		$(this).parent("span:first").remove();
	}); 
	

	$("#exampleCheck1").on("click", function(){
		if($(this).attr("checked", true)){
			$(this).val("Y");
		}
	});


	optionPtrn = "<option value='%V' %S>%T</option>";
	var deptTag = $("select[name='dept']").data("success", function(resp){
		
		var html = "";
		$.each(resp, function(i, dept){
			html += optionPtrn.replace("%V", dept.dept_code)
							  .replace("%T", dept.dept_name)
							  .replace("%S", dept.dept_code == "${deptlist.dept_code}"?"selected":"");
		});
		deptTag.append(html);
	}).on("change", function(){
		let dept_code = $(this).val();
		
		team_codeTag.trigger("renew", {
			dept_code : dept_code
		});
		
		emp_targetTag.trigger("renew", {
			dept_code : dept_code
		});
	});
	
	var team_codeTag = $("select[name='team_code']").data("success", function(resp){
		var html = "<option value=''>팀</option>";
		$.each(resp, function(i, team){
			html += optionPtrn.replace("%V", team.team_code)
							  .replace("%T", team.team_name)
							  .replace("%S", team.team_code == "${report.team_code}" ? "selected": "");
		});
		team_codeTag.html(html);
	});

	var emp_targetTag = $("select[name='emp_target']").data("success", function(resp){
		var html = "<option value>보고대상</option>";
		$.each(resp, function(i, target){
			html += optionPtrn.replace("%V", target.emp_code)
							  .replace("%T", target.emp_kor)
							  .replace("%S", target.emp_code == "${report.emp_target}"?"selected":"");
		});
		emp_targetTag.html(html);
	});
	
	
	
	$(".dynamicElement").dynamicSelect();


	
	// 모달
	var listBody = $("#listBody");
	var searchForm = $("#searchForm").paging({
		searchUI:"#searchUI",
		searchBtn:"#searchBtn",
		pagination:"#pagingArea",
		pageParam:"page",
		byAjax:true,
		success:function(resp){
			let worklogList = resp.dataList;
			let pagingHTML = resp.pagingHTML;
			let trTags = [];
			if(worklogList.length>0){
				$.each(worklogList, function(idx, worklog){
					let trTag = $("<tr>").append(
									$("<td>").text(worklog.rnum)
									, $("<td>").text(worklog.wl_date)
									, $("<td>").text(worklog.wl_title)
									, $("<p>").html('<button type="button" class="btn btn-default" data-dismiss="modal" id="addWl" data-code='+worklog.wl_code+' style="margin-left:10px;">추가</button>')
								);
					trTags.push(trTag);
				});
			}
			listBody.html(trTags);
			listBody.data("currentPage", resp.currentPage);
			$("#pagingArea").html(pagingHTML);
			searchForm.find("[name='page']").val("");
		}
	});
	
	$(".modal-body").on("click","button",function(){
		let code = $(this).attr("data-code");
		$.ajax({
			url : "${cPath}/work/workreport"
			,method : "post"
			,dataType : "json"
			,data : {
				wl_code : code
			}
			,success: function(resp){
				$("input[name=report_title]").val(resp.wl_title);
				$("select[name=team_code]").find("option[value="+resp.team_code+" ]").attr("selected",true);
				$("select[name=dept]").find("option[value="+resp.dept_code+" ]").attr("selected",true);
				$("input[name=report_date]").val(resp.wl_date);
				CKEDITOR.instances.report_content.setData(resp.wl_content);
				
				let tags = [];
				var attList = resp.attatchList;
				
				if(attList != null){
					$("#orgatt").css("display", "inline");
					let spanTag3 = $("<span>").addClass("text").css("margin-right", "45px").text("기존파일");
					$.each(attList, function(idx, attatch){
						console.log(attatch);
						let spanTag1 = $("<span>").addClass("eachAttatch").text(attatch.org_name);
						let hidden = $("<input type='hidden' name='wl_attcode'>").val(attatch.wl_attcode);
						let spanTag2 = $("<span data-attno='"+ attatch.wl_attcode +"'>").addClass("delBtn").text("[DEL] ");
						
						tags.push(spanTag3, spanTag1, spanTag2, hidden);
						console.log(hidden);
					})
					$("#orgatt").append(tags);
				}
				
				$(".delBtn").on("click", function(){
					
// 					let wl_attcode = $(this).data("wl_attcode");
					
					$(this).parent().children().eq(1).remove();
					$(this).parent().children().eq(2).remove();
					$(this).remove();
				}); 
				
			}
				
		})
	})
	
	
	
	
	searchForm.submit();
</script>

