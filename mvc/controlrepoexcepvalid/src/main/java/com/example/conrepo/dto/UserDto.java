package com.example.conrepo.dto;

public class UserDto {
	private String name;
	private int age;
	public UserDto() {
		// TODO Auto-generated constructor stub
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
	public UserDto(String name, int age) {
		super();
	
		this.name = name;
		this.age = age;
	}
	

}


