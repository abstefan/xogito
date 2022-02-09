package com.example.demo.users;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.example.demo.util.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
@ToString

public class User extends BaseEntity<Long>{

	 @Column
     @NotNull
	 private String name;
	 
	 @Column(unique = true)
     @NotNull
     @Email(regexp = ".+@.+\\..+" ,message = "Invalid E-Mail")
	// @Pattern(regexp ="^(.+)@(\\S+)$", message="Invalid E-Mail")  
	 private String email;
}
