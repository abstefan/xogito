package com.example.demo.projects;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/")
public class ProjectController {

    private final ProjectService projectService;

    
    
    @PostMapping("projects")
	public ResponseEntity<Project> createUser(@Valid @RequestBody Project project){
		Project savedProject = projectService.createProject(project);
		return new ResponseEntity<Project>(savedProject, HttpStatus.CREATED);
	}
    
    @RequestMapping(value="/findByName")
	  public ResponseEntity<Project> findByName(@RequestParam("projectName") String projectName ){
   		  return  projectService.findByName(projectName)
	                .map(ResponseEntity::ok)
	                .orElseGet(() -> ResponseEntity.noContent().build());
		}
    
    
    @GetMapping("/projects/{pageNo}/{pageSize}")
    public List<Project> getPaginatedProjects(@PathVariable int pageNo,@PathVariable int pageSize) {

        return projectService.findPaginated(pageNo, pageSize);
    }
    
    @GetMapping("/projects/{id}")
    public ProjectDTO getProjectsById(@PathVariable Long id) {

        return projectService.findProjectsById(id);
    }
}
