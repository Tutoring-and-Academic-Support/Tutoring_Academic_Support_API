package com.eduaccesscode.model.service;

import com.upao.tutoring_academic_support_api.domain.CursoEstudiante;
import com.upao.tutoring_academic_support_api.domain.Curso;
import com.upao.tutoring_academic_support_api.domain.Estudiante;
import com.upao.tutoring_academic_support_api.repository.CursoEstudianteRepository;
import com.upao.tutoring_academic_support_api.repository.CursoRepository;
import com.upao.tutoring_academic_support_api.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccesoCursoService {

    @Autowired
    private CursoEstudianteRepository cursoEstudianteRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    public boolean verificarAcceso(Long estudianteId, Long cursoId) {
        CursoEstudiante acceso = cursoEstudianteRepository.findByEstudianteIdAndCursoId(estudianteId, cursoId);
        if (acceso != null && acceso.isAccesoPermitido()) {
            return acceso.getRendimiento() >= 0.75; // Ejemplo: el estudiante debe tener un rendimiento mayor o igual a 0.75
        }
        return false;
    }

    public void habilitarAcceso(Long estudianteId, Long cursoId, boolean accesoPermitido) {
        Curso curso = cursoRepository.findById(cursoId).orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        Estudiante estudiante = estudianteRepository.findById(estudianteId).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        CursoEstudiante acceso = new CursoEstudiante();
        acceso.setCurso(curso);
        acceso.setEstudiante(estudiante);
        acceso.setAccesoPermitido(accesoPermitido);
        acceso.setRendimiento(calcularRendimiento(estudiante)); // Método para calcular el rendimiento

        cursoEstudianteRepository.save(acceso);
    }

    public void denegarAcceso(Long estudianteId, Long cursoId) {
        CursoEstudiante acceso = cursoEstudianteRepository.findByEstudianteIdAndCursoId(estudianteId, cursoId);
        if (acceso != null) {
            acceso.setAccesoPermitido(false);
            cursoEstudianteRepository.save(acceso);
        } else {
            throw new RuntimeException("El acceso al curso no existe para el estudiante");
        }
    }

    private double calcularRendimiento(Estudiante estudiante) {
        // Implementar lógica para calcular el rendimiento del estudiante
        return 0.8; // Valor ejemplo
    }
}


