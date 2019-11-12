package br.com.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.restapi.data.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
