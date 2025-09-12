package br.com.fiap.projectmgt.application.service.impl;

import br.com.fiap.projectmgt.domain.repository.ProjectRepository;
import br.com.fiap.projectmgt.domain.service.ProjectService;
import br.com.fiap.projectmgt.domain.entity.PageList;
import br.com.fiap.projectmgt.domain.entity.Project;

public final class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository repository;

    public ProjectServiceImpl(ProjectRepository repository) {
        this.repository = repository;
    }

    public PageList<Project> listProjects(Integer pageSize, Integer pageNumber) {
        return this.repository.findAll(pageSize, pageNumber);
    }

    public Project getProject(Long projectId) {
        return this.repository.findById(projectId);
    }

    public Project createProject(Project project) {
        return this.repository.save(project);
    }

    public Project updateProject(Project project) {
        return this.repository.save(project);
    }

    public void deleteProject(Long projectId) {
        this.repository.delete(projectId);
    }
}
