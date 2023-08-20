package br.com.jnsdevs.RestWithSpringBootJNS.integrationtests.vo.pagedmodels;

import br.com.jnsdevs.RestWithSpringBootJNS.integrationtests.vo.BookVO;
import br.com.jnsdevs.RestWithSpringBootJNS.integrationtests.vo.PersonVO;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 20/08/2023 - 12:12
 */
@XmlRootElement
public class PagedModelBook {

    @XmlElement(name = "content")
    private List<BookVO> content;

    public PagedModelBook() {
    }

    public List<BookVO> getContent() {
        return content;
    }

    public void setContent(List<BookVO> content) {
        this.content = content;
    }
}
