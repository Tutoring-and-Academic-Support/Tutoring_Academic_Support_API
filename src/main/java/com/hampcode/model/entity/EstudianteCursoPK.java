package com.hampcode.model.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class EstudianteCursoPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "email_estudiante", referencedColumnName = "email", nullable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_curso", referencedColumnName = "id", nullable = false)
    private Curso curso;
}


