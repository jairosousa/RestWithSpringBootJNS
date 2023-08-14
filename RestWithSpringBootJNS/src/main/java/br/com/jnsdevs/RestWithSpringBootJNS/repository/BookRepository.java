package br.com.jnsdevs.RestWithSpringBootJNS.repository;

import br.com.jnsdevs.RestWithSpringBootJNS.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Autor Jairo Nascimento
 * @Created 14/08/2023 - 16:00
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {}