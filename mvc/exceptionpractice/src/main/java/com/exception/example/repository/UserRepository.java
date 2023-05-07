package com.exception.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exception.example.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>
{

	

}
