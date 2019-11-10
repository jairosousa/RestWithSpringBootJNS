package br.com.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.restapi.model.Person;
import br.com.restapi.service.PersonService;

@RestController
@RequestMapping("person")
public class PersonController {

	@Autowired
	private PersonService services;

	@GetMapping
	public List<Person> finAll() {

		return services.findAll();
	}

	@GetMapping(value = "/{id}")
	public Person findById(@PathVariable("id") Long id) {

		return services.findById(id);
	}

	@PostMapping
	public Person create(@RequestBody Person person) {
		return services.create(person);
	}

	@PutMapping
	public Person update(@RequestBody Person person) {
		return services.update(person);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		services.delete(id);
		return ResponseEntity.ok().build();
	}
}
