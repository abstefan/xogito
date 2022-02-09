package com.example.demo.users;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {


    private final UserRepository userRepository;

 	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public Optional<User> findByNameAndEmail(String username,String email) {
		return userRepository.findByNameAndEmail(username, email);
	}
}
