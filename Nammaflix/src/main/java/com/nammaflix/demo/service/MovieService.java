package com.nammaflix.demo.service;

import java.util.List;
import java.util.Set;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.nammaflix.demo.entity.Movie;

public interface MovieService{

	List<Movie> getAll();

	List<Movie> findBytitle(String title);

	Movie saveMovie(Movie movie);

	Optional<Movie> findById(Long contentId);

	Set<Movie> findByGenre(String genreName);

	Set<Movie> searchMovies(String query);

	Page<Movie> getAllMOviesWithPagination(int offset, int pagesize);

	void giveLikeToMovie(Long contentId);

	void giveDisLikeToMovie(Long contentId);

//	List<Movie> getAllMoviesByCategoryId(Long categoryId);
	

}
