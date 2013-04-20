<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/components/jquery-easyui-1.3.2/jquery-easyui.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改日志</title>
</head>

<body>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#dp2").datepicker();
			$('#form').validation();
		});
		
	</script>
	<form:form  id="form" modelAttribute="voModel" method="post" action="save.do"
		class="well form-horizontal">

		<form:hidden path="id" />

		<div class="control-group">
			<label class="control-label" for="taskName">任务名称:</label>
			<div class="controls">
				<form:input path="taskName" readonly="true"/>
				<form:hidden path="taskId" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="name">日志名称:</label>
			<div class="controls">
				<form:input path="name" check-type="chinese" required-message="日志名称应为中文名!"/>
				<form:errors path="name" />
			</div>
		</div>
		<div class="control-group">
            	<label class="control-label" for="taskStatus">任务状态:</label>
            	<div class="controls">
                 <form:input path="taskStatus"  id="taskStatus" check-type="number" number-message="任务状态必须为0~100之间的整数!" cssClass="textbox" maxlength="100" placeholder="任务状态"/>
             	 <form:errors path="taskStatus"/>
             	</div>
             </div>    
		<div class="control-group">
			<label class="control-label" for="createPerson">修改人员:</label>
			<div class="controls">
				<form:input path="createPerson" />
				<form:errors path="createPerson" />
			</div>
		</div>				
		<div class="control-group">
			<span>
				<div class="control-group">
					<div class="control-label">修改日期:</div>
					<div class="controls">
						<div class="input-append date" id="dp2"
							data-date-format="yyyy-mm-dd">
							<form:input path="createTime"  type="text"
								readonly='true' />
							<span class="add-on"><i class="icon-calendar"> </i></span>
						</div>
					</div>
				</div>
			</span>
				<form:errors path="createTime" />
		</div>				
		<div class="control-group">
			<label class="control-label" for="content">日志内容：</label>
			<div class="controls">
				<form:textarea path="content"  size="15"  style="width:320px;height:130px" />
				<form:errors path="content" />	
			</div>
		</div>
		<div class="form-actions">
			<input type="submit" id="saveBtn" name="saveBtn" value="保存"
				class="btn btn-primary"> <a class="btn"
				href="${ctx}/taskmgr/journal/list.do">返回</a>
		</div>
	</form:form>
</body>
</html>