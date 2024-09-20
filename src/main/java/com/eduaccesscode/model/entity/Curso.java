package com.eduaccesscode.model.entity;

import com.eduaccesscode.model.enums.EstadoCurso;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre_curso", length = 100, nullable = false)
    private String nombreCurso;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", length = 50, nullable = false)
    private EstadoCurso estado;

    @Column(name = "valoracion", nullable = false)
    private int valoracion;

    @OneToMany(mappedBy = "curso")
    private List<Material> materiales;

    @OneToMany(mappedBy = "curso")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "curso")
    private List<CursoTutor> cursoTutores;

    @OneToMany(mappedBy = "curso")
    private List<EstudianteCurso> estudianteCursos;
}

