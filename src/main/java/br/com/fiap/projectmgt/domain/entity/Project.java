package br.com.fiap.projectmgt.domain.entity;

import br.com.fiap.projectmgt.interfaces.dto.PageListDTO;
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

        private List<Task> tasks;

        static public ProjectOutDto toOutDto(Project project) {
                return new ProjectOutDto(
                                project.getId(),
                                project.getName(),
                                project.getDescription(),
                                project.getStartDate(),
                                project.getEndDate());
        }

        static public PageListDTO<ProjectOutDto> toOutDtoList(PageList<Project> list) {
                List<ProjectOutDto> dtoList = list.getList().stream().map(
                                p -> new ProjectOutDto(
                                                p.getId(),
                                                p.getName(),
                                                p.getDescription(),
                                                p.getStartDate(),
                                                p.getEndDate()))
                                .toList();

                return new PageListDTO<ProjectOutDto>(
                                dtoList,
                                list.getPageNumber(),
                                list.getPageSize());
        }
}
