package br.com.jnsdevs.RestWithSpringBootJNS.integrationtests.vo.wrappers;

import br.com.jnsdevs.RestWithSpringBootJNS.integrationtests.vo.BookVO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 20/08/2023 - 12:02
 */
public class BookEmbeddedVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("bookVOList")
    private List<BookVO> books;

    public BookEmbeddedVO() {}

    public List<BookVO> getBooks() {
        return books;
    }

    public void setBooks(List<BookVO> books) {
        this.books = books;
    }
}
