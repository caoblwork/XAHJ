<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<c:url value="/staticResource/scripts/PageList.js"/>" type="text/javascript"></script>
<title>数据字典列表</title>
<script type="text/javascript">
    var pageList = new $.PageList();
    var parameter = {
        // 全选checkbox的id
        selectAllId: 'chkAll',
        // 列表中行选择的checkbox的名称
        rowCheckboxName: 'rowCheckBox',
        // 模块URL
        moduleUrl: '${ctx}/system/dataDictionary',
        //单个删除还是批量删除都走这个URL
        deletePageUrl:'${ctx}/system/dataDictionary/remove.do'
    };
    pageList.init(parameter);
    // 单行删除
    function deleteBtn(id){
        var form = $("#controlForm");
        var confirm = function (v, h, f) {
            if (v == 'ok') {
                form.attr("action", '${ctx}/system/dataDictionary/delete.do?id='+id).submit();
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
    
    <form:form class="well form-inline" id="searchForm" modelAttribute="dataDictionarySearchCondition" action="${ctx}/system/dataDictionary/list.do" method="post">
        <form:hidden id="pageNumber" path="pageNumber" />
        <form:hidden id="pageSize" path="pageSize" />
        <span>
            <label for="type">类型：</label>
            <form:input path="type" id="type" class="span3" maxlength="100" placeholder="类型"/>
        </span>
        <span>
            <label for="key">键：</label>
            <form:input path="key"  id="key"  class="span3" maxlength="100" placeholder="键"/>
        </span>
        <span>
            <input type="submit" class="btn" value="查询"/>
        </span>
    </form:form>
       
    <div class="well well-small">
        <input type="button" class="btn" value="新增" onclick="pageList.gotoAddPage();" />
        <input type="button" class="btn" value="删除" onclick="pageList.gotoDeletePage();" />
    </div>
    
	<table width="100%" class="table table-striped table-bordered table-condensed">
        <thead>
            <tr>
                <th class="checkType">
                    <input type="checkbox" name="checkbox" id="chkAll" value="off" onclick="pageList.selectAll()" />
                </th>
                <th class="serialnoType">序列</th>
                <th>类型</th>
                <th>键</th>
                <th>值</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${pageObject.result}" var="record" varStatus="c">
                <tr>
                    <td class="alignCenter">
                        <input type="checkbox" name="rowCheckBox" id="chk${c.count}" value="${record.id}" />
                    </td>
                    <td class="alignCenter">${c.count}</td>
                    <td class="alignCenter">${record.type}</td>
                    <td class="alignCenter">${record.key}</td>
                    <td class="alignCenter">${record.value}</td>
                    <td class="alignCenter">
                        <div class="toolIcoArea">
                            <a href="show.do?id=${record.id}" title="查看"><i class="icon-info-sign"></i></a>
                            <a href="edit.do?id=${record.id}" title="编辑"><i class="icon-pencil"></i></a>
                            <a href="remove.do?id=${record.id}" title="删除"><i class="icon-minus-sign"></i></a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <hangu:PagingNavigation />
</body>
</html>