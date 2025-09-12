package br.com.fiap.projectmgt.domain.repository;

import br.com.fiap.projectmgt.domain.entity.PageList;
import br.com.fiap.projectmgt.domain.entity.Project;

public interface ProjectRepository {
    PageList<Project> findAll(Integer pageSize, Integer pageNumber);

    Project findById(Long projectId);

    Project save(Project project);

    void delete(Long projectId);
}
