package com.company.B1.service.ServiceImpl;

import com.company.B1.controller.dto.AccountingAccountsDTO;
import com.company.B1.model.AccountingAccountsEntity;
import com.company.B1.repository.AccountingAccountsRepository;
import com.company.B1.service.AccountingAccountsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountingAccountsServiceImpl implements AccountingAccountsService {

    private final static Logger LOGGER = LogManager.getLogger();

    @Autowired
    private AccountingAccountsRepository accountingAccountsRepository;

    @Override
    public List<AccountingAccountsEntity> findALL() {
        return (accountingAccountsRepository.findAll());
    }

    @Transactional
    @Override
    public void save(AccountingAccountsDTO accountingAccountsDTO) {
        AccountingAccountsEntity accountingAccountsEntity = new AccountingAccountsEntity(accountingAccountsDTO.getAccountNumber(), accountingAccountsDTO.getСomponentsAccount(), accountingAccountsDTO.getClassEntity());
        accountingAccountsRepository.save(accountingAccountsEntity);
    }

    @Override
    public boolean save(AccountingAccountsEntity obj) {
        AccountingAccountsEntity accountingAccounts = accountingAccountsRepository.save(obj);
        if (accountingAccounts == null) {
            return false;
        } else {
            return true;
        }
    }
}
