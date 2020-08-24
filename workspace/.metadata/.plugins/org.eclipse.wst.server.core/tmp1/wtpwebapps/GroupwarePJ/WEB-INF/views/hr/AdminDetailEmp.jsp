<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>   
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 

<style>
	.fileChooser{margin-left:7px;}
</style>

<form:form id="employForm" modelAttribute="employ"  method="post" enctype="multipart/form-data" class="w-100"
	action="${pageContext.request.contextPath }${currentAction}">
	<c:if test="${not empty methodType }">
		<input type="hidden" name="_method" value="${methodType }" >
	</c:if>	

<div class="content">
            <!-- Horizontal Form -->
            <div class="card card-info">
              <div class="card-header">
                <h3 class="card-title">사원 상세 정보</h3>
              </div>
              
               <div class="card-footer" align="center">
           <img id="img1"  src="${cPath}/approval/download/emp/${employ.img300}"
				class="img-fluid mb-2" alt="사원 이미지"
				style="height: 200px; width: 180px;"><br>

			
			<h5><b>이미지 미리보기</b></h5>
			<input type="file" id="input_img1" name="img1"/>
                </div>
              
              <!-- /.card-header -->
              <!-- form start -->
                <div class="card-body">
                  <div class="form-group row">
                    <label for="inputEmail3" class="col-sm-2 col-form-label">사원명(한글)</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="emp_kor" name="emp_kor" style="height: 35px; width: 200px;" value="${employ.emp_kor}">
                    </div>
                  </div>
                  <div class="form-group row">
                    <label for="inputEmail3" class="col-sm-2 col-form-label">사원명(영문)</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="emp_eng" name="emp_eng" style="height: 35px; width: 200px;" value="${employ.emp_eng}">
                    </div>
                  </div>
                  <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">사원코드</label>
                    <div class="col-sm-10">
                       <input type="text" class="form-control" id="emp_code" name="emp_code" style="height: 35px; width: 200px;" readonly="readonly" value="${employ.emp_code}">
                    </div>
                  </div>
                  
                   <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">비밀번호</label>
                    <div class="col-sm-10">
                       <input type="password" class="form-control" id="emp_pw" name="emp_pw" style="height: 35px; width: 200px;" value="${employ.emp_pw}">
                    </div>
                  </div>
                  
                   

<!-- 					<div class="form-group row"> -->
<!-- 					<label for="inputStatus" class="col-sm-2 col-form-label">부서명</label> -->
<!-- 					<div class="col-sm-10"> -->
<!-- 						<select class="form-control" style="width: 200px;" -->
<!-- 							name="dept_code"> -->
<!-- 							 <option value="" selected disabled hidden>부서명</option> -->
<%--  							 <option ${employ.dept_code} selected="selected"></option>  --%>
<%-- 							<c:if test="${not empty departnm }"> --%>
<%-- 								<c:forEach items="${departnm }" var="map"> --%>
<%-- 									<c:set var="selected" --%>
<%--  										value="${(map.dept_code eq employ.dept_code) ? 'selected' : ''}" />  --%>
<%--  									<option value="${map.dept_code }" ${selected }>${map.dept_name }</option>  --%>
<%--  								</c:forEach>  --%>
<%--  							</c:if>  --%>
<!-- 						</select> -->
<!-- 					</div> -->
<!-- 				</div> -->
				
				<div class="form-group row">
					<label for="inputStatus" class="col-sm-2 col-form-label" >부서명</label>
					<div class="col-sm-10">
						<select class="dynamicElement form-control"  aria-hidden="true"  style="width: 200px; display: inline;"
								name="dept_code" data-url="<c:url value= '/employ/getDeptList'/>">
							<option selected disabled>부서</option>
						</select> 
					</div>
				</div>
					
				<div class="form-group row">
					<label for="inputStatus" class="col-sm-2 col-form-label">팀명</label>
					<div class="col-sm-10">
						<select class="dynamicElement form-control"  aria-hidden="true"  style="width: 200px; display: inline;"
								name="team_code" data-url="<c:url value= '/employ/getTeamList'/>">
							<option selected disabled>팀</option>
						</select>
					</div>
				</div>
				
<!-- 				<div class="form-group row"> -->
<!-- 					<label for="inputStatus" class="col-sm-2 col-form-label">팀명</label> -->
<!-- 					<div class="col-sm-10"> -->
<!-- 						<select class="form-control" style="width: 200px;" -->
<!-- 							name="team_code"> -->
<%--  							<option selected disabled value="${employ.team_code}">팀명</option>  --%>
<!-- 								 <option value="" selected disabled hidden>팀명</option> -->
<%-- 							<c:if test="${not empty teamnm }"> --%>
<%-- 								<c:forEach items="${teamnm }" var="map"> --%>
<%-- 									<c:set var="selected" --%>
<%-- 										value="${(map.team_code eq employ.team_code) ? 'selected' : ''}" /> --%>
<%-- 									<option value="${map.team_code }" ${selected }>${map.team_name }</option> --%>
<%-- 								</c:forEach> --%>
<%-- 							</c:if> --%>
<!-- 						</select> -->
<!-- 					</div> -->
<!-- 				</div> -->
			
			
			
				<div class="form-group row">
					<label for="inputStatus" class="col-sm-2 col-form-label">직급</label>
					<div class="col-sm-10">
						<select class="form-control" style="width: 200px;"
							name="position_code">
<%-- 							<option selected disabled value="${employ.position_code}">직급</option> --%>
								 <option value="" selected disabled hidden>직급</option>
							<c:if test="${not empty positionnm }">
								<c:forEach items="${positionnm }" var="map">
									<c:set var="selected"
										value="${(map.position_code eq employ.position_code) ? 'selected' : ''}" />
									<option value="${map.position_code }" ${selected }>${map.position_name }</option>
								</c:forEach>
							</c:if>
						</select>
					</div>
				</div>
			
			
			
			
			<div class="form-group row">
					<label for="inputStatus" class="col-sm-2 col-form-label">직책</label>
					<div class="col-sm-10">
						<select class="form-control" style="width: 200px;"
							name="jobtitle_code">
<!-- 							<option selected disabled >직책</option> -->
	 						<option value="" selected disabled hidden>없음</option>
							<c:if test="${not empty jobnm }">
								<c:forEach items="${jobnm }" var="map">
									<c:set var="selected"
										value="${(map.jobtitle_code eq employ.jobtitle_code) ? 'selected' : ''}" />
									<option value="${map.jobtitle_code }" ${selected }>${map.jobtitle_name }</option>
								</c:forEach>
							</c:if>
						</select>
					</div>
				</div>
			
			
			
                   
                 <div class="form-group row">
					<label for="inputStatus" class="col-sm-2 col-form-label">전결권한</label>
					<div class="col-sm-10">
						<select class="form-control" style="width: 200px;" id="power" name="emp_arbitrary">
<!-- 							<option selected disabled>전결권한</option> -->
							<option value="" selected disabled hidden>전결권한</option>
							<option value="y" <c:if test="${employ.emp_arbitrary eq 'y'}">selected</c:if>>허용</option>
							<option value="n"<c:if test="${employ.emp_arbitrary eq 'n'}">selected</c:if>>불허</option>
						</select>
					</div>
				</div>  

                   
                  
                    <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">내선번호</label>
                    <div class="col-sm-10">
                       <input type="text" class="form-control" id="co_phone" name="co_phone" style="height: 35px; width: 200px;" value="${employ.co_phone}">
                    </div>
                  </div>
                  
                   <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">이메일</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="emp_mail" name="emp_mail" style="height: 35px; width: 200px;" value="${employ.emp_mail}">
                    </div>
                  </div>
                  
                    <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">HP</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="emp_hp" name="emp_hp" style="height: 35px; width: 200px;" value="${employ.emp_hp}">
                    </div>
                  </div>
                  
                      <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">우편번호</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" style="height:35PX; width: 150PX; display: inline;" id="adr" name="emp_zip"  value="${employ.emp_zip}">
                      <input type="button" class="form-control btn-info" style="height:35PX; width: 120PX; 
                      display: inline;" value="우편번호 검색" onclick="getAddressInfo()">
                    </div>
                  </div>
                  
                  
                  
                      <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">주소</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="adr2" name="emp_add1" style="height: 35px; width: 400px;" value="${employ.emp_add1}" >
                    </div>
                  </div>
                  
                    <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">상세주소</label>
                    <div class="col-sm-10">
                       <input type="text" class="form-control" id="emp_add2" name="emp_add2" style="height: 35px; width: 500px;" value="${employ.emp_add2}">
                    </div>
                  </div>
                  
                    <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">주민등록번호</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" name="emp_reg1" style="height:35PX; width: 200PX; display: inline;" value="${employ.emp_reg1}"> - 
                      <input type="text" class="form-control" name="emp_reg2" style="height:35PX; width: 200PX; display: inline;" value="${employ.emp_reg2}">
                    </div>
                  </div>
                  
                
                  
                    <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">연봉</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="emp_sal" name="emp_sal" style="height: 35px; width: 200px;" value="${employ.emp_sal}">
                    </div>
                  </div>
                  
                       <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">IP</label>
                    <div class="col-sm-10">
                           <input type="text" class="form-control" id="emp_ip" name="emp_ip" style="height: 35px; width: 200px;" value="${employ.emp_ip}">
                    </div>
                  </div>
                  
                    <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">출퇴근 허용 IP</label>
                    <div class="col-sm-10">
                            <input type="text" class="form-control" id="emp_ip2" name="emp_ip2" style="height: 35px; width: 200px;" value="${employ.emp_ip2}">
                    </div>
                  </div>
                  
                    <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">입사일</label>
                    <div class="col-sm-10">
                      <input type="date" class="form-control" id="emp_startdate" name="emp_startdate" style="height: 35px; width: 200px;" value="${employ.emp_startdate}">
                    </div>
                  </div>
                  
                    <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">퇴사일</label>
                    <div class="col-sm-10">
                      <input type="date" class="form-control" id="retire_date" name="retire_date" style="height: 35px; width: 200px;" value="${employ.retire_date}">
                    </div>
                  </div>
                  
                  
                    <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">휴가일수</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="vaction_cnt" name="vaction_cnt" style="height: 35px; width: 200px;" value="${employ.vaction_cnt}">
                    </div>
                  </div>
                  
                  
                   


			<div class="form-group row">
					<label for="inputStatus" class="col-sm-2 col-form-label">활동여부</label>
					<div class="col-sm-10">
						<select class="form-control" style="width: 200px;" id="active" name="long_vacation">
<!-- 							<option selected disabled>활동여부</option> -->
							<option value="" selected disabled hidden>활동여부</option>
							<option value="y" <c:if test="${employ.long_vacation eq 'y'}">selected</c:if> >활성화</option>
							<option value="n" <c:if test="${employ.long_vacation eq 'n'}">selected</c:if> >비활성화</option>
						</select>
					</div>
				</div>
				
				
				<div class="form-group row">
					<label for="inputStatus" class="col-sm-2 col-form-label">도장</label>
					<div style="width:80%">
						<img id="img2" src="${cPath}/approval/download/emp/${employ.img200}"
						class="img-fluid mb-2" alt=""
						style="height: 100px; width: 100px;">
	<!-- 				<button type="button" class="btn btn-info">도장 업로드</button> -->
						<div class="fileChooser">
							<input type="file" id="input_img2" name="img2" />
						</div>
					</div>
				</div>
				
				<div class="form-group row">
					<label for="inputStatus" class="col-sm-2 col-form-label">서명</label>
					<div style="width:80%">
						<img id="img3" src="${cPath}/approval/download/emp/${employ.img100}"
						class="img-fluid mb-2" alt=""
						style="height: 100px; width: 100px;">	
<!-- 					<button type="button" class="btn btn-info">사인 업로드</button>				 -->
						<div class="fileChooser">
							<input type="file" id="input_img3" name="img3"/>
						</div>
					</div>			
				</div>
				
				
				
              
                </div>
                <!-- /.card-body -->
                <div class="card-footer" align="center">
                  <button type="submit" class="btn btn-default" >수정</button>
                  <button type="button" class="btn btn-info"  onclick ="location.href ='${cPath}/hr/employer/entiremanage'">뒤로가기</button>
                </div>
                <!-- /.card-footer -->
            </div>
            <!-- /.card -->

          </div>
          
         </form:form> 
          
          <script>
//           $(document).on("keyup", "#phonenumber", function() {
//           $(this).val( $(this).val().replace(/[^0-9]/g, "").replace(/(^02|^0505|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,"$1-$2-$3").replace("--", "-") ); });
	
	$(document).on("keyup", "#phonenumber", function() { 
	$(this).val( $(this).val().replace(/[^0-9]/g, "").replace(/(^02|^0505|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,"$1-$2-$3").replace("--", "-") ); });


	$(document).on("keyup", "#innertel", function() { 
	$(this).val( $(this).val().replace(/[^0-9]/g, "").replace(/(^02|^0505|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,"$1-$2-$3").replace("--", "-") ); });




	</script>
	
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
   <script>
 //해당 코드는 사용자가 클릭한것을 반환해준다 ( 도로명 클릭시 도로명 반환,지번 클릭시 지번반환)
 //기본적으로 다음 API는 (시,구,동만 반환해준다 상세정보 반환X) 하지만 풀주소는 반환해준다 
 //따라서 풀주소로 시,구,동,상세주소를 파싱해주자..
     
 	function getAddressInfo() {
        new daum.Postcode({
            oncomplete: function(data) {
              //  var roadAddr = data.roadAddress; // 도로명 주소 변수
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
//                 document.getElementById('adr').value = data.zonecode;
//                 document.getElementById('adrr').value = data.jibunAddress;
             
               
                if(data.userSelectedType=='R'){
                 document.getElementById('adr').value = data.zonecode;	
                 document.getElementById('adr2').value = data.roadAddress;
                }else{
                	 document.getElementById('adr').value = data.zonecode;	
                     document.getElementById('adr2').value = data.jibunAddress;	
				}
                
                
            }
        }).open();
    }
 
 


   </script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/dynamicSelect.js?time=${System.currentTimeMillis()}"></script>
	<script>
	
	//부서 동적 셀렉박스
	optionPtrn = "<option value='%V' %S>%T</option>";
	var deptTag = $("select[name='dept_code']").data("success", function(resp){
		
		var html = "";
		$.each(resp, function(i, dept){
			var selected = "";
			if(dept.dept_code == '${employ.dept_code}'){
				selected = "selected"; 
			}
	
			html += optionPtrn.replace("%V", dept.dept_code)
							  .replace("%T", dept.dept_name) 
							  .replace("%S", selected);
		});
		deptTag.append(html);
	}).on("change", function(){
		let dept_code = $(this).val();
		
		team_codeTag.trigger("renew", {
			dept_code : dept_code
		});
	
	});
	
	var team_codeTag = $("select[name='team_code']").data("success", function(resp){
		var html = "<option value=''>팀</option>";
		$.each(resp, function(i, team){
			var selected = "";
			if(team.team_code == '${employ.team_code}'){
				selected = "selected";
			}
			html += optionPtrn.replace("%V", team.team_code)
							  .replace("%T", team.team_name)
							  .replace("%S", selected);
		});
		team_codeTag.html(html);
	});
	
	
	$(".dynamicElement").dynamicSelect();
	
	</script>
	
	
  
	<script type="text/javascript">
 
// 	사원 사진
	var sel_file;
	var sel_file2;
	var sel_file3;
	$(document).ready(function(){
		$("#input_img1").on("change", handleImagFileSelect1);
		$("#input_img2").on("change", handleImagFileSelect2);
		$("#input_img3").on("change", handleImagFileSelect3);
	});
	
	function handleImagFileSelect1(e){
		var files = e.target.files;
		var filesArr = Array.prototype.slice.call(files);
		
		filesArr.forEach(function(f){
			if(!f.type.match("image.*")){
				alert("확장자는 이미지 확장자만 가능합니다");
				return;
			}
			
			sel_file = f;
			
			var reader = new FileReader();
			reader.onload = function(e){
				$("#img1").attr("src", e.target.result);
			}
			reader.readAsDataURL(f);
		});
	}
	
	

	
	
	
	function handleImagFileSelect2(e){
		var files = e.target.files;
		var filesArr = Array.prototype.slice.call(files);
		
		filesArr.forEach(function(f2){
			if(!f2.type.match("image.*")){
				alert("확장자는 이미지 확장자만 가능합니다");
				return;
			}
			
			sel_file2 = f2;
			
			var reader = new FileReader();
			reader.onload = function(e){
				$("#img2").attr("src", e.target.result);
			}
			reader.readAsDataURL(f2);
		});
	}
	
	function handleImagFileSelect3(e){
		var files = e.target.files;
		var filesArr = Array.prototype.slice.call(files);
		
		filesArr.forEach(function(f3){
			if(!f3.type.match("image.*")){
				alert("확장자는 이미지 확장자만 가능합니다");
				return;
			}
			
			sel_file3 = f3;
			
			var reader = new FileReader();
			reader.onload = function(e){
				$("#img3").attr("src", e.target.result);
			}
			reader.readAsDataURL(f3);
		});
	}
	
	</script>
          
          
          
          
          
          
          
          
          