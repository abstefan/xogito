package com.example.demo.users;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/")
public class UserController {


    private final UserService userService;
	
	
	@PostMapping("users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		User savedUser = userService.createUser(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}

	
	  @RequestMapping(value="/findByNameAndEmail")
	  public ResponseEntity<User> findByNameAndEmail(@RequestParam("userName") String userName , 
			                                         @Valid @RequestParam("userEmail") String userEmail ){
		
		  return  userService.findByNameAndEmail(userName, userEmail)
	                .map(ResponseEntity::ok)
	                .orElseGet(() -> ResponseEntity.noContent().build());
			
		}
}
