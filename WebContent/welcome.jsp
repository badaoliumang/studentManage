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
<title>Insert title here</title>
</head>
<body>
<style>
	body {  
	     background-image:url('images/greenbg.png');  
	    background-size: cover;  
	}  
	h1{  
	    margin:150px auto;  
       text-align: center;  
	}  
	span{  
	    color:red;  
	    font-family:fantasy;  
	}  	</style>  

	</head>  
	<body>  
	    <h1>登录成功，欢迎<span><%=request.getAttribute("username") %></span>来到学生管理系统！</h1>  
	    <center><p>5秒钟后系统会自动跳转到查看全部学生信息页面...</p></center>  
	      
	    <%response.setHeader("refresh","5;url=findAllServlet"); %>  

</body>
</html>