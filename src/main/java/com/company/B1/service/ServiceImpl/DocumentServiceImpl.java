package com.company.B1.service.ServiceImpl;

import com.company.B1.controller.dto.AccountingAccountsDTO;
import com.company.B1.controller.dto.DocumentDTO;
import com.company.B1.model.AccountingAccountsEntity;
import com.company.B1.model.DocumentEntity;
import com.company.B1.repository.AccountingAccountsRepository;
import com.company.B1.repository.DocumentRepository;
import com.company.B1.service.DocumentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final static Logger LOGGER = LogManager.getLogger();

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public List<DocumentEntity> findALL() {
        return (documentRepository.findAll());
    }

    @Transactional
    @Override
    public void save(DocumentDTO documentDTO) {
        DocumentEntity documentEntity = new DocumentEntity(documentDTO.getNameOrganization(), documentDTO.getDocumentName(), documentDTO.getDocumentDescription(), documentDTO.getDateOfSubmission());
        DocumentRepository.save(documentEntity);
    }

    @Override
    public boolean save(DocumentEntity obj) {
        DocumentEntity document = documentRepository.save(obj);
        if (document == null) {
            return false;
        } else {
            return true;
        }
    }
}
