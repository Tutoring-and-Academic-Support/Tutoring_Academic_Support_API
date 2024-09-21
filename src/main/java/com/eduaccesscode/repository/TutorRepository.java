package com.eduaccesscode.repository;

import com.eduaccesscode.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<Tutor, Integer> {
    boolean existsTutorByEmail(String email);
    Tutor findTutorByEmailAndContraseña(String email, String contraseña);
}
