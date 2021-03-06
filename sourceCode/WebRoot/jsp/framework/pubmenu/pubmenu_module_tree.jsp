<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>模块树视图</title>
<!-- 追加ztree的js资源-->
<script type="text/javascript"
	src="<%=basePath%>js/ztree/js/jquery-1.7.2.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/ztree/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/ztree/js/jquery.ztree.excheck-3.5.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/ztree/css/zTreeStyle/zTreeStyle.css">
<!--artDialog-->
<script type="text/javascript"
	src="<%=basePath%>artDialog/artDialog.source.js?skin=twitter"></script>
<script type="text/javascript"
	src="<%=basePath%>artDialog/plugins/iframeTools.source.js"></script>
</head>
<body>
	<form action="<%=path%>/module/setResources.action" name="selResourceRoleForm"
		id="selResourceRoleForm" method="post"  target="rightFrame">
		<!-- 树容器   UL-->
		<ul id="treeDemo" class="ztree"></ul>
	</form>
	<script type="text/javascript">
		var treeObj;
		//-----------配置信息------------
		var setting = {
			view: {
				dblClickExpand: false,
				showLine: false
			},	
			check : {
				enable : true,
				chkboxType : {
					"Y" : "ps",
					"N" : "sp"
				},
				chkStyle:"radio"
			},
			data : {
				simpleData : {
					idKey : "id",
					pIdKey : "pid",
					rootPId : "角色",
					enable : true
				}
			},
			callback : {//事件方法绑定   onClick点击事件   OnCheck选中事件
					onCheck : zTreeOnCheck,
					onClick : zTreeOnlick
			}
		};
		//-----------json数据------------
		var zNodes = <s:property value="jsonData" escape="false"/>;
		//-----------初始化树并且同时展开所有节点------------
		$(document).ready(function() {
			setting.check.radioType = "all";  
			treeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
			treeObj.expandAll(true);
		});
	function zTreeOnCheck(event, treeId, treeNode) {
			var nodes = treeObj.getCheckedNodes(true);
			var id = nodes[0].id;
			var kong=" ";	
			var name = nodes[0].name;
			var url=nodes[0].treevalue;
			if(nodes.length > 0){
				art.dialog.data('checkedIds',id);
				art.dialog.data('checkedNames',name);
				art.dialog.data('checkedUrl',url);
			}else{
				art.dialog.data('checkedIds',kong);
				art.dialog.data('checkedNames',kong);
				art.dialog.data('checkedUrl',kong);
			}
		};
				//单击事件
		function zTreeOnlick(event, treeId, treeNode) {
            var zTree = $.fn.zTree.getZTreeObj("treeDemo");
            zTree.checkNode(treeNode, !treeNode.checked, null, true);
		};
	</script>
	
</body>
</html>