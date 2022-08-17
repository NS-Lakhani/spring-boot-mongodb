package com.javachamp.serviceImpl;

import java.io.IOException;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javachamp.collection.Photo;
import com.javachamp.repository.PhotoRepository;
import com.javachamp.service.PhotoService;

@Service
public class PhotoServiceImpl implements PhotoService {

	@Autowired
	private PhotoRepository photoRepository;
	
	@Override
	public String save(String originalFilename, MultipartFile image) throws IOException {
		Photo photo = new Photo();
		photo.setName(originalFilename);
		photo.setPhoto(new Binary(BsonBinarySubType.BINARY, image.getBytes()));
		
		return photoRepository.save(photo).getId();
	}

	@Override
	public Photo get(String id) {
		return photoRepository.findById(id).get();
	}

}
