package com.example.springbootjpa.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootjpa.model.Student;
import com.example.springbootjpa.repository.StudentRepo;

@Service
public class StudentSvcImpl implements StudentSVC {
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public List<Student> getAllStudent() {
		System.out.println("in service getall");
		List<com.example.springbootjpa.entity.Student> list = studentRepo.findAll();
		List<Student> stdlist = new ArrayList<Student>();
		if (list != null && list.size() > 0) {
			for (com.example.springbootjpa.entity.Student s : list) {
				Student std = new Student(s.getId(), s.getName(), s.getAddress());
				stdlist.add(std);
			}
		}

		return stdlist;
	}

	@Override
	public boolean addStudent(Student student) {
		boolean result = false;
		System.out.println("in service add");
		System.out.println(student.getId() + " " + student.getName() + " " + student.getAddress());
		
		com.example.springbootjpa.entity.Student stud = new com.example.springbootjpa.entity.Student(student.getId(),
				student.getName(), student.getAddress());
		try {
			studentRepo.save(stud);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Student getStudent(int id) {
		System.out.println("in service get");
		System.out.println(id);
		if(!studentRepo.existsById(id)) {
			return null;
		}
		com.example.springbootjpa.entity.Student studedit = studentRepo.findById(id).get();
		System.out.println(studedit.getId() + "ee " + studedit.getName() + " eee" + studedit.getAddress());

		Student student = new Student(studedit.getId(), studedit.getName(), studedit.getAddress());
		return student;
	}

	@Override
	public boolean editStudent(Student student) {
		System.out.println("in service edit");
		boolean result = false;
		if (studentRepo.existsById(student.getId())) {

			result = true;

			Optional<com.example.springbootjpa.entity.Student> studedit = studentRepo.findById(student.getId());
			if (student.getAddress() != null && student.getName() != null) {
				com.example.springbootjpa.entity.Student stud = new com.example.springbootjpa.entity.Student(
						student.getId(), student.getName(), student.getAddress());
				System.out.println(student.getId() + " " + student.getName() + " " + student.getAddress());
				System.out.println(
						studedit.get().getId() + " " + studedit.get().getName() + " " + studedit.get().getAddress());

				studentRepo.save(stud);
			}
			if (student.getAddress() == null && student.getName() != null) {
				com.example.springbootjpa.entity.Student stud = new com.example.springbootjpa.entity.Student(
						student.getId(), studedit.get().getName(), student.getAddress());
				System.out.println(student.getId() + " " + student.getName() + " " + student.getAddress());
				System.out.println(
						studedit.get().getId() + " " + studedit.get().getName() + " " + studedit.get().getAddress());
				studentRepo.save(stud);
			}
			if (student.getAddress() != null && student.getName() == null) {
				com.example.springbootjpa.entity.Student stud = new com.example.springbootjpa.entity.Student(
						student.getId(), studedit.get().getName(), student.getAddress());
				System.out.println(student.getId() + " " + student.getName() + " " + student.getAddress());
				System.out.println(
						studedit.get().getId() + " " + studedit.get().getName() + " " + studedit.get().getAddress());
				studentRepo.save(stud);
			}
		}
		return result;
	}

	@Override
	public boolean deletStudent(int id) {
		System.out.println("in service delet");
		System.out.println(id);

		try {
			studentRepo.deleteById(id);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("in service delet");
		}
		return !studentRepo.existsById(id);
	}

}
