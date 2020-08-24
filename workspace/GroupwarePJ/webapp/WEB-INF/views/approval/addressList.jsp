<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
	#content {padding: 50px;}
	.card-body{width: 100%; padding: 20px 40px 20px 40px}
	.text, .form-control{display: inline;}
	#groupName{width:60%; margin-left:10px;}
	#tree1{padding: 20px, 0px, 20px, 0px}
/* 	.oi{width:5px; heigth:5px;} */
</style>
<link href="${cPath}/resources/dynatree-master/dist/skin-vista/ui.dynatree.css" rel="stylesheet" type="text/css" id="skinSheet">
<script src="${cPath}/resources/dynatree-master/dist/jquery.dynatree.min.js"></script>

<div id="content">
	<div class="card card-primary">
		<div class="card-header">
			<h3 class="card-title">${title }</h3>
		</div>
		
		<div class="card-body">
			<div class="form-group">
				<label for="inputName" class="text">그룹명</label> 
				<input type="text" id="groupName" class="form-control" value="${dataList.line_name }">
			</div>
			
		 	<div id="tree1"></div>
		   	<button id="btn1" class="btn btn-default"><span class="oi oi-plus"></span></button>
		   	<button id="btn2" class="btn btn-default"><span class="oi oi-minus"></span></button>
		    <div id="tree2"></div>
		</div>
		
		

		<div class="card-footer">
		    <button class="btn btn-default float-right">취소</button>  
		    <button id="addBtn" class="btn btn-primary float-right">설정</button>
    	</div>
    
    
    </div>
</div>
    
    
    
    
<script>
if('${position}'== 'modify'){
	$.ajax({
		url : "${cPath }/approval/setting/${state }/modify/${lineCode}"
		,dataType : "json"
		,success : function(resp){
			let empList = resp.empList;
			let node2 = $("#tree2").dynatree("getTree").selectKey("group");
			node2.setTitle(resp.line_name);
			if(empList!= null){
				$.each(empList,function(idx,emp){
					let key = emp.emp_code;
					let title = emp.emp_kor+"("+emp.position_code+")";
					node2.addChild({title: title, key: key});
				});
				node2.expand(true);
			}
		}
		,error : function(errorResp) {
			console.log(errorResp.status + ":"+ errorResp.responseText);
		}
	});

}
$.ajax({
	url: "${cPath}/address/emp",
	dataType : "json",
	success:function(data){
		console.log(data);
		$("#tree1").dynatree({
			  children: data
		})
	}
  });


$("#groupName").on("change",function(){
	let node =$("#tree2").dynatree("getTree").selectKey("group");
	let str = $(this).val();
	node.setTitle(str);	
});
  
$("#tree2").dynatree({
	  children: [{"title":"그룹","key":"group","isFolder":"true","children":[]}]
})

var groupList = [];

function checkGroup(topNode){
	if(topNode.data.isFolder){
		let list = topNode.childList;
		$.each(list,function(idx,node){
			if(node.data.isFolder){
			 	checkGroup(node);
			}else{
				data = {
					title : node.data.title
					,key : node.data.key
				}
				groupList.push(data);
				
			}
		})
	}else{
		data = {
				title : topNode.data.title
				,key : topNode.data.key
			}
		groupList.push(data);
	}
	console.log(groupList);
}


$("#btn1").on("click",function(){
	let node = $("#tree1").dynatree("getActiveNode");
// 	let isFolder = node.data.isFolder;
	let node2 = $("#tree2").dynatree("getTree").selectKey("group");
	moveData(node,node2);
});

$("#btn2").on("click",function(){
	let node = $("#tree2").dynatree("getActiveNode");
	let isFolder = node.data.isFolder;
	if(isFolder){
		return;
	}
	node.remove();		
});
  
function moveData(baseNode , addPlaceNode) {
	checkGroup(baseNode);
	$.each(groupList,function(idx,temp){
		let checkNode = $("#tree2").dynatree("getTree").getNodeByKey(temp.key);
	   	if(checkNode != null){
	   		return;
	   	}
	   	addPlaceNode.addChild({title: temp.title, key: temp.key});
   	})
     addPlaceNode.expand(true);
	groupList = [];
  };

$("#addBtn").on("click",function(){
	let node = $("#tree2").dynatree("getTree").getNodeByKey("group");
	 let list = node.childList;
	 let dataList = [];
	$.each(list,function(idx,temp){
		data = {
				title : temp.data.title
				,key : temp.data.key
		}
		dataList.push(data);	
	});
	jsonData = JSON.stringify(dataList);
	
	$.ajax({
		url : "${cPath}/approval/setting/${state}/${position}"
		,method:"post"
		,data : {dataList:jsonData,title:$("#groupName").val(),code:"${dataList.line_code}"}
		,success :function(resp){
			if(resp == ""){
				location.href = "${cPath}/approval/setting/${state}"			
			}
		}
		,error : function(error){
			alert(error.responseText)
			
		}
	})

});
  
  
  
</script>