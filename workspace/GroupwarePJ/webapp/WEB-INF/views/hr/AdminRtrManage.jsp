<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    

<style>
	#content {padding: 30px;}
	.chkBox {width: 15px;height: 15px;}
	#nav{float:right;width:60px;margin-top:10px;}
	h2{margin:10px 0 30px 0;}
	#searchBtn{width:40px; heigth:40px;}
</style>

<div id="content">
	<div class="col-12">
		<div class="card">
			<div class="card-header">
				<h2>퇴사자 관리</h2>
				
				<!-- 검색 -->
				<div class="form-group" id="searchUI">
					<select name="searchType" class="form-control select2 select2-hidden-accessible" style="width: 10%; float: left" data-select2-id="1" tabindex="-1" aria-hidden="true">
						<option value="" data-select2-id="3" selected disabled>검색 방법</option>
						<option value="empnum" 
							data-select2-id="34">사원번호</option>
						<option value="empnm" 
							data-select2-id="35">사원명</option>
						<option value="deptnm" 
							data-select2-id="36">부서명</option>
						<option value="teamnm" 
							data-select2-id="36">팀명</option>
						<option value="position" 
							data-select2-id="36">직급</option>
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
				     <button class="btn btn-danger btn-sm" onclick="deleteAction()">
				        <i class="fas fa-trash"> </i>삭제
				    </button>
				</div>
			</div>

			<div class="card-body table-responsive p-0">
			    <table class="table table-striped projects">                
					<thead>
						   <tr>
							   <th rowspan="1" colspan="1">선택</th>
							   <th rowspan="1" colspan="1">사원명</th>
							   <th rowspan="1" colspan="1">부서명</th>
							   <th rowspan="1" colspan="1">팀명</th>
							   <th rowspan="1" colspan="1">직급</th>
							   <th rowspan="1" colspan="1">입사일</th>
							   <th rowspan="1" colspan="1">퇴사일</th>
						   </tr>
				    </thead>
			        <tbody id="listBody">
			        </tbody>
			    </table>
		    </div>

			<div style="margin:20px 20px 20px 20px;">
				<nav id="pagingArea" class="d-flex ml-md-auto d-print-none">
					${pagingVO.pagingHTML }
				</nav>	
			</div>	
		</div>
	</div>
</div>

<form id="searchForm" action="${pageContext.request.contextPath }/hr/employer/retiremanage">
	<input type="hidden" name="page" value="${param.page }"/>
	<input type="hidden" name="searchType" value=""/>
	<input type="hidden" name="searchWord" value=""/>
</form>

<script type="text/javascript">

//테이블 만들기
	
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
					$.each(empList, function(idx, empmanage){
// 						if(empmanage.retire_date!=null){
							
						
						let trTag = $("<tr>").append(
								$("<td>").html('<input type="checkbox" name="checkRow" value="'+empmanage.emp_code+'" />')
// 										,$("<td>").html(empmanage.emp_kor)
										, $("<td>").html(
											$("<a>").attr("href", "${pageContext.request.contextPath}/hr/employer/detailempinfo/" + empmanage.emp_code)
													.text(empmanage.emp_kor)													
										)
										, $("<td>").text(empmanage.dept_code)
										, $("<td>").text(empmanage.team_code)
										, $("<td>").text(empmanage.position_code)
										, $("<td>").text(empmanage.emp_startdate)
										, $("<td>").text(empmanage.retire_date)
										);
						trTags.push(trTag);
//						}
						
					});
					$("#pagingArea").html(pagingHTML);
				}else{
					trTags.push($("<tr>").html($("<td colspan='8'>").text("조건에 맞는 사원이 없음.")));
					$("#pagingArea").empty();
				}
				listBody.html(trTags);
				listBody.data("currentpage", resp.currentPage);
				searchForm.find("[name='page']").val("");
			}
		}).submit();
				
			
</script>

<script>
	
	//전체 선택
	function checkAll(){
	      if( $("#th_checkAll").is(':checked') ){
	        $("input[name=checkRow]").prop("checked", true);
	      }else{
	        $("input[name=checkRow]").prop("checked", false);
	      }
	}

//체크된것 삭제(체크박스된 것 전부)
	function deleteAction(){
	  var checkRow = "";
	  $( "input[name='checkRow']:checked" ).each (function (){
	    checkRow = checkRow + $(this).val()+"," ;
	  });
	  checkRow = checkRow.substring(0,checkRow.lastIndexOf( ",")); //맨끝 콤마 지우기
	 
	  if(checkRow == ''){
	    alert("삭제할 사원을 선택하세요.");
	    return false;
	  }
	  console.log("### checkRow => {}"+checkRow);
	 
	  if(confirm("사원정보를 삭제 하시겠습니까?")){
		  $.ajax({
	            url : '${pageContext.request.contextPath }/hr/employer/deleteemp',
	            type : "POST",
	            datatype : 'json',
	            contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
	            data:{
	                emp_code : checkRow
	            },
	            success : function(data) {
				    alert("삭제가 완료되었습니다.");
				    location.href="${pageContext.request.contextPath }/hr/employer/retiremanage/${who}";
	                
	            },
	            error:function(request, status, error) {
	            	alert("삭제를 실패하였습니다.");
	 
	            }
		 })
	        

	  }
	 
	}
	
</script>			
				
				
				
				
				
				
				
                  