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
<title>登录成功，欢迎您！</title>
</head>
<body>
<style>
	body{  
	    background-image:url('images/welcomeBg.jpg');  
	    background-size: cover;  
	}  
	h1{  
	    margin:150px auto;  
        text-align: center;  
	}  
	span{  
	    color:red;  
	    font-family:fantasy;  
	} 
</style>  
</head>  
<body onload="run()">  
	 <h1>登录成功，欢迎<span><%=request.getAttribute("username") %></span>来到学生管理系统！</h1>  
	 <center><p><span id="spanId">5</span>秒钟后系统会自动跳转到查看全部学生信息页面...</p></center>  
	      
	 <%response.setHeader("refresh","5;url=findAllServlet"); %>  

</body>
<br><script type="text/javascript">
    // 页面一加载完成，该方法就会执行
    // 读秒，一秒钟数字改变一次
    var x = 5;
    function run(){
        // 获取到的是span标签的对象
        var span = document.getElementById("spanId");
        // 获取span标签中间的文本
        span.innerHTML = x;
        x--;
        // 再让run方法执行呢，一秒钟执行一次
        window.setTimeout("run()", 1000);
    }
     
</script><br>
</html>