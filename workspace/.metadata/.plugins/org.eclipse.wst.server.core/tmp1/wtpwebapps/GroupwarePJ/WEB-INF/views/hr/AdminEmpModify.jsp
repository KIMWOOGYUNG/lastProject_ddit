<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form id="employeeForm" modelAttribute="employee" method="post" enctype="multipart/form-data" class="w-100"
			action="${pageContext.request.contextPath }/hr/employer/empenroll">
<div class="col-md-6">

	<!-- Horizontal Form -->
	<div class="card card-info">
		<div class="card-header">
			<h3 class="card-title">사원 정보 등록</h3>
		</div>

		<div class="card-footer" align="center">
			<img src="https://via.placeholder.com/300/000000?text=2"
				class="img-fluid mb-2" alt="black sample"
				style="height: 200px; width: 180px;">
			<button type="submit" class="btn btn-info">첨부</button>
			<button type="submit" class="btn btn-default">삭제</button>
		</div>

			

			<c:if test="${not empty methodType }">
				<input type="hidden" name="_method" value="${methodType }">
			</c:if>

		<form role="form">
			<div class="card-body">
				<div class="form-group row">
					<label for="inputEmail3" class="col-sm-2 col-form-label">사원명(한글)</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="emp_kor"
							style="height: 35px; width: 200px;" value="${employee.emp_kor}" name="emp_kor" >
					</div>
				</div>
				
				<div class="form-group row">
					<label for="inputEmail3" class="col-sm-2 col-form-label">사원명(영문)</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="emp_eng"
							style="height: 35px; width: 200px;" value="${employee.emp_eng}" name="emp_eng">
					</div>
				</div>
				
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">사원코드</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="emp_code"
							style="height: 35px; width: 200px;" readonly="readonly" value="${employee.emp_code}" name="emp_code">
					</div>
				</div>

				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">비밀번호</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="emp_pw"
							style="height: 35px; width: 200px;" value="${employee.emp_pw}" name="emp_pw">
					</div>
				</div>

				<div class="form-group row">
					<label for="inputStatus" class="col-sm-2 col-form-label">부서명</label>
					<div class="col-sm-10">
						<select class="form-control" style="width: 200px;"
							name="dept_code">
							<option selected disabled value="${employee.dept_code}">부서명</option>
							<c:if test="${not empty departnm }">
								<c:forEach items="${departnm }" var="map">
									<c:set var="selected"
										value="${(map.dept_code eq department.dept_name) or (map.dept_name eq department.dept_name)? 'selected' : ''}" />
									<option value="${map.dept_code }" ${selected }>${map.dept_name }</option>
								</c:forEach>
							</c:if>
						</select>
					</div>
				</div>

				<div class="form-group row">
					<label for="inputStatus" class="col-sm-2 col-form-label">팀명</label>
					<div class="col-sm-10">
						<select class="form-control" style="width: 200px;"
							name="team_code">
							<option selected disabled value="${employee.team_code}">팀명</option>
							<c:if test="${not empty teamnm }">
								<c:forEach items="${teamnm }" var="map">
									<c:set var="selected"
										value="${(map.team_code eq team.team_name) or (map.team_name eq team.team_name)? 'selected' : ''}" />
									<option value="${map.team_code }" ${selected }>${map.team_name }</option>
								</c:forEach>
							</c:if>
						</select>
					</div>
				</div>

				<div class="form-group row">
					<label for="inputStatus" class="col-sm-2 col-form-label">직급</label>
					<div class="col-sm-10">
						<select class="form-control" style="width: 200px;"
							name="position_code">
							<option selected disabled value="${employee.position_code}">직급</option>
							<c:if test="${not empty positionnm }">
								<c:forEach items="${positionnm }" var="map">
									<c:set var="selected"
										value="${(map.position_code eq position.position_name) or (map.position_name eq position.position_name)? 'selected' : ''}" />
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
							<option selected disabled >직책</option>
							<option value="">없음</option>
							<c:if test="${not empty jobnm }">
								<c:forEach items="${jobnm }" var="map">
									<c:set var="selected"
										value="${(map.jobtitle_code eq jobtitle.jobtitle_name) or (map.jobtitle_name eq jobtitle.jobtitle_name)? 'selected' : ''}" />
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
							<option selected disabled>전결권한</option>
							<option value="y">허용</option>
							<option value="n">불허</option>
						</select>
					</div>
				</div>

				<!--                    <div class="form-group row"> -->
				<!--                     <label for="inputPassword3" class="col-sm-2 col-form-label">부서명</label> -->
				<!--                     <div class="col-sm-10"> -->
				<!--                       <input type="password" class="form-control" id="inputPassword3" > -->
				<!--                     </div> -->
				<!--                   </div> -->

				<!--                     <div class="form-group row"> -->
				<!--                     <label for="inputPassword3" class="col-sm-2 col-form-label">직급</label> -->
				<!--                     <div class="col-sm-10"> -->
				<!--                       <input type="password" class="form-control" id="inputPassword3" > -->
				<!--                     </div> -->
				<!--                   </div> -->

				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">내선번호</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="innertel"
							style="height: 35px; width: 200px;" value="${employee.co_phone}" name="co_phone">
					</div>
				</div>

				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">이메일</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="emp_mail"
							style="height: 35px; width: 200px;" value="${employee.emp_mail}" name="emp_mail">
					</div>
				</div>

				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">HP</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="phonenumber"
							style="height: 35px; width: 200px;" value="${employee.emp_hp}" name="emp_hp">
					</div>
				</div>

				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">우편번호</label>
					<div class="col-sm-10">
						<input type="text" class="form-control"
							style="height: 35PX; width: 150PX; display: inline;" id="adr"
							value="${employee.emp_zip}" name="emp_zip"> <input type="button"
							class="form-control btn-info"
							style="height: 35PX; width: 120PX; display: inline;"
							value="우편번호 검색" onclick="getAddressInfo()">
					</div>
				</div>

				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">주소</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="adr2"
							style="height: 35px; width: 400px;" value="${employee.emp_add1}" name="emp_add1">
					</div>
				</div>

				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">상세주소</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="adr3"
							style="height: 35px; width: 500px;" value="${employee.emp_add2}" name="emp_add2">
					</div>
				</div>

				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">주민등록번호</label>
					<div class="col-sm-10">
						<input type="text" class="form-control"
							style="height: 35PX; width: 200PX; display: inline;"
							value="${employee.emp_reg1}" name="emp_reg1"> - <input type="text"
							class="form-control"
							style="height: 35PX; width: 200PX; display: inline;"
							value="${employee.emp_reg2}" name="emp_reg2">
					</div>
				</div>

				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">연봉</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="emp_sal"
							style="height: 35px; width: 200px;" value="${employee.emp_sal}" name="emp_sal">
					</div>
				</div>

				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">IP</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="emp_ip"
							style="height: 35px; width: 200px;" value="${employee.emp_ip}" name="emp_ip">
					</div>
				</div>

				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">출퇴근
						허용 IP</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="emp_ip2"
							style="height: 35px; width: 200px;" value="${employee.emp_ip2}" name="emp_ip2">
					</div>
				</div>

				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">입사일</label>
					<div class="col-sm-10">
						<input type="date" class="form-control" id="emp_startdate"
							style="height: 35px; width: 200px;"
							value="${employee.emp_startdate}" name="emp_startdate">
					</div>
				</div>

				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">퇴사일</label>
					<div class="col-sm-10">
						<input type="date" class="form-control" id="retire_date"
							style="height: 35px; width: 200px;"
							value="${employee.retire_date}" name="retire_date">
					</div>
				</div>

				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">휴가일수</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="vaction_cnt"
							style="height: 35px; width: 200px;"
							value="${employee.vaction_cnt}" name="vaction_cnt">
					</div>
				</div>

				<div class="form-group row">
					<label for="inputStatus" class="col-sm-2 col-form-label">활동여부</label>
					<div class="col-sm-10">
						<select class="form-control" style="width: 200px;" id="active" name="long_vacation">
							<option selected disabled>활동여부</option>
							<option value="y">활성화</option>
							<option value="n">비활성화</option>
						</select>
					</div>
				</div>

			</div>
			<!-- /.card-body -->
			<div class="card-footer" align="center">
				<button type="submit" class="btn btn-info">등록</button>
				<button type="submit" class="btn btn-default">취소</button>
			</div>
		</form>
			<!-- /.card-footer -->

	<!-- /.card -->

</div>
</div>
		</form:form>	



<script>
	//           $(document).on("keyup", "#phonenumber", function() {
	//           $(this).val( $(this).val().replace(/[^0-9]/g, "").replace(/(^02|^0505|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,"$1-$2-$3").replace("--", "-") ); });

	$(document)
			.on(
					"keyup",
					"#phonenumber",
					function() {
						$(this)
								.val(
										$(this)
												.val()
												.replace(/[^0-9]/g, "")
												.replace(
														/(^02|^0505|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,
														"$1-$2-$3").replace(
														"--", "-"));
					});

	$(document)
			.on(
					"keyup",
					"#innertel",
					function() {
						$(this)
								.val(
										$(this)
												.val()
												.replace(/[^0-9]/g, "")
												.replace(
														/(^02|^0505|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,
														"$1-$2-$3").replace(
														"--", "-"));
					});
</script>

<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	//해당 코드는 사용자가 클릭한것을 반환해준다 ( 도로명 클릭시 도로명 반환,지번 클릭시 지번반환)
	//기본적으로 다음 API는 (시,구,동만 반환해준다 상세정보 반환X) 하지만 풀주소는 반환해준다 
	//따라서 풀주소로 시,구,동,상세주소를 파싱해주자..

	function getAddressInfo() {
		new daum.Postcode({
			oncomplete : function(data) {
				//  var roadAddr = data.roadAddress; // 도로명 주소 변수
				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				//                 document.getElementById('adr').value = data.zonecode;
				//                 document.getElementById('adrr').value = data.jibunAddress;

				if (data.userSelectedType == 'R') {
					document.getElementById('adr').value = data.zonecode;
					document.getElementById('adr2').value = data.roadAddress;
				} else {
					document.getElementById('adr').value = data.zonecode;
					document.getElementById('adr2').value = data.jibunAddress;
				}

			}
		}).open();
	}

	$("#power option:selected").val();

	$("#active option:selected").val();
	
	
</script>















