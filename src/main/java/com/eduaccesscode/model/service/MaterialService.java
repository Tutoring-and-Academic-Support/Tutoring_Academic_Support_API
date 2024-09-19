package com.eduaccesscode.model.service;

import com.upao.tutoring_academic_support_api.TipoMaterial;
import com.upao.tutoring_academic_support_api.domain.Material;
import com.upao.tutoring_academic_support_api.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    public List<Material> getAllMaterials() {
        return materialRepository.findAll();
    }

    public Material getMaterialById(String id) {
        Optional<Material> material = materialRepository.findById(Long.valueOf(id));
        return material.orElse(null);
    }

    private boolean isValidFileExtension(String title, TipoMaterial tipo) {
        String extension = StringUtils.getFilenameExtension(title).toLowerCase();

        switch (tipo) {
            case DOCUMENTO:
                return extension.matches("pdf|doc|docx|xls|xlsx|ppt|pptx");
            case VIDEO:
                return extension.matches("mp4|avi|mov|mkv");
            case AUDIO:
                return extension.matches("mp3|wav|aac");
            case LINK:
                return extension.matches("http|https");
            default:
                return false;
        }
    }

    public Material createMaterial(Material material) {
        if (!isValidFileExtension(material.getTitulo(), material.getTipo())) {
            throw new IllegalArgumentException("Formato de archivo no válido");
        }
        return materialRepository.save(material);
    }

    public Material updateMaterial(String id, Material updatedMaterial) {
        if (!isValidFileExtension(updatedMaterial.getTitulo(), updatedMaterial.getTipo())) {
            throw new IllegalArgumentException("Formato de archivo no válido");
        }
        return materialRepository.findById(Long.valueOf(id)).map(material -> {
            material.setTitulo(updatedMaterial.getTitulo());
            material.setTipo(updatedMaterial.getTipo());
            material.setFechaSubida(updatedMaterial.getFechaSubida());
            return materialRepository.save(material);
        }).orElse(null);
    }

    public void deleteMaterial(String id) {
        materialRepository.deleteById(Long.valueOf(id));
    }
}

