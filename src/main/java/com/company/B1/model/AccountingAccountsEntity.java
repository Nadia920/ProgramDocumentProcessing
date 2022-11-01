package com.company.B1.model;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Data
@DynamicUpdate
@Table(name = "accounting_accounts")
public class AccountingAccountsEntity extends BaseEntity{
    @NotNull
    @Column(name = "account_number")
    private Integer accountNumber;
    @NotNull
    @Column(name = "сomponents_account")
    private String сomponentsAccount;
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "class_Id")
    private Long classId;

    public AccountingAccountsEntity(Integer accountNumber, String сomponentsAccount, ClassEntity classEntity) {}

    public AccountingAccountsEntity(Double asset, Double passive, ClassEntity classEntity) {}
}
