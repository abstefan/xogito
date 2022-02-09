package com.example.demo.projects;

import java.util.List;

import com.example.demo.users.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProjectDTO  {
	
	 private Long id;
	
	 private String name;
	
	 private String description;
	 
	 @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
     private List<User> assignedUsers;

}
