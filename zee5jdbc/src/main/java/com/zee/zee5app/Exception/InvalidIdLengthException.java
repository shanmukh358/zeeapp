package com.zee.zee5app.Exception;

import lombok.ToString;

@ToString(callSuper=true)
//toString from the base class i.e.., exception class.
public class InvalidIdLengthException extends Exception {

	public InvalidIdLengthException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

//	@Override
//	public String toString() {
//		return "IdNotFoundException [toString()=" + super.toString() + "]";
//	}
 
}
