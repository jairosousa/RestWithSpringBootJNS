package br.com.erudio.exception;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ExceptionResponse implements Serializable {

	private Date timestamp;
	private String menssage;
	private String details;

	public ExceptionResponse(Date timestamp, String menssage, String details) {
		super();
		this.timestamp = timestamp;
		this.menssage = menssage;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMenssage() {
		return menssage;
	}

	public String getDetails() {
		return details;
	}

}
