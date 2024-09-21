package com.eduaccesscode.model.repository;

import com.upao.tutoring_academic_support_api.domain.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
}

