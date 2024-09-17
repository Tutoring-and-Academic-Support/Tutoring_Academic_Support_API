package com.hampcode.model.entity;

import com.hampcode.model.enums.RolUsuario;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(length = 10, nullable = false)
    private String id; // Clave primaria

    @Column(name = "email", length = 255, nullable = false, unique = true) // Email debe ser único y no nulo
    private String email;

    @Column(name = "contraseña", length = 255, nullable = false)
    private String contraseña;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private RolUsuario rol; // Enum para rol de usuario
}

