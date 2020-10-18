package com.ecomerce.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomerce.webapp.entity.PersonEntity;
import com.ecomerce.webapp.response.PersonResponse;
import com.ecomerce.webapp.service.PersonService;

@RestController
@RequestMapping(path="/webapione")
public class PersonController {

	@Autowired
	PersonService personService;
	
	@GetMapping("/person/{personId}")
	public PersonResponse getPerson(@PathVariable int personId) {
		 return personService.getPersonWithHobby(personId);
	}
	
	@PostMapping("/person")
	public void addPerson(@RequestBody PersonEntity pe) {
		personService.addPerson(pe);
	}
}
