<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<style>
	#content {padding: 30px;}
	.chkBox {width: 15px;height: 15px;}
	.icon {margin: 0px 5px 10px 0px;}
	.button {background: none;border: 0;float:left;}
	#nav{float:right;width:140px;margin-top:10px;}
	h2{margin:10px 0 30px 0;}
	#searchBtn{width:40px; heigth:40px;}
	.hide2{float:right;}
</style>


<div id="content">
	<div class="col-12">
		<div class="card">
			<div class="card-header">
			<h2>중요 일정함</h2>
		<div class="form-group" id="searchUI">
             <select name="searchType" class="form-control select2 select2-hidden-accessible" style="width: 10%;float:left" data-select2-id="1" tabindex="-1" aria-hidden="true">
               <option value="title"
               data-select2-id="34">제목</option>
               <option value="writer"
               data-select2-id="35">작성자</option>
               <option value="import" 
               data-select2-id="36">중요도</option>
             </select>

            <div class="input-group input-group-sm" style="width: 40%; float:left">
              <input type="text" class="form-control float-right" name="searchWord" placeholder="Search" value="${pagingVO.searchVO.searchWord }" style="height: 38px;" />

              <div class="input-group-append">
                <input class="btn btn-default " type="button" value="검색" id="searchBtn">
              </div>
        </div>
     </div>



<div id="nav">
</div>
   
  <div class="card-body table-responsive p-0">
   <div style="margin:20px 20px 0px 20px;">
	<button class="button showBtn" id="blockBtn" data-target="#blockBody" onclick = "location.href = '${cPath}/plan/myplancalendar/import' ">
						<span class="oi oi-grid-three-up icon"></span>
					</button>
					<button class="button showBtn" id="tableBtn" 
						data-target="#projectTable">
						<span class="oi oi-list icon"></span>
					</button>	
			</div>
  
    
<br>
<br>


<table class="table table-hover text-nowrap toggleShow" id="projectTable">
	<thead>
		   <tr>
		   <th rowspan="1" colspan="1">선택</th>
		   <th rowspan="1" colspan="1">제목</th>
		   <th rowspan="1" colspan="1">작성자</th>
		   <th rowspan="1" colspan="1">시작일</th>
		   <th rowspan="1" colspan="1">종료일</th>
		   <th rowspan="1" colspan="1">중요도</th>
		   </tr>
    	  </thead>
          <tbody id="listBody">
               
                 </tbody>
                 </table>
     <div id="blockBody" class="toggleShow"></div>
	<div style="margin:20px 20px 20px 20px; float:left;width:80%;">           
	<div id="pagingArea" class="d-flex ml-md-auto d-print-none">
		${pagingVO.pagingHTML }
	</div>
	</div>
	</div>
	</div>
	</div>
	</div>	
</div>

<form id="searchForm" action="${pageContext.request.contextPath }/plan/myplanbox/importantplan">
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
				let myscheduleList = resp.dataList;
				let pagingHTML = resp.pagingHTML;
				let trTags = [];
				if(myscheduleList.length>0){
					$.each(myscheduleList, function(idx, myschedule){
	//					if(myschedule.ms_important == '높음'){
						
						
						let trTag = $("<tr>").append(
										$("<td>").html('<input type="checkbox" name="checkRow" value="'+myschedule.ms_code+'" />')
										, $("<td>").html(
											$("<a>").attr("href", "${pageContext.request.contextPath}/plan/DetailMySchedule/" + myschedule.ms_code)
													.text(myschedule.ms_title)													
										)
										, $("<td>").text(myschedule.emp_code)
										, $("<td>").text(myschedule.ms_startdate)
										, $("<td>").text(myschedule.ms_enddate)
										, $("<td>").text(myschedule.ms_important)
										);
						trTags.push(trTag);
	//					}
					});
					$("#pagingArea").html(pagingHTML);
				}else{
					trTags.push($("<tr>").html($("<td colspan='8'>").text("조건에 맞는 내 일정이 없음.")));
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
	    alert("삭제할 일정을 선택하세요.");
	    return false;
	  }
	  console.log("### checkRow => {}"+checkRow);
	 
	  if(confirm("일정을 삭제 하시겠습니까?")){
		  $.ajax({
	            url : '${pageContext.request.contextPath }/plan/departmentplanbox/departmentplan/deletedept',
	            type : "POST",
	            datatype : 'json',
	            contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
	            data:{
	                ds_code : checkRow
	            },
	            success : function(data) {
				    alert("삭제가 완료되었습니다.");
				    location.href="${pageContext.request.contextPath }/plan/departmentplanbox/departmentplan";
	                
	            },
	            error:function(request, status, error) {
	            	alert("삭제를 실패하였습니다.");
	 
	            }
		 })
	        

	  }
	 
	}



</script>
