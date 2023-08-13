package br.com.jnsdevs.RestWithSpringBootJNS.controllers;

import br.com.jnsdevs.RestWithSpringBootJNS.model.Person;
import br.com.jnsdevs.RestWithSpringBootJNS.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 13/08/2023 - 11:33
 */

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices personServices;


    @GetMapping
    public List<Person> findAll() {
        return personServices.findAll();
    }

    @GetMapping(value = "/{id}")
    public Person findById(@PathVariable(value = "id") Long id) {
        return personServices.findById(id);
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person) {
        return personServices.create(person);
    }

    @PutMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person) {
        return personServices.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        personServices.delete(id);
    }
}
