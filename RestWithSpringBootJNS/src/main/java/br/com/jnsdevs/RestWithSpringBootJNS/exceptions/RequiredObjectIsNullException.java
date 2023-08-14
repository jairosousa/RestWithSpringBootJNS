package br.com.jnsdevs.RestWithSpringBootJNS.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Autor Jairo Nascimento
 * @Created 14/08/2023 - 10:11
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectIsNullException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public RequiredObjectIsNullException() {
        super("It is not allowed to persist a null object!");
    }

    public RequiredObjectIsNullException(String ex) {
        super(ex);
    }

}
