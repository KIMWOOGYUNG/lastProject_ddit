<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<style>
	#content{padding:30px;}
	h2{margin:10px 0 30px 0;}
	#nav{float:right;width:140px;margin-top:10px;}
	#searchBtn{width:40px; height:40px;}
	#searchDate{height:40px;}
</style>

<div id="content">

<div class="col-12">
            <div class="card">
              <div class="card-header">
                <h2>공유주간업무일지</h2>
                <div id="nav">
			   		<button id = "myteam" class="btn btn-primary btn-sm">내팀보기</button>
				</div>
				
                <div>
                  <div class="input-group input-group-sm" id="searchUI" style="width: 200px;">
                    
                    <input type="date" id="searchDate" name="searchWord" class="form-control float-right" placeholder="Search"
                    	value="${pagingVO.searchVO.searchWord }"
						onkeyup="event.keyCode==13?$('#searchBtn').trigger('click'):'';"
                    >
					
                    <div class="input-group-append">
                      <button class="btn btn-default" id="searchBtn"><i class="fas fa-search"></i></button>
                    </div>
                    
                  </div>
                </div>
              </div>
              <!-- /.card-header -->
              <div class="card-body table-responsive p-0">
                <table class="table table-hover text-nowrap">
                  <thead>
                    <tr>
                      <th><input type="checkbox" name="checkAll" id="th_checkAll" onclick="checkAll();"/></th>
                      <th>순번</th>
                      <th>작성자</th>
                      <th>작성일</th>
                      <th>제목</th>
                      <th>팀</th>
                    </tr>
                  </thead>
                  <tbody id="listBody">
 
                  </tbody>
					
                </table>
                <div style="margin:20px 20px 20px 20px;">
	                <div id="pagingArea" class="d-flex ml-md-auto d-print-none">
						${pagingVO.pagingHTML }
					</div>	
				</div>
              </div>	
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
</div>
<form id="searchForm" action="${cPath }/work/publicwork/weekdiary/${team_code==null?'all' : team_code}">
	<input type="hidden" name="page" value="${param.page }"/>
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
			let worklogList = resp.dataList;
			let pagingHTML = resp.pagingHTML;
			let trTags = [];
			if(worklogList.length > 0){
				$.each(worklogList, function(idx, worklog){
					console.log(worklog);
					let trTag = $("<tr>").append(
									 $("<td>").html('<input type="checkbox" name="checkRow" value="${content.IDX}" />')
									, $("<td>").text(worklog.rnum)
									, $("<td>").text(worklog.emp_code)
									, $("<td>").text(worklog.wl_date)
									, $("<td>").html($("<a>").attr("href", "${cPath }/work/mywork/weekdiaryview/" + worklog.wl_code).html(worklog.wl_title))
									, $("<td>").text(worklog.team_code));
					trTags.push(trTag);
				});
				$("#pagingArea").html(pagingHTML);
			}else{
				trTags.push($("<tr>").html($("<td colspan='8'>").text("일지가 없습니다.")));
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
	
	// 내 팀 보기
	$("#myteam").on("click", function(){
		 location.href = "${cPath}/work/publicwork/weekdiary/${authUser.team_code }";
	});


</script>
          