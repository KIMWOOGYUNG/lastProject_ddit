<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script src="${cPath }/resources/ckeditor/ckeditor.js"></script>
<style>
	#content {padding: 50px;}
	.smallForm {
		display: inline;
		float: left;
		margin-right: 40px;   
	}
	.card-body{width: 100%; padding: 20px 40px 20px 40px}
	li{list-style:none;}
	#fileTable{padding:20px;}
</style>

<div id="content">
	<div class="card card-primary">
		<div class="card-header">
			<h3 class="card-title">${title }</h3>
		</div>
		
		
		<div class="card-body" id="apprSettingArea">
			<div class="form-group smallForm">
				<label for="inputStatus">기안서 카테고리</label>
<!-- 				<div> -->
					<select id="formCatagSelect" class="form-control" style="width: 200px;">
						<option value=" " <c:if test="${draftVO.fc_code eq null }">selected</c:if>  disabled>카테고리</option>
						<option value=" ">전체</option>
						<c:if test="${form_catag.size() gt 0}">
							<c:forEach items="${form_catag }" var="catag">
								<option <c:if test="${draftVO.fc_code eq catag.fc_code }">selected</c:if> value="${catag.fc_code }">${catag.fc_name }</option>
							</c:forEach>
						</c:if>
					</select>
<!-- 				</div> -->
			</div>
			
			<div class="form-group ">
					<label for="inputStatus">기안서</label>
<!-- 					<div> -->
						<select id="formSelect" class="form-control" style="width: 200px;">
							<option value=" " <c:if test="${draftVO.form_code eq null }">selected</c:if> disabled>양식</option>
							<c:forEach items="${forminfo }" var="form">
								<c:set var="selected" value="${form.form_code eq draftVO.form_code ? 'selected' : ' ' }"/>
								<option value="${form.form_code }" ${selected } >${form.form_name } </option>
							</c:forEach>
						</select>
<!-- 					</div> -->
			</div>
			
			<div id="apprSection" class="row py-1"<c:if test="${draftVO.fc_code eq null }">hidden="hidden" </c:if>>
				<div class="px-1 col-2" >
					<button class="btn btn-primary btn-sm" data-size="5" data-type="apprLine" data-toggle="modal" data-target="#addrModal" >
						<i class=" fas fa-save"></i> 결제라인등록 
					</button>
				</div>
				<div id="apprLineArea" class="col-10 p-0 border form-control">
					<c:if test="${draftVO ne null }">
						<c:if test="${draftVO.apprList ne null }">
							<c:forEach items="${draftVO.apprList }" var="appr">
							 	<span class="mx-1 badge bg-lightblue" name="${appr.empVO.emp_code }">${appr.empVO.emp_kor }(${appr.empVO.position_name }) </span>
							</c:forEach>
						</c:if>
					</c:if>
				</div>
			</div>
			<div id="rg1Section" class="row py-1" <c:if test="${draftVO.fc_code eq null }">hidden="hidden"</c:if>>
				<div class="px-1 col-2">
					<button class="btn btn-primary btn-sm" data-type="rg1Line" data-size="5" data-toggle="modal" data-target="#addrModal" >
						<i class=" fas fa-save"></i> 참조권자등록 
					</button>
				</div>
				<div id="rg1LineArea" class="col-10 p-0 border form-control">
					<c:if test="${draftVO ne null }">
						<c:if test="${draftVO.rg1List ne null }">
							<c:forEach items="${draftVO.rg1List }" var="rg1">
							 	<span class="mx-1 badge bg-lightblue" name="${rg1.empVO.emp_code }">${rg1.empVO.emp_kor }(${rg1.empVO.position_name }) </span>
							</c:forEach>
						</c:if>
					</c:if>
				</div>
			</div>
		<div id="rg2Section" class="row py-1" <c:if test="${draftVO.fc_code eq null  }">hidden="hidden" </c:if>>
			<div class="px-1 col-2"><button class="btn btn-primary btn-sm" data-type="rg2Line" data-size="5" data-toggle="modal"  data-target="#addrModal">
				<i class=" fas fa-save"></i> 열람권자등록 
				</button></div>
				<div id="rg2LineArea"  class="col-10 p-0 border form-control">
				<c:if test="${draftVO ne null }">
					<c:if test="${draftVO.rg2List ne null }">
						<c:forEach items="${draftVO.rg2List }" var="rg2">
						 	<span class="mx-1 badge bg-lightblue" name="${rg2.empVO.emp_code }">${rg2.empVO.emp_kor }(${rg2.empVO.position_name }) </span>
						</c:forEach>
					</c:if>
				</c:if>
			</div>
		</div>
		<div id="insteadSection" class="row py-1" <c:if test="${draftVO.fc_code ne 'FC300'  }"> hidden="hidden"</c:if>>
			<div class="px-1 col-2"><button class="btn btn-primary btn-sm w-2" data-type="instead" data-size="1" data-toggle="modal" data-target="#addrModal">
				<i class=" fas fa-save"></i> 대결권자등록 
				</button></div>
			<div id="insteadArea" class="col-10 p-0 border form-control">
				<c:if test="${draftVO.insteadEmpVO ne null }">
					<span class="mx-1 badge bg-lightblue" name="${draftVO.insteadEmpVO.emp_code}">${draftVO.insteadEmpVO.emp_kor }(${draftVO.insteadEmpVO.position_name }) </span>
				</c:if>
			</div>
		</div>
						 
		<div  id="vacationArea" class="row" style="margin: 3px 0px 6px 0px;" <c:if test="${draftVO.fc_code ne 'FC300'  }"> hidden="hidden"</c:if>>
			<div class="col-2" style="padding: 0px;">
				<label class="col-6" style="padding: 0px" for="inputName">휴가종류</label> 
				
				</div>
				<select id="vctType" class="col-1 form-control" style="margin-right: 10px; margin-left:-5px;" <c:if test="${draftVO.fc_code ne 'FC300' or vacation.size() lt 0 }"> hidden='hidden'</c:if>>
						<option disabled>휴가종류</option>
						
						<c:if test="${vacation.size() ge 0}">
							<c:forEach items="${vctinfo }" var="info">
					
							<c:set var="selected" value="${info.standard_code eq vacation[0].vc_catag ? 'selected' : ' ' }"/>
								<option value="${info.standard_code }" ${selected }>${info.standard_name }</option>
							</c:forEach>
						</c:if>
					</select>
				<div class="p-0" style="width: 600px">
					
					<c:set  var="startday"  value="${vacation[0].cws_code }"/> 
					<c:set  var="endday"  value="${vacation[fn:length(vacation)-1].cws_code  }"/>
					
					<input type="date" id="startDate" class="form-control float-left" style="width: 200px;" <c:if test="${draftVO.fc_code ne 'FC300' or vacation.size() lt 0 }"> hidden='hidden' </c:if>value="${fn:substring(startday, 0, 4)}-${fn:substring(startday, 4, 6)}-${fn:substring(startday, 6, 8)}">
					<input type="date" id="endDate"  class="form-control float-left" style="width: 200px;" <c:if  test="${draftVO.fc_code ne 'FC300' or fn:length(vacation) le 1}"> hidden='hidden'</c:if> value="<c:if  test="${fn:length(vacation) gt 1}">${fn:substring(endday, 0, 4)}-${fn:substring(endday, 4, 6)}-${fn:substring(endday, 6, 8)}</c:if>">	
				</div>
			
			</div>
		<div class="row form-group">
				<label class="col-2 m-auto" for="inputName">제목</label> 
				<input id="draft_title" class="col-10 form-control" style="width:80%" type="text" value="${draftVO.draft_title }">
		</div>	
		
			
			<div class="mt-2 form-group">
				<label for="inputDescription">내용</label>
			
					<textarea class="form-control" name="bo_content" id="bo_content">
					${draftVO.draft_content }
					</textarea>
			</div>
			
			<input id="file" class="form-cont" type="file" id="fileUpload" name="file" style="color: transparent;"/>
			<br>
			
			<form id="fileForm" action="#" method="post" enctype="multipart/form-data">
			      <div class="card card-primary px-0" id="fileTable" >
			      <div class="card-header">첨부파일 목록</div>
			      	<c:if test="${draftVO ne null }">
			      <table class="table table-bordered">
			      		<c:if test="${draftVO.attatchList[0].org_name ne null}">
			      			<c:forEach var="att" items="${draftVO.attatchList }">
					            	<tr><td><span>${att.org_name }</span><input type="hidden" name="orgfile" value="${att.draft_attcode}"><input type="button" class="mx-2 py-0 btn" value="X"></td></tr>
					         </c:forEach>
			      		</c:if>
			      	</table>
			      	</c:if>
			      </div>
			      <c:if test="${draftVO ne null }">
			      	<input type="hidden" name="draft_code" value="${draftVO.draft_code }">
			      </c:if>
			      
			      <input type="hidden" name="apprLine" value="">
			      <input type="hidden" name="rg1Line" value="">
			      <input type="hidden" name="rg2Line" value="">
			      <input type="hidden" name="insteadEmp" value="">
			      <input type="hidden" name="draft_title" value="" required>
			      <input type="hidden" name="draft_content" value="">
			      <input type="hidden" name="form_code" value="">
			      <input type="hidden" name="startDate">
				  <input type="hidden" name="endDate">
				  <input type="hidden" name="vc_catag" value="">
			</form>
			
			<br>
			
			
		</div>

		<!-- Modal -->
		<div class="modal fade" id="addrModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        
		        <h4 class="modal-title" id="myModalLabel">라인 등록</h4>
		      </div>
		      <div  class="modal-body">
				 <nav class="mt-2">
		       		<ul id="myModalBody" class="nav nav-pills nav-sidebar flex-column treeview" role="menu" data-accordion="false" data-widget="treeview">
		       			<jsp:include page="setAddList.jsp"/>
		       		</ul>	
		     	 </nav>
				</div>
		      <div id="myModalFooter"class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
		        <button type="button" class="btn btn-primary" data-dismiss="modal" id="addBtn">등록</button>
		  <!--  <button type="button" id="addApprLineBtn" class="btn btn-success" data-dismiss="modal">결재라인 추가</button> -->
		      </div>
		    </div>
		  </div>
		</div>
		<div class="card-footer">
			
			<button class="btn btn-primary float-right" id="draftSendBtn" >
				<i class="fas fa-download">
				</i>
				상신
			</button>
			
			<button class="btn btn-primary float-right" id="draftSaveBtn" style="margin-right: 10px;">
				<i class="fas fa-folder">
				</i>
				저장
			</button>
		</div>
	</div>
	
</div>
<script type="text/javascript">
function clickForm(){
	let code = $(this).val();
	if(code =='FO002'){
		$("#vacationArea").attr({"hidden":false});
	}else{
		$("#vacationArea").attr({"hidden":true});
	}
	$.ajax({
		url:"${cPath}/approval/publicformbox/form"
		,data:{
			form_code:code
		}
		,method:"post"
		,dataType:"json"
		,success:function(resp){
			CKEDITOR.instances.bo_content.setData(resp.form_content)
		}
	})
	let value = $("#formCatagSelect").val();
	if(value == 'FC300'){
		$("#insteadSection").attr("hidden",false);
		$("#apprSection").attr("hidden",false);
		$("#rg1Section").attr("hidden",false);
		$("#rg2Section").attr("hidden",false);
	}else{
		$("#insteadSection").attr("hidden",true);
		$("#apprSection").attr("hidden",false);
		$("#rg1Section").attr("hidden",false);
		$("#rg2Section").attr("hidden",false);
	}
	
	let tags = [];
	tags.push($("<option>").attr({"value":" ","selected":"selected","disabled":"disabled"}).text("휴가종류"));
	tags.push($("<option>").attr({"value":"VCC100"}).text("연차"));
	tags.push($("<option>").attr({"value":"VCC400"}).text("공과"));
	tags.push($("<option>").attr({"value":"VCC200"}).text("오후반차"));
	tags.push($("<option>").attr({"value":"VCC300"}).text("오전반차"));
	
	$("#vctType").empty();
	$("#vctType").append(tags);
	$("#startDate").attr({"hidden":true,"disabled":true}).val(0);
	$("#endDate").attr({"hidden":true,"disabled":true}).val(0);
	
	if($(this).val()=='FO002'){
		$("#vctType").attr({"hidden":false,"disabled":false});
	
	}else{
		$("#vctType").attr({"hidden":true,"disabled":true});	
	}
}
$("#formSelect").on("change",clickForm)
$("#formSelect").on("load",clickForm)

$("#vctType").on("click",function(){
	let code = $(this).val();
	if(code=='VCC100'||code=='VCC400'){
		$("#startDate").attr({"hidden":false,"disabled":false})
		$("#endDate").attr({"hidden":false,"disabled":false})
	}else {
		$("#startDate").attr({"hidden":false,"disabled":false})
		$("#endDate").attr({"hidden":true,"disabled":true})
	}
})

function sendCatag(){
	let code = $("#formCatagSelect option:selected").val();
	$.ajax({
		url : "${cPath}/approval/publicformbox/catag"
			,method :"get"
			,dataType:'json'
			,data : {
				fc_code : code
			}
			,success : function(resp){
				let tags = [];
				tags.push($("<option>").val(" ").text("양식").attr({"disabled":true,"selected":true}))
				
				$.each(resp,function(idx,form){
					let code = form.form_code;
					let title = form.form_name;
					let tag = $("<option>").val(code).text(title);
					tags.push(tag);
				})
				console.log(tags);
				$("#formSelect").html(tags);
			}
			,error: function(e){
				console.log(e);
			}
		})
}
	

$("#formCatagSelect").on("change",function(){
	sendCatag();
})


$("#file").on("change",function(e){
	var files = e.target.files;
	var fileArr = Array.prototype.slice.call(files);
	var table = $("#fileTable");		

	let tag = $("<tr>").append($("<td>").append($("<span>").text(fileArr[0].name)
								,$(this).clone().css("display","none")
								,$("<input>").attr("type","button").val("X").addClass("mx-2 py-0 btn")));
	table.append(tag);
});

$("#fileForm").on("click","input[type=button]",function(){
	$(this).parents("tr").remove();
})




// $("#apprSettingArea").find("input").attr("readonly",true);
$("#apprSettingArea").on("click","button",function(){
	let pos = $(this).attr("data-type");
	let size = $(this).attr("data-size");
	$("#addrModal").attr("data-type",pos);
	$("#addrModal").attr("data-size",size);
	addApprInfo(this);
	$.ajax({
		url:"${cPath}/approval/approvalwrite/"+pos
		,dataType:'json'
		,success : function(resp){
			let basetree = $("#tree1").dynatree("getTree");
			let basenode = $("#tree1").dynatree("getRoot");
			if(basetree.selectKey("group") == null ){
				basenode.addChild({title: "즐겨찾기", key: "group",isFolder:true});
			}
			topnode = basetree.selectKey("group");
			topnode.removeChildren();
			$.each(resp,function(idx,group){
				let line_name = group.line_name;
				let line_code = group.line_code;
				topnode.addChild({title: line_name, key: line_code,isFolder:true});
					
				if(group.empList!=null){
					let bottomnode = basetree.selectKey(line_code);
					$.each(group.empList,function(idy,emp){
						let emp_code = emp.emp_code;
						let emp_name = emp.emp_kor;
						let position_name = emp.position_name;
						bottomnode.addChild({title:emp_name+"("+position_name+")", key: emp_code});
					})
				}
			})
		basenode.visit(function (childNode) {
		        childNode.expand(false);
		    });

		}
		,error :function(error){
			console.log(error);
		}
	})
	
	$("#addrModal").modal();
})

$("#addBtn").on("click",function(){
	let node = $("#tree2").dynatree("getTree").getNodeByKey("group");
	let list = node.childList;
	
		spanTags =[]
		let  pos = $("#addrModal").attr("data-type");
		$.each(list,function(idx,temp){
			let trTag = $("<span>").text(temp.data.title).attr("name",temp.data.key).addClass("mx-1 badge bg-lightblue");
			spanTags.push(trTag);
		});	
		$("#"+pos+"Area").html(spanTags)
	
 
});


$("#draftSendBtn").on("click",function(){
	
	var title = $("#draft_title").val();
	if(title == ""){
		alert("제목을 입력해주세요.");
		return;
	}
	
	var apprData = $("#apprLineArea").find("span") //결재라인 정보
	var rg1Data = $("#rg1LineArea").find("span")//참조자
	var rg2Data = $("#rg2LineArea").find("span")//열람권자
 	var insreadData = $("#insteadArea").find("span")//대결권자
 
 	var apprStr = getAttrName(apprData);
	var rg1Str = getAttrName(rg1Data);
	var rg2Str = getAttrName(rg2Data);
	var insteadStr = getAttrName(insreadData);
	
	$("#fileForm").find("input[name=form_code]").val($("#formSelect option:selected").val());
	$("#fileForm").find("input[name=vc_catag]").val($("#vctType option:selected").val());
	$("#fileForm").find("input[name=startDate]").val($("#startDate").val().replace(/-/gi,""));
	$("#fileForm").find("input[name=endDate]").val($("#endDate").val().replace(/-/gi,""));
	

	$("#fileForm").find("input[name=apprLine]").val(apprStr);
	$("#fileForm").find("input[name=rg1Line]").val(rg1Str);
	$("#fileForm").find("input[name=rg2Line]").val(rg2Str);
	$("#fileForm").find("input[name=insteadEmp]").val(insteadStr);
	$("#fileForm").find("input[name=draft_title]").val(title);
	$("#fileForm").find("input[name=draft_content]").val(CKEDITOR.instances.bo_content.getData());
	
	
	$("#fileForm").attr("action","${cPath}/approval/enroll");
	$("#fileForm").submit();

});

$("#draftSaveBtn").on("click",function(){

	var title = $("#draft_title").val();
	if(title == ""){
		alert("제목을 입력해주세요.");
		return;
	}
	var apprData = $("#apprLineArea").find("span") //결재라인 정보
	var rg1Data = $("#rg1LineArea").find("span")//참조자
	var rg2Data = $("#rg2LineArea").find("span")//열람권자
 	var insreadData = $("#insteadArea").find("span")//대결권자
 
 	var apprStr = getAttrName(apprData);
	var rg1Str = getAttrName(rg1Data);
	var rg2Str = getAttrName(rg2Data);
	var insteadStr = getAttrName(insreadData);

	$("#fileForm").find("input[name=form_code]").val($("#formSelect option:selected").val());
	$("#fileForm").find("input[name=vc_catag]").val($("#vctType option:selected").val());
	$("#fileForm").find("input[name=startDate]").val($("#startDate").val().replace(/-/gi,""));
	$("#fileForm").find("input[name=endDate]").val($("#endDate").val().replace(/-/gi,""));
	

	$("#fileForm").find("input[name=apprLine]").val(apprStr);
	$("#fileForm").find("input[name=rg1Line]").val(rg1Str);
	$("#fileForm").find("input[name=rg2Line]").val(rg2Str);
	$("#fileForm").find("input[name=insteadEmp]").val(insteadStr);
	$("#fileForm").find("input[name=draft_title]").val(title);
	$("#fileForm").find("input[name=draft_content]").val(CKEDITOR.instances.bo_content.getData());
	                            
	$("#fileForm").attr("action","${cPath}/approval/temporary");
	$("#fileForm").submit();
});

	function getAttrName(object){
		let dataList = []
		$.each(object,function(idx,data){
	 		temp = {
	 				emp_code : $(data).attr("name")
	 		}
	 		dataList.push(temp);
	 	})
	 	return JSON.stringify(dataList);
	}
	
	

	
function addApprInfo(addLineBtn){
	var pos = $(addLineBtn).attr("data-type");
	var dataList = $("#"+pos+"Area").find("span");
	console.log(dataList.length);
	var node = $("#tree2").dynatree("getTree").selectKey("group");
	node.removeChildren();
	if(dataList.length < 0||dataList == null){
		return;
	}else{
		$.each(dataList,function(idx,data){
			 let temp_key = $(data).attr("name");
			 let temp_title = $(data).text();
			 node.addChild({title:temp_title,key:temp_key});
			
		})
	}	
	
}	

 $("#endDate").on("change",function(){
		var selectedDate1 = $("#startDate").val().replace(/-/gi,"");
		var selectedDate2 = $("#endDate").val().replace(/-/gi,"");
		if(selectedDate1 && selectedDate2){ //둘다 값이 있을 때 
			if(selectedDate1>=selectedDate2){
				$(this).val(0);	
				alert("조회기간을 확인해주세요");
				
			}
		}else if(!selectedDate1 || !selectedDate2){ //둘중에 하나라도 값이 없을 때 
			$(this).val(0);	
			alert("선택하지 않은 날짜데이터가 있습니다.");
		}
 });
 $("#startDate").on("change",function(){
		var selectedDate1 = $("#startDate").val().replace(/-/gi,"");
		var selectedDate2 = $("#endDate").val().replace(/-/gi,"");
		if(selectedDate1 && selectedDate2){ //둘다 값이 있을 때 
			if(selectedDate1>=selectedDate2){
				$(this).val(0);				
				alert("조회기간을 확인해주세요");
			}
		}
});
	
	CKEDITOR.replace('bo_content',{
		 // Adding drag and drop image upload.
	      uploadUrl: '${pageContext.request.contextPath}/board/image?command=QuickUpload&type=Files&responseType=json',

	     // Configure your file manager integration. This example uses CKFinder 3 for PHP.
	    width : '100%',
	    height : '400px',
	      filebrowserUploadUrl:'${pageContext.request.contextPath}/mine/imageUpload.do'
	});
	
// 	CKEDITOR.instances.bo_content.setData("");
	
</script>



