package com.company.B1.service.ServiceImpl;

import com.company.B1.controller.dto.ClassDTO;
import com.company.B1.model.AccountingAccountsEntity;
import com.company.B1.model.ClassEntity;
import com.company.B1.repository.AccountingAccountsRepository;
import com.company.B1.repository.ClassRepository;
import com.company.B1.service.ClassService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    private final static Logger LOGGER = LogManager.getLogger();

    @Autowired
    private ClassRepository classRepository;

    @Override
    public List<ClassEntity> findALL() {
        return (classRepository.findAll());
    }

    @Transactional
    @Override
    public void save(ClassDTO classDTO) {
        ClassEntity classEntity = new ClassEntity(classDTO.getClassName(), classDTO.getDocumentEntity());
        ClassRepository.save(classEntity);
    }

    @Override
    public boolean save(ClassEntity obj) {
        ClassEntity classes = ClassRepository.save(obj);
        if (classes == null) {
            return false;
        } else {
            return true;
        }
    }
}
