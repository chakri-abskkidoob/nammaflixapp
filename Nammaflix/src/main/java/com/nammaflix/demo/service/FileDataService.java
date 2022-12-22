package com.nammaflix.demo.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.nammaflix.demo.entity.FileData;

public interface FileDataService {

	FileData uploadFile(MultipartFile file) throws IllegalStateException, IOException;

	ResponseEntity<Resource> downloadFile(Long fileId, HttpServletRequest request) throws IOException;

}
