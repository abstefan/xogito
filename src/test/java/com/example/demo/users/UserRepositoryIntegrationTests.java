package com.example.demo.users;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.hibernate.MappingException;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.DemoApplication;
import com.example.demo.users.User;
import com.example.demo.users.UserRepository;


@Transactional
@SpringBootTest(classes = DemoApplication.class)
class UserRepositoryIntegrationTests {

	
	@Autowired 
	UserRepository userRepository;

	private User user;

	@BeforeEach
	void setUp() {

		user = new User();
		user.setEmail("user1@xxx.com");
		user.setName("user1");
	}

	
    @Test
    public void injectedComponentsAreNotNull(){
	        assertThat(userRepository).isNotNull();
    }
	
	@Test
	void findUserById() {
		user = userRepository.save(user);
		assertThat(userRepository.findById(user.getId())).hasValue(user);
	}
	
	@Test
	void findUserByName() {

		user = userRepository.save(user);

		assertThat(userRepository.findByName("user1")).contains(user);
	}
	
	@Test
	void findUserByEmail() {

		user = userRepository.save(user);

		assertThat(userRepository.findByEmail("user1@xxx.com")).contains(user);
	}
	
	@Test
	void findUserByNameAndEmail() {

		user = userRepository.save(user);

		assertThat(userRepository.findByNameAndEmail("user1","user1@xxx.com")).contains(user);
	}
	
	
	@Test
	void emailNull() {
		User user = new User();
		user.setName("user1");
			
		try {
			 userRepository.save(user);
		} catch (ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertThat(violations.size()).isEqualTo(1);
		}
	
	}
	
	
	@Test
	void emailInvalid() {
		User user = new User();
		user.setName("user1");
		user.setEmail("user1");	
		try {
			 userRepository.save(user);
		} catch (ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertThat(violations.size()).isEqualTo(1);
		}
	
	}

}