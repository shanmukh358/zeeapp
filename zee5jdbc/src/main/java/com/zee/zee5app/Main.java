package com.zee.zee5app;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidEmailException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.Exception.InvalidPasswordException;
import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.UserService2;
import com.zee.zee5app.service.impl.LoginServiceimpl;
import com.zee.zee5app.service.impl.UserServiceimpl;

import lombok.Data;
@Data
public class Main {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
//        UserService2 service;
//		try {
//			service = UserServiceimpl.getInstance();
//			Optional<List<Register>> optional = service.getAllUserDetails();
//			if(optional.isEmpty()) {
//				System.out.println("there are no records");
//			}
//			else {
//				optional.get().forEach(e->System.out.println(e));
//			}
//		} catch (IOException | InvalidEmailException | InvalidIdLengthException | InvalidNameException | InvalidPasswordException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		UserService2 service;
//		try {
//			service = UserServiceimpl.getInstance();
//			Optional<Register> register = service.getUserById("ab000001");
//			System.out.println(register.get());
//		} catch (IOException | IdNotFoundException | InvalidIdLengthException | InvalidNameException | InvalidEmailException | InvalidPasswordException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			UserService2 service=UserServiceimpl.getInstance();
//			String result=service.deleteUserById("ab000001");
//		} catch (IOException | IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		try {
//			Login login=new Login();
//			LoginService service=LoginServiceimpl.getInstance();
//			String result=service.addCredentials(login);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			LoginService loginService = LoginServiceimpl.getInstance();
			System.out.println(loginService.changeRole("sai123@gmail.com", EROLE.ROLE_ADMIN));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
   }
		

}