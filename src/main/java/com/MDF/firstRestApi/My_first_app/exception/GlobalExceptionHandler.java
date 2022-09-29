package com.MDF.firstRestApi.My_first_app.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.MDF.firstRestApi.My_first_app.payloads.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(CourseApiException.class)
	@ResponseBody
	public ResponseEntity<ErrorDetails> handleCourseApiException(CourseApiException exception) {
		ErrorDetails objError = new ErrorDetails(new Date(), exception.getMessage());
		return new ResponseEntity<>(objError, HttpStatus.BAD_REQUEST);
	}
}
