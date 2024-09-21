package com.eduaccesscode.repository;

import com.eduaccesscode.entity.EstudianteCurso;
import com.eduaccesscode.entity.EstudianteCursoPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteCursoRepository extends JpaRepository<EstudianteCurso, EstudianteCursoPK> {
    boolean existsByEstudianteIdAndCursoId(Long estudianteId, Long cursoId);
}
