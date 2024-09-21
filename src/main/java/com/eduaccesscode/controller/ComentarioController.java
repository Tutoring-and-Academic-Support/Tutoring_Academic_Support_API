package com.eduaccesscode.controller;

import com.eduaccesscode.dto.ComentarioDTO;
import com.eduaccesscode.service.ComentarioService;
import com.eduaccesscode.entity.Comentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@Validated
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @PostMapping("/publicar")
    public ResponseEntity<String> publicarComentario(@Valid @RequestBody ComentarioDTO comentarioDTO) {
        try {
            String respuesta = comentarioService.publicarComentario(comentarioDTO);
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    // Obtener comentarios de un curso específico
    @GetMapping("/curso/{cursoId}")
    public ResponseEntity<List<Comentario>> obtenerComentariosPorCurso(@PathVariable Long cursoId) {
        List<Comentario> comentarios = comentarioService.obtenerComentariosPorCurso(cursoId);
        return ResponseEntity.ok(comentarios);
    }

    // Eliminar comentario por ID
    @DeleteMapping("/eliminar/{comentarioId}")
    public ResponseEntity<String> eliminarComentario(@PathVariable Long comentarioId) {
        String response = comentarioService.eliminarComentario(comentarioId);
        if (response.equals("Comentario eliminado con éxito.")) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }
}

class PublicarComentarioRequest {
    private Long cursoId;
    private Long estudianteId;
    private String texto;

    // Getters y setters
    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    public Long getEstudianteId() {
        return estudianteId;
    }
}
