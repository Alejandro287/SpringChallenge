package com.moviesapi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {
	
	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public User() {}
		

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id; 
	
	@NotNull
    @Size(max = 65)
	@Column (name = "name")
	private String name; 
	
	@NotNull
    @Email
    @Size(max = 100)
	@Column (name = "email", unique = true)
	private String email;
	
	@NotNull
    @Size(max = 128)
	@Column (name = "password")
	private String password; 	
	
	@Column (name = "description", columnDefinition = "TEXT")
	private String description; 
	
	
	@Column(name = "active")
	 private int active;
	
	@OneToMany(
	        mappedBy = "user",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<UserMovie_List> movies = new ArrayList<>();
	
	@OneToOne(fetch = FetchType.LAZY,
	            cascade =  CascadeType.ALL,
	            mappedBy = "user")
	private ProfileImage profileImage;

	
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_role", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Role> roles;
	
}
