package br.com.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restapi.converter.DozerConverter;
import br.com.restapi.data.model.Book;
import br.com.restapi.data.model.Person;
import br.com.restapi.data.vo.v1.BookVO;
import br.com.restapi.exception.ResourceNotFoundException;
import br.com.restapi.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;

	public List<BookVO> findAll() {
		return DozerConverter.parseListObject(repository.findAll(), BookVO.class);
	}

	public BookVO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não encontramos nenhum registro para esse id"));
	
		return DozerConverter.parseObject(entity, BookVO.class);
	}

	public BookVO create(BookVO book) {
		var entity = DozerConverter.parseObject(book, Book.class);
		var vo = DozerConverter.parseObject(repository.save(entity), BookVO.class);
		return vo;
	}

	public BookVO update(BookVO book) {
		var entity = repository.findById(book.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("Não encontramos nenhum registro para esse id"));

		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
		
		var vo = DozerConverter.parseObject(repository.save(entity), BookVO.class);
		
		return vo;
	}

	public void delete(Long id) {
		var vo = findById(id);
		repository.delete(DozerConverter.parseObject(vo, Book.class));
	}

}
