package com.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.spring.mvc.model.Student;
import com.spring.mvc.repo.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepo;

	public List<Student> getAllStudent() {
		return studentRepo.findAll();
	}

	public Student getStudentById(String regdNo) {
		return studentRepo.findById(regdNo).orElse(new Student());
	}

	public List<Student> getStudentListByName(String sname) {
		return studentRepo.findByStudentNameContainingIgnoreCase(sname);
	}

	public String addStudent(Student s) {
		try {
			studentRepo.save(s);
			return "Success: User has been successfully inserted.";
		} catch (DataIntegrityViolationException e) {
			// Handle specific exceptions (e.g., duplicate key)
			System.out.println(e);
			e.printStackTrace();
			return "Failure: Data integrity violation.";
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return "Failure: An error occurred while inserting the user.";
		}
	}

}
