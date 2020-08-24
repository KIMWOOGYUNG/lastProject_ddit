<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<script src="${cPath }/resources/ckeditor/ckeditor.js"></script>   




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
<!--                   <button type="submit" class="btn btn-default">취소</button> -->
                  	<a class="btn btn-default" href="${cPath}/plan/myplanbox/myplan">  
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
	$()
	CKEDITOR.replace('ms_content',{
		 // Adding drag and drop image upload.
	      uploadUrl: '${pageContext.request.contextPath}/board/image?command=QuickUpload&type=Files&responseType=json',
	
	     // Configure your file manager integration. This example uses CKFinder 3 for PHP.
	      filebrowserImageUploadUrl: '${pageContext.request.contextPath}/board/image?command=QuickUpload&type=Images',
	});
		</script> 
