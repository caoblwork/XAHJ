<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<%@ include file="/components/zTree/zTree.jsp"%>
	<SCRIPT type="text/javascript">
		<!--
		var setting = {
			view: {
				showLine: false
			},
			async: {
				enable: true,
				url:'<c:url value="/global/organUsersData.do?user=${param.user}"/>',
				autoParam:["id"]
			},
			callback: {
				beforeClick: beforeClick,
				onClick: multSelect,
				onDblClick: select
			}
		};

		var zTreeNodeStr = "${organUsers}";
		var zNodes = eval(zTreeNodeStr);

		function beforeClick(treeId, treeNode, clickFlag) {
			//alert("ok");
		}
		function multSelect(event, treeId, treeNode, clickFlag) {
			//获取多选择值
			var zTree = $.fn.zTree.getZTreeObj("organUsersTree"),
			nodes = zTree.getSelectedNodes(),
			v = "",n="";
			nodes.sort(function compare(a,b){return a.id-b.id;});
			for (var i=0, l=nodes.length; i<l; i++) {
				n += nodes[i].name + ",";
				v += nodes[i].id + ",";
			}
			if (n.length > 0 ) n = n.substring(0, n.length-1);
			if (v.length > 0 ) v = v.substring(0, v.length-1);
			//赋值
			//window.parent.window.callbackMultHandlerOrganUser(n,v); //参数节点名称 节点编码 
			
			if(eval('${param.selectParent}')==!treeNode.isParent){
				alert("请选择用户！");
			}else{
				window.parent.window.callbackMultHandlerOrganUser(n,v);
			}
		}
		function select(event, treeId, treeNode, clickFlag) {
			window.parent.window.callbackHandlerOrganUser(treeNode.name,treeNode.id,'${param.index}'); //节点名称 节点编码 使用模版编码
			window.parent.window.jBox.close();
		}		

		function mergerStr(str1, str2) {
			var arr1 = new Array();
			var arr2 = new Array();
			arr1 = str1.split(",");
			arr2 = str2.split(",");
			var flags = {}, temp = arr1.concat(arr2), result = []; 
			for (var i = 0, len = temp.length; i < len; i++) { 
				if (!flags[temp[i]]) { 
					result.push(temp[i]); 
					flags[temp[i]] = true; 
				} 
			} 
			var resStr = result.join(",");
			var index1 = resStr.lastIndexOf(',');
			var leng2 = resStr.length;
			if(index1==(leng2-1)){
				resStr = resStr.substring(0,leng2-1);
			}
			arr1 = null,arr2 = null;
			return resStr; 
		}

		$(document).ready(function(){
			$.fn.zTree.init($("#organUsersTree"), setting, zNodes);
		});
		
		//-->
	</SCRIPT>
</HEAD>

<BODY>
	<ul id="organUsersTree" class="ztree"></ul>
</BODY>
</HTML>