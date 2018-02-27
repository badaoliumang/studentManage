package com.bean;
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.ArrayList;

import java.util.List;
public class StudentDao {
	public Connection getConnection(){

		// 数据库连接
		Connection conn = null;
		

		try {
		

		// 加载数据库驱动，注册到驱动管理器

		Class.forName("com.mysql.jdbc.Driver");
		//String driverClass="com.mysql.jdbc.Driver";
		// 数据库连接字符串?useSSL=true&useUnicode=true&characterEncoding=utf-8

		String url="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8&useSSL=false&verifyServerCertificate=false";  

		// 数据库用户名

		String username = "root";

		// 数据库密码

		String password = "523627";

		// 创建Connection连接

		conn = DriverManager.getConnection(url,username,password);

		} catch (ClassNotFoundException e) {

		e.printStackTrace();

		} catch (SQLException e) {

		e.printStackTrace();

		}

		// 返回数据库连接

		return conn;

		}
	/**

	 * 分页查询所有商品信息

	 * @param page 页数

	 * @return List<Product>

	 */
	public List<Student> find(int page){

		// 创建List

		List<Student> list = new ArrayList<Student>();

		// 获取数据库连接

		Connection conn = getConnection();

		// 分页查询的SQL语句

		String sql = "select * from student order by id asc limit ?,?";

		try {

		// 获取PreparedStatement

		PreparedStatement ps = conn.prepareStatement(sql);

		// 对SQL语句中的第1个参数赋值

		ps.setInt(1, (page - 1) * Student.PAGE_SIZE);

		// 对SQL语句中的第2个参数赋值

		ps.setInt(2, Student.PAGE_SIZE);

		// 执行查询操作

		ResultSet rs = ps.executeQuery();

		// 光标向后移动，并判断是否有效

		while(rs.next()){

		// 实例化Product

		Student p = new Student();

		 p.setId(rs.getInt("id"));  
         p.setUsername(rs.getString("username"));  
         p.setPassword(rs.getString("password"));  
         p.setSex(rs.getString("sex"));  
         p.setAddress(rs.getString("address"));  	 
		list.add(p);

		}

		// 关闭ResultSet

		rs.close();

		// 关闭PreparedStatement

		ps.close();

		// 关闭Connection

		conn.close();

		} catch (SQLException e) {

		e.printStackTrace();

		}

		return list;

		}
	
	/**

	 * 查询总记录数

	 * @return 总记录数

	 */

	public int findCount(){

	// 总记录数

	int count = 0;

	// 获取数据库连接

	Connection conn = getConnection();

	// 查询总记录数SQL语句

	String sql = "select count(*) from student";

	try {

	// 创建Statement

	Statement stmt = conn.createStatement();

	// 查询并获取ResultSet

	ResultSet rs = stmt.executeQuery(sql);

	// 光标向后移动，并判断是否有效

	if(rs.next()){

	// 对总记录数赋值

	count = rs.getInt(1);

	}

	// 关闭ResultSet

	rs.close();

	// 关闭Connection

	conn.close();

	} catch (SQLException e) {

	e.printStackTrace();

	}

	// 返回总记录数

	return count;

	}

	
	
}