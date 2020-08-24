<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<script src="${cPath }/resources/ckeditor/ckeditor.js"></script>
<style>
	#content {padding: 50px;}
	.smallForm {display: inline;float: left;margin-right: 50px;}
	.card-body{width: 100%; padding: 20px 40px 20px 40px}
</style>


<div id="content">
<form method="post" action="${cPath }/project/${state}" enctype="multipart/form-data" id="newPjForm">
	<input type="hidden" name="project_code" value="${project.project_code }"/>
	<div class="card card-primary">
		<div class="card-header">
			<c:if test="${empty project}">
				<h3 class="card-title">새 프로젝트</h3>
			</c:if>
			<c:if test="${not empty project}">
				<h3 class="card-title">프로젝트 수정</h3>
			</c:if>
		</div>
		<div class="card-body">

			<!-- 프로젝트명 -->
			<div class="form-group">
				<label for="inputName">프로젝트 명</label> 
				<input type="text" id="inputName" class="form-control" style="width: 60%;" name="project_name"
					value="${project.project_name }">
			</div>

			<!-- 부서 -->
			<div class="form-group">
				<label for="inputStatus">부서</label>
				<div>
					<select class="form-control" style="width: 200px;" name="dept_code">
						<option selected disabled>부서</option>
						<c:if test="${not empty deptList }">
							<c:forEach items="${deptList }" var="map">
								<c:set var="selected"
									value="${(map.dept_code eq project.dept_code) or (map.dept_name eq project.dept_name)? 'selected' : ''}" />
								<option value="${map.dept_code }" ${selected }>${map.dept_name }</option>
							</c:forEach>
						</c:if>
					</select>
				</div>
			</div>

			<!-- 요약 -->
			<div class="form-group">
				<label for="inputName">요약</label> <input type="text" id="inputName"
					class="form-control" style="width: 60%;" name="project_sum"
					value="${project.project_sum }">
			</div>

			<!-- 내용 -->
			<div class="form-group">
				<label for="inputDescription">내용</label>

				<textarea class="form-control" name="project_content"
					id="project_content">
					${project.project_content}
				</textarea>
			</div>

			<!-- 팀역할 -->
			<div class="form-group">
				<label for="inputName">팀역할</label>
				<select class="select2bs4 select2-hidden-accessible" multiple="multiple" data-placeholder="팀원" style="width: 100%;" data-select2-id="23" tabindex="-1" aria-hidden="true" name="pr_code">
                    <c:set var="rgroupList" value="${project.pj_rgroupList }"></c:set>
                    
                    <!-- 수정이라면 -->
                    <c:if test="${not empty rgroupList }">
	                    <c:forEach items="${roleList }" var="role">
	                    	<c:forEach items="${rgroupList}" var="rgroup">
		                    	<c:set var="selected"
  		                    		value="${(role.pr_code eq rgroup.pr_code)? 'selected' : ''}" />
							<option class="selectRole" value="${role.pr_code}" ${selected }>${role.pr_name }</option> 
 		                    </c:forEach> 
 						</c:forEach> 
					</c:if>
					
					<!-- 등록이라면 -->
					<c:if test="${empty rgroupList }">
						 <option>등록</option>
						 <c:forEach items="${roleList }" var="role">
						 	<option class="selectRole" value="${role.pr_code}">${role.pr_name }</option>
						 </c:forEach>
					</c:if>
                  </select>
			</div>



			<!-- 시작일 & 종료일 -->
			<div style="display: block; height: 90px;">
				<div class="form-group smallForm">
					<label for="inputStart">시작일</label>
					<div class="input-group">
						<input type="date" class="form-control" style="width: 200px;" name="project_start"
							value="${project.project_start}">
					</div>
					<!-- /.input group -->
				</div>

				<div class="form-group smallForm">
					<label for="inputEnd">종료일</label>
					<div class="input-group">
						<input type="date" class="form-control" style="width: 200px;" name="project_end"
							value="${project.project_end}">
					</div>
					<!-- /.input group -->
				</div>
			</div>


			<!-- 상태 -->
			<div class="form-group smallForm">
				<label for="inputStatus">상태</label>
				<div>
					<select class="form-control" style="width: 200px;" name="project_stat">
						<option selected disabled>상태</option>
						<c:if test="${not empty sttList }">
							<c:forEach items="${sttList }" var="map">
								<c:set var="selected"
									value="${(map.standard_code eq project.project_stat) or (map.standard_name eq project.project_stat)? 'selected' : ''}" />
								<option value="${map.standard_code }" ${selected }>${map.standard_name }</option>
							</c:forEach>
						</c:if>
					</select>
				</div>
			</div>


			<!-- 중요도 -->
			<div class="form-group ">
				<label for="inputStatus">중요도</label>
				<div>
					<select class="form-control" style="width: 200px;" name="project_important">
						<option selected disabled>중요도</option>
						<c:if test="${not empty impList }">
							<c:forEach items="${impList }" var="map">
								<c:set var="selected"
									value="${(map.standard_code eq project.project_important) or (map.standard_name eq project.project_important)? 'selected' : ''}" />
								<option value="${map.standard_code }" ${selected }>${map.standard_name }</option>
							</c:forEach>
						</c:if>
					</select>
				</div>
			</div>

			<!-- 공개여부 -->
			<div class="form-group" style="margin-top: 16px;">
				<label for="inputName">공개여부</label>
				<div>
					<c:set var="showChecked"
						value="${(project.project_hide eq 'N')? 'checked' : ''}" />
					<c:set var="hideChecked"
						value="${(project.project_hide eq 'Y')? 'checked' : ''}" />
					공개 <input type="radio" name="project_hide" value="N" ${showChecked } />
					&nbsp;&nbsp;&nbsp;&nbsp; 
					비공개 <input type="radio" name="project_hide"	value="Y" ${hideChecked } />
				</div>
			</div>
		</div>
		
		
		<!-- /.card-body -->
		<div class="card-footer">
			<button type="submit" class="btn btn-default float-right"
				onclick="location.href='${pageContext.request.contextPath }/project/projectlist/project/list'">취소</button>
			<button type="submit" class="btn btn-primary float-right"
				style="margin-right: 10px;">등록</button>
		</div>
	</div>
</form>
</div>

<!-- Select2 -->
<script src="${cPath }/resources/plugins/select2/js/select2.full.min.js"></script>
<link rel="stylesheet" href="${cPath }/resources/plugins/select2/css/select2.min.css">
<link rel="stylesheet" href="${cPath }/resources/plugins/select2-bootstrap4-theme/select2-bootstrap4.min.css">
<script>

  //Initialize Select2 Elements
  $('.select2').select2()

  //Initialize Select2 Elements
  $('.select2bs4').select2({
    theme: 'bootstrap4'
  })

</script>

<!-- 역할 선택 -->
<script>
	$("#newPjForm").on("submit", function(){
		var checked = $(".selectRole:selected");
		var inputList = [];
		
		$(checked).each(function(idx,item){
			let val = $(this).attr("value");
			let input = $("<input>").attr({
				name : 'pj_rgroupList['+idx+'].pr_code',
				type : 'hidden',
				value : val
			})
			inputList.push(input);
		});
		$(this).append(inputList);
		return true;
	});
	
</script>

<!-- 프로젝트 수정 -->
<script>

	if(${message ne null}){
		alert("${message}");
	}
</script>


<!-- ckEditor -->
<script>
	$()
	CKEDITOR
			.replace(
					'project_content',
					{
						// Adding drag and drop image upload.
						uploadUrl : '${pageContext.request.contextPath}/board/image?command=QuickUpload&type=Files&responseType=json',

						// Configure your file manager integration. This example uses CKFinder 3 for PHP.
						filebrowserImageUploadUrl : '${pageContext.request.contextPath}/board/image?command=QuickUpload&type=Images',
					});
</script>