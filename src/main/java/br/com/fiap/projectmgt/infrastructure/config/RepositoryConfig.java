package br.com.fiap.projectmgt.infrastructure.config;

import br.com.fiap.projectmgt.domain.repository.ProjectRepository;
import br.com.fiap.projectmgt.infrastructure.repository.JpaProjectEntityRepository;
import br.com.fiap.projectmgt.infrastructure.repository.ProjectRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    public ProjectRepository projectRepository(JpaProjectEntityRepository repository) {
        return new ProjectRepositoryImpl(repository);
    }
}
