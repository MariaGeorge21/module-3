package com.exception.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.student.entity.StudentEntity;
import com.exception.student.service.StudentService;
import com.exception.student.user.UserNotFoundException;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService serviceimpl;
	
	@PostMapping("/create")
	public ResponseEntity<StudentEntity> createuser(@RequestBody StudentEntity student ){
		return new ResponseEntity<>(serviceimpl.createuser(student),HttpStatus.CREATED);
	}
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<StudentEntity> retrieve(@PathVariable int id) throws UserNotFoundException{
		return ResponseEntity.ok(serviceimpl.retrieve(id));
	}
	@GetMapping("/retrieve")
	public ResponseEntity<List<StudentEntity>> retriveall(StudentEntity student){
		return ResponseEntity.ok(serviceimpl.retrieveall(student));
		
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id)
	{
		return serviceimpl.delete(id);
	}
	@PutMapping
	public StudentEntity update(@RequestBody StudentEntity student){
		return serviceimpl.update(student);
	}
	


}
