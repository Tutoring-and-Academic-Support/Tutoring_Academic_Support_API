package com.eduaccesscode.model.controller;

import com.eduaccesscode.model.entity.Comentario;
import com.eduaccesscode.model.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    // Publicar comentario
    @PostMapping("/publicar")
    public ResponseEntity<String> publicarComentario(@RequestBody PublicarComentarioRequest request) {
        String response = comentarioService.publicarComentario(request.getEstudianteId(), request.getCursoId(), request.getTexto());
        if (response.equals("Comentario publicado con éxito.")) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
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

// Clase para manejar la solicitud de publicar comentario
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
