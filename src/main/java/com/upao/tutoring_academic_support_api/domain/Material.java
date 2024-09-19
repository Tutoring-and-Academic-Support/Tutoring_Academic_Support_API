package com.upao.tutoring_academic_support_api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.upao.tutoring_academic_support_api.TipoMaterial;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Material {

    @Id
    @Column(length = 10, nullable = false)
    private String id; // Clave primaria, longitud 10

    @Column(name = "titulo", length = 100, nullable = false)
    private String titulo; // Título del material

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private TipoMaterial tipo; // Tipo de material (enum)

    @Column(name = "fecha_subida", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSubida; // Fecha de subida del material

    @ManyToOne
    @JoinColumn(name = "curso_id", referencedColumnName = "id", nullable = false) // Relación con Curso
    @JsonBackReference
    private Curso curso; // Clave foránea a la entidad Curso

    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public TipoMaterial getTipo() {
        return tipo;
    }

    public void setTipo(TipoMaterial tipo) {
        this.tipo = tipo;
    }

    public Date getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(Date fechaSubida) {
        this.fechaSubida = fechaSubida;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
