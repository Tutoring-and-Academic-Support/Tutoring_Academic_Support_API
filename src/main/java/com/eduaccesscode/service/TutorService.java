package com.eduaccesscode.service;

import com.eduaccesscode.model.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TutorService {
    public void registerTutor (Tutor tutor);
    Tutor findByEmail(String email);

}

