package com.zee.zee5app.dto;

import java.util.Objects;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidEmailException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.Exception.InvalidPasswordException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
//@EqualsAndHashCode
//@NoArgsConstructor
//@AllArgsConstructor
public class Register implements Comparable<Register>{
	
	public Register(String id, String firstName, String lastName, String email, String password)
			throws InvalidIdLengthException, InvalidNameException,InvalidPasswordException,InvalidEmailException {
		super();
		this.setId(id);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.email = email;
		this.password = password;
	}
	@Setter(value = AccessLevel.NONE)
	private String id;
	// it should have min length of 6.
	// we have to write a code to validate the length and 
	// then assign the value.
	@Setter(value = AccessLevel.NONE)
	private String firstName;
	@Setter(value = AccessLevel.NONE)
	private String lastName;
	@Setter(value = AccessLevel.NONE)
	private String email;
	@Setter(value = AccessLevel.NONE)
	private String password;
	
	public Register() {
		// EDC
		// any kind of customization during the initialization of object
		// then its better to introduce EDC or PC or both as per the need.
		
		System.out.println("hello ");
	}

	public void setFirstName(String firstName) throws InvalidNameException {
		
		if(firstName==null || firstName=="" || firstName.length()<2) {
			throw new InvalidNameException("firstname is not valid");
		}
		this.firstName = firstName;
	}
	public void setLastName(String lastName) throws InvalidNameException {
		if(lastName==null || lastName=="" || lastName.length()<2) {
			throw new InvalidNameException("lastname is not valid");		
		}
		this.lastName = lastName;
	}
	public void setPassword(String password) throws InvalidPasswordException {
		if(password==null || password=="" || password.length()<6) {
 
		}
		this.password = password;
	}
	public void setEmail(String email) throws InvalidEmailException {
		if(email==null || email=="" || !(email.contains("@gmail.com"))) {
			throw new InvalidEmailException("email is not valid");		
		}
		this.email = email;
	}
	public void setId(String id) throws InvalidIdLengthException {
		// throws : it will provide the list of exceptions may be raised
		// it will hold the list of checked exceptions.
		
		
		if(id.length()<4) {
			// it should raise the InvalidIdExcetpion
			// exception object is created by JVM .
			
			// user defined exception object must be raised 
			// by us
			throw new InvalidIdLengthException
			("id length is lessthan or eq to 6");
			// throw : it will throw the exception 
		}
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Register other = (Register) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password);
	}

	@Override
	public int compareTo(Register o) {
		// TODO Auto-generated method stub
		return o.id.compareTo(this.getId());
	}
	
	// private stuff will be accessible only inside the class.
	
	// setter : is used to set the value for a particular field.
	// getter : to get/return the value of a specific field
}
