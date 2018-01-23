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
		      
		     protected void doGet(HttpServletRequest request,    
		            HttpServletResponse response) throws ServletException, IOException {    
	        //��һ�����Ȱ��ַ����趨��utf-8��������һ����������������ľͻ��������  
		        request.setCharacterEncoding("utf-8");  
		           
		        //�Ȱ������������û����������ó�����   
		        String un = request.getParameter("username");  
	        String pw = request.getParameter("password");  
		          
		        //���û������õ�request������������û����ת����ӭ���ߴ���ҳ��ʱ��֪����ʲô  
		        request.setAttribute("username", un);  
		          
		        //��ʱ��ʼ�����ݿ�����Ѱ��û��ͬʱ�����û�����������У��оͶԣ�û�оʹ�  
		        //�ȼ���libĿ¼�µ�java-connect-mysql.jar������  
		        try {  
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
		            String sql = "select * from student where username = ? and password = ?";    
		            PreparedStatement ps = conn.prepareStatement(sql);    
		            ps.setString(1, un);  
		            ps.setString(2, pw);  
	            ResultSet rs=ps.executeQuery();  
		              
		            if(rs.next()){  
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



