package com.eduaccesscode.repository;

import com.eduaccesscode.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
    boolean existsEstudianteByEmail(String email);
    Estudiante findByEmailAndContraseña(String email, String contraseña);

}
