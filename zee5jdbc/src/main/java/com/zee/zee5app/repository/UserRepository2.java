package com.zee.zee5app.repository;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidEmailException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.Exception.InvalidPasswordException;
import com.zee.zee5app.dto.Register;

public interface UserRepository2 {
	public String addUser(Register register);
	public String updateUser(String id) throws IdNotFoundException, InvalidNameException;
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException;
	public Register[] getAllUsers() throws InvalidEmailException, InvalidIdLengthException, InvalidNameException, InvalidPasswordException;
	public String deleteUserById(String id) throws IdNotFoundException;
	Optional<List<Register>> getAllUserDetails() throws InvalidEmailException, InvalidIdLengthException, InvalidNameException, InvalidPasswordException;
}
//we can't crete/declare the objects for interfaces only references possible.
//we can get only access for the interface overridden methods.