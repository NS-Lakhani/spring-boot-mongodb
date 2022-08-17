package com.javachamp.collection;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "person")
@JsonInclude(value = Include.NON_NULL)
public class Person {

	@Id
	private String personId;
	private String firstName;
	private String lastName;
	private Integer age;
	private List<String> hobbies;
	private List<Address> addresses;
	
}
