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
	/** 
	 * 写DeleteServlet时遇到极大的困难，代码都对，前台jsp里<a href="deleteServlet?id=<%=s.getId()%>">删除</a> 
	 * 对，后台接收id的值，然后删除也对，但是就是进不来servlet，前台提示找不到404。后来关了服务器、清理、重启、前台改了若干数据、删除，问题好了。 
	 * 可能是服务器没有重启的原因，也有可能是前台的缓存造成的找不到，仅仅刷新是不够的，缓存没有变，必须跳转页面，才有新缓存。 
	 * @author Administrator 
	 * 
	 */  public class DeleteServlet extends HttpServlet{  	      
	    //重写doGet方法  
	    protected void doGet(HttpServletRequest request,    
	        HttpServletResponse response) throws ServletException, IOException {    	          
	        //从jsp页面获取要修改的元素的id和各项修改后的值  
	        int id = Integer.valueOf(request.getParameter("id"));  	          
	        try {  
	            //先加载lib目录下的java-connect-mysql.jar驱动包  
	            Class.forName("com.mysql.jdbc.Driver");                  
	            //选择驱动类，连接地址、账号密码，连接MySQL  
	            String driverClass="com.mysql.jdbc.Driver";  
	            String url="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8";  
	            String sqlusername="root";  
                String sqlpassword="523627";  
	            Connection conn = DriverManager.getConnection(url, sqlusername,    
	                    sqlpassword);  	              
	            //编写SQL语句，这里不要用statement了，换用preparedstatement，因为  
	            //preparedstatement可以设置？为形参，然后set各个形参的实际值，statement没有此  
	            //功能。最后执行更新语句。  
	            //此外，？不要加单双引号，否则报错java.sql.SQLException: Parameter index out of range (0 < 1 ).  
            String sql = "delete from student where id = ?";    
	            PreparedStatement ps = conn.prepareStatement(sql);    
	            ps.setInt(1, id);  
            ps.executeUpdate();  	              
	            //关闭连接  
	            ps.close();    
	            conn.close();                  
	        } catch (SQLException | ClassNotFoundException e) {  
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
