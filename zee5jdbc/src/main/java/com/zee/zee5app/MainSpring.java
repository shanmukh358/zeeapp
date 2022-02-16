package com.zee.zee5app;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.zee.zee5app.Exception.InvalidEmailException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.Exception.InvalidPasswordException;
import com.zee.zee5app.config.Config;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository2;

public class MainSpring {
	 public static void main(String[] args) {
		 
		 AbstractApplicationContext applicationContext=new AnnotationConfigApplicationContext(Config.class);
		 UserRepository2 userRepository=applicationContext.getBean(UserRepository2.class);
		 System.out.println(userRepository);
	      UserRepository2 userRepository2=applicationContext.getBean(UserRepository2.class);
		 System.out.println(userRepository2);
		 
		 System.out.println(userRepository.hashCode());
		 System.out.println(userRepository2.hashCode());
		 System.out.println(userRepository.equals(userRepository2));
		 
		 DataSource dataSource=applicationContext.getBean("ds",DataSource.class);
		 
		 
		 
			
				Register register=null;
				try {
					register = new Register("shannu8","shanmukh","narra","shannu358@gmail.com","S123456");
				} catch (InvalidIdLengthException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidNameException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidPasswordException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidEmailException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(userRepository.addUser(register));
			
		 applicationContext.close();
	 }
	}
