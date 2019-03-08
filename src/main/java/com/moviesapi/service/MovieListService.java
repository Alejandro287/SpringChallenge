package com.moviesapi.service;

import com.moviesapi.model.Page;

public interface MovieListService {

	Page findPage(Long pageNum);

	Page filterBy(Long pageNum, int genreNum, int year);

}
