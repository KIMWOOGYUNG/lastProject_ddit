<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
	#content {padding: 50px;}
	.card-body{width: 100%; padding: 20px 40px 20px 40px}
</style>

<script src="${cPath}/resources/dynatree-master/dist/jquery.dynatree.min.js"></script>

<div id="content">
	<div class="card card-primary">
		<div class="card-header">
			<h3 class="card-title">${title }</h3>
		</div>
		
		<div class="card-body">
			<div class="form-group">
				<label for="inputStatus">기안서 카테고리</label>

				<link href="${cPath}/resources/dynatree-master/dist/skin-vista/ui.dynatree.css" rel="stylesheet" type="text/css" id="skinSheet">
				 <div id="tree1"></div>
				
				   	<button id="btn1" class="my-2 font-weight-bolder btn btn-default">+</button><button class="mx-2 my-2 font-weight-bolder btn btn-default" id="btn2">-</button>
				    <div id="tree2"></div>
				<!--     <button id="addBtn">설정</button><button>취소</button> -->
      		</div>
		</div>
	</div>
</div>
      
<script>

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

  
$("#tree2").dynatree({
	  children: [{"title":"결재그룹","key":"group","isFolder":"true","children":[]}]
})

var groupList = [];

function checkGroup(topNode){
	if(topNode.data.isFolder){
		var list = topNode.childList;
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
	
}


$("#btn1").on("click",function(){
	var node = $("#tree1").dynatree("getActiveNode");
	var node2 = $("#tree2").dynatree("getTree").selectKey("group");
	moveData(node,node2);
});

$("#btn2").on("click",function(){
	var node = $("#tree2").dynatree("getActiveNode");
	var isFolder = node.data.isFolder;
	if(isFolder){
		return;
	}
	node.remove();
});
  
function moveData(baseNode , addPlaceNode) {
	checkGroup(baseNode);
	var node = $("#tree2").dynatree("getTree").selectKey("group");
	var size= $("#addrModal").attr("data-size");
	var childSize = node.countChildren();
	var dataSize = groupList.length;
	var pos = $("#addrModal").attr("data-type");
	if((dataSize+childSize)<=size){
		$.each(groupList,function(idx,temp){
			let checkNode = $("#tree2").dynatree("getTree").getNodeByKey(temp.key);
		   	if(checkNode != null){
		   		return;
		   	}
		   	addPlaceNode.addChild({title: temp.title, key: temp.key});
	   	})
	     addPlaceNode.expand(true);
	}else{
		alert("추가할 수 있는 사원수를 초과하였습니다.");
	}
	
	groupList = [];
  };

  
  
  
  
</script>