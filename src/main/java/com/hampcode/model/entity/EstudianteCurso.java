package com.hampcode.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "estudiante_curso")
public class EstudianteCurso {

    @EmbeddedId
    private EstudianteCursoPK id;

    @ManyToOne
    @MapsId("estudiante") // Mapea el campo 'estudiante' de la clave compuesta
    @JoinColumn(name = "id_estudiante", referencedColumnName = "email", nullable = false)
    private Estudiante estudiante;

    @ManyToOne
    @MapsId("curso") // Mapea el campo 'curso' de la clave compuesta
    @JoinColumn(name = "id_curso", referencedColumnName = "id", nullable = false)
    private Curso curso;


}

