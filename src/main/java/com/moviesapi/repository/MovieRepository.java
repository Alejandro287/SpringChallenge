package com.moviesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviesapi.model.Movie;

@Repository("movieRepository")
public interface MovieRepository extends JpaRepository<Movie, Long> {

}