package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.Exception.AlreadyExistsException;
import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidEmailException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.Exception.InvalidPasswordException;
import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.UserService2;
@Service
public class UserServiceimpl implements UserService2 {
   @Autowired
   private UserRepository userRepository;
   @Autowired
   private LoginServiceimpl service;
   @Autowired
   private LoginRepository loginRepository;
   public UserServiceimpl() throws IOException{
		// TODO Auto-generated constructor stub
	}
	
	
	
	//UserRepository userRepository ;

	
	@Override
	@org.springframework.transaction.annotation.Transactional(rollbackFor = AlreadyExistsException.class)
	public User addUser(User register) throws AlreadyExistsException{
		// TODO Auto-generated method stub
		userRepository.findById(register.getId());
		boolean status=userRepository.existsByEmailAndFirstname(register.getEmail(),register.getFirstname() );
		System.out.println("status"+status);
		
		User register2=userRepository.save(register);
		Login login = new Login(register2.getEmail(),register2.getPassword(),register2);
	    String result=service.addCredentials(login);
		System.out.println(register2);
		if(register2==null) {
			System.out.println("fail");
		}
	   
			if(!result.equals("success")) {
			    throw new AlreadyExistsException("record exists");
     		}
			//addCredential LoginService
			
			return register2;
		
	}
        

	@Override
	public String updateUser(Long id) throws IdNotFoundException, InvalidNameException {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Optional<User> getUserById(Long id) throws IdNotFoundException {
		// TODO Auto-generated method stub
	  Optional<User> optional=userRepository.findById(id);
	  if(optional.isEmpty()) {
		  throw new IdNotFoundException("id does not exixts");
	  }else {
		  return optional;
	  }
	}

	@Override
	public User[] getAllUsers() throws InvalidEmailException, InvalidIdLengthException, InvalidNameException, InvalidPasswordException {
		// TODO Auto-generated method stub
		List<User> list=userRepository.findAll();
		User[] array=new User[list.size()];
		return list.toArray(array);
	}

	@Override
	public String deleteUserById(Long id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> optional;
		try {
			 optional=this.getUserById(id);
			if(optional==null) {
				throw new IdNotFoundException("record not found");
			}else {
				userRepository.deleteById(id);
				return "deleted";
			}
			
		} catch (IdNotFoundException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
		
		
	}

	@Override
	public Optional<List<User>> getAllUserDetails() throws InvalidEmailException, InvalidIdLengthException, InvalidNameException, InvalidPasswordException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(userRepository.findAll());
	}
}
