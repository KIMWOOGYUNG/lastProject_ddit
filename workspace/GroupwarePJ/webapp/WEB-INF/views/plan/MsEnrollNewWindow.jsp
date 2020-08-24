<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<script src="${cPath }/resources/ckeditor/ckeditor.js"></script>   
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




<body class="hold-transition sidebar-mini layout-fixed">




<form:form id="myscheduleForm" modelAttribute="myschedule" method="post" enctype="multipart/form-data" class="w-100"
			action="${pageContext.request.contextPath }/plan/MyScheduleEnroll">


<h1>내 일정 등록</h1>
<div class="content">

            <!-- Horizontal Form -->
            <div class="card card-info">
              <div class="card-header">
                <h3 class="card-title">내 일정 등록</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form class="form-horizontal">
                <div class="card-body">
                
                  <div class="form-group row">
                    <label for="inputEmail3" class="col-sm-2 col-form-label">제목</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="ms_title" value="${myschedule.ms_title}" name="ms_title" style="width: 400px;">
                    </div>
                  </div>
                  <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">작성자</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="emp_code" value="${authUser.emp_kor}" name="emp_code" readonly="readonly" style="width: 200px; background-color: white;">
                    </div>
                  </div>
               
                <!-- Date range -->
                     <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">시작일</label>
                    <div class="col-sm-10">
                      <input type="date" class="form-control" id="ms_startdate" style="height: 35px; width: 200px;" value="${myschedule.ms_startdate}" name="ms_startdate">
                    </div>
                  </div>
                  
                    <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">종료일</label>
                    <div class="col-sm-10">
                      <input type="date" class="form-control" id="ms_enddate" style="height: 35px; width: 200px;" value="${myschedule.ms_enddate}" name="ms_enddate">
                    </div>
                  </div>
                  
                  
                  
                  
                    <div class="form-group row">
					<label for="inputStatus" class="col-sm-2 col-form-label">중요도</label>
					<div class="col-sm-10">
						<select class="form-control" style="width: 200px;"
							name="ms_important">
							<option selected disabled>중요도</option>
							<c:if test="${empty myimportantnm }">
							</c:if>
							<c:if test="${not empty myimportantnm }">

								<c:forEach items="${myimportantnm }" var="map">
									<c:set var="selected"
										value="${(map.standard_code eq myschedule.ms_important) or (map.standard_name eq myschedule.ms_important)? 'selected' : ''}" />
									<option value="${map.standard_code }" ${selected }>${map.standard_name }</option>
								</c:forEach>
							</c:if>
						</select>
					</div>
				</div>
                  
                  
             
              
                  <div class="form-group">
				<label for="inputDescription">내용</label>
				
				<textarea class="form-control" name="ms_content" id="ms_content">
					${myschedule.ms_content}
				</textarea>
			</div>
                 
                </div>
                <!-- /.card-body -->
                <div class="card-footer" align="center">
                  <button type="submit" class="btn btn-info">확인</button>
                  	<a class="btn btn-default" onclick="window.close()">  
					취소
					</a>
                </div>
                <!-- /.card-footer -->
              </form>
            </div>
            <!-- /.card -->

          </div>
          
          
          
          
          
          </form:form>
          
      <script>
      document.getElementById("ms_startdate").value = opener.startdate;
  	  document.getElementById("ms_enddate").value = opener.enddate;
  	  document.getElementById("ms_title").value = opener.title;
//   	  document.getElementById("emp_code").value = opener.emp_kor;
  	  document.getElementById("ms_content").value = opener.content;
  	  if(opener.emp_kor !=""){
  		document.getElementById("emp_code").value = opener.emp_kor;	   //작성자
		
		}else{
			document.getElementById("emp_code").value = "${authUser.emp_kor}";
		}
  	  
  	  
	let ms_important = opener.important;
	
	$("select[name=ms_important]").val(ms_important);
      </script>    
          
          
          
                       <script>
	$()
	CKEDITOR.replace('ms_content',{
		 // Adding drag and drop image upload.
	      uploadUrl: '${pageContext.request.contextPath}/board/image?command=QuickUpload&type=Files&responseType=json',
	
	     // Configure your file manager integration. This example uses CKFinder 3 for PHP.
	      filebrowserImageUploadUrl: '${pageContext.request.contextPath}/board/image?command=QuickUpload&type=Images',
	      on: {
	          change: function() {
	              this.updateElement();    
	          }
	    }			  
	});
		</script> 
		
		
		<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
  
  $("#myscheduleForm").on("submit",function(event){
			
			event.preventDefault();

			let dataList = $(this).serializeArray();
			let obj = {};
			
			$.each(dataList,function(idx,item){
				obj[this.name] = this.value;
			});
			console.log(JSON.stringify(obj));
			
			$.ajax({
				url : "${cPath}/plan/MyScheduleEnroll"
				,method : "post"
				,processData : false
				,contentType : "application/json"
				,data : JSON.stringify(obj)
				,success :function(resp){
					if(resp == 'ok'){
						alert("성공적으로 저장하셨습니다.")
// 						location.href = "${cPath}/plan/myplancalendar/{type}";
						window.opener.location.reload();
						self.close();
					}
					else alert("오류가 발생하셨습니다.");
					
				}
			})
			
		});
  
</script>



<!-- overlayScrollbars -->
<script src="${pageContext.request.contextPath }/resources/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath }/resources/dist/js/adminlte.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${pageContext.request.contextPath }/resources/dist/js/demo.js"></script>

</body>	
				
		
		
		