package com.moviesapi.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Data;

@Entity(name = "UserMovie_List")
@Table(name = "user_movie")
@Data
public class UserMovie_List {
	
	@EmbeddedId
    private UserMovieId id;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("movieId")
    private Movie movie;
 
    @Column(name = "list")
    private String list; 
    
    @Column(name = "qualification")
    private double qualification;

}
