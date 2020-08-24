<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    



 <!-- Main Sidebar Container -->
 
    <!-- Brand Logo -->
    <a href="${cPath }/index" class="brand-link">
      <img src="${cPath }/resources/images/logo.png" alt="groupware Logo" 
           style="width: 230px;height: 50px; ">
<!--       <span class="brand-text font-weight-light">GROUPWARE</span> -->
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="${cPath }/approval/download/emp/${authUser.emp_attcode}" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
          <a href="${cPath }/mypage/${authUser.emp_code}" class="d-block">${authUser.emp_kor }</a>
        </div>

      </div>
        <div class="info" id="attCheck">
	        <button ${faceRec? "":"disabled" } type="button" id="attCheckBtn" class="btn btn-block btn-info" 
	        data-toggle="modal" data-target="#modal-info">
	         	출/퇴근 체크
		    </button>
		      <c:if test="${not faceRec}">
				 <span style="
    font-size: x-small;
    color: white;
    margin: 19px;
"> 얼굴 인식 로그인 후 출/퇴근체크 가능합니다.</span>
		      </c:if>
        </div> 
        <br>
       	<div class="info">
       		<button type="button" class="btn btn-block btn-info" onclick="logout()">
       			로그아웃
       		</button>
       	</div>




    <c:if test="${param.sub eq 'mail' }">
    <%@ include file="/includee/leftMenu/mail_leftMenu.jsp" %>
    </c:if> 

   <c:if test="${param.sub eq 'address' }">
    <%@ include file="/includee/leftMenu/address_leftMenu.jsp" %>
    </c:if>       
     
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  
<script type="text/javascript">
  		var today = new Date();
  		//출근체크날짜구하기
	    var year = today.getFullYear();              //yyyy
	    var month = (1 + today.getMonth());          //M
	    month = month >= 10 ? month : '0' + month;  //month 두자리로 저장
	    var day = today.getDate();                   //d
	    day = day >= 10 ? day : '0' + day;          //day 두자리로 저장
	    var cws_code = year + '' + month + '' + day;       //'-' 추가하여 yyyy-mm-dd 형태 생성 가능
	    var todayStr = year +"년 "+month+"월 "+day+"일 ";
		//출근체크시간구하기
	    var hour = today.getHours();
	    var min = today.getMinutes();
	    var checkTime = hour + ""+ min;
		$('#attCheckBtn').on("click",function(){
			$.ajax({
				type : "POST"
				,url : "${cPath}/attCheck.do"
			 	,data:{cws_code:cws_code,checkTime:checkTime}
				,success:function(resp){
					alert(todayStr+resp);
				}
			});
		});
		
		
		function logout(){
			location.href = "${cPath }/logout";
		}

</script>