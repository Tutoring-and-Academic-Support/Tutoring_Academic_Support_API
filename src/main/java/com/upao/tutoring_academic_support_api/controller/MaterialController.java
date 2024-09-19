package com.upao.tutoring_academic_support_api.controller;

import com.upao.tutoring_academic_support_api.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/materiales")
public class MaterialController {

    @Autowired
    private MaterialRepository materialRepository;

    @PostMapping
    public ResponseEntity<String> uploadMaterial(@RequestBody MaterialRequest materialRequest) {
        // Validar los datos de entrada
        if (materialRequest.getCourseId() == null || materialRequest.getMaterialType() == null || materialRequest.getMaterialUrl() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Todos los campos son obligatorios");
        }

        // Crear un nuevo Material
        Material material = new Material(
                materialRequest.getCourseId(),
                materialRequest.getMaterialType(),
                materialRequest.getMaterialUrl()
        );

        // Guardar el material en la base de datos
        materialRepository.save(material);

        // Retornar respuesta exitosa
        return ResponseEntity.ok("Material subido correctamente");
    }
}

