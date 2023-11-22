package com.example.springbootjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootjpa.model.Student;
import com.example.springbootjpa.service.StudentSVC;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
	@Autowired
	private StudentSVC studentSvc;
	
	@GetMapping("/status")
	public String isServiceRunning() {
		return " Student Service Is Running";
	}
	@CrossOrigin
	@PostMapping
	public boolean addStudent( Student student) {
		System.out.println("in controller add");
		return studentSvc.addStudent(student);
	}
	@GetMapping
	public List<Student> getAllStudent() {
		System.out.println("in controller getall");
		return studentSvc.getAllStudent();

	}

	@GetMapping("{id}")
	public Student getStudent(@PathVariable int id) {
		System.out.println("in controller get");
		return studentSvc.getStudent(id);
	}

	@PutMapping
	public boolean editStudent(Student student) {
		System.out.println("in controller edit");
		return studentSvc.editStudent(student);
	}

	@DeleteMapping("{id}")
	public boolean deleteStudent(@PathVariable int id) {
		System.out.println("in controller delet");
		return studentSvc.deletStudent(id);
	}
}
