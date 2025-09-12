package br.com.fiap.projectmgt.infrastructure.config;

import br.com.fiap.projectmgt.application.service.impl.ProjectServiceImpl;
import br.com.fiap.projectmgt.domain.repository.ProjectRepository;
import br.com.fiap.projectmgt.domain.service.ProjectService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfig {

    @Bean
    public ProjectService projectService(ProjectRepository repository) {
        return new ProjectServiceImpl(repository);
    }
}
