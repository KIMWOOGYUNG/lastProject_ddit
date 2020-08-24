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
            
            <li class="nav-item">
            <a href="#" class="nav-link">
        <!-- 프로젝트 -->
            <p>- <spring:message code="menu6"/> -</p>
            </a>
            </li>
            
            
            
            
            <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
            <p><spring:message code="project.sideMenu1"/> <i class="right fas fa-angle-left"> </i></p>
            </a>
               <ul class="nav nav-treeview">
               
              <!-- 내 프로젝트 -->
                  <li class="nav-item">
                  <a href="${pageContext.request.contextPath }/project/projectlist/my" class="nav-link">
                  <p><spring:message code="project.sideMenu1_1"/></p>
                  </a>
                  </li>

              <!-- 모든 프로젝트 -->
                  <li class="nav-item">
                  <a href="${pageContext.request.contextPath}/project/projectlist/all" class="nav-link">
                  <p><spring:message code="project.sideMenu1_2"/></p>
                  </a>
                  </li>
                  
               </ul>
            <li>
   
  <c:set var="project" value="${projectCommon }"/>
  <c:if test="${not empty project}">
            
            <li class="nav-item">
                  <a href="${cPath}/project/eachproject/${project.project_code}" class="nav-link">
                  <p>${project.project_name}</p>
                  </a>
            </li>
            
            <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
            <p><spring:message code="project.sideMenu2"/> <i class="right fas fa-angle-left"> </i></p>
            </a>
               <ul class="nav nav-treeview">
               
               <!-- 달력 -->
                  <li class="nav-item">
                  <a href="${cPath}/project/projectplan/${project.project_code }/calendar" class="nav-link">
                  <p><spring:message code="project.sideMenu2_1"/></p>
                  </a>
                  </li>

				<!-- 간트 -->
                  <li class="nav-item">
                  <a href="${cPath}/project/projectplan/${project.project_code }/ganttchart" class="nav-link">
                  <p><spring:message code="project.sideMenu2_2"/></p>
                  </a>
                  </li>
               </ul>
            <li>
            
            
            
            <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
            <p><spring:message code="project.sideMenu3"/> <i class="right fas fa-angle-left"> </i></p>
            </a>
               <ul class="nav nav-treeview">
               
               <!-- 선택한 프로젝트의 내 일감 -->
                  <li class="nav-item">
                  <a href="${pageContext.request.contextPath }/project/tasklist/${project.project_code }/myTask" class="nav-link">
                  <p><spring:message code="project.sideMenu3_2"/></p>
                  </a>
                  </li>
                  
               <!-- 선택한 프로젝트의 모든 일감 -->
                  <li class="nav-item">
                  <a href="${pageContext.request.contextPath }/project/tasklist/${project.project_code }/allTask" class="nav-link">
                  <p><spring:message code="project.sideMenu3_1"/></p>
                  </a>
                  </li>
               </ul>
            <li>
</c:if>       
          
          
               <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
            <p><spring:message code="project.sideMenu4"/> <i class="right fas fa-angle-left"> </i></p>
            </a>
               <ul class="nav nav-treeview">

               <!-- 모든 프로젝트 내 일감 -->
                  <li class="nav-item">
                  <a href="${pageContext.request.contextPath }/project/tasklist/allProject/myTask" class="nav-link">
                  <p><spring:message code="project.sideMenu4_2"/></p>
                  </a>
                  </li>

               <!-- 모든 프로젝트 모든 일감 -->
                  <li class="nav-item">
                  <a href="${pageContext.request.contextPath }/project/tasklist/allProject/allTask" class="nav-link">
                  <p><spring:message code="project.sideMenu4_1"/></p>
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