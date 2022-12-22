package com.nammaflix.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nammaflix.demo.Exception.CategoryNotFoundException;
import com.nammaflix.demo.entity.Categories;
import com.nammaflix.demo.entity.CategoriesDTO;
import com.nammaflix.demo.entity.Movie;
import com.nammaflix.demo.entity.MovieDTO;
import com.nammaflix.demo.repository.CategoryRepo;
import com.nammaflix.demo.repository.MovieRepo;


@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private MovieRepo movieRepo;


	@Override
	public Categories findById(Long categoryId) {
		return categoryRepo.findById(categoryId).get();
	}

	@Override
	public Optional<Categories> findByCategoryId(Long categoryId) {
		Optional<Categories> category = categoryRepo.findById(categoryId);
		if(category.isEmpty()) {
			throw new CategoryNotFoundException("Category Doesn't Exist with "+categoryId);
		}
		return category;
	}

	@Override
	public List<CategoriesDTO> findAll() {
		return categoryRepo.findCategories();
	}

	@Override
	public Set<Movie> findMoviesByCatgeoryId(Long categoryId) {
		Optional<Categories> category = categoryRepo.findById(categoryId);
		return category.get().getMovies();
//		return movieRepo.movies(categoryId);
	}

	@Override
	public List<MovieDTO> getAllMoviesByCategoryId(Long categoryId) {
		if(!categoryRepo.existsById(categoryId)) {
			throw new CategoryNotFoundException("No category found with id : "+categoryId);
		}
		List<Movie> movies =  movieRepo.findMovieByCategoryId(categoryId);
		List<MovieDTO> mdto = new ArrayList<>();
		for(Movie e : movies) {
			mdto.add(new MovieDTO(e.getContentId(), e.getTitle(), e.getDescription()));
		}
		return mdto;
	}


//	@Override
//	public Page<Categories> findByCategoryIdAndPagination(Long categoryId, Pageable firstPage) {
//		categoryRepo.findAllById(categoryId, firstPage);
//		return null;
//	}
	
	
	
}
