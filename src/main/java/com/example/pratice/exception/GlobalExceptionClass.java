package com.example.pratice.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionClass extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("check your apis and methos and input types once");
		ErrorDetails ed = new ErrorDetails(message, details, status, LocalDateTime.now());

		return ResponseEntity.status(status).body(ed);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("check your apis and methos and input types once");
		ErrorDetails ed = new ErrorDetails(message, details, status, LocalDateTime.now());

		return ResponseEntity.status(status).body(ed);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("check your apis and methos and input types once");
		ErrorDetails ed = new ErrorDetails(message, details, status, LocalDateTime.now());

		return ResponseEntity.status(status).body(ed);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("check your apis and methos and input types once");
		ErrorDetails ed = new ErrorDetails(message, details, status, LocalDateTime.now());

		return ResponseEntity.status(status).body(ed);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("check your apis and methos and input types once");
		ErrorDetails ed = new ErrorDetails(message, details, status, LocalDateTime.now());

		return ResponseEntity.status(status).body(ed);
	}

	@ExceptionHandler

	public ResponseEntity<Object> handlePersonDetailsAreAvailableOnThisId(PersonDetailsAreAvailableOnThisId ex) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("check your apis and methos and input types once");
		ErrorDetails ed = new ErrorDetails(message, details, HttpStatus.BAD_REQUEST, LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ed);

	}

}
