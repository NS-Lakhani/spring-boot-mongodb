package com.javachamp.service;

import java.util.List;

import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.javachamp.collection.Person;

public interface PersonService {

	String save(Person person);

	List<Person> getPersonByName(String name);

	void delete(String id);

	List<Person> getPersonByAge(Integer min, Integer max);

	List<Person> findAll();

	Page<Person> search(String name, Integer minAge, Integer maxAge, String city, Pageable pageable);

	List<Document> getOldestPersonByCity();

	List<Document> getPopulationByCity();

}
