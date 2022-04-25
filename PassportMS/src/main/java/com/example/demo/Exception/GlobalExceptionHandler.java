package com.example.demo.Exception;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	@Override
	 protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers,HttpStatus status,WebRequest request){
	   Map<String,String> errors=new HashMap<String,String>();
	   ex.getBindingResult().getAllErrors().forEach((error)->{
		   String fieldName =((FieldError) error).getField();
		   String message=error.getDefaultMessage();
		   errors.put(fieldName,message);
	   });
	   return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Registration_Exception.class)
	public ResponseEntity<ExceptionResponse> recordNotFound(Registration_Exception ex){
		ExceptionResponse response=new ExceptionResponse();
		if(ex.getMessage().equals("Invalid Pin"))
			response.setErrorCode("error code 513");
		else if(ex.getMessage().equals("Invalid State City"))
			response.setErrorCode("error code 515");
		else if(ex.getMessage().equals("Invalid IssueDate"))
			response.setErrorCode("error code 516");
		else
			response.setErrorCode("Not Found");
		response.setErrorMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.BAD_REQUEST);
	}

}
