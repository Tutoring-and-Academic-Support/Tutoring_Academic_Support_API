package com.hampcode.model.entity;

import com.hampcode.model.enums.TipoSuscripcion;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "suscripcion")
public class Suscripcion {

    @Id
    @Column(length = 10, nullable = false)
    private String id; // Clave primaria

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false) // Clave foránea
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private TipoSuscripcion tipo;

    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio; // Usa Date para manejar fechas

    @Column(name = "fecha_expiracion", nullable = false)
    private Date fechaExpiracion;
}

