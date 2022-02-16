package com.zee.zee5app.service.impl;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.UserRepository2;
import com.zee.zee5app.repository.impl.LoginRepositoryimpl;
import com.zee.zee5app.repository.impl.UserRepositoryimpl;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.UserService2;
@Service
public class LoginServiceimpl implements LoginService {
   
	private LoginServiceimpl() throws IOException{
		// TODO Auto-generated constructor stub
	}
	private static LoginService service;
	
	public static LoginService getInstance() throws IOException {
		
		if(service==null) {
			service = new LoginServiceimpl();
		}
		
		return service;
	}
	
	LoginRepository loginRepository;
	@Override
	public String addCredentials(Login login) {
		// TODO Auto-generated method stub
		return loginRepository.addCredentials(login);
	}

	@Override
	public String deleteCredentials(String Username) {
		// TODO Auto-generated method stub
		return loginRepository.deleteCredentials(Username);
	}

	@Override
	public String changePassword(String Username, String password) {
		// TODO Auto-generated method stub
		return loginRepository.changePassword(Username, password);
	}

	@Override
	public String changeRole(String Username, EROLE erole) {
		// TODO Auto-generated method stub
		return loginRepository.changeRole(Username, erole);
	}

}
