<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>  
<%@page import="com.bean.Student" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String basePath="http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";	
%>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<script src="../../assets/js/ie-emulation-modes-warning.js"></script>
<title>学生信息管理系统</title>
    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <link href="css/dashboard.css" rel="stylesheet">

</head>
<script type='text/javascript'>

function showstudentlist(){
	var content=document.getElementById("studentlist");
	var showorhide=document.getElementById("showorhide");	
		content.style.visibility="visible";		
}
function hidestudentlist(){
	var content=document.getElementById("studentlist");
	var showorhide=document.getElementById("showorhide");	
		 content.style.visibility="hidden";//隐藏
	
	
}
</script>  
<body >

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href=""><span class="glyphicon glyphicon-home" aria-hidden="true">学生管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href=""><span class="glyphicon glyphicon-search" aria-hidden="true"></a></li>
            <li><a href="">帮助</a></li>
            <li><a href="login.jsp">退出<span class="glyphicon glyphicon-off" aria-hidden="true"></a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="输入学号">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="add.jsp">添加学生 <span class="glyphicon glyphicon-plus" aria-hidden="true"></a></li>
            <li><a href="#">按学号降序  <span class="glyphicon glyphicon-download" aria-hidden="true"></a></li>
            <li><a href="#">按学号升序 <span class="glyphicon glyphicon-upload" aria-hidden="true"></a></li>
            <li><a href="javascript:hidestudentlist();" id="showorhide">隐藏学生&nbsp;<span class="glyphicon glyphicon-eye-close" aria-hidden="true"></a></li>
            <li><a href="javascript:showstudentlist();" id="showorhide">查看学生&nbsp;<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">公告</h1>
		  <!-- 巨幕展示 -->
	      <div class="jumbotron">
		  <h1>Hello, world!</h1>
		  <p>这是一个巨幕展示</p>
		  <p><a class="btn btn-primary btn-lg" href="" role="button">Learn more</a></p>
	      </div>
		  <!-- 学生列表展示 -->
          <h2 class="sub-header"><span class="glyphicon glyphicon-user" aria-hidden="true">学生列表</h2>
          <div class="table-responsive" id="studentlist">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>学号</th>
                  <th>姓名</th>
                  <th>密码</th>
                  <th>性别</th>
                  <th>地址</th>
                  <th colspan="3">操作</th>
                </tr>
              </thead>
              <tbody>
             <%  	           
	           List<Student> ss = (List<Student>)request.getAttribute("list"); 
	        if(ss!=null){
	            for(Student s : ss){  
	        %>  
	        <tr>  
	            <td><%=s.getId() %></td>  
	            <td><%=s.getUsername() %></td>  
	            <td><%=s.getPassword() %></td>  
	            <td><%=s.getSex() %></td>  
	            <td><%=s.getAddress() %></td>  
	            <td colspan="3">  
	                <!-- 编辑图标加功能 -->
	                <a href="update.jsp?id=<%=s.getId()%>&username=<%=s.getUsername()%>&password=<%=s.getPassword()%>&sex=<%=s.getSex()%>&address=<%=s.getAddress()%>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></a>  
	                <!-- 删除图标加功能 -->  &nbsp;
	                <a href="deleteServlet?id=<%=s.getId()%>" onclick="return confirm('确定删除？')"> <span class="glyphicon glyphicon-trash" aria-hidden="true"></a>  
	            </td>  
	        </tr>
             <%   
	            }  
	        }
	        %> 
	        <tr>
              <td align="center" colspan="5" bgcolor="white">
              <%=request.getAttribute("bar")%>
             
              </td>
             </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
	  
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="../../assets/js/vendor/holder.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>