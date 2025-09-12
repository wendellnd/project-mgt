package br.com.fiap.projectmgt.interfaces.dto;

import java.util.List;

public record PageListDTO<T>(
        List<T> list,
        Integer pageSize,
        Integer pageNumber
) {
}
