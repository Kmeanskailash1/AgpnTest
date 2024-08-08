package com.spring.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.mvc.model.DummyStudent;
import com.spring.mvc.model.User;

@Controller
public class MainController {

	@RequestMapping("/")
	public String home() {
		return "index.html";
	}

	@RequestMapping("/student-data")
	@ResponseBody
	public List<DummyStudent> showStudentData() {
		List<DummyStudent> studentList = new ArrayList<DummyStudent>();
		studentList.add(new DummyStudent(12, "Rajesh Kumar", "Sitaram Modak", 15000d));
		studentList.add(new DummyStudent(14, "Shiv Kumar", "Guhiram Daw", 7000d));
		studentList.add(new DummyStudent(77, "Jaidev Kumar Rakshit", "Pran Rakshit", 18000d));
		return studentList;
	}

	@PostMapping("/login")
	@ResponseBody
	public String loginRequest(@RequestBody User user) {
		System.out.println("Login Requested...");
		System.out.println("User: " + user.getUser() + "\nPass: " + user.getPass());
		if ("admin".equalsIgnoreCase(user.getUser()) && "Testing".equalsIgnoreCase(user.getPass())) {
			return "success";
		}
		return "fail";
	}

}
