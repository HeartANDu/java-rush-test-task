package com.test.parts.repository;

import com.test.parts.model.Part;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
    List<Part> findByRequired(boolean isRequired);

    Page<Part> findByRequired(boolean isRequired, Pageable pageable);

    Page<Part> findByNameLike(String name, Pageable pageable);
}
