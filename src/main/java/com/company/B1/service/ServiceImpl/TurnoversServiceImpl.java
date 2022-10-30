package com.company.B1.service.ServiceImpl;

import com.company.B1.controller.dto.AccountingAccountsDTO;
import com.company.B1.controller.dto.TurnoversDTO;
import com.company.B1.model.AccountingAccountsEntity;
import com.company.B1.model.TurnoversEntity;
import com.company.B1.repository.AccountingAccountsRepository;
import com.company.B1.repository.TurnoversRepository;
import com.company.B1.service.TurnoversService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TurnoversServiceImpl implements TurnoversService {

    private final static Logger LOGGER = LogManager.getLogger();

    @Autowired
    private TurnoversRepository turnoversRepository;

    @Override
    public List<TurnoversEntity> findALL() {
        return (turnoversRepository.findAll());
    }

    @Transactional
    @Override
    public void save(TurnoversDTO turnoversDTO) {
        TurnoversEntity turnoversEntity = new TurnoversEntity(turnoversDTO.getDebit(), turnoversDTO.getCredit(), turnoversDTO.getClassEntity());
        TurnoversRepository.save(turnoversEntity);
    }

    @Override
    public boolean save(TurnoversEntity obj) {
        TurnoversEntity turnovers = turnoversRepository.save(obj);
        if (turnovers == null) {
            return false;
        } else {
            return true;
        }
    }
}
