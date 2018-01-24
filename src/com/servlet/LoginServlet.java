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
	            //��һ�����Ȱ��ַ����趨��utf-8��������һ����������������ľͻ��������  
		        request.setCharacterEncoding("utf-8");  	           
		        //�Ȱ������������������û����������ó�����   
		        String un = request.getParameter("username");  
	            String pw = request.getParameter("password");  		          
		        //���û������õ�request������������������ת����ӭ���ߴ���ҳ��ʱ��֪����ʲô  
		        request.setAttribute("username", un);  		          
		        //��ʱ��ʼ�����ݿ�����Ѱ��û��ͬʱ�����û�����������У��оͶԣ�û�оʹ�  
		        //�ȼ���libĿ¼�µ�java-connect-mysql.jar������  
		        try {  
		        	//ע��mysql������
		            Class.forName("com.mysql.jdbc.Driver");  		              
		            //ѡ�������࣬���ӵ�ַ���˺����룬����MySQL  
		            String driverClass="com.mysql.jdbc.Driver";  
		            //studentΪ���ݿ�����
		            String url="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8"; 
		            //�û���
		            String sqlusername="root"; 
		            //����
		            String sqlpassword="523627";
		            /* Connection : �˽ӿھ��нӴ����ݿ�����з�����
		                              �����Ӷ����ʾͨ�������ģ��������������ݿ��ͨ�Ž�ͨ��������Ӷ�����С�
		            */
		            /* �����ӣ���Ҫʹ�� DriverManager.getConnection() ��������һ�� Connection ����
		                              �����������ݿ���������ӡ�*/
		            Connection conn = DriverManager.getConnection(url, sqlusername,sqlpassword);        
		             /* ִ�в�ѯ����Ҫʹ�����������Ķ��������ύһ�� SQL ��䵽���ݿ⡣
		              * ��дSQL��䣬���ﲻҪ��statement�ˣ�����preparedstatement����Ϊ  
		               preparedstatement�������ã�Ϊ�βΣ�Ȼ��set�����βε�ʵ��ֵ��statementû�д˹��ܡ����ִ�и�����䡣  
		                                     ���⣬����Ҫ�ӵ�˫���ţ����򱨴�java.sql.SQLException: Parameter index out of range (0 < 1 ).
		             */ 
		            String sql = "select * from student where username = ? and password = ?";    
		            PreparedStatement ps = conn.prepareStatement(sql);  
		            //�����βδ�����Ӧ��ֵ
		            ps.setString(1, un);  
		            ps.setString(2, pw); 
		            //��ȡ�������
	                ResultSet rs = ps.executeQuery();  
	                //������ݿ��д�������ת����ӭ���棬������ת���������
		            if(rs.next()){ 
		            	//ҳ��ת�����������ض���,�ᴫֵ��ȥ��
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



