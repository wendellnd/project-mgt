package br.com.fiap.projectmgt.domain.service;

import br.com.fiap.projectmgt.domain.entity.Project;
import br.com.fiap.projectmgt.domain.entity.PageList;

public interface ProjectService {
    PageList<Project> listProjects(Integer pageSize, Integer pageNumber);

    Project getProject(Long projectId);

    Project createProject(Project project);

    Project updateProject(Project project);

    void deleteProject(Long projectId);
}
