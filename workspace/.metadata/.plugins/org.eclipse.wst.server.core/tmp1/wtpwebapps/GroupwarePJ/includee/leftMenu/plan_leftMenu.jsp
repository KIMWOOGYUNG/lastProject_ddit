<%@ page language="java" contentType="text/html; charset=UTF-8"
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
				<!-- 일정 -->
				<p>- <spring:message code="menu7"/> -</p>
				</a>
				</li> 
				
				
				
				
				<!--회사일정함 -->
				<li class="nav-item"> 
						<a href="${cPath}/plan/complancalendar" class="nav-link">
						<p><spring:message code="plan.sideMenu1"/></p>
						</a>
						</li>
				
				
				
				
				
				<li class="nav-item has-treeview">
				<a href="#" class="nav-link">
				<!--부서일정함 -->
				<p><spring:message code="plan.sideMenu2"/><i class="right fas fa-angle-left"> </i></p>
				</a>
					<ul class="nav nav-treeview">
						<li class="nav-item">
						<a href="${cPath}/plan/depplancalendar/all" class="nav-link">
						<!--부서일정 -->
						<p><spring:message code="plan.sideMenu2_1"/></p>
						</a>
						</li>

						<li class="nav-item">
						<a href="${cPath}/plan/depplancalendar/my" class="nav-link">
						<!--부서 내 일정 -->
						<p><spring:message code="plan.sideMenu2_2"/></p>
						</a>
						</li>
				
					</ul>
				<li>
				
				
				
				
				
				<li class="nav-item has-treeview">
				<a href="#" class="nav-link">
				<!--내 일정함 -->
				<p><spring:message code="plan.sideMenu3"/> <i class="right fas fa-angle-left"> </i></p>
				</a>
					<ul class="nav nav-treeview">
						<li class="nav-item">
						<a href="${cPath}/plan/myplancalendar/all" class="nav-link">
						<!--내 일정 -->
						<p><spring:message code="plan.sideMenu3_1"/></p>
						</a>
						</li>

						<li class="nav-item">
						<a href="${cPath}/plan/myplancalendar/import" class="nav-link">
						<!--중요 일정 -->
						<p><spring:message code="plan.sideMenu3_2"/></p>
						</a>
						</li>

					
					</ul>
				<li>
				
	
			
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