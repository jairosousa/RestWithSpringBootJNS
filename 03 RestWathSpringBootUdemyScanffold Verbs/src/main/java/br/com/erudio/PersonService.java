package br.com.erudio;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service
public class PersonService {

	private final AtomicLong counter = new AtomicLong();
	
	public Person create(Person person) {
		return person;
	}
	
	public Person update(Person person) {
		return person;
	}
	
	public void delete(String id) {
		System.out.println("Excluio a person id: " + id);
	}

	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Jairo");
		person.setLasttName("Nascimento");
		person.setAddres("Uberlândia - MG - Brasil");
		person.setGender("Male");
		return person;
	}

	public List<Person> findAll() {
		List<Person> persons = new ArrayList<>();

		for (int i = 0; i < 8; i++) {
			Person p = mockPerson(i);
			persons.add(p);
		}

		return persons;
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person0" + (i + 1));
		person.setLasttName("LanstName0" + (i + 1));
		person.setAddres("Brasil" + (i + 1));
		person.setGender(((i + 1) % 2 == 0) ? "Male" : "Female");
		return person;
	}
}
