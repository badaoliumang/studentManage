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
<title>学生管理系统</title>
	<style type="text/css">  
	body {  
	    background-image:url('images/loginBg.jpg');  
	    background-size: cover;  /* 图片平铺拉伸，适应屏幕 */  
	}  
	h1{  /* 标题居中  */  
	    margin:100px auto;  
	    text-align: center;  
	}  
	form{  /* 表单居中  */  
	    width:300px;  
	    height:220px;  
	    margin: 100px auto;  
	}  
	.item{    /* item与itemV的设定纯粹是为了让出入框左对齐，名字右对齐    */  
	    width:80px;  
	    display:inline-block;  
	    text-align: right;  
	}  
	.itemV{  
	    width:180px; 
	    display:inline-block;  
	    text-align: right;  
	}  
	#btn{    /* 按钮居中  */  
	    margin-left: 80px;  
	}  
	</style>  

</head>
<body>
  <h1>欢迎登录学生管理系统！</h1>  
	      
	    <form action="loginServlet" method="post">  
	    <span class="item">用户名:</span>   
	    <input type="text" name="username" /></span><br><br>  
	    <span class="item">密码:</span>   
	    <input type="text" name="password" /></span><br><br><br>  
	    <div id="btn">   
	    <input type="submit" value="登录" />   
	    <input type="reset" value="重置" />  
	    </div>  
	    </form>     

</body>
</html>