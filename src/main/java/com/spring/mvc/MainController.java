package com.spring.mvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@RequestMapping("/")
	public String home() {
		return "index.html";
	}
	
	
	
	@ResponseBody
	@RequestMapping("/student-data")
	public List<Student> showStudentData() {
		List<Student> studentList = new ArrayList();
		 studentList.add(new Student(12,"Rajesh Kumar","Sitaram Modak",15000d));
		 studentList.add(new Student(14,"Shiv Kumar","Guhiram Daw",7000d));
		 studentList.add(new Student(77,"Jaidev Kumar Rakshit","Pran Rakshit",18000d));
		return studentList;
	}
	@ResponseBody
	@PostMapping("/login")
	public String loginRequest(@RequestBody User user) {
		System.out.println("Login Requested...");
		System.out.println("User: "+ user.getUser() + "\nPass: "+user.getPass());
		if("admin".equalsIgnoreCase(user.getUser()) && "Testing".equalsIgnoreCase(user.getPass())) {
			return "success";
		}
		return "fail";
	}
	
	
}
