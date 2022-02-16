package com.zee.zee5app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.Exception.AlreadyExistsException;
import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidEmailException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.Exception.InvalidPasswordException;
import com.zee.zee5app.Exception.LocationNotFoundException;
import com.zee.zee5app.Exception.NameNotFoundException;
import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.repository.Movierepo;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.Movieservice2;
import com.zee.zee5app.service.RoleService;
import com.zee.zee5app.service.impl.EpisodesServiceimpl;
import com.zee.zee5app.service.impl.Movieserviceimpl;
import com.zee.zee5app.service.impl.RoleServiceimpl;
import com.zee.zee5app.service.impl.Seriesserviceimpl;
import com.zee.zee5app.service.impl.Subserviceimpl;
import com.zee.zee5app.service.impl.UserServiceimpl;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String args[]) {
		 ConfigurableApplicationContext applicationContext=SpringApplication.run(Zee5appspringbootApplication.class, args);
		 
//		 DataSource dataSource=applicationContext.getBean(DataSource.class);
//		 
//		 System.out.println(dataSource!=null);
//		 Role role=new Role();
 //    	 role.setRoleName(EROLE.ROLE_ADMIN);
	 
//		 Role role2=new Role();
//		 role2.setRoleName(EROLE.ROLE_USER);
//		 
//		 RoleService roleservice=applicationContext.getBean(RoleServiceimpl.class);
//		 RoleRepository roleRepository=applicationContext.getBean(RoleRepository.class);
//		 System.out.println(roleservice.addRole(role));
//		 System.out.println(roleservice.addRole(role2));
		 
//		 UserServiceimpl service=applicationContext.getBean(UserServiceimpl.class);
//		 Register register = new Register("shannu333","shanmukh","narra","shannu333@gmail.com","S123456",null,null);
//		 Set<Role> roles=new HashSet<>();
//		 roles.add(roleRepository.findById(2).get());
//		 roles.add(roleRepository.findById(3).get());
//		 register.setRoles(roles);
//		try {
//			System.out.println(service.addUser(register));
//		} catch (AlreadyExistsException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		  Subserviceimpl service4=applicationContext.getBean(Subserviceimpl.class);
//			Subscription subscription=new Subscription("sub001", "premium", "2021-10-26", "Active","India","499","upi", "no", "2022-10-25", register);
//			System.out.println(service4.addSubscription(subscription));
//		 
		 
		 
		 
//		Register register2=new Register("vamsi12345","narra","vamsi","vamsi12345@gmail.com","vamsi@123");
//		try {
//			System.out.println(service.addUser(register2));
//		} catch (AlreadyExistsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			System.out.println(service.updateUser("vamsi05"));
//		} catch (IdNotFoundException | InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			System.out.println(service.deleteUserById("vamsi05"));
//		} catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		service.addUser(register2);
//		try {
//			System.out.println(service.getAllUserDetails());
//		} catch (InvalidEmailException | InvalidIdLengthException | InvalidNameException | InvalidPasswordException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			System.out.println(service.getAllUsers());
//		} catch (InvalidEmailException | InvalidIdLengthException | InvalidNameException | InvalidPasswordException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		UserRepository userRepository=applicationContext.getBean(UserRepository.class);
//		System.out.println(userRepository.existsByEmailAndFirstName("vamsi123@gmail.com","narra"));
		
//		//Movie
//		Movieserviceimpl service2=applicationContext.getBean(Movieserviceimpl.class);
//		Movie movie = new Movie("mov003","antim","action","2021-11-26","salman",160,"hindi","");
//		System.out.println(service2.addMovie(movie));
//		Movie movie2= new Movie("mov001","varudukavalenu","comedy","2022-1-10","salman",145,"telugu","");
//		System.out.println(service2.addMovie(movie2));
//		Movierepo movierepo=applicationContext.getBean(Movierepo.class);
//		System.out.println(movierepo.findByMname("varudukavalenu"));
//		System.out.println(movierepo.findByMnameAndMdor("antim","2021-11-26"));
//		System.out.println(movierepo.findByMcast("salman"));
		 
//		 //Series and episodes
//		 Seriesserviceimpl service2=applicationContext.getBean(Seriesserviceimpl.class);
//		 EpisodesServiceimpl episodeservice=applicationContext.getBean(EpisodesServiceimpl.class);
//		 
//		 
//		    Series series1 = new Series("ser003","antim","action","2021-11-26","salman",16,"hindi","",null);
//			System.out.println(service2.addSeries(series1));
//			Series series2= new Series("ser001","varudukavalenu","comedy","2022-1-10","salman",14,"telugu","",null);
//			System.out.println(service2.addSeries(series2));
//			
//			
//			Episodes episode=new Episodes("ep0001",35,"eposide1","db","ser001","",series2);
//			System.out.println(episodeservice.addEpisodes(episode));
//			Episodes episode2=new Episodes("ep0005",45,"eposide5","db","ser003","",series1);
//			System.out.println(episodeservice.addEpisodes(episode2));
			
//		 Movieservice2 movieService=applicationContext.getBean(Movieservice2.class);
//		 Movie movie = new Movie("mov005","pushpa","action","2021-12-21","alluarjun",165,"telugu",null);
//		 FileInputStream fileInputStream = null;
//		 FileOutputStream fileOutputStream=null;
//		 try {
//			 fileInputStream = new FileInputStream("C:\\Users\\narra.shanmukh\\Downloads\\pusphat.mp4");
//			 File file = new File("C:\\Users\\narra.shanmukh\\Downloads\\pusphat.mp4");
//			 long fileSize= file.length();
//	         byte[] allBytes = new byte[(int) fileSize];
//	         
//	         fileInputStream.read(allBytes);
//	         
//	         movie.setMtrailer("C:\\Users\\narra.shanmukh\\Downloads\\movie\\"+file.getName());
//	         
//	         
//	         String result=movieService.addMovie(movie);
//	         
//	         if(result.equals("success")) {
//	      	   
//	      	   fileOutputStream = new FileOutputStream("C:\\Users\\narra.shanmukh\\Downloads\\movie\\"+file.getName());
//	      	   
//	      	   byte[] data = new byte[(int) file.length()];
//	      	   
//	      	   fileInputStream.read(data);
//	      	   fileOutputStream.write(data);
//	      	   
//	         }
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			finally {
//				try {
//					fileInputStream.close();
//					fileOutputStream.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
		 
		 
//		 
//		 
//			Movieservice2 movieService=applicationContext.getBean(Movieservice2.class);
//			
//			try {
//				Optional<Movie> movie=movieService.getMovieById("mov001");
//				if(movie.isEmpty()) {
//					System.out.println("record not found");
//				}else {
//				 Movie movie1=Optional.get();
//				 FileOutputStream fileOutputStream=new FileOutputStream("");
//				 fileOutputStream.write(movie.getMtrailer());
//				}
//			} catch (LocationNotFoundException | NameNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			
//			UserServiceimpl service=applicationContext.getBean(UserServiceimpl.class);
//			try {
//				System.out.println(service.getUserById("shannu005"));
//			} catch (IdNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
//		 UserServiceimpl service=applicationContext.getBean(UserServiceimpl.class);
//         Register register = new Register("shannu38","shanmukh","narra","shannu38@gmail.com","S123456",null,null,null);
//         try {
//			System.out.println(service.addUser(register));
//		} catch (AlreadyExistsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
			
		//applicationContext.close();
	}

}
