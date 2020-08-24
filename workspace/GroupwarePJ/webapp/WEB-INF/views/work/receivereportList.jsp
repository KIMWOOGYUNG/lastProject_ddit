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
                <h2>받은업무보고</h2>

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
                      <th>보고자</th>
                      <th>보고일</th>
                      <th>제목</th>
                      <th>보고상태</th>
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
<form id="searchForm" action="${cPath }/work/workreport/receivereport">
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
			let receivereportList = resp.dataList;
			let pagingHTML = resp.pagingHTML;
			let trTags = [];
			if(receivereportList.length > 0){
				$.each(receivereportList, function(idx, receive){
					console.log(receive);
					let trTag = $("<tr>").append(
									 $("<td>").html('<input type="checkbox" name="checkRow" value="${content.IDX}" />')
									, $("<td>").text(receive.rnum)
									, $("<td>").text(receive.emp_reporter)
									, $("<td>").text(receive.report_date)
									, $("<td>").html($("<a>").attr("href", "${cPath }/work/workreport/receiveview/" + receive.report_code).html(receive.report_title))
									, $("<td>").text(receive.report_stat));
					trTags.push(trTag);
				});
				$("#pagingArea").html(pagingHTML);
			}else{
				alert("직급이 '부장'이상인 사원만 열람 가능합니다.");
				trTags.push($("<tr>").html($("<td colspan='8'>").text("보고가 없습니다.")));
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
  </script >