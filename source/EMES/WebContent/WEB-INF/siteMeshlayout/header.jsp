<%@ page language="java" pageEncoding="UTF-8"%>

<script type="text/javascript">
	function setContentTab(name, curr, n) {
		for (i = 1; i <= n; i++) {
			var menu = document.getElementById(name + i);
			var cont = document.getElementById("con_" + name + "_" + i);
			menu.className = i == curr ? "current" : "";
			if (i == curr) {
				cont.style.display = "block";
			} else {
				cont.style.display = "none";
			}
		}
	}
</script>

<div class="topbar">
	<div class="subnav">
		您好！<a href="#"><sec:authentication property="principal.organName" />、<sec:authentication property="principal.realName" /></a> <em class="separator">|</em> <a href="#">修改密码</a> <em class="separator">|</em><a href="<c:url value='/j_spring_security_logout'/>">退出</a>
	</div>
</div>

<div id="menu_out">
	<div id="menu_in">
		<div id="menu">
			<ul id="nav">
			
				<li><a href="<c:url value="/system/dataDictionary/list.do"/>" id="one1" onmouseover="setContentTab('one',1,5)" class="current"><span>系统管理</span></a></li>
				
				<li class="menu_line"></li>
				<li><a href="<c:url value="/emes/psBaseInfo/list.do"/>" id="one2" onmouseover="setContentTab('one',2,5)"><span>污染源档案管理</span></a></li>
				<li class="menu_line"></li>
				<li><a href="<c:url value="/emes/psBaseInfo/list.do"/>" id="one3" onmouseover="setContentTab('one',3,5)"><span>环境安全与应急管理</span></a></li>
				<li class="menu_line"></li>
				<li><a href="<c:url value="/emes/psBaseInfo/list.do"/>" id="one4" onmouseover="setContentTab('one',4,5)"><span>移动执法支撑系统</span></a></li>
				<li class="menu_line"></li>
				<li><a href="<c:url value="/emes/psBaseInfo/list.do"/>" id="one5" onmouseover="setContentTab('one',5,5)"><span>数据中心</span></a></li>
				<!-- 
				<li class="menu_line"></li>
				<li><a href="<c:url value="/system/dataDictionary/list.do"/>" id="one6" onmouseover="setContentTab('one',6,6)"><span>系统管理</span></a></li>
				 -->
			</ul>
			<!--nav end-->
			<div id="menu_con">
				<div id="con_one_1" style="display: block">
					<ul>
						<li><a href="<c:url value="/system/dataDictionary/list.do"/>"><span>数据字典</span></a></li>
						<li class="menu_line2"></li>
						
						<li><a href="<c:url value="/system/role/list.do"/>"><span>角色管理</span></a></li>
						<li class="menu_line2"></li>
						
						<li><a href="<c:url value="/system/user/list.do"/>"><span>用户管理</span></a></li>
						<li class="menu_line2"></li>
						
						<li><a href="<c:url value="/workflow/deployManager/list.do"/>"><span>流程管理</span></a></li>
						<li class="menu_line2"></li>
						
						<li><a href="<c:url value="/system/model/list.do"/>"><span>模块管理</span></a></li>
						<li class="menu_line2"></li>
						
						<li><a href="<c:url value="/system/resource/list.do"/>"><span>资源管理</span></a></li>
						<li class="menu_line2"></li>
						
						<li><a href="<c:url value="/system/organization/list.do"/>"><span>组织机构管理</span></a></li>

					</ul>
				</div>
				<div id="con_one_2" style="display: none">
					<ul>
						<li><a href="#"><span>污染源名单</span></a></li>
						<li><a href="#"><span>一厂一档管理</span></a></li>
					</ul>
				</div>
				<div id="con_one_3" style="display: none">
					<ul>
						<li><a href="#"><span>环境风险源管理</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="#"><span>环境应急预案</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="#"><span>环境应急演练</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="#"><span>事故应急处理辅助</span></a></li>
					</ul>
				</div>
				<div id="con_one_4" style="display: none">
					<ul>
						<li><a href="#"><span>执法管理</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="#"><span>行政处罚</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="#"><span>后督察管理</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="#"><span>指挥调度</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="#"><span>稽查考核</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="#"><span>环保手册管理</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="#"><span>环保手册管理</span></a></li>
					</ul>
				</div>
				<div id="con_one_5" style="display: none">
					<ul>
						<li><a href="#"><span>数据同步</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="#"><span>数据整合模块</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="#"><span>数据交换接口规范</span></a></li>
					</ul>
				</div>
				<div id="con_one_6" style="display: none">
					<ul>
						<li><a href="#"><span>角色管理</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="#"><span>档案管理</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="#"><span>流程管理</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="#"><span>权限管理</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="#"><span>日志管理</span></a></li>
					</ul>
				</div>
			</div>
			<!--menu_con end-->
		</div>
		<!--menu end-->
	</div>
</div>
