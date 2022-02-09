package com.example.demo.projects;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" ,unmappedTargetPolicy = ReportingPolicy.IGNORE ,  uses=ProjectService.class)
public interface ProjectMapper {

    Project map(ProjectDTO source);

    @InheritInverseConfiguration
    ProjectDTO map(Project source);
   
}
