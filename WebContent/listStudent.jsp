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
<title>Insert title here</title>
<style  type="text/css">  
	body {  
	    background-image:url('images/listBg.jpg'); 
	    background-size: cover;  /* 图片平铺拉伸，适应屏幕 */  
	}  
	h1{  
	    margin:50px auto;  
	    text-align: center;  
	}  	  
	table {  
	    width:600px;  
	    margin:50px auto;  
	    border-collapse: collapse;  
	    text-align: center;  
	} 
	 
	#toAdd{ 
	text-align: center;
	}  
	table,th,td{
	border:1px solid black;
	}  
	th{
	height:50px;
	}  	
	</style>   
</head>
<body>
 <h1>欢迎来到查看学生页面</h1>  
	    <table style="border: 1px">  
	        <tr>  
	            <th>ID</th>  
	            <th>username</th>  
	            <th>password</th>  
	            <th>sex</th>  
	            <th>address</th>  
                <th colspan="3">操作</th>  
	        </tr>  
	        <%  
	           
	           List<Student> ss = (List<Student>)request.getAttribute("ss"); 
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
	                <a href="update.jsp?id=<%=s.getId()%>&username=<%=s.getUsername()%>&password=<%=s.getPassword()%>&sex=<%=s.getSex()%>&address=<%=s.getAddress()%>">修改</a>  
	                    
	                <a href="deleteServlet?id=<%=s.getId()%>" onclick="return confirm('确定删除？')">删除</a>  
	            </td>  
	        </tr>  
	        <%   
	            }  
	        }
	        %>  
	    </table>  
	    <div id="toAdd"><a href="add.jsp">增加学生</a></div>  

</body>
</html>