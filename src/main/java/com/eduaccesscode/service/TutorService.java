package com.eduaccesscode.service;

import com.eduaccesscode.model.entity.Tutor;
import org.springframework.stereotype.Service;

@Service
public interface TutorService {
    public Tutor sesionTutor(Tutor tutor);

    public Tutor findById(Integer id);
    public Tutor update(Integer id, Tutor updateTutor);
}
