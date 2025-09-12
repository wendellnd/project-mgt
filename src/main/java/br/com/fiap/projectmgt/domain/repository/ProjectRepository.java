package br.com.fiap.projectmgt.domain.repository;

import br.com.fiap.projectmgt.domain.entity.PageList;
import br.com.fiap.projectmgt.domain.entity.Project;

public interface ProjectRepository {
    PageList<Project> findAll(Integer pageSize, Integer pageNumber);
}
