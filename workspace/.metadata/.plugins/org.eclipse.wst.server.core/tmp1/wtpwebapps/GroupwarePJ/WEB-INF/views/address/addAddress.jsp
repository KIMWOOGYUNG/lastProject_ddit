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
  <title>GroupWare | Log in</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">


<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resources/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${pageContext.request.contextPath}/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/resources/dist/js/adminlte.min.js"></script>


  <!-- Font Awesome -->
  <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/plugins//fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- icheck bootstrap -->
  <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
  
</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<b>Group</b>ware
		</div>
		<!-- /.login-logo -->
		<div class="card">
			<div class="card-body login-card-body">
				<button type="button" class="btn btn-block btn-info" data-toggle="modal" data-target="#modal-info" id="facelogin">명함인식</button>
			</div>
			<!-- /.social-auth-links -->
		</div>
		<!-- /.login-card-body -->
	</div>
	<!-- /.login-box -->


<!-- 명함인식모달 -->
 <div class="modal fade" id="modal-info">
        <div class="modal-dialog">
          <div class="modal-content bg-info">
            <div class="modal-header">
              <h4 class="modal-title">명함인식</h4>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
              <p>명함인식중입니다</p>
              <div id="my_camera"></div>
			<input type=button value="입력" id="shotBtn">
			<input type=button value="사진전송" id="sendImg">
            </div>
            <div class="modal-footer justify-content-between">
              <button type="button" class="btn btn-outline-light" data-dismiss="modal">확인</button>
            </div>
          </div>
          <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
  </div>
  <!-- /.modal -->
<%--   action="${cPath }/faceidLogin" --%>
<form id="myAwesomeForm" method="post" >
<input type="hidden" id="filename" name="filename" /> <!-- Filename -->
</form>

</body>

<script type="text/javascript" src="${cPath }/resources/js/webcam.min.js"></script>
<script type="text/javascript">
<c:if test="${not empty message }">
	alert('${message}');
</c:if>

//웹캠세팅
$("#facelogin").on("click",function(){
Webcam.set({
			width: 320,
			height: 240,
			image_format: 'jpeg',
			jpeg_quality: 90
		});
		Webcam.attach( '#my_camera' );
});

//사진찍기
$("#shotBtn").on("click",function(){
	if("입력"==$("#shotBtn").val()){
		take_snapshot();
		$("#shotBtn").val('다시촬영');
	}else{
		Webcam.attach( '#my_camera' );
		$("#shotBtn").val('입력');
	}
});
//변환
function b64toBlob(b64Data, contentType, sliceSize) {
	contentType = contentType || '';
	sliceSize = sliceSize || 512;
	var byteCharacters = atob(b64Data); // window.atob(b64Data)
	var byteArrays = [];
	for (var offset = 0; offset < byteCharacters.length; offset += sliceSize) {
		var slice = byteCharacters.slice(offset, offset + sliceSize);
		var byteNumbers = new Array(slice.length);
		for (var i = 0; i < slice.length; i++) {
			byteNumbers[i] = slice.charCodeAt(i);
		}
		var byteArray = new Uint8Array(byteNumbers);
		byteArrays.push(byteArray);
	}
	var blob = new Blob(byteArrays, {
		type : contentType
	});
	return blob;
}
//웹캠에서 사진으로

function take_snapshot() {
	Webcam.snap( function(data_uri) {
			var form = document.getElementById("myAwesomeForm");
		document.getElementById('my_camera').innerHTML = 
			'<img src="'+data_uri+'"/>';
			var ImageURL = data_uri;
			//Split the base64 string in data and contentType
			var block = ImageURL.split(";");
			//Get the content type of the image
			var contentType = block[0].split(":")[1];// In this case "image/gif"
			//get the real base64 content of the file
			var realData = block[1].split(",")[1];
			//Convert it to a blob to upload
			var blob = b64toBlob(realData, contentType);
			//Create a FormData and append the file with "image" as parameter name
			formDataToUpload = new FormData();
			formDataToUpload.append("image", blob);
	} );
}

//서버로 값 넘기기 
$("#sendImg").on("click",function(){
	$.ajax({
		type : "POST",
		url : "${cPath }/getImage",
		data : formDataToUpload,
		 processData: false,
		    contentType: false,
		success : function(resp) {
			//${message}
			alert(resp);
			location.href = "${cPath}/index";
		}
	})
// var request = new XMLHttpRequest(formDataToUpload);
// request.open("POST", "${cPath }/getImage");
// request.send(formDataToUpload);
});

</script>
</html>