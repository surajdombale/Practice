package com.example.springbootjpa.service;

import java.util.List;

import com.example.springbootjpa.model.Student;

public interface StudentSVC {
	public boolean addStudent(Student student);

	public Student getStudent(int id);

	public List<Student> getAllStudent();

	public boolean editStudent(Student student);

	public boolean deletStudent(int id);
}
