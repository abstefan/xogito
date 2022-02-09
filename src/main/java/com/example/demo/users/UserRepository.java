package com.example.demo.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByName(String username);

	Optional<User> findByEmail(String email);
	
	Optional<User> findByNameAndEmail(String username,String email);

}
