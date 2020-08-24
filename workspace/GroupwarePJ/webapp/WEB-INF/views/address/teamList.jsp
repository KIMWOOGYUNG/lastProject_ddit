<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<style>
	#content{padding:50px;}
	.chkBox{width:15px; height:15px;}
 	.icon{margin:0px 5px 10px 0px;} 
	.button{background:none; border:0;}
</style>
<div id="content">
<h1>${title }</h1>
<div id="top">
		<div class="input-group input-group-sm" id="searchUI"
				style="width: 300px; float: left;">
				<select name="searchType" class="custom-select">
					<option value="emp_kor" ${pagingVO.searchVO.searchType eq 'name'?"selected":"" }>이름</option>
					<option value="dept_name" ${paginVO.searchVO.searchType eq 'department'?"selected":"" }>부서</option>
				</select> 
				<input type="text" name="searchWord"
					class="form-control float-right" placeholder="Search" value="${pagingVO.searchVO.searchWord }" />
				<div class="input-group-append">
					<button id="searchBtn"  type="submit" class="btn btn-default">
						<i class="fas fa-search"></i>
					</button>
				</div>
			</div>
			</div>

			<div style="text-align: center;">
				<button class="btn btn-primary btn-sm" href="#">
					<i class=" fas fa-plus"> </i> 이동
				</button>
			</div>
	<!-- 아이콘 -->
	<div>
		<button class="button showBtn" id="blockBtn" data-target="#blockBody">
			<span class="oi oi-grid-three-up icon"></span>
		</button>
		<button class="button showBtn" id="tableBtn"  data-target="#addressTable">
			<span class="oi oi-list icon"></span>
		</button>	
	</div>
	
	
<table class="table table-striped address toggleShow" id="addressTable">
	<thead>
        <tr>
            <th>
                <input type="checkbox" name="checkAll" id="th_checkAll" onclick="checkAll();"/>
            </th>
            <th>이름</th>
            <th>부서명</th>
            <th>팀명</th>
            <th>H.P</th>
            <th>이메일</th>
            <th>내선번호</th>
        </tr>
    </thead>
	<tbody id="listBody">
	</tbody>
</table>	

<div id="blockBody" class="toggleShow" style="height: 850px;">

</div>
<div id="footer">
	<nav id="pagingArea" class="d-flex ml-md-auto d-print-none">
		<div>${pagingVO.pagingHTML }</div>
	</nav>	
</div>
</div>
<form id="searchForm" action="${cPath }/address/teamList?team_code=${pagingVO.detailSearch.team_code}">
	<input type="hidden" name="page" value="${param.page }"/>
	<input type="hidden" name="searchType" value=""/>
	<input type="hidden" name="searchWord" value=""/>
	<input type="hidden" name="viewType" value=""/>	<!-- 페이지를 클릭할때 블럭인지 리스트인지 정보를 받아옴 -->
</form>
<%-- <script type="text/javascript" src="${cPath }/js/paging.js?time=${System.currentTimeMillis()}"></script> --%>
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
					let divTag = $("<div>").append(
									$("<div>").css("display","inline").css("width","30%").css("float","left").addClass("col-12 col-sm-6 col-md-4 align-items-stretch").html(
										$("<div>").addClass("card bg-light").css("margin","10px").html(
												$("<div>").addClass("card-header text-muted border-bottom-0").html($("<p>").text(address.emp_kor))
 										).append(
											$("<div>").addClass("card-body pt-0").html(
												$("<div>").addClass("row").html(
													$("<div>").addClass("col-15").html(
														$("<h4>").addClass("lead").html(
																$("<b>").text(address.emp_kor)
														)
													).append(
														$("<p>").addClass("text-muted text-sm").html($("<p>").text(address.dept_name))
													).append(
														$("<p>").addClass("text-muted text-sm").html($("<p>").text(address.team_name))
													).append(
															$("<p>").addClass("text-muted text-sm").html($("<p>").text(address.emp_hp))		
													).append(
															$("<p>").addClass("text-muted text-sm").html($("<p>").text(address.emp_mail))		
													).append(
															$("<p>").addClass("text-muted text-sm").html($("<p>").text(address.co_phone))		
													)
												 )
											 )
										).append(
											$("<div>").addClass("card-footer").html(
												$("<div>").addClass("text-right").html(
													$("<a>").html($("<span>").addClass("oi oi-zoom-in")).attr("href", "${cPath}/address/detailAddress/"+address.emp_code)
												)
											)
										)
									)
								);
						divTags.push(divTag);
						
						//리스트형태
						let trTag = $("<tr>").append(
								$("<td>").html('<input type="checkbox" class="chkBox" name="checkRow" value="'+address.emp_code+'" />'), 

 								$("<td>").html(
 									$("<a>").attr("href","${cPath}/address/detailAddress/"+address.emp_code)
 									.text(address.emp_kor)//이름
 								)
								, $("<td>").text(address.dept_name)//부서명
								, $("<td>").text(address.team_name)//팀명
								, $("<td>").text(address.emp_hp)//핸드폰번호
								, $("<td>").html(
										$("<a>").attr("href","${cPath}/address/note/writenote/"+address.emp_code)
										.text(address.emp_mail)//이메일
										)
								, $("<td>").text(address.co_phone)//내선번호
						);
						trTags.push(trTag);
				});
				$("#pagingArea").html(pagingHTML);
			}else{
				divTags.push($("<span>").text("검색된 주소록이 없습니다."));
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

//프로젝트 추가
// function insertAction(){
// 	location.href="${pageContext.request.contextPath }/project/newProject";
// }

//전체 선택
function checkAll(){
      if( $("#th_checkAll").is(':checked') ){
        $("input[name=checkRow]").prop("checked", true);
      }else{
        $("input[name=checkRow]").prop("checked", false);
      }
}


</script>
