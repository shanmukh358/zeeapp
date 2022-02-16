package com.zee.zee5app.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.repository.LoginRepository;

import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.UserService2;
@Service
public class LoginServiceimpl implements LoginService {
	@Autowired
	private LoginRepository loginRepository;

	public LoginServiceimpl() throws IOException{
		// TODO Auto-generated constructor stub
	}
	 LoginService service;
	
//	public static LoginService getInstance() throws IOException {
//		
//		if(service==null) {
//			service = new LoginServiceimpl();
//		}
//		
//		return service;
//	}
	
	@Override
	public String addCredentials(Login login) {
		// TODO Auto-generated method stub
    Login login2=loginRepository.save(login);
		
		System.out.println(login2);
		if(login2!=null) {
			return "success";
		}
		return "fail";
	}

	@Override
	public String deleteCredentials(String Username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changePassword(String Username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
