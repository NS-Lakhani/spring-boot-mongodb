package com.javachamp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javachamp.collection.Photo;

@Repository
public interface PhotoRepository extends MongoRepository<Photo, String>{

}
