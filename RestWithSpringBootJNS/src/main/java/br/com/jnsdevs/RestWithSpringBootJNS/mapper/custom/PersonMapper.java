package br.com.jnsdevs.RestWithSpringBootJNS.mapper.custom;

import br.com.jnsdevs.RestWithSpringBootJNS.data.vo.v2.PersonVOV2;
import br.com.jnsdevs.RestWithSpringBootJNS.model.Person;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * @Autor Jairo Nascimento
 * @Created 13/08/2023 - 17:29
 */

@Service
public class PersonMapper {

    public PersonVOV2 convertEntityToVO(Person person) {
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setAddress(person.getAddress());
        vo.setBirthDay(LocalDate.now());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setGender(person.getGender());
        return vo;
    }

    public Person convertVoToEntity(PersonVOV2 personVOV2) {
        Person person = new Person();
        person.setId(personVOV2.getId());
        person.setAddress(personVOV2.getAddress());
        person.setFirstName(personVOV2.getFirstName());
        person.setLastName(personVOV2.getLastName());
        person.setGender(personVOV2.getGender());
        return person;
    }
}
