<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>GroupWare!</title>
  
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
   <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/dist/css/adminlte.min.css">
   <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
  
 
  
  <!-- Tempusdominus Bbootstrap 4 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/open-iconic-master/font/css/open-iconic-bootstrap.css">
  <!-- JQVMap -->
  <!--link rel="stylesheet" href="${pageContext.request.contextPath }/resources/plugins/jqvmap/jqvmap.min.css"--!>
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/plugins/daterangepicker/daterangepicker.css">
  <!-- summernote -->
  <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/plugins/summernote/summernote-bs4.css">
 
  <link rel="stylesheet" href="${cPath }/resources/css/left.css">
 <!-- jQuery -->
<script src="${cPath}/resources/plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="${cPath}/resources/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${pageContext.request.contextPath }/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- overlayScrollbars -->
<script src="${pageContext.request.contextPath }/resources/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath }/resources/dist/js/adminlte.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${pageContext.request.contextPath }/resources/dist/js/demo.js"></script>
  
  


<!-- 아이콘 사용 -->
<script src="https://unpkg.com/ionicons@5.1.2/dist/ionicons.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/paging.js"></script>

<%-- <link rel="stylesheet" href="${cPath }/resources/css/aTagStyle.css"> --%>
</head>




<body class="hold-transition sidebar-mini layout-fixed">


<div class="wrapper">
	<nav class="main-header navbar navbar-expand navbar-white navbar-light">
	 	<tiles:insertAttribute name="topMenu"></tiles:insertAttribute>
	</nav>

	<aside class="main-sidebar sidebar-dark-primary elevation-4">
	 	<tiles:insertAttribute name="leftMenu"></tiles:insertAttribute>
	</aside>
 <div class="content-wrapper"> 
 	<tiles:insertAttribute name="content"></tiles:insertAttribute>
 </div>
 
  <!-- Control Sidebar -->
 <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
 </aside>
 
  <!-- /.control-sidebar -->
  <div id="sidebar-overlay"></div>
</div>
<!-- ./wrapper -->



<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>


<script type="text/javascript">
	var ws;
	function connect(){	
	 	const protocol = location.protocol == "http:"?"ws:":"wss:";
		const domain = location.hostname;
		const port = location.port!=""?":"+location.port:"";
		const address = protocol+"//"+domain+port+"${cPath}/pushMessage";
		$("#url").val(address);
			ws = new WebSocket(address);
	
			ws.onmessage = function(e){
				let data = JSON.parse(e.data);
				let title = data.title;
				let content = data.content;
				let date = data.data;
				let type = data.type == 'draft'?'far fa-copy':'fas fa-envelope fa-lg';

				 $(document).Toasts('create', {
				        body: content,
				        title: title,
				        subtitle: date,
				        autohide: true,
				        delay: 5000,
				        icon: type,
				        position:"topRight"
				      });
				      
		    
			let node = $("#topsideMenu").find("."+data.type);
				
			let parentNode = node.find("span");
			let childrenNode = node.find(".dropdown-menu");
				 console.log(parentNode);
				 console.log(childrenNode);
				 
				   	 $.ajax({
					  url : "${cPath}/pushmesage/"+data.type
					 , method : "get"
					 , dataType : "json"
					 , success : function(desp){
						 console.log(desp);
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
						$(childrenNode).html(tags);
					 }
				   });
			};
	}
	
	$(function(){
		connect();

	})
</script>
  
</body>
</html>

