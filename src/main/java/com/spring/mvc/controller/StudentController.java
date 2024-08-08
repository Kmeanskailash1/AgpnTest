package com.spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mvc.model.Student;
import com.spring.mvc.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentServ;

	@GetMapping("/allStudents")
	public List<Student> getAllStudent() {
		return studentServ.getAllStudent();
	}

	@GetMapping("/student/searchById/{id}")
	public Student getStudentByRegdId(@PathVariable("id") String id) {
		return studentServ.getStudentById(id);
	}

	@GetMapping("/student/searchByName/{sname}")
	public List<Student> getMethodName(@PathVariable("sname") String sname) {
		return studentServ.getStudentListByName(sname);
	}

	@PostMapping("/add/student")
	public String addStudent(@RequestBody Student s) {
		System.out.println("called");
		return studentServ.addStudent(s);
	}

}
