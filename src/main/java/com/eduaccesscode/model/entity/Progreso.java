package com.eduaccesscode.model.entity;

import com.eduaccesscode.model.enums.EstadoProgreso;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "progreso")
public class Progreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_progreso", nullable = false)
    private Long idProgreso;

    @Column(name = "porcentaje", nullable = false)
    private double porcentaje;

    @Column(name = "fecha_ultimo_acceso", nullable = false)
    private Date fechaUltimoAcceso;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", length = 50, nullable = false)
    private EstadoProgreso estado;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_estudiante", referencedColumnName = "id_estudiante"),
            @JoinColumn(name = "id_curso", referencedColumnName = "id_curso")
    })
    private EstudianteCurso estudianteCurso;
}
