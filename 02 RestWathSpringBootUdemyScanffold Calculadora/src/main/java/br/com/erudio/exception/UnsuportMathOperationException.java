package br.com.erudio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportMathOperationException extends RuntimeException {

	public UnsuportMathOperationException(String exception) {
		super(exception);
	}
}
