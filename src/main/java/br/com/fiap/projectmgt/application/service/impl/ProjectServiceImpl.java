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

    @Override
    public Project getProject(Long projectId) {
        return null;
    }

    @Override
    public Project createProject(Project project) {
        return null;
    }

    @Override
    public Project updateProject(Project project) {
        return null;
    }

    @Override
    public void deleteProject(Long projectId) {

    }

    /*
    public Project getProject(Long projectId) {
        final JpaProjectEntity p = this.repository.findById(projectId).orElseThrow();

        return JpaProjectEntity.toProject(p);
    }

    public Project createProject(Project project) {
        JpaProjectEntity savedEntity = this.repository.save(Project.toJpaProjectEntity(project));

        return JpaProjectEntity.toProject(savedEntity);
    }

    public Project updateProject(Project project) {
        JpaProjectEntity entity = Project.toJpaProjectEntity(project);
        this.repository.save(entity);

        return project;
    }

    public void deleteProject(Long projectId) {
        this.repository.deleteById(projectId);
    }
     */
}
