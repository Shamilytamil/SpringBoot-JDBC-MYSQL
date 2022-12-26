package com.springboot.JDBC.MYSQL.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.JDBC.MYSQL.dto.Student;
import com.springboot.JDBC.MYSQL.repository.StudentRepository;

@Service

public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public void save(Student student) throws ClassNotFoundException, SQLException {
		studentRepository.save(student);
	}
	public List<Student> getStudent() throws ClassNotFoundException, SQLException{
		return studentRepository.getStudent();
	}
	public void update(Student student) throws ClassNotFoundException, SQLException{
		studentRepository.update(student);
	}
	public void delete(Student student) throws ClassNotFoundException, SQLException{
		studentRepository.delete(student);
	}
}
