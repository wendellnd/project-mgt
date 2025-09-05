package br.com.fiap.projectmgt.application.service.impl;

import br.com.fiap.projectmgt.application.service.ProjectService;
import br.com.fiap.projectmgt.domain.entity.Project;
import br.com.fiap.projectmgt.domain.entity.Tarefa;
import br.com.fiap.projectmgt.infrastructure.entity.JpaProjectEntity;
import br.com.fiap.projectmgt.infrastructure.repository.JpaProjectEntityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final JpaProjectEntityRepository repository;

    public ProjectServiceImpl(JpaProjectEntityRepository repository) {
        this.repository = repository;
    }

    public List<Project> listProjects(Integer pageSize, Integer pageNumber) {
        Page<JpaProjectEntity> pageOfProjects = this.repository.findAll(
                Pageable
                        .ofSize(pageSize)
                        .withPage(pageNumber));

        List<Tarefa> tasks = new ArrayList<Tarefa>();
        return JpaProjectEntity.toProjectEntityList(pageOfProjects, tasks);
    }

    public Project getProject(Long projectId) {
        final JpaProjectEntity p = this.repository.findById(projectId).orElseThrow();

        return JpaProjectEntity.toProjectEntity(p);
    }

    public Project createProject(Project project) {
        JpaProjectEntity savedEntity = this.repository.save(Project.toJpaProjectEntity(project));

        return JpaProjectEntity.toProjectEntity(savedEntity);
    }

    public Project updateProject(Project project) {
        JpaProjectEntity entity = Project.toJpaProjectEntity(project);
        this.repository.save(entity);

        return project;
    }

    public void deleteProject(Long projectId) {
        this.repository.deleteById(projectId);
    }
}
