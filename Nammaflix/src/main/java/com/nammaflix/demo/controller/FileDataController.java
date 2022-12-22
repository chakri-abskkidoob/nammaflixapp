package com.nammaflix.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nammaflix.demo.entity.FileData;
import com.nammaflix.demo.service.FileDataService;

@RestController
public class FileDataController {
	
	@Autowired
	private FileDataService fileDataService;
	
	
	@PostMapping("/file")
	public ResponseEntity<FileData>uploadFile(@RequestParam("file") MultipartFile file)
			throws IllegalStateException, IOException{
		FileData fileData = fileDataService.uploadFile(file);
		
		return new ResponseEntity<>(fileData, HttpStatus.OK);
	}
	
	
	@GetMapping("/file/{fileId}")
	public ResponseEntity<?> downloadFile(@PathVariable Long fileId, HttpServletRequest request) throws IOException{
		ResponseEntity<Resource> file = fileDataService.downloadFile(fileId, request);
		return file;
	}
}
