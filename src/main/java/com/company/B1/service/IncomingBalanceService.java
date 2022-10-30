package com.company.B1.service;

import com.company.B1.controller.dto.IncomingBalanceDTO;
import com.company.B1.model.AccountingAccountsEntity;
import com.company.B1.model.DocumentEntity;
import com.company.B1.model.IncomingBalanceEntity;

import javax.transaction.Transactional;
import java.util.List;

public interface IncomingBalanceService {
    List<IncomingBalanceEntity> findALL();

    @Transactional
    void save(IncomingBalanceDTO incomingBalanceDTO);

    boolean save(IncomingBalanceEntity incomingBalanceEntity);
}
