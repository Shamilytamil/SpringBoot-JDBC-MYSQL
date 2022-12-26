package com.springboot.JDBC.MYSQL.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.JDBC.MYSQL.dto.GenericResponse;
import com.springboot.JDBC.MYSQL.dto.Student;
import com.springboot.JDBC.MYSQL.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping(value = "/create")
	private GenericResponse<Student> createStudent(@RequestBody Student student) throws ClassNotFoundException, SQLException {
		
		studentService.save(student);
		GenericResponse<Student> response = new GenericResponse<Student>();
		response.setData(null);
		response.setDataList(null);
		response.setMessage("Student data created successfully");
		response.setStatus("SUCCESS");
		
		return response;
	}
	@GetMapping(value = "/read")
	private GenericResponse<Student> getStudentInfo() throws ClassNotFoundException, SQLException {
		
		
		List<Student> studentList = new ArrayList<Student>();
		studentList = studentService.getStudent();
		GenericResponse<Student> response = new GenericResponse<Student>();
		response.setData(null);
		response.setDataList(studentList);
		response.setMessage("Student data read successfully");
		response.setStatus("SUCCESS");
		
		return response;
	}
	@PutMapping(value = "/update")
	private GenericResponse<Student> getUpdateInfo(@RequestBody Student student) throws ClassNotFoundException, SQLException {
		
		
		studentService.update(student);
		GenericResponse<Student> response = new GenericResponse<Student>();
		response.setData(null);
		response.setDataList(null);
		response.setMessage("Student data update successfully");
		response.setStatus("SUCCESS");
		
		return response;
	}
	@DeleteMapping(value = "/delete")
	private GenericResponse<Student> getDeleteInfo(@RequestBody Student student) throws ClassNotFoundException, SQLException {
		
		
		studentService.delete(student);
		GenericResponse<Student> response = new GenericResponse<Student>();
		response.setData(null);
		response.setDataList(null);
		response.setMessage("Student data has been deleted successfully");
		response.setStatus("SUCCESS");
		
		return response;
	}
}