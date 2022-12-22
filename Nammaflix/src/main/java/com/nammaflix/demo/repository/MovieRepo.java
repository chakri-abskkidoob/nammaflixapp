package com.nammaflix.demo.repository;

import java.util.Set;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nammaflix.demo.entity.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long>{

	List<Movie> findBytitleContaining(String title);

	Set<Movie> findByGenreGenreName(String genreName);
	
	@Query("SELECT m from Movie m WHERE "+
			"m.title LIKE CONCAT('%', :query, '%')"+
			"Or m.description LIKE CONCAT('%', :query, '%')")
	Set<Movie> searchMovies(String query);
	
//	@Query("SELECT * FROM Movie m JOIN MovieCategory n ON n.contentId = m.contentId WHERE n.categoryId = :categoryId")
//	Set<Movie>movies();
	
	
	@Query(value = "SELECT m.* FROM movie_category n "
			+ " Join movie m on m.content_id = n.content_id"
			+ " where n.category_id = ?1",
			nativeQuery = true)
	List<Movie>findMovieByCategoryId(Long categoryId);
	
	
//	SELECT * FROM movie_category n "
//	+ " Join movie m on m.content_id = n.content_id"
//	+ " where n.category_id = ?1",
//	nativeQuery = true
	
//	List<MovieDTO>findMoviesByCategoriesCategoryId(Long categoryId);
	
	
	
//	@Query(value = "SELECT new com.nammaflix.demo.entity.MovieDTO(m.contentId, m.title, m.description) FROM categories c \r\n"
//			+ "JOIN movie_category n ON n.category_id = c.category_id\r\n"
//			+ "JOIN movie m ON m.content_id = n.content_id\r\n"
//			+ "WHERE c.category_id = :categoryId",
//			nativeQuery = true)

}
