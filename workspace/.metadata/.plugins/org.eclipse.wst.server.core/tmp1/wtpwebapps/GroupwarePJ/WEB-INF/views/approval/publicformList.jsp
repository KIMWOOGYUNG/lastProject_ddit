
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

<div id="content">

<div class="col-12">
	<div class="card">
		<div class="card-header">
			<h2>공용서식함</h2>
			<div class="form-group" id="searchUI">
				<select name = "searchType" class="form-control select2 select2-hidden-accessible" style="width: 10%;float:left" data-select2-id="1" tabindex="-1" aria-hidden="true">
					<option value="" data-select2-id="3" selected disabled>전체</option>
					<option value="form_code" ${pagingVO.searchVO.searchType eq 'form_code'?"selected":"" } >코드</option>
					<option value="fc_code" ${pagingVO.searchVO.searchType eq 'fc_code'?"selected":"" } >카테고리</option>
					<option value="form_name" ${pagingVO.searchVO.searchType eq 'form_name'?"selected":"" } >서식명</option>
				</select>
				
				<div class="input-group input-group-sm" style="width: 40%; float: left">
					<input type="text" class="form-control float-right" name="searchWord" placeholder="Search" style="height:38px;" value="${pagingVO.searchVO.searchWord }" />
					<div class="input-group-append">
						<button type="submit" id="searchBtn" class="btn btn-default"><i class="fas fa-search"></i></button>
					</div>
				</div>
			</div>
				
			<div id="nav" hidden="hidden">
				<button class = "btn btn-primary btn-sm" onclick="insertForm()">
					<i class="fas fa-folder">
			        </i>
			       	 등록
			    </button>
			    <button class="btn btn-info btn-sm" id="btnUpdate" onclick="updateForm()">
			        <i class="fas fa-pencil-alt">
			        </i>
			       	 수정
			    </button>
			    <button class="btn btn-danger btn-sm" onclick="deleteForm()">
			        <i class="fas fa-trash">
			        </i>
			    	 삭제
			    </button>
				</div>
				
			<div class="card-tools">
				<div class="input-group input-group-sm" id="searchUI" style="width: 150px;"> </div>
			</div>
		</div>
		<!-- /.card-header -->
		<div class="card-body table-responsive p-0">
			<table class="table table-hover text-nowrap" id="formTable">
				<thead>
					<tr>
						<th>
							<input type="checkbox" name="checkAll" id="th_checkAll" onclick="checkAll();" />
						</th>
						<th>순번</th>
						<th>카테고리</th>
						<th>서식명</th>
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
 
<form id="searchForm" action="${pageContext.request.contextPath }/approval/publicformbox/publicformList">
	<input type="hidden" name="page" value="${param.page }"/>
	<input type="hidden" name="searchType" value="" />
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
			let publicFormList = resp.dataList;
			let pagingHTML = resp.pagingHTML;
			let trTags = [];
			if(publicFormList.length > 0){
				$.each(publicFormList, function(idx, form){
					let trTag = $("<tr>").append(
									 $("<td>").html('<input type="checkbox" name="checkRow" value="'+form.form_code+'" />')
									, $("<td>").text(form.rnum)
									, $("<td>").text(form.fc_name)
									, $("<td>").html(
										$("<a>").attr("href", "${cPath}/approval/publicformbox/publicformView/" + form.form_code).html(form.form_name).addClass("url-link")
									)
									);
					trTags.push(trTag);
				});
				$("#pagingArea").html(pagingHTML);
			}else{
				trTags.push($("<span>")).text("서식이 없습니다.");
				$("#pagingArea").empty();
			}
			listBody.html(trTags);
			listBody.data("currentpage", resp.currentPage);
			searchForm.find("[name='page']").val("");
		}
	}).submit();

	function checkAll(){
        if( $("#th_checkAll").is(':checked') ){
          $("input[name=checkRow]").prop("checked", true);
        }else{
          $("input[name=checkRow]").prop("checked", false);
        }
  	}
	
	// 서식 추가
	function insertForm(){
		location.href="${pageContext.request.contextPath }/approval/publicformbox/insertform";
	}
	
	// 서식수정
	function updateForm(){
		
		var form_code = $("input[name='checkRow']:checked").val();
		if(form_code==null){
			alert("수정할 서식을 선택하세요.");
		}else{
			if($("input[name='checkRow']:checked").length==1){
				location.href="${cPath}/approval/publicformbox/updateForm/"+ form_code;
			}else{
				alert("하나만 선택하세요.");
			}
		}
	}
	
	// 서식 삭제
	function deleteForm(){
		var checkRow = "";
		$("input[name='checkRow']:checked").each(function(){
			checkRow = checkRow + $(this).val() + ",";
		});
		checkRow = checkRow.substring(0, checkRow.lastIndexOf(","));
		
		if(checkRow == ''){
			alert("삭제할 서식을 선택하세요.");
			return false;
		}
		console.log("checkRow => {}" + checkRow);
		
		if(confirm("서식을 삭제하시겠습니까 ? ")){
			$.ajax({
				url : '${pageContext.request.contextPath }/approval/publicformbox/delForm',
				type : "POST",
	            datatype : 'json',
	            contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
				data : {
					form_code : checkRow
				},
				success : function(data){
					alert("삭제가 완료 되었습니다.");
					location.href="${pageContext.request.contextPath }/approval/publicformbox/publicformList";
				},
				error : function(request, status, error){
					alert("삭제를 실패했습니다.")
				}
			})
		}
		
	}
	
</script>




