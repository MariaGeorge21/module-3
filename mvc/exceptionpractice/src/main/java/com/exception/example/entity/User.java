package com.exception.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="USER")
public class User {
						@Id
						@GeneratedValue
						private int id;
						private String name;
						private String gender;
						private int age;
						
						public User() {
							// TODO Auto-generated constructor stub
						}

						public int getId() {
							return id;
						}
						public int setId(int id) {
							return this.id=id;
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

						public User(int id, String name, String gender, int age) {
							super();
							this.id = id;
							this.name = name;
							this.gender = gender;
							this.age = age;
						}

						public static User build(int i, int name2, String gender2, int age2) {
							// TODO Auto-generated method stub
							return null;
						}

						public static User build(int i, String name2, String gender2, int age2) {
							// TODO Auto-generated method stub
							return null;
						}
						
						
					
	

}
