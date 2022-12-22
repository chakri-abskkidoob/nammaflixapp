package com.nammaflix.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nammaflix.demo.entity.FileData;

@Repository
public interface FileDataRepo extends JpaRepository<FileData, Long>{

}
