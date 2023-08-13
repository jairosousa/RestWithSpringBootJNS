package br.com.jnsdevs.RestWithSpringBootJNS.repository;

import br.com.jnsdevs.RestWithSpringBootJNS.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Autor Jairo Nascimento
 * @Created 13/08/2023 - 14:48
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
