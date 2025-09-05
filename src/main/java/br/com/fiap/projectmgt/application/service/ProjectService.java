package br.com.fiap.projectmgt.application.service;

import br.com.fiap.projectmgt.domain.entity.Project;
import br.com.fiap.projectmgt.domain.entity.ProjectList;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProjectService {
    ProjectList listProjects(Integer pageSize, Integer pageNumber);
    Project getProject(Long projectId);
    Project createProject(Project project);
    Project updateProject(Project project);
    void deleteProject(Long projectId);
}
