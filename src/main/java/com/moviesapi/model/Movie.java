package com.moviesapi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "movie")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {
	
	@Id
	@Column (name = "movie_id")
	private long id; 
	
	@Column (name = "title")
	private String title; 
	
	@Column (name = "overview", columnDefinition = "TEXT")
	private String overview; 
	
	@OneToMany(
	        mappedBy = "movie",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	 private List<UserMovie_List> users = new ArrayList<>();
	 
	 @OneToOne(fetch = FetchType.LAZY,
	            cascade =  CascadeType.ALL,
	            mappedBy = "movie")
	 private MovieReport movieReport;

}
