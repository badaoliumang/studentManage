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
<title>帮助</title>
<head>
	<style>
	* {
		margin: 0;
		padding: 0;
	}
	body{
		background-image:url('images/snow_bk.jpg');
		background-size:cover;
		background-repeat: no-repeat;
		background-color:#222;
		position: relative;
		width:100%;
	}
	#code{
		width:40%;
		min-width:450px;
		height:450px;
		background-color:rgba(0, 0, 0, 0.3);
		position:fixed;
		left:30%;
		top:20%;
		border-radius: 10px;
		font-size:16px;
		line-height:22px;
		font-weitht:bold;
		text-align:center;
		padding:50px;
		
	}
   .comment a{
		color:#ffffff;
		font-weight: 800;
	}
	</style>
</head>
<body>
	
	 <div id="code">
	
    
		<span class="comment"><a href="">广告位招商联系</a></span>
		<br>
		<br>		
        <span class="comment"><a href="">留言板</a></span>
		<br>
		<br>		
        <span class="comment"><a href="listStudent.jsp">返回主页面</a></span>
	
	 </div>
	<script src="js/ThreeCanvas.js"></script>
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<script src="js/Snow.js"></script>
	<script src="js/snowFall.js"></script>
	<script>
		$.snowFall({
			//创建粒子数量，密度
			particleNo: 500,
			//粒子下拉速度
			particleSpeed:30,
			//粒子在垂直（Y轴）方向运动范围
			particleY_Range:1300,
			//粒子在垂直（X轴）方向运动范围
			particleX_Range:1000,
			//是否绑定鼠标事件
		    bindMouse: false,
		    //相机离Z轴原点距离
		    zIndex:600,
		  //摄像机视野角度
		    angle:55,
		    wind_weight:0
			});
	</script>
	<canvas>
	</canvas>

</body>
</html>