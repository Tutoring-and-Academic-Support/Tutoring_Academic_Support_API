package com.hampcode.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "comentario")
public class Comentario {

    @Id
    @Column(name = "id", length = 10, nullable = false)
    private String id;

    @Column(name = "texto", columnDefinition = "TEXT", nullable = false)
    private String texto;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id", nullable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_material", referencedColumnName = "id", nullable = false)
    private Material material;


}

