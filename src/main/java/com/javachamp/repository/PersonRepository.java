package com.javachamp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.javachamp.collection.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String>{

	List<Person> findByFirstName(String name);

	@Query(value = "{'age':{$gt:?0, $lt:?1}}",
			fields = "{addresses: 0}")
	List<Person> findByAgeBetween(Integer min, Integer max);
}
