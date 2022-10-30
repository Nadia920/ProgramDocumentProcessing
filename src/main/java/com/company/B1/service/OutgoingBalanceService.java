package com.company.B1.service;

import com.company.B1.controller.dto.OutgoingBalanceDTO;
import com.company.B1.model.AccountingAccountsEntity;
import com.company.B1.model.IncomingBalanceEntity;
import com.company.B1.model.OutgoingBalanceEntity;

import javax.transaction.Transactional;
import java.util.List;

public interface OutgoingBalanceService {
    List<OutgoingBalanceEntity> findALL();

    @Transactional
    void save(OutgoingBalanceDTO outgoingBalanceDTO);

    boolean save(OutgoingBalanceEntity outgoingBalanceEntity);
}
