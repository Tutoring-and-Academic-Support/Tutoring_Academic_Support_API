package com.eduaccesscode.service;

import com.eduaccesscode.dto.ComentarioDTO;
import com.eduaccesscode.model.entity.Comentario;
import com.eduaccesscode.model.entity.Curso;
import com.eduaccesscode.repository.ComentarioRepository;
import com.eduaccesscode.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    // Lista de palabras ofensivas o prohibidas que puedes ajustar
    private final List<String> palabrasProhibidas = Arrays.asList("mala palabra1", "mala palabra2");

    // Método que verifica si el comentario contiene contenido ofensivo
    private boolean contieneContenidoOfensivo(String comentario) {
        return palabrasProhibidas.stream().anyMatch(comentario.toLowerCase()::contains);
    }

    public String publicarComentario(ComentarioDTO comentarioDTO) throws Exception {
        // Busca el curso en lugar del material
        Curso curso = cursoRepository.findById(comentarioDTO.getCursoId())
                .orElseThrow(() -> new Exception("Curso no encontrado"));

        // Validación dentro del servicio
        if (contieneContenidoOfensivo(comentarioDTO.getComment())) {
            throw new Exception("El comentario contiene contenido ofensivo");
        }

        Comentario comentario = new Comentario();
        comentario.setTexto(comentarioDTO.getComment());
        comentario.setFecha(new Date());
        comentario.setCurso(curso);  // Relación con Curso

        comentarioRepository.save(comentario);

        return "Comentario publicado con éxito";
    }
}


