package com.eduaccesscode.mapper;

import com.eduaccesscode.dto.ComentarioDTO;
import com.eduaccesscode.entity.Comentario;
import org.springframework.stereotype.Component;

@Component
public class ComentarioMapper {

    public Comentario toEntity(ComentarioDTO comentarioDTO) {
        Comentario comentario = new Comentario();
        comentario.setTexto(comentarioDTO.getComment());
        // Aquí se asignan los otros valores (material y estudiante) en el servicio.
        return comentario;
    }
}
