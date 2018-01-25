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
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>添加学生</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
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
	    width:410px;  
	    margin: 100px auto;  
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
    var pwdc = document.getElementById('passwordConfirm').value;
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
    if(!(pwd == pwdc)){
    	alert('两次密码不一致!');
        return false;
    }
  
}


</script>

<body>

  <h1>欢迎来到新增学生页面</h1>  
	    <form   action="addServlet" method="post" class="form-horizontal" onsubmit='return validation();' >  
	         <!-- 学号 -->
	         <div class="form-group">
               <label for="id" class="col-sm-4 control-label">学号:</label>
                  <div class="col-sm-8">
                    <input type="text" class="form-control" class="form-control" id="id" name="id" placeholder="学号（九位数字）" maxlength=9>
                  </div>
             </div>
             <!-- 姓名 -->
             <div class="form-group">
               <label for="username" class="col-sm-4 control-label">姓名:</label>
                   <div class="col-sm-8">
                     <input type="text" class="form-control" id="username" name="username" placeholder="姓名">
                   </div>
             </div>
	         <!-- 密码 -->
	         <div class="form-group" >
               <label for="password" class="col-sm-4 control-label">密码:</label>
               <div class="col-sm-8">
                  <input type="password" class="form-control" id="password" name="password" >
               </div>
             </div>
             <!-- 确认密码 -->
             <div class="form-group">
               <label for="passwordConfirm" class="col-sm-4 control-label">确认密码:</label>
                 <div class="col-sm-8">
                    <input type="password" class="form-control" id="passwordConfirm" name="passwordConfirm" >
                 </div>
             </div>
	         <!-- 性别-->
             <div class="form-group">
               <label for="username" class="col-sm-4 control-label">性别:</label>
                 <div class="col-sm-8">
                   <input type="radio" name="sex" value="男" checked="checked" >男&nbsp;
                   <input type="radio" name="sex" value="女" >女
                 </div>
             </div>   
	          <!-- 地址 -->
         <!--  <div class="form-group">
               <label for="address">地址：</label>
               <input type="text" class="form-control" id="address" name="address" placeholder="地址">
             </div> -->
             
              <div class="form-group">
		         <label  class="col-sm-4 control-label">地址:</label>
		      </div>
              <!-- 三级联动测试 -->
             <div data-toggle="distpicker" >           
		        <div class="form-group">
		        
		          <!-- 省 -->		
		          <div class="col-sm-4">
		            <select class="form-control" id="province1"></select>
		          </div>
		          
		           <!-- 市 -->		           
		            <div class="col-sm-4">
		            <select class="form-control" id="city1"></select>
		            </div>
		            
		           <!-- 县 -->		         
		             <div class="col-sm-4">
		              <select class="form-control" id="district1"></select>
		             </div><!-- 县 -->	          
		        </div><!-- form-group-->
             </div><!-- distpicker-->
             
              <!-- 底部按钮 -->
             <div class="form-group">
               <center>
              <button type="submit" class="btn btn-success">添加</button>&nbsp;
              <button type="reset" class="btn btn-primary">重置</button>
               </center>
             </div>	     
	    </form>  
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<!-- 三级联动引入库 -->
<script src="js/distpicker.data.js"></script>
<script src="js/distpicker.js"></script>
<script src="js/main.js"></script>

</body>
</html>