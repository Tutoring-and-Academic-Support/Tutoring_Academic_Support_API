package com.upao.tutoring_academic_support_api.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter

@Entity
@Table(name = "materials")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Material> materials;
}
