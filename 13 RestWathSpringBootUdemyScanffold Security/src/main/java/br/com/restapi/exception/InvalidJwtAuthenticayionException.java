package br.com.restapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidJwtAuthenticayionException extends AuthenticationException {
	
	public InvalidJwtAuthenticayionException(String exception) {
		super(exception);
	}
}
