package br.com.jnsdevs.RestWithSpringBootJNS.services;

import br.com.jnsdevs.RestWithSpringBootJNS.controllers.PersonController;
import br.com.jnsdevs.RestWithSpringBootJNS.data.vo.v1.PersonVO;
import br.com.jnsdevs.RestWithSpringBootJNS.exceptions.ResourceNotFoundException;
import br.com.jnsdevs.RestWithSpringBootJNS.mapper.DozerMapper;
import br.com.jnsdevs.RestWithSpringBootJNS.model.Person;
import br.com.jnsdevs.RestWithSpringBootJNS.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
        var entity = DozerMapper.parseObject(personVO, Person.class);
        PersonVO vo = DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public PersonVO update(PersonVO personVO) {
        logger.info("Updating one person!");

        var entityVO = findById(personVO.getKey());

        entityVO.setFirstName(personVO.getFirstName());
        entityVO.setLastName(personVO.getLastName());
        entityVO.setAddress(personVO.getAddress());
        entityVO.setGender(personVO.getGender());

        var entity = DozerMapper.parseObject(entityVO, Person.class);

        PersonVO vo = DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
        return vo;
    }

    public PersonVO findById(Long id) {
        var person = personRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No record found for this ID"));
        PersonVO vo = DozerMapper.parseObject(person, PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return vo;
    }

    public List<PersonVO> findAll() {
        logger.info("Finding one person!");
        List<PersonVO> personVOS = DozerMapper.parseListObject(personRepository.findAll(), PersonVO.class);
        personVOS
                .stream()
                .forEach(vo -> vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel()));
        return personVOS;
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");
        var entity = findById(id);
        personRepository.delete(DozerMapper.parseObject(entity, Person.class));
    }

}
