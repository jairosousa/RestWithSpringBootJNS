package br.com.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.restapi.data.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
