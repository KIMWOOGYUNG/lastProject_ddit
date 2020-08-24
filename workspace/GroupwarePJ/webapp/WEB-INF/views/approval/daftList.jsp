<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<style>
	#content {padding: 30px;}
	#nav{float:right;width:200px;margin-top:10px;display:inline}
	h2{margin:10px 0 30px 0;}
	#searchBtn{width:40px; heigth:40px;}
</style>
<c:set var="btn" value="${draft_pos eq 'all' ? '회수' : '삭제' }"/>
<div id="content">
	<div class="row">
          <div class="col-12">
            <div class="card">
              <div class="card-header">
                <h2>${title}</h2>
					
                  <select name="searchType" class="form-control select2 select2-hidden-accessible" style="width: 10%; float: left">
      				 <option value="no">문서번호</option>
      				 <option value="emp">기안자</option>
       				 <option value="title">제목</option>
       				 <option value="state">진행상태</option>
                  </select>
                  
                  <div class="input-group input-group-sm" style="width: 40%; float: left">
	                  <input type="text" name="searchWord" class="form-control float-right" placeholder="Search" style="height: 38px;">
						
	                  <div class="input-group-append">
	                      <button type="submit" id="searchBtn" class="btn btn-default"><i class="fas fa-search"></i></button>
	                  </div>
                  </div>
				
				<div id="nav">
					<a class="btn btn-primary btn-sm p-10" href="${cPath }/approval/approvalwrite">
						<i class="fas fa-folder"></i>등록
					</a>
					
					<button id="apprDeleteBtn"class="btn btn-danger btn-sm" >
						<i class="fas fa-trash"></i> ${btn }
					</button>
					
					<c:if test="${draft_pos eq'delete'}">
						<button id="apprMoveBtn" class="btn btn-info btn-sm" >
							<i class="fas fa-pencil-alt"></i>이동
						</button>
					</c:if>
				</div>
              </div>
              <!-- /.card-header -->
              <div class="card-body table-responsive p-0">
                <table class="table table-hover text-nowrap">
                  <thead>
                    <tr>
                   
                      <th><input type="checkbox" id="allCheck" ></th>
                    
                      <th>문서번호</th>
                      <th>기안서명</th>
                      <th>기안서 상태</th>
                      <th>작성날짜</th>
                    </tr>
                  </thead>
                  <tbody id="listBody">
                  </tbody>
                </table>
                <div style="margin:20px 20px 20px 20px;">
					<div id="pagingArea" class="d-flex ml-md-auto d-print-none">
						<div>${pagingVO.pagingHTML }</div>
					</div>
 				</div>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
        </div>
</div>
		<form id="searchForm" action="${pageContext.request.contextPath }/approval/myapproval/${draft_pos}">
			<input type="hidden" name="page" value="${page }"/>
			<input type="hidden" name="searchType" value=""/>
			<input type="hidden" name="searchWord" value=""/>
			<input type="hidden" name="draft_pos" value="${draft_pos }"/>
		</form>   
	<div class="modal fade" id="modal" style="display: none;" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h4 class="modal-title"></h4>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">×</span>
              </button>
            </div>
            <div class="modal-body">
           
            </div>
            <div class="modal-footer justify-content-between">
              <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
              <button type="button" class="btn btn-primary" id="modalConfirm">확인</button>
            </div>
          </div>
          <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
      </div>
<script type="text/javascript">
var activeCatag = "";
$("#allCheck").on("change",function(){
	 var chk = $(this).is(":checked");//.attr('checked');
    
	 if(chk) $("#listBody input[type=checkbox]").prop('checked', true);
     else  $("#listBody input[type=checkbox]").prop('checked', false);

})

$("#apprDeleteBtn").on("click",function(){
	let modal = $("#modal");
	$(".modal-title").text("${btn}");
	let itemList = $("#listBody").find("input:checked")
	if(itemList.length <= 0){
		alert("${btn}하실 기안서를 선택해주세요.")
		return;
	}
	
	var check = true;
	$.each(itemList,function(idx,item){
		 let state = $(item).attr("data-stat");
		if(state != null && state != '기안중'){
			alert("결재상태가 기안중이거나 없는 경우만 ${btn}가 가능합니다.")
			check = false;
			return false;
		}
	})
	if(!check) return;
	
	let modalBody= modal.find(".modal-body");
	modalBody.html($("<p>").text(itemList.length+"개의 기안서를 ${btn}하시겠습니까?"));
	modal.modal();
	activeCatag = 'delete';
});
	

$("#modalConfirm").on("click",function(){
	let itemList = $("#listBody").find("input:checked");
	let dataList = [];
	let methodeType = "";
	if('${draft_pos}' == 'delete'){
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
		url : "${cPath }/approval/"+activeCatag+"/${draft_pos}"
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
	
	$("#apprMoveBtn").on("click",function(){
		let modal = $("#modal");
		$(".modal-title").text("이동");
		let itemList = $("#listBody").find("input:checked")
		if(itemList.length <= 0){
			alert("이동하실 그룹을 선택해주세요.")
			return;
		}	
		
		let modalBody= modal.find(".modal-body");
		modalBody.html($("<p>").text(itemList.length+"개의 그룹을 이동하시겠습니까?"));
		modal.modal();
		activeCatag = 'move';
	});
	
	var listBody = $("#listBody");
	var searchForm = $("#searchForm").paging({
		searchUI:"#searchUI",
		searchBtn:"#searchBtn",
		pagination:"#pagingArea",
		pageParam:"page",
		byAjax:true,
		success:function(resp){
			let draftList = resp.dataList;
			let pagingHTML = resp.pagingHTML;
			let trTags = [];
			if(draftList.length>0){
				$.each(draftList, function(idx, draft){
					let trTag = $("<tr>").append(
							 $("<td>").append($("<input>").attr("type","checkbox").attr("data-code",draft.draft_code).attr("data-stat",draft.draft_stat)),
									 $("<td>").text(draft.draft_code)
									, $("<td>").html($("<a>").attr("href", "${cPath}/approval/detail/"+draft.draft_code).html(draft.draft_title).addClass("url-link"))
									, $("<td>").text(draft.draft_stat)
									, $("<td>").text(draft.draft_date.split(" ")[0]));
					trTags.push(trTag);
					
				});
				$("#pagingArea").html(pagingHTML);
			}else{
				trTags.push($("<tr>").html($("<td colspan='8'>").text("기안서가 존재하지 않습니다.")));
				$("#pagingArea").empty();
			}
			console.log(trTags);
			listBody.html(trTags);
			listBody.data("currentpage", resp.currentPage);
			searchForm.find("[name='page']").val("");
		}
	}).submit();
	
</script>