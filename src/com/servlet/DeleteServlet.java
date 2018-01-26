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
	 * дDeleteServletʱ������������ѣ����붼�ԣ�ǰ̨jsp��<a href="deleteServlet?id=<%=s.getId()%>">ɾ��</a> 
	 * �ԣ���̨����id��ֵ��Ȼ��ɾ��Ҳ�ԣ����Ǿ��ǽ�����servlet��ǰ̨��ʾ�Ҳ���404���������˷�����������������ǰ̨�����������ݡ�ɾ����������ˡ� 
	 * �����Ƿ�����û��������ԭ��Ҳ�п�����ǰ̨�Ļ�����ɵ��Ҳ���������ˢ���ǲ����ģ�����û�б䣬������תҳ�棬�����»��档 
	 * @author Administrator 
	 * 
	 */  public class DeleteServlet extends HttpServlet{  	      
	    //��дdoGet����  
	    protected void doGet(HttpServletRequest request,    
	        HttpServletResponse response) throws ServletException, IOException {    	          
	        //��jspҳ���ȡҪ�޸ĵ�Ԫ�ص�id�͸����޸ĺ��ֵ  
	        int id = Integer.valueOf(request.getParameter("id"));  	          
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
            String sql = "delete from student where id = ?";    
	            PreparedStatement ps = conn.prepareStatement(sql);    
	            ps.setInt(1, id);  
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
