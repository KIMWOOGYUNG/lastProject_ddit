<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<style>
#content {
	padding: 50px;
}
.btnAddEmp{
	height:34px;
	margin-bottom:3px;
}
.empDiv{
	border: 1px solid #ced4da;
    border-radius: .25rem;
    height: calc(2.25rem + 2px);
    padding: .375rem .75rem;
    box-sizing: border-box;
    width:60%;
}
</style>

<div id="content">

	<form id="memForm" method="post" action="${cPath }/project/tmManage/${project.project_code}">
		<input type="hidden" name="project_code" value="${project.project_code}"/>
		<div class="card card-primary">
		  <div class="card-header">
		    <h3 class="card-title">프로젝트 팀 관리</h3>
		  </div>
		  <!-- /.card-header -->
		  <!-- form start -->
		    <div class="card-body">
		      <!-- 프로젝트명 -->
				<div class="form-group">
					<label for="inputName">프로젝트 명</label> <input type="text"
						id="inputName" class="form-control" style="width: 60%;" name="project_name"
						value="${project.project_name}">
				</div>
				<br>
			  <!-- 팀원 -->	
		      <div class="form-group">
		        <label for="exampleInputPassword1">프로젝트 역할 구성</label>
		        <c:forEach items="${rgroupList }" var="rgroup" >
		       	 <div class="list">
	                    <span class="input-group-text" style="width:60px; display:inline"><i class="fas fa-user"></i>&nbsp;${rgroup.pr_name}</span>
			        	<button type="button" class="btn btn-secondary btnAddEmp" id="${rgroup.pr_code}" data-toggle="modal" data-target="#modal-lg"> 
	 						추가
	 					</button>
	 					<div class="empDiv" data-code="${rgroup.pr_code}" data-prg_code="${rgroup.prg_code }">
	 						
	 					
	 							<c:forEach items="${rgroup.pj_memberList }" var="member">
	 						<c:if test="${member.emp_code ne null }">
			        			<span id="emp_span" data-code="${member.emp_code }" data-pos="${member.position_name }" data-name="${member.emp_kor }">${member.emp_kor }</span>
			        			<input type="hidden" value="${member.emp_code }"/>
	 						</c:if>
	 							</c:forEach>
			       		</div>
			       		<br>
			        </div>
		        </c:forEach>
		      </div>
		    </div>
		    <!-- /.card-body -->
		
		    <div class="card-footer">
		      <button type="button" class="btn btn-default float-right">취소</button>
		      <button type="submit" class="btn btn-primary float-right" id="btnFinish">완료</button>
		    </div>
		</div>
	</form>
</div>

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
					<select class="dynamicElement form-control mr-2" name="deptcode"
						data-url="<c:url value='/addTeam/getDeptList.do'/>"
					>
						<option selected disabled>부서</option>
						
					</select>
					<select class="dynamicElement form-control mr-2" name="team_code"
						data-url="<c:url value='/addTeam/getTeamList.do' />"
					>
						
					</select>
					
					<input class="btn btn-success mr-2" type="button" value="검색" id="searchBtn">
				</div>
				
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th>사원명</th>
							<th>직급</th>
						</tr>
					</thead>
					<tbody id="listBody">
						
					</tbody>
					<tfoot>
						<tr>
							<td colspan="3">
								<nav id="pagingArea">
									${pagingVO.pagingHTML }
								</nav>
							</td>
						</tr>
					</tfoot>
				</table>
				
				<hr>
							
				<table class="table">
					<thead>
						<tr>
							<th> </th>
							<th>사원명</th>
							<th>직급</th>
						</tr>
					</thead>
					<tbody id="addedBody">
						
					</tbody>
				</table>

			</div>
			
			<div class="modal-footer">
				<button type="submit" class="btn btn-primary" data-dismiss="modal" aria-label="Close" id="addAll">등록</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript" src="${cPath }/resources/js/dynamicSelect.js?time=${System.currentTimeMillis()}"></script>
<script type="text/javascript" src="${cPath  }/resources/js/paging.js?time=${System.currentTimeMillis()}"></script>


<form id="searchForm" action="${cPath  }/project/tmManage/${project.project_code}">
	<input type="hidden" name="page" value="${param.page }"/>
	<input type="hidden" name="dept_code" value=""/>
	<input type="hidden" name="team_code" value=""/>
</form>

<script>

	//부서 선택시
	var optionPtrn = "<option value='%V' %S>%T</option>";
	var deptTag = $("select[name='deptcode']").data("success", function(resp){
		var html = "";
		$.each(resp, function(idx, dept){
			html += optionPtrn.replace("%V", dept.dept_code).replace("%T", dept.dept_name);
		});
		deptTag.append(html);
	}).on("change", function(){
		let dept_code = $(this).val();

		teamTag.trigger("renew", {
			dept_code : dept_code
		});
	});
	
	//팀 선택시
	var teamTag = $("select[name='team_code']").data("success", function(resp){
		var html = "<option selected disabled>팀</option>";
		$.each(resp, function(idx, team){
			html += optionPtrn.replace("%V", team.team_code).replace("%T", team.team_name);
		});
		teamTag.html(html);
	});
	
	$(".dynamicElement").dynamicSelect();
	
	//사원 검색
	var listBody = $("#listBody");
	var searchForm = $("#searchForm").paging({
		searchUI:"#searchUI",
		searchBtn:"#searchBtn",
		pagination:"#pagingArea",
		pageParam:"page",
		byAjax:true,
		success:function(resp){
			let empList = resp.dataList;
			let pagingHTML = resp.pagingHTML;
			let trTags = [];
			if(empList.length>0){   
				$.each(empList, function(idx, emp){
					let trTag = $("<tr>").append(
									$("<td>").text(emp.rnum)
									, $("<td>").text(emp.emp_kor)
									, $("<td>").text(emp.position_name)
									, $("<p>").html('<button type="button" class="btn btn-default" id="addTM" style="margin-left:10px;">추가</button>')
								).attr("data-code", emp.emp_code).attr("data-name", emp.emp_kor).attr("data-pos", emp.position_name);
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
	
	//임시 목록에 추가
	$("#listBody").on("click","button",function(){
		let clickData = $(this).parents("tr");
		let data_code = clickData.attr("data-code");
		let sameData = $("#addedBody").find("tr[data-code="+data_code+"]");
		let cloneTag = clickData.clone();
		cloneTag.find("button").text("삭제");
		let tags= []
	
		if(sameData.length > 0){   
			return;
		}else{
			$("#addedBody").append(cloneTag);	
		}
	})

	//임시 목록에서 삭제
	$("#addedBody").on("click","button",function(){
		let clickData = $(this).parents("tr");
		clickData.remove();
	})
	
	//추가버튼 클릭
	$(".btnAddEmp").on("click", function(){
		var id = $(this).attr('id');
		let dataList = $("div[data-code="+id+"]").find("span")
		$("#addedBody").empty();
		if(dataList.length > 0){
			let trTags = [];
			$.each(dataList,function(idx,data){
				let emp_kor = $(data).text();
				let emp_code= $(data).attr("data-code");
				let position_name = $(data).attr("data-pos");
// 				if(data != null){
				let trTag = $("<tr>").append(
						$("<td>").text(" "), 
						$("<td>").text(emp_kor)
						, $("<td>").text(position_name)
						, $("<p>").html('<button type="button" class="btn btn-default" id="addTM" style="margin-left:10px;">삭제</button>')
				).attr("data-code", emp_code).attr("data-name", emp_kor).attr("data-pos",position_name);
// 				}
				trTags.push(trTag);
			})
			
			$("#addedBody").append(trTags);	
		}
		
		$("#addAll").attr("data-code",id);
	});
	

	//모달 추가완료

	$("#addAll").on("click", function(){
		var tags = [];
		// 		let emp_code = $("#addedBody").find("tr").attr("data-code");
			$("#addedBody").find("tr").each(function(idx,item){
				var emp_code = $(item).attr("data-code");
				var emp_name = $(item).attr("data-name");
				var position_name = $(item).attr("data-pos");
				
// 					console.log("emp_code : "+emp_code+", emp_name : "+emp_name+", position_name : "+position_name);
					
				let input = $("<input>").attr({
					name : 'emp_code',
					type : 'hidden',
					value : emp_code
				})
				
				let span = $("<span data-code='"+emp_code+"' data-pos='"+position_name+"' >" ).text(emp_name);
				
				tags.push(input);
				tags.push(span);
			});
	
			let code = $(this).attr("data-code");
			let showAdded =$(".list").find("button[id="+code+"]").parents("div").find("div[data-code="+code+"]");	
			
			showAdded.html(tags);
	});
	
	//완료 클릭시 멤버 정보가 담김
	$("#memForm").on("submit", function(event){
		event.preventDefault();	//이벤트 막기.
		var roles = [];	//pj_rgroupVO와 동일한 구조
		var empCodes = [];
		
		$(".list").each(function(){
			let div = $(this).find("div:first");
			let roleCode = div.data('code');
			let prgCode = div.data('prg_code');
			let empCodes = [];
			div.each(function(){
				$(this).find("input[type=hidden]").each(function(){
					let empCode = {
						emp_code : $(this).val()
					};
					console.log("empCode : "+empCode);
					empCodes.push(empCode);
				});
				console.log("empCodes : "+empCodes);
			})
			let role = {
				pr_code : roleCode
				,pj_memberList : empCodes
				,prg_code : prgCode
			}
			roles.push(role);
		});
		console.log(roles);
		
		let url = $(this).attr("action");
		let method = $(this).attr("method");
		
		$.ajax({
			url : url,
			method : method,
			data : JSON.stringify(roles),	//마샬링
			contentType : 'application/json; charset=UTF-8',	//보낼 컨텐트 타입
			dataType : 'json',	//받을 타입
			success : function(resp){
				alert(resp.message);
				//resp의 값에 따라 이동할지 말지 결정.
				console.log("resp : " + resp);
				location.href = resp.goPage;
			}, error : function(request,status,error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
		
		return false;
	});

</script>