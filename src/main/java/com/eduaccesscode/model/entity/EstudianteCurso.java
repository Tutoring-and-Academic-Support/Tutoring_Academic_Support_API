package com.eduaccesscode.model.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "estudiante_curso")
public class EstudianteCurso {

    @EmbeddedId
    private EstudianteCursoPK id;

    @ManyToOne
    @MapsId("idEstudiante")  // Esto mapea el campo 'idEstudiante' de la clave compuesta
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id")
    private Estudiante estudiante;

    @ManyToOne
    @MapsId("idCurso")
    @JoinColumn(name = "id_curso", referencedColumnName = "id")
    private Curso curso;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

}


