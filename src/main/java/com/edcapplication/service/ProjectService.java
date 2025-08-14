package com.edcapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edcapplication.model.Project;
import com.edcapplication.repository.ProjectRepository;

@Service
public class ProjectService {

private ProjectRepository projectRepository;
	
	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}
	
	public List<Project> getProjects() {
		return (List<Project>) projectRepository.findAll();
	}
	
	public Project getProjectById(Integer id) {
		Optional<Project> ProjectResponse =  projectRepository.findById(id);
		Project Project = ProjectResponse.get();
		return Project;
	}
	
	public Project addProject(Project project) {
		Project project1 =  projectRepository.save(project);
		return project1;
	}
	
	public Project updateProject(Project project) {
        return projectRepository.save(project);
    }
	
	public void deleteProject(Integer id) {
		projectRepository.deleteById(id);
	}
}
