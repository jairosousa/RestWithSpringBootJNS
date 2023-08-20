package br.com.jnsdevs.RestWithSpringBootJNS.services;

import br.com.jnsdevs.RestWithSpringBootJNS.controllers.PersonController;
import br.com.jnsdevs.RestWithSpringBootJNS.data.vo.v1.PersonVO;
import br.com.jnsdevs.RestWithSpringBootJNS.exceptions.RequiredObjectIsNullException;
import br.com.jnsdevs.RestWithSpringBootJNS.exceptions.ResourceNotFoundException;
import br.com.jnsdevs.RestWithSpringBootJNS.mapper.DozerMapper;
import br.com.jnsdevs.RestWithSpringBootJNS.model.Person;
import br.com.jnsdevs.RestWithSpringBootJNS.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import java.util.Objects;
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

    @Autowired
    private PagedResourcesAssembler<PersonVO> assembler;

    public PersonVO create(PersonVO personVO) {
        logger.info("Creating one person!");

        if (Objects.isNull(personVO)) throw new RequiredObjectIsNullException();

        var entity = DozerMapper.parseObject(personVO, Person.class);
        PersonVO vo = DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public PersonVO update(PersonVO personVO) {
        logger.info("Updating one person!");

        if (Objects.isNull(personVO)) throw new RequiredObjectIsNullException();

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

    public PagedModel<EntityModel<PersonVO>> findAll(Pageable pageable) {
        logger.info("Finding one person!");
        Page<Person> personPage = personRepository.findAll(pageable);

        var personVospage = personPage.map(p -> DozerMapper.parseObject(p, PersonVO.class))
                .map(vo -> vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel()));

        Link link = linkTo(
                methodOn(PersonController.class)
                        .findAll(pageable.getPageNumber(),
                                pageable.getPageSize(),
                                "asc")).withSelfRel();

        return assembler.toModel(personVospage, link);
    }

    @Transactional
    public PersonVO disablePerson(Long id) {

        logger.info("Disabling one person!");

        personRepository.disablePerson(id);

        var entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var vo = DozerMapper.parseObject(entity, PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return vo;
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");
        var entity = findById(id);
        personRepository.delete(DozerMapper.parseObject(entity, Person.class));
    }

}
