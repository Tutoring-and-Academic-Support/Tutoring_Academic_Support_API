package com.eduaccesscode.repository;

import com.eduaccesscode.model.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    // Verificar si el tutor está asignado a un curso
    boolean existsByIdAndCursoTutores_Tutor_IdTutor(Long cursoId, Long tutorId);
}
