package com.hampcode.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tutor")
public class Tutor {

    @Id
    @Column(name = "id", length = 10, nullable = false)
    private String id;

    @Column(name = "email", length = 255, nullable = false)
    private String email;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "departamento", length = 100)
    private String departamento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_email", referencedColumnName = "email")
    private Usuario usuario;
}
