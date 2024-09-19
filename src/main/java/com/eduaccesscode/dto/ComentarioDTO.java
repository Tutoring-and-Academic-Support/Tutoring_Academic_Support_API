package com.eduaccesscode.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ComentarioDTO {

    @NotNull(message = "El ID del curso es obligatorio")
    private Long cursoId;

    @NotBlank(message = "El comentario no puede estar vacío")
    @Size(max = 500, message = "El comentario no puede tener más de 500 caracteres")
    private String comment;

}
