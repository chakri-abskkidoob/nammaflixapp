package com.nammaflix.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nammaflix.demo.entity.Cast;
import com.nammaflix.demo.repository.CastRepo;

@RestController
public class CastController {
	
	@Autowired
	private CastRepo castRepo;
	
	@PostMapping("/savecast")
	public Cast saveCast(@RequestBody Cast cast) {
		castRepo.save(cast);
		return cast;
	}

}
