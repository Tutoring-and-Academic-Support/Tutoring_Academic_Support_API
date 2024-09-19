package com.eduaccesscode.controller;

import com.eduaccesscode.service.ModeracionComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutores/comentarios")
public class GestionarComentarioController {

    @Autowired
    private ModeracionComentarioService moderacionComentarioService;

    @DeleteMapping("/{comment_id}")
    public ResponseEntity<String> eliminarComentario(@PathVariable Long comment_id, @RequestParam Long tutor_id) {
        try {
            String response = moderacionComentarioService.eliminarComentario(comment_id, tutor_id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}


