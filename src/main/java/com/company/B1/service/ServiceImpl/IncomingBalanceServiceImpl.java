package com.company.B1.service.ServiceImpl;

import com.company.B1.controller.dto.AccountingAccountsDTO;
import com.company.B1.controller.dto.IncomingBalanceDTO;
import com.company.B1.model.AccountingAccountsEntity;
import com.company.B1.model.IncomingBalanceEntity;
import com.company.B1.repository.AccountingAccountsRepository;
import com.company.B1.repository.IncomingBalanceRepository;
import com.company.B1.service.IncomingBalanceService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IncomingBalanceServiceImpl implements IncomingBalanceService {

    private final static Logger LOGGER = LogManager.getLogger();

    @Autowired
    private IncomingBalanceRepository incomingBalanceRepository;

    @Override
    public List<IncomingBalanceEntity> findALL() {
        return (incomingBalanceRepository.findAll());
    }

    @Transactional
    @Override
    public void save(IncomingBalanceDTO incomingBalanceDTO) {
        IncomingBalanceEntity incomingBalanceEntity = new AccountingAccountsEntity(incomingBalanceDTO.getAsset(), incomingBalanceDTO.getPassive(), incomingBalanceDTO.getClassEntity());
        IncomingBalanceRepository.save(incomingBalanceEntity);
    }

    @Override
    public boolean save(IncomingBalanceEntity obj) {
        IncomingBalanceEntity incomingBalance = incomingBalanceRepository.save(obj);
        if (incomingBalance == null) {
            return false;
        } else {
            return true;
        }
    }
}

