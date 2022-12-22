package com.nammaflix.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nammaflix.demo.entity.Categories;
import com.nammaflix.demo.entity.CategoriesDTO;

@Repository
public interface CategoryRepo extends JpaRepository<Categories, Long>{
	
	public static final String FIND_CATEGORIES = "SELECT new com.nammaflix.demo.entity.CategoriesDTO(c.categoryId, c.categoryName, c.categoryPriority) FROM Categories c";

	
	@Query(value = FIND_CATEGORIES)
	public List<CategoriesDTO> findCategories();
	
//	<Categories>findAllById(Long categoryId, Pageable pageable);

//	List<Categories>findCategoriesByMovieContentId(Long contentId);
}
