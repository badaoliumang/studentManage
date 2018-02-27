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
	      
	    //重写doGet方法  
	    protected void doGet(HttpServletRequest request,    
	        HttpServletResponse response) throws ServletException, IOException {    
	        request.setCharacterEncoding("utf-8");         
	        //从jsp页面获取要添加的新对象的各项值  
	        int id = Integer.valueOf(request.getParameter("id").trim());  
	        String username = request.getParameter("username");  
	        String password = request.getParameter("password");  
	        String sex =request.getParameter("sex");
	        String province1 = request.getParameter("province1");//获得省
	        String city1 = request.getParameter("city1");//获得市
	        String district1 = request.getParameter("district1");//获得区
	        String address = province1+city1+district1;//拼接成地址
  
	        try {  
	           /* //先加载lib目录下的java-connect-mysql.jar驱动包  
	            Class.forName("com.mysql.jdbc.Driver");    	              
	            //选择驱动类，连接地址、账号密码，连接MySQL  
	            String driverClass="com.mysql.jdbc.Driver";
 	            String url="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8&useSSL=false&verifyServerCertificate=false";  
	            String sqlusername="root";  
	            String sqlpassword="523627";  */
	        	//调用建立连接
	        	StudentDao studentDao=new StudentDao();
	            Connection conn = studentDao.getConnection(); 
	            
	            //编写SQL语句，这里不要用statement了，换用preparedstatement，因为  
                //preparedstatement可以设置？为形参，然后set各个形参的实际值，statement没有此  
	            //功能。最后执行更新语句。  
	            //此外，？不要加单双引号，否则报错java.sql.SQLException: Parameter index out of range (0 < 1 ).  
	            String sql = "select * from student where id = ? ";          
	            PreparedStatement ps = conn.prepareStatement(sql);  
	            ps.setInt(1, id);  
	            //提取结果数据
                ResultSet rs = ps.executeQuery();  
                //如果id已经存在则，提示信息，并且回退网页，如果不存在则执行插入
	            if(rs.next()){ 
	            	//防止alert中文乱码
	            	 response.setContentType("text/html;charset=gb2312");//在PrintWriter前面有效果  
	    	         PrintWriter out = response.getWriter();//通过servlet的doget方法获取response对象，通过getWriter方法获取PrintWriter对象
	    	         out.flush();//清空缓存
	    	         out.println("<script  charset='utf-8' type='text/javascript'>");//输出script标签
	    	         out.println("alert('学号已经存在！！');");//js语句：输出alert语句
	    	         out.println("history.back();");//js语句：输出网页回退语句
	    	         out.println("</script>");//输出script结尾标签
	            }else{  
	                 sql = "insert into student values("+id+",'"+username+"','"+password+"','"+sex+"','"+address+"')";
	                 ps = conn.prepareStatement(sql);  
	                 ps.executeUpdate();  
	            }             
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
