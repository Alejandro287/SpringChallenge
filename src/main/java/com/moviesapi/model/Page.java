package com.moviesapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Page {
	
	private int page;
	private int total_results;
	private int total_pages;
	
	private List<MovieList> results; 
	
}
