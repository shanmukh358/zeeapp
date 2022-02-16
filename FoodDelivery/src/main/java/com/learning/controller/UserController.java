package com.learning.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.Exception.AlreadyExistsException;
import com.learning.Exception.IdNotFoundException;
import com.learning.Exception.InvalidPasswordException;
import com.learning.entity.Food;
import com.learning.entity.Login;
import com.learning.entity.Register;
import com.learning.repo.FoodRepository;
import com.learning.service.FoodService;
import com.learning.service.LoginService;
import com.learning.service.UserService;
import com.learning.service.impl.UserServiceimpl;



@RestController //it is combination of @ResponseBody @Controller
@RequestMapping("/users")
public class UserController {
 
	@Autowired
	UserService userService;
	@Autowired
	FoodService foodService;
	@Autowired
	FoodRepository foodrepository;
	
	//adding user info into the table
	//info will be shared by the client in terms of json object
	
	
	@PostMapping("/register")
	public ResponseEntity<?> addUser(@RequestBody Register register) throws AlreadyExistsException {
		
			Register result=userService.addUser(register);
			System.out.println(result);
		
			return ResponseEntity.status(201).body(result);	
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") int id) throws IdNotFoundException{
		Register result=userService.getUserById(id);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllUserDetails() throws InvalidPasswordException{
		Optional<List<Register>> optional=userService.getAllUserDetails();
		if(optional.isEmpty()) {
			HashMap<String, String> map=new HashMap<>();
			map.put("messeage", "no record found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
		}
		return ResponseEntity.ok(optional.get());
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable("id")int id) throws IdNotFoundException{
		String result=userService.deleteUserById(id);
		HashMap<String, String> map=new HashMap<>();
		map.put("messeage", "delete");
		return ResponseEntity.status(201).body(map);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") int id, @RequestBody Register register) throws IdNotFoundException
	{
		Register result = userService.updateUser(id, register);
		Map<String, String> map = new HashMap<>();
		map.put("message", "success updated");
		return ResponseEntity.status(201).body(result);
	}
	
	
	 @PostMapping("/authenticate")
		public ResponseEntity<?> authenticate(String email , String password){
			String result = userService.authenticate(email, password);
			return ResponseEntity.status(201).body(result);
			
		}
	
	  //add record
		@PostMapping("/addFood")
		public ResponseEntity<?> addFood(@Valid @RequestBody Food food) throws AlreadyExistsException {
			
		
			Food result = foodService.addFood(food);
			return ResponseEntity.status(201).body(result);
			
			}
		
		//retrieve single record
		@GetMapping("/food{foodId}")
		public ResponseEntity<?> getFoodById(@PathVariable("foodId") int foodId) throws IdNotFoundException{
			Food result = foodService.getFoodById(foodId);
			return ResponseEntity.ok(result);	
			
		}
		
		//retrieve all records
		@GetMapping("/allfood")
		public ResponseEntity<?> getAllFoodDetails(){
			Optional<List<Food>> optional = foodService.getAllFoodDetails();
			if(optional.isEmpty()) {
				Map<String, String> map = new HashMap<>();
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
			}
			return ResponseEntity.ok(optional.get());	
			
		}
		
		@DeleteMapping("/delete/food{foodId}")
		public ResponseEntity<?> deleteFoodById(@PathVariable("foodId") int foodId) throws IdNotFoundException
		{
			String result = foodService.deleteFoodById(foodId);
			Map<String, String> map = new HashMap<>();
			map.put("message", "success deleted");
			return ResponseEntity.status(201).body(result);
		}
		
		@PutMapping("/update/food{foodId}")
		public ResponseEntity<?> updateFood(@PathVariable("foodId") int foodId, @RequestBody Food food) throws IdNotFoundException
		{
			Food result = foodService.updateFood(foodId, food);
			Map<String, String> map = new HashMap<>();
			map.put("message", "success updated");
			return ResponseEntity.status(201).body(result);
		}

	
	
}
