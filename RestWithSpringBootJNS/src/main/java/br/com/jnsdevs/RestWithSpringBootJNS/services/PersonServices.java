package br.com.jnsdevs.RestWithSpringBootJNS.services;

import br.com.jnsdevs.RestWithSpringBootJNS.data.vo.v1.PersonVO;
import br.com.jnsdevs.RestWithSpringBootJNS.exceptions.ResourceNotFoundException;
import br.com.jnsdevs.RestWithSpringBootJNS.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

/**
 * @Autor Jairo Nascimento
 * @Created 13/08/2023 - 11:34
 */

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    private PersonRepository personRepository;

    public PersonVO create(PersonVO person) {
        logger.info("Creating one person!");
        return personRepository.save(person);
    }

    public PersonVO update(PersonVO person) {
        logger.info("Updating one person!");

        var entity = findById(person.getId());

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(entity);
    }

    public PersonVO findById(Long id) {
        return personRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No record found for this ID"));
    }

    public List<PersonVO> findAll() {
        logger.info("Finding one person!");
        return personRepository.findAll();
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");
        var entity = findById(id);

        personRepository.delete(entity);
    }

}
