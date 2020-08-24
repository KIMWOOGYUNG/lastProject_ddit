<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<style>
	#content {padding: 30px;}
	#nav{float:right;width:140px;margin-top:10px;display:inline}
	h3{margin:10px 0 30px 0;}
	#searchBtn{width:40px; heigth:40px;}
</style>

<div id="content">
	<div class="row">
          <div class="col-12">
            <div class="card">
              <div class="card-header">
                <h3>${title}</h3>
					<select name="searchType" class="form-control select2 select2-hidden-accessible" style="width: 10%; float: left">
	      				 <option value="name">그룹명</option>
	       				 <option value="emp">그룹원</option>
	                  </select>
                

                  <div class="input-group input-group-sm" style="width: 40%; float: left" id="searchUI">
                    <input type="text" name="searchWord" class="form-control float-right" placeholder="Search" style="height: 38px;">
					
                    <div class="input-group-append">
                      <button type="submit" id="searchBtn" class="btn btn-default"><i class="fas fa-search"></i></button>
                    </div>
                  </div>
                  
                  <div id="nav">
	                    <a class="btn btn-primary btn-sm p-10" href="${cPath }/approval/setting/${state}/add">
							<i class="fas fa-folder"></i>추가
						</a>
						<button id="lineDeleteBtn" class="btn btn-danger btn-sm" >
							<i class="fas fa-trash"></i>삭제
						</button>
			 	  </div>
              </div>
              <!-- /.card-header -->
              <div class="card-body table-responsive p-0">
                <table class="table table-hover text-nowrap">
                  <thead>
                    <tr>
                      <th><input type="checkbox" id="allCheck"></th>
                      <th>그룹명</th>
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
        <form id="searchForm" action="${cPath}/approval/setting/${state}">
			<input type="hidden" name="page" value="${page }"/>
			<input type="hidden" name="searchType" value=""/>
			<input type="hidden" name="searchWord" value=""/>
		</form>   
		
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
$("#allCheck").on("change",function(){
	 var chk = $(this).is(":checked");//.attr('checked');
   
	 if(chk) $("#listBody input[type=checkbox]").prop('checked', true);
    else  $("#listBody input[type=checkbox]").prop('checked', false);

})

$("#lineDeleteBtn").on("click",function(){
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
	$.each(itemList,function(idx,item){
		let code = $(item).attr("data-code");
		dataList[dataList.length] = code;
	});
	var data= {'dataList' :dataList};
	$.ajax({
		url : "${cPath }/approval/setting/${state}/delete"
		,data :JSON.stringify(dataList)
		,dataType:'text'
		,contentType:'application/json'
		,traditional : true
		,method : 'delete'
		,success : function(resp){
			location.reload();
		}
		,error : function(error){
			alert(error.responseText)
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
			console.log(resp);
			let lineList = resp.dataList;
			let pagingHTML = resp.pagingHTML;
			let trTags = [];
			if(lineList.length>0){
				$.each(lineList, function(idx, line){
					let trTag = $("<tr>").append(
									  $("<td>").html($("<input>").attr({"type":"checkbox","data-code":line.line_code}))
									, $("<td>").html($("<a>").attr("href", "${cPath}/approval/setting/${state }/modify/"+line.line_code).text(line.line_name).addClass("url-link"))
									);
					trTags.push(trTag);
					
				});
				$("#pagingArea").html(pagingHTML);
			}else{
				trTags.push($("<tr>").html($("<td colspan='8'>").text("해당 그룹이 없습니다.")));
				$("#pagingArea").empty();
			}
			console.log(trTags);
			listBody.html(trTags);
			listBody.data("currentpage", resp.currentPage);
			searchForm.find("[name='page']").val("");
		}
	}).submit();

</script>