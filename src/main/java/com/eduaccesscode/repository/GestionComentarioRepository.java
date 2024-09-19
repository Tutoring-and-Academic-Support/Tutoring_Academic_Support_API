package com.eduaccesscode.repository;

import com.eduaccesscode.model.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestionComentarioRepository extends JpaRepository<Comentario, Long> {
}
