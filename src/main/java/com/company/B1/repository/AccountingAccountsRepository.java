package com.company.B1.repository;

import com.company.B1.model.AccountingAccountsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountingAccountsRepository extends JpaRepository<AccountingAccountsEntity, Long> {
    List<AccountingAccountsEntity> findAll();
    AccountingAccountsEntity save(AccountingAccountsEntity accountingAccountsEntity);
}
