package com.nammaflix.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nammaflix.demo.entity.Genre;
import com.nammaflix.demo.repository.GenreRepo;

@Service
public class GenreServiceImpl implements GenreService{
	
	@Autowired
	private GenreRepo genreRepo;

	@Override
	public Genre saveGenre(Genre genre) {
		return genreRepo.save(genre);
	}

}
