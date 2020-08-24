<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<h1>내주소록</h1>

<div class="content">
<!-- <div class="col-md-6"> -->
<!--  <form class="form-horizontal"> -->


            <!-- Horizontal Form -->
            <div class="card card-info">
              <div class="card-header">
                <h3 class="card-title">내 주소록</h3>
                <button class="btn btn-info btn-sm float-sm-center float-right m-0 p-0" type="button" id="updateBtn" style="margin:5px;" >
			    <i class="fas fa-pencil-alt">
			    </i>
			       수정
				</button>
              </div>
              
              <!-- 사진 -->
<!--                <div class="card-footer" align="center"> -->
<!--               <img src="https://via.placeholder.com/300/000000?text=2" class="img-fluid mb-2"  -->
<!--               alt="black sample" style="height: 200px;width:180px;"> -->
<!--                 </div> -->
              
              <!-- /.card-header -->
              <!-- form start -->
              <form class="form-horizontal" method="post" id="myaddressbtn" action="${pageContext.request.contextPath}/address/myaddressDetail/${address.add_code}">
                <input type="hidden" name="_method" value="put"> 
                <div class="card-body">
                  
                  <div class="form-group row">
                    <label for="inputEmail3" class="col-sm-2 col-form-label">이름</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="add_name" name="add_name" readonly="readonly" style="height: 35px;   width: 200px;" value="${address.add_name}">
                    </div>
                  </div>
                  
                  <div class="form-group row">
                    <label for="inputEmail3" class="col-sm-2 col-form-label">소속</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="ag_name" name="ag_name"  readonly="readonly"  style="height: 35px;   width: 200px;" value="${address.ag_name}">
                    </div>
                  </div>
                  
			 <div class="form-group row">
				<label for="inputStatus" class="col-sm-2 col-form-label">직위</label>
				<div class="col-sm-10">
						<input type="text" class="form-control" id="add_title" name="add_title" value="${address.add_title}" readonly="readonly" style="height: 35px; width: 200px;" >	
				</div>
			</div>
			
                  <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">부서명</label>
                    <div class="col-sm-10">
                       <input type="text" class="form-control" id="dept_name" name="dept_name" style="height: 35px; width: 200px;" readonly="readonly" value="${address.dept_name}">
                    </div>
                  </div>
                  
                 
                   <div class="form-group row">
				<label for="inputStatus" class="col-sm-2 col-form-label">이메일</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="add_mail" name="add_mail" value="${address.add_mail}"  readonly="readonly" style="height: 35px; width: 200px;" >	
				 <a href="${cPath}"></a>
				</div>
			</div> 
			
			
			
					   <div class="form-group row">
				<label for="inputStatus" class="col-sm-2 col-form-label">HP</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="add_hp"  name="add_hp" value="${address.add_hp}"readonly="readonly"  style="height: 35px; width: 200px;" >		
				</div>
			</div> 
			
			
			<div class="form-group row">
				<label for="inputStatus" class="col-sm-2 col-form-label">주소</label>
				<div class="col-sm-10">
						<input type="text" class="form-control" id="add_add" name="add_add" value="${address.add_add}" readonly="readonly" style="height: 35px; width: 200px;" >	
				</div>
			</div> 
			
			<div class="form-group row">
				<label for="inputStatus" class="col-sm-2 col-form-label">비고</label>
				<div class="col-sm-10">
						<input type="text" class="form-control" id="add_etc" name="add_etc" value="${address.add_etc}"   readonly="readonly" style="height: 35px; width: 200px;" >	
				</div>
			</div> 
			 <div id="modifyArea" class="card-footer" align="center" hidden>
			
			
			
			<button class="btn btn-info btn-sm float-sm-center" type="button" id="okBtn" style="margin:5px;" >
			    <i class="fas fa-pencil-alt">
			    </i>
			       확인
			</button>
			
			<button class="btn btn-info btn-sm float-sm-center" type="button" id="concleBtn" style="margin:5px;">
			    <i class="fas fa-pencil-alt">
			    </i>
			       취소
			</button>
			
			</div>
			</form>
			</div>
			</div>
			
<script>
$("#updateBtn").on("click", function(){

		$("#updateBtn").attr("hidden", true);
		$("#modifyArea").attr("hidden", false);
		changeState(false);
});

$("#concleBtn").on("click", function(){
	$("#updateBtn").attr("hidden", false);
	$("#modifyArea").attr("hidden", true);
	
	changeState(true);
})
$("#okBtn").on("click", function(){
	
	 let data= $("#myaddressbtn").submit();
	
	 
})
	
function changeState(stat){
	$("#add_name").attr("readonly", stat);
	$("#ag_name").attr("readonly", stat);
	$("#add_title").attr("readonly", stat);
	$("#dept_name").attr("readonly", stat);
	$("#add_mail").attr("readonly", stat);
	$("#add_hp").attr("readonly", stat);
	$("#add_add").attr("readonly", stat);
	$("#add_etc").attr("readonly", stat);
}
</script>
			

