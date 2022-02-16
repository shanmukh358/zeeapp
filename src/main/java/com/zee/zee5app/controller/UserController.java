package com.zee.zee5app.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.Exception.AlreadyExistsException;
import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidEmailException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.Exception.InvalidPasswordException;
import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.payload.request.LoginRequest;
import com.zee.zee5app.payload.request.SignupRequest;
import com.zee.zee5app.payload.response.JwtResponse;
import com.zee.zee5app.payload.response.MessageResponse;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.security.jwt.JwtUtils;
import com.zee.zee5app.security.services.UserDetailsImpl;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.UserService2;
import com.zee.zee5app.service.impl.UserServiceimpl;

@CrossOrigin("*")
@RestController //it is combination of @ResponseBody @Controller
@RequestMapping("/api/auth")
public class UserController {
 
	@Autowired
	UserService2 userService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
		
		Authentication authentication=authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(
						loginRequest.getusername(), loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt=jwtUtils.generateToken(authentication);
		UserDetailsImpl userDetailsImpl=(UserDetailsImpl)authentication.getPrincipal();
		
		List<String> roles=userDetailsImpl.getAuthorities()
				.stream().map(i->i.getAuthority())
				.collect(Collectors.toList());
		
		
		return ResponseEntity.ok(new JwtResponse(jwt,
				userDetailsImpl.getId(),
				userDetailsImpl.getUsername(), 
				userDetailsImpl.getEmail(), 
				roles));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest){
		
		if(userRepository.existsByUsername(signupRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}
		
		if(userRepository.existsByEmail(signupRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already use!"));
		}
		
		User user=new User(signupRequest.getUsername(),
				signupRequest.getFirstname(),
				signupRequest.getLastname(),
				signupRequest.getEmail(),
				passwordEncoder.encode(signupRequest.getPassword()));
			
		Set<String> strRoles=signupRequest.getRoles();
		
		Set<Role> roles=new HashSet<>();
		
		if(strRoles==null) {
			Role userRole=roleRepository.findByRoleName(EROLE.ROLE_USER)
					.orElseThrow(()->new RuntimeException("Error:role not found"));
		}
		else {
			strRoles.forEach(e->{
				switch(e) {
				 
				case "admin":
					Role roleAdmin = roleRepository.findByRoleName(EROLE.ROLE_ADMIN)
					                 .orElseThrow(()->new RuntimeException("Error:role not found"));
					roles.add(roleAdmin);
				    break;
				
				case "mod" :
					Role roleMod = roleRepository.findByRoleName(EROLE.ROLE_MODERATOR)
	                 .orElseThrow(()->new RuntimeException("Error:role not found"));
	                 roles.add(roleMod);
                      break;
					
					
						
				default:
					Role userRole = roleRepository.findByRoleName(EROLE.ROLE_USER)
	                 .orElseThrow(()->new RuntimeException("Error:role not found"));
	                 roles.add(userRole);
                     
				}
			});
			
			
		}
		user.setRole(roles);
		userRepository.save(user);
		return ResponseEntity.status(201).body(new MessageResponse("user created sucessfully"));
		
	}
	
	//adding user info into the table
	//info will be shared by the client in terms of json object
	
	
//	@PostMapping("/addUser")
//	public ResponseEntity<?> addUser(@RequestBody User register) throws AlreadyExistsException {
//		
//			User result=userService.addUser(register);
//			System.out.println(result);
//		
//			return ResponseEntity.status(201).body(result);	
//		
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<?> getUserById(@PathVariable("id") Long id) throws IdNotFoundException{
//		userService.getUserById(id);
//		return ResponseEntity.ok(id);
//	}
//	
//	@GetMapping("/all")
//	@PreAuthorize(value = "")
//	@PostAuthorize(value = "")
//	public ResponseEntity<?> getAllUserDetails() throws InvalidEmailException, InvalidIdLengthException, InvalidNameException, InvalidPasswordException{
//		Optional<List<User>> optional=userService.getAllUserDetails();
//		if(optional.isEmpty()) {
////			HashMap<String, String> map=new HashMap<>();
////			map.put("messeage", "no record found");
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageResponse("no record found"));
//		}
//		return ResponseEntity.ok(optional.get());
//	}
	
	
	
}
