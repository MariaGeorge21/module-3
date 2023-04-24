package com.ust.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ust.rest.resource.User;

//@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	

}
