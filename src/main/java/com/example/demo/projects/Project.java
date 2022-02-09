package com.example.demo.projects;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.example.demo.users.User;
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
public class Project  extends BaseEntity<Long>{
	
	 @Column
     @NotNull
	 private String name;
	 
	 @Column
	 private String description;
	 
	  @OneToMany
	  private List<User> assignedUsers;

}
