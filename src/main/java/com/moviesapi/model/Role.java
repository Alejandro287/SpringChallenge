package com.moviesapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="role")
@Data
public class Role {

	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name="role_id")
	 private int id;
	 
	 @Column(name="role")
	 private String role;
	 
	 public Role(int id, String role) {
		this.id=id; 
		this.role = role; 
	}

}