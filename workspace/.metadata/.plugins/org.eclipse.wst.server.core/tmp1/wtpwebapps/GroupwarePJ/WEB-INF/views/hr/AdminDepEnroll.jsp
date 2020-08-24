<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<style>
	#content {padding: 50px;}
</style>

<div id="content">
<form:form id="departmentForm" modelAttribute="department" method="post" enctype="multipart/form-data" class="w-100">

	<div class="card card-primary">
	    <div class="card-header">
	      <h3 class="card-title">신규 등록</h3>
	    </div>
	  
		<div class="card-body">
			<div style="width:200px;">
			  <input type="radio" name="radio" id="r1" value="1" ><label for="r1">&nbsp;부서</label>
			  <input type="radio" name="radio" id="r2" value="0"><label for="r2">&nbsp;팀</label>
			</div>
		           
		           
		     <div id="dep">
		        <div class="form-group row" >
			        <label for="inputEmail3" class="col-sm-2 col-form-label">부서 명</label>
			        <div class="col-sm-10">
			         <input type="text" class="form-control" id="dp1" name="dept_name" style="width: 200px;">
					</div>
		  		</div>
		     </div>
		     
             <hr>
             
             <div id="dep">
                  
				<div class="form-group row">
					<label for="inputStatus" class="col-sm-2 col-form-label">부서명</label>
					<div class="col-sm-10">
						<select class="form-control" style="width: 200px;"
							name="dept_code" id="dp2">
							<option value="" selected disabled>부서명</option>
							<c:if test="${not empty departnm }">
								<c:forEach items="${departnm }" var="map">
									<c:set var="selected" value="${(map.dept_code eq department.dept_code)? 'selected' : ''}" />  
									<option value="${map.dept_code }" ${selected }>${map.dept_name }</option> 
								</c:forEach> 
							</c:if>  
						</select>
					</div>
				</div>
			
				<div class="form-group row" >
				  <label for="inputEmail3" class="col-sm-2 col-form-label">팀 명</label>
				  <div class="col-sm-10">
				    <input type="text" class="form-control" id="team_name" name="team_name" style="width: 200px;">
				  </div>
				</div>
			                
			</div>
		</div>
		
	      <div class="card-footer" align="center">
	        <button type="submit" class="btn btn-primary">등록</button>
	        <a class="btn btn-default" href="${cPath}/hr/departmentmanage">취소</a>
	      </div>
   
           </div>
          </form:form>
</div>      
          
    <script>
    var radio = 1
    
    	 
	        // 라디오버튼 클릭시 이벤트 발생
	        $("input:radio[name=radio]").on("click",function(){
	            
	        	console.log( $("input[name=radio]:checked").val() )
	            if($("input[name=radio]:checked").val() == "1"){
	                $("#dp1").attr("disabled",false);
	                $("#dp2").attr("disabled",true);
	                $("input:text[name=team_name]").attr("disabled",true);
	                // radio 버튼의 value 값이 1이라면 활성화
	     
	            }else if($("input[name=radio]:checked").val() == "0"){
	                  $("#dp1").attr("disabled",true);
	                  $("#dp2").attr("disabled",false);
		                $("input:text[name=team_name]").attr("disabled",false);
	                // radio 버튼의 value 값이 0이라면 비활성화
		            }
	        	
    if($("input:radio[name=radio]:checked").val() == "1"){
    	action="${pageContext.request.contextPath }/hr/employer/depenroll"
    	console.log("부서등록");
    	
    }else {
    	action="${pageContext.request.contextPath }/hr/employer/teamenroll"
    		console.log("팀등록");
    }
	        	
   $("#departmentForm").attr("action",action); 
		        });

    
    
    </script>
         
          