package com.zee.zee5app;

import com.zee.zee5app.Exception.InvalidEmailException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.Exception.InvalidPasswordException;
import com.zee.zee5app.dto.Register;


public class Main2 {
 public static void main(String[] args) {
	 try {
		 Register register=new Register("shannu0001","shanmukh","narra","shannu@gmail.com","S123456");
		 System.out.println(register);
		 System.out.println(register.toString());
		 System.out.println(register.hashCode());
		 Register register2=new Register("shanu0003","shanmukh","narra","shannu@gmail.com","S123456");
		 System.out.println(register2);
		 System.out.println(register2.toString());
		 System.out.println(register2.hashCode());
		 System.out.println(register);
		 System.out.println(register.toString());
		 System.out.println(register.hashCode());
		 System.out.println("equals and calls"+register.equals(register2));
		 
	 }catch (InvalidIdLengthException |InvalidNameException |InvalidPasswordException|InvalidEmailException e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	 
 }
}
