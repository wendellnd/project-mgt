package br.com.fiap.projectmgt.infrastructure.entity;



import br.com.fiap.projectmgt.domain.entity.Project;
import br.com.fiap.projectmgt.domain.entity.Tarefa;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "project")
@Getter
@Setter
public class JpaProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    public JpaProjectEntity() {
        super();
    }

    public JpaProjectEntity(String name, String description, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static Project toProjectEntity(JpaProjectEntity project) {
        List<Tarefa> tasks = new ArrayList<Tarefa>();
        return new Project(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getStartDate(),
                project.getEndDate(),
                tasks
        );
    }

    public static List<Project> toProjectEntityList(Page<JpaProjectEntity> projects, List<Tarefa> tasks) {
        return projects.getContent().stream().parallel().map(
                p -> new Project(
                        p.getId(),
                        p.getName(),
                        p.getDescription(),
                        p.getStartDate(),
                        p.getEndDate(),
                        tasks
                )
        ).toList();
    }
}
