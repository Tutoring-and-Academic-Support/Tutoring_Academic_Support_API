package com.eduaccesscode.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.upao.tutoring_academic_support_api.domain.CursoEstudiante;

public interface CursoEstudianteRepository extends JpaRepository<CursoEstudiante, Long> {
    CursoEstudiante findByEstudianteIdAndCursoId(Long estudianteId, Long cursoId);
}

