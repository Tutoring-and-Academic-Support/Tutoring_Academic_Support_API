package com.hampcode.model.entity;

import com.hampcode.model.enums.EstadoProgreso;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "progreso")
public class Progreso {

    @Id
    @Column(length = 10, nullable = false)
    private String id; // Usa id como clave primaria

    @ManyToOne
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id", nullable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "curso_id", referencedColumnName = "id", nullable = false)
    private Curso curso;

    @Column(nullable = true)
    private Float porcentaje;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private EstadoProgreso estado; // Elimina la duplicidad de "estado"
}
