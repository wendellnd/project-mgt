package br.com.fiap.projectmgt.domain.entity;

import br.com.fiap.projectmgt.infrastructure.entity.JpaProjectEntity;
import br.com.fiap.projectmgt.interfaces.dto.ProjectOutDto;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor

@EqualsAndHashCode

@Data
@Getter
@Setter
public class Project {

    private Long id;

    private String name;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private List<Tarefa> tarefas;

    static public ProjectOutDto toOutDto(Project project) {
        return new ProjectOutDto(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getStartDate(),
                project.getEndDate()
        );
    }

    static public JpaProjectEntity toJpaProjectEntity(Project project) {
        return new JpaProjectEntity(
                project.getName(),
                project.getDescription(),
                project.getStartDate(),
                project.getEndDate()
        );
    }
}
