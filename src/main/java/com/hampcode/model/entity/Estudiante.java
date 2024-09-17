package com.hampcode.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @Column(length = 10, nullable = false)
    private String id; // Usa id como clave primaria

    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String email; // Mantén email como atributo

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "matricula", length = 50, nullable = false)
    private String matricula;

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id") // Clave foránea referenciando el id de Usuario
    private Usuario usuario;
}

