package com.example.conrepo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

@Entity
public class User {
	@Id
	@GeneratedValue
	private int id;
	@NotNull(message="invalid type")
	private String name;
	@Min(18)
	@Max(60)
	private int age;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public User(int id, @NotNull(message = "invalid type") String name, @Min(18) @Max(60) int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	

}
