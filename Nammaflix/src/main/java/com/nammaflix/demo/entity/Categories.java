package com.nammaflix.demo.entity;


import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Categories {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;
	
	private String categoryName;
	private Integer categoryPriority;
	private Boolean deleted;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "movieCategory", 
			joinColumns = @JoinColumn(name = "categoryId", referencedColumnName = "categoryId"),
			inverseJoinColumns = @JoinColumn(name = "contentId", referencedColumnName = "contentId"))
	private Set<Movie> movies = new HashSet<>();

	public Categories(Long categoryId, String categoryName, Integer categoryPriority) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryPriority = categoryPriority;
	}
	
	
}
