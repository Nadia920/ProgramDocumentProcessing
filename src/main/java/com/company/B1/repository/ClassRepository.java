package com.company.B1.repository;


import com.company.B1.model.AccountingAccountsEntity;
import com.company.B1.model.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
    List<ClassEntity> findAll();
    ClassEntity save(ClassEntity classEntity);
}
