package com.company.B1.service;

import com.company.B1.controller.dto.ClassDTO;
import com.company.B1.model.AccountingAccountsEntity;
import com.company.B1.model.ClassEntity;

import javax.transaction.Transactional;
import java.util.List;

public interface ClassService {
    List<ClassEntity> findALL();

    @Transactional
    void save(ClassDTO classDTO);

    boolean save(ClassEntity classEntity);
}
