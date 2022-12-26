package com.springboot.JDBC.MYSQL.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;


import com.springboot.JDBC.MYSQL.dto.Student;

@Repository
public class StudentRepository {

	private static Connection connection;
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		if(!ObjectUtils.isEmpty(connection)) {
			return connection;
		}
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://101.53.155.156:3306/mysql_demo_tnj","mysql_demo_tnj", "Ebrain@20");
		return connection;
	}
	
	public void save(Student student) throws ClassNotFoundException, SQLException {
		connection = getConnection();
		String insertQuery = "insert into tb_shamily_student (st_id,st_name,st_year,st_cgp) values (?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(insertQuery);
		ps.setString(1,student.getStId());
		ps.setString(2,student.getStName());
		ps.setInt(3, student.getStYear());
		ps.setDouble(4, student.getStCgp());
		ps.executeUpdate();
		ps.close();
		connection.close();
	}
	public List<Student> getStudent() throws ClassNotFoundException, SQLException {
		connection = getConnection();
		String selectQuery = "select * from tb_shamily_student";
		PreparedStatement ps = connection.prepareStatement(selectQuery);
		ResultSet rs = ps.executeQuery();
		List<Student> studentList = new ArrayList<Student>();
		Student student =null;
		while(rs.next())
		{
			student = new Student();
			student.setStId(rs.getString(1));
			student.setStName(rs.getString(2));
			student.setStYear(rs.getInt(3));
			student.setStCgp(rs.getDouble(4));
			studentList.add(student);
		}
		
		ps.close();
		connection.close();
		return studentList;
	}
	public void update(Student student) throws ClassNotFoundException, SQLException {
		connection = getConnection();
		String updateQuery = "update tb_shamily_student set st_year = ? where st_id = ? ";
		PreparedStatement ps = connection.prepareStatement(updateQuery);
		ps.setInt(1, student.getStYear());
		ps.setString(2, student.getStId());
		ps.executeUpdate();
		ps.close();
		connection.close();
	}
	public void delete(Student student) throws ClassNotFoundException, SQLException {
		connection = getConnection();
		String deleteQuery = "delete from tb_shamily_student where st_id = ? ";
		PreparedStatement ps = connection.prepareStatement(deleteQuery);
		ps.setString(1, student.getStId());
		ps.executeUpdate();
		ps.close();
		connection.close();
	}
}
