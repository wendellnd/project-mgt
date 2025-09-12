package br.com.fiap.projectmgt.infrastructure.repository;

import br.com.fiap.projectmgt.domain.entity.PageList;
import br.com.fiap.projectmgt.domain.entity.Project;
import br.com.fiap.projectmgt.domain.repository.ProjectRepository;
import br.com.fiap.projectmgt.infrastructure.entity.JpaProjectEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ProjectRepositoryImpl implements ProjectRepository {
    private final JpaProjectEntityRepository repository;

    public ProjectRepositoryImpl(JpaProjectEntityRepository repository) {
        this.repository = repository;
    }

    public PageList<Project> findAll(Integer pageSize, Integer pageNumber) {
        Page<JpaProjectEntity> pageOfProjects = this.repository.findAll(
                Pageable
                        .ofSize(pageSize)
                        .withPage(pageNumber));
        return JpaProjectEntity.toProjectEntityList(pageOfProjects, pageSize, pageNumber);
    }

    public Project findById(Long projectId) {
        JpaProjectEntity jpaProject = this.repository.findById(projectId).orElseThrow();
        return JpaProjectEntity.toProject(jpaProject);
    }

    public Project save(Project project) {
        JpaProjectEntity jpaProject = JpaProjectEntity.fromProject(project);
        JpaProjectEntity savedJpaProject = this.repository.save(jpaProject);
        return JpaProjectEntity.toProject(savedJpaProject);
    }

    public void delete(Long projectId) {
        this.repository.deleteById(projectId);
    }
}
