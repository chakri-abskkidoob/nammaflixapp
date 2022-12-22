package com.nammaflix.demo.service;

import java.util.List;
import java.util.Set;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nammaflix.demo.Exception.MoviesNotFoundException;
import com.nammaflix.demo.entity.Movie;
import com.nammaflix.demo.repository.MovieRepo;



@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepo movieRepo;

	@Override
	public List<Movie> getAll() {
		return movieRepo.findAll();
	}

	@Override
	public List<Movie> findBytitle(String title) {
		List<Movie> movies =  movieRepo.findBytitleContaining(title);
		if(movies.isEmpty()) throw new MoviesNotFoundException("No Movies Found");
		else return movies;
	}

	@Override
	public Movie saveMovie(Movie movie) {
		return movieRepo.save(movie);
	}

	@Override
	public Optional<Movie> findById(Long contentId) {
		Optional<Movie> movie = movieRepo.findById(contentId);
		if(movie.isEmpty()) {
			throw new MoviesNotFoundException("No Movie Found");
		}
		else {
			return movie;
		}
	}

	@Override
	public Set<Movie> findByGenre(String genreName) {
		Set<Movie> movies = movieRepo.findByGenreGenreName(genreName);
		return movies;
	}

	@Override
	public Set<Movie> searchMovies(String query) {
		Set<Movie> movies = movieRepo.searchMovies(query);
		return movies;
	}

	@Override
	public Page<Movie> getAllMOviesWithPagination(int offset, int pagesize) {
		return movieRepo.findAll(PageRequest.of(offset, pagesize));
	}

	@Override
	public void giveLikeToMovie(Long contentId) {
		Movie movie = movieRepo.findById(contentId).get();
		movie.setLikes(movie.getLikes()+1);
		movieRepo.save(movie);
		
	}

	@Override
	public void giveDisLikeToMovie(Long contentId) {
		Movie movie = movieRepo.findById(contentId).get();
		movie.setDislikes(movie.getDislikes()+1);
		movieRepo.save(movie);
		
	}

//	@Override
//	public List<Movie> getAllMoviesByCategoryId(Long categoryId) {
//		if(!categoryRepo.existsById(categoryId)) {
//			throw new CategoryNotFoundException("No category found with id : "+categoryId);
//		}
//		return movieRepo.findMovieByCategoriesCategoryId(categoryId);
//	}
	
//	public void get() {
//		List<Movie> s = movieRepo.findAll();
//		List<List<Categories>> cat = s.stream().map(e -> e.getCategories()).toList();
//		s.stream()
//		.filter(Categories::getCategoryId)
//		.collect(Collectors.groupingBy(Categories::getCategoryId));
//	}
}
