package com.servlet;  
import java.io.IOException;  
import java.sql.Connection;  
import java.sql.DriverManager;  
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
public class FindAllServlet extends HttpServlet{        
	    //��дdoGet����  
	    protected void doGet(HttpServletRequest request,    
	        HttpServletResponse response) throws ServletException, IOException {    	    	
	        try {  
	            //�ȼ���libĿ¼�µ�java-connect-mysql.jar������  ,Ȼ��ע������
	            Class.forName("com.mysql.jdbc.Driver");    	         
	            //ѡ�������࣬���ӵ�ַ���˺����룬����MySQL  
	            String driverClass="com.mysql.jdbc.Driver";  
	            String url="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8";  
	            String sqlusername="root";  
	            String sqlpassword="523627"; 
	            //���ݿ�url�󶨣������ݿ⽨������
	            Connection conn = DriverManager.getConnection(url, sqlusername,sqlpassword);  	             	              
	            //��дSQL��䣬ִ�У��õ������  
	            String sql = "select * from student";
	            //����sql������ݿ⣬����������
	            //statement���������о�̬SQL��䣬statement�ӿڲ����ܲ���
	            //PreparedStatement �ƻ����ʹ��SQL��䣬�����ڽ�������Ĳ���-��
	            Statement statement = conn.createStatement();
	            //SQL �������ݿ��ѯ�л�ȡ���ݣ��������ݷ��ص��������,
	            //һ�� ResultSet �������һ�����ָ��ǰ�еĽ����
                ResultSet resultSet = statement.executeQuery(sql);  	              
	            //�ѽ�����Ķ�������ArrayList  
	            List<Student> ss = new ArrayList<Student>();  
	            while(resultSet.next()){  
	                Student s = new Student();  
	                s.setId(resultSet.getInt("id"));  
	                s.setUsername(resultSet.getString("username"));  
	                s.setPassword(resultSet.getString("password"));  
	                s.setSex(resultSet.getString("sex"));  
	                s.setAddress(resultSet.getString("address"));  	                  
	                //��̨��ӡ���Կ���û���õ�  
	                /* String ms = resultSet.getInt("id")+resultSet.getString("username"); 
	                System.out.println(ms);  */         
	                ss.add(s);  
	            }  	              
	            //ArrayList�Ž�request�����������jspҳ�����request.getAttribute("ss")  
	            //�ó�ArrayList�ˡ�  
	            request.setAttribute("ss", ss);    
	            resultSet.close();  
	            statement.close();  
	              
	        } catch (SQLException | ClassNotFoundException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	          
	          
	        //��ת����ʾҳ��  
	        request.getRequestDispatcher("listStudent.jsp")    
	        .forward(request, response);   
	    }    
	    
	    protected void doPost(HttpServletRequest request,    
	            HttpServletResponse response) throws ServletException, IOException {    
	        doGet(request, response);    
	    }    
	}  
