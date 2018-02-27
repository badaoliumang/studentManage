package com.servlet;  
import java.io.IOException;
import java.io.PrintWriter;
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
	        String province1 = request.getParameter("province1");//���ʡ
	        String city1 = request.getParameter("city1");//�����
	        String district1 = request.getParameter("district1");//�����
	        String address = province1+city1+district1;//ƴ�ӳɵ�ַ
  
	        try {  
	           /* //�ȼ���libĿ¼�µ�java-connect-mysql.jar������  
	            Class.forName("com.mysql.jdbc.Driver");    	              
	            //ѡ�������࣬���ӵ�ַ���˺����룬����MySQL  
	            String driverClass="com.mysql.jdbc.Driver";
 	            String url="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8&useSSL=false&verifyServerCertificate=false";  
	            String sqlusername="root";  
	            String sqlpassword="523627";  */
	        	//���ý�������
	        	StudentDao studentDao=new StudentDao();
	            Connection conn = studentDao.getConnection(); 
	            
	            //��дSQL��䣬���ﲻҪ��statement�ˣ�����preparedstatement����Ϊ  
                //preparedstatement�������ã�Ϊ�βΣ�Ȼ��set�����βε�ʵ��ֵ��statementû�д�  
	            //���ܡ����ִ�и�����䡣  
	            //���⣬����Ҫ�ӵ�˫���ţ����򱨴�java.sql.SQLException: Parameter index out of range (0 < 1 ).  
	            String sql = "select * from student where id = ? ";          
	            PreparedStatement ps = conn.prepareStatement(sql);  
	            ps.setInt(1, id);  
	            //��ȡ�������
                ResultSet rs = ps.executeQuery();  
                //���id�Ѿ���������ʾ��Ϣ�����һ�����ҳ�������������ִ�в���
	            if(rs.next()){ 
	            	//��ֹalert��������
	            	 response.setContentType("text/html;charset=gb2312");//��PrintWriterǰ����Ч��  
	    	         PrintWriter out = response.getWriter();//ͨ��servlet��doget������ȡresponse����ͨ��getWriter������ȡPrintWriter����
	    	         out.flush();//��ջ���
	    	         out.println("<script  charset='utf-8' type='text/javascript'>");//���script��ǩ
	    	         out.println("alert('ѧ���Ѿ����ڣ���');");//js��䣺���alert���
	    	         out.println("history.back();");//js��䣺�����ҳ�������
	    	         out.println("</script>");//���script��β��ǩ
	            }else{  
	                 sql = "insert into student values("+id+",'"+username+"','"+password+"','"+sex+"','"+address+"')";
	                 ps = conn.prepareStatement(sql);  
	                 ps.executeUpdate();  
	            }             
	            //�ر�����  
	            ps.close();    
	            conn.close();    
	              
        } catch (SQLException e) {  
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
