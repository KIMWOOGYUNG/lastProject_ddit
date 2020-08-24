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
				<!-- 전자결재 -->
				<p>- <spring:message code="menu3"/> -</p>
				</a>
				</li>     
				
				
				
				
				<li class="nav-item has-treeview ">
				<a href="${cPath}/approval/approvalwrite" class="nav-link">
				<p><spring:message code="approval.sideMenu1"/></p>
				</a>
				</li>
				
				
				<li class="nav-item has-treeview ${draft_pos eq '1'or draft_pos eq '2'or draft_pos eq '3'?'menu-open':'' } ">
				<a href="#" class="nav-link">
				<p><spring:message code="approval.sideMenu2"/> <i class="right fas fa-angle-left"> </i></p>
				</a>
					<ul class="nav nav-treeview">
						<li class="nav-item">
						
						<a href="${cPath}/approval/myapproval/all" class="nav-link ${draft_pos eq '1'?'active':'' }">
						<p><spring:message code="approval.sideMenu2_1"/></p>
						</a>
						</li>

						<li class="nav-item " id="tempApproval">
						<a href="${cPath}/approval/myapproval/temp"   class="nav-link ${draft_pos eq '2'?'active':'' }">
						<p><spring:message code="approval.sideMenu2_2"/></p>
						</a>
						</li>

						<li class="nav-item " id="deleteApproval">
						<a href="${cPath}/approval/myapproval/delete"class="nav-link ${draft_pos eq '3'?'active':'' }">
						<p><spring:message code="approval.sideMenu2_3"/></p>
						</a>
						</li>
					</ul>
				<li>
		

			<li class="nav-item" ><a href="${cPath}/approval/entiremanage" class="nav-link">
					<p><spring:message code="approval.sideMenu3"/></p>
			</a></li>
			<li class="nav-item" ><a href="${cPath}/approval/publicformbox" class="nav-link">
					<p><spring:message code="approval.sideMenu4"/></p>
			</a></li>
			<li class="nav-item" ><a href="${cPath}/approval/setting" class="nav-link">
					<p><spring:message code="approval.sideMenu5"/><i class="right fas fa-angle-left"> </i></p>
			</a>
			<ul class="nav nav-treeview">
						<li class="nav-item">
						
						<a href="${cPath}/approval/setting/apprLine" class="nav-link">
						<p><spring:message code="approval.sideMenu5_1"/></p>
						</a>
						</li>

						<li class="nav-item">
						<a href="${cPath}/approval/setting/rg1Line"   class="nav-link">
						<p><spring:message code="approval.sideMenu5_2"/></p>
						</a>
						</li>
						<li class="nav-item">
						<a href="${cPath}/approval/setting/rg2Line"   class="nav-link">
						<p><spring:message code="approval.sideMenu5_3"/></p>
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

<script type="text/javascript">
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