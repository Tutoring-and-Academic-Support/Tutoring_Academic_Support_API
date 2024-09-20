package com.eduaccesscode.service.implem;

import com.eduaccesscode.model.entity.Tutor;
import com.eduaccesscode.repository.TutorRepository;
import com.eduaccesscode.service.TutorService;

public class TutorServiceImpl implements TutorService {

    private TutorRepository tutorRepository;

    @Override
    public void registerTutor(Tutor tutor) {
        tutorRepository.save(tutor);

    }

    @Override
    public Tutor findByEmail(String email) {
        return null;
    }




}
