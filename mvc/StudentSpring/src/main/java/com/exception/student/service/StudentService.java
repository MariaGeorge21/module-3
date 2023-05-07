package com.exception.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exception.student.entity.StudentEntity;
import com.exception.student.repository.StudentRepository;
import com.exception.student.user.UserNotFoundException;
@Service
public class StudentService {
	@Autowired
	StudentRepository srepo;

	public StudentEntity createuser(StudentEntity student) {
		
		return srepo.save(student);
	}

	public StudentEntity retrieve(int id) throws UserNotFoundException  {
		Optional<StudentEntity>ops=srepo.findById(id);
		if(ops.isPresent()) {
			return ops.get();
		}
		else
			throw new UserNotFoundException("user not found");
	
		
		
		
		
		
	}

	public List<StudentEntity> retrieveall(StudentEntity student) {
		
		return srepo.findAll();
	}

	public String delete(int id) {
		srepo.deleteById(id);
		return "deleted";
	}

	public StudentEntity update(StudentEntity student) {
		StudentEntity s1=null;
		Optional<StudentEntity>ops=srepo.findById(student.getId());
		if(ops.isPresent()) {
			s1=ops.get();
			s1.setSname(student.getSname());
			s1.setTmarks(student.getTmarks());
			srepo.save(s1);
		}
		else {
			return srepo.save(student);
			
			
			
		}
		return s1;
		
		
	}

	

}
