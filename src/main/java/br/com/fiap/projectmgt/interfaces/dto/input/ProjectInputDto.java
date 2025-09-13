package br.com.fiap.projectmgt.interfaces.dto.input;

import br.com.fiap.projectmgt.interfaces.validation.Description;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class ProjectInputDto {

    private Long id;

    @NotNull(message = "Nome inválido")
    @NotEmpty(message = "Nome inválido")
    @Length(min=5, message = "Mínimo 5 caracteres")
    private String name;

    @Description
    private String description;

    @NotNull(message = "Defina a data de início")
    private LocalDate startDate;

    private LocalDate endDate;
}
