package com.moviesapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "movie_report")
@Data
public class MovieReport {
	@Id
	@Column(name = "id")
    private int id;
	
	@Column(name = "favorite_counter")
    private int favoriteCounter;
	
	@Column(name = "watched_counter")
    private int watchedCounter;
	
	@Column(name = "qualification_counter")
    private int qualificationCounter;
	
	@OneToOne
    @MapsId
    private Movie movie;
	
}
