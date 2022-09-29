package com.MDF.firstRestApi.My_first_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CourseApiException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7825274385734287680L;
	private HttpStatus status;
	private String message;

	
	public HttpStatus getStatus() {
		return status;
	}


	public String getMessage() {
		return message;
	}


	public CourseApiException(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

}
