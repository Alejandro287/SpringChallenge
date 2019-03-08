package com.moviesapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.moviesapi.model.Movie;
import com.moviesapi.model.UserMovieId;
import com.moviesapi.model.UserMovie_List;
import com.moviesapi.repository.MovieRepository;
import com.moviesapi.repository.UserMovie_ListRepository;

@Service("movieService") 
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	UserMovie_ListRepository userMovie_ListRepository;
	
	public Movie findOne(Long id) {
		RestTemplate restTemplate = new RestTemplate();
        Movie movie = restTemplate.getForObject("https://api.themoviedb.org/3/movie/"+id+"?api_key=503140563829c178a12567a8e04fa3bf", Movie.class);
		return movie;
	}
	
	public UserMovie_List save(UserMovie_List userMovie_List) {
		
		/*Movie movie = findOne(userMovie_List.getId().getMovieId());
		List<UserMovie_List> usersList = movie.getUsers();
		if (usersList == null) {
			usersList = new ArrayList <UserMovie_List> ();
			usersList.add(userMovie_List);
			movie.setUsers(usersList);
		}else {
			usersList.add(userMovie_List);
			movie.setUsers(usersList);
		}*/
		return userMovie_ListRepository.save(userMovie_List);
	}
	
	public UserMovie_List addToList(Long movieId, String listType, Long userId) {	
		UserMovieId userMovieId = new UserMovieId();
		userMovieId.setMovieId(movieId);
		userMovieId.setUserId(userId);
		UserMovie_List userMovie_List = new UserMovie_List (); 
		userMovie_List.setId(userMovieId);
		userMovie_List.setList(listType);
		return save(userMovie_List);
	}

}
