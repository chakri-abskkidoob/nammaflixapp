package com.nammaflix.demo.controller;


import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nammaflix.demo.entity.Genre;
import com.nammaflix.demo.entity.Movie;
import com.nammaflix.demo.service.MovieService;

@CrossOrigin(origins = "*")
@RestController
public class MovieController {

	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/getallmovies")
	public List<Movie> getAllMovies(){
		return movieService.getAll();
	}
	
	@GetMapping("/getallmovies/{offset}/{pagesize}")
	public Page<Movie> getAllMoviesWithPagination(@PathVariable int offset, @PathVariable int pagesize){
		return movieService.getAllMOviesWithPagination(offset, pagesize);
	}
	
	@GetMapping("/search")
	public Set<Movie> searchMovies(@RequestParam("query") String query) {
		
		return movieService.searchMovies(query);
	}
	
	@PostMapping("/saveMovie")
	public Movie saveMOvie(@RequestBody Movie movie) {
		return movieService.saveMovie(movie);
	}
	
//	here we can fetch the movie by movie id
	@GetMapping("/get/{contentId}")
	public Optional<Movie> getMovieById(@PathVariable Long contentId) {
		Optional<Movie> movie = movieService.findById(contentId);
		return movie;
	}
	
	@GetMapping("/morelikethis/{contentId}")
	public Object[] sameGenreTypeMovies(@PathVariable Long contentId){
		Optional<Movie> movie = movieService.findById(contentId);
		Set<Genre> genre = movie.get().getGenre();
		Object[] movies = genre.stream()
				.map(e -> movieService.findByGenre(e.getGenreName()))
				.distinct()
				.toArray();
		return movies;
	}
	
	@PutMapping("/like/{contentId}")
	public ResponseEntity<Movie> giveLikeToMovie(@PathVariable Long contentId){
		movieService.giveLikeToMovie(contentId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/dislike/{contentId}")
	public ResponseEntity<Movie>giveDisLikeToMovie(@PathVariable Long contentId){
		movieService.giveDisLikeToMovie(contentId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
//	@GetMapping("/{categoryId}/categoryId")
//	public List<Movie>getAllMoviesByCategoryId(@PathVariable Long categoryId){
//		return movieService.getAllMoviesByCategoryId(categoryId);
//	}
}
