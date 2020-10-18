package com.ecomerce.webapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecomerce.webapp.entity.PersonEntity;
import com.ecomerce.webapp.repository.PersonRepository;
import com.ecomerce.webapp.response.PersonResponse;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository personRepository;
	
	RestTemplate restTemplate = new RestTemplate();
	
	
	public  void addPerson(PersonEntity person) {
		personRepository.save(person);
	}
	
	public Optional<PersonEntity> getPerson(int pid) {
		return personRepository.findById(pid);
	}
	
	public List<PersonEntity> getAllPerson() {
		return personRepository.findAll();
	}
	
	public PersonResponse getPersonWithHobby(int pid) {
		
		String uri = "http://localhost:8082/webapitwo/hobby/{personId}";
		
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("personId", pid);
		
		String result = restTemplate.getForObject(uri, String.class,params);
		
		PersonResponse pres = new PersonResponse();
		PersonEntity pe = personRepository.findById(pid).get();
		
		pres.setPersonId(pe.getPersonId());
		pres.setName(pe.getName());
		pres.setAge(pe.getAge());
		pres.setHobby(result);
		
		return pres;
	}
}
