<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<style>
	#content{padding:50px;}
	.chkBox{width:15px; height:15px;}
 	.icon{margin:0px 5px 10px 0px;} 
	.button{background:none; border:0;}
	#nav{float:right;}
	h2{margin:10px 0 30px 0;}
	#searchBtn{width:40px; heigth:40px;}
	#insertBtn{ color: white;}
</style>
<div id="content">
	<div class="col-12">
		<div class="card">
			<div class="card-header">
				<h2>내 주소록</h2>
				<div class="form-group" id="searchUI">
					<select name="searchType"
						class="form-control select2 select2-hidden-accessible"
						style="width: 10%; float: left" data-select2-id="1" tabindex="-1"
						aria-hidden="true">
						<option value="add_name"
							${pagingVO.searchVO.searchType eq 'add_name'?"selected":"" }>이름</option>
						<option value="ag_name"
							${paginVO.searchVO.searchType eq 'ag_name'?"selected":"" }>소속</option>
					</select>
					<div class="input-group input-group-sm"
						style="width: 40%; float: left">
						<input type="text" name="searchWord"
							class="form-control float-right" placeholder="Search"
							style="height: 38px;" value="${pagingVO.searchVO.searchWord }" />
						<div class="input-group-append">
							<button id="searchBtn" type="submit" class="btn btn-default">
								<i class="fas fa-search"></i>
							</button>
						</div>
					</div>
				</div>
			</div>
			<!-- 				</div> -->
			<div style="text-align: center;">
				<a class="btn btn-primary btn-sm m-2" id="insertBtn" style="float: right;">
				 <i class= "fas fa-save"> </i> 
				등록
				</a>
				 <a class="btn btn-danger btn-sm m-2" id="delBtn" href="#" style="float: right;" onclick="deleteAction()">
				 <i class="fas fa-trash"> </i> 삭제
				</a>
			</div>
			<!-- 아이콘 -->
			<div class="mx-3 mt-3">
				<button class="button showBtn" id="blockBtn" data-target="#blockBody"> <span
					class="oi oi-grid-three-up icon"></span>
				</button>
				<button class="button showBtn" id="tableBtn"
					data-target="#addressTable">
					<span class="oi oi-list icon"></span>
				</button>
			</div>
			<!-- 			</div> -->
			<div class="card-body  table-responsive p-0">
				<table class="table table-striped address toggleShow"
					id="addressTable">
					<thead>
						<tr>
							<th><input type="checkbox" name="checkAll" id="th_checkAll"
								onclick="checkAll();" /></th>
							<th>이름</th>
							<th>소속</th>
							<th>직급</th>
							<th>H.P</th>
							<th>이메일</th>
						</tr>
					</thead>
					<tbody id="listBody">
					</tbody>
				</table>
				<!-- 아이콘 -->
				<div>
					<div id="blockBody" class="row toggleShow m-0"></div>
					<div id="footer">
						<nav id="pagingArea" class="d-flex ml-md-auto d-print-none">
							<div>${pagingVO.pagingHTML }</div>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- <div id="content"> -->
<!-- <div id="top"> -->
<!-- 	</div> -->
<!-- 				<button class="btn btn-primary btn-sm" href="#"> -->
<!-- 					<i class=" fas fa-plus"> </i> 이동 -->
<!-- 				</button> -->
<!-- 			</div> -->
<!-- </div> -->
<form id="searchForm" action="${cPath }/address/cusomeraddrList/${ag_code}" method="get">
	<input type="hidden" name="page" value="${param.page }"/>
	<input type="hidden" name="searchType" value=""/>
	<input type="hidden" name="searchWord" value=""/>
	<input type="hidden" name="viewType" value=""/>	<!-- 페이지를 클릭할때 블럭인지 리스트인지 정보를 받아옴 -->
</form>

<!-- 내주소록 등록 모달창-->
<div id="addmodal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<form id="modalbtn" method="post" action="${cPath}/address/myaddress">
			<div class="modal-header">
			<h2>거래처 등록</h2>
				<h4 id="modalTitle" class="modal-title"></h4>
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">×</span> <span class="sr-only">close</span>
				</button>
			</div>
			<div class="modal-body">
				<input type="hidden" name="_method" value="put"> 
				<table class="table table-bordered" id="modal">
					<tr>
						<th>이름</th>
						<td><input type="text" name="add_name" class="modalname"></td>
					</tr>
					<tr>
						<th>회사명</th>
						<td><input type="text" name="ag_name" class="modalcompanyName">
						</td>
					</tr>
					<tr>
						<th>부서명</th>
						<td><input type="text" name="dept_name" class="modaldept"></td>
					</tr>
					
					<tr>
						<th>직위</th>
						<td><input type="text" name="add_title" class="modalposition"></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="text" name="add_mail" class="modalemail"></td>
					</tr>
					<tr>
						<th>H.P</th>
						<td><input type="text" name="add_hp" class="modalhp"></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input type="text" name="add_add" class="modalhp"></td>
					</tr>
					<tr>
						<th>메모</th>
						<td><textarea cols="50" name="add_etc" rows="10" class="modalcompany"></textarea>
						</td>
					</tr>
				</table>
			</div>
			<div class="modal-footer">
				<button type="submit" id="okBtn" class="btn btn-primary mr-2" style="float: center;">확인</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal" >취소</button>
			</div>
				</form>
		</div>
	</div>
</div>

<script type="text/javascript">
		var blockBody = $("#blockBody");
		var listBody = $("#listBody");
		var addressTable =$("#addressTable");
		var searchForm =$("#searchForm").paging({
			searchUI:"#searchUI",
			searchBtn:"#searchBtn",
			pagination:"#pagingArea",
			pageParam:"page",
			byAjax:true,
			success:function(resp){
			let addrList = resp.dataList;
			let pagingHTML = resp.pagingHTML;
			let divTags = [];
			let trTags = [];
			
			console.log(addrList.length);
			
			if(addrList.length>0){
				$.each(addrList, function(idx, address){
					//블럭형태
					let divTag = $("<div>").addClass("h-4 m-0 p-0 col-4 row").append(
									$("<div>").addClass("float-left h-5 align-items-stretch col-12").html(
										$("<div>").addClass("card bg-light").css("margin","10px").append(
												
												$("<div>").addClass("card-body pt-0").html(
														$("<div>").addClass("row  mt-5").html(
															$("<div>").addClass("col-15").html(
																$("<h4>").addClass("lead").html(
																		$("<b>").text(address.add_name)
																)
															).append(
																$("<p>").addClass("text-muted text-sm").html($("<p>").text(address.ag_name))
															).append(
																	$("<p>").addClass("text-muted text-sm").html($("<p>").text(address.add_title))	
															.append(
																	$("<a>").html($("<span>").addClass("data-tooltip")).attr("href", "${cPath}/note/writenote/"+address.emp_code)
																	)
															).append(
																	$("<p>").addClass("text-muted text-sm").html($("<p>").text(address.add_hp))		
															).append(
																	$("<p>").addClass("text-muted text-sm").html($("<p>").text(address.add_mail))		
															)
														 )
													 )
												).append(
													$("<div>").addClass("card-footer").html(
														$("<div>").addClass("text-right").html(
															$("<a>").html($("<span>").addClass("oi oi-zoom-in")).attr("href", "${cPath}/address/myaddressDetail/"+address.add_code)
														)
													)
												)
											)
										);		
												
						divTags.push(divTag);
						
						//리스트형태
						let trTag = $("<tr>").append(
								$("<td>").html('<input type="checkbox" class="chkBox" name="checkRow" value="'+address.add_code+'" />'), 

 								$("<td>").html(
 									$("<a>").attr("href","${cPath}/address/myaddressDetail/"+address.add_code)
 									.text(address.add_name)//이름
 								)
								, $("<td>").text(address.ag_name)//소속
								, $("<td>").text(address.add_title)//직급
								, $("<td>").text(address.add_hp)//핸드폰번호
								, $("<td>").text(address.add_mail)//이메일
								
						);
						trTags.push(trTag);
				});
				$("#pagingArea").html(pagingHTML);
			}else{
				trTags.push($("<tr>").append($("<td colspan='4'>").text("조건에 맞는 쪽지가 없습니다.")));
// 				divTags.push($("<span>").text("검색된 주소록이 없습니다."));
				$("#pagingArea").empty();
			}
			blockBody.html(divTags);
			blockBody.data("currentpage", resp.currentPage);
			listBody.html(trTags);
			listBody.data("currentpage", resp.currentPage);
			
			searchForm.find("[name='page']").val("");
			let viewType = searchForm.find("[name='viewType']").val();
			
			//paging시 viewType 유지
			
			if(viewType){	//viewType이 있다면
				$(".toggleShow").hide();	
				$(viewType).show();
				
			}else{			//viewType이 없다면 (default)
				addressTable.hide();
				blockBody.show();
			}
		}
	}).submit();
	
//viewType 이벤트
	$(".showBtn").on("click", function(){
		var target = $(this).data("target");
		$(".toggleShow").hide();
		$(target).show();
//			$(".toggleShow").toggle();
		searchForm.find("[name='viewType']").val(target);
	});

//전체 선택
function checkAll(){
      if( $("#th_checkAll").is(':checked') ){
        $("input[name=checkRow]").prop("checked", true);
      }else{
        $("input[name=checkRow]").prop("checked", false);
      }
}

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
		   alert("주소록을  선택하세요");
		   return false;
	   }
	   if(confirm("주소록을 삭제하시겠습니까?")){
		   $.ajax({
	            url : '${pageContext.request.contextPath }/address/deletemycustomer',
	            type : "POST",
	            datatype : 'json',
	            contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
	            data:{
	                add_code : checkRow
	            },
	            success : function(data) {
				    alert("삭제가 완료되었습니다.");
				    location.href="${pageContext.request.contextPath }/address/cusomeraddrList/${who}";
	                
	            },
	            error:function(request, status, error) {
	            	alert("삭제를 실패하였습니다.");
	 
	            }
	   })
}
}


$("#insertBtn").on("click",function(){
	 $('#addmodal').modal();
  $("#okBtn").submit();
});



</script>
