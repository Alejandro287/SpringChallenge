package com.moviesapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moviesapi.model.Movie;
import com.moviesapi.model.UserMovie_List;
import com.moviesapi.service.MovieServiceImpl;

@RestController
public class MovieController {
	
	@Autowired
	private MovieServiceImpl movieServiceImpl;
	
	
	@GetMapping("/movies/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable(value="id") Long movieId){
		
		Movie movie = movieServiceImpl.findOne(movieId);
		
		if(movie==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(movie);
	}
	
	
	@PostMapping("/movies")
	public ResponseEntity<UserMovie_List> addMovieToList(@RequestParam(value="movieId") Long movieId, @RequestParam(value = "list",required = false) String listType, @RequestParam(value = "userId",required = false) Long userId){
		
		UserMovie_List userMovie_List = movieServiceImpl.addToList(movieId, listType, userId);
		
		if(userMovie_List==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(userMovie_List);
	}
	
	
}
