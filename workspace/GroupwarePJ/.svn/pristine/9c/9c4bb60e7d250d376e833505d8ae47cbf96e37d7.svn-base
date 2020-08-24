<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<style>
#searchBtn{width:40px; heigth:40px;}
#content {padding: 30px;}
#nav{float:right;}
.table-hover > tbody:hover  {
		cursor:Pointer
		}
</style>

<div id="content">
	<div class="col-12">
		<div class="card">
			<div class="card-header">
				<h2>중요 보관함</h2>
				<div class="form-group" id="searchUI">
					<select name="searchType"class="form-control select2 select2-hidden-accessible"style="width: 10%; float: left" data-select2-id="1" tabindex="-1"aria-hidden="true">
						<option value="emp_sender" ${pagingVO.searchVO.searchType eq 'emp_sender' ?"selected":"" } data-select-id="35">보낸이</option>
						<option value="emp_receiver" ${pagingVO.searchVO.searchType eq 'emp_receiver' ?"selected":"" } data-select-id="35">받는이</option>
						<option value="msg_content" ${pagingVO.searchVO.searchType eq '"msg_content"'?"selected":"" } data-select2-id="36">내용</option>
					</select>
					<div class="input-group input-group-sm"style="width: 40%; float: left">
						<input type="text" class="form-control float-right" name="searchWord" placeholder="Search" style="height: 38px;" value="${pagingVO.searchVO.searchWord }" />
						<div class="input-group-append">
							<button type="submit" id="searchBtn" class="btn btn-default">
								<i class="fas fa-search"></i>
							</button>
						</div>
					</div>
				</div>
			</div>
			<div class="card-body">
				<div class="float-right" >
					<a class="btn btn-primary btn-sm mx-2" href="${cPath }/note/writenote" style="float: right;"> <i class="fas fa-folder"> 
					</i> 쪽지쓰기
					</a> 
					<a class="btn btn-danger btn-sm" id="delBtn" href="#" onclick="deleteAction()" style="float: right;"> 
					<i class="fas fa-trash">
					 </i> 삭제
					</a>
					 <a class="btn btn-primary btn-sm mx-2" id="moveBtn" href="#"	onclick="moveAction(event)" style="float: right;"> <i
						class="fas fa-plus"> 
						</i> 이동
					</a>
				</div>
				<table class="table table-hover projects"  style="table-layout: fixed;">
					<thead>
						<tr>
							<th rowspan="1" colspan="1"><input type="checkbox" name="checkAll" id="th_checkAll" onclick="checkAll2();"/></th>
							<th rowspan="1" colspan="1">보낸사람</th>
							<th rowspan="1" colspan="1">받는사람</th>
							<th rowspan="1" colspan="1">내용</th>
							<th rowspan="1" colspan="1">날짜</th>
						</tr>
					</thead>
					<tbody id="listBody">
					</tbody>
				</table>
				<div id="footer">
					<nav id="pagingArea" class="d-flex ml-md-auto d-print-none">
						${pagingVO.pagingHTML}</nav>
				</div>
			</div>
		</div>
	</div>
</div>

<form method="post" id=moveAction action="${pageContext.request.contextPath }/note/entirenote{pos}">
  <input type="hidden" name="msg_code" value="${msg_code }">
  </form>
  <form id="searchForm" action="${pageContext.request.contextPath }/note/importantnote">
  	<input type="hidden" name="page" value="${param.page }"/>
  	<input type="hidden" name="searchType" value=""/>
  	<input type="hidden" name="searchWord" value=""/>
  </form>
   
   <script type="text/javascript">
  	var listBody = $("#listBody");
  	var searchForm = $("#searchForm").paging({
  		searchUI:"#searchUI",
  		searchBtn:"#searchBtn",
  		pagination:"#pagingArea",
  		pageParam:"page",
  		byAjax:true,
  		success:function(resp){
  			console.log(resp);
  			let msgList = resp.dataList;
  			let pagingHTML=resp.pagingHTML;
  			let trTags=[];
  			if(msgList.length>0){
  				$.each(msgList,function(idx,msg){
  					console.log(msg);
  					let trTag=$("<tr>").append(
  							 $("<td>").html('<input type="checkbox" name="checkRow" value="'+msg.msg_code+'"/> ')
  		  					 .attr("data-url","${pageContext.request.contextPath}/note/detailnote")).attr("data-code",msg.msg_code);
  							trTag.append($("<td>").text(msg.emp_sender_kor));
  							trTag.append($("<td>").text(msg.emp_receiver_kor));
  		  					trTag.append($("<td>").text(msg.msg_content));
  		  					trTag.append($("<td>").text(msg.msg_date));
  		  					
  		  					trTags.push(trTag);
  				});
  				$("#pagingArea").html(pagingHTML);
  				
  				$(".table-hover").on("click","tbody td",function(event){
  			 	   event.stopPropagation() 
   				 	
  			 	   if($(this).children().length > 0){
   					  return;
   				  	}
  			 	   
  			 	    let code = $(this).parent().attr("data-code");
  			 	   location.href="${pageContext.request.contextPath}/note/detailnote/"+code;
  			    });
  				
  			}else{
  				$(".table-hover").off();
  				trTags.push($("<tr>").append($("<td colspan='4'>").text("조건에 맞는 쪽지가 없습니다.")));
  				$("#pagingArea").empty();
  			}
  			listBody.html(trTags);
  			listBody.data("currentpage",resp.currentPage);
  			searchForm.find("[name='page']").val("");
  		}
  	}).submit();
   
   //삭제전체선택
   function checkAll(){
	   if($("#th_checkAll").is(':checked')){
		   $("input[name=checkRow]").prop("checked",true);
	   }else{
		   $("input[name=checkRow]").prop("checked", false);
	   }
   }
   
   //체크된것 삭제 (체크박스 된거 전부)
   		function deleteAction(){
	   var checkRow="";
	   $("input[name='checkRow']:checked").each(function(){
		  checkRow=checkRow+$(this).val()+","; 
	   });
	   checkRow=checkRow.substring(0,checkRow.lastIndexOf(",")); //맨끝 콤마지우기
	   if(checkRow==''){
		   alert("삭제 쪽지 선택하세요");
		   return false;
	   }
	   if(confirm("쪽지를 삭제하시겠습니까?")){
		   $.ajax({
	            url : '${pageContext.request.contextPath }/note/deletenote',
	            type : "POST",
	            datatype : 'json',
	            contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
	            data:{
	                msg_code : checkRow
	            },
	            success : function(data) {
				    alert("삭제가 완료되었습니다.");
				    location.href="${pageContext.request.contextPath }/note/importantnote/${who}";
	                
	            },
	            error:function(request, status, error) {
	            	alert("삭제를 실패하였습니다.");
	 
	            }
	   })
   }
}
    //이동전체선택
    function checkAll2(){
 	   if( $("#th_checkAll").is(':checked') ){
 		   $("input[name=checkRow]").prop("checked",true);
 	   }else{
 		   $("input[name=checkRow]").prop("checked", false);
 	   }
    }
    $("#moveBtn").on("click",function(){
 	   
    })
    ///이동버튼
   	function moveAction(event){
    	event.preventDefault();
 	   var checkRow=[];
 	   $("input[name='checkRow']:checked").each(function(){
 		  checkRow.push($(this).val());
 	   });
 	  
 	   if(checkRow.length <= 0){
 		   alert("이동할 쪽지 선택하세요");
 		   return false;
 	   }
 	   if(confirm("쪽지를  이동하시겠습니까?")){
 		   $.ajax({
 			   url : '${pageContext.request.contextPath}/note/entirenote{pos}',
 			   type:"POST",
 			  contentType:"application/json",
 			   data:JSON.stringify({
 				   msg_code : checkRow
 			   }),
 			   success :function(data){
 		 		  alert("쪽지가 이동되었습니다.");
 		 		  location.reload();
 			   },
 			 error :function(request,status,error){
 				 alert("이동을 실패하였습니다.");
 			 }
 		   })
 	   }
    }
    
   
   </script>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    