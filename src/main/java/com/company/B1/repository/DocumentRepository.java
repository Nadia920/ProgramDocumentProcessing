package com.company.B1.repository;


import com.company.B1.model.ClassEntity;
import com.company.B1.model.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<DocumentEntity, Long> {
    List<DocumentEntity> findAll();
    DocumentEntity save(DocumentEntity documentEntity);
}
