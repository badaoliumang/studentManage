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
	  
public class AddServlet extends HttpServlet{  
	      
	    //��дdoGet����  
	    protected void doGet(HttpServletRequest request,    
	        HttpServletResponse response) throws ServletException, IOException {    
	        request.setCharacterEncoding("utf-8");         
	        //��jspҳ���ȡҪ��ӵ��¶���ĸ���ֵ  
	        int id = Integer.valueOf(request.getParameter("id").trim());  
	        String username = request.getParameter("username");  
	        String password = request.getParameter("password");  
	        String sex =request.getParameter("sex");  
	        String address = request.getParameter("address");  
	              
	        try {  
	            //�ȼ���libĿ¼�µ�java-connect-mysql.jar������  
	            Class.forName("com.mysql.jdbc.Driver");    	              
	            //ѡ�������࣬���ӵ�ַ���˺����룬����MySQL  
	            String driverClass="com.mysql.jdbc.Driver";
 	            String url="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8";  
	            String sqlusername="root";  
	            String sqlpassword="523627";  
	            Connection conn = DriverManager.getConnection(url, sqlusername,    
	                    sqlpassword);  
	              
	            //��дSQL��䣬���ﲻҪ��statement�ˣ�����preparedstatement����Ϊ  
                //preparedstatement�������ã�Ϊ�βΣ�Ȼ��set�����βε�ʵ��ֵ��statementû�д�  
	            //���ܡ����ִ�и�����䡣  
	            //���⣬����Ҫ�ӵ�˫���ţ����򱨴�java.sql.SQLException: Parameter index out of range (0 < 1 ).  
	            String sql = "insert into student values("+id+",'"+username+"','"+password+"','"+sex+"','"+address+"')";    
	            PreparedStatement ps = conn.prepareStatement(sql);    
	            ps.executeUpdate();  
              
	            //�ر�����  
	            ps.close();    
	            conn.close();    
	              
        } catch (SQLException | ClassNotFoundException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	          
	          
	        //��ת����ʾҳ��  
	        response.sendRedirect("findAllServlet");  
	        /*request.getRequestDispatcher("listStudent.jsp")   
	        .forward(request, response); */  
	    }    
	    
	    protected void doPost(HttpServletRequest request,    
	            HttpServletResponse response) throws ServletException, IOException {    
	        doGet(request, response);    
	    }    
	}  
