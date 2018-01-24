package com.servlet;
import java.io.IOException;  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  	 
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

public class LoginServlet extends HttpServlet {  		      
		protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {    
	            //第一步，先把字符集设定成utf-8，否则万一浏览器送来的是中文就会出现乱码  
		        request.setCharacterEncoding("utf-8");  	           
		        //先把浏览器（表单）输入的用户名、密码拿出来。   
		        String un = request.getParameter("username");  
	            String pw = request.getParameter("password");  		          
		        //把用户名设置到request的属性里，这样呆会儿跳转到欢迎或者错误页面时好知道叫什么  
		        request.setAttribute("username", un);  		          
		        //此时开始在数据库中搜寻有没有同时满足用户名、密码的行，有就对，没有就错：  
		        //先加载lib目录下的java-connect-mysql.jar驱动包  
		        try {  
		        	//注册mysql的驱动
		            Class.forName("com.mysql.jdbc.Driver");  		              
		            //选择驱动类，连接地址、账号密码，连接MySQL  
		            String driverClass="com.mysql.jdbc.Driver";  
		            //student为数据库名称
		            String url="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8"; 
		            //用户名
		            String sqlusername="root"; 
		            //密码
		            String sqlpassword="523627";
		            /* Connection : 此接口具有接触数据库的所有方法。
		                              该连接对象表示通信上下文，即，所有与数据库的通信仅通过这个连接对象进行。
		            */
		            /* 打开连接：需要使用 DriverManager.getConnection() 方法创建一个 Connection 对象，
		                              它代表与数据库的物理连接。*/
		            Connection conn = DriverManager.getConnection(url, sqlusername,sqlpassword);        
		             /* 执行查询：需要使用类型声明的对象建立并提交一个 SQL 语句到数据库。
		              * 编写SQL语句，这里不要用statement了，换用preparedstatement，因为  
		               preparedstatement可以设置？为形参，然后set各个形参的实际值，statement没有此功能。最后执行更新语句。  
		                                     此外，？不要加单双引号，否则报错java.sql.SQLException: Parameter index out of range (0 < 1 ).
		             */ 
		            String sql = "select * from student where username = ? and password = ?";    
		            PreparedStatement ps = conn.prepareStatement(sql);  
		            //将？形参传进对应的值
		            ps.setString(1, un);  
		            ps.setString(2, pw); 
		            //提取结果数据
	                ResultSet rs = ps.executeQuery();  
	                //如果数据库中存在则跳转到欢迎界面，否则跳转到错误界面
		            if(rs.next()){ 
		            	//页面转发，区别于重定向,会传值过去。
		                request.getRequestDispatcher("welcome.jsp").forward(request, response);  
		            }else{  
		                request.getRequestDispatcher("error.jsp").forward(request, response);  
		            }  
		              
		        } catch (ClassNotFoundException | SQLException e) {  
		            e.printStackTrace();  
		        }    
		    }    
		    
	    protected void doPost(HttpServletRequest request,    
		            HttpServletResponse response) throws ServletException, IOException {    
		        doGet(request, response);    
		    }    
		}  



