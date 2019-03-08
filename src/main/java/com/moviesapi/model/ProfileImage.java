package com.moviesapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "profile_image")
@Data
public class ProfileImage {
	
	@Id
	@Column(name = "id")
    private Long id;
	
	@Column(name = "image_name")
	private String imageName;
	
	@OneToOne
    @MapsId
    private User user;
	

}
