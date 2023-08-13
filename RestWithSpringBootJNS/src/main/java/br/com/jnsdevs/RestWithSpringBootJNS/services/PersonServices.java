package br.com.jnsdevs.RestWithSpringBootJNS.services;

import br.com.jnsdevs.RestWithSpringBootJNS.model.Person;
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

    public Person create(Person person) {
        logger.info("Creating one person!");
        return person;
    }

    public Person update(Person person) {
        logger.info("Updating one person!");
        return person;
    }

    public Person findById(Long id) {
        return null;
    }

    public List<Person> findAll() {
        logger.info("Finding one person!");
        return null;
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");
    }

}
