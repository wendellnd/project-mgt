package br.com.fiap.projectmgt.interfaces.dto;

import java.util.List;

public record ProjectOutDtoList(
        List<ProjectOutDto> projects,
        Integer pageSize,
        Integer pageNumber) {
}
