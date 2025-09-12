package br.com.fiap.projectmgt.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class PageList<T> {
    private List<T> list;
    private Integer pageSize;
    private Integer pageNumber;
}
