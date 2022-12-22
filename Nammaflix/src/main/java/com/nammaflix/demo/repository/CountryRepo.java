package com.nammaflix.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nammaflix.demo.entity.Country;

@Repository
public interface CountryRepo extends JpaRepository<Country, Long>{

}
