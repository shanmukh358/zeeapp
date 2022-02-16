package com.zee.zee5app.controller.controlleradvice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.MethodArgumentBuilder;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ErrorAdvice extends ResponseEntityExceptionHandler{

//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentBuilder ex,
//		HttpHeaders headers,HttpStatus status,WebRequest request){
//		return ResponseEntity.ok(ex);
//	}
}
