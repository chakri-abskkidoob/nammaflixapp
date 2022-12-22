package com.nammaflix.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriesDTO {

	private Long categoryId;
	private String categoryName;
	private Integer categoryPrioroty;
}
