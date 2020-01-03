package com.faiz.learn.exception;

import java.util.Date;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<GenericExceptionModel> handleAllExceptions(Exception ex, WebRequest request) {

		GenericExceptionModel exceptionResponse = new GenericExceptionModel(new Date(), ex.getMessage(),
				request.getDescription(true));

		return new ResponseEntity<GenericExceptionModel>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<GenericExceptionModel> handleNotFoundException(Exception ex, WebRequest request) {

		GenericExceptionModel exceptionResponse = new GenericExceptionModel(new Date(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<GenericExceptionModel>(exceptionResponse, HttpStatus.NOT_FOUND);

	}

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		GenericExceptionModel exceptionResponse = new GenericExceptionModel(new Date(), "Validation Failed",
				ex.getBindingResult().toString());

		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}
