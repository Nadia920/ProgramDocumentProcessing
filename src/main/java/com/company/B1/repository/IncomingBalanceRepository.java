package com.company.B1.repository;


import com.company.B1.model.DocumentEntity;
import com.company.B1.model.IncomingBalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomingBalanceRepository extends JpaRepository<IncomingBalanceEntity, Long> {
    List<IncomingBalanceEntity> findAll();
    IncomingBalanceEntity save(IncomingBalanceEntity incomingBalanceEntity);
}
