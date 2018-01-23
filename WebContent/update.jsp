<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.bean.Student" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String basePath="http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
	
%>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style type="text/css">  
	body {  
	    background-image:url('images/greenbg.png');  
	    background-size: cover;  
	}  
	h1{  
	    margin:50px auto;  
	    text-align: center;  
	}  
	  
	form{  
	    width:310px;  
	    margin: 100px auto;  
	}  
	  
	.item{  
	    color:red;  
	    width:100px;  
	    display:inline-block;   
	    text-align:right;  
	}  
	  
	.btn{  
	    width:50px;  
	}  
	</style>  

</head>
<body>
 <%  
	        String id = request.getParameter("id");  
	        String username = request.getParameter("username");  
	        String password = request.getParameter("password");  
	        String sex = request.getParameter("sex");  
	        String address = request.getParameter("address");  
	    %>  
	      
	    <!-- id是唯一定位元素的标识符，不能修改，但可以显示给人看，此时不要用disabled限制别人访问，因为  
	         它会使id的name连同value都作废，不能提交给servlet；用read-only，它可以提交。  
	     -->  
	    <h1>欢迎来到修改学生信息页面</h1>  
	    <form action="updateServlet" method="post">  
	        <span class="item">ID：</span>       <span><input type="text" name="id" value="<%=id %>" readonly="readonly"/></span><br>  
	        <span class="item">username：</span> <span><input type="text" name="username" value="<%=username %>" /></span><br>  
	        <span class="item">password：</span> <span><input type="text" name="password" value="<%=password %>" /></span><br>  
	        <span class="item">sex：</span>      <span><input type="text" name="sex" value="<%=sex %>" /></span><br>  
	        <span class="item">address：</span>  <span><input type="text" name="address" value="<%=address %>" /></span><br>  
	        <br><br>  
	        <center>  
	            <input class="btn" type="submit" value="提交" />  
	            <input class="btn" type="reset" value="重置" />  
	        </center>  
	    </form>  

</body>
</html>