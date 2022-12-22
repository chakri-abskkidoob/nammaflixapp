package com.nammaflix.demo.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.net.HttpHeaders;
import com.nammaflix.demo.entity.FileData;
import com.nammaflix.demo.repository.FileDataRepo;

@Service
public class FileDataServiceImpl implements FileDataService{
	
	@Autowired
	private FileDataRepo fileDataRepo;
	
	private final String FOLDER_PATH = "C:/chakri/chakris";

	@Override
	public FileData uploadFile(MultipartFile file) throws IllegalStateException, IOException {
		String filePath = FOLDER_PATH+file.getOriginalFilename();
		
		String extension = FilenameUtils
				.getExtension(file.getOriginalFilename());
		FileData fileData = new FileData();
		Long name = System.currentTimeMillis();
		String s = name
				.toString()
				.concat("."+extension);
		
		fileData.setFilename(s);
		fileData.setOriginalFileName(file.getOriginalFilename());
		fileData.setFileType(file.getContentType());
		fileData.setFilePath(filePath);
		fileData.setFileSize(file.getSize());
//		fileData.setB(file.getBytes());
		
		fileDataRepo.save(fileData);
		file.transferTo(new File(filePath));
		
		return fileData;
		
	}

	@Override
	public ResponseEntity<Resource> downloadFile(Long fileId, HttpServletRequest request) throws IOException {
		FileData fileData = fileDataRepo.findById(fileId).get();
		String filePath = fileData.getFilePath();
		Path normalize = Paths
				.get(filePath)
				.toAbsolutePath()
				.normalize();
		Path resolve = normalize
				.resolve(fileData.getFilePath());
		Resource urlResource = new UrlResource(resolve.toUri());
		String mimeType = request
				.getServletContext()
				.getMimeType(urlResource.getFile().getAbsolutePath());
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(mimeType))
				.header(HttpHeaders.CONTENT_DISPOSITION,
						"attachment; filename=\"" + fileData.getOriginalFileName() + "\"")
				.body(urlResource);

	}

}
