package com.javachamp.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.javachamp.collection.Photo;

public interface PhotoService {

	String save(String originalFilename, MultipartFile image) throws IOException;

	Photo get(String id);

}
