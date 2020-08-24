\<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>



<!-- Main Sidebar Container -->
<aside class="main-sidebar sidebar-dark-primary elevation-4">

	<!-- Sidebar -->
	<div class="sidebar">
	  <div class="user-panel mt-3 pb-3 mb-3 d-flex">
	    <a href="${cPath }/index">
	      <img src="${cPath }/resources/images/logo.png" alt="groupware Logo" 
	           style="width: 230px;height: 50px; ">
	    </a>
      </div>
		<!-- Sidebar Menu -->
		<nav class="mt-2">
			<ul class="nav nav-pills nav-sidebar flex-column"
				data-widget="treeview" role="menu" data-accordion="false">
				<!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
               
               	<li class="nav-item">
				<a href="#" class="nav-link">
				<!-- HR -->
				<p>- <spring:message code="menu4"/> -</p>
				</a>
				</li>
               
               
               
				<li class="nav-item has-treeview">
				<a href="#" class="nav-link">
				<!-- 사원관리 -->
				<p><spring:message code="hr.sideMenu1"/> <i class="right fas fa-angle-left"> </i></p>
				</a>
					<ul class="nav nav-treeview">
						<li class="nav-item">
						<a href="${cPath}/hr/employer/entiremanage" class="nav-link">
						<!-- 전 사원 관리 -->
						<p><spring:message code="hr.sideMenu1_1"/></p>
						</a>
						</li>

						<li class="nav-item">
						<a href="${cPath}/hr/employer/retiremanage" class="nav-link">
						<!-- 퇴사자 관리 -->
						<p><spring:message code="hr.sideMenu1_2"/></p>
						</a>
						</li>

						
					</ul>
				<li>
				
				<li class="nav-item has-treeview">
				<a href="#" class="nav-link">
				<!-- 부서관리 -->
				<p><spring:message code="hr.sideMenu2"/><i class="right fas fa-angle-left"> </i></p>
				</a>
					<ul class="nav nav-treeview">
						<li class="nav-item">
						<a href="${cPath}/hr/departmentmanage" class="nav-link">
						<!-- 부서 현황 -->
						<p><spring:message code="hr.sideMenu2_1"/></p>
						</a>
						</li>
						
					</ul>	
					<ul class="nav nav-treeview">
						<li class="nav-item">
						<a href="${cPath}/hr/teammanage" class="nav-link">
						<!-- 팀 현황 -->
						<p><spring:message code="hr.sideMenu2_2"/></p>
						</a>
						</li>
						
					</ul>	
						
						<li class="nav-item has-treeview">
				<a href="#" class="nav-link">
				<!-- 근태관리 -->
				<p><spring:message code="hr.sideMenu3"/> <i class="right fas fa-angle-left"> </i></p>
				</a>
					<ul class="nav nav-treeview">
						
						
						<li class="nav-item has-treeview">
						<a href="#" class="nav-link">
						<!-- 전 사원 근태조회 -->
						<p><spring:message code="hr.sideMenu3_1"/> <i class="right fas fa-angle-left"></i></p>
						</a>
						<ul class="nav nav-treeview">
						
						<li class="nav-item">
						<a href="${cPath }/hr/att/monthlyList" class="nav-link">
						<!-- 월별 근태 현황 -->
						<p><spring:message code="hr.sideMenu3_1_1"/></p>
						</a>
						</li>
						
						<li class="nav-item">
						<a href="${cPath }/hr/att/detailList" class="nav-link">
						<!-- 상세 근태 현황 -->
						<p><spring:message code="hr.sideMenu3_1_2"/></p>
						</a>
						</li>
						
						</ul>
						</li>
						
<!-- 						<li class="nav-item"> -->
<%-- 						<a href="${cPath }/hr/att/Setting" class="nav-link"> --%>
<!-- 						근태 입력 -->
<%-- 						<p><spring:message code="hr.sideMenu3_2"/></p> --%>
<!-- 						</a> -->
<!-- 						</li> -->
						
						<li class="nav-item has-treeview">
						<a href="#" class="nav-link">
						<!-- 근태 기초정보 설정 -->
						<p><spring:message code="hr.sideMenu3_3"/><i class="right fas fa-angle-left"></i></p>
						</a>
						<ul class="nav nav-treeview">
						
						<li class="nav-item">
						<a href="${cPath }/hr/att/holiday" class="nav-link">
						<!-- 휴일 정보 등록 -->
						<p><spring:message code="hr.sideMenu3_3_1"/></p>
						</a>
						</li>
						
						<li class="nav-item">
						<a href="${cPath }/hr/att/ip" class="nav-link">
						<!-- 출퇴근 허용 IP 설정 -->
						<p><spring:message code="hr.sideMenu3_3_2"/></p>
						</a>
						</li>
						
						<li class="nav-item">
						<a href="${cPath }/hr/att/faceid" class="nav-link">
						<!-- FACEID관리 -->
						<p><spring:message code="hr.sideMenu3_3_3"/></p>
						</a>
						</li>
						
						
						</ul>
						</li>
						
						
		

			
			</ul>
		</nav>
		<!-- /.sidebar-menu -->
	</div>
	<!-- /.sidebar -->
</aside>
<script>
let addr= '${requestScope['javax.servlet.forward.servlet_path']}';
let selectNode = $(".sidebar").find("a[href *= '${requestScope['javax.servlet.forward.servlet_path']}']");

mouseClick(selectNode);

function mouseClick(aTag){
	aTag.addClass("active");
	let ul = aTag.closest("ul");
	let li = ul.closest("li");
	
	if(li.length > 0){
		ul.css("margin-left","10px");
		li.addClass("menu-open");
		aTag = li.children("a");
		mouseClick(aTag);
	}
}

</script>