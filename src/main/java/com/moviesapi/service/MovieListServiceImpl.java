package com.moviesapi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.moviesapi.model.Page;

@Service("movieListService") 
public class MovieListServiceImpl implements MovieListService {
	
	@Override
	public Page findPage(Long pageNum) {
		RestTemplate restTemplate = new RestTemplate();
        Page page = restTemplate.getForObject("https://api.themoviedb.org/3/discover/movie?page="+pageNum+"&api_key=503140563829c178a12567a8e04fa3bf", Page.class);
		return page;
	}

	@Override
	public Page filterBy(Long pageNum, int genreNum, int year) {
		RestTemplate restTemplate = new RestTemplate();
        Page page = restTemplate.getForObject("https://api.themoviedb.org/3/discover/movie?with_genres="+genreNum+"&primary_release_year="+year+"&page="+pageNum+"&api_key=503140563829c178a12567a8e04fa3bf", Page.class);
		return page;
	}
	
}
