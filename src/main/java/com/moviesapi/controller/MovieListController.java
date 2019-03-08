package com.moviesapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moviesapi.model.Page;
import com.moviesapi.service.MovieListService;
import com.moviesapi.service.MovieListServiceImpl;

@RestController
public class MovieListController {
	

	private MovieListService movieListService;
	
	@Autowired
	public MovieListController(MovieListServiceImpl movieListServiceImpl){
		this.movieListService = movieListServiceImpl;
	}
	
	@GetMapping("/movieLists/{page}")
	public ResponseEntity<Page> getMoviePage(@PathVariable(value = "page",required = false) Long pageNum){
		
		Page page = movieListService.findPage(pageNum);
		
		if(page == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(page);
	}
	
	
	@GetMapping("/movieLists")
	public ResponseEntity<Page> getMoviePageByGenre(@RequestParam(value = "page",required = false) Long pageNum, @RequestParam(value = "genre",required = false) int genreNum, @RequestParam(value = "year",required = false) int year){
		
		
		Page page = movieListService.filterBy(pageNum, genreNum, year);
		
		if(page == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(page);
	}


}
