package br.com.jnsdevs.RestWithSpringBootJNS.controllers;

import br.com.jnsdevs.RestWithSpringBootJNS.data.vo.v1.PersonVO;
import br.com.jnsdevs.RestWithSpringBootJNS.services.PersonServices;
import br.com.jnsdevs.RestWithSpringBootJNS.util.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.jnsdevs.RestWithSpringBootJNS.util.MediaType.APPLICATION_YML;

/**
 * @Autor Jairo Nascimento
 * @Created 13/08/2023 - 11:33
 */

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonServices personServices;

    @GetMapping(produces = {
            MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML,
            APPLICATION_YML})
    public List<PersonVO> findAll() {
        return personServices.findAll();
    }

    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON,
                    MediaType.APPLICATION_XML,
                    APPLICATION_YML})
    public PersonVO findById(@PathVariable(value = "id") Long id) {
        return personServices.findById(id);
    }

    @PostMapping(
            produces = {MediaType.APPLICATION_JSON,
                    MediaType.APPLICATION_XML,
                    APPLICATION_YML},
            consumes = {MediaType.APPLICATION_JSON,
                    MediaType.APPLICATION_XML,
                    APPLICATION_YML})
    public PersonVO create(@RequestBody PersonVO person) {
        return personServices.create(person);
    }

    @PutMapping(
            produces = {MediaType.APPLICATION_JSON,
                    MediaType.APPLICATION_XML,
                    APPLICATION_YML},
            consumes = {MediaType.APPLICATION_JSON,
                    MediaType.APPLICATION_XML,
                    APPLICATION_YML})
    public PersonVO update(@RequestBody PersonVO person) {
        return personServices.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        personServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
