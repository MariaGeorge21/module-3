package com.example.conrepo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.conrepo.dto.UserDto;
import com.example.conrepo.entity.User;
import com.example.conrepo.exception.UserNotFoundException;
import com.example.conrepo.repository.UserRepository;

@RestController
@RequestMapping()
@Validated
public class UserController {
	@Autowired
	
	UserRepository userepo;
	@PostMapping("/create")
	public ResponseEntity<User> createuser(@RequestBody @Valid User user ){
		return ResponseEntity.ok().body(userepo.save(user));
	}
	@GetMapping("/retrive/{id}")
	public ResponseEntity<User> fetchuser(@PathVariable int id) 
	{
	 Optional<User> op=userepo.findById(id);
	 if(op.isPresent())
	 {
		 return ResponseEntity.ok().body(op.get());
		 
	 }
	 else
	 {
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	 }
	 
	 
	}
	@DeleteMapping("/Delete/{id}")
	public ResponseEntity<?>deleteuser(@PathVariable int id){
		Optional<User> opde=userepo.findById(id);
		
				if(opde.isPresent()) {
					userepo.deleteById(id);
					return ResponseEntity.ok().build();
				}
				else {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
				}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateuser(@PathVariable int id , @RequestBody User upuser ) throws UserNotFoundException
	{
		//User user=null;
		Optional<User> opuser=userepo.findById(id);
				if(opuser.isPresent())
				{
					User user=opuser.get();
					user.setName(upuser.getName());
					user.setAge(upuser.getAge());
					return ResponseEntity.ok().body(userepo.save(user));
					
				}
				else
				{
					throw new UserNotFoundException("invalid user");
				}
	}

}
