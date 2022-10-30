package com.company.B1.service;

import com.company.B1.controller.dto.AccountingAccountsDTO;
import com.company.B1.model.AccountingAccountsEntity;
import com.company.B1.model.DocumentEntity;

import javax.transaction.Transactional;
import java.util.List;

public interface AccountingAccountsService {

    List<AccountingAccountsEntity> findALL();

    @Transactional
    void save(AccountingAccountsDTO accountingAccountsDTO);

    boolean save(AccountingAccountsEntity accountingAccountsEntity);
}
