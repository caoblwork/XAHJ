<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="/components/jquery-easyui-1.3.2/jquery-easyui.jsp"%>
</head>
<body>
	<script type="text/javascript">
		//处理多选，如果只涉及单选就请删除此段代码
		function callbackMultHandlerOrganUser(name, id) {

			var namesVal = $("#jbox-iframe")[0].contentWindow.mergerStr(name,
					$('#users').val());
			var idsVal = $("#jbox-iframe")[0].contentWindow.mergerStr(id, $(
					'#userids').val());

			$('#users').val(namesVal);
			$('#userids').val(idsVal);
		}

		//处理单选，如果只涉及多选就请删除此段代码
		function callbackHandlerOrganUser(name, id) {
			$('#users').val(name);
			$('#userids').val(id);
		}

		//“清除功能”
		function cleanOrganUserData(v, h, f) {
			if (v == 0) {
				$('#users').val('');
				$('#userids').val('');
			}
		}

		$(document).ready(function() {
			$("#dp1").datepicker();
		});
	</script>

	<div class="well well-small">
		<form class="form-horizontal">

			<span>
				<div class="control-group">
					<div class="control-label">选择:</div>
					<div class="controls">
						<div class="input-append date" id="tc">
							<input class="span2" readonly='readonly' type="text" id='users'
								placeholder="点击选择" /> <input type="hidden" id="userids">
							<span class="add-on"><i class="icon-th"
								onclick="$.jBox.open('iframe:${ctx}/global/loadOrganUsers.do', '请单击选择用户', 400, 400, {iframeScrolling: 'no', buttons: {'清空': 0, '关闭': true},submit:cleanOrganUserData } )"></i></span>
						</div>
					</div>
				</div>
			</span> 
			<span>
				<div class="control-group">
					<div class="control-label">日期:</div>
					<div class="controls">

						<div class="input-append date" id="dp1"
							data-date-format="yyyy-mm-dd">
							<input readonly='readonly' size="16" type="text" class="span2" />
							<span class="add-on"><i class="icon-calendar"> </i></span>
						</div>

					</div>
				</div>
			</span> 
			<span>
				<div class="control-group">
					<div class="control-label">选择(请选择):</div>
					<div class="controls">
						<hangu:DataDicSelect path="property" type="TestType" class="span2" />
					</div>
				</div>
			</span> 
			<span>
				<div class="control-group">
					<div class="control-label">选择:</div>
					<div class="controls">
						<hangu:DataDicSelect type="TestType" class="span5" required="true" />
					</div>
				</div>
			</span>

			<span>
				<div class="control-group">
					<div class="control-label">选择组织机构:</div>
					<div class="controls">
						<div class="input-append date" id="tc">
							<input class="span5" readonly='readonly' type="text" id='users'
								placeholder="点击选择" /> <input type="hidden" id="userids">
							<span class="add-on"><i class="icon-th"
								onclick="$.jBox.open('iframe:${ctx}/global/loadOrganUsers.do?user=true', '请单击选择用户', 400, 400, {iframeScrolling: 'no', buttons: {'清空': 0, '关闭': true},submit:cleanOrganUserData } )"></i></span>
						</div>
					</div>
				</div>
			</span> 
			
			<span>
				<div class="control-group">
					<div class="control-label">选择联系人:</div>
					<div class="controls">
						<div class="input-append date" id="tc">
							<input class="span5" readonly='readonly' type="text" id='users'
								placeholder="点击选择" /> <input type="hidden" id="userids">
							<span class="add-on"><i class="icon-th"
								onclick="$.jBox.open('iframe:${ctx}/global/loadLinkManGroup.do', '请单击选择用户', 400, 400, {iframeScrolling: 'no', buttons: {'清空': 0, '关闭': true},submit:cleanOrganUserData } )"></i></span>
						</div>
					</div>
				</div>
			</span>

			<span>
				<div class="control-group">
					<div class="control-label">label显示:</div>
					<div class="controls">
						<hangu:DataDicLabel dataType="TestType" dataKey="0" />
						<hangu:DataDicLabel dataType="TestType" dataKey="1" />
					</div>
				</div>
			</span> 
			<span>
				<ul id="tt" class="easyui-tree">
					<li><span><input type="checkbox" id="module001"
							name="module001" />模块名称001</span>
						<ul>
							<li><span><input type="checkbox" id="subModule001"
									name="subModule001" />子模块001</span>
								<ul>
									<li><span><input type="checkbox" id="resource001"
											name="resource001" />资源001</span></li>
									<li><span><input type="checkbox" id="resource002"
											name="resource002" />资源002</span></li>
									<li><span><input type="checkbox" id="resource003"
											name="resource003" />资源003</span></li>
								</ul></li>
							<li><span><input type="checkbox" id="subModule002"
									name="subModule002" />子模块002</span></li>
							<li><span><input type="checkbox" id="subModule003"
									name="subModule003" />子模块003</span></li>
						</ul></li>
					<li><span><input type="checkbox" id="module002"
							name="module002" />模块名称002</span></li>
				</ul>
			</span>

		</form>
	</div>

</body>
<html>