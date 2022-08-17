package com.javachamp.controller;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javachamp.collection.Person;
import com.javachamp.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@PostMapping
	public String save(@RequestBody Person person) {
		return personService.save(person);
	}
	
	@GetMapping
	public List<Person> findAllPersons() {
		return personService.findAll();
	}
	
	@GetMapping("/{name}")
	public List<Person> getPersonByName(@PathVariable String name) {
		return personService.getPersonByName(name);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		personService.delete(id);
	}
	
	@GetMapping("/age/{min}/{max}")
	public List<Person> getPersonByAge(@PathVariable Integer min, @PathVariable Integer max) {
		return personService.getPersonByAge(min, max);
	}
	
	@GetMapping("/search")
	public Page<Person> search(@RequestParam(required = false) String name,
								@RequestParam(required = false) Integer minAge,
								@RequestParam(required = false) Integer maxAge,
								@RequestParam(required = false) String city,
								@RequestParam(defaultValue = "0") int page,
								@RequestParam(defaultValue = "5") int size) {
		
		Pageable pageable = PageRequest.of(page, size);
		
		return personService.search(name, minAge, maxAge, city, pageable);
		
	}
	
	@GetMapping("/getOldestPersonByCity")
	public List<Document> getOldestPersonByCity() {
		return personService.getOldestPersonByCity();
	}
	
	@GetMapping("/getPopulationByCity")
	public List<Document> getPopulationByCity() {
		return personService.getPopulationByCity();
	}
	
}
