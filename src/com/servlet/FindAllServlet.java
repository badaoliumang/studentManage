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
import org.apache.jasper.tagplugins.jstl.core.Out;
import com.bean.Student;
import com.bean.StudentDao;
import jdk.nashorn.internal.ir.RuntimeNode.Request;    
public class FindAllServlet extends HttpServlet{   
	//private static final long serialVersionUID = 1L;
	    //重写doGet方法  
	    protected void doGet(HttpServletRequest request,    
	        HttpServletResponse response) throws ServletException, IOException {
			

	       	// 当前页码

	    	int currPage = 1;

	    	// 判断传递页码是否有效
	    	//System.out.println(request.getParameter("page"));
	    	String temp=request.getParameter("page");
	    	System.out.println(temp);
	    	if(temp != null){
	    	System.out.println(temp);
	    	// 对当前页码赋值

	    	currPage = Integer.parseInt(temp);
	    	//System.out.println(temp);
	    	//System.out.println(currPage);

	    	}

	    	// 实例化ProductDao
	    	StudentDao dao=new StudentDao();
	    	List<Student> list=dao.find(currPage);
	    	// 将list放置到request之中
	            request.setAttribute("list", list); 
	         // 总页数

	            int pages ;

	            // 查询总记录数

	            int count = dao.findCount();

	            // 计算总页数

	            if(count % Student.PAGE_SIZE == 0){

	            // 对总页数赋值

	            pages = count /Student.PAGE_SIZE;

	            }else{

	            // 对总页数赋值

	            pages = count / Student.PAGE_SIZE + 1;
	            

	            }

	            // 实例化StringBuffer

	            StringBuffer sb = new StringBuffer();

	            // 通过循环构建分页条

	            for(int i=1; i <= pages; i++){

	            // 判断是否为当前页

	            if(i == currPage){

	            // 构建分页条

	            sb.append("『" + i + "』");
	            //System.out.println(i);
	            //System.out.println(currPage);
	            }else{
	            //request.setAttribute("page", i);
	            // 构建分页条
		        //sb.append("<a href='FindAllServlet?page=123'>" + i + "</a>");
                
	            sb.append("<a href='findAllServlet?page=" + i + "'>" + i + "</a>");
	            //System.out.println(i);
	            //System.out.println(request.getAttribute(page));
	           
	            }

	            // 构建分页条

	            sb.append("　");

	            }
	          
	            // 将分页条的字符串放置到request之中

	            request.setAttribute("bar", sb.toString());
	  /*          resultSet.close();  
	            statement.close();  
	              
	        } catch (SQLException | ClassNotFoundException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  */
	          
	          
	        //跳转到显示页面 ，页面转发可传值 
	        request.getRequestDispatcher("listStudent.jsp")    
	        .forward(request, response);   
	        //doPost(request, response);
	    }    
	    
	    protected void doPost(HttpServletRequest request,    
	            HttpServletResponse response) throws ServletException, IOException {    
	        doGet(request, response);  
	        
	    }    
	}  
