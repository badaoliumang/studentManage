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
	    //��дdoGet����  
	    protected void doGet(HttpServletRequest request,    
	        HttpServletResponse response) throws ServletException, IOException {
			

	       	// ��ǰҳ��

	    	int currPage = 1;

	    	// �жϴ���ҳ���Ƿ���Ч
	    	//System.out.println(request.getParameter("page"));
	    	String temp=request.getParameter("page");
	    	System.out.println(temp);
	    	if(temp != null){
	    	System.out.println(temp);
	    	// �Ե�ǰҳ�븳ֵ

	    	currPage = Integer.parseInt(temp);
	    	//System.out.println(temp);
	    	//System.out.println(currPage);

	    	}

	    	// ʵ����ProductDao
	    	StudentDao dao=new StudentDao();
	    	List<Student> list=dao.find(currPage);
	    	// ��list���õ�request֮��
	            request.setAttribute("list", list); 
	         // ��ҳ��

	            int pages ;

	            // ��ѯ�ܼ�¼��

	            int count = dao.findCount();

	            // ������ҳ��

	            if(count % Student.PAGE_SIZE == 0){

	            // ����ҳ����ֵ

	            pages = count /Student.PAGE_SIZE;

	            }else{

	            // ����ҳ����ֵ

	            pages = count / Student.PAGE_SIZE + 1;
	            

	            }

	            // ʵ����StringBuffer

	            StringBuffer sb = new StringBuffer();

	            // ͨ��ѭ��������ҳ��

	            for(int i=1; i <= pages; i++){

	            // �ж��Ƿ�Ϊ��ǰҳ

	            if(i == currPage){

	            // ������ҳ��

	            sb.append("��" + i + "��");
	            //System.out.println(i);
	            //System.out.println(currPage);
	            }else{
	            //request.setAttribute("page", i);
	            // ������ҳ��
		        //sb.append("<a href='FindAllServlet?page=123'>" + i + "</a>");
                
	            sb.append("<a href='findAllServlet?page=" + i + "'>" + i + "</a>");
	            //System.out.println(i);
	            //System.out.println(request.getAttribute(page));
	           
	            }

	            // ������ҳ��

	            sb.append("��");

	            }
	          
	            // ����ҳ�����ַ������õ�request֮��

	            request.setAttribute("bar", sb.toString());
	  /*          resultSet.close();  
	            statement.close();  
	              
	        } catch (SQLException | ClassNotFoundException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  */
	          
	          
	        //��ת����ʾҳ�� ��ҳ��ת���ɴ�ֵ 
	        request.getRequestDispatcher("listStudent.jsp")    
	        .forward(request, response);   
	        //doPost(request, response);
	    }    
	    
	    protected void doPost(HttpServletRequest request,    
	            HttpServletResponse response) throws ServletException, IOException {    
	        doGet(request, response);  
	        
	    }    
	}  
