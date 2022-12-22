package com.nammaflix.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long fileId;
	
	private String filename;
	
	private String originalFileName;
	
	private String fileType;
	
	private String filePath;
	
	private Long fileSize;
	
//	@Lob
//	private byte[] b;
}
