<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    



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
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
                <li class="nav-item">
				<a href="#" class="nav-link">
				<!-- 메일 -->
				<p>- <spring:message code="menu1"/> -</p>
				</a>
				</li>     
               
               
               
          <li class="nav-item has-treeview menu-open">
            
            <ul class="nav nav-treeview">
              <li class="nav-item"> 
                <a href="${cPath }/mail/entiremailbox" class="nav-link">
                  <p><spring:message code="mail.sideMenu1"/></p>
                </a>
              </li><!-- 전체메일함 -->
              
              <li class="nav-item"> <!--받은메일  -->
                <a href= "${cPath }/mail/receivemailbox"class="nav-link">
                
                  <p><spring:message code="mail.sideMenu2"/></p>
                </a>
              </li>
              
              <li class="nav-item"><!-- 보낸메일 -->
                <a href="${cPath }/mail/sendmailbox"class="nav-link">
                
                  <p><spring:message code="mail.sideMenu3"/></p>
                </a>
              </li>
               <li class="nav-item"> <!--  임시보관함 -->
                <a href="${cPath }/mail/temporarymailbox"" class="nav-link">
                
                  <p><spring:message code="mail.sideMenu4"/></p>
                </a>
              </li>
              <li class="nav-item"><!-- 내게쓴메일함 -->
                <a href="${cPath }/mail/selfmailbox" class="nav-link">
                 
                  <p>내게 쓴 메일함</p>
                </a>
              </li>
              <li class="nav-item"> <!-- 휴지통 -->
                <a href="${cPath }/mail/mailtrashbasket" class="nav-link">
                
                  <p><spring:message code="mail.sideMenu5"/></p>
                </a>
              </li>
              
			<li class="nav-item has-treeview">
<!--               <li class="nav-item"> 환경설정 -->
                <a href="${cPath }/mail/environmentsetting" class="nav-link">
                  <p><spring:message code="mail.sideMenu6"/>
                   <i class="right fas fa-angle-left"></i>
                  </p>
                </a>
                
                 <ul class="nav nav-treeview">
<!--               </li> -->
<!--               <ul class="nav nav-treeview"> -->
<!--                 </li> -->
                <li class="nav-item">
                <a href="${cPath}/mail/environmentsetting/configurationmail" class="nav-link">
                	<p>명함</p>
                	</a>
                	</li>
                	<li class="nav-item">
                <a href="${cPath}/mail/environmentsetting/template" class="nav-link">
                	<p>템플릿</p>
                	</a>
                	</li>
                	</ul>
            
     
             
             
             
              
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
		li.addClass("menu-open");
		aTag = li.children("a");
		mouseClick(aTag);
	}
}
</script>