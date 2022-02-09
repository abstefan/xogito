package com.example.demo.projects;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

	Optional<Project> findByName(String projectName);
}
