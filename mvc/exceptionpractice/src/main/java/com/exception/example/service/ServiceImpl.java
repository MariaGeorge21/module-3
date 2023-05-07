package com.exception.example.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import com.exception.example.Exception.UserNotFoundException;
import com.exception.example.dto.Userdto;
import com.exception.example.entity.User;
import com.exception.example.repository.UserRepository;

public class ServiceImpl {
	@Autowired
UserRepository urepo;
	

	public User Createuser( Userdto udto) {
		User user=User.build(0,udto.getName(),udto.getGender(),udto.getAge());
		return urepo.save(user);
	}


	public List<User> getuser() {
	
		return urepo.findAll();
	}


	public Optional<User> getuserid(int id) throws UserNotFoundException {
		Optional<User> user=urepo.findById(id);
		if(user!=null)
		{
			return user;
		}
		else {
			 throw new UserNotFoundException("user not found");
		}
			
		
	
	
	}


	public User update(Userdto udto, int id) {
		Optional<User> op=urepo.findById(id);
		User use=null;
		if(op.isPresent()) {
			use.getId();
			use.setName(udto.getName());
			use.setAge(udto.getAge());
			use.setGender(udto.getGender());
			
		}
		return null;
	}

	

	
}
