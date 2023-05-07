package com.exception.student.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int  id;
	private String sname;
	private int tmarks;
	public int getId() {
		return id;
	}
	public StudentEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public StudentEntity(int id, String sname, int tmarks) {
		super();
		this.id = id;
		this.sname = sname;
		this.tmarks = tmarks;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getTmarks() {
		return tmarks;
	}
	public void setTmarks(int tmarks) {
		this.tmarks = tmarks;
	}
	

}
