package br.com.jnsdevs.RestWithSpringBootJNS.integrationtests.vo.pagedmodels;

import br.com.jnsdevs.RestWithSpringBootJNS.integrationtests.vo.PersonVO;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 20/08/2023 - 11:49
 */
@XmlRootElement
public class PagedModelPerson {

    @XmlElement(name = "content")
    private List<PersonVO> content;

    public PagedModelPerson() {}

    public List<PersonVO> getContent() {
        return content;
    }

    public void setContent(List<PersonVO> content) {
        this.content = content;
    }
}
