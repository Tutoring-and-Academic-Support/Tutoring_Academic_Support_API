package com.eduaccesscode.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "ciclo", nullable = false)
    private int ciclo;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "contraseña", length = 255, nullable = false)
    private String contraseña;

    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "estudiante")
    private List<EstudianteCurso> estudianteCursos;
}


