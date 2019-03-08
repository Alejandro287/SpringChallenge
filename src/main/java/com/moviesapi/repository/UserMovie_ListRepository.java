package com.moviesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviesapi.model.UserMovieId;
import com.moviesapi.model.UserMovie_List;

@Repository("userMovie_ListRepository")
public interface UserMovie_ListRepository extends JpaRepository<UserMovie_List, UserMovieId>  {
	
}