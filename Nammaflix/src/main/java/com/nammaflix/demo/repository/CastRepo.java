package com.nammaflix.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nammaflix.demo.entity.Cast;

@Repository
public interface CastRepo extends JpaRepository<Cast, Long>{

}
