	package com.servlet;  
	  
	import java.io.IOException; 
 
	import java.sql.Connection;  
	import java.sql.DriverManager;  
	import java.sql.PreparedStatement;  
	import java.sql.ResultSet;  
	import java.sql.SQLException;  
	import java.sql.Statement;  
	import java.util.ArrayList;  
	import java.util.List;  
	  
	import javax.servlet.ServletException;  
	import javax.servlet.http.HttpServlet;  
	import javax.servlet.http.HttpServletRequest;  
	import javax.servlet.http.HttpServletResponse;  
	  
	import com.bean.Student;
import com.bean.StudentDao;  
	  
	public class UpdateServlet extends HttpServlet{  
	      
	    //重写doGet方法  
	    protected void doGet(HttpServletRequest request,    
	        HttpServletResponse response) throws ServletException, IOException {    
	          
	        request.setCharacterEncoding("utf-8");  
	          
	        //从jsp页面获取要修改的元素的id和各项修改后的值  
	        int id = Integer.valueOf(request.getParameter("id"));  
	        String username = request.getParameter("username");  
	        String password = request.getParameter("password");  
	        String sex = request.getParameter("sex");  
	        String address = request.getParameter("address");  
	          
	        try {  
	          /*  //先加载lib目录下的java-connect-mysql.jar驱动包  
	            Class.forName("com.mysql.jdbc.Driver");    
	              
	            //选择驱动类，连接地址、账号密码，连接MySQL  
	            String driverClass="com.mysql.jdbc.Driver";  
	            String url="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8&useSSL=false&verifyServerCertificate=false";  
	            String sqlusername="root";  
	            String sqlpassword="523627";  
	            Connection conn = DriverManager.getConnection(url, sqlusername,    
	                    sqlpassword);  */
	        	StudentDao studentDao=new StudentDao();
	            Connection conn = studentDao.getConnection(); 
	            //编写SQL语句，这里不要用statement了，换用preparedstatement，因为  
	            //preparedstatement可以设置？为形参，然后set各个形参的实际值，statement没有此  
	            //功能。最后执行更新语句。  
	            //此外，？不要加单双引号，否则报错java.sql.SQLException: Parameter index out of range (0 < 1 ).  
	            String sql = "update student set username = ?, password = ?, sex = ?, address = ? where id = ?";    
	            PreparedStatement ps = conn.prepareStatement(sql);    
	            ps.setString(1, username);  
	            ps.setString(2, password);  
	            ps.setString(3, sex);  
	            ps.setString(4, address);  
	            ps.setInt(5, id);  
	            ps.executeUpdate();  
	              
	            //关闭连接  
	            ps.close();    
	            conn.close();    
              
	        } catch (SQLException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	          
	          
        //跳转到显示页面  
	        response.sendRedirect("findAllServlet");  
	        /*request.getRequestDispatcher("listStudent.jsp")   
	        .forward(request, response); */  
	    }    
	    
	    protected void doPost(HttpServletRequest request,    
	            HttpServletResponse response) throws ServletException, IOException {    
	        doGet(request, response);    
	    }    
	}  
