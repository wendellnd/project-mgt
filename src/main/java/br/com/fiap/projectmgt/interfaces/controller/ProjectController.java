package br.com.fiap.projectmgt.interfaces.controller;

import br.com.fiap.projectmgt.application.service.ProjectService;
import br.com.fiap.projectmgt.application.service.impl.ProjectServiceImpl;
import br.com.fiap.projectmgt.domain.entity.Project;
import br.com.fiap.projectmgt.domain.entity.ProjectList;
import br.com.fiap.projectmgt.domain.exceptions.ResourceNotFoundException;
import br.com.fiap.projectmgt.interfaces.dto.ProjectOutDto;
import br.com.fiap.projectmgt.interfaces.dto.ProjectOutDtoList;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<ProjectOutDtoList> getProjects(@RequestParam(name = "pageSize", required = false,defaultValue = "10") Integer pageSize,
                                                                   @RequestParam(name = "pageNumber", required = false,defaultValue = "0") Integer pageNumber) {

        ProjectList allProjects = projectService.listProjects(pageSize, pageNumber);
        ProjectOutDtoList projectsDto = ProjectList.toOutDtoList(allProjects);

        return ResponseEntity.ok(projectsDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectOutDto> getProject(@PathVariable("id") Long id) {
        try {
            Project project = projectService.getProject(id);
            ProjectOutDto projectDto = Project.toOutDto(project);

            return ResponseEntity.ok(projectDto);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Não foi possível localizar o id = "+id);
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
            throw new ResourceNotFoundException("Não foi possível localizar o id = "+id);
        }
    }

    @PatchMapping
    public ResponseEntity<Project> patchProject(@RequestBody Project project) {
        //Implementar em casa o patch

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(project);
    }


}
