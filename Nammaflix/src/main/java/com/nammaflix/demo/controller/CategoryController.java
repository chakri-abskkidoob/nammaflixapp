package com.nammaflix.demo.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nammaflix.demo.entity.CategoriesDTO;
import com.nammaflix.demo.entity.Movie;
import com.nammaflix.demo.entity.MovieDTO;
import com.nammaflix.demo.service.CategoryService;

@CrossOrigin(origins = "*")
@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/getallcategories")
	public List<CategoriesDTO> getAll(){
		return categoryService.findAll();
	}
	
	
	@GetMapping("/category/{categoryId}")
	public Set<Movie>findMoviesByCategoryId(@PathVariable Long categoryId){
		return categoryService.findMoviesByCatgeoryId(categoryId);
	}
	
	
	@GetMapping("/categoryid/{categoryId}")
	public List<MovieDTO>getAllMoviesByCategoryId(@PathVariable Long categoryId){
		return categoryService.getAllMoviesByCategoryId(categoryId);
	}
	
	
//	@GetMapping("/search")
//	public Set<Movie> searchMovies(@RequestParam("query") String query) {
//		
//		return movieService.searchMovies(query);
//	}
	
//	@GetMapping("/category/{categoryId}")
//	public List<Movie> getcategory(@PathVariable Long categoryId) {
//		return categoryService.findByCategoryId(categoryId);
//	}
	
	
//	@GetMapping("/category/{categoryId}/{offset}/{pagesize}")
//	public Page<Categories> getcategory(@PathVariable Long categoryId,
//					@PathVariable int offset,
//					@PathVariable int pagesize) {
//		Pageable firstPage = PageRequest.of(offset, pagesize);
//		Page<Categories> pages = categoryService.findByCategoryIdAndPagination(categoryId, firstPage);
//		return pages;
//	}
}
