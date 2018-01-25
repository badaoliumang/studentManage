<%@page import="org.apache.catalina.filters.AddDefaultCharsetFilter"%>
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
<title>添加学生</title>
<style type="text/css">  
	body {  
	    background-image:url('images/addBg.jpg');  
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
<script language="javascript">
/*校验是否全由8位数字组成 */
function isStudentNo(str) {
    var reg=/^[0-9]{9}$/;   /*定义验证表达式*/
    return reg.test(str);     /*进行验证*/
}

function validation() {
	var id = document.getElementById('id').value; 
    var no = document.getElementById('username').value;          
    var pwd = document.getElementById('password').value;
    if(id == '') {
        alert('请输入id!');
        return false;
    }
    if(!isStudentNo(id)) {
    	alert('学号必须为9位数字!');
        return false;
    }
    if(no == '') {
        alert('请输入用户名!');
        return false;
    }
    if(pwd == '') {
        alert('请输入密码!');
        return false;
    }
  
}

</script>
<body>

  <h1>欢迎来到新增学生页面</h1>  
	    <form   action="addServlet" method="post" onsubmit='return validation();' >  
	        <span class="item">学号：(9位数字)</span> <span><input type="text" name="id" id="id"/></span><br>
	        <span class="item">username：</span> <span><input type="text" name="username" id="username"/></span><br>  
	        <span class="item">password：</span> <span><input type="text" name="password" id="password" /></span><br>  
	        <span class="item">sex：</span>      <span><input type="text" name="sex" /></span><br>  
	        <span class="item">address：</span>  <span><input type="text" name="address" /></span><br>  
	        <br><br>  
	        <center>  
	            <button class="btn" type="submit">添加</button>
	            <input class="btn" type="reset" value="重置" />  
	        </center>  
	    </form>  

</body>
</html>