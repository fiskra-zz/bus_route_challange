package com.goeuro.bus.route.challange.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goeuro.bus.route.challange.model.ResponseError;
import com.goeuro.bus.route.challange.model.MessageType;
/**
 * This class provides to intercept the exceptions that specified some 
 * 
 * @author feride
 *
 */
@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(TypeMismatchException.class)
	public
	@ResponseBody
	ResponseError typeMismatchExpcetionHandler(Exception exception, HttpServletRequest request) {
		return new ResponseError("Type is not match", MessageType.INFO);
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public
	@ResponseBody
	ResponseError missingRequestParameterExceptionHandler(Exception exception, HttpServletRequest request) {
		return new ResponseError("Parameter is missing", MessageType.INFO);
	}

	@ExceptionHandler(Exception.class)
	public
	@ResponseBody
	ResponseError generalExceptionHandler(Exception exception, HttpServletRequest request) {
	    return new ResponseError("General error occured", MessageType.ERROR);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public
	@ResponseBody
	ResponseError runtimeExceptionHandler(Exception exception, HttpServletRequest request) {
	    return new ResponseError("There is a problem occured", MessageType.INFO);
	}

}
