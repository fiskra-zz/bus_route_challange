package com.goeuro.bus.route.challange.model;
/**
 * This model class represents to intercept exceptions of a specific kind and return
 * custom message  
 * 
 * @author feride
 *
 */
public class ResponseError {
	
	private String message;
	private MessageType type;
	
	public ResponseError(String message,MessageType type){
		this.message = message;
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public MessageType getType() {
		return type;
	}

}
