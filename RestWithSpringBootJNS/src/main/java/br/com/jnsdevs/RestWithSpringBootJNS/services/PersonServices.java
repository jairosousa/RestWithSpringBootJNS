package br.com.jnsdevs.RestWithSpringBootJNS.services;

import br.com.jnsdevs.RestWithSpringBootJNS.data.vo.v1.PersonVO;
import br.com.jnsdevs.RestWithSpringBootJNS.exceptions.ResourceNotFoundException;
import br.com.jnsdevs.RestWithSpringBootJNS.mapper.MMapper;
import br.com.jnsdevs.RestWithSpringBootJNS.model.Person;
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

    public PersonVO create(PersonVO personVO) {
        logger.info("Creating one person!");
        var entity = MMapper.parseObject(personVO, Person.class);
        return MMapper.parseObject(personRepository.save(entity), PersonVO.class);
    }

    public PersonVO update(PersonVO personVO) {
        logger.info("Updating one person!");

        var entityVO = findById(personVO.getId());

        entityVO.setFirstName(personVO.getFirstName());
        entityVO.setLastName(personVO.getLastName());
        entityVO.setAddress(personVO.getAddress());
        entityVO.setGender(personVO.getGender());

        var entity = MMapper.parseObject(entityVO, Person.class);

        return MMapper.parseObject(personRepository.save(entity), PersonVO.class);
    }

    public PersonVO findById(Long id) {
        var person = personRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No record found for this ID"));
        return MMapper.parseObject(person, PersonVO.class);
    }

    public List<PersonVO> findAll() {
        logger.info("Finding one person!");
        return MMapper.parseListObject(personRepository.findAll(), PersonVO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");
        var entity = findById(id);
        personRepository.delete(MMapper.parseObject(entity, Person.class));
    }

}
