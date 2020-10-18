package com.ecomerce.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomerce.webapp.entity.PersonEntity;
import com.ecomerce.webapp.service.PersonService;

@RestController
@RequestMapping(path="/webapione/admin")
public class AdminController {
	
	@Autowired
	PersonService personService;
	
	@GetMapping("/persons")
	public List<PersonEntity> getPerson() {
		 return personService.getAllPerson();
	}
	
	@DeleteMapping("/persons/{persoId}")
	public String deletePerson(@PathVariable int personId) {
		 return "Delete for :" +personId;
	}

}
