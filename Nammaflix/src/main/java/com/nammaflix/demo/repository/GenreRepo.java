package com.nammaflix.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nammaflix.demo.entity.Genre;

@Repository
public interface GenreRepo extends JpaRepository<Genre, Long>{

}
