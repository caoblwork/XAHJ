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
		您好！<a href="#">张三</a> <em class="separator">|</em> <a href="#">修改密码</a> <em class="separator">|</em><a href="login.html">退出</a>
	</div>
</div>

<div id="menu_out">
	<div id="menu_in">
		<div id="menu">
			<ul id="nav">
				<li><a href="http://www.jsfoot.com/" id="one1" onmouseover="setContentTab('one',1,6)" class="current"><span>首 页</span></a></li>
				<li class="menu_line"></li>
				<li><a href="http://www.jsfoot.com/jquery/" id="one2" onmouseover="setContentTab('one',2,6)"><span>污染源档案管理</span></a></li>
				<li class="menu_line"></li>
				<li><a href="http://www.jsfoot.com/js/" id="one3" onmouseover="setContentTab('one',3,6)"><span>环境安全与应急管理</span></a></li>
				<li class="menu_line"></li>
				<li><a href="http://www.jsfoot.com/flash/" id="one4" onmouseover="setContentTab('one',4,6)"><span>移动执法支撑系统</span></a></li>
				<li class="menu_line"></li>
				<li><a href="http://www.jsfoot.com/css3/" id="one5" onmouseover="setContentTab('one',5,6)"><span>数据中心</span></a></li>
				<li class="menu_line"></li>
				<li><a href="http://www.jsfoot.com/html5/" id="one6" onmouseover="setContentTab('one',6,6)"><span>系统管理</span></a></li>
			</ul>
			<!--nav end-->
			<div id="menu_con">
				<div id="con_one_1" style="display: block">
					<ul>
						<li></li>
					</ul>
				</div>
				<div id="con_one_2" style="display: none">
					<ul>
						<li><a href="http://www.jsfoot.com/jquery/images/"><span>污染源名单</span></a></li>
						<li><a href="http://www.jsfoot.com/jquery/images/"><span>一厂一档管理</span></a></li>
					</ul>
				</div>
				<div id="con_one_3" style="display: none">
					<ul>
						<li><a href="http://www.jsfoot.com/js/images/"><span>环境风险源管理</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="http://www.jsfoot.com/js/menu/"><span>环境应急预案</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="http://www.jsfoot.com/js/xxk/"><span>环境应急演练</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="http://www.jsfoot.com/js/letter/"><span>事故应急处理辅助</span></a></li>
					</ul>
				</div>
				<div id="con_one_4" style="display: none">
					<ul>
						<li><a href="http://www.jsfoot.com/flash/images/"><span>执法管理</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="http://www.jsfoot.com/flash/menu/"><span>行政处罚</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="http://www.jsfoot.com/flash/letter/"><span>后督察管理</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="http://www.jsfoot.com/flash/letter/"><span>指挥调度</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="http://www.jsfoot.com/flash/letter/"><span>稽查考核</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="http://www.jsfoot.com/flash/letter/"><span>环保手册管理</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="http://www.jsfoot.com/flash/letter/"><span>环保手册管理</span></a></li>
					</ul>
				</div>
				<div id="con_one_5" style="display: none">
					<ul>
						<li><a href="http://www.jsfoot.com/css3/layout/"><span>数据同步</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="http://www.jsfoot.com/css3/menu/"><span>数据整合模块</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="http://www.jsfoot.com/css3/css3/"><span>数据交换接口规范</span></a></li>
					</ul>
				</div>
				<div id="con_one_6" style="display: none">
					<ul>
						<li><a href="http://www.jsfoot.com/html5/tx/"><span>角色管理</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="http://www.jsfoot.com/html5/tb/"><span>档案管理</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="http://www.jsfoot.com/html5/tb/"><span>流程管理</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="http://www.jsfoot.com/html5/tb/"><span>权限管理</span></a></li>
						<li class="menu_line2"></li>
						<li><a href="http://www.jsfoot.com/html5/tb/"><span>日志管理</span></a></li>
					</ul>
				</div>
			</div>
			<!--menu_con end-->
		</div>
		<!--menu end-->
	</div>
</div>
