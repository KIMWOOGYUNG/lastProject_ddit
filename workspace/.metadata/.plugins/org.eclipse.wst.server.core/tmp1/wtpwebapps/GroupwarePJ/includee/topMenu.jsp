<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    

 <!-- Navbar -->
  
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
<!--       <li class="nav-item d-none d-sm-inline-block"> -->
<%--       	<img src="${cPath }/resources/images/email.png" style="height: 1.3rem; width: 1.3rem; display: inline-block; margin-left: 7px; " > --%>
<%--         <a href="${cPath }/mail/list" class="nav-link" style="display: inline-block; padding-left: 0.2rem;"><spring:message code="menu1"/></a> --%>
<!--       </li> -->
      <li class="nav-item d-none d-sm-inline-block">
      	<img src="${cPath }/resources/images/notebook.png" style="height: 1.3rem; width: 1.3rem; display: inline-block; margin-left: 7px;" >
        <a href="${cPath }/address/addressList/all" class="nav-link" style="display: inline-block; padding-left: 0.2rem;"><spring:message code="menu2"/></a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
      	<img src="${cPath }/resources/images/stamp.png" style="height: 1.3rem; width: 1.3rem; display: inline-block; margin-left: 7px;" >
        <a href="${cPath }/approval/entiremanage" class="nav-link" style="display: inline-block; padding-left: 0.2rem;"><spring:message code="menu3"/></a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
      	<img src="${cPath }/resources/images/survey.png" style="height: 1.3rem; width: 1.3rem; display: inline-block; margin-left: 7px;" >
        <a href="${cPath }/work/mywork/daydiary" class="nav-link" style="display: inline-block; padding-left: 0.2rem;"><spring:message code="menu5"/></a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
      	<img src="${cPath }/resources/images/concept.png" style="height: 1.3rem; width: 1.3rem; display: inline-block; margin-left: 7px;" >
        <a href="${cPath }/project/projectlist/my" class="nav-link" style="display: inline-block; padding-left: 0.2rem;"><spring:message code="menu6"/></a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
      	<img src="${cPath }/resources/images/calendar.png" style="height: 1.3rem; width: 1.3rem; display: inline-block; margin-left: 7px;" >
        <a href="${cPath }/plan/complancalendar" class="nav-link" style="display: inline-block; padding-left: 0.2rem;"><spring:message code="menu7"/></a>
      </li>
     
      <li class="nav-item d-none d-sm-inline-block">
      	<img src="${cPath }/resources/images/speaker.png" style="height: 1.3rem; width: 1.3rem; display: inline-block; margin-left: 7px;" >
        <a href="${cPath }/board/boardList/BOD100" class="nav-link" style="display: inline-block; padding-left: 0.2rem;"><spring:message code="menu9"/></a>
      </li>
       <li class="nav-item d-none d-sm-inline-block">
      	<img src="${cPath }/resources/images/man.png" style="height: 1.3rem; width: 1.3rem; display: inline-block; margin-left: 7px;" >
        <a href="${cPath }/mypage/${authUser.emp_code }" class="nav-link" style="display: inline-block; padding-left: 0.2rem;"><spring:message code="menu10"/></a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
      	<img src="${cPath }/resources/images/paper.png" style="height: 1.3rem; width: 1.3rem; display: inline-block; margin-left: 7px;" >
        <a href="${cPath }/note/entirenote" class="nav-link" style="display: inline-block; padding-left: 0.2rem;"><spring:message code="menu11"/></a>
      </li>
      <c:if test="${authUser.team_code == 'TE001'}">
	      <li class="nav-item d-none d-sm-inline-block">
	      	<img src="${cPath }/resources/images/team-management.png" style="height: 1.3rem; width: 1.3rem; display: inline-block; margin-left: 7px;" >
	        <a href="${cPath }/hr/employer/entiremanage" class="nav-link" style="display: inline-block; padding-left: 0.2rem;"><spring:message code="menu4"/></a>
	      </li>
      </c:if>
    </ul>
	<ul class="navbar-nav ml-auto" id="topsideMenu">
	  <li class="logout nav-item d-none d-sm-inline-block">
	  	<div class="user-panel" style="display: inline-block; border-radius: 30px;">
	  	<img src="${cPath }/approval/download/emp/${authUser.emp_attcode}" class="img-circle elevation-2" alt="User Image" style="height: 2.4rem;"> 
	  	<a href="${cPath }/mypage/${authUser.emp_code}" class="nav-link" style="display: inline-block;">${authUser.emp_kor }님</a>
	  	</div>
	  </li>
	  <li class="logout nav-item d-none d-sm-inline-block">
      	<img src="${cPath }/resources/images/logout.png" style="height: 1.3rem; width: 1.3rem; display: inline-block;" >
        <a href="${cPath }/logout" class="nav-link" style="display: inline-block; padding-left: 0.2rem;">로그아웃</a>
      </li>
     <li class="nav-item dropdown message">
        <a class="nav-link" data-toggle="dropdown" href="#">
          <i class="far fa-comments"></i>
          <span class="badge badge-danger navbar-badge">${pushMessageCount }</span>
        </a>
        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
         <c:choose>
	    <c:when test="${pushMessagetList.size() gt 0 }">
         <c:forEach items="${pushMessagetList }" var="pushMessage">
          <a href="${cPath }/pushmesage/${pushMessage.push_code}" class="dropdown-item">
            <!-- Message Start -->
            <div class="media">
              <div class="media-body">
                <h3 class="dropdown-item-title">
                 ${pushMessage.title }
                 
                </h3>
                <p class="text-sm">${pushMessage.content }</p>
                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i>${pushMessage.push_date }</p>
              </div>
            </div>
            <!-- Message End -->
          </a>
          </c:forEach>
         	</c:when>
	       	  	<c:otherwise>
	       	  		<a class="dropdown-item" href="#">
	       	  		<div class="media">
	       	  		<div class="media-body">
	       	  		<p class="text-sm">알람이 없습니다.</p>
	       	  		</div>
	       	  		</div>
	       	  		</a>
	       	  	</c:otherwise>
	       	  </c:choose>
        </div>
      </li>
      <li class="nav-item dropdown draft">
       <a class="nav-link" data-toggle="dropdown" href="#">
          <i class="far fa-copy"></i>
          <span class="badge badge-danger navbar-badge">${pushDraftCount }</span>
        </a>
         <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
	       	  <c:choose>
	       	  	<c:when test="${pushDraftList.size() gt 0 }">
	       	  		<c:forEach items="${pushDraftList }" var="pushDraft">
		           <a href="${cPath }/pushmesage/${pushDraft.push_code}" class="dropdown-item">
		            <!-- Message Start -->
		            <div class="media">
		              <div class="media-body">
		                <h3 class="dropdown-item-title">
		                 ${pushDraft.title }
		                </h3>
		                <p class="text-sm">${pushDraft.content }</p>
		                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i>${pushDraft.push_date }</p>
		              </div>
		            </div>
		            <!-- Message End -->
		          	</a>
	          		</c:forEach>
	       	  	</c:when>
	       	  	<c:otherwise>
	       	  		<a class="dropdown-item" href="#">
	       	  		<div class="media">
	       	  		<div class="media-body">
	       	  		<p class="text-sm">알람이 없습니다.</p>
	       	  		</div>
	       	  		</div>
	       	  		</a>
	       	  	</c:otherwise>
	       	  </c:choose>
          </div>
      </li>
    </ul>
  <!-- /.navbar -->
  <script type="text/javascript">
   $(".dropdown-menu").on("click","a",function(e){
	   e.preventDefault();
	   
	   let node = $(this).parent();
	   let parentNode = node.parent().find("a.nav-link").find("span");
	 
	   	$.ajax({
		  url : $(this).attr("href")
		 , method : "delete"
		 , dataType : "json"
		 , success : function(desp){
			let tags = []
			$(parentNode).text(desp.length);
			if(desp != null && desp.length > 0){
				$.each(desp,function(idx,push){
					  let tag = $("<a>").addClass("dropdown-item").attr({"href":"${cPath}/pushmesage/"+push.push_code}).append(
							   $("<div>").addClass("media").append($("<div>").addClass("media-body").append(
							   	$("<h3>").addClass("dropdown-item-title").text(push.title)
								,$("<p>").addClass("text-sm").text(push.content)
								,$("<p>").addClass("text-sm text-muted").text(push.push_date).prepend($("<i>").addClass("far fa-clock mr-1")))))
					 tags.push(tag);
				})
			}else{
				let tag = $("<a>").addClass("dropdown-item").attr({"href":"#"}).append(
						   $("<div>").addClass("media").append($("<div>").addClass("media-body").append(
						   	$("<h3>").addClass("dropdown-item-title").text()
							,$("<p>").addClass("text-sm").text("알람이 없습니다.")
							)));
				 tags.push(tag);
			}
			$(node).html(tags);
			
		 }
	   });
	   
	   return false;
   })
  </script>
