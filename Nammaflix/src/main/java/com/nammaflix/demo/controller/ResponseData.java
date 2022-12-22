package com.nammaflix.demo.controller;

public class ResponseData {
	
	private Long fileId;
	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	private String downloadURL;
	private String contentType;
	private Long size;

//	public ResponseData(String fileName, String downloadURL, String contentType, long size) {
//		// TODO Auto-generated constructor stub
//	}

	public ResponseData(Long fileId, String downloadURL, String contentType, Long size) {
		super();
		this.fileId = fileId;
		this.downloadURL = downloadURL;
		this.contentType = contentType;
		this.size = size;
	}


	public String getDownloadURL() {
		return downloadURL;
	}

	public void setDownloadURL(String downloadURL) {
		this.downloadURL = downloadURL;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}
	

}
