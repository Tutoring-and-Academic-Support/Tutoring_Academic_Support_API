package com.eduaccesscode.controller;

import com.eduaccesscode.service.AccesoCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/acceso-cursos")
@CrossOrigin(origins = "http://localhost:4200")
public class AccesoCursoController {

    @Autowired
    private AccesoCursoService accesoCursoService;

    @GetMapping("/verificar/{estudianteId}/{cursoId}")
    public ResponseEntity<Boolean> verificarAcceso(@PathVariable Long estudianteId, @PathVariable Long cursoId) {
        boolean acceso = accesoCursoService.verificarAcceso(estudianteId, cursoId);
        return ResponseEntity.ok(acceso);
    }

    @PostMapping("/habilitar")
    public ResponseEntity<Void> habilitarAcceso(@RequestParam Long estudianteId, @RequestParam Long cursoId, @RequestParam boolean accesoPermitido) {
        accesoCursoService.habilitarAcceso(estudianteId, cursoId, accesoPermitido);
        return ResponseEntity.ok().build();
    }


}

