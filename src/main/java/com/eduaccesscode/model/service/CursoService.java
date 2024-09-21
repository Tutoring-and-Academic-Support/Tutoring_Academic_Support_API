package com.eduaccesscode.model.service;


import com.upao.tutoring_academic_support_api.domain.Curso;
import com.upao.tutoring_academic_support_api.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    public Curso getCursoById(Integer id) {
        Optional<Curso> curso = cursoRepository.findById(Long.valueOf(id));
        return curso.orElse(null);
    }

    public Curso createCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso updateCurso(Long id, Curso updatedCurso) {
        return cursoRepository.findById(id).map(curso -> {
            curso.setNombre(updatedCurso.getNombre());
            curso.setDescripcion(updatedCurso.getDescripcion());
            return cursoRepository.save(curso);
        }).orElse(null);
    }

    public void deleteCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}

