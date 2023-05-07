package com.exception.example.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;
@Validated
public class Userdto {
	
	@NotNull(message="user name cannot be null")
	private String name;
	private String gender;
	@Min(18)
	@Max(60)
	private int age;
	
	public Userdto( @NotNull(message = "user name cannot be null") String name, String gender,
			@Min(18) @Max(60) int age) {
		super();
	
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
    
}
