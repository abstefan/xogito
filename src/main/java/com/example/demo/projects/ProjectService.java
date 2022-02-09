package com.example.demo.projects;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProjectService {


    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;


	public Project createProject(Project project) {
		return projectRepository.save(project);
	}
 
	
	public Optional<Project> findByName(String projectName) {
		return projectRepository.findByName(projectName);
	}
	
	
	 public ProjectDTO findProjectsById(Long id) {
		 return projectRepository.findById(id).map(projectMapper::map).orElseThrow(() -> {
	            throw new EntityNotFoundException("Project Id not found.");
	        });
    }
	
	
	 public List<Project> findPaginated(int pageNo, int pageSize) {

	        Pageable paging = PageRequest.of(pageNo, pageSize);
	        Page<Project> pagedResult = projectRepository.findAll(paging);

	        return pagedResult.toList();
	    }
}
