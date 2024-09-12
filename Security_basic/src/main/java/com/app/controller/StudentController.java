package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.model.Student;

import jakarta.servlet.http.HttpServletRequest;
@RestController
@RequestMapping("/students")
public class StudentController {

	List<Student> students = new ArrayList<Student>(List.of(
			new Student(1,"Debabrat",50),
			new Student(2,"Ranjan",65)));
	
	
	@GetMapping("")
	public List<Student> getStudents(){
		return students;
	}
	
	// for any changes in databases such as post/update/delete we need the CSRF token
	
	@GetMapping("/csrf-token")
	public CsrfToken token(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
	
	@PostMapping("")
	public Student addStudent(@RequestBody	 Student student) {
		System.out.println(student);
		students.add(student);
		return student;
	}
}
