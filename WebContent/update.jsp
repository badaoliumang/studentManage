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
<title>编辑学生信息</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
	<style type="text/css">  
	body {  
	    background-image:url('images/updatebg.jpg');  
	    background-size: cover;  
	} 
	h1{
	text-align:center;
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
	    <h1>欢迎来到修改学生信息页面</h1><br>  <br> 
	    <form action="updateServlet" method="post" class="form-horizontal col-md-offset-4 " >  
	        <!-- 学号显示 -->
	        <div class="form-group">
		    <label for="input1" class="col-sm-2 control-label">学号：</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control" id="input1" name="id" value="<%=id %>" readonly="readonly" >
		    </div>
		    </div>
	        <!-- 姓名显示 -->
	        <div class="form-group">
		    <label for="input2" class="col-sm-2 control-label">姓名：</label>
		    <div class="col-sm-4">
		      <input type="text" name="username" value="<%=username %>" class="form-control" id="input2" >
		    </div> 
		     </div>
		    <!-- 密码显示 -->
	        <div class="form-group">
		    <label for="input3" class="col-sm-2 control-label">密码：</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control" id="input3" name="password" value="<%=password %> ">
		    </div>  
		     </div>
		    <!-- 性别显示 -->
	        <div class="form-group">
		    <label for="input4" class="col-sm-2 control-label">学号：</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control" id="input4" name="sex" value="<%=sex %>">
		    </div> 
		     </div>
		    <!-- 地址显示 -->
	        <div class="form-group">
		    <label for="input5" class="col-sm-2 control-label">学号：</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control" id="input5" name="address" value="<%=address %> ">
		    </div>        
            </div>
			<div class="form-group">
			 <div class="col-sm-offset-2 col-sm-10">
			    <button type="submit" class="btn btn-default">提交</button>
			  </div>
			</div>
            </div>
	    </form>  
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>