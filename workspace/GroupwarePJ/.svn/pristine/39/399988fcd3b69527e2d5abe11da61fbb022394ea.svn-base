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
										<th>#</th>
										<th>사원명</th>
										<th>직급</th>
									</tr>
								</thead>
								<tbody id="addedBody">
									
								</tbody>
<!-- 								<tfoot> -->
<!-- 									<tr> -->
<!-- 										<td colspan="3"> -->
<!-- 											<nav id="pagingArea"> -->
<%-- 												${pagingVO.pagingHTML } --%>
<!-- 											</nav> -->
<!-- 										</td> -->
<!-- 									</tr> -->
<!-- 								</tfoot> -->
							</table>
						</div>

						
						<div class="modal-footer justify-content-between">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">취소</button>
							<button type="button" class="btn btn-primary" data-dismiss="modal" aria-label="Close" id="addAll">완료</button>
						</div>
					</div>
				</div>
			</div>




<!-- 팀원추가모달창 -->

<form id="searchForm" action="${pageContext.request.contextPath }/project/newProject">
	<input type="hidden" name="page" value="${param.page }"/>
	<input type="hidden" name="dept_code" value=""/>
	<input type="hidden" name="team_code" value=""/>
</form>










	//팀 역할
//     var roleList = []
//     $.ajax({
//     	url : '${cPath}/project/roleList',
//     	contentType: "application/x-www-form-urlencoded; charset=UTF-8",
//     	success : function(resp) {
//             roleList = resp;
//         }
//     })
    
// 	//팀원 목록에 추가
// 	$("#listBody").on("click","button",function(){
// 		let clickData = $(this).parents("tr");
// 		let data_code = clickData.attr("data-code");
// 		let sameData = $("#addedBody").find("tr[data-code="+data_code+"]");
// 		let cloneTag = clickData.clone();
// 		cloneTag.find("button").text("삭제");
// 		let tags= []
		
// 		//역할
// 		$.each(roleList,function(idx, item){
// 			let tag = $("<option>").val(item.pr_code).text(item.pr_name);
// 			tags.push(tag)
// 		})	
		
// 		$("<select>").append(tags).insertBefore(cloneTag.find("button"));
		
		
// 		if(sameData.length > 0){
// 			return;
// 		}else{
// 			$("#addedBody").append(cloneTag);	
// 		}
// 	})
	
// 	//팀원 목록에서 삭제
// 	$("#addedBody").on("click","button",function(){
// 		let clickData = $(this).parents("tr");
// 		clickData.remove();
// 	})	
	
	
	
// 	//부서 선택시
// 	var optionPtrn = "<option value='%V' %S>%T</option>";
// 	var deptTag = $("select[name='deptcode']").data("success", function(resp){
// 		var html = "";
// 		$.each(resp, function(idx, dept){
// 			html += optionPtrn.replace("%V", dept.dept_code).replace("%T", dept.dept_name);
// 		});
// 		deptTag.append(html);
// 	}).on("change", function(){
// 		let dept_code = $(this).val();
	
// 		teamTag.trigger("renew", {
// 			dept_code : dept_code
// 		});
// 	});
	
// 	//팀 선택시
// 	var teamTag = $("select[name='team_code']").data("success", function(resp){
// 		var html = "<option selected disabled>팀</option>";
// 		$.each(resp, function(idx, team){
// 			html += optionPtrn.replace("%V", team.team_code).replace("%T", team.team_name);
// 		});
// 		teamTag.html(html);
// 	});
	
// 	$(".dynamicElement").dynamicSelect();
	
// 	//사원 검색
// 	var listBody = $("#listBody");
// 	var searchForm = $("#searchForm").paging({
// 		searchUI:"#searchUI",
// 		searchBtn:"#searchBtn",
// 		pagination:"#pagingArea",
// 		pageParam:"page",
// 		byAjax:true,
// 		success:function(resp){
// 			let empList = resp.dataList;
// 			let pagingHTML = resp.pagingHTML;
// 			let trTags = [];
// 			if(empList.length>0){
// 				$.each(empList, function(idx, emp){
// 					let trTag = $("<tr>").append(
// 									$("<td>").text(emp.rnum)
// 									, $("<td>").text(emp.emp_kor)
// 									, $("<td>").text(emp.position_name)
// 									, $("<p>").html('<button type="button" class="btn btn-default" id="addTM" style="margin-left:10px;">추가</button>')
// 								).attr("data-code", emp.emp_code);
// 					trTags.push(trTag);
// 				});
// 			}
// 			listBody.html(trTags);
// 			listBody.data("currentPage", resp.currentPage);
// 			$("#pagingArea").html(pagingHTML);
// 			searchForm.find("[name='page']").val("");
// 		}
// 	});
	
// 	searchForm.submit();
	
// 	//팀원 목록 추가 완료
// 	$("#addAll").on("click", function(){
// 		let added_emp_code = $("#addedBody").find("tr").attr("data-code");
// 		let added_emp_name = "";
// 		let added_role_name = "";
// 		let added_role_code = "";
// 		let added_emp = "";
// 		let added_emp_codes = "";
// 		let added_role_codes = "";
		
// 		$("#addedBody").find("tr").each(function(){
// 			added_emp_name = $(this).children().eq(1).text();
// 			added_role_name = $(this).children().eq(3).find(":selected").text();
// 			added_emp += added_emp_name + " (" + added_role_name + ") ";
// 			added_emp += " ";
			
// 			added_emp_code = $(this).children().eq(1).val();
// 			added_emp_codes += added_emp_code + ",";
// 			added_emp_codes = added_emp_codes.substring(0,added_emp_codes.lastIndexOf( ","));
// 			added_role_code = $(this).children().eq(3).find(":selected").val();
// 			added_role_codes += added_role_code + ",";
// 			added_role_codes = added_role_codes.substring(0,added_role_codes.lastIndexOf( ","));
// 		})
		
// 		$("#tmDiv").addClass("form-control").html(added_emp);
// 		$("[name=added_emp_codes]").attr("value",added_emp_codes);
// 		$("[name=added_role_codes]").attr("value",added_role_codes);
// 	});


<button type="button" class="btn btn-secondary"  id="btnAddEmp" data-toggle="modal" data-target="#modal-lg"> 
 						<i class="fas fa-users"></i>
 					</button>
 					<div id="tmDiv"></div>

<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/dynamicSelect.js?time=${System.currentTimeMillis()}"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/paging.js?time=${System.currentTimeMillis()}"></script>
