<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" media="screen" href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加日志</title>
</head>
<body>	
<script type="text/javascript">
		$(document).ready(function() {
			$("#dp2").datepicker();
			$('#form').validation();
		});
	</script>
	<form:form id="form" modelAttribute="voModel" method="post" class="well form-horizontal" action="save.do">
		<form:hidden path="version" value="0"/>		
		     <form:hidden path="id"/>    
             <div class="control-group">
            	<label class="control-label" for="taskName">任务名称:</label>
            	<div class="controls">
                 <form:input path="taskName"   id="taskName" readonly="true" cssClass="textbox" maxlength="40" placeholder="创建人员"/>
             	  <form:hidden path="taskId" value="${parm.id }"/>	
             	</div>
             </div>
	          <div class="control-group">
            	<label class="control-label" for="name">日志名称:</label>
            	<div class="controls">
                 <form:input path="name"  id="name"  check-type="chinese"  required-message="日志名称应为中文名!" cssClass="textbox" maxlength="24" placeholder="日志名称"/>
             	  <form:errors path="name"/> 
             	</div>
             </div>               
             <div class="control-group">
            	<label class="control-label" for="taskStatus">任务状态:</label>
            	<div class="controls">
                 <form:input path="taskStatus"  id="taskStatus" check-type="number" number-message="任务状态必须为0~100之间的整数!" cssClass="textbox"  placeholder="任务状态"/>
             	 <form:errors path="taskStatus"/>
             	</div>
             </div>                          			
			<div class="control-group">
            	<label class="control-label" for="createPerson">创建人员:</label>
            	<div class="controls">
                 <form:input path="createPerson"  id="createPerson" cssClass="textbox" maxlength="24" placeholder="创建人员"/>
             	  <form:errors path="createPerson"/> 
             	</div>
             </div>            
             <div class="control-group">
			<span>
				<div class="control-group">
					<div class="control-label">创建日期:</div>
					<div class="controls">
						<div class="input-append date" id="dp2" data-date-format="yyyy-mm-dd">
							<form:input path="createTime"  type="text"
								readonly='true' />
							<span class="add-on"><i class="icon-calendar"> </i></span>
						</div>
					</div>
				</div>
				 <form:errors path="createTime"/> 
			</span>
		</div>                                 
            <div class="control-group">
				<label class="control-label" for="content">日志内容:</label>
	            <div class="controls">
	            <form:textarea path="content" style="width:320px;height:130px" id="createDate"  cssClass="textbox" maxlength="150" placeholder="日志内容"/>
            	 <form:errors path="content"/> 
            	</div>
            </div>
            <div class="form-actions">
				<input type="submit" id="saveBtn" name="saveBtn" value="保存" class="btn btn-primary">
				<a class="btn" href="${ctx}/taskmgr/journal/list.do" >返回</a>
			</div>
	</form:form>
</body>
</html>