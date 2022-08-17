package com.javachamp.collection;

import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "photo")
public class Photo {
	
	private String id;
	private String name;
	private Binary photo;

}
