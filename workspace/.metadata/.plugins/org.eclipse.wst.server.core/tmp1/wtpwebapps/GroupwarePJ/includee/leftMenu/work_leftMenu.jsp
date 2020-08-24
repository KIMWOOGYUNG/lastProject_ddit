


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
				<!-- 업무 -->
				<p>- <spring:message code="menu5"/> -</p>
				</a>
				</li>     
				
			   
			   
				
				<li class="nav-item has-treeview">
				<a href="#" class="nav-link">
				<p><spring:message code="work.sideMenu1"/><i class="right fas fa-angle-left"> </i></p>
				</a>
					<ul class="nav nav-treeview">
						<li class="nav-item">
						<a href="#" class="nav-link">
						<p><spring:message code="work.sideMenu1_1"/><i class="right fas fa-angle-left"></i></p>
						</a>
						<ul class="nav nav-treeview">
						</li>
						
						<li class="nav-item">
						<a href="${cPath }/work/mywork/daydiary" class="nav-link">
						<p><spring:message code="work.sideMenu1_1_1"/></p>
						</a>
						</li>
						
						<li class="nav-item">
						<a href="${cPath }/work/mywork/weekdiary" class="nav-link">
						<p><spring:message code="work.sideMenu1_1_2"/></p>
						</a>
						</li>
						
						<li class="nav-item">
						<a href="${cPath }/work/mywork/trashbasket" class="nav-link">
						<p><spring:message code="work.sideMenu1_1_3"/></p>
						</a>
						</li>
					
					</ul>
						<li>

						<li class="nav-item">
						<a href="#" class="nav-link">
						<p><spring:message code="work.sideMenu1_2" /><i class="right fas fa-angle-left"></i></p>
						</a>
						<ul class="nav nav-treeview">
						</li>
						
						<li class="nav-item">
						<a href="${cPath }/work/publicwork/daydiary/all" class="nav-link">
						<p><spring:message code="work.sideMenu1_2_1" /></p>
						</a>
						</li>
						
						<li class="nav-item">
						<a href="${cPath }/work/publicwork/weekdiary/all" class="nav-link">
						<p><spring:message code="work.sideMenu1_2_2" /></p>
						</a>
						</li>
						
					
						</ul>
						<li>
						
						
						<li class="nav-item">
						<a href="./index.html" class="nav-link">
						<p><spring:message code="work.sideMenu1_3" /><i class="right fas fa-angle-left"></i></p>
						</a>
						<ul class="nav nav-treeview">
						</li>
						
						<li class="nav-item">
						<a href="${cPath }/work/teamwork/diary" class="nav-link">
						<p>${authUser.team_name }</p>
						</a>
						</li>
						
						<li class="nav-item">
						<a href="${cPath }/work/teamwork/teamtrashbasket" class="nav-link">
						<p><spring:message code="work.sideMenu1_3_1" /></p>
						</a>
						</li>
						
					
						</ul>
						<li>
				
					</ul>
				<li>
				
				
				
				<li class="nav-item has-treeview">
				<a href="#" class="nav-link">
				<p><spring:message code="work.sideMenu2" /><i class="right fas fa-angle-left"></i></p>
				</a>
					<ul class="nav nav-treeview">
						<li class="nav-item has-treeview">
						<a href="./index.html" class="nav-link">
						<p><spring:message code="work.sideMenu2_1" /><i class="right fas fa-angle-left"></i></p>
						</a>
						<ul class="nav nav-treeview">
						</li>
						
						<%-- <li class="nav-item">
						<a href="${pageContext.request.contextPath }/work/workreport/myworkreport/dayreport" class="nav-link">
						<p><spring:message code="work.sideMenu2_1_1" /></p>
						</a>
						</li> --%>
						
						<li class="nav-item">
						<a href="${cPath }/work/workreport/myworkreport/report" class="nav-link">
						<p><spring:message code="work.sideMenu2_1_2" /></p>
						</a>
						</li>
					
						</ul>
						<c:if test="${authUser.position_code == 'PO005'}">
							<li>
							<li class="nav-item">
							<a href="${cPath }/work/workreport/receivereport" class="nav-link">
							<p><spring:message code="work.sideMenu2_2" /></p>
							</a>
							</li>
						</c:if>
						
				
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


