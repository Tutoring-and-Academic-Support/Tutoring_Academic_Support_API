package com.hampcode.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "administrador")
public class Administrador {

    @Id
    @Column(length = 10, nullable = false)
    private String id; // Usa id como clave primaria

    @Column(name = "email", length = 255, nullable = false)
    private String email; // Mantén email como atributo

    @Column(name = "nivel", length = 50)
    private String nivel;

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id") // Clave foránea referenciando el id de Usuario
    private Usuario usuario;


}
