package com.eduaccesscode.model.repository;

import com.eduaccesscode.model.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Comentario, Long> {
}
