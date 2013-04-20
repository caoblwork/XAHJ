<%@ page language="java" pageEncoding="UTF-8" %>
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
        
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          
          <a class="brand" href="${ctx}/index.jsp">陕西环境执法局系统</a>
          
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href="#">首页</a></li>
              <li><a href="#about">关于</a></li>
            </ul>
          </div>
          
           <p class="navbar-text pull-right">
           		当前用户 
              	<a href="#" class="navbar-link">  <sec:authentication property="principal.realName" /></a>
              	<a href="<c:url value='/j_spring_security_logout'/>">退出</a>
           </p>
          <!--/.nav-collapse -->
        </div>
      </div>
    </div>
