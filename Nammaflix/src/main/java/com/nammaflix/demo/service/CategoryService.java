package com.nammaflix.demo.service;

import java.util.List;
import java.util.Set;
import java.util.Optional;

import com.nammaflix.demo.entity.Categories;
import com.nammaflix.demo.entity.CategoriesDTO;
import com.nammaflix.demo.entity.Movie;
import com.nammaflix.demo.entity.MovieDTO;

public interface CategoryService {


	Categories findById(Long categoryId);

	Optional<Categories> findByCategoryId(Long categoryId);

	List<CategoriesDTO> findAll();

	Set<Movie> findMoviesByCatgeoryId(Long categoryId);

	List<MovieDTO> getAllMoviesByCategoryId(Long categoryId);

//	Page<Categories> findByCategoryIdAndPagination(Long categoryId, Pageable firstPage);


}
