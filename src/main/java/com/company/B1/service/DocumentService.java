package com.company.B1.service;

import com.company.B1.controller.dto.DocumentDTO;
import com.company.B1.model.AccountingAccountsEntity;
import com.company.B1.model.DocumentEntity;

import javax.transaction.Transactional;
import java.util.List;

public interface DocumentService {
    List<DocumentEntity> findALL();

    @Transactional
    void save(DocumentDTO documentDTO);

    boolean save(DocumentEntity documentEntity);
}
