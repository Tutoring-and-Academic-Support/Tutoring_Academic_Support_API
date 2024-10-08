package com.eduaccesscode.model.service;

import com.eduaccesscode.model.entity.Comentario;
import com.eduaccesscode.model.entity.Curso;
import com.eduaccesscode.model.repository.ComentarioRepository;
import com.eduaccesscode.model.repository.CursoRepository;
import com.eduaccesscode.model.repository.EstudianteCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private EstudianteCursoRepository estudianteCursoRepository;

    // Publicar comentario
    public String publicarComentario(Long estudianteId, String texto) {
        if (texto.length() > 500) {
            return "El comentario excede el límite de caracteres permitidos.";
        }

        // Validar que el estudiante está inscrito en el curso
        boolean estaInscrito = estudianteCursoRepository.existsByEstudianteIdAndCursoId(estudianteId, cursoId);
        if (!estaInscrito) {
            return "No estás inscrito en este curso.";
        }

        // Buscar el curso
        Optional<Comentario> cursoOptional = cursoRepository.findById(cursoId);
        if (cursoOptional.isEmpty()) {
            return "Curso no encontrado.";
        }

        Curso curso = cursoOptional.get().getCurso();

        // Crear el comentario
        Comentario comentario = new Comentario();
        comentario.setTexto(texto);
        comentario.setFecha(new Date());
        comentario.setCurso(curso);

        // Guardar el comentario
        comentarioRepository.save(comentario);
        return "Comentario publicado con éxito.";
    }

    // Obtener comentarios por curso
    public List<Comentario> obtenerComentariosPorCurso(Long cursoId) {
        return comentarioRepository.findByCursoId(cursoId);
    }

    // Eliminar comentario
    public String eliminarComentario(Long comentarioId) {
        Optional<Comentario> comentario = comentarioRepository.findById(comentarioId);
        if (comentario.isPresent()) {
            comentarioRepository.deleteById(comentarioId);
            return "Comentario eliminado con éxito.";
        } else {
            return "Comentario no encontrado.";
        }
    }
}