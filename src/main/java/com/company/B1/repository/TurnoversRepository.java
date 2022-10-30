package com.company.B1.repository;


import com.company.B1.model.OutgoingBalanceEntity;
import com.company.B1.model.TurnoversEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurnoversRepository extends JpaRepository<TurnoversEntity, Long> {
    List<TurnoversEntity> findAll();
    TurnoversEntity save(TurnoversEntity turnoversEntity);
}
