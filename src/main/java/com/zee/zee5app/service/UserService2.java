package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.Exception.AlreadyExistsException;
import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidEmailException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.Exception.InvalidPasswordException;
import com.zee.zee5app.dto.User;

public interface UserService2 {
	public User addUser(User register) throws AlreadyExistsException;
	public String updateUser(Long id) throws IdNotFoundException, InvalidNameException;
	public Optional<User> getUserById(Long id) throws IdNotFoundException;
	public User[] getAllUsers() throws InvalidEmailException, InvalidIdLengthException, InvalidNameException, InvalidPasswordException;
	public String deleteUserById(Long id) throws IdNotFoundException;
	Optional<List<User>> getAllUserDetails() throws InvalidEmailException, InvalidIdLengthException, InvalidNameException, InvalidPasswordException;
}
