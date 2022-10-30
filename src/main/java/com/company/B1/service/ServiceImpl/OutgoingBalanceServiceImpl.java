package com.company.B1.service.ServiceImpl;

import com.company.B1.controller.dto.AccountingAccountsDTO;
import com.company.B1.controller.dto.OutgoingBalanceDTO;
import com.company.B1.model.AccountingAccountsEntity;
import com.company.B1.model.OutgoingBalanceEntity;
import com.company.B1.repository.AccountingAccountsRepository;
import com.company.B1.repository.OutgoingBalanceRepository;
import com.company.B1.service.OutgoingBalanceService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OutgoingBalanceServiceImpl implements OutgoingBalanceService {

    private final static Logger LOGGER = LogManager.getLogger();

    @Autowired
    private OutgoingBalanceRepository outgoingBalanceRepository;

    @Override
    public List<OutgoingBalanceEntity> findALL() {
        return (outgoingBalanceRepository.findAll());
    }

    @Transactional
    @Override
    public void save(OutgoingBalanceDTO outgoingBalanceDTO) {
        OutgoingBalanceEntity outgoingBalanceEntity = new OutgoingBalanceEntity(outgoingBalanceDTO.getAsset(), outgoingBalanceDTO.getPassive(), outgoingBalanceDTO.getClassEntity());
        OutgoingBalanceRepository.save(outgoingBalanceEntity);
    }

    @Override
    public boolean save(OutgoingBalanceEntity obj) {
        OutgoingBalanceEntity outgoingBalance = outgoingBalanceRepository.save(obj);
        if (outgoingBalance == null) {
            return false;
        } else {
            return true;
        }
    }
}
