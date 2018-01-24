<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String basePath="http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
	
%>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP-JDBC-Servlet-Demo-学生管理系统</title>
<link rel="stylesheet" href="css/login.css" type="text/css" />
<link type="text/css" rel="stylesheet" href="font/font-awesome.min.css"/>
</head>
<body class="loginpage">
	<div class="loginbox">
    	<div class="loginboxinner">       	
            <div class="logo">
            	<h1 class="logo">JJS.<span>练手项目</span></h1>
				<span class="slogan">学生管理系统</span>
            </div><!--logo-->        
            <br clear="all" />
            <br />                      
            <form id="login" action="loginServlet" method="post">           	
                <div class="username">
                	<div class="usernameinner">
                    	<input type="text" name="username" id="username" placeholder="用户名" />
                    </div>
                </div>              
                <div class="password">
                	<div class="passwordinner">
                    	<input type="password" name="password" id="password" placeholder="密码" />
                    </div>
                </div>               
                <button type="submit">登录</button>                                     
            </form>           
        </div><!--loginboxinner-->
    </div><!--loginbox-->


</body>
</html>