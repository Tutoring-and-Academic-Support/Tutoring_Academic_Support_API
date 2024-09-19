package com.eduaccesscode.service.implem;

import com.eduaccesscode.model.entity.Estudiante;
import com.eduaccesscode.repository.EstudianteRepository;
import com.eduaccesscode.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.eduaccesscode.model.entity.Estudiante;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

@Service
public class EstudianteServiceImpl implements EstudianteService {
    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public Estudiante findById(Integer id) {

        return estudianteRepository.findById(id).orElse(null);
    }

    @Override
    public Estudiante sesionEstudiante(Estudiante estudiante) {
        Estudiante estudianteExistente = estudianteRepository.findByEmailAndContraseña(estudiante.getEmail(), estudiante.getContraseña());
        if (estudianteExistente != null) {
            return estudianteExistente;
        } else{
            throw new RuntimeException("Estudiante no encontrado");
        }
    }

    @Override
    public Estudiante update(Integer id, Estudiante updateEstudiante) {
        Estudiante estudianteActual = estudianteRepository.findById(id).orElse(null);
        estudianteActual.setNombre(updateEstudiante.getNombre());

        return estudianteRepository.save(estudianteActual);
    }

}
