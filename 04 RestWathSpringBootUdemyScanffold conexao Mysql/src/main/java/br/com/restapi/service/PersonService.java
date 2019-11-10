package br.com.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restapi.exception.ResourceNotFoundException;
import br.com.restapi.model.Person;
import br.com.restapi.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	public List<Person> findAll() {
		return repository.findAll();
	}

	public Person findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não encontramos nenhum registro para esse id"));
	}

	public Person create(Person person) {
		return repository.save(person);
	}

	public Person update(Person person) {
		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Não encontramos nenhum registro para esse id"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLasttName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return repository.save(entity);
	}

	public void delete(Long id) {
		Person entity = findById(id);
		repository.delete(entity);
	}

}
