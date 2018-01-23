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
	      
	    //重写doGet方法  
	    protected void doGet(HttpServletRequest request,    
	        HttpServletResponse response) throws ServletException, IOException {    
	    	
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
	            //编写SQL语句，执行，拿到结果集  
	            String sql = "select * from student";    
	            Statement statement = conn.createStatement();  
                ResultSet resultSet = statement.executeQuery(sql);  
	              
	            //把结果集的东西倒进ArrayList  
	            List<Student> ss = new ArrayList<Student>();  
	            while(resultSet.next()){  
	                Student s = new Student();  
	                s.setId(resultSet.getInt("id"));  
	                s.setUsername(resultSet.getString("username"));  
	                s.setPassword(resultSet.getString("password"));  
	                s.setSex(resultSet.getString("sex"));  
	                s.setAddress(resultSet.getString("address"));  
	                  
	                //后台打印，试看有没有拿到  
	              /*  String ms = resultSet.getInt("id")+resultSet.getString("username"); 
	                System.out.println(ms);  */
                  
	                ss.add(s);  
	            }  
	              
	            //ArrayList放进request的属性里，这样jsp页面就能request.getAttribute("ss")  
	            //拿出ArrayList了。  
	            request.setAttribute("ss", ss);    
	            resultSet.close();  
	            statement.close();  
	              
	        } catch (SQLException | ClassNotFoundException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	          
	          
	        //跳转到显示页面  
	        request.getRequestDispatcher("listStudent.jsp")    
	        .forward(request, response);   
	    }    
	    
	    protected void doPost(HttpServletRequest request,    
	            HttpServletResponse response) throws ServletException, IOException {    
	        doGet(request, response);    
	    }    
	}  
