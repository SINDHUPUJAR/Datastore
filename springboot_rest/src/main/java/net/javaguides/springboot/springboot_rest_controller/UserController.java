package net.javaguides.springboot.springboot_rest_controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.springboot_rest_exception.ResourceNotFoundException;
import net.javaguides.springboot.springboot_rest_model.User;
import net.javaguides.springboot.springboot_rest_repository.UserRepository;

@RestController

public class UserController {
	@Autowired
	private UserRepository userRepository;
	
//create user
		@PostMapping("/createusers")
		public User createUser(@RequestBody User user)
		{
			return userRepository.save(user);
		}
	
//create get all users  
	@GetMapping("/getusers")
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
		
	}
	
	
	
//get user by id
	@GetMapping("/user/{id}/{email}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") String userId)throws ResourceNotFoundException
	{
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found forthis id :" + userId));
		return ResponseEntity.ok().body(user);
	}
//update user by id
	@PutMapping("/updateuser/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") String userId, @RequestBody User userDetails)throws ResourceNotFoundException
	{
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found forthis id :" + userId));
		user.setId(userDetails.getId());
		user.setUsername(userDetails.getUsername());
		user.setStatus(userDetails.getStatus());
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setEmail(userDetails.getEmail());
		user.setCreatedBy(userDetails.getCreatedBy());
		user.setCreatedDate(userDetails.getCreatedDate());
		user.setLastModifiedBy(userDetails.getLastModifiedBy());
		user.setLastmodifieddate(userDetails.getLastmodifieddate());
		userRepository.save(user);
		
		
		return ResponseEntity.ok().body(user);
		
	}
	
//delete user by id
	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity deleteUser(@PathVariable(value = "id") String userId)throws ResourceNotFoundException
	{
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for  sthis id :" + userId));
		userRepository.deleteById(userId);
		return ResponseEntity.ok().build();
	}
	
	
}

 