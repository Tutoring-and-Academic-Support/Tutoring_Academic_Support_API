package com.eduaccesscode.service;
import com.eduaccesscode.entity.Estudiante;
import org.springframework.stereotype.Service;

@Service
public interface EstudianteService {
    public Estudiante sesionEstudiante(Estudiante estudiante);

    public Estudiante findById(Integer id);
    public Estudiante update(Integer id, Estudiante updateEstudiante);
}
