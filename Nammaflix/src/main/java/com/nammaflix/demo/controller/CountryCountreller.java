package com.nammaflix.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nammaflix.demo.entity.Country;
import com.nammaflix.demo.repository.CountryRepo;

@RestController
@CrossOrigin("*")
public class CountryCountreller {
	
	@Autowired CountryRepo countryRepo;
	
	
	@PostMapping("/save/country")
	public ResponseEntity<Country> saveCountry(@RequestBody Country country){
		countryRepo.save(country);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/get/country")
	public List<Country> getAllCountries(){
		return countryRepo.findAll();
	}
	
	@PutMapping("/updatecountry/{countryId}")
	public Country updateCountry(@PathVariable Long countryId, @RequestBody Country country) {
		Country c = countryRepo.findById(countryId).get();
		c.setCountryName(country.getCountryName());
		return countryRepo.save(c);
	}
}
