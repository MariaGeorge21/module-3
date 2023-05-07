package com.exception.example.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.example.Exception.UserNotFoundException;
import com.exception.example.dto.Userdto;
import com.exception.example.entity.User;
import com.exception.example.service.ServiceImpl;

@RestController
@RequestMapping("/api/v1")
@Validated
public class UserController {
	@Autowired
	ServiceImpl serviceimpl;
	@PostMapping("/signup")
	public ResponseEntity<User> createuser(@RequestBody @Valid Userdto udto){
		return new ResponseEntity<>(serviceimpl.Createuser(udto),HttpStatus.CREATED);
		
	}
	@GetMapping()
	public ResponseEntity<List<User>> getuser()
	{
		return ResponseEntity.ok(serviceimpl.getuser());
	}
		
	
	@GetMapping("User/{id}")
	public ResponseEntity<Optional<User>> getUserid(@PathVariable int id) throws UserNotFoundException{
		return ResponseEntity.ok(serviceimpl.getuserid(id));
	}

	@PutMapping("update/{id}")
	public ResponseEntity<User> update(@RequestBody Userdto udto,@PathVariable int id){
		return ResponseEntity.ok(serviceimpl.update(udto,id));
	}
}
