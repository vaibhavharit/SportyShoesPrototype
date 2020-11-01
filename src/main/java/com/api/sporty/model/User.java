package com.api.sporty.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//Table - User
@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@ToString
public class User {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String role;

	public User() {

	}
		
	public User(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}
	
	public User(int id, String name, String role) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
