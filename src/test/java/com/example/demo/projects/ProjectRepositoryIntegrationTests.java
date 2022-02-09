package com.example.demo.projects;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

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
class ProjectRepositoryIntegrationTests {

	
	@Autowired 
	ProjectRepository projectRepository;

	private Project project1;
	private Project project2;
	
	@BeforeEach
	void setUp() {

		User user1 = new User();
		user1.setEmail("user1@xxx.com");
		user1.setName("user1");
		
		User user2 = new User();
		user1.setEmail("user1@xxx.com");
		user1.setName("user2");
		
		User user3 = new User();
		user1.setEmail("user3@xxx.com");
		user1.setName("user3");
		
		
		project1 = new Project();
		project1.setName("Xogito test");
		project1.setDescription("Xogito test description");
		project1.setAssignedUsers(Arrays.asList(user1,user2,user3));
		
		project2 = new Project();
		project2.setName("Xogito test2");
		project2.setDescription("Xogito test description2");
		project2.setAssignedUsers(Arrays.asList(user1,user2,user3));

		
	}

	
    @Test
    public void injectedComponentsAreNotNull(){
	        assertThat(projectRepository).isNotNull();
    }
	
	@Test
	void findProject1ById() {
		project1 = projectRepository.save(project1);
		assertThat(projectRepository.findById(project1.getId())).hasValue(project1);
	}
	
	@Test
	void findProject2ById() {
		project2 = projectRepository.save(project2);
		assertThat(projectRepository.findById(project2.getId())).hasValue(project2);
	}
	
	
	
	@Test
	void findByProjectName() {

		project1 = projectRepository.save(project1);

		assertThat(projectRepository.findByName("Xogito test")).contains(project1);
	}
	

}