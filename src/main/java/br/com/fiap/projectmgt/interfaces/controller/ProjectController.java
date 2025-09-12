package br.com.fiap.projectmgt.interfaces.controller;

import br.com.fiap.projectmgt.domain.exceptions.ResourceNotFoundException;
import br.com.fiap.projectmgt.domain.service.ProjectService;
import br.com.fiap.projectmgt.domain.entity.PageList;
import br.com.fiap.projectmgt.domain.entity.Project;
import br.com.fiap.projectmgt.interfaces.dto.PageListDTO;
import br.com.fiap.projectmgt.interfaces.dto.ProjectOutDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<PageListDTO<ProjectOutDto>> getProjects(
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            @RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber) {
        PageList<Project> allProjects = projectService.listProjects(pageSize, pageNumber);
        PageListDTO<ProjectOutDto> projectsDto = Project.toOutDtoList(allProjects);

        return ResponseEntity.ok(projectsDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectOutDto> getProject(@PathVariable("id") Long id) {
        try {
            Project project = projectService.getProject(id);
            ProjectOutDto projectDto = Project.toOutDto(project);

            return ResponseEntity.ok(projectDto);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Não foi possível localizar o id = " + id);
        }
    }

    @PostMapping
    public ResponseEntity<ProjectOutDto> createProject(@RequestBody Project project) {
        Project createdProject = projectService.createProject(project);
        ProjectOutDto projectDto = Project.toOutDto(createdProject);

        return ResponseEntity.status(HttpStatus.CREATED).body(projectDto);
    }

    @PutMapping
    public ResponseEntity<ProjectOutDto> updateProject(@RequestBody Project project) {
        Project updatedProject = projectService.updateProject(project);
        ProjectOutDto projectDto = Project.toOutDto(updatedProject);

        return ResponseEntity.status(HttpStatus.OK).body(projectDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable("id") Long id) {
        try {
            projectService.deleteProject(id);

            return ResponseEntity.ok().build();
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Não foi possível localizar o id = " + id);
        }
    }

    @PatchMapping
    public ResponseEntity<Project> patchProject(@RequestBody Project project) {
        // Implementar em casa o patch

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(project);
    }

}
