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

		// ���ݿ�����
		Connection conn = null;
		

		try {
		

		// �������ݿ�������ע�ᵽ����������

		Class.forName("com.mysql.jdbc.Driver");
		//String driverClass="com.mysql.jdbc.Driver";
		// ���ݿ������ַ���?useSSL=true&useUnicode=true&characterEncoding=utf-8

		String url="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8&useSSL=false&verifyServerCertificate=false";  

		// ���ݿ��û���

		String username = "root";

		// ���ݿ�����

		String password = "523627";

		// ����Connection����

		conn = DriverManager.getConnection(url,username,password);

		} catch (ClassNotFoundException e) {

		e.printStackTrace();

		} catch (SQLException e) {

		e.printStackTrace();

		}

		// �������ݿ�����

		return conn;

		}
	/**

	 * ��ҳ��ѯ������Ʒ��Ϣ

	 * @param page ҳ��

	 * @return List<Product>

	 */
	public List<Student> find(int page){

		// ����List

		List<Student> list = new ArrayList<Student>();

		// ��ȡ���ݿ�����

		Connection conn = getConnection();

		// ��ҳ��ѯ��SQL���

		String sql = "select * from student order by id asc limit ?,?";

		try {

		// ��ȡPreparedStatement

		PreparedStatement ps = conn.prepareStatement(sql);

		// ��SQL����еĵ�1��������ֵ

		ps.setInt(1, (page - 1) * Student.PAGE_SIZE);

		// ��SQL����еĵ�2��������ֵ

		ps.setInt(2, Student.PAGE_SIZE);

		// ִ�в�ѯ����

		ResultSet rs = ps.executeQuery();

		// �������ƶ������ж��Ƿ���Ч

		while(rs.next()){

		// ʵ����Product

		Student p = new Student();

		 p.setId(rs.getInt("id"));  
         p.setUsername(rs.getString("username"));  
         p.setPassword(rs.getString("password"));  
         p.setSex(rs.getString("sex"));  
         p.setAddress(rs.getString("address"));  	 
		list.add(p);

		}

		// �ر�ResultSet

		rs.close();

		// �ر�PreparedStatement

		ps.close();

		// �ر�Connection

		conn.close();

		} catch (SQLException e) {

		e.printStackTrace();

		}

		return list;

		}
	
	/**

	 * ��ѯ�ܼ�¼��

	 * @return �ܼ�¼��

	 */

	public int findCount(){

	// �ܼ�¼��

	int count = 0;

	// ��ȡ���ݿ�����

	Connection conn = getConnection();

	// ��ѯ�ܼ�¼��SQL���

	String sql = "select count(*) from student";

	try {

	// ����Statement

	Statement stmt = conn.createStatement();

	// ��ѯ����ȡResultSet

	ResultSet rs = stmt.executeQuery(sql);

	// �������ƶ������ж��Ƿ���Ч

	if(rs.next()){

	// ���ܼ�¼����ֵ

	count = rs.getInt(1);

	}

	// �ر�ResultSet

	rs.close();

	// �ر�Connection

	conn.close();

	} catch (SQLException e) {

	e.printStackTrace();

	}

	// �����ܼ�¼��

	return count;

	}

	
	
}