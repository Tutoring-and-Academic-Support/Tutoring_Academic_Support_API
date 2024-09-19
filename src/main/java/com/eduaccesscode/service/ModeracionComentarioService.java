package com.eduaccesscode.service;

import com.eduaccesscode.model.entity.Comentario;
import com.eduaccesscode.repository.ComentarioRepository;
import com.eduaccesscode.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ModeracionComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    // Método para eliminar un comentario por parte de un tutor
    public String eliminarComentario(Long commentId, Long tutorId) {
        Optional<Comentario> comentarioOptional = comentarioRepository.findById(commentId);

        if (!comentarioOptional.isPresent()) {
            throw new EntityNotFoundException("Comentario no encontrado");
        }

        Comentario comentario = comentarioOptional.get();

        // Verificar si el tutor tiene permisos para eliminar el comentario
        if (!verificarPermisoTutor(comentario.getCurso().getId(), tutorId)) {
            throw new SecurityException("No tiene permisos para eliminar este comentario");
        }

        comentarioRepository.delete(comentario);
        return "Comentario eliminado con éxito";
    }

    private boolean verificarPermisoTutor(Long cursoId, Long tutorId) {
        // Verificar si el tutor está asignado al curso
        boolean tienePermiso = cursoRepository.existsByIdAndCursoTutores_Tutor_IdTutor(cursoId, tutorId);
        System.out.println("Verificando permisos: cursoId=" + cursoId + ", tutorId=" + tutorId + ", tienePermiso=" + tienePermiso);
        return tienePermiso;
    }
}
