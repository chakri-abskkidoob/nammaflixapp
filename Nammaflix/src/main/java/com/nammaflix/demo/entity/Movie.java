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
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long contentId;
	private String title;
	private String description;
	private Boolean premium;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "filedata_fk", referencedColumnName = "contentId")
	private Set<FileData> files;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "movieCasting",
				joinColumns = @JoinColumn(name = "contentId", referencedColumnName = "contentId"),
				inverseJoinColumns = @JoinColumn(name = "castId", referencedColumnName = "castId"))
	private Set<Cast> cast = new HashSet<>();
	private Double rating;
	private String dateOfRelease;
	private String duration;
	private Long likes;
	private Long dislikes;
	private Boolean deleted;
	private String createdTime;
	private String modifiedTime;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "movieGenre",
				joinColumns = @JoinColumn(name = "contentId", referencedColumnName = "contentId"),
				inverseJoinColumns = @JoinColumn(name = "genreId", referencedColumnName = "genreId"))
	private Set<Genre> genre = new HashSet<>();
	
	
	
	
	
//	@ManyToMany(mappedBy = "movies", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	private Set<Categories> categories = new HashSet<>();
	

}
