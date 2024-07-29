package com.spring.mvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
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
	
}
