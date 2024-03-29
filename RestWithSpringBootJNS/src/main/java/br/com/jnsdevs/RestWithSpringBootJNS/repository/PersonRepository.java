package br.com.jnsdevs.RestWithSpringBootJNS.repository;

import br.com.jnsdevs.RestWithSpringBootJNS.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Autor Jairo Nascimento
 * @Created 13/08/2023 - 14:48
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Modifying
    @Query("UPDATE Person p SET p.enabled = false WHERE p.id =:id")
    void disablePerson(@Param("id") Long id);

    @Query("SELECT p FROM Person p WHERE p.firstName LIKE LOWER(CONCAT ('%',:firstName, '%'))")
    Page<Person> findPersonsByNames(@Param("firstName") String firstName, Pageable pageable);
}
