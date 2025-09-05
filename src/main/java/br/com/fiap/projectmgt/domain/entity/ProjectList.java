package br.com.fiap.projectmgt.domain.entity;


import br.com.fiap.projectmgt.infrastructure.entity.JpaProjectEntity;
import br.com.fiap.projectmgt.interfaces.dto.ProjectOutDto;
import br.com.fiap.projectmgt.interfaces.dto.ProjectOutDtoList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ProjectList {
    private List<Project> projects;
    private Integer pageSize;
    private Integer pageNumber;

    static public ProjectOutDtoList toOutDtoList(ProjectList projectList) {
        List<ProjectOutDto> projects = projectList.projects.stream().map(
                p -> new ProjectOutDto(
                        p.getId(),
                        p.getName(),
                        p.getDescription(),
                        p.getStartDate(),
                        p.getEndDate()
                )
        ).toList();

        return new ProjectOutDtoList(
                projects,
                projectList.getPageSize(),
                projectList.getPageNumber()
        );
    }
}
