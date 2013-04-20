<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<c:url value="/staticResource/scripts/PageList.js"/>" type="text/javascript"></script>
<title>项目说明列表</title>
<script type="text/javascript">
    var pageList = new $.PageList();
    var parameter = {
        // 全选checkbox的id
        selectAllId: 'chkAll',
        // 列表中行选择的checkbox的名称
        rowCheckboxName: 'rowCheckBox',
        // 模块URL
        moduleUrl: '${ctx}/taskmgr/introduction',
        //单个删除还是批量删除都走这个URL
        deletePageUrl:'${ctx}/taskmgr/introduction/remove.do'
    };
    pageList.init(parameter);
    // 单行删除
    function deleteBtn(id){
        var form = $("#controlForm");
        var confirm = function (v, h, f) {
            if (v == 'ok') {
                form.attr("action", '${ctx}/taskmgr/introduction/delete.do?id='+id).submit();
                return true;
            }else if (v == 'cancel') {
                return true;
            }
            return true;
        };
        $.jBox.confirm("确定要删除吗？", "提示", confirm, {top:'35%'});
    }
</script>
</head>
<body>

	<form id="controlForm" action="" method="post">
	    <input type="hidden" id="selectedItemIds" name="ids" />
	</form>
	
    <form:form id="searchForm" modelAttribute="introductionSearchCondition" class="well form-inline" action="${ctx}/taskmgr/introduction/list.do?projectId=${param.projectId}" method="post">
        <form:hidden id="pageNumber" path="pageNumber" />
        <form:hidden id="pageSize" path="pageSize" />
        <span>
            <label for="projectProgress">项目进展：</label>
            <form:input path="projectProgress" id="projectProgress" class="span3" maxlength="48" placeholder="项目进展"/>
        </span>
        <span>
            <label for="emphasis">工作重点：</label>
            <form:input path="emphasis"  id="emphasis"  class="span3" maxlength="48" placeholder="工作重点"/>
        </span>
        <span>
            <input type="submit" class="btn" value="查询" />
        </span>
    </form:form>

       
    <div class="well well-small">
        <input type="button" class="btn" value="删除" onclick="pageList.gotoDeletePage();" />
    </div>          
            <table width="100%" class="table table-striped table-bordered table-condensed">
        <thead>
            <tr>
                <th class="checkType">
                    <input type="checkbox" name="checkbox" id="chkAll" value="off" onclick="pageList.selectAll()" />
                </th>
                <th class="serialnoType">序       列</th>
                <th>工作重点</th>
                <th>进展情况</th>              
                <th>操       作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${pageObject.result}" var="record" varStatus="c">
                <tr>
                    <td class="alignCenter">
                        <input type="checkbox" name="rowCheckBox" id="chk${c.count}" value="${record.id}" />
                    </td>
                    <td class="alignCenter" align="center">${c.count}</td>
                    
                    
                     <td class="alignCenter">
                    	<c:choose>
                    		<c:when test="${fn:length(record.emphasis)>12}">
                    			${fn:substring(record.emphasis,0,12)}……
                    		</c:when>
                    		<c:otherwise>
                    			${record.emphasis}
                    		</c:otherwise>
                    	</c:choose>
                    </td>
                     <td class="alignCenter">
                    	<c:choose>
                    		<c:when test="${fn:length(record.projectProgress)>12}">
                    			${fn:substring(record.projectProgress,0,12)}……
                    		</c:when>
                    		<c:otherwise>
                    			${record.projectProgress}
                    		</c:otherwise>
                    	</c:choose>
                    </td>               
                    <td class="alignCenter" align="center">
	                    <a href="edit.do?id=${record.id}" title="编辑"><i class="icon-pencil"></i></a>                    	                   
	                    <a href="remove.do?id=${record.id}" title="删除"><i class="icon-minus-sign"></i></a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>       
    </table>
        <div class="form-actions">
			<a class="btn" href="${ctx}/taskmgr/project/list.do" >返回到项目列表</a>
		</div>
    <hangu:PagingNavigation />		          
</body>
</html>