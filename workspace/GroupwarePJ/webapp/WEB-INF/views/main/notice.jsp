<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<style type="text/css">
	input,label:hover {
		cursor:pointer;
		text-decoration:underline;
	}
	</style>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
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
 
  
  
  
<!-- jQuery -->
<script src="${cPath}/resources/plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="${cPath}/resources/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${pageContext.request.contextPath }/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- 아이콘 사용 -->
<script src="https://unpkg.com/ionicons@5.1.2/dist/ionicons.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/paging.js"></script>
</head>
<body class="hold-transition layout-fixed">
<div class="card m-0">
<div class="card-body" >
<img alt="" src="/GroupwarePJ/approval/download/att/AA998">
</div>

<div class="card-footer">
<label for="check" class="float-right my-auto"> 하루 동안 다시보지 않기 </label>
<input type="checkbox" class="float-right  mt-2 mr-1" id="check">
</div>
</div>

<!-- overlayScrollbars -->
<script src="${pageContext.request.contextPath }/resources/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath }/resources/dist/js/adminlte.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${pageContext.request.contextPath }/resources/dist/js/demo.js"></script>
<script type="text/javascript">
$("#check").on("click",function(event){
	let date = new Date();
	date.setTime(date.getTime() + 1*24*60*60*1000);
	console.log(opener);
	setCookie('popUP',date.getTime(),1);
	
	self.close();
})
	function setCookie(name, value, exp) {
			var date = new Date();
			date.setTime(date.getTime() + exp*24*60*60*1000);
			document.cookie = name + '=' + value + ';expires=' + date.toUTCString() + ';path=/';
	};

</script>
</body>
</html>