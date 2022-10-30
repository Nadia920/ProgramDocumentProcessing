package com.company.B1.service;

import com.company.B1.controller.dto.TurnoversDTO;
import com.company.B1.model.AccountingAccountsEntity;
import com.company.B1.model.OutgoingBalanceEntity;
import com.company.B1.model.TurnoversEntity;

import javax.transaction.Transactional;
import java.util.List;

public interface TurnoversService {
    List<TurnoversEntity> findALL();

    @Transactional
    void save(TurnoversDTO turnoversDTO);

    boolean save(TurnoversEntity turnoversEntity);
}
