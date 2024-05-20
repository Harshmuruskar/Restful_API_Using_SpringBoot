package com.pirate.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pirate.restapi.entity.Student;
import com.pirate.restapi.repository.StudentRepository;

@RestController
public class StudentController {
	@Autowired
	StudentRepository repo;
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		List<Student> students=repo.findAll();
		return students;	
	}
	@GetMapping("/students/{id}")
	public Student getstudent(@PathVariable int id) {
		Student student= repo.findById(id).get();
		return student;
	}
	@PostMapping("/student/add")
	public void createStudent(@RequestBody Student student) {
		repo.save(student);
		
	}
	@PutMapping("student/update/{id}")
	public Student updateStudents(@PathVariable int id) {
		Student student =repo.findById(id).get();
		student.setName("akash");
		student.setPercentage(60);
		repo.save(student);
		return student;
		
		
	}
	@DeleteMapping("student/delete/{id}")
	public void deletestudent(@PathVariable int id) {
		Student student=repo.findById(id).get();
		repo.delete(student);
	}


		
	}
	
	


