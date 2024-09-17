package com.hampcode.model.entity;

import com.hampcode.model.enums.TipoMaterial;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "material")
public class Material {

    @Id
    @Column(length = 10, nullable = false)
    private String id; // Clave primaria

    @Column(name = "titulo", length = 100, nullable = false)
    private String titulo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private TipoMaterial tipo; // Enum para tipo de material

    @Column(name = "fecha_subida", nullable = false)
    private Date fechaSubida; // Usa Date para manejar fechas

    @ManyToOne
    @JoinColumn(name = "curso_id", referencedColumnName = "id", nullable = false) // Clave foránea
    private Curso curso;
}



