package com.upao.tutoring_academic_support_api.service;

import com.upao.tutoring_academic_support_api.domain.Material;
import com.upao.tutoring_academic_support_api.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    public List<Material> getAllMaterials() {
        return materialRepository.findAll();
    }

    public Optional<Material> getMaterialById(Long id) {
        return materialRepository.findById(id);
    }

    public Material createMaterial(Material material) {
        return materialRepository.save(material);
    }

    public void deleteMaterial(Long id) {
        materialRepository.deleteById(id);
    }
}

