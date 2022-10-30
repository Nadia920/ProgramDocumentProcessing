package com.company.B1.repository;


import com.company.B1.model.IncomingBalanceEntity;
import com.company.B1.model.OutgoingBalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutgoingBalanceRepository extends JpaRepository<OutgoingBalanceEntity, Long> {
    List<OutgoingBalanceEntity> findAll();
    OutgoingBalanceEntity save(OutgoingBalanceEntity outgoingBalanceEntity);
}
