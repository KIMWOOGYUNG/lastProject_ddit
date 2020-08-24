<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<style>
	.chkBox {width: 15px;height: 15px;}
	.icon {margin: 0px 5px 10px 0px;}
	.button {background: none;border: 0;float:left;}
	#nav{float:right;width:70px;margin-top:10px;}
	h2{margin:10px 0 30px 0;}
	#searchBtn{width:40px; heigth:40px;}
</style>

<div id="content">
	<div class="col-12" style="padding:0px">
            <div class="card card-secondary card-outline card-tabs">
              <div class="card-header p-0 pt-1 border-bottom-0">
                <ul class="nav nav-tabs" id="custom-tabs-three-tab" role="tablist">
                  <li class="nav-item">
                    <a class="nav-link active" id="custom-tabs-three-all-tab" data-toggle="pill" href="#custom-tabs-three-all" role="tab" aria-controls="custom-tabs-three-all" aria-selected="true" data-state="all">전체</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" id="custom-tabs-three-draft-tab" data-toggle="pill" href="#custom-tabs-three-draft" role="tab" aria-controls="custom-tabs-three-draft" aria-selected="false"data-state="draft">기안중</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" id="custom-tabs-three-prog-tab" data-toggle="pill" href="#custom-tabs-three-prog" role="tab" aria-controls="custom-tabs-three-prog" aria-selected="false" data-state="prog">진행중</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" id="custom-tabs-three-attr-tab" data-toggle="pill" href="#custom-tabs-three-attr" role="tab" aria-controls="custom-tabs-three-attr" aria-selected="false" data-state="attr">반려</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" id="custom-tabs-three-comp-tab" data-toggle="pill" href="#custom-tabs-three-comp" role="tab" aria-controls="custom-tabs-three-comp" aria-selected="false" data-state="comp">승인</a>
                  </li>
                </ul>
              </div>
              <div class="card-body">
                <div class="tab-content" id="custom-tabs-three-tabContent">
                  <div class="tab-pane fade active show" id="custom-tabs-three-content" role="tabpanel" aria-labelledby="custom-tabs-three-all-tab">
	                	
	                	<div class="row">
				          <div class="col-12">
				            <div class="card">
				              <div class="card-header">
<%-- 				                <h3 class="card-title">${title}*제목넣기*</h3> --%>
				                    <select name="searchType" class="form-control select2 select2-hidden-accessible" style="width: 10%; float: left">
				                         				 <option value="no">문서번호</option>
				                          				 <option value="title">제목</option>
				                          				 <option value="state">진행상태</option>
				                    </select>
				                  <div class="input-group input-group-sm" style="width: 40%; float: left" id="searchUI">
				                      <input type="text" name="searchWord" class="form-control float-right" placeholder="Search" style="height: 38px;">
									
				                      <div class="input-group-append">
				                      	<button type="submit" id="searchBtn" class="btn btn-default"><i class="fas fa-search"></i></button>
				                      </div>
				                  </div>
				               <div id="nav">
				                  <a class="btn btn-primary btn-sm p-10" href="${cPath }/approval/approvalwrite">
									<i class="fas fa-folder"></i>추가
									</a>
									<c:if test="${state eq 'draft' }">
										<button id="apprDeleteBtn"class="btn btn-danger btn-sm" >
										<i class="fas fa-trash"></i>삭제
										</button>
									</c:if>
									</div>
				              </div>
				              <!-- /.card-header -->
				              <div class="card-body table-responsive p-0">
				                <table class="table table-hover text-nowrap">
				                  <thead>
				                    <tr>
				                      <th>문서코드</th>
				                      <th>기안서명</th>
				                      <th>작성자</th>
				                      <th>기안서 상태</th>
				                      <th>작성날짜</th>
				                    </tr>
				                  </thead>
				                  <tbody id="listBody">
				                  </tbody>
				                </table>
				              </div>
				              <!-- /.card-body -->
				            </div>
				            <!-- /.card -->
				          </div>
				        </div>
						 
                		<div class="card-footer">
							<div class="row">
								<div class="col-sm-12 col-md-6">
								</div>
								<div class="col-sm-12 col-md-6">
									<div class="dataTables_paginate paging_simple_numbers"
										id="example2_paginate" >
										<nav id="pagingArea">
										${pagingVO.pagingHTML }
										</nav>
									</div>
								</div>
							</div>
						</div>
						<form id="searchForm" action="${pageContext.request.contextPath }/approval/entiremanage/all">
							<input type="hidden" name="page" value="${page }"/>
							<input type="hidden" name="searchType" value=""/>
							<input type="hidden" name="searchWord" value=""/>
							<input type="hidden" name="draft_pos" value="${draft_pos }"/>
						</form>   
                  </div>
                </div>
              </div>
              <!-- /.card -->
             
            </div>
          </div>
      </div>
          <div class="modal fade" id="modal-danger" style="display: none;" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content bg-danger">
            <div class="modal-header">
              <h4 class="modal-title">삭제</h4>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">×</span>
              </button>
            </div>
            <div class="modal-body">
           
            </div>
            <div class="modal-footer justify-content-between">
              <button type="button" class="btn btn-outline-light" data-dismiss="modal">취소</button>
              <button type="button" class="btn btn-outline-light" id="modalConfirm">확인</button>
            </div>
          </div>
          <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
      </div>
<script type="text/javascript">
$("#apprDeleteBtn").on("click",function(){
	let modal = $("#modal-danger");
	let itemList = $("#listBody").find("input:checked")
	if(itemList.length <= 0){
		alert("삭제하실 그룹을 선택해주세요.")
		return;
	}
	
	let modalBody= modal.find(".modal-body");
	modalBody.html($("<p>").text(itemList.length+"개의 그룹을 삭제하시겠습니까?"));
	modal.modal();
});
	
	
$("#modalConfirm").on("click",function(){
	let itemList = $("#listBody").find("input:checked");
	let dataList = [];
	let methodeType = "";
	if('${pos}' == 'delete'){
		methodeType = 'delete';
	}else{
		methodeType = 'post';
	}
	
	$.each(itemList,function(idx,item){
		let code = $(item).attr("data-code");
		dataList[dataList.length] = code;
	});
	var data= {'dataList' :dataList};
	$.ajax({
		url : "${cPath }/approval/delete"
		,data :JSON.stringify(dataList)
		,contentType:'application/json'
		,traditional : true
		,datetype : "text"
		,method : methodeType
		,success : function(resp){
			location.reload();
		}
		,error : function(error){
			console.log(error.responseText);
		}
		
	})
})


var listBody = $("#listBody");
var searchForm = $("#searchForm").paging({
	searchUI:"#searchUI",
	searchBtn:"#searchBtn",
	pagination:"#pagingArea",
	pageParam:"page",
	byAjax:true,
	success:function(resp){
		let draftList = resp.dataList;
		console.log(draftList);
		let pagingHTML = resp.pagingHTML;
		let trTags = [];
		if(draftList.length>0){
			$.each(draftList, function(idx, draft){
				let trTag = $("<tr>").append(
								  $("<td>").text(draft.draft_code)
								, $("<td>").html($("<a>").attr("href", "${cPath}/approval/detail/"+draft.draft_code).html(draft.draft_title).addClass("url-link"))
								, $("<td>").text(draft.emp_kor)
								, $("<td>").text(draft.draft_stat)
								, $("<td>").text(draft.draft_date.split(" ")[0]));
				trTags.push(trTag);
				
			});
			$("nav#pagingArea").html(pagingHTML);
		}else{
			trTags.push($("<tr>").html($("<td colspan='8'>").text("기안서가 존재하지 않습니다.")));
			$("nav#pagingArea").empty();
		}
		listBody.html(trTags);
		listBody.data("currentpage", resp.currentPage);
		searchForm.find("[name='page']").val("");
	}
}).submit();

$("#custom-tabs-three-tab").on("click","a",function(){
	let state = $(this).data("state");
	$("#searchForm").attr("action","${pageContext.request.contextPath }/approval/entiremanage/"+state);
	searchForm.submit();
})


</script>



