package com.hampcode.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 10, nullable = false)
    private String id;

    @Column(name = "texto", columnDefinition = "TEXT", nullable = false)
    private String texto;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "email_estudiante", referencedColumnName = "email", nullable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_material", referencedColumnName = "id", nullable = false)
    private Material material;


}

