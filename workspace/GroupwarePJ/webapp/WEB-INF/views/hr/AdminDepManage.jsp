<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    

<style>
	#content {padding: 30px;}
	.chkBox {width: 15px;height: 15px;}
	#nav{float:right;width:140px;margin-top:10px;}
	h2{margin:10px 0 0 0;}
	#searchBtn{width:40px; heigth:40px;}
</style>

<div id="content">
	<div class="col-12">
		<div class="card">
			<div class="card-header">
				<h2>부서 현황</h2>
				
		        <div id="nav">
					<a class="btn btn-primary btn-sm" href="${cPath}/hr/employer/depenroll">
				        <i class="fas fa-folder">
				        </i>
				       	 등록
				    </a>
				  
				    <button class="btn btn-danger btn-sm" onclick="deleteAction()">
				        <i class="fas fa-trash">
				        </i>
				    	 삭제
				    </button>
				</div>
			</div>

			<div class="card-body table-responsive p-0">
         		<table id="example2" class="table table-hover dataTable dtr-inline" role="grid" aria-describedby="example2_info">
					<thead>
						   <tr>
						   <th rowspan="1" colspan="1">선택</th>
						   <th rowspan="1" colspan="1">부서코드</th>
						   <th rowspan="1" colspan="1">부서명</th>
						   </tr>
				    </thead>
                 	<tbody id="listBody"></tbody>
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


<form id="searchForm" action="${pageContext.request.contextPath }/hr/departmentmanage">
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
				let depList = resp.dataList;
				let pagingHTML = resp.pagingHTML;
				let trTags = [];
				if(depList.length>0){
					$.each(depList, function(idx, depmanage){
						let trTag = $("<tr>").append(
										$("<td>").html('<input type="checkbox" name="checkRow" value="'+depmanage.dept_code+'" />')
										, $("<td>").text(depmanage.dept_code)
										, $("<td>").text(depmanage.dept_name)
										);
						trTags.push(trTag);
					});
					$("#pagingArea").html(pagingHTML);
				}else{
					trTags.push($("<tr>").html($("<td colspan='8'>").text("조건에 맞는 부서가 없음.")));
					$("#pagingArea").empty();
				}
				listBody.html(trTags);
				listBody.data("currentpage", resp.currentPage);
				searchForm.find("[name='page']").val("");
			}
		}).submit();
	


		
		
		
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
	    alert("삭제할 부서를 선택하세요.");
	    return false;
	  }
	  console.log("### checkRow => {}"+checkRow);
	 
	  if(confirm("부서를 삭제 하시겠습니까?")){
		  $.ajax({
	            url : '${pageContext.request.contextPath }/hr/employer/deletedept',
	            type : "POST",
	            datatype : 'json',
	            contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
	            data:{
	                dept_code : checkRow
	            },
	            success : function(data) {
				    alert("삭제가 완료되었습니다.");
				    location.href="${pageContext.request.contextPath }/hr/departmentmanage";
	                
	            },
	            error:function(request, status, error) {
	            	alert("삭제를 실패하였습니다.");
	 
	            }
		 })
	        

	  }
	}


</script>

               
                
                   
